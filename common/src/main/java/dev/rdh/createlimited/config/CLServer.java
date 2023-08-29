package dev.rdh.createlimited.config;

import com.simibubi.create.foundation.config.ConfigBase;

public class CLServer extends ConfigBase {
	@Override
	public String getName() {
		return "server";
	}

	public final ConfigFloat minTurnSize = f(7, 7, "minTurnSize", "Minimum radius for placing 90 degree turns");
	public final ConfigFloat min45TurnSize = f(3.25f, 3.25f, "min45TurnSize", "Minimum radius for placing 45 degree turns");
}
