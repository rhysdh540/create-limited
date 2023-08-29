package dev.rdh.createlimited.mixin;

import com.simibubi.create.infrastructure.config.CTrains;

import dev.rdh.createlimited.Util;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = CTrains.class, remap = false, priority = 0)
public class CTrainsMixin {
	@ModifyConstant(method = "<init>", constant = @Constant(intValue = 128))
	private static int something(int original) {
		if(Util.isModLoaded("createunlimited"))
			return original;
		return Integer.MAX_VALUE;
	}
}
