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

    public static String materialsBotania = "iron:wood:stone";
    public static String materialStarmetal = "iron";

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
