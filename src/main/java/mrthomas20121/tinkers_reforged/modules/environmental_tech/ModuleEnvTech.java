package mrthomas20121.tinkers_reforged.modules.environmental_tech;

import com.google.common.collect.Lists;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.library.ModuleCore;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;

import java.util.ArrayList;

public class ModuleEnvTech extends ModuleCore {

    public ModuleEnvTech() {
        super("enviromentaltech");
    }

    @Override
    public boolean canLoad() {
        return TinkersReforgedConfig.SettingMaterials.modules.environmentaltech && this.isDepLoaded();
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        this.setMaterialClass(new ModifiersEnvTech());
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
        return Lists.newArrayList(ModifiersEnvTech.digging);
    }
}
