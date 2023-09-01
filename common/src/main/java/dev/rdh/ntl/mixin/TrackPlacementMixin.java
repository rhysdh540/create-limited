package dev.rdh.ntl.mixin;

import com.simibubi.create.content.trains.track.TrackPlacement;
import dev.rdh.ntl.config.NTLConfigs;

import net.minecraft.util.Mth;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(value = TrackPlacement.class, priority = 1001)
public class TrackPlacementMixin {
	@ModifyConstant(method = "tryConnect", constant = @Constant(doubleValue = 7, ordinal = 0), remap = false)
	private static double setMinTurnRadius(double original) {
		return NTLConfigs.server().minTurnSize.get();
	}

	@ModifyConstant(method = "tryConnect", constant = @Constant(doubleValue = 3.25, ordinal = 0), remap = false)
	private static double setMin45TurnRadius(double original) {
		return NTLConfigs.server().min45TurnSize.get();
	}

	@Redirect(
		method = "tryConnect",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/util/Mth;equal(DD)Z",
			ordinal = 0,
			slice = "getCenterOf"
		),
		slice = @Slice(
			from = @At(value = "INVOKE", target = "Lcom/simibubi/create/foundation/utility/VecHelper;getCenterOf(Lnet/minecraft/core/Vec3i;)Lnet/minecraft/world/phys/Vec3;", ordinal = 0),
			id = "getCenterOf"
		)
	)
	private static boolean gimmeSlopeSTurn3(double x, double y) {
		return NTLConfigs.server().allowSlopeSTurns.get() || Mth.equal(x, y);
	}
}
