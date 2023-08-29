package net.examplegroup.examplemod.util.fabric;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.examplegroup.examplemod.ExampleMod;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.commands.CommandSourceStack;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

#if PRE_CURRENT_MC_1_19_2
import net.minecraftforge.api.ModLoadingContext;
#elif POST_CURRENT_MC_1_20_1
import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
#endif

import java.nio.file.Path;

public class UtilsImpl {
	public static String getVersion() {
		return FabricLoader.getInstance()
				.getModContainer(ExampleMod.ID)
				.orElseThrow()
				.getMetadata()
				.getVersion()
				.getFriendlyString();
	}

	public static boolean isDevEnv() {
		return FabricLoader.getInstance().isDevelopmentEnvironment();
	}

	public static Path configDir() {
		return FabricLoader.getInstance().getConfigDir();
	}

	public static void registerCommand(LiteralArgumentBuilder<CommandSourceStack> command) {
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated, selection) -> dispatcher.register(command));
	}

	public static void registerConfig(ModConfig.Type type, IConfigSpec<?> spec) {
		#if PRE_CURRENT_MC_1_19_2
		ModLoadingContext.registerConfig(ExampleMod.ID, type, spec);
		#elif POST_CURRENT_MC_1_20_1
		ForgeConfigRegistry.INSTANCE.register(ExampleMod.ID, type, spec);
		#endif
	}
}
