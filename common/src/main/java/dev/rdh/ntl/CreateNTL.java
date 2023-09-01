package dev.rdh.ntl;

import dev.rdh.ntl.config.NTLConfigs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateNTL {
	public static final String ID = "ntl";
	public static final String NAME = "Create: No Train Limits";
	public static final String VERSION = Util.getVersion().split("-")[0];
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
	public static final boolean unlimitedInstalled = Util.isModLoaded("createunlimited");

    public static void init() {
		LOGGER.info("train nerds mod v{} incoming", VERSION);
		if(unlimitedInstalled) {
			LOGGER.warn("Create Unlimited is loaded, disabling NTL");
		} else NTLConfigs.register();
	}
}
