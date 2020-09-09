package mrthomas20121.tinkers_reforged.proxy;

import mrthomas20121.tinkers_reforged.config.Config;
import mrthomas20121.tinkers_reforged.modules.Modules;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import slimeknights.tconstruct.library.modifiers.IModifier;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.tools.ToolCore;


@Mod.EventBusSubscriber
public class CommonProxy {


    public void preInit(FMLPreInitializationEvent e) {

        Config.readConfig(e);
    }

    public void init(FMLInitializationEvent e) {
        Modules.tools.init(e);
    }

    public void postInit(FMLPostInitializationEvent e) { }

    public <T extends Item & IToolPart> void registerToolPartModel(T part) { }

    public void registerToolModel(ToolCore tc) { }
    public void registerModifierModel(IModifier mod, ResourceLocation rl) { }
    public void registerBookData() { }

    public void registerToolCrafting()
    {

    }
}