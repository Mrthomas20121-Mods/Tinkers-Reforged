package mrthomas20121.tinkers_reforged.config;

import com.google.common.collect.Lists;
import mrthomas20121.biolib.config.ConfigBase;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Level;

import java.util.ArrayList;

import static mrthomas20121.tinkers_reforged.TinkersReforged.MODID;

@Mod.EventBusSubscriber(modid = TinkersReforged.MODID)
public class TinkersReforgedConfig {

    @SubscribeEvent
    public static void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equals(TinkersReforged.MODID))
        {
            ConfigManager.sync(TinkersReforged.MODID, net.minecraftforge.common.config.Config.Type.INSTANCE);
        }
    }

    @Config(modid = MODID, name = "Tinkers Reforged - General")
    public static class SettingGeneral {

        @Config.Comment("Enable Alloy recipes.")
        @Config.LangKey("config."+MODID+".enableAlloy")
        public static boolean enableAlloyRecipes = true;

        @Config.Comment("How much mana Livingwood/Livingrock/Manasteel parts cost.")
        @Config.LangKey("config."+MODID+".manacost")
        public static int manaCost = 2000;

        @Config.Comment("Fuels added by this mod. syntax is : modid:fluid_name:temp:amount:fuel_duration")
        @Config.LangKey("config."+MODID+".fuels")
        public static String[] fuels = {
                "thermalfoundation:pyrotheum:2000:1000:1000"
        };

        @Config.Comment("Materials used to create Manasteel, Livingwood, Livingrock parts. syntax is: manasteel:livingwood:livingrock")
        @Config.LangKey("config."+MODID+".parts_botania")
        public static String infusionMaterials = "iron:wood:stone";

        @Config.Comment("Material used to create starmetal parts.")
        @Config.LangKey("config."+MODID+".parts_astral")
        public static String materialStarmetal = "iron";
    }

    @Config(modid = MODID, name = "Tinkers Reforged - Tools")
    public static class SettingTools {

        @Config.Comment("Enable the Tinkers Reforged tools.")
        @Config.LangKey("config."+MODID+".tools")
        public static boolean enableTools = true;

        @Config.Comment("Enable the gladius.")
        @Config.LangKey("config."+MODID+".tool.gladius")
        public static boolean enableGladius = true;

        @Config.Comment("Enable the club.")
        @Config.LangKey("config."+MODID+".tool.club")
        public static boolean enableClub = true;

        @Config.Comment("Enable the greatsword.")
        @Config.LangKey("config."+MODID+".tool.greatsword")
        public static boolean enableGreatsword = true;

        @Config.Comment("Enable the khopesh.")
        @Config.LangKey("config."+MODID+".tool.khopesh")
        public static boolean enableKhopesh = true;

        @Config.Comment("Enable the Roots Knife.")
        @Config.LangKey("config."+MODID+".tool.knife")
        public static boolean enableKnife = true;

        @Config.Comment("Enable the lightsword.")
        @Config.LangKey("config."+MODID+".tool.lightsword")
        public static boolean enableLightsword = true;
    }


    @Config(modid = MODID, name = "Tinkers Reforged - Materials and Modules")
    public static class SettingMaterials {

        @Config.Comment("Materials to remove list.")
        @Config.LangKey("config."+MODID+".material")
        @Config.RequiresMcRestart
        public static String[] materials = new String[] {};

        @Config.Comment("Modules to disable list. module name is the mod id")
        @Config.LangKey("config."+MODID+".modules")
        @Config.RequiresMcRestart
        public static String[] modules = new String[] {};

        public static boolean containMaterials(String materialName)
        {
            boolean result = true;
            for(String material: materials)
            {
                if(material.equals(materialName))
                {
                    result = false;
                    break;
                }
            }
            return result;
        }
        public static boolean containModules(String moduleName)
        {
            boolean result = false;
            for(String material: materials)
            {
                if(material.equals(moduleName))
                {
                    result = true;
                    break;
                }
            }
            return result;
        }
    }


}