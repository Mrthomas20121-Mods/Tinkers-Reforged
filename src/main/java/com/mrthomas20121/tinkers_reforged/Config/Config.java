package com.mrthomas20121.tinkers_reforged.Config;

import com.mrthomas20121.tinkers_reforged.TinkersReforged;
import com.mrthomas20121.tinkers_reforged.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

public class Config {
    // thermalfoundation
    public static boolean enderium = true;
    public static boolean signalum = true;
    public static boolean lumium = true;
    public static boolean platinum = true;
    public static boolean invar = true;
    public static boolean iridium = true;
    public static boolean aluminum = true;
    // naturesaura
    public static boolean infused_iron = true;
    public static boolean ancient_wood = true;
    public static boolean ingot_of_the_sky = true;
    // actually additions
    public static boolean blackquartz = true;
    public static boolean enori = true;
    public static boolean diamantine = true;
    public static boolean voidcrystal = true;
    public static boolean redstonia = true;
    public static boolean palis = true;
    public static boolean emeratic = true;
    // appliedenergistic2
    public static boolean certus_quartz = true;
    public static boolean fluix_crystal = true;
    // astral
    public static boolean starmetal = true;
    // atum
    public static boolean limestone = true;
    public static boolean khnumite = true;
    // blue skies
    public static boolean ventium = true;
    public static boolean horizonite = true;
    public static boolean pyrope = true;
    public static boolean turquoise = true;
    public static boolean charoite = true;
    public static boolean diopside = true;
    public static boolean lunar_stone = true;
    public static boolean turquoise_stone = true;
    //mekanism
    public static boolean refined_obsidian = true;
    public static boolean refined_glowstone = true;
    public static boolean osmium = true;
    public static boolean hdpe_sheet = true;
    // mystical world
    public static boolean amethyst = true;
    // roots
    public static boolean runestone = true;
    // extreme reactor
    public static boolean yellorium = true;
    public static boolean cyanite = true;
    public static boolean ludicrite = true;
    public static boolean blutonium = true;
    // tinkers' reforged
    public static boolean lavium = true;
    public static boolean qivium = true;
    public static boolean kovar = true;

    // tools
    public static boolean tools = true;
    public static boolean toolGladius = true;
    public static boolean toolClub = true;
    public static boolean toolGreatsword = true;
    public static boolean toolKhopesh = true;
    public static boolean toolRunedKnife = true;
    public static boolean atum_requirement_for_tools = true;

    // fuels
    public static boolean pyrotheum = true;

    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            ConfigModules.moduleTinkersReforged(cfg);
            ConfigModules.moduleAe2(cfg);
            ConfigModules.moduleAstralSorcery(cfg);
            ConfigModules.moduleAtum(cfg);
            ConfigModules.moduleBlueSkies(cfg);
            ConfigModules.moduleExtremReactor(cfg);
            ConfigModules.moduleMekanism(cfg);
            ConfigModules.moduleMysticalWorld(cfg);
            ConfigModules.moduleNaturesAura(cfg);
            ConfigModules.moduleRoots(cfg);
            ConfigModules.moduleThermal(cfg);
        } catch (Exception e1) {
            TinkersReforged.logger.log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }
}