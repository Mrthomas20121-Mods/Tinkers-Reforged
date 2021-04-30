package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.tinkers_reforged.ReforgedTraits;
import mrthomas20121.tinkers_reforged.compat.ASCompat;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.library.module.ModuleReforgedBase;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.utils.HarvestLevels;

public class MaterialsAS extends ModuleReforgedBase {

    Material starmetal = new Material("ref_starmetal", 0x001169);

    @Override
    public boolean canLoad() {
        return TinkersReforgedConfig.SettingMaterials.modules.astralsorcery;
    }

    @Override
    public void preInit() {
        if(TinkersReforgedConfig.SettingMaterials.materials.starmetal) {
            starmetal.addTrait(ReforgedTraits.astralInfusion);
            TinkerRegistry.addMaterial(starmetal);
            TinkerRegistry.addMaterialStats(starmetal,
                    new HeadMaterialStats(200, 5.2f, 3.2f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(0.85f, 60),
                    new ExtraMaterialStats(50),
                    new BowMaterialStats(0.9f, 1.5f, 7f));
        }
    }

    @Override
    public void init() {

        if(TinkersReforgedConfig.SettingMaterials.materials.starmetal) {
            starmetal.setCraftable(false).setCastable(false);
            starmetal.setRepresentativeItem("ingotAstralStarmetal");
            starmetal.addItem("ingotAstralStarmetal", 1, Material.VALUE_Ingot);
        }
    }

    @Override
    public void registerRecipes(IForgeRegistry<IRecipe> r) {
        if(TinkersReforgedConfig.SettingMaterials.materials.starmetal) {
            for(IToolPart part : TinkerRegistry.getToolParts())
            {
                if(part.canUseMaterial(starmetal) && part.canBeCasted() || part.canBeCrafted())
                {
                    ASCompat.addInfusionRecipe(part.getItemstackWithMaterial(starmetal), part.getItemstackWithMaterial(TinkerRegistry.getMaterial(TinkersReforgedConfig.SettingGeneral.mods.starmetal.material)));
                }
            }
        }
    }
}
