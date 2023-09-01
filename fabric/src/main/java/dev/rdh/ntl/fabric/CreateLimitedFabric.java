package dev.rdh.ntl.fabric;

import dev.rdh.ntl.CreateNTL;

import dev.rdh.ntl.config.NTLConfigs;

#if PRE_CURRENT_MC_1_19_2
import net.minecraftforge.api.fml.event.config.ModConfigEvents;
#elif POST_CURRENT_MC_1_20_1
import fuzs.forgeconfigapiport.api.config.v2.ModConfigEvents;
#endif
import net.fabricmc.api.ModInitializer;

public class CreateLimitedFabric implements ModInitializer {
    @Override
    public void onInitialize() {
		ModConfigEvents.loading(CreateNTL.ID).register(NTLConfigs::onLoad);
		ModConfigEvents.reloading(CreateNTL.ID).register(NTLConfigs::onReload);
        CreateNTL.init();
    }
}
