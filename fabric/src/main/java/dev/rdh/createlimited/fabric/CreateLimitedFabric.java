package dev.rdh.createlimited.fabric;

import dev.rdh.createlimited.CreateLimited;

import dev.rdh.createlimited.config.CLConfigs;

#if PRE_CURRENT_MC_1_19_2
import net.minecraftforge.api.fml.event.config.ModConfigEvents;
#elif POST_CURRENT_MC_1_20_1
import fuzs.forgeconfigapiport.api.config.v2.ModConfigEvents;
#endif
import net.fabricmc.api.ModInitializer;

public class CreateLimitedFabric implements ModInitializer {
    @Override
    public void onInitialize() {
		ModConfigEvents.loading(CreateLimited.ID).register(CLConfigs::onLoad);
		ModConfigEvents.reloading(CreateLimited.ID).register(CLConfigs::onReload);
        CreateLimited.init();
    }
}
