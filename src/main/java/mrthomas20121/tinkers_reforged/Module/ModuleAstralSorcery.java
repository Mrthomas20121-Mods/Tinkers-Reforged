package mrthomas20121.tinkers_reforged.Module;

import mrthomas20121.biolib.common.MaterialBuilder;
//import com.mrthomas20121.libs.SmelteryUtils;
import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.Config.Config;
import mrthomas20121.tinkers_reforged.Traits.Traits;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleAstralSorcery implements ModuleBase {

    public MaterialBuilder starmetal = new MaterialBuilder(Materials.starmetal);

    public ModuleAstralSorcery() {
        starmetal.setCraftable(false).setCastable(true);
        starmetal.setTrait(Traits.astral, MaterialTypes.HEAD);
        starmetal.setTrait(TinkerTraits.alien);
        starmetal.setHeadStats(200, 5.2f, 3.2f, HarvestLevels.IRON);
        starmetal.setHandleStats(0.9f, 70);
        starmetal.setExtraStats(50);
        starmetal.setBowStats(3.0f, 3f, 3f);
    }
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        if(Config.starmetal) {
            starmetal.addCommonItems("AstralStarmetal");
            starmetal.addIngot("ingotAstralStarmetal");
            starmetal.addIngot("dustAstralStarmetal");
            starmetal.preInit("AstralStarmetal", FluidRegistry.getFluid("starmetal"));
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(starmetal, 1f);
            }
            Materials.mats.add(starmetal.getMat());
        }
    }
    @Override
    public void init(FMLInitializationEvent e) {
        starmetal.setCastable(true).setCraftable(false);
    }
    @Override
    public void postInit(FMLPostInitializationEvent e) { }
}