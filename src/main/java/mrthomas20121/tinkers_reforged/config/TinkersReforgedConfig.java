package mrthomas20121.tinkers_reforged.config;

import com.google.common.collect.Lists;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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

        @Config.Comment("Part of the config related to mods materials/interaction")
        @Config.LangKey("config."+MODID+".mods")
        public static SettingMods mods = new SettingMods();

        @Config.Comment("Damage multiplier for the Astral Infusion trait")
        @Config.LangKey("config."+MODID+".astral_infusion")
        public static double dmgMultiplier = 1.2;
    }

    public static class SettingMods {
        @Config.Comment("Config for Manasteel material.")
        @Config.LangKey("config."+MODID+".manasteel")
        public Manasteel manasteel = new Manasteel();

        @Config.Comment("Config for Starmetal material.")
        @Config.LangKey("config."+MODID+".starmetal")
        public Starmetal starmetal = new Starmetal();

        @Config.Comment("Config for Infused Iron material.")
        @Config.LangKey("config."+MODID+".infused_iron")
        public InfusedIron infusedIron = new InfusedIron();

        @Config.Comment("Config for Sky material.")
        @Config.LangKey("config."+MODID+".sky")
        public Sky sky = new Sky();

        @Config.Comment("Make pyrotheum a smeltery fuel.")
        @Config.LangKey("config."+MODID+".pyrotheum")
        public boolean pyrotheum = true;
    }

    public static class Manasteel {
        @Config.Comment("How much mana used per Manasteel parts.")
        @Config.LangKey("config."+MODID+".manacost")
        public int cost = 2000;

        @Config.Comment("MaterialsAA used to create Manasteel tool parts.")
        @Config.LangKey("config."+MODID+".manasteel_part")
        public String material = "iron";
    }

    public static class Starmetal {

        @Config.Comment("MaterialsAA used to create Starmetal tool parts.")
        @Config.LangKey("config."+MODID+".starmetal_part")
        public String material = "iron";
    }

    public static class InfusedIron {
        @Config.Comment("How much aura is used to craft a Infused Iron part.")
        @Config.LangKey("config."+MODID+".aura_cost")
        public int aura_cost = 50;

        @Config.Comment("Time it take to finish the craft.")
        @Config.LangKey("config."+MODID+".time")
        public int time = 25;

        @Config.Comment("MaterialsAA used to create Infused Iron tool parts.")
        @Config.LangKey("config."+MODID+".infused_iron_part")
        public String material = "iron";
    }

    public static class Sky {

        @Config.Comment("MaterialsAA used to create Manasteel tool parts.")
        @Config.LangKey("config."+MODID+".manasteel_part")
        public String material = "ref_infused_iron";
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

        @Config.Comment("Enable the Prospector Pickaxe.")
        @Config.LangKey("config."+MODID+".tool.propick")
        public static boolean enableProPick = true;
    }


    @Config(modid = MODID, name = "Tinkers Reforged - MaterialsAA and Modules")
    public static class SettingMaterials {

        @Config.Comment("MaterialsAA list.")
        @Config.LangKey("config."+MODID+".material")
        @Config.RequiresMcRestart
        public static Materials materials = new Materials();

        @Config.Comment("Modules list")
        @Config.LangKey("config."+MODID+".modules")
        @Config.RequiresMcRestart
        public static Modules modules = new Modules();
    }

    public static class Materials {
        @Config.Comment("Enable/Disable black_quartz material.")
        @Config.LangKey("config."+MODID+".material.black_quartz")
        @Config.RequiresMcRestart
        public boolean black_quartz = true;

        @Config.Comment("Enable/Disable restonia material.")
        @Config.LangKey("config."+MODID+".material.restonia")
        @Config.RequiresMcRestart
        public boolean restonia = true;

        @Config.Comment("Enable/Disable palis material.")
        @Config.LangKey("config."+MODID+".material.palis")
        @Config.RequiresMcRestart
        public boolean palis = true;

        @Config.Comment("Enable/Disable diamatine material.")
        @Config.LangKey("config."+MODID+".material.diamatine")
        @Config.RequiresMcRestart
        public boolean diamatine = true;

        @Config.Comment("Enable/Disable void_crystal material.")
        @Config.LangKey("config."+MODID+".material.void_crystal")
        @Config.RequiresMcRestart
        public boolean void_crystal = true;

        @Config.Comment("Enable/Disable emeradic material.")
        @Config.LangKey("config."+MODID+".material.emeradic")
        @Config.RequiresMcRestart
        public boolean emeradic = true;

        @Config.Comment("Enable/Disable enori material.")
        @Config.LangKey("config."+MODID+".material.enori")
        @Config.RequiresMcRestart
        public boolean enori = true;

        @Config.Comment("Enable/Disable certus_quartz material.")
        @Config.LangKey("config."+MODID+".material.certus_quartz")
        @Config.RequiresMcRestart
        public boolean certus_quartz = true;

        @Config.Comment("Enable/Disable charged_certus_quartz material.")
        @Config.LangKey("config."+MODID+".material.charged_certus_quartz")
        @Config.RequiresMcRestart
        public boolean charged_certus_quartz = true;

        @Config.Comment("Enable/Disable fluix_crystal material.")
        @Config.LangKey("config."+MODID+".material.fluix_crystal")
        @Config.RequiresMcRestart
        public boolean fluix_crystal = true;

        @Config.Comment("Enable/Disable starmetal material.")
        @Config.LangKey("config."+MODID+".material.starmetal")
        @Config.RequiresMcRestart
        public boolean starmetal = true;

        @Config.Comment("Enable/Disable khnumite material.")
        @Config.LangKey("config."+MODID+".material.khnumite")
        @Config.RequiresMcRestart
        public boolean khnumite = true;

        @Config.Comment("Enable/Disable zinc material.")
        @Config.LangKey("config."+MODID+".material.zinc")
        @Config.RequiresMcRestart
        public boolean zinc = true;

        @Config.Comment("Enable/Disable titanium material.")
        @Config.LangKey("config."+MODID+".material.titanium")
        @Config.RequiresMcRestart
        public boolean titanium = true;

        @Config.Comment("Enable/Disable platinum material.")
        @Config.LangKey("config."+MODID+".material.platinum")
        @Config.RequiresMcRestart
        public boolean platinum = true;

        @Config.Comment("Enable/Disable aluminum material.")
        @Config.LangKey("config."+MODID+".material.aluminum")
        @Config.RequiresMcRestart
        public boolean aluminum = true;

        @Config.Comment("Enable/Disable iridium material.")
        @Config.LangKey("config."+MODID+".material.iridium")
        @Config.RequiresMcRestart
        public boolean iridium = true;

        @Config.Comment("Enable/Disable invar material.")
        @Config.LangKey("config."+MODID+".material.invar")
        @Config.RequiresMcRestart
        public boolean invar = true;

        @Config.Comment("Enable/Disable amethyst material.")
        @Config.LangKey("config."+MODID+".material.amethyst")
        @Config.RequiresMcRestart
        public boolean amethyst = true;

        @Config.Comment("Enable/Disable ruby material.")
        @Config.LangKey("config."+MODID+".material.ruby")
        @Config.RequiresMcRestart
        public boolean ruby = true;

        @Config.Comment("Enable/Disable sapphire material.")
        @Config.LangKey("config."+MODID+".material.sapphire")
        @Config.RequiresMcRestart
        public boolean sapphire = true;

        @Config.Comment("Enable/Disable peridot material.")
        @Config.LangKey("config."+MODID+".material.peridot")
        @Config.RequiresMcRestart
        public boolean peridot = true;

        @Config.Comment("Enable/Disable horizonite material.")
        @Config.LangKey("config."+MODID+".material.horizonite")
        @Config.RequiresMcRestart
        public boolean horizonite = true;

        @Config.Comment("Enable/Disable charoite material.")
        @Config.LangKey("config."+MODID+".material.charoite")
        @Config.RequiresMcRestart
        public boolean charoite = true;

        @Config.Comment("Enable/Disable diopside material.")
        @Config.LangKey("config."+MODID+".material.diopside")
        @Config.RequiresMcRestart
        public boolean diopside = true;

        @Config.Comment("Enable/Disable pyrope material.")
        @Config.LangKey("config."+MODID+".material.pyrope")
        @Config.RequiresMcRestart
        public boolean pyrope = true;

        @Config.Comment("Enable/Disable turquoise material.")
        @Config.LangKey("config."+MODID+".material.turquoise")
        @Config.RequiresMcRestart
        public boolean turquoise = true;

        @Config.Comment("Enable/Disable manasteel material.")
        @Config.LangKey("config."+MODID+".material.manasteel")
        @Config.RequiresMcRestart
        public boolean manasteel = true;

        @Config.Comment("Enable/Disable livingwood material.")
        @Config.LangKey("config."+MODID+".material.livingwood")
        @Config.RequiresMcRestart
        public boolean livingwood = true;

        @Config.Comment("Enable/Disable livingrock material.")
        @Config.LangKey("config."+MODID+".material.livingrock")
        @Config.RequiresMcRestart
        public boolean livingrock = true;

        @Config.Comment("Enable/Disable dreamwood material.")
        @Config.LangKey("config."+MODID+".material.dreamwood")
        @Config.RequiresMcRestart
        public boolean dreamwood = true;

        @Config.Comment("Enable/Disable aquamarine material.")
        @Config.LangKey("config."+MODID+".material.aquamarine")
        @Config.RequiresMcRestart
        public boolean aquamarine = true;

        @Config.Comment("Enable/Disable hexcite material.")
        @Config.LangKey("config."+MODID+".material.hexcite")
        @Config.RequiresMcRestart
        public boolean hexcite = true;

        @Config.Comment("Enable/Disable magnite material.")
        @Config.LangKey("config."+MODID+".material.magnite")
        @Config.RequiresMcRestart
        public boolean magnite = true;

        @Config.Comment("Enable/Disable yellorium material.")
        @Config.LangKey("config."+MODID+".material.yellorium")
        @Config.RequiresMcRestart
        public boolean yellorium = true;

        @Config.Comment("Enable/Disable cyanite material.")
        @Config.LangKey("config."+MODID+".material.cyanite")
        @Config.RequiresMcRestart
        public boolean cyanite = true;

        @Config.Comment("Enable/Disable ludicrite material.")
        @Config.LangKey("config."+MODID+".material.ludicrite")
        @Config.RequiresMcRestart
        public boolean ludicrite = true;

        @Config.Comment("Enable/Disable blutonium material.")
        @Config.LangKey("config."+MODID+".material.blutonium")
        @Config.RequiresMcRestart
        public boolean blutonium = true;

        @Config.Comment("Enable/Disable osmium material.")
        @Config.LangKey("config."+MODID+".material.osmium")
        @Config.RequiresMcRestart
        public boolean osmium = true;

        @Config.Comment("Enable/Disable refined_obsidian material.")
        @Config.LangKey("config."+MODID+".material.refined_obsidian")
        @Config.RequiresMcRestart
        public boolean refined_obsidian = true;

        @Config.Comment("Enable/Disable refined_glowstone material.")
        @Config.LangKey("config."+MODID+".material.refined_glowstone")
        @Config.RequiresMcRestart
        public boolean refined_glowstone = true;

        @Config.Comment("Enable/Disable infused_iron material.")
        @Config.LangKey("config."+MODID+".material.infused_iron")
        @Config.RequiresMcRestart
        public boolean infused_iron = true;

        @Config.Comment("Enable/Disable sky material.")
        @Config.LangKey("config."+MODID+".material.sky")
        @Config.RequiresMcRestart
        public boolean sky = true;

        @Config.Comment("Enable/Disable firestone material.")
        @Config.LangKey("config."+MODID+".material.firestone")
        @Config.RequiresMcRestart
        public boolean firestone = true;

        @Config.Comment("Enable/Disable waterstone material.")
        @Config.LangKey("config."+MODID+".material.waterstone")
        @Config.RequiresMcRestart
        public boolean waterstone = true;

        @Config.Comment("Enable/Disable leafstone material.")
        @Config.LangKey("config."+MODID+".material.leafstone")
        @Config.RequiresMcRestart
        public boolean leafstone = true;

        @Config.Comment("Enable/Disable thunderstone material.")
        @Config.LangKey("config."+MODID+".material.thunderstone")
        @Config.RequiresMcRestart
        public boolean thunderstone = true;

        @Config.Comment("Enable/Disable sunstone material.")
        @Config.LangKey("config."+MODID+".material.sunstone")
        @Config.RequiresMcRestart
        public boolean sunstone = true;

        @Config.Comment("Enable/Disable dawnstone material.")
        @Config.LangKey("config."+MODID+".material.dawnstone")
        @Config.RequiresMcRestart
        public boolean dawnstone = true;

        @Config.Comment("Enable/Disable duskstone material.")
        @Config.LangKey("config."+MODID+".material.duskstone")
        @Config.RequiresMcRestart
        public boolean duskstone = true;

        @Config.Comment("Enable/Disable crystal material.")
        @Config.LangKey("config."+MODID+".material.crystal")
        @Config.RequiresMcRestart
        public boolean crystal = true;

        @Config.Comment("Enable/Disable red_alloy material.")
        @Config.LangKey("config."+MODID+".material.red_alloy")
        @Config.RequiresMcRestart
        public boolean red_alloy = true;

        @Config.Comment("Enable/Disable electrotine_alloy material.")
        @Config.LangKey("config."+MODID+".material.electrotine_alloy")
        @Config.RequiresMcRestart
        public boolean electrotine_alloy = true;

        @Config.Comment("Enable/Disable electrotine material.")
        @Config.LangKey("config."+MODID+".material.electrotine")
        @Config.RequiresMcRestart
        public boolean electrotine = true;

        @Config.Comment("Enable/Disable runestone material.")
        @Config.LangKey("config."+MODID+".material.runestone")
        @Config.RequiresMcRestart
        public boolean runestone = true;

        @Config.Comment("Enable/Disable quartz_enriched_iron material.")
        @Config.LangKey("config."+MODID+".material.quartz_enriched_iron")
        @Config.RequiresMcRestart
        public boolean quartz_enriched_iron = true;

        @Config.Comment("Enable/Disable thaumium material.")
        @Config.LangKey("config."+MODID+".material.thaumium")
        @Config.RequiresMcRestart
        public boolean thaumium = true;

        @Config.Comment("Enable/Disable enderium material.")
        @Config.LangKey("config."+MODID+".material.enderium")
        @Config.RequiresMcRestart
        public boolean enderium = true;

        @Config.Comment("Enable/Disable signalum material.")
        @Config.LangKey("config."+MODID+".material.signalum")
        @Config.RequiresMcRestart
        public boolean signalum = true;

        @Config.Comment("Enable/Disable lumium material.")
        @Config.LangKey("config."+MODID+".material.lumium")
        @Config.RequiresMcRestart
        public boolean lumium = true;

        @Config.Comment("Enable/Disable Nickel Silver material.")
        @Config.LangKey("config."+MODID+".material.nickel_silver")
        @Config.RequiresMcRestart
        public boolean nickel_silver = true;

        @Config.Comment("Enable/Disable Tool Steel material.")
        @Config.LangKey("config."+MODID+".material.tool_steel")
        @Config.RequiresMcRestart
        public boolean tool_steel = true;

        @Config.Comment("Enable/Disable Titanium Alloy material.")
        @Config.LangKey("config."+MODID+".material.titanium_alloy")
        @Config.RequiresMcRestart
        public boolean titanium_alloy = true;

        @Config.Comment("Enable/Disable Mangalloy material.")
        @Config.LangKey("config."+MODID+".material.mangalloy")
        @Config.RequiresMcRestart
        public boolean mangalloy = true;

        @Config.Comment("Enable/Disable qivium material.")
        @Config.LangKey("config."+MODID+".material.qivium")
        @Config.RequiresMcRestart
        public boolean qivium = true;

        @Config.Comment("Enable/Disable lavium material.")
        @Config.LangKey("config."+MODID+".material.lavium")
        @Config.RequiresMcRestart
        public boolean lavium = true;
    }

    public static class Modules {
        @Config.Comment("Enable/Disable actuallyadditions module.")
        @Config.LangKey("config."+MODID+".module.actuallyadditions")
        @Config.RequiresMcRestart
        public boolean actuallyadditions = true;

        @Config.Comment("Enable/Disable appliedenergistics2 module.")
        @Config.LangKey("config."+MODID+".module.appliedenergistics2")
        @Config.RequiresMcRestart
        public boolean appliedenergistics2 = true;

        @Config.Comment("Enable/Disable astralsorcery module.")
        @Config.LangKey("config."+MODID+".module.astralsorcery")
        @Config.RequiresMcRestart
        public boolean astralsorcery = true;

        @Config.Comment("Enable/Disable atum module.")
        @Config.LangKey("config."+MODID+".module.atum")
        @Config.RequiresMcRestart
        public boolean atum = true;

        @Config.Comment("Enable/Disable base_materials module.")
        @Config.LangKey("config."+MODID+".module.base_materials")
        @Config.RequiresMcRestart
        public boolean base_materials = true;

        @Config.Comment("Enable/Disable blue_skies module.")
        @Config.LangKey("config."+MODID+".module.blue_skies")
        @Config.RequiresMcRestart
        public boolean blue_skies = true;

        @Config.Comment("Enable/Disable biomeoplenty module.")
        @Config.LangKey("config."+MODID+".module.biomeoplenty")
        @Config.RequiresMcRestart
        public boolean biomeoplenty = true;

        @Config.Comment("Enable/Disable botania module.")
        @Config.LangKey("config."+MODID+".module.botania")
        @Config.RequiresMcRestart
        public boolean botania = true;

        @Config.Comment("Enable/Disable cavern2 module.")
        @Config.LangKey("config."+MODID+".module.cavern2")
        @Config.RequiresMcRestart
        public boolean cavern2 = true;

        @Config.Comment("Enable/Disable dark_utils module.")
        @Config.LangKey("config."+MODID+".module.dark_utils")
        @Config.RequiresMcRestart
        public boolean dark_utils = true;

        @Config.Comment("Enable/Disable environmentaltech module.")
        @Config.LangKey("config."+MODID+".module.environmentaltech")
        @Config.RequiresMcRestart
        public boolean environmentaltech = true;

        @Config.Comment("Enable/Disable extreme_reactor module.")
        @Config.LangKey("config."+MODID+".module.extreme_reactor")
        @Config.RequiresMcRestart
        public boolean extreme_reactor = true;

        @Config.Comment("Enable/Disable Heat and Climate module.")
        @Config.LangKey("config."+MODID+".module.heat_and_climate")
        @Config.RequiresMcRestart
        public boolean heat_and_climate = true;

        @Config.Comment("Enable/Disable mekanism module.")
        @Config.LangKey("config."+MODID+".module.mekanism")
        @Config.RequiresMcRestart
        public boolean mekanism = true;

        @Config.Comment("Enable/Disable naturesaura module.")
        @Config.LangKey("config."+MODID+".module.naturesaura")
        @Config.RequiresMcRestart
        public boolean naturesaura = true;

        @Config.Comment("Enable/Disable pixelmon module.")
        @Config.LangKey("config."+MODID+".module.pixelmon")
        @Config.RequiresMcRestart
        public boolean pixelmon = true;

        @Config.Comment("Enable/Disable project_red module.")
        @Config.LangKey("config."+MODID+".module.project_red")
        @Config.RequiresMcRestart
        public boolean project_red = true;

        @Config.Comment("Enable/Disable roots module.")
        @Config.LangKey("config."+MODID+".module.roots")
        @Config.RequiresMcRestart
        public boolean roots = true;

        @Config.Comment("Enable/Disable refined_storage module.")
        @Config.LangKey("config."+MODID+".module.refined_storage")
        @Config.RequiresMcRestart
        public boolean refined_storage = true;

        @Config.Comment("Enable/Disable thaumcraft module.")
        @Config.LangKey("config."+MODID+".module.thaumcraft")
        @Config.RequiresMcRestart
        public boolean thaumcraft = true;

        @Config.Comment("Enable/Disable thermal module.")
        @Config.LangKey("config."+MODID+".module.thermal")
        @Config.RequiresMcRestart
        public boolean thermal = true;

        @Config.Comment("Enable/Disable tinkers_reforged module.")
        @Config.LangKey("config."+MODID+".module.tinkers_reforged")
        @Config.RequiresMcRestart
        public boolean tinkers_reforged = true;
    }


}