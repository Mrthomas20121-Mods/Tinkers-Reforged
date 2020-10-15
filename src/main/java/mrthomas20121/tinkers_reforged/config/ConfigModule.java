package mrthomas20121.tinkers_reforged.config;

import mrthomas20121.biolib.config.ConfigBase;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class ConfigModule extends ConfigBase {

    public static boolean tinkersreforged = true;
    public static boolean actuallyadditions = true;
    public static boolean advancedrocketry = true;
    public static boolean appliedenergistics = true;
    public static boolean astralsorcery = true;
    public static boolean atum = true;
    public static boolean bigreactors = true;
    public static boolean biomesoplenty = true;
    public static boolean blueskies = true;
    public static boolean botania = true;
    public static boolean cavernII = true;
    public static boolean cyclic = true;
    public static boolean darkutils = true;
    public static boolean environmentaltech = true;
    public static boolean mekanism = true;
    public static boolean mysticalworld = true;
    public static boolean naturesaura = true;
    public static boolean pixelmon_reforged = true;
    public static boolean projectred_core = true;
    public static boolean projectred_exploration = true;
    public static boolean railcraft = true;
    public static boolean refinedstorage = true;
    public static boolean roots = true;
    public static boolean techreborn = true;
    public static boolean thermalfoundation = true;

    public ConfigModule()
    {
        super("modules.cfg", Configuration.CATEGORY_GENERAL);
    }

    public static ConfigBase getInstance()
    {
        return new ConfigModule();
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        File reforged_folder = new File(event.getModConfigurationDirectory(), "tinkers_reforged");
        this.setConfig(new Configuration(new File(reforged_folder, this.getName())));
    }

    @Override
    public void init() {
        tinkersreforged = this.getConfig().getBoolean("tinkersreforged", this.getCategory(), tinkersreforged, "Set to false to disable tinkersreforged module.");
        actuallyadditions = this.getConfig().getBoolean("actuallyadditions", this.getCategory(), actuallyadditions, "Set to false to disable actuallyadditions module.");
        advancedrocketry = this.getConfig().getBoolean("advancedrocketry", this.getCategory(), advancedrocketry, "Set to false to disable advancedrocketry module.");
        appliedenergistics = this.getConfig().getBoolean("appliedenergistics", this.getCategory(), appliedenergistics, "Set to false to disable appliedenergistics module.");
        astralsorcery = this.getConfig().getBoolean("astralsorcery", this.getCategory(), astralsorcery, "Set to false to disable astralsorcery module.");
        atum = this.getConfig().getBoolean("atum", this.getCategory(), atum, "Set to false to disable atum module.");
        biomesoplenty = this.getConfig().getBoolean("biomesoplenty", this.getCategory(), biomesoplenty, "Set to false to disable biomesoplenty module.");
        blueskies = this.getConfig().getBoolean("blueskies", this.getCategory(), blueskies, "Set to false to disable blueskies module.");
        botania = this.getConfig().getBoolean("botania", this.getCategory(), botania, "Set to false to disable botania module.");
        cavernII = this.getConfig().getBoolean("cavernII", this.getCategory(), cavernII, "Set to false to disable cavernII module.");
        cyclic = this.getConfig().getBoolean("cyclic", this.getCategory(), cyclic, "Set to false to disable cyclic module.");
        environmentaltech = this.getConfig().getBoolean("environmentaltech", this.getCategory(), environmentaltech, "Set to false to disable environmentaltech module.");
        darkutils = this.getConfig().getBoolean("dark_utilities", this.getCategory(), darkutils, "Set to false to disable dark utils module.");
        bigreactors = this.getConfig().getBoolean("bigreactors", this.getCategory(), bigreactors, "Set to false to disable bigreactors module.");
        mekanism = this.getConfig().getBoolean("mekanism", this.getCategory(), mekanism, "Set to false to disable mekanism module.");
        mysticalworld = this.getConfig().getBoolean("mysticalworld", this.getCategory(), mysticalworld, "Set to false to disable mysticalworld module.");
        naturesaura = this.getConfig().getBoolean("naturesaura", this.getCategory(), naturesaura, "Set to false to disable naturesaura module.");
        projectred_core = this.getConfig().getBoolean("projectred_core", this.getCategory(), projectred_core, "Set to false to disable projectred_core module.");
        projectred_exploration = this.getConfig().getBoolean("projectred_exploration", this.getCategory(), projectred_exploration, "Set to false to disable projectred_exploration module.");
        railcraft = this.getConfig().getBoolean("railcraft", this.getCategory(), railcraft, "Set to false to disable railcraft module.");
        refinedstorage = this.getConfig().getBoolean("refinedstorage", this.getCategory(), refinedstorage, "Set to false to disable refinedstorage module.");
        roots = this.getConfig().getBoolean("roots", this.getCategory(), roots, "Set to false to disable roots module.");
        techreborn = this.getConfig().getBoolean("techreborn", this.getCategory(), techreborn, "Set to false to disable techreborn module.");
        thermalfoundation = this.getConfig().getBoolean("thermalfoundation", this.getCategory(), thermalfoundation, "Set to false to disable thermalfoundation module.");
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
