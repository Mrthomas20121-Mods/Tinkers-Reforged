package com.mrthomas20121.tinkers_reforged.Config;

import com.mrthomas20121.tinkers_reforged.TinkersReforged;
import com.mrthomas20121.tinkers_reforged.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

import java.util.HashMap;

public class Config {

    private static final String CATEGORY_METERIALS = "materials";
    private static final String CATEGORY_GENERAL = "general";
    private static final String CATEGORY_MODULES = "modules";
    private static final String CATEGORY_TOOLS = "tools";

    // thermalfoundation
    public static boolean enderium = true;
    public static boolean signalum = true;
    public static boolean lumium = true;

    // naturesaura
    public static boolean infused_iron = true;
    public static boolean ancient_wood = true;

    // appliedenergistic2
    public static boolean certus_quartz = true;
    public static boolean fluix_crystal = true;

    // astral
    public static boolean starmetal = true;

    // atum
    public static boolean limestone = true;
    public static boolean khnumite = true;

    // mystical world
    public static boolean amethyst = true;

    // roots
    public static boolean runestone = true;

    // modules
    public static boolean thermal = true;
    public static boolean naturesaura = true;
    public static boolean ae2 = true;
    public static boolean astral = true;
    public static boolean atum = true;
    public static boolean mysticalworld = true;
    public static boolean roots = true;
    public static boolean extreme = true;

    // tools
    public static boolean tools = true;
    public static boolean toolGladius = true;
    public static boolean toolClub = true;
    public static boolean toolGreatsword = true;
    public static boolean toolKhopesh = true;
    public static boolean toolRunedKnife = true;
    public static boolean atum_requirement_for_tools = true;
    /**
     * Read the Config
     */
    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            initMaterialConfig(cfg, CATEGORY_METERIALS);
            initModuleConfig(cfg, CATEGORY_MODULES);
            initToolsConfig(cfg, CATEGORY_TOOLS);
        } catch (Exception e1) {
            TinkersReforged.logger.log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initMaterialConfig(Configuration cfg, String category) {
        cfg.addCustomCategoryComment(category, "Tinkers' Construct Materials");
        // thermal
        enderium = cfg.getBoolean("enderium", category, enderium, "Set to false to disable enderium material");
        signalum = cfg.getBoolean("signalum", category, signalum, "Set to false to disable signalum material");
        lumium = cfg.getBoolean("lumium", category, lumium, "Set to false to disable lumium material");

        // naturesaura
        infused_iron = cfg.getBoolean("infused_iron", category, infused_iron, "Set to false to disable infused iron material");
        ancient_wood = cfg.getBoolean("ancient_wood", category, ancient_wood, "Set to false to disable ancient wood material");

        // astral sorcery
        starmetal = cfg.getBoolean("astral_starmetal", category, starmetal, "Set to false to disable astral star metal material");

        // ae2
        certus_quartz = cfg.getBoolean("certus_quartz", category, certus_quartz, "Set to false to disable certus quartz material");
        fluix_crystal = cfg.getBoolean("fluix_crystal", category, fluix_crystal, "Set to false to disable fluix crystal material");

        // atum 2
        limestone = cfg.getBoolean("limestone", category, limestone, "Set to false to disable limestone material");
        khnumite = cfg.getBoolean("khnumite", category, fluix_crystal, "Set to false to disable khnumite material");

        // mystical world
        amethyst = cfg.getBoolean("amethyst", category, amethyst, "Set to false to disable amethyst material");

        // roots
        runestone = cfg.getBoolean("runestone", category, runestone, "Set to false to disable runestone material");

    }

    private static void initModuleConfig(Configuration cfg, String category) {
        cfg.addCustomCategoryComment(category, "Modules");
        thermal = cfg.getBoolean("thermalfoundation", category, thermal, "Set to false to disable Thermal Foundation Module");
        naturesaura = cfg.getBoolean("naturesaura", category, naturesaura, "Set to false to disable Natures Aura Module");
        ae2 = cfg.getBoolean("appliedenergistics2", category, ae2, "Set to false to disable Applied Energistic 2 Module");
        astral = cfg.getBoolean("astralsorcery", category, astral, "Set to false to disable Astral Sorcery Module");
        atum = cfg.getBoolean("atum", category, atum, "Set to false to disable Atum Module");
        mysticalworld = cfg.getBoolean("mysticalworld", category, mysticalworld, "Set to false to disable Mystical World Module");
        roots = cfg.getBoolean("roots", category, roots, "Set to false to disable Astral Sorcery Module");
    }
    private static void initToolsConfig(Configuration cfg, String category) {
        cfg.addCustomCategoryComment(category, "Tools");
        tools = cfg.getBoolean("tools", category, tools, "Set to false to disable Tinkers' Tools Added by this mod");
        toolGladius = cfg.getBoolean("toolGladius", category, toolGladius, "Set to false to disable the weapon Gladius");
        toolClub = cfg.getBoolean("toolClub", category, toolClub, "Set to false to disable the weapon Club");
        toolGreatsword = cfg.getBoolean("toolGreatsword", category, toolGreatsword, "Set to false to disable the weapon Greatsword");
        toolKhopesh = cfg.getBoolean("toolKhopesh", category, toolKhopesh, "Set to false to disable the weapon Khopesh");
        toolRunedKnife = cfg.getBoolean("toolRunedKnife", category, toolRunedKnife, "Set to false to disable the weapon Runed Knife");
        atum_requirement_for_tools = cfg.getBoolean("atum_requirement_for_tools", category, atum_requirement_for_tools, "Set to false to Remove the Atum Requirement for the tools");
    }
}