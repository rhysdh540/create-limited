package dev.rdh.createlimited.fabric;

import net.minecraftforge.api.ModLoadingContext;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

import dev.rdh.createlimited.CreateLimited;

import net.fabricmc.loader.api.FabricLoader;

public class UtilImpl {

	public static void registerConfig(ModConfig.Type type, IConfigSpec<?> spec) {
		#if PRE_CURRENT_MC_1_19_2
		ModLoadingContext.registerConfig(CreateLimited.ID, type, spec);
		#elif POST_CURRENT_MC_1_20_1
		ForgeConfigRegistry.INSTANCE.register(CreateUnlimited.ID, type, spec);
		#endif
	}

	public static String getVersion() {
		return FabricLoader.getInstance()
			.getModContainer(CreateLimited.ID)
			.orElseThrow()
			.getMetadata()
			.getVersion()
			.getFriendlyString();
	}

	public static boolean isModLoaded(String id) {
		return FabricLoader.getInstance().isModLoaded(id);
	}
}
