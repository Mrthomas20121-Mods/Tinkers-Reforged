package mrthomas20121.tinkers_reforged.modules;

import epicsquid.roots.init.ModRecipes;
import epicsquid.roots.recipe.FeyCraftingRecipe;
import mrthomas20121.tinkers_reforged.ReforgedTraits;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.compat.RootsCompat;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.library.module.ModuleReforgedBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.tinkering.MaterialItem;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerMaterials;

public class MaterialsRoots extends ModuleReforgedBase {

    private Material runestone = new Material("ref_runestone", 0x71717F);

    @Override
    public boolean canLoad() {
        return TinkersReforgedConfig.SettingMaterials.modules.roots;
    }

    @Override
    public void preInit() {

        if(TinkersReforgedConfig.SettingMaterials.materials.runestone) {
            runestone.addTrait(ReforgedTraits.fey, MaterialTypes.HEAD);
            TinkerRegistry.addMaterial(runestone);
            TinkerRegistry.addMaterialStats(runestone,
                    new HeadMaterialStats(290, 5.5f, 3f, HarvestLevels.IRON),
                    new HandleMaterialStats(1f, 20),
                    new ExtraMaterialStats(-2),
                    new ArrowShaftMaterialStats(1.2f, 2),
                    new BowStringMaterialStats(1.2f));
        }
    }

    @Override
    public void init() {

        if(TinkersReforgedConfig.SettingMaterials.materials.runestone) {
            runestone.setRepresentativeItem("runestone");
            runestone.addItem("runestone", 1, Material.VALUE_Ingot);

            for (IToolPart part : TinkerRegistry.getToolParts()) {
                if(part.canUseMaterial(runestone) && TinkersReforgedConfig.SettingMaterials.materials.runestone) {
                    RootsCompat.addRunestoneFeyCrafting("runestone_toolpart_"+ ((MaterialItem) part).getRegistryName(), part.getItemstackWithMaterial(runestone), part.getItemstackWithMaterial(TinkerMaterials.stone));
                }
            }
        }
    }

}
