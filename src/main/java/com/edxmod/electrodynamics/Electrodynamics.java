package com.edxmod.electrodynamics;

import com.edxmod.electrodynamics.common.block.EDXBlocks;
import com.edxmod.electrodynamics.common.config.EDXConfiguration;
import com.edxmod.electrodynamics.common.core.EDXRecipes;
import com.edxmod.electrodynamics.common.events.EDXEvents;
import com.edxmod.electrodynamics.common.item.EDXItems;
import com.edxmod.electrodynamics.common.network.PacketPipeline;
import com.edxmod.electrodynamics.common.lib.EDXProps;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * @author Royalixor.
 */
@Mod(modid = EDXProps.ID, name = EDXProps.NAME, version = EDXProps.VERSION, dependencies = "required-after:Forge@[10.12.0.1024,)")
public class Electrodynamics {

    @Mod.Instance(EDXProps.ID)
    public static Electrodynamics instance;

    @SidedProxy(clientSide = EDXProps.CLIENT, serverSide = EDXProps.SERVER)
    public static CommonProxy proxy;

    public static final PacketPipeline packetPipeline = new PacketPipeline();

    public static String configPath;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        configPath = event.getModConfigurationDirectory() + "/EDX/";
        EDXConfiguration.init(configPath);

        EDXBlocks.init();
        EDXItems.init();
        EDXEvents.init();
        EDXRecipes.init();

        proxy.registerRenders();
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
        packetPipeline.init();
    }

    @Mod.EventHandler
    public void modsLoaded(FMLPostInitializationEvent event) {
        packetPipeline.postInit();
    }
}
