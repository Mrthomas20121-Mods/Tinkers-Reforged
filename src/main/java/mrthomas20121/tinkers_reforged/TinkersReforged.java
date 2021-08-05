package mrthomas20121.tinkers_reforged;

import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.library.Manager;
import mrthomas20121.tinkers_reforged.tools.ToolClub;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.common.SidedProxy;
import mrthomas20121.tinkers_reforged.proxy.CommonProxy;

@Mod(modid = TinkersReforged.MODID, name = TinkersReforged.NAME, version = TinkersReforged.VERSION,
        dependencies = "required-after:forge@[14.23.5.2847,);"
        + "required-after:mantle@[1.12-1.3.3.55,);"
        + "required-after:tconstruct@[1.12.2-2.13.0.183,);"
        + "required-after:biolib@[1.1.2,);")
public class TinkersReforged
{
    @Mod.Instance(TinkersReforged.MODID)
    public static TinkersReforged instance;
    // manager
    public static Manager manager = new Manager();
    public static final String MODID = "tinkers_reforged";
    public static final String NAME = "Tinkers Reforged";
    public static final String VERSION = "1.5.6";

    private static Logger logger;

    public static Logger getLogger() {
        return logger;
    }

    @SidedProxy(serverSide = "mrthomas20121.tinkers_reforged.proxy.CommonProxy", clientSide = "mrthomas20121.tinkers_reforged.proxy.ClientProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
        if(Loader.isModLoaded(Reference.atum) && TinkersReforgedConfig.SettingMaterials.modules.atum && TinkersReforgedConfig.SettingTools.enableClub) {
            MinecraftForge.EVENT_BUS.register(ToolClub.class);
        }
        logger = event.getModLog();
        proxy.preInit(event);
        manager.preInit();
   }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.registerBookData();
        proxy.init(event);
        manager.init();
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.registerToolCrafting();
        proxy.postInit(event);
        manager.postInit();
    }

}
