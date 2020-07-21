package mrthomas20121.tinkers_reforged.proxy;

import mrthomas20121.tinkers_reforged.Config.Config;
import mrthomas20121.tinkers_reforged.Modifiers.Modifiers;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.tools.ToolCore;

import java.io.File;

//import static com.mrthomas20121.tinkers_reforged.TinkersReforged.logger;

@Mod.EventBusSubscriber
public class CommonProxy {

    public static Configuration config;
    public void preInit(FMLPreInitializationEvent e) {
        File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "TinkersReforged.cfg"));
        Config.readConfig();
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) { }

    public <T extends Item & IToolPart> void registerToolPartModel(T part) {
    }

    public void registerToolModel(ToolCore tc) {

    }
    public void registerBookData() { }
}