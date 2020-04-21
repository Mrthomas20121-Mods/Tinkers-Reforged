package com.mrthomas20121.tinkers_reforged;

import com.mrthomas20121.tinkers_reforged.Config.Config;
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
        + "required-after:mantle@[1.12-1.3.3.49,);"
        + "required-after:tconstruct@[1.12.2-2.12.0.157,);")
public class TinkersReforged
{
    @Mod.Instance
    public static TinkersReforged instance;
    public static final String MODID = "tinkers_reforged";
    public static final String NAME = "Tinkers' Reforged";
    public static final String VERSION = "1.0.3";

    public static Logger logger;

    @SidedProxy(serverSide = "com.mrthomas20121.tinkers_reforged.proxy.CommonProxy", clientSide = "com.mrthomas20121.tinkers_reforged.proxy.ClientProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
        logger = event.getModLog();
        proxy.preInit(event);

        if(Loader.isModLoaded("thermalfoundation") && Config.thermal) {
            Modules.thermal.preInit(event);
        }
        if(Loader.isModLoaded("naturesaura") && Config.naturesaura) {
            Modules.natureAura.preInit(event);
        }
        if(Loader.isModLoaded("appliedenergistics2") && Config.ae2) {
            Modules.ae.preInit(event);
        }
        if(Loader.isModLoaded("astralsorcery") && Config.astral) {
            Modules.astral.preInit(event);
        }
        if(Loader.isModLoaded("natura") && Config.astral) {
            Modules.natura.preInit(event);
        }
   }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
        if(Loader.isModLoaded("naturesaura") && Config.naturesaura) {
            Modules.natureAura.init(event);
        }
        if(Loader.isModLoaded("astralsorcery") && Config.astral) {
            Modules.astral.init(event);
        }
        if(Loader.isModLoaded("thermalfoundation") && Config.thermal) {
            Modules.thermal.init(event);
        }
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
    @Mod.EventHandler
    public void clientPostInit() {
        Modules.module.clientPostInit();
    }
}
