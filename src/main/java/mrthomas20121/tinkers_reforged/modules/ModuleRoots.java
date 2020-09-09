package mrthomas20121.tinkers_reforged.modules;

import epicsquid.roots.recipe.FeyCraftingRecipe;
import mrthomas20121.biolib.common.MaterialBuilder;
import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.config.Config;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.Traits.Traits;
import mrthomas20121.tinkers_reforged.config.ConfigMaterials;
import mrthomas20121.tinkers_reforged.resources.Resources;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.tinkering.MaterialItem;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerMaterials;
import slimeknights.tconstruct.tools.TinkerTraits;
import epicsquid.roots.init.ModRecipes;

public class ModuleRoots implements ModuleBase {

    public ModuleRoots() {
        Resources.runestone.builder.setHeadStats(280, 5.5f, 3f, HarvestLevels.STONE);
        Resources.runestone.builder.setHandleStats(1f, 100);
        Resources.runestone.builder.setExtraStats(-10);
        Resources.runestone.builder.setTrait(TinkerTraits.cheap, MaterialTypes.HEAD);
        Resources.runestone.builder.setTrait(Traits.fey);
    }

    public void preInit(FMLPreInitializationEvent e) {
        if(ConfigMaterials.runestone) {
            Resources.runestone.builder.preInit("runestone");
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.runestone.builder, 0);
            }
            Resources.materials.add(Resources.runestone);
        }
    }
    public void init(FMLInitializationEvent e) {
        Resources.runestone.builder.setRepresentativeItem("runestone");

        for (IToolPart part : TinkerRegistry.getToolParts()) {
            if(part.canUseMaterial(Resources.runestone.builder.getMat()))
            {
                FeyCraftingRecipe recipe = new FeyCraftingRecipe(part.getItemstackWithMaterial(Resources.runestone.builder.getMat()));
                recipe.addIngredients(
                        new ItemStack(Items.DYE, 1, 4),
                        part.getItemstackWithMaterial(TinkerMaterials.stone),
                        new ItemStack(Blocks.STONE, 1),
                        new ItemStack(Blocks.STONE, 1),
                        new ItemStack(Blocks.STONE, 1)
                );
                ModRecipes.addFeyCraftingRecipe(new ResourceLocation(TinkersReforged.MODID, "runestone_toolpart_"+ ((MaterialItem) part).getRegistryName()), recipe);
            }
        }
    }
    public void postInit(FMLPostInitializationEvent e) {

    }
}
