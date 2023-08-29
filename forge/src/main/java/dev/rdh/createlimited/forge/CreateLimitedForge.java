package dev.rdh.createlimited.forge;

import dev.rdh.createlimited.CreateLimited;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CreateLimited.ID)
public class CreateLimitedForge {

    public CreateLimitedForge() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get()
			.getModEventBus();
		IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

		forgeEventBus.register(Events.ClientModBusEvents.class);
		modEventBus.addListener(Events.ClientModBusEvents::onLoadComplete);
		CreateLimited.init();
    }
}
