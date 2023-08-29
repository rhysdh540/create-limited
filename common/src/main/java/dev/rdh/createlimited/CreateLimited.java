package dev.rdh.createlimited;

import dev.rdh.createlimited.config.CLConfigs;

import net.minecraft.resources.ResourceLocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateLimited {
	public static final String ID = "createlimited";
	public static final String NAME = "Create Limited";
	public static final String VERSION = Util.getVersion().split("-")[0];
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    public static void init() {
		LOGGER.info("train nerds mod v{} incoming", VERSION);
		CLConfigs.register();
	}

	public static ResourceLocation asResource(String path) {
		return new ResourceLocation(ID, path);
	}
}
