package com.mrthomas20121.tinkers_reforged;

import com.mrthomas20121.tinkers_reforged.Config.Config;
import com.mrthomas20121.tinkers_reforged.proxy.ClientEvent;
import com.mrthomas20121.tinkers_reforged.proxy.ClientProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.common.SidedProxy;
import com.mrthomas20121.tinkers_reforged.proxy.CommonProxy;

import com.mrthomas20121.tinkers_reforged.Module.Modules;

@Mod(modid = TinkersReforged.MODID, name = TinkersReforged.NAME, version = TinkersReforged.VERSION,
        dependencies = "required-after:forge@[14.23.5.2847,);"
        + "required-after:mantle@[1.12-1.3.3.55,);"
        + "required-after:tconstruct@[1.12.2-2.13.0.183,);")
public class TinkersReforged
{
    @Mod.Instance
    public static TinkersReforged instance;
    public static final String MODID = "tinkers_reforged";
    public static final String NAME = "Tinkers' Reforged";
    public static final String VERSION = "1.0.6";

    public static Logger logger;

    @SidedProxy(serverSide = "com.mrthomas20121.tinkers_reforged.proxy.CommonProxy", clientSide = "com.mrthomas20121.tinkers_reforged.proxy.ClientProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
        if (Loader.isModLoaded("atum")) {
            MinecraftForge.EVENT_BUS.register(ClientEvent.class);
        }
        logger = event.getModLog();
        proxy.preInit(event);

        Modules.preInit(event);
   }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
        Modules.init(event);
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
        Modules.postInit(event);
    }

}
