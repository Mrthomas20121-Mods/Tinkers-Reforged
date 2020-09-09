package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.Traits.Traits;
import mrthomas20121.tinkers_reforged.config.ConfigMaterials;
import mrthomas20121.tinkers_reforged.resources.Resources;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleAstralSorcery implements ModuleBase {


    public ModuleAstralSorcery() {
        Resources.starmetal.builder.setCraftable(false).setCastable(true);
        Resources.starmetal.builder.setTrait(Traits.astral, MaterialTypes.HEAD);
        Resources.starmetal.builder.setTrait(TinkerTraits.alien);
        Resources.starmetal.builder.setHeadStats(200, 5.2f, 3.2f, HarvestLevels.IRON);
        Resources.starmetal.builder.setHandleStats(0.9f, 70);
        Resources.starmetal.builder.setExtraStats(50);
        Resources.starmetal.builder.setBowStats(3.0f, 3f, 3f);
    }
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        Resources.starmetal.registerFluid();
        if(ConfigMaterials.starmetal)
        {
            Resources.starmetal.builder.addCommonItems("AstralStarmetal");
            Resources.starmetal.builder.addIngot("dustAstralStarmetal");
            Resources.starmetal.builder.preInit("AstralStarmetal", FluidRegistry.getFluid("starmetal"));
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.starmetal.builder, 1f);
            }
            Resources.materials.add(Resources.starmetal);
        }
    }
    @Override
    public void init(FMLInitializationEvent e) {

    }
    @Override
    public void postInit(FMLPostInitializationEvent e) { }
}