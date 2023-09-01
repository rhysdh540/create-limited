package dev.rdh.ntl.fabric;

import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

import dev.rdh.ntl.CreateNTL;

import net.fabricmc.loader.api.FabricLoader;

#if PRE_CURRENT_MC_1_19_2
import net.minecraftforge.api.ModLoadingContext;
#elif POST_CURRENT_MC_1_20_1
import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
#endif

public class UtilImpl {

	public static void registerConfig(ModConfig.Type type, IConfigSpec<?> spec) {
		#if PRE_CURRENT_MC_1_19_2
		ModLoadingContext.registerConfig(CreateNTL.ID, type, spec);
		#elif POST_CURRENT_MC_1_20_1
		ForgeConfigRegistry.INSTANCE.register(CreateLimited.ID, type, spec);
		#endif
	}

	public static String getVersion() {
		return FabricLoader.getInstance()
			.getModContainer(CreateNTL.ID)
			.orElseThrow()
			.getMetadata()
			.getVersion()
			.getFriendlyString();
	}

	public static boolean isModLoaded(String id) {
		return FabricLoader.getInstance().isModLoaded(id);
	}
}
