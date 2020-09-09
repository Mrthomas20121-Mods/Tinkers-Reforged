package mrthomas20121.tinkers_reforged.config;

import mrthomas20121.biolib.config.ConfigBase;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class ConfigReforged extends ConfigBase {

    public static boolean alloyrecipes = true;
    public static boolean tools = true;
    public static boolean gladius = true;
    public static boolean club = true;
    public static boolean greatsword = true;
    public static boolean khopesh = true;
    public static boolean runedKnife = true;
    public static int mana = 1000;
    // fuels
    public static String[] fuels = {
            "thermalfoundation:pyrotheum:2000:1000:1000"
    };

    public static ConfigBase getInstance() {
        return new ConfigReforged();
    }

    public ConfigReforged()
    {
        super("tinkers_reforged.cfg", Configuration.CATEGORY_GENERAL);
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        File reforged_folder = new File(event.getModConfigurationDirectory(), "tinkers_reforged");
        this.config = new Configuration(new File(reforged_folder, this.getName()));
    }

    @Override
    public void init() {
        tools = this.getConfig().getBoolean("tools", this.getCategory(), ConfigReforged.tools, "Set to false to disable Tinkers Tools/Weapons added by this mod.");
        // weapons
        gladius = this.getConfig().getBoolean("weapon_gladius", this.getCategory(), gladius, "Set to false to disable the Gladius weapon.");
        club = this.getConfig().getBoolean("weapon_club", this.getCategory(), club, "Set to false to disable the Club weapon.");
        greatsword = this.getConfig().getBoolean("weapon_greatsword", this.getCategory(), greatsword, "Set to false to disable the Greatsword weapon.");
        runedKnife = this.getConfig().getBoolean("weapon_runic_knife", this.getCategory(), runedKnife, "Set to false to disable the Runic Knife weapon.");

        // botania stuff
        mana = this.getConfig().getInt("mana", this.getCategory(), mana, 0, 50000, "How much mana the pool will use to create manasteel/livingwood/livingrock tinkers parts.");
        // fuels
        fuels = this.getConfig().getStringList("smeltery_fuels", this.getCategory(), fuels, "Fuels to registers. syntax is modid:fluidname:temp:amount:fuelduration");

        alloyrecipes = this.getConfig().getBoolean("alloys", this.getCategory(), alloyrecipes, "Set to false to remove alloys recipes.");
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
