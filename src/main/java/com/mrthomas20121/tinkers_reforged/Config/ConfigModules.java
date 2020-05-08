package com.mrthomas20121.tinkers_reforged.Config;

import net.minecraftforge.common.config.Configuration;
import com.mrthomas20121.tinkers_reforged.Config.Config;

public class ConfigModules {

    private static String name = "module";

    public static boolean ae2 = true;
    public static boolean astral = true;
    public static boolean atum = true;
    public static boolean blue_skies = true;
    public static boolean extreme = true;
    public static boolean mekanism = true;
    public static boolean mysticalworld = true;
    public static boolean naturesaura = true;
    public static boolean roots = true;
    public static boolean thermal = true;

    public static void moduleAe2(Configuration cfg) {
        String category = "appliedenergistics2";
        ae2 = cfg.getBoolean(name, category, ae2, "Set to false to disable Applied Energistic 2 module");

        Config.certus_quartz = cfg.getBoolean("certus_quartz", category, Config.certus_quartz, "Set to false to disable certus quartz material");
        Config.fluix_crystal = cfg.getBoolean("fluix_crystal", category, Config.fluix_crystal, "Set to false to disable fluix crystal material");
    }
    public static void moduleAtum(Configuration cfg) {
        String category = "atum2";
        atum = cfg.getBoolean(name, category, atum, "Set to false to disable Atum module");

        Config.limestone = cfg.getBoolean("limestone", category, Config.limestone, "Set to false to disable limestone material");
        Config.khnumite = cfg.getBoolean("khnumite", category, Config.fluix_crystal, "Set to false to disable khnumite material");

        Config.toolClub = cfg.getBoolean("weaponClub", category, Config.toolClub, "Set to false to disable the weapon Club");
        Config.toolGreatsword = cfg.getBoolean("weaponGreatsword", category, Config.toolGreatsword, "Set to false to disable the weapon Greatsword");
        Config.toolKhopesh = cfg.getBoolean("weaponKhopesh", category, Config.toolKhopesh, "Set to false to disable the weapon Khopesh");
        Config.atum_requirement_for_tools = cfg.getBoolean("require_atum", category, Config.atum_requirement_for_tools, "Set to false to let atum tools to be used without atum 2 loaded");
    }
    public static void moduleAstralSorcery(Configuration cfg) {
        String category = "astralsorcery";
        astral = cfg.getBoolean(name, category, astral, "Set to false to disable Astral Sorcery module");

        Config.starmetal = cfg.getBoolean("astral_starmetal", category, Config.starmetal, "Set to false to disable astral starmetal material");
    }
    public static void moduleBlueSkies(Configuration cfg) {
        String category = "blue_skies";
        blue_skies = cfg.getBoolean(name, category, blue_skies, "Set to false to disable Blue Skies module");
    }
    public static void moduleExtremReactor(Configuration cfg) {
        String category = "extremereactors";
        extreme = cfg.getBoolean(name, category, extreme, "Set to false to disable Extreme Reactors module");

        Config.yellorium = cfg.getBoolean("yellorium", category, Config.yellorium, "Set to false to disable yellorium material");
        Config.blutonium = cfg.getBoolean("blutonium", category, Config.blutonium, "Set to false to disable blutonium material");
        Config.cyanite = cfg.getBoolean("cyanite", category, Config.cyanite, "Set to false to disable cyanite material");
        Config.ludicrite = cfg.getBoolean("ludicrite", category, Config.ludicrite, "Set to false to disable ludicrite material");
    }
    public static void moduleMekanism(Configuration cfg) {
        String category = "mekanism";
        mekanism = cfg.getBoolean(name, category, mekanism, "Set to false to disable Mekanism  module");

        Config.refined_obsidian = cfg.getBoolean("refined_obsidian", category, Config.refined_obsidian, "Set to false to disable refined obsidian material");
        Config.refined_glowstone = cfg.getBoolean("refined_glowstone", category, Config.refined_glowstone, "Set to false to disable refined glowstone material");
        Config.osmium = cfg.getBoolean("osmium", category, Config.osmium, "Set to false to disable osmium material");
        Config.hdpe_sheet = cfg.getBoolean("hdpe_sheet", category, Config.hdpe_sheet, "Set to false to disable hdpe sheet material");
    }

    public static void moduleMysticalWorld(Configuration cfg) {
        String category = "mysticalworld";
        mysticalworld = cfg.getBoolean(name, category, mysticalworld, "Set to false to disable Mystical World module");

        Config.amethyst = cfg.getBoolean("amethyst", category, Config.amethyst, "Set to false to disable amethyst material");
    }
    public static void moduleNaturesAura(Configuration cfg) {
        String category = "natuesaura";
        naturesaura = cfg.getBoolean(name, category, naturesaura, "Set to false to disable Natures Aura module");

        Config.infused_iron = cfg.getBoolean("infused_iron", category, Config.infused_iron, "Set to false to disable infused iron material");
        Config.ingot_of_the_sky = cfg.getBoolean("material_of_the_sky", category, Config.ancient_wood, "Set to false to disable material_of_the_sky material");
        Config.ancient_wood = cfg.getBoolean("ancient_wood", category, Config.ancient_wood, "Set to false to disable ancient wood material");
    }
    public static void moduleRoots(Configuration cfg) {
        String category = "roots";
        roots = cfg.getBoolean(name, category, roots, "Set to false to disable Roots module");

        Config.runestone = cfg.getBoolean("runestone", category, Config.runestone, "Set to false to disable runestone material");

        Config.toolRunedKnife = cfg.getBoolean("toolRunedKnife", category, Config.toolRunedKnife, "Set to false to disable the weapon Runed Knife");
    }
    public static void moduleThermal(Configuration cfg) {
        String category = "thermalfoundation";
        thermal = cfg.getBoolean(name, category, thermal, "Set to false to disable Thermal Foundation module");

        Config.enderium = cfg.getBoolean("enderium", category, Config.enderium, "Set to false to disable enderium material");
        Config.signalum = cfg.getBoolean("signalum", category, Config.signalum, "Set to false to disable signalum material");
        Config.lumium = cfg.getBoolean("lumium", category, Config.lumium, "Set to false to disable lumium material");
        Config.platinum = cfg.getBoolean("platinum", category, Config.platinum, "Set to false to disable platinum material");
        Config.iridium = cfg.getBoolean("iridium", category, Config.iridium, "Set to false to disable iridium material");
        Config.invar = cfg.getBoolean("invar", category, Config.invar, "Set to false to disable invar material");
        Config.aluminum = cfg.getBoolean("aluminum", category, Config.aluminum, "Set to false to disable aluminum material");
    }
    public static void moduleTinkersReforged(Configuration cfg) {
        String category = "general";

        Config.tools = cfg.getBoolean("tools", category, Config.tools, "Set to false to disable Tinkers' Tools Added by this mod");
        Config.toolGladius = cfg.getBoolean("swordGladius", category, Config.toolGladius, "Set to false to disable the weapon Gladius");

    }
}
