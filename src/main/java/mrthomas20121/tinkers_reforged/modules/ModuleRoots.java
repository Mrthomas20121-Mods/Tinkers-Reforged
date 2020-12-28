package mrthomas20121.tinkers_reforged.modules;

import epicsquid.roots.init.ModRecipes;
import epicsquid.roots.recipe.FeyCraftingRecipe;
import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.ReforgedTraits;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.trait.TraitFey;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.tinkering.MaterialItem;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerMaterials;

public class ModuleRoots implements ModuleBase {

    Material runestone = new Material("ref_runestone", 0x71717F);

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {

        if(TinkersReforgedConfig.SettingMaterials.materials.runestone) {
            runestone.addTrait(ReforgedTraits.fey);
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
    public void init(FMLInitializationEvent fmlInitializationEvent) {
        runestone.setRepresentativeItem("runestone");
        runestone.addItem("runestone", 1, Material.VALUE_Ingot);

        for (IToolPart part : TinkerRegistry.getToolParts()) {
            if(part.canUseMaterial(runestone) && TinkersReforgedConfig.SettingMaterials.materials.runestone)
            {
                FeyCraftingRecipe recipe = new FeyCraftingRecipe(part.getItemstackWithMaterial(runestone));
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

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
