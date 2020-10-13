package mrthomas20121.tinkers_reforged.config;

import mrthomas20121.biolib.config.ConfigBase;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class ConfigMaterials extends ConfigBase {

    // tinkers reforged materials
    public static boolean lavium = true;
    public static boolean qivium = true;

    // common materials
    public static boolean invar = true;
    public static boolean aluminum = true;
    public static boolean iridium = true;
    public static boolean platinum = true;
    public static boolean titanium = true;
    public static boolean zinc = true;
    public static boolean ruby = true;
    public static boolean sapphire = true;
    public static boolean amethyst = true;
    public static boolean peridot = true;

    // actually additions
    public static boolean blackquartz = true;
    public static boolean diamatine = true;
    public static boolean emeradic = true;
    public static boolean enori = true;
    public static boolean palis = true;
    public static boolean void_crystal = true;
    public static boolean restonia = true;
    public static boolean silicon = true;

    // ae2
    public static boolean certus_quartz = true;
    public static boolean fluix_crystal = true;

    // astral sorcery
    public static boolean starmetal = true;

    // atum2
    public static boolean khnumite = true;
    public static boolean limestone = true;

    // blue skies
    public static boolean charoite = true;
    public static boolean diopside = true;
    public static boolean horizonite = true;
    public static boolean pyrope = true;

    // botania
    public static boolean dragonstone = true;
    public static boolean dreamwood = true;
    public static boolean elementium = true;
    public static boolean gaia_spirit = true;
    public static boolean red_string = true;
    public static boolean manasteel = true;
    public static boolean terrasteel = true;
    public static boolean mana_diamond = true;
    public static boolean livingwood = true;
    public static boolean livingrock = true;

    // cavern II
    public static boolean aquamarine = true;
    public static boolean magnite = true;
    public static boolean hexcite = true;

    // extreme/big reactors
    public static boolean yellorium = true;
    public static boolean cyanite = true;
    public static boolean blutonium = true;
    public static boolean ludicrite = true;

    // mekanism
    public static boolean osmium = true;
    public static boolean refined_obsidian = true;
    public static boolean refined_glowstone = true;

    // project red
    public static boolean red_alloy = true;
    public static boolean electrotine = true;
    public static boolean electrotine_alloy = true;

    // quark
    public static boolean ender_biotite = true;

    // refined storage
    public static boolean quartz_enriched_iron = true;

    // thaumcraft

    public static boolean thaumium = true;

    // thermal expansion
    public static boolean enderium = true;
    public static boolean signalum = true;
    public static boolean lumium = true;

    // natures aura
    public static boolean material_of_the_sky = true;
    public static boolean infused_iron = true;
    public static boolean ancient_wood = true;

    // roots
    public static boolean runestone = true;

    // pixelmon
    public static boolean firestone = true;
    public static boolean waterstone = true;
    public static boolean leafstone = true;
    public static boolean thunderstone = true;
    public static boolean sunstone = true;
    public static boolean dawnstone = true;
    public static boolean duskstone = true;
    public static boolean crystal = true;

    public static ConfigBase getInstance() {
        return new ConfigMaterials();
    }

    public ConfigMaterials()
    {
        super("materials.cfg", Configuration.CATEGORY_GENERAL);
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        File reforged_folder = new File(event.getModConfigurationDirectory(), "tinkers_reforged");
        this.config = new Configuration(new File(reforged_folder, this.getName()));
    }

    @Override
    public void init() {
        // tinkers reforged
        lavium = this.config.getBoolean("lavium", this.getCategory(), lavium, "Set to false to disable the material lavium");
        qivium = this.config.getBoolean("qivium", this.getCategory(), qivium, "Set to false to disable the material qivium");

        // common materials
        invar = this.config.getBoolean("invar", this.getCategory(), invar, "Set to false to disable the material invar");
        aluminum = this.config.getBoolean("aluminum", this.getCategory(), aluminum, "Set to false to disable the material aluminum");
        iridium = this.config.getBoolean("iridium", this.getCategory(), iridium, "Set to false to disable the material iridium");
        platinum = this.config.getBoolean("platinum", this.getCategory(), platinum, "Set to false to disable the material platinum");
        titanium = this.config.getBoolean("titanium", this.getCategory(), titanium, "Set to false to disable the material titanium");
        zinc = this.config.getBoolean("zinc", this.getCategory(), zinc, "Set to false to disable the material zinc");
        ruby = this.config.getBoolean("ruby", this.getCategory(), ruby, "Set to false to disable the material ruby");
        sapphire = this.config.getBoolean("sapphire", this.getCategory(), sapphire, "Set to false to disable the material sapphire");
        amethyst = this.config.getBoolean("amethyst", this.getCategory(), amethyst, "Set to false to disable the material amethyst");
        peridot = this.config.getBoolean("peridot", this.getCategory(), peridot, "Set to false to disable the material peridot");

        // actually addition
        blackquartz = this.config.getBoolean("blackquartz", this.getCategory(), blackquartz, "Set to false to disable the material blackquartz");
        diamatine = this.config.getBoolean("diamatine", this.getCategory(), diamatine, "Set to false to disable the material diamatine");
        emeradic = this.config.getBoolean("emeradic", this.getCategory(), emeradic, "Set to false to disable the material emeradic");
        enori = this.config.getBoolean("enori", this.getCategory(), enori, "Set to false to disable the material enori");
        palis = this.config.getBoolean("palis", this.getCategory(), palis, "Set to false to disable the material palis");
        void_crystal = this.config.getBoolean("void_crystal", this.getCategory(), void_crystal, "Set to false to disable the material void_crystal");
        restonia = this.config.getBoolean("restonia", this.getCategory(), restonia, "Set to false to disable the material restonia");

        // advanced rocketry
        silicon = this.config.getBoolean("silicon", this.getCategory(), silicon, "Set to false to disable the material silicon");

        // applied energistics
        certus_quartz = this.config.getBoolean("certus_quartz", this.getCategory(), certus_quartz, "Set to false to disable the material certus_quartz");
        fluix_crystal = this.config.getBoolean("fluix_crystal", this.getCategory(), fluix_crystal, "Set to false to disable the material fluix_crystal");

        // astral sorcery
        starmetal = this.config.getBoolean("starmetal", this.getCategory(), starmetal, "Set to false to disable the material starmetal");

        // atum 2
        khnumite = this.config.getBoolean("khnumite", this.getCategory(), khnumite, "Set to false to disable the material khnumite");
        limestone = this.config.getBoolean("limestone", this.getCategory(), limestone, "Set to false to disable the material limestone");

        // blue skies
        charoite = this.config.getBoolean("charoite", this.getCategory(), charoite, "Set to false to disable the material charoite");
        diopside = this.config.getBoolean("diopside", this.getCategory(), diopside, "Set to false to disable the material diopside");
        horizonite = this.config.getBoolean("horizonite", this.getCategory(), horizonite, "Set to false to disable the material horizonite");
        pyrope = this.config.getBoolean("pyrope", this.getCategory(), pyrope, "Set to false to disable the material pyrope");

        // botania
        dragonstone = this.config.getBoolean("dragonstone", this.getCategory(), dragonstone, "Set to false to disable the material dragonstone");
        dreamwood = this.config.getBoolean("dreamwood", this.getCategory(), dreamwood, "Set to false to disable the material dreamwood");
        elementium = this.config.getBoolean("elementium", this.getCategory(), elementium, "Set to false to disable the material elementium");
        gaia_spirit = this.config.getBoolean("gaia_spirit", this.getCategory(), gaia_spirit, "Set to false to disable the material gaia_spirit");
        red_string = this.config.getBoolean("red_string", this.getCategory(), red_string, "Set to false to disable the material red_string");
        manasteel = this.config.getBoolean("manasteel", this.getCategory(), manasteel, "Set to false to disable the material manasteel");
        terrasteel = this.config.getBoolean("terrasteel", this.getCategory(), terrasteel, "Set to false to disable the material terrasteel");
        mana_diamond = this.config.getBoolean("mana_diamond", this.getCategory(), mana_diamond, "Set to false to disable the material mana_diamond");
        livingwood = this.config.getBoolean("livingwood", this.getCategory(), livingwood, "Set to false to disable the material livingwood");
        livingrock = this.config.getBoolean("livingrock", this.getCategory(), livingrock, "Set to false to disable the material livingrock");

        // cavern II
        aquamarine = this.config.getBoolean("aquamarine", this.getCategory(), aquamarine, "Set to false to disable the material aquamarine");
        magnite = this.config.getBoolean("magnite", this.getCategory(), magnite, "Set to false to disable the material magnite");
        hexcite = this.config.getBoolean("hexcite", this.getCategory(), hexcite, "Set to false to disable the material hexcite");

        // extreme reactor
        yellorium = this.config.getBoolean("yellorium", this.getCategory(), yellorium, "Set to false to disable the material yellorium");
        cyanite = this.config.getBoolean("cyanite", this.getCategory(), cyanite, "Set to false to disable the material cyanite");
        blutonium = this.config.getBoolean("blutonium", this.getCategory(), blutonium, "Set to false to disable the material blutonium");
        ludicrite = this.config.getBoolean("ludicrite", this.getCategory(), ludicrite, "Set to false to disable the material ludicrite");

        // mekanism
        osmium = this.config.getBoolean("osmium", this.getCategory(), osmium, "Set to false to disable the material osmium");
        refined_obsidian = this.config.getBoolean("refined_obsidian", this.getCategory(), refined_obsidian, "Set to false to disable the material refined_obsidian");
        refined_glowstone = this.config.getBoolean("refined_glowstone", this.getCategory(), refined_glowstone, "Set to false to disable the material refined_glowstone");

        // project red core
        red_alloy = this.config.getBoolean("red_alloy", this.getCategory(), red_alloy, "Set to false to disable the material red_alloy");
        electrotine = this.config.getBoolean("electrotine", this.getCategory(), electrotine, "Set to false to disable the material electrotine");
        electrotine_alloy = this.config.getBoolean("electrotine_alloy", this.getCategory(), electrotine_alloy, "Set to false to disable the material electrotine_alloy");

        // quark
        ender_biotite = this.config.getBoolean("ender_biotite", this.getCategory(), ender_biotite, "Set to false to disable the material ender_biotite");

        // refined storage
        quartz_enriched_iron = this.config.getBoolean("quartz_enriched_iron", this.getCategory(), quartz_enriched_iron, "Set to false to disable the material quartz_enriched_iron");

        // thermal expansion
        enderium = this.config.getBoolean("enderium", this.getCategory(), enderium, "Set to false to disable the material enderium");
        signalum = this.config.getBoolean("signalum", this.getCategory(), signalum, "Set to false to disable the material signalum");
        lumium = this.config.getBoolean("lumium", this.getCategory(), lumium, "Set to false to disable the material lumium");

        // natures aura
        material_of_the_sky = this.config.getBoolean("material_of_the_sky", this.getCategory(), material_of_the_sky, "Set to false to disable the material material_of_the_sky");
        infused_iron = this.config.getBoolean("infused_iron", this.getCategory(), infused_iron, "Set to false to disable the material infused_iron");
        ancient_wood = this.config.getBoolean("ancient_wood", this.getCategory(), ancient_wood, "Set to false to disable the material ancient_wood");
        // roots
        runestone = this.config.getBoolean("runestone", this.getCategory(), runestone, "Set to false to disable the material runestone");

        // pixelmon reforged
        firestone = this.config.getBoolean("firestone", this.getCategory(), firestone, "Set to false to disable the material firestone");
        waterstone = this.config.getBoolean("waterstone", this.getCategory(), waterstone, "Set to false to disable the material waterstone");
        leafstone = this.config.getBoolean("leafstone", this.getCategory(), leafstone, "Set to false to disable the material leafstone");
        thunderstone = this.config.getBoolean("thunderstone", this.getCategory(), thunderstone, "Set to false to disable the material thunderstone");
        sunstone = this.config.getBoolean("sunstone", this.getCategory(), leafstone, "Set to false to disable the material sunstone");
        dawnstone = this.config.getBoolean("dawnstone", this.getCategory(), dawnstone, "Set to false to disable the material dawnstone");
        duskstone = this.config.getBoolean("duskstone", this.getCategory(), leafstone, "Set to false to disable the material duskstone");
        crystal = this.config.getBoolean("crystal", this.getCategory(), crystal, "Set to false to disable the material crystal");
    }

    @Override
    public boolean isLoaded() {
        return true;
    }

    @Override
    public boolean canLoad() {
        return true;
    }
}
