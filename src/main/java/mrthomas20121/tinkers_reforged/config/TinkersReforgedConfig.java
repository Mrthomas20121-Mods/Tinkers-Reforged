package mrthomas20121.tinkers_reforged.config;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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

        @Config.Comment("Make pyrotheum a smeltery fuel.")
        @Config.LangKey("config."+MODID+".pyrotheum")
        public static boolean pyrotheum = true;

        @Config.Comment("Materials used to create Manasteel tool parts.")
        @Config.LangKey("config."+MODID+".parts_botania")
        public static String infusionMaterial = "iron";

        @Config.Comment("Tinker Material used to create starmetal parts.")
        @Config.LangKey("config."+MODID+".parts_astral")
        public static String materialStarmetal = "iron";

        @Config.Comment("Damage multiplier for the Astral Infusion trait")
        @Config.LangKey("config."+MODID+".astral_infusion")
        public static double dmgMultiplier = 1.2;
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
            for(String module: modules)
            {
                if(module.equals(moduleName))
                {
                    result = true;
                    break;
                }
            }
            return result;
        }
    }


}