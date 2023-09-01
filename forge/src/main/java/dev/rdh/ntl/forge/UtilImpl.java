package dev.rdh.ntl.forge;

import dev.rdh.ntl.CreateNTL;

import net.minecraftforge.common.util.MavenVersionStringHelper;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.forgespi.language.IModInfo;

import java.util.List;

public class UtilImpl {

	public static void registerConfig(ModConfig.Type type, IConfigSpec<?> spec) {
		ModLoadingContext.get().registerConfig(type, spec);
	}

	public static String getVersion() {
		String versionString = "UNKNOWN";

		List<IModInfo> infoList = ModList.get().getModFileById(CreateNTL.ID).getMods();
		if (infoList.size() > 1) {
			CreateNTL.LOGGER.error("Multiple mods for ID: " + CreateNTL.ID);
		}
		for (IModInfo info : infoList) {
			if (info.getModId().equals(CreateNTL.ID)) {
				versionString = MavenVersionStringHelper.artifactVersionToString(info.getVersion());
				break;
			}
		}
		return versionString;
	}

	public static boolean isModLoaded(String id) {
		return ModList.get().isLoaded(id);
	}
}
