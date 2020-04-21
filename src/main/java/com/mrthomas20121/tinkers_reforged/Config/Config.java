package com.mrthomas20121.tinkers_reforged.Config;

import com.mrthomas20121.tinkers_reforged.TinkersReforged;
import com.mrthomas20121.tinkers_reforged.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

public class Config {

    private static final String CATEGORY_METERIALS = "materials";
    private static final String CATEGORY_GENERAL = "general";
    private static final String CATEGORY_MODULES = "modules";

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

    // modules
    public static boolean thermal = true;
    public static boolean naturesaura = true;
    public static boolean ae2 = true;
    public static boolean astral = true;


    /**
     * Read the Config
     */
    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            initMaterialConfig(cfg);
            initModuleConfig(cfg);
        } catch (Exception e1) {
            TinkersReforged.logger.log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initMaterialConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_METERIALS, "Tinkers' Construct Materials");

        // thermal
        enderium = cfg.getBoolean("enderium", CATEGORY_METERIALS, enderium, "Set to false to disable enderium material");
        signalum = cfg.getBoolean("signalum", CATEGORY_METERIALS, signalum, "Set to false to disable signalum material");
        lumium = cfg.getBoolean("lumium", CATEGORY_METERIALS, lumium, "Set to false to disable lumium material");

        // naturesaura
        infused_iron = cfg.getBoolean("infused_iron", CATEGORY_METERIALS, infused_iron, "Set to false to disable infused iron material");
        ancient_wood = cfg.getBoolean("ancient_wood", CATEGORY_METERIALS, ancient_wood, "Set to false to disable ancient wood material");


        // astral sorcery
        starmetal = cfg.getBoolean("astral_starmetal", CATEGORY_METERIALS, starmetal, "Set to false to disable astral star metal material");

        // ae2
        certus_quartz = cfg.getBoolean("certus_quartz", CATEGORY_METERIALS, certus_quartz, "Set to false to disable certus quartz material");
        fluix_crystal = cfg.getBoolean("fluix_crystal", CATEGORY_METERIALS, fluix_crystal, "Set to false to disable fluix crystal material");
    }

    private static void initModuleConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_MODULES, "Modules");
        thermal = cfg.getBoolean("thermalfoundation", CATEGORY_MODULES, thermal, "Set to false to disable Thermal Foundation Module");
        naturesaura = cfg.getBoolean("naturesaura", CATEGORY_MODULES, naturesaura, "Set to false to disable Natures Aura Module");
        ae2 = cfg.getBoolean("appliedenergistics2", CATEGORY_MODULES, ae2, "Set to false to disable Applied Energistic 2 Module");
        astral = cfg.getBoolean("astralsorcery", CATEGORY_MODULES, astral, "Set to false to disable Astral Sorcery Module");
    }
}