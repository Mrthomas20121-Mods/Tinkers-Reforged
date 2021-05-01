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
        public static boolean enableAlloyRecipes = true;

        @Config.Comment("Part of the config related to mods materials/interaction")
        public static SettingMods mods = new SettingMods();

        @Config.Comment("Damage multiplier for the Astral Infusion trait")
        public static double dmgMultiplier = 1.2;
    }

    public static class SettingMods {
        @Config.Comment("Config for Manasteel material.")
        public Manasteel manasteel = new Manasteel();

        @Config.Comment("Config for Starmetal material.")
        public Starmetal starmetal = new Starmetal();

        @Config.Comment("Config for Infused Iron material.")
        public InfusedIron infusedIron = new InfusedIron();

        @Config.Comment("Config for Sky material.")
        public Sky sky = new Sky();

        @Config.Comment("Make pyrotheum a smeltery fuel.")
        public boolean pyrotheum = true;
    }

    public static class Manasteel {
        @Config.Comment("How much mana used per Manasteel parts.")
        public int cost = 2000;

        @Config.Comment("Materials used to create Manasteel tool parts.")
        public String material = "iron";
    }

    public static class Starmetal {

        @Config.Comment("Materials used to create Starmetal tool parts.")
        public String material = "iron";
    }

    public static class InfusedIron {
        @Config.Comment("How much aura is used to craft a Infused Iron part.")
        public int aura_cost = 50;

        @Config.Comment("Time it take to finish the craft.")
        public int time = 25;

        @Config.Comment("Materials used to create Infused Iron tool parts.")
        public String material = "iron";
    }

    public static class Sky {

        @Config.Comment("Materials used to create Manasteel tool parts.")
        public String material = "ref_infused_iron";
    }

    @Config(modid = MODID, name = "Tinkers Reforged - Tools")
    public static class SettingTools {

        @Config.Comment("Enable the Tinkers Reforged tools.")
        public static boolean enableTools = true;

        @Config.Comment("Enable the gladius.")
        public static boolean enableGladius = true;

        @Config.Comment("Enable the club.")
        public static boolean enableClub = true;

        @Config.Comment("Enable the greatsword.")
        public static boolean enableGreatsword = true;

        @Config.Comment("Enable the khopesh.")
        public static boolean enableKhopesh = true;

        @Config.Comment("Enable the Roots Knife.")
        public static boolean enableKnife = true;

        @Config.Comment("Enable the lightsword.")
        public static boolean enableLightsword = true;

        @Config.Comment("Enable the Prospector Pickaxe.")
        public static boolean enableProPick = true;
    }


    @Config(modid = MODID, name = "Tinkers Reforged - Materials and Modules")
    public static class SettingMaterials {

        @Config.Comment("Materials list.")
        @Config.RequiresMcRestart
        public static Materials materials = new Materials();

        @Config.Comment("Modules list")
        @Config.RequiresMcRestart
        public static Modules modules = new Modules();

        @Config.Comment("Modifiers list")
        @Config.RequiresMcRestart
        public static SettingModifiers modifiers = new SettingModifiers();
    }

    public static class SettingModifiers {

        @Config.Comment("Enable the Modifier Enderstar. Require Actually Additions")
        public boolean enderstar = true;

        @Config.Comment("Enable the Modifier Lens Killer. Require Actually Additions")
        public boolean lens_killer = true;

        @Config.Comment("Enable the Modifier Lens Miner. Require Actually Additions")
        public boolean lens_miner = true;

        @Config.Comment("Enable the Modifier amber. Require Biomesoplenty")
        public boolean amber = true;

        @Config.Comment("Enable the Modifier tanzanite. Require Biomesoplenty")
        public boolean tanzanite = true;

        @Config.Comment("Enable the Modifier topaz. Require Biomesoplenty")
        public boolean topaz = true;

        @Config.Comment("Enable the Modifier malachite. Require Biomesoplenty")
        public boolean malachite = true;

        @Config.Comment("Enable the Modifier Terrestrial Artifact. Require Biomesoplenty")
        public boolean terrestrial_artifact = true;

        @Config.Comment("Enable the Modifier Shulker Pearl. Require Darkutils.")
        public boolean shulker_pearl = true;

        @Config.Comment("Enable the Modifier digging. Require Environmental tech.")
        public boolean digging = true;

        @Config.Comment("Enable the Modifier token. Require Naturesaura.")
        public boolean token = true;
    }

    public static class Materials {
        @Config.Comment("Enable/Disable black_quartz material.")
        @Config.RequiresMcRestart
        public boolean black_quartz = true;

        @Config.Comment("Enable/Disable restonia material.")
        @Config.RequiresMcRestart
        public boolean restonia = true;

        @Config.Comment("Enable/Disable palis material.")
        @Config.RequiresMcRestart
        public boolean palis = true;

        @Config.Comment("Enable/Disable diamatine material.")
        @Config.RequiresMcRestart
        public boolean diamatine = true;

        @Config.Comment("Enable/Disable void_crystal material.")
        @Config.RequiresMcRestart
        public boolean void_crystal = true;

        @Config.Comment("Enable/Disable emeradic material.")
        @Config.RequiresMcRestart
        public boolean emeradic = true;

        @Config.Comment("Enable/Disable enori material.")
        @Config.RequiresMcRestart
        public boolean enori = true;

        @Config.Comment("Enable/Disable certus_quartz material.")
        @Config.RequiresMcRestart
        public boolean certus_quartz = true;

        @Config.Comment("Enable/Disable charged_certus_quartz material.")
        @Config.RequiresMcRestart
        public boolean charged_certus_quartz = true;

        @Config.Comment("Enable/Disable fluix_crystal material.")
        @Config.RequiresMcRestart
        public boolean fluix_crystal = true;

        @Config.Comment("Enable/Disable starmetal material.")
        @Config.RequiresMcRestart
        public boolean starmetal = true;

        @Config.Comment("Enable/Disable khnumite material.")
        @Config.RequiresMcRestart
        public boolean khnumite = true;

        @Config.Comment("Enable/Disable limestone material.")
        @Config.RequiresMcRestart
        public boolean limestone = true;

        @Config.Comment("Enable/Disable glowstone material.")
        @Config.RequiresMcRestart
        public boolean glowstone = true;

        @Config.Comment("Enable/Disable zinc material.")
        @Config.RequiresMcRestart
        public boolean zinc = true;

        @Config.Comment("Enable/Disable titanium material.")
        @Config.RequiresMcRestart
        public boolean titanium = true;

        @Config.Comment("Enable/Disable platinum material.")
        @Config.RequiresMcRestart
        public boolean platinum = true;

        @Config.Comment("Enable/Disable aluminum material.")
        @Config.RequiresMcRestart
        public boolean aluminum = true;

        @Config.Comment("Enable/Disable iridium material.")
        @Config.RequiresMcRestart
        public boolean iridium = true;

        @Config.Comment("Enable/Disable invar material.")
        @Config.RequiresMcRestart
        public boolean invar = true;

        @Config.Comment("Enable/Disable amethyst material.")
        @Config.RequiresMcRestart
        public boolean amethyst = true;

        @Config.Comment("Enable/Disable ruby material.")
        @Config.RequiresMcRestart
        public boolean ruby = true;

        @Config.Comment("Enable/Disable sapphire material.")
        @Config.RequiresMcRestart
        public boolean sapphire = true;

        @Config.Comment("Enable/Disable peridot material.")
        @Config.RequiresMcRestart
        public boolean peridot = true;

        @Config.Comment("Enable/Disable horizonite material.")
        @Config.RequiresMcRestart
        public boolean horizonite = true;

        @Config.Comment("Enable/Disable charoite material.")
        @Config.RequiresMcRestart
        public boolean charoite = true;

        @Config.Comment("Enable/Disable diopside material.")
        @Config.RequiresMcRestart
        public boolean diopside = true;

        @Config.Comment("Enable/Disable pyrope material.")
        @Config.RequiresMcRestart
        public boolean pyrope = true;

        @Config.Comment("Enable/Disable turquoise material.")
        @Config.RequiresMcRestart
        public boolean turquoise = true;

        @Config.Comment("Enable/Disable manasteel material.")
        @Config.RequiresMcRestart
        public boolean manasteel = true;

        @Config.Comment("Enable/Disable livingwood material.")
        @Config.RequiresMcRestart
        public boolean livingwood = true;

        @Config.Comment("Enable/Disable livingrock material.")
        @Config.RequiresMcRestart
        public boolean livingrock = true;

        @Config.Comment("Enable/Disable dreamwood material.")
        @Config.RequiresMcRestart
        public boolean dreamwood = true;

        @Config.Comment("Enable/Disable aquamarine material.")
        @Config.RequiresMcRestart
        public boolean aquamarine = true;

        @Config.Comment("Enable/Disable hexcite material.")
        @Config.RequiresMcRestart
        public boolean hexcite = true;

        @Config.Comment("Enable/Disable magnite material.")
        @Config.RequiresMcRestart
        public boolean magnite = true;

        @Config.Comment("Enable/Disable yellorium material.")
        @Config.RequiresMcRestart
        public boolean yellorium = true;

        @Config.Comment("Enable/Disable cyanite material.")
        @Config.RequiresMcRestart
        public boolean cyanite = true;

        @Config.Comment("Enable/Disable ludicrite material.")
        @Config.RequiresMcRestart
        public boolean ludicrite = true;

        @Config.Comment("Enable/Disable blutonium material.")
        @Config.RequiresMcRestart
        public boolean blutonium = true;

        @Config.Comment("Enable/Disable osmium material.")
        @Config.RequiresMcRestart
        public boolean osmium = true;

        @Config.Comment("Enable/Disable refined_obsidian material.")
        @Config.RequiresMcRestart
        public boolean refined_obsidian = true;

        @Config.Comment("Enable/Disable refined_glowstone material.")
        @Config.RequiresMcRestart
        public boolean refined_glowstone = true;

        @Config.Comment("Enable/Disable infused_iron material.")
        @Config.RequiresMcRestart
        public boolean infused_iron = true;

        @Config.Comment("Enable/Disable sky material.")
        @Config.RequiresMcRestart
        public boolean sky = true;

        @Config.Comment("Enable/Disable firestone material.")
        @Config.RequiresMcRestart
        public boolean firestone = true;

        @Config.Comment("Enable/Disable waterstone material.")
        @Config.RequiresMcRestart
        public boolean waterstone = true;

        @Config.Comment("Enable/Disable leafstone material.")
        @Config.RequiresMcRestart
        public boolean leafstone = true;

        @Config.Comment("Enable/Disable thunderstone material.")
        @Config.RequiresMcRestart
        public boolean thunderstone = true;

        @Config.Comment("Enable/Disable sunstone material.")
        @Config.RequiresMcRestart
        public boolean sunstone = true;

        @Config.Comment("Enable/Disable dawnstone material.")
        @Config.RequiresMcRestart
        public boolean dawnstone = true;

        @Config.Comment("Enable/Disable duskstone material.")
        @Config.RequiresMcRestart
        public boolean duskstone = true;

        @Config.Comment("Enable/Disable crystal material.")
        @Config.RequiresMcRestart
        public boolean crystal = true;

        @Config.Comment("Enable/Disable red_alloy material.")
        @Config.RequiresMcRestart
        public boolean red_alloy = true;

        @Config.Comment("Enable/Disable electrotine_alloy material.")
        @Config.RequiresMcRestart
        public boolean electrotine_alloy = true;

        @Config.Comment("Enable/Disable electrotine material.")
        @Config.RequiresMcRestart
        public boolean electrotine = true;

        @Config.Comment("Enable/Disable runestone material.")
        @Config.RequiresMcRestart
        public boolean runestone = true;

        @Config.Comment("Enable/Disable quartz_enriched_iron material.")
        @Config.RequiresMcRestart
        public boolean quartz_enriched_iron = true;

        @Config.Comment("Enable/Disable thaumium material.")
        @Config.RequiresMcRestart
        public boolean thaumium = true;

        @Config.Comment("Enable/Disable enderium material.")
        @Config.RequiresMcRestart
        public boolean enderium = true;

        @Config.Comment("Enable/Disable signalum material.")
        @Config.RequiresMcRestart
        public boolean signalum = true;

        @Config.Comment("Enable/Disable lumium material.")
        @Config.RequiresMcRestart
        public boolean lumium = true;

        @Config.Comment("Enable/Disable Nickel Silver material.")
        @Config.RequiresMcRestart
        public boolean nickel_silver = true;

        @Config.Comment("Enable/Disable Tool Steel material.")
        @Config.RequiresMcRestart
        public boolean tool_steel = true;

        @Config.Comment("Enable/Disable Titanium Alloy material.")
        @Config.RequiresMcRestart
        public boolean titanium_alloy = true;

        @Config.Comment("Enable/Disable Mangalloy material.")
        @Config.RequiresMcRestart
        public boolean mangalloy = true;

        @Config.Comment("Enable/Disable qivium material.")
        @Config.RequiresMcRestart
        public boolean qivium = true;

        @Config.Comment("Enable/Disable lavium material.")
        @Config.RequiresMcRestart
        public boolean lavium = true;
    }

    public static class Modules {
        @Config.Comment("Enable/Disable actuallyadditions module.")
        @Config.RequiresMcRestart
        public boolean actuallyadditions = true;

        @Config.Comment("Enable/Disable appliedenergistics2 module.")
        @Config.RequiresMcRestart
        public boolean appliedenergistics2 = true;

        @Config.Comment("Enable/Disable astralsorcery module.")
        @Config.RequiresMcRestart
        public boolean astralsorcery = true;

        @Config.Comment("Enable/Disable atum module.")
        @Config.RequiresMcRestart
        public boolean atum = true;

        @Config.Comment("Enable/Disable base_materials module.")
        @Config.RequiresMcRestart
        public boolean base_materials = true;

        @Config.Comment("Enable/Disable blue_skies module.")
        @Config.RequiresMcRestart
        public boolean blue_skies = true;

        @Config.Comment("Enable/Disable biomeoplenty module.")
        @Config.RequiresMcRestart
        public boolean biomeoplenty = true;

        @Config.Comment("Enable/Disable botania module.")
        @Config.RequiresMcRestart
        public boolean botania = true;

        @Config.Comment("Enable/Disable cavern2 module.")
        @Config.RequiresMcRestart
        public boolean cavern2 = true;

        @Config.Comment("Enable/Disable dark_utils module.")
        @Config.RequiresMcRestart
        public boolean dark_utils = true;

        @Config.Comment("Enable/Disable extreme_reactor module.")
        @Config.RequiresMcRestart
        public boolean extreme_reactor = true;

        @Config.Comment("Enable/Disable Heat and Climate module.")
        @Config.RequiresMcRestart
        public boolean heat_and_climate = true;

        @Config.Comment("Enable/Disable mekanism module.")
        @Config.RequiresMcRestart
        public boolean mekanism = true;

        @Config.Comment("Enable/Disable naturesaura module.")
        @Config.RequiresMcRestart
        public boolean naturesaura = true;

        @Config.Comment("Enable/Disable pixelmon module.")
        @Config.RequiresMcRestart
        public boolean pixelmon = true;

        @Config.Comment("Enable/Disable project_red module.")
        @Config.RequiresMcRestart
        public boolean project_red = true;

        @Config.Comment("Enable/Disable roots module.")
        @Config.RequiresMcRestart
        public boolean roots = true;

        @Config.Comment("Enable/Disable refined_storage module.")
        @Config.RequiresMcRestart
        public boolean refined_storage = true;

        @Config.Comment("Enable/Disable thaumcraft module.")
        @Config.RequiresMcRestart
        public boolean thaumcraft = true;

        @Config.Comment("Enable/Disable thermal module.")
        @Config.RequiresMcRestart
        public boolean thermal = true;

        @Config.Comment("Enable/Disable tinkers_reforged module.")
        @Config.RequiresMcRestart
        public boolean tinkers_reforged = true;
    }


}