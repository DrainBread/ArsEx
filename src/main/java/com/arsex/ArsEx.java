package com.arsex;

import com.arsex.mod.ArsExId;
import com.arsex.mod.registry.ArsExEffects;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.arsex.mod.events.PlayerExArsEvents;
import com.arsex.mod.events.ArsExConfig;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ArsExId.modId)
@Mod.EventBusSubscriber(modid = ArsExId.modId, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArsEx
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public static boolean arsLoaded = false;

    public static boolean playerExLoaded = false;

    public ArsEx() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        arsLoaded = ModList.get().isLoaded("ars_nouveau");
        playerExLoaded = ModList.get().isLoaded("playerex");
        if (arsLoaded) {
            //ArsSpells.initSpells();
            if (playerExLoaded)
                MinecraftForge.EVENT_BUS.register(new PlayerExArsEvents());
        }
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ArsExConfig.COMMON_CONFIG);
        ArsExEffects.EFFECTS.register(bus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(FMLCommonSetupEvent event) {}

}
