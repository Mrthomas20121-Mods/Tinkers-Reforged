package mrthomas20121.tinkers_reforged.config;

import mrthomas20121.biolib.config.ConfigBase;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Level;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = TinkersReforged.MODID)
public class Config {

    public static ConfigReforged configReforged = new ConfigReforged();
    public static ConfigModule configModule = new ConfigModule();
    public static ConfigMaterials configMaterials = new ConfigMaterials();

    @SubscribeEvent
    public static void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equals(TinkersReforged.MODID))
        {
            ConfigManager.sync(TinkersReforged.MODID, net.minecraftforge.common.config.Config.Type.INSTANCE);
        }
    }

    public static void readConfig(FMLPreInitializationEvent event) {
        configReforged.preInit(event);
        configMaterials.preInit(event);
        configModule.preInit(event);

        try {
            configReforged.getConfig().load();
            configMaterials.getConfig().load();
            configModule.getConfig().load();
            if(configReforged.canLoad() || configMaterials.canLoad() || configModule.canLoad())
            {
                configReforged.init();
                configMaterials.init();
                configModule.init();
            }
        } catch (Exception e1) {
            TinkersReforged.getLogger().log(Level.ERROR, "Problem loading config files!", e1);
        } finally {
            if (configReforged.getConfig().hasChanged()){
                    configReforged.getConfig().save();
            }
            if (configMaterials.getConfig().hasChanged()) {
                configMaterials.getConfig().save();
            }
            if (configModule.getConfig().hasChanged()) {
                configModule.getConfig().save();
            }
        }
    }
}