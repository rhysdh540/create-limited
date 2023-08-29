package dev.rdh.createlimited.mixin;

import com.simibubi.create.content.trains.track.TrackPlacement;

import dev.rdh.createlimited.config.CLConfigs;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = TrackPlacement.class, remap = false, priority = 1001)
public class TrackPlacementMixin {
	@ModifyConstant(method = "tryConnect", constant = @Constant(doubleValue = 7, ordinal = 0))
	private static double setMinTurnRadius(double original) {
		return CLConfigs.server().minTurnSize.get();
	}

	@ModifyConstant(method = "tryConnect", constant = @Constant(doubleValue = 3.25, ordinal = 0))
	private static double setMin45TurnRadius(double original) {
		return CLConfigs.server().min45TurnSize.get();
	}
}
