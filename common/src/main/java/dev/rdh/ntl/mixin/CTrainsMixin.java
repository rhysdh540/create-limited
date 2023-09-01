package dev.rdh.ntl.mixin;

import com.simibubi.create.infrastructure.config.CTrains;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = CTrains.class, remap = false)
public class CTrainsMixin {
	@ModifyConstant(method = "<init>", constant = @Constant(intValue = 128))
	private static int bigCurves(int original) {
		return Integer.MAX_VALUE;
	}
}
