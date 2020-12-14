package mrthomas20121.tinkers_reforged.modules;

import hellfirepvp.astralsorcery.common.crafting.infusion.InfusionRecipeRegistry;
import hellfirepvp.astralsorcery.common.crafting.infusion.recipes.BasicInfusionRecipe;
import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.trait.TraitAstralInfusion;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.utils.HarvestLevels;

public class ModuleAS implements ModuleBase {

    Material starmetal = new Material("ref_starmetal", 0x001169);

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {
        starmetal.addTrait(new TraitAstralInfusion());
        TinkerRegistry.addMaterial(starmetal);
        TinkerRegistry.addMaterialStats(starmetal,
                new HeadMaterialStats(200, 5.2f, 3.2f, HarvestLevels.DIAMOND),
                new HandleMaterialStats(0.85f, 60),
                new ExtraMaterialStats(50),
                new BowMaterialStats(0.9f, 1.5f, 7f));
    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {
        for(IToolPart part : TinkerRegistry.getToolParts())
        {
            if(part.canUseMaterial(starmetal) && TinkersReforgedConfig.SettingMaterials.containMaterials(starmetal.getIdentifier()))
            {
                InfusionRecipeRegistry.recipes.add(new BasicInfusionRecipe(part.getItemstackWithMaterial(starmetal), part.getItemstackWithMaterial(TinkerRegistry.getMaterial(TinkersReforgedConfig.SettingGeneral.materialStarmetal))));
            }
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
