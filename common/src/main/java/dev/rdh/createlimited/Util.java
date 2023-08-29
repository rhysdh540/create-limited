package dev.rdh.createlimited;

import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

import dev.architectury.injectables.annotations.ExpectPlatform;

public class Util {

	@ExpectPlatform
	public static String getVersion() {
		throw new AssertionError();
	}

	@ExpectPlatform
	public static void registerConfig(ModConfig.Type type, IConfigSpec<?> spec) {
		throw new AssertionError();
	}

	@ExpectPlatform
	public static boolean isModLoaded(String id) {
		throw new AssertionError();
	}
}
