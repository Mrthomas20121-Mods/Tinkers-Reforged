package mrthomas20121.tinkers_reforged.modules.darkutils;

import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.library.ModuleCore;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;

import java.util.ArrayList;

public class ModuleDarkUtils extends ModuleCore {

    public ModuleDarkUtils() {
        super("darkutils");
    }

    @Override
    public boolean canLoad() {
        return TinkersReforgedConfig.SettingMaterials.modules.dark_utils && this.isDepLoaded();
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        this.setMaterialClass(new ModifiersDarkUtils());
        this.getMaterialClass().preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        this.getMaterialClass().init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        this.getMaterialClass().postInit(event);
    }

    @Override
    public ArrayList<Modifier> getModifiers() {
        ArrayList<Modifier> list = new ArrayList<>();
        list.add(ModifiersDarkUtils.shulkerPearl);
        return list;
    }
}
