package mrthomas20121.tinkers_reforged.datagen.tcon;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.datagen.ReforgedByproduct;
import mrthomas20121.tinkers_reforged.init.*;
import mrthomas20121.tinkers_reforged.item.CastObject;
import net.minecraft.data.*;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.CompoundIngredient;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.common.crafting.conditions.NotCondition;
import net.minecraftforge.common.crafting.conditions.TagEmptyCondition;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.recipe.helper.ItemOutput;
import slimeknights.mantle.recipe.ingredient.EntityIngredient;
import slimeknights.mantle.recipe.ingredient.FluidIngredient;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.data.recipe.*;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.materials.definition.MaterialVariantId;
import slimeknights.tconstruct.library.recipe.FluidValues;
import slimeknights.tconstruct.library.recipe.alloying.AlloyRecipeBuilder;
import slimeknights.tconstruct.library.recipe.casting.ItemCastingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.casting.material.CompositeCastingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.casting.material.MaterialCastingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.entitymelting.EntityMeltingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.fuel.MeltingFuelBuilder;
import slimeknights.tconstruct.library.recipe.ingredient.MaterialIngredient;
import slimeknights.tconstruct.library.recipe.melting.MeltingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.modifiers.adding.SwappableModifierRecipeBuilder;
import slimeknights.tconstruct.library.recipe.molding.MoldingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.partbuilder.PartRecipeBuilder;
import slimeknights.tconstruct.library.tools.part.IMaterialItem;
import slimeknights.tconstruct.shared.TinkerMaterials;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;
import slimeknights.tconstruct.smeltery.data.Byproduct;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.TinkerToolParts;
import slimeknights.tconstruct.tools.TinkerTools;
import slimeknights.tconstruct.tools.data.material.MaterialIds;
import slimeknights.tconstruct.world.TinkerWorld;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ReforgedRecipes extends RecipeProvider implements IConditionBuilder, IMaterialRecipeHelper, IToolRecipeHelper, ISmelteryRecipeHelper, ICommonRecipeHelper {

    public ReforgedRecipes(DataGenerator gen) {
        super(gen);
    }

    public void craftingRecipes(Consumer<FinishedRecipe> consumer) {

        blockIngotNuggetCompression(consumer, "aluminum", TinkersReforgedBlocks.aluminum_block.get().asItem(), TinkersReforgedItems.aluminum_ingot.get(), TinkersReforgedItems.aluminum_nugget.get());
        blockIngotNuggetCompression(consumer, "duralumin", TinkersReforgedBlocks.duralumin_block.get().asItem(), TinkersReforgedItems.duralumin_ingot.get(), TinkersReforgedItems.duralumin_nugget.get());
        blockIngotNuggetCompression(consumer, "electrical_copper", TinkersReforgedBlocks.electrical_copper_block.get().asItem(), TinkersReforgedItems.electrical_copper_ingot.get(), TinkersReforgedItems.electrical_copper_nugget.get());
        blockIngotNuggetCompression(consumer, "lavium", TinkersReforgedBlocks.lavium_block.get().asItem(), TinkersReforgedItems.lavium_ingot.get(), TinkersReforgedItems.lavium_nugget.get());
        blockIngotNuggetCompression(consumer, "qivium", TinkersReforgedBlocks.qivium_block.get().asItem(), TinkersReforgedItems.qivium_ingot.get(), TinkersReforgedItems.qivium_nugget.get());
        blockIngotNuggetCompression(consumer, "gausum", TinkersReforgedBlocks.gausum_block.get().asItem(), TinkersReforgedItems.gausum_ingot.get(), TinkersReforgedItems.gausum_nugget.get());
        blockIngotNuggetCompression(consumer, "felsteel", TinkersReforgedBlocks.felsteel_block.get().asItem(), TinkersReforgedItems.felsteel_ingot.get(), TinkersReforgedItems.felsteel_nugget.get());
        blockIngotNuggetCompression(consumer, "kepu", TinkersReforgedBlocks.kepu_block.get().asItem(), TinkersReforgedItems.kepu_ingot.get(), TinkersReforgedItems.kepu_nugget.get());
        blockIngotNuggetCompression(consumer, "chorus_metal", TinkersReforgedBlocks.chorus_metal_block.get().asItem(), TinkersReforgedItems.chorus_metal_ingot.get(), TinkersReforgedItems.chorus_metal_nugget.get());
        blockIngotNuggetCompression(consumer, "durasteel", TinkersReforgedBlocks.durasteel_block.get().asItem(), TinkersReforgedItems.durasteel_ingot.get(), TinkersReforgedItems.durasteel_nugget.get());
        blockIngotNuggetCompression(consumer, "crusteel", TinkersReforgedBlocks.crusteel_block.get().asItem(), TinkersReforgedItems.crusteel_ingot.get(), TinkersReforgedItems.crusteel_nugget.get());
        blockIngotNuggetCompression(consumer, "wavy", TinkersReforgedBlocks.wavy_block.get().asItem(), TinkersReforgedItems.wavy_ingot.get(), TinkersReforgedItems.wavy_nugget.get());
        blockIngotNuggetCompression(consumer, "yokel", TinkersReforgedBlocks.yokel_block.get().asItem(), TinkersReforgedItems.yokel_ingot.get(), TinkersReforgedItems.yokel_nugget.get());
        blockIngotNuggetCompression(consumer, "baolian", TinkersReforgedBlocks.baolian_block.get().asItem(), TinkersReforgedItems.baolian_ingot.get(), TinkersReforgedItems.baolian_nugget.get());
        blockIngotNuggetCompression(consumer, "galu", TinkersReforgedBlocks.galu_block.get().asItem(), TinkersReforgedItems.galu_ingot.get(), TinkersReforgedItems.galu_nugget.get());
        blockIngotNuggetCompression(consumer, "magma_steel", TinkersReforgedBlocks.magma_steel_block.get().asItem(), TinkersReforgedItems.magma_steel_ingot.get(), TinkersReforgedItems.magma_steel_nugget.get());
        blockIngotNuggetCompression(consumer, "cyber_steel", TinkersReforgedBlocks.cyber_steel_block.get().asItem(), TinkersReforgedItems.cyber_steel_ingot.get(), TinkersReforgedItems.cyber_steel_nugget.get());

        gemBlock(consumer, "epidote", TinkersReforgedItems.epidote_block.get(), TinkersReforgedItems.epidote_gem.get());
        gemBlock(consumer, "hureaulite", TinkersReforgedItems.hureaulite_block.get(), TinkersReforgedItems.hureaulite_gem.get());
        gemBlock(consumer, "red_beryl", TinkersReforgedItems.red_beryl_block.get(), TinkersReforgedItems.red_beryl_gem.get());
    }

    public void alloyRecipes(Consumer<FinishedRecipe> consumer) {
        String alloyFolder = "smeltery/alloy/";

        AlloyRecipeBuilder.alloy(TinkersReforgedFluids.magma_steel.get(), FluidValues.INGOT)
                .addInput(TinkerFluids.moltenIron.get(), FluidValues.INGOT*2)
                .addInput(TinkerFluids.magma.get(), FluidValues.SLIMEBALL)
                .addInput(TinkersReforgedFluids.coal.get(), FluidValues.SLIMEBALL)
                .save(consumer, modResource(alloyFolder+"magma_steel"));

        AlloyRecipeBuilder.alloy(TinkersReforgedFluids.cyber_steel.get(), FluidValues.INGOT)
                .addInput(TinkersReforgedFluids.chorus_metal.get(), FluidValues.INGOT*2)
                .addInput(TinkerFluids.magma.get(), FluidValues.SLIMEBALL)
                .addInput(TinkersReforgedFluids.coal.get(), FluidValues.SLIMEBALL)
                .save(consumer, modResource(alloyFolder+"cyber_steel"));

        AlloyRecipeBuilder.alloy(TinkersReforgedFluids.baolian.get(), FluidValues.INGOT*2)
                .addInput(TinkerFluids.moltenObsidian.get(), FluidValues.GLASS_BLOCK)
                .addInput(TinkersReforgedFluids.red_beryl.get(), FluidValues.INGOT)
                .addInput(TinkersReforgedFluids.epidote.get(), FluidValues.INGOT)
                .save(consumer, modResource(alloyFolder+"baolian"));

        AlloyRecipeBuilder.alloy(TinkersReforgedFluids.galu.get(), FluidValues.INGOT*2)
                .addInput(TinkerFluids.moltenObsidian.get(), FluidValues.GLASS_BLOCK)
                .addInput(TinkersReforgedFluids.red_beryl.get(), FluidValues.INGOT)
                .addInput(TinkersReforgedFluids.hureaulite.get(), FluidValues.INGOT)
                .save(consumer, modResource(alloyFolder+"galu"));

        AlloyRecipeBuilder.alloy(TinkersReforgedFluids.duralumin.get(), FluidValues.INGOT*5)
                .addInput(TinkerFluids.moltenCopper.get(), FluidValues.INGOT)
                .addInput(TinkerFluids.moltenAluminum.get(), FluidValues.METAL_BLOCK)
                .save(consumer, modResource(alloyFolder+"duralumin"));

        AlloyRecipeBuilder.alloy(TinkersReforgedFluids.blazing_copper.get(), FluidValues.METAL_BLOCK)
                .addInput(TinkerFluids.moltenCopper.get(), FluidValues.METAL_BLOCK)
                .addInput(TinkerFluids.blazingBlood.get(), FluidValues.GLASS_BLOCK)
                .save(consumer, modResource(alloyFolder+"blazing_copper"));

        AlloyRecipeBuilder.alloy(TinkersReforgedFluids.electrical_copper.get(), FluidValues.INGOT*2)
                .addInput(TinkersReforgedFluids.blazing_copper.get(), FluidValues.INGOT*2)
                .addInput(TinkersReforgedFluids.redstone.get(), FluidValues.GLASS_BLOCK)
                .save(consumer, modResource(alloyFolder+"electrical_copper"));

        AlloyRecipeBuilder.alloy(TinkersReforgedFluids.gausum.get(), FluidValues.INGOT*2)
                .addInput(TinkersReforgedFluids.blazing_copper.get(), FluidValues.INGOT*2)
                .addInput(TinkerFluids.moltenDebris.get(), FluidValues.INGOT*2)
                .addInput(TinkersReforgedFluids.lapis.get(), FluidValues.METAL_BLOCK)
                .save(consumer, modResource(alloyFolder+"gausum"));

        AlloyRecipeBuilder.alloy(TinkersReforgedFluids.felsteel.get(), FluidValues.INGOT*3)
                .addInput(TinkersReforgedFluids.blazing_copper.get(), FluidValues.INGOT*2)
                .addInput(TinkerFluids.moltenDebris.get(), FluidValues.INGOT*2)
                .addInput(TinkersReforgedFluids.duralumin.get(), FluidValues.INGOT*2)
                .save(consumer, modResource(alloyFolder+"felsteel"));

        AlloyRecipeBuilder.alloy(TinkersReforgedFluids.chorus_metal.get(), FluidValues.INGOT*2)
                .addInput(TinkersReforgedFluids.kepu.get(), FluidValues.INGOT)
                .addInput(TinkersReforgedFluids.chorus.get(), FluidValues.INGOT)
                .addInput(TinkersReforgedFluids.shulker.get(), FluidValues.INGOT)
                .save(consumer, modResource(alloyFolder+"chorus_metal"));

        AlloyRecipeBuilder.alloy(TinkersReforgedFluids.durasteel.get(), FluidValues.INGOT)
                .addInput(TinkerFluids.moltenEnder.get(), FluidValues.SLIMEBALL)
                .addInput(TinkerFluids.moltenAluminum.get(), FluidValues.INGOT)
                .addInput(TinkerFluids.moltenDebris.get(), FluidValues.INGOT)
                .save(consumer, modResource(alloyFolder+"durasteel"));

        AlloyRecipeBuilder.alloy(TinkersReforgedFluids.proto_lava.get(), FluidValues.GLASS_BLOCK)
                .addInput(TinkerFluids.moltenEnder.get(), FluidValues.SLIMEBALL)
                .addInput(TinkersReforgedFluids.chorus.get(), FluidValues.INGOT)
                .addInput(FluidTags.LAVA, FluidValues.GLASS_BLOCK)
                .save(consumer, modResource(alloyFolder+"proto_lava"));

        AlloyRecipeBuilder.alloy(TinkersReforgedFluids.yokel.get(), FluidValues.INGOT*2)
                .addInput(TinkersReforgedFluids.kelp.get(), FluidValues.SLIMEBALL)
                .addInput(TinkerFluids.moltenAluminum.get(), FluidValues.INGOT)
                .addInput(TinkerFluids.moltenIron.get(), FluidValues.INGOT)
                .save(consumer, modResource(alloyFolder+"yokel"));

        AlloyRecipeBuilder.alloy(TinkersReforgedFluids.crusteel.get(), FluidValues.INGOT*3)
                .addInput(TinkerFluids.moltenCopper.get(), FluidValues.INGOT)
                .addInput(TinkerFluids.moltenDebris.get(), FluidValues.INGOT)
                .addInput(TinkerFluids.moltenAmethyst.get(), FluidValues.INGOT)
                .save(consumer, modResource(alloyFolder+"crusteel"));
    }

    @Override
    protected void buildCraftingRecipes(@Nonnull Consumer<FinishedRecipe> consumer) {

        String materialFolder = "materials/";
        String meltingFolder = "smeltery/melting/";
        String castingFolder = "smeltery/casting/";
        String castFolder = "smeltery/casts/";
        String toolFolder = "tools/building/";
        String partFolder = "tools/parts/";
        String slotless = "tools/modifiers/slotless/";

        this.alloyRecipes(consumer);
        this.craftingRecipes(consumer);

        metalCasting(consumer, TinkersReforgedFluids.duralumin, TinkersReforgedBlocks.duralumin_block.get(), TinkersReforgedItems.duralumin_ingot.get(), TinkersReforgedItems.duralumin_nugget.get(), castingFolder, "duralumin");
        metalCasting(consumer, TinkersReforgedFluids.electrical_copper, TinkersReforgedBlocks.electrical_copper_block.get(), TinkersReforgedItems.electrical_copper_ingot.get(), TinkersReforgedItems.electrical_copper_nugget.get(), castingFolder, "electrical_copper");
        metalCasting(consumer, TinkersReforgedFluids.lavium, TinkersReforgedBlocks.lavium_block.get(), TinkersReforgedItems.lavium_ingot.get(), TinkersReforgedItems.lavium_nugget.get(), castingFolder, "lavium");
        metalCasting(consumer, TinkersReforgedFluids.qivium, TinkersReforgedBlocks.qivium_block.get(), TinkersReforgedItems.qivium_ingot.get(), TinkersReforgedItems.qivium_nugget.get(), castingFolder, "qivium");
        metalCasting(consumer, TinkersReforgedFluids.gausum, TinkersReforgedBlocks.gausum_block.get(), TinkersReforgedItems.gausum_ingot.get(), TinkersReforgedItems.gausum_nugget.get(), castingFolder, "gausum");
        metalCasting(consumer, TinkersReforgedFluids.felsteel, TinkersReforgedBlocks.felsteel_block.get(), TinkersReforgedItems.felsteel_ingot.get(), TinkersReforgedItems.felsteel_nugget.get(), castingFolder, "felsteel");
        metalCasting(consumer, TinkersReforgedFluids.kepu, TinkersReforgedBlocks.kepu_block.get(), TinkersReforgedItems.kepu_ingot.get(), TinkersReforgedItems.kepu_nugget.get(), castingFolder, "kepu");
        metalCasting(consumer, TinkersReforgedFluids.chorus_metal, TinkersReforgedBlocks.chorus_metal_block.get(), TinkersReforgedItems.chorus_metal_ingot.get(), TinkersReforgedItems.chorus_metal_nugget.get(), castingFolder, "chorus_metal");
        metalCasting(consumer, TinkersReforgedFluids.durasteel, TinkersReforgedBlocks.durasteel_block.get(), TinkersReforgedItems.durasteel_ingot.get(), TinkersReforgedItems.durasteel_nugget.get(), castingFolder, "durasteel");
        metalCasting(consumer, TinkersReforgedFluids.crusteel, TinkersReforgedBlocks.crusteel_block.get(), TinkersReforgedItems.crusteel_ingot.get(), TinkersReforgedItems.crusteel_nugget.get(), castingFolder, "crusteel");
        metalCasting(consumer, TinkersReforgedFluids.wavy, TinkersReforgedBlocks.wavy_block.get(), TinkersReforgedItems.wavy_ingot.get(), TinkersReforgedItems.wavy_nugget.get(), castingFolder, "wavy");
        metalCasting(consumer, TinkersReforgedFluids.yokel, TinkersReforgedBlocks.yokel_block.get(), TinkersReforgedItems.yokel_ingot.get(), TinkersReforgedItems.yokel_nugget.get(), castingFolder, "yokel");
        metalCasting(consumer, TinkersReforgedFluids.baolian, TinkersReforgedBlocks.baolian_block.get(), TinkersReforgedItems.baolian_ingot.get(), TinkersReforgedItems.baolian_nugget.get(), castingFolder, "baolian");
        metalCasting(consumer, TinkersReforgedFluids.galu, TinkersReforgedBlocks.galu_block.get(), TinkersReforgedItems.galu_ingot.get(), TinkersReforgedItems.galu_nugget.get(), castingFolder, "galu");
        metalCasting(consumer, TinkersReforgedFluids.blazing_copper, TinkersReforgedBlocks.blazing_copper_block.get(), TinkersReforgedItems.blazing_copper_ingot.get(), TinkersReforgedItems.blazing_copper_nugget.get(), castingFolder, "blazing_copper");
        metalCasting(consumer, TinkersReforgedFluids.magma_steel, TinkersReforgedBlocks.magma_steel_block.get(), TinkersReforgedItems.magma_steel_ingot.get(), TinkersReforgedItems.magma_steel_nugget.get(), castingFolder, "magma_steel");
        metalCasting(consumer, TinkersReforgedFluids.cyber_steel, TinkersReforgedBlocks.cyber_steel_block.get(), TinkersReforgedItems.cyber_steel_ingot.get(), TinkersReforgedItems.cyber_steel_nugget.get(), castingFolder, "cyber_steel");

        materialMeltingCasting(consumer, ReforgedMaterialIds.aluminum, TinkerFluids.moltenAluminum, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterialIds.blazing_copper, TinkersReforgedFluids.blazing_copper, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterialIds.duralumin, TinkersReforgedFluids.duralumin, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterialIds.electrical_copper, TinkersReforgedFluids.electrical_copper, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterialIds.lavium, TinkersReforgedFluids.lavium, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterialIds.qivium, TinkersReforgedFluids.qivium, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterialIds.gausum, TinkersReforgedFluids.gausum, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterialIds.felsteel, TinkersReforgedFluids.felsteel, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterialIds.chorus_metal, TinkersReforgedFluids.chorus_metal, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterialIds.kepu, TinkersReforgedFluids.kepu, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterialIds.magma_steel, TinkersReforgedFluids.magma_steel, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterialIds.cyber_steel, TinkersReforgedFluids.cyber_steel, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterialIds.durasteel, TinkersReforgedFluids.durasteel, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterialIds.crusteel, TinkersReforgedFluids.crusteel, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterialIds.wavy, TinkersReforgedFluids.wavy, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterialIds.yokel, TinkersReforgedFluids.yokel, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterialIds.baolian, TinkersReforgedFluids.baolian, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterialIds.epidote, TinkersReforgedFluids.epidote, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterialIds.galu, TinkersReforgedFluids.galu, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterialIds.hureaulite, TinkersReforgedFluids.hureaulite, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterialIds.red_beryl, TinkersReforgedFluids.red_beryl, materialFolder);

        metalMelting(consumer, TinkersReforgedFluids.duralumin.get(), "duralumin", false, meltingFolder, false);
        metalMelting(consumer, TinkersReforgedFluids.electrical_copper.get(), "electrical_copper", false, meltingFolder, false);
        metalMelting(consumer, TinkersReforgedFluids.lavium.get(), "lavium", false, meltingFolder, false);
        metalMelting(consumer, TinkersReforgedFluids.qivium.get(), "qivium", false, meltingFolder, false);
        metalMelting(consumer, TinkersReforgedFluids.gausum.get(), "gausum", false, meltingFolder, false);
        metalMelting(consumer, TinkersReforgedFluids.felsteel.get(), "felsteel", false, meltingFolder, false, ReforgedByproduct.BLAZING_BLOOD);
        metalMelting(consumer, TinkersReforgedFluids.kepu.get(), "kepu", true, meltingFolder, false, ReforgedByproduct.ENDER);
        metalMelting(consumer, TinkersReforgedFluids.chorus_metal.get(), "chorus_metal", false, meltingFolder, false);
        metalMelting(consumer, TinkersReforgedFluids.crusteel.get(), "crusteel", false, meltingFolder, false);
        metalMelting(consumer, TinkersReforgedFluids.wavy.get(), "wavy", false, meltingFolder, false);
        metalMelting(consumer, TinkersReforgedFluids.yokel.get(), "yokel", false, meltingFolder, false);
        metalMelting(consumer, TinkersReforgedFluids.baolian.get(), "baolian", false, meltingFolder, false);
        metalMelting(consumer, TinkersReforgedFluids.galu.get(), "galu", false, meltingFolder, false);
        metalMelting(consumer, TinkersReforgedFluids.blazing_copper.get(), "blazing_copper", false, meltingFolder, false);
        metalMelting(consumer, TinkersReforgedFluids.magma_steel.get(), "magma_steel", false, meltingFolder, false);
        metalMelting(consumer, TinkersReforgedFluids.cyber_steel.get(), "cyber_steel", false, meltingFolder, false);

        metalMaterialRecipe(consumer, ReforgedMaterialIds.aluminum, materialFolder, "aluminum", false);
        metalMaterialRecipe(consumer, ReforgedMaterialIds.blazing_copper, materialFolder, "blazing_copper", false);
        metalMaterialRecipe(consumer, ReforgedMaterialIds.gausum, materialFolder, "gausum", false);
        metalMaterialRecipe(consumer, ReforgedMaterialIds.duralumin, materialFolder, "duralumin", false);
        metalMaterialRecipe(consumer, ReforgedMaterialIds.electrical_copper, materialFolder, "electrical_copper", false);
        metalMaterialRecipe(consumer, ReforgedMaterialIds.lavium, materialFolder, "lavium", false);
        metalMaterialRecipe(consumer, ReforgedMaterialIds.qivium, materialFolder, "qivium", false);
        metalMaterialRecipe(consumer, ReforgedMaterialIds.felsteel, materialFolder, "felsteel", false);
        metalMaterialRecipe(consumer, ReforgedMaterialIds.chorus_metal, materialFolder, "chorus_metal", false);
        metalMaterialRecipe(consumer, ReforgedMaterialIds.kepu, materialFolder, "kepu", false);
        metalMaterialRecipe(consumer, ReforgedMaterialIds.magma_steel, materialFolder, "magma_steel", false);
        metalMaterialRecipe(consumer, ReforgedMaterialIds.cyber_steel, materialFolder, "cyber_steel", false);
        metalMaterialRecipe(consumer, ReforgedMaterialIds.durasteel, materialFolder, "durasteel", false);
        metalMaterialRecipe(consumer, ReforgedMaterialIds.crusteel, materialFolder, "crusteel", false);
        metalMaterialRecipe(consumer, ReforgedMaterialIds.wavy, materialFolder, "wavy", false);
        metalMaterialRecipe(consumer, ReforgedMaterialIds.yokel, materialFolder, "yokel", false);
        metalMaterialRecipe(consumer, ReforgedMaterialIds.baolian, materialFolder, "baolian", false);
        metalMaterialRecipe(consumer, ReforgedMaterialIds.galu, materialFolder, "galu", false);
        gemMaterialRecipe(consumer, ReforgedMaterialIds.epidote, materialFolder, "epidote");
        gemMaterialRecipe(consumer, ReforgedMaterialIds.hureaulite, materialFolder, "hureaulite");
        gemMaterialRecipe(consumer, ReforgedMaterialIds.red_beryl, materialFolder, "red_beryl");
        materialRecipe(consumer, ReforgedMaterialIds.ender_bone, Ingredient.of(TinkersReforgedItems.ender_bone.get()), 1, 1, materialFolder + "ender_bone");

        Ingredient plate = Ingredient.of(TinkerTools.plateArmor.values().stream().map(ItemStack::new));

        // embellishment
        plateTexture(consumer, plate, ReforgedMaterialIds.gausum, false, slotless);
        plateTexture(consumer, plate, ReforgedMaterialIds.duralumin, false, slotless);
        plateTexture(consumer, plate, ReforgedMaterialIds.electrical_copper, false, slotless);
        plateTexture(consumer, plate, ReforgedMaterialIds.lavium, false, slotless);
        plateTexture(consumer, plate, ReforgedMaterialIds.qivium, false, slotless);
        plateTexture(consumer, plate, ReforgedMaterialIds.felsteel, false, slotless);
        plateTexture(consumer, plate, ReforgedMaterialIds.chorus_metal, false, slotless);
        plateTexture(consumer, plate, ReforgedMaterialIds.kepu, false, slotless);
        plateTexture(consumer, plate, ReforgedMaterialIds.blazing_copper, false, slotless);
        plateTexture(consumer, plate, ReforgedMaterialIds.aluminum, false, slotless);
        plateTexture(consumer, plate, ReforgedMaterialIds.magma_steel, false, slotless);
        plateTexture(consumer, plate, ReforgedMaterialIds.cyber_steel, false, slotless);
        plateTexture(consumer, plate, ReforgedMaterialIds.durasteel, false, slotless);
        plateTexture(consumer, plate, ReforgedMaterialIds.crusteel, false, slotless);
        plateTexture(consumer, plate, ReforgedMaterialIds.wavy, false, slotless);
        plateTexture(consumer, plate, ReforgedMaterialIds.yokel, false, slotless);
        plateTexture(consumer, plate, ReforgedMaterialIds.baolian, false, slotless);
        plateTexture(consumer, plate, ReforgedMaterialIds.epidote, false, slotless);
        plateTexture(consumer, plate, ReforgedMaterialIds.galu, false, slotless);
        plateTexture(consumer, plate, ReforgedMaterialIds.hureaulite, false, slotless);
        plateTexture(consumer, plate, ReforgedMaterialIds.red_beryl, false, slotless);
        plateTexture(consumer, plate, ReforgedMaterialIds.ender_bone, false, slotless);

        materialComposite(consumer, MaterialIds.cobalt, ReforgedMaterialIds.lavium, TinkerFluids.liquidSoul, false, 500, materialFolder+"lavium_");
        materialComposite(consumer, MaterialIds.cobalt, ReforgedMaterialIds.qivium, TinkerFluids.magma, true, 500, materialFolder+"qivium_");
        materialComposite(consumer, MaterialIds.bloodshroom, ReforgedMaterialIds.wavy, TinkerFluids.moltenObsidian, false, 500, materialFolder+"wavy_");
        metalComposite(consumer, TinkerMaterials.cobalt.getIngot(), TinkersReforgedItems.lavium_ingot.get(), TinkerFluids.liquidSoul, false, materialFolder, "lavium");
        metalComposite(consumer, TinkerMaterials.cobalt.getIngot(), TinkersReforgedItems.qivium_ingot.get(), TinkerFluids.magma, true, materialFolder, "qivium");
        metalComposite(consumer, TinkerWorld.bloodshroom.get(), TinkersReforgedItems.wavy_block.get(), TinkerFluids.moltenObsidian, false, materialFolder, "wavy_bloodshroom");
        metalComposite(consumer, Items.CRIMSON_FUNGUS, TinkersReforgedItems.wavy_ingot.get(), TinkerFluids.moltenObsidian, false, materialFolder, "wavy_crimson");
        metalComposite(consumer, Items.WARPED_FUNGUS, TinkersReforgedItems.wavy_ingot.get(), TinkerFluids.moltenObsidian, false, materialFolder, "wavy_warped");
        metalComposite(consumer, Items.REDSTONE, TinkersReforgedItems.electrical_copper_dust.get(), TinkersReforgedFluids.blazing_copper, true, materialFolder, "electrical_copper");

        MeltingRecipeBuilder.melting(Ingredient.of(Items.KELP), new FluidStack(TinkersReforgedFluids.kelp.get(), FluidValues.SLIMEBALL), 500, 30).save(consumer, new ResourceLocation(TinkersReforged.MOD_ID, "smeltery/melting/kelp"));
        MeltingRecipeBuilder.melting(Ingredient.of(ItemTags.COALS), new FluidStack(TinkersReforgedFluids.coal.get(), FluidValues.SLIMEBALL), 300, 30).save(consumer, new ResourceLocation(TinkersReforged.MOD_ID, "smeltery/melting/coal"));
        MeltingRecipeBuilder.melting(Ingredient.of(Tags.Items.STORAGE_BLOCKS_COAL), new FluidStack(TinkersReforgedFluids.coal.get(), FluidValues.SLIME_BLOCK), 300, 30).save(consumer, new ResourceLocation(TinkersReforged.MOD_ID, "smeltery/melting/coal_block"));
        MeltingRecipeBuilder.melting(Ingredient.of(Tags.Items.ORES_COAL), new FluidStack(TinkersReforgedFluids.coal.get(), (int)(FluidValues.SLIMEBALL*1.5f)), 500, 50).save(consumer, new ResourceLocation(TinkersReforged.MOD_ID, "smeltery/melting/coal_ore"));

        MeltingRecipeBuilder.melting(Ingredient.of(Items.REDSTONE), new FluidStack(TinkersReforgedFluids.redstone.get(), 100), 300, 30).save(consumer, new ResourceLocation(TinkersReforged.MOD_ID, "smeltery/melting/redstone"));
        MeltingRecipeBuilder.melting(Ingredient.of(Tags.Items.STORAGE_BLOCKS_REDSTONE), new FluidStack(TinkersReforgedFluids.redstone.get(), 900), 300, 30).save(consumer, new ResourceLocation(TinkersReforged.MOD_ID, "smeltery/melting/redstone_block"));
        MeltingRecipeBuilder.melting(Ingredient.of(Tags.Items.ORES_REDSTONE), new FluidStack(TinkersReforgedFluids.redstone.get(), 150), 500, 50).save(consumer, new ResourceLocation(TinkersReforged.MOD_ID, "smeltery/melting/redstone_ore"));

        MeltingRecipeBuilder.melting(Ingredient.of(Tags.Items.STORAGE_BLOCKS_LAPIS), TinkersReforgedFluids.lapis.get(), FluidValues.METAL_BLOCK).save(consumer, modResource(meltingFolder+"lapis_block"));
        MeltingRecipeBuilder.melting(Ingredient.of(Tags.Items.GEMS_LAPIS), TinkersReforgedFluids.lapis.get(), FluidValues.GEM).save(consumer, modResource(meltingFolder+"lapis_gem"));
        MeltingRecipeBuilder.melting(Ingredient.of(Items.SHULKER_SHELL), TinkersReforgedFluids.shulker.get(), FluidValues.INGOT/2).save(consumer, modResource(meltingFolder+"shulker_shell"));
        EntityMeltingRecipeBuilder.melting(EntityIngredient.of(EntityType.SHULKER), new FluidStack(TinkersReforgedFluids.shulker.get(), FluidValues.INGOT)).save(consumer, modResource(meltingFolder+"/entity/shulker"));

        MeltingRecipeBuilder.melting(Ingredient.of(Items.CHORUS_FLOWER), TinkersReforgedFluids.chorus.get(), FluidValues.METAL_BLOCK).save(consumer, modResource(meltingFolder+"chorus_flower"));
        MeltingRecipeBuilder.melting(Ingredient.of(Items.CHORUS_FRUIT), TinkersReforgedFluids.chorus.get(), FluidValues.INGOT).save(consumer, modResource(meltingFolder+"chorus_fruit"));
        MeltingRecipeBuilder.melting(Ingredient.of(Items.POPPED_CHORUS_FRUIT), TinkersReforgedFluids.chorus.get(), FluidValues.INGOT).save(consumer, modResource(meltingFolder+"popped_chorus_fruit"));
        ingotCasting(consumer, TinkersReforgedFluids.chorus, Items.CHORUS_FRUIT, castFolder+"chorus_fruit");

        gemMeltingCasting(consumer, Items.LAPIS_LAZULI, Blocks.LAPIS_BLOCK, TinkersReforgedFluids.lapis, "smeltery/", "lapis", Byproduct.DIAMOND);
        gemMeltingCasting(consumer, TinkersReforgedItems.epidote_gem, TinkersReforgedBlocks.epidote_block, TinkersReforgedFluids.epidote, "smeltery/", "epidote", Byproduct.AMETHYST);
        gemMeltingCasting(consumer, TinkersReforgedItems.hureaulite_gem, TinkersReforgedBlocks.hureaulite_block, TinkersReforgedFluids.hureaulite, "smeltery/", "hureaulite", Byproduct.AMETHYST);
        gemMeltingCasting(consumer, TinkersReforgedItems.red_beryl_gem, TinkersReforgedBlocks.red_beryl_block, TinkersReforgedFluids.red_beryl, "smeltery/", "red_beryl", Byproduct.AMETHYST);

        ItemCastingRecipeBuilder.tableRecipe(TinkersReforgedItems.book.get())
                .setFluidAndTime(TinkerFluids.moltenAluminum, true, FluidValues.INGOT)
                .setCast(Items.BOOK, false)
                .save(consumer, modResource(castingFolder + "book"));

        ItemCastingRecipeBuilder.tableRecipe(TinkersReforgedItems.ender_bone.get())
                .setFluidAndTime(TinkerFluids.moltenEnder, true, FluidValues.SLIMEBALL)
                .setCast(Items.BONE, false)
                .save(consumer, modResource(castingFolder + "ender_bone"));

        MeltingRecipeBuilder.melting(Ingredient.of(TinkersReforgedTags.Items.ALUMINUM_CASTS), new FluidStack(TinkerFluids.moltenAluminum.get(), FluidValues.INGOT), 700, 50).save(consumer, new ResourceLocation(TinkersReforged.MOD_ID, "smeltery/aluminum_from_cast"));

        MeltingFuelBuilder.fuel(FluidIngredient.of(new FluidStack(TinkersReforgedFluids.blazing_copper.get(), 50)), 150, 1800).save(consumer, modResource("smeltery/fuel/blazing_copper"));

        MeltingFuelBuilder.fuel(FluidIngredient.of(new FluidStack(TinkersReforgedFluids.proto_lava.get(), 50)), 100, 2500).save(consumer, modResource("smeltery/fuel/proto_lava"));

        createCast(consumer, CastType.ingot, Tags.Items.INGOTS, castFolder);
        createCast(consumer, CastType.nugget, Tags.Items.NUGGETS, castFolder);
        createCast(consumer, CastType.gem, Tags.Items.GEMS, castFolder);
        createCast(consumer, CastType.rod, Tags.Items.RODS, castFolder);

        createCast(consumer, CastType.plate, "plates", castFolder);
        createCast(consumer, CastType.gear, "gears", castFolder);
        createCast(withCondition(consumer, new NotCondition(new TagEmptyCondition("forge:coins"))), CastType.coin, "coins", castFolder);
        createCast(withCondition(consumer, new NotCondition(new TagEmptyCondition("forge:wires"))), CastType.wire, "wires", castFolder);

        createCast(consumer, CastType.broad_axe_head, TinkerToolParts.broadAxeHead.get(), castFolder);
        createCast(consumer, CastType.broad_blade, TinkerToolParts.broadBlade.get(), castFolder);
        createCast(consumer, CastType.hammer_head, TinkerToolParts.hammerHead.get(), castFolder);
        createCast(consumer, CastType.large_plate, TinkerToolParts.largePlate.get(), castFolder);
        createCast(consumer, CastType.pick_head, TinkerToolParts.pickHead.get(), castFolder);
        createCast(consumer, CastType.repair_kit, TinkerToolParts.repairKit.get(), castFolder);
        createCast(consumer, CastType.small_axe_head, TinkerToolParts.smallAxeHead.get(), castFolder);
        createCast(consumer, CastType.small_blade, TinkerToolParts.smallBlade.get(), castFolder);
        createCast(consumer, CastType.tool_binding, TinkerToolParts.toolBinding.get(), castFolder);
        createCast(consumer, CastType.tool_handle, TinkerToolParts.toolHandle.get(), castFolder);
        createCast(consumer, CastType.tough_handle, TinkerToolParts.toughHandle.get(), castFolder);

        createCast(consumer, CastType.large_round_plate, TinkersReforgedItems.LARGE_ROUND_PLATE.get(), castFolder);
        createCast(consumer, CastType.great_blade, TinkersReforgedItems.GREAT_BLADE.get(), castFolder);

        ShapedRecipeBuilder.shaped(TinkersReforgedBlocks.raw_aluminum_block.get(), 1)
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', TinkersReforgedItems.raw_aluminum.get())
                .group("")
                .unlockedBy("has_item", has(TinkersReforgedItems.raw_aluminum.get()))
                .save(consumer, modResource("raw_aluminum_block"));

        ShapedRecipeBuilder.shaped(TinkersReforgedBlocks.raw_kepu_block.get(), 1)
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', TinkersReforgedItems.raw_kepu.get())
                .group("")
                .unlockedBy("has_item", has(TinkersReforgedItems.raw_kepu.get()))
                .save(consumer, modResource("raw_kepu_block"));

        ShapelessRecipeBuilder.shapeless(TinkersReforgedItems.raw_aluminum.get(), 9)
                .requires(TinkersReforgedBlocks.raw_aluminum_block.get())
                .group("")
                .unlockedBy("has_item", has(TinkersReforgedItems.raw_aluminum.get()))
                .save(consumer, modResource("raw_aluminum"));

        ShapelessRecipeBuilder.shapeless(TinkersReforgedItems.raw_kepu.get(), 9)
                .requires(TinkersReforgedBlocks.raw_kepu_block.get())
                .group("")
                .unlockedBy("has_item", has(TinkersReforgedItems.raw_kepu.get()))
                .save(consumer, modResource("raw_kepu"));

        oreFurnace(consumer, TinkersReforgedTags.Items.ALUMINUM_ORE, TinkersReforgedItems.aluminum_ingot, "aluminum", false);
        oreFurnace(consumer, TinkersReforgedTags.Items.RAW_ALUMINUM, TinkersReforgedItems.aluminum_ingot, "aluminum", true);

        oreFurnace(consumer, TinkersReforgedTags.Items.KEPU_ORE, TinkersReforgedItems.kepu_ingot, "kepu", false);
        oreFurnace(consumer, TinkersReforgedTags.Items.RAW_KEPU, TinkersReforgedItems.kepu_ingot, "kepu", true);

        oreFurnace(consumer, TinkersReforgedTags.Items.EPIDOTE_ORE, TinkersReforgedItems.epidote_gem, "epidote", false);
        oreFurnace(consumer, TinkersReforgedTags.Items.HUREAULITE_ORE, TinkersReforgedItems.hureaulite_gem, "hureaulite", false);
        oreFurnace(consumer, TinkersReforgedTags.Items.RED_BERYL_ORE, TinkersReforgedItems.red_beryl_gem, "red_beryl", false);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.kepu_dust.get()), TinkersReforgedItems.kepu_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.kepu_ingot.get())).save(consumer, modResource("kepu_ingot_from_smelting_kepu_dust"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.aluminum_dust.get()), TinkersReforgedItems.aluminum_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.aluminum_ingot.get())).save(consumer, modResource("aluminum_ingot_from_smelting_aluminum_dust"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.duralumin_dust.get()), TinkersReforgedItems.duralumin_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.duralumin_ingot.get())).save(consumer, modResource("duralumin_ingot_from_smelting_duralumin_dust"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.lavium_dust.get()), TinkersReforgedItems.lavium_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.lavium_ingot.get())).save(consumer, modResource("lavium_ingot_from_smelting_lavium_dust"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.qivium_dust.get()), TinkersReforgedItems.qivium_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.qivium_ingot.get())).save(consumer, modResource("qivium_ingot_from_smelting_qivium_dust"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.gausum_dust.get()), TinkersReforgedItems.gausum_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.gausum_ingot.get())).save(consumer, modResource("gausum_ingot_from_smelting_gausum_dust"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.felsteel_dust.get()), TinkersReforgedItems.felsteel_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.felsteel_ingot.get())).save(consumer, modResource("felsteel_ingot_from_smelting_felsteel_dust"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.electrical_copper_dust.get()), TinkersReforgedItems.electrical_copper_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.electrical_copper_ingot.get())).save(consumer, modResource("electrical_copper_ingot_from_smelting_electrical_copper_dust"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.durasteel_dust.get()), TinkersReforgedItems.durasteel_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.durasteel_ingot.get())).save(consumer, modResource("durasteel_ingot_from_smelting_durasteel_dust"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.crusteel_dust.get()), TinkersReforgedItems.crusteel_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.crusteel_ingot.get())).save(consumer, modResource("crusteel_ingot_from_smelting_crusteel_dust"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.wavy_dust.get()), TinkersReforgedItems.wavy_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.wavy_ingot.get())).save(consumer, modResource("wavy_ingot_from_smelting_wavy_dust"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.yokel_dust.get()), TinkersReforgedItems.yokel_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.yokel_ingot.get())).save(consumer, modResource("yokel_ingot_from_smelting_yokel_dust"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.baolian_dust.get()), TinkersReforgedItems.baolian_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.baolian_ingot.get())).save(consumer, modResource("baolian_ingot_from_smelting_baolian_dust"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.galu_dust.get()), TinkersReforgedItems.galu_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.galu_ingot.get())).save(consumer, modResource("galu_ingot_from_smelting_galu_dust"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.magma_steel_dust.get()), TinkersReforgedItems.magma_steel_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.magma_steel_ingot.get())).save(consumer, modResource("magma_steel_ingot_from_smelting_magma_steel_dust"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.cyber_steel_dust.get()), TinkersReforgedItems.cyber_steel_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.cyber_steel_ingot.get())).save(consumer, modResource("cyber_steel_ingot_from_smelting_cyber_steel_dust"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.blazing_copper_dust.get()), TinkersReforgedItems.blazing_copper_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.blazing_copper_ingot.get())).save(consumer, modResource("blazing_copper_ingot_from_smelting_blazing_copper_dust"));

        toolBuilding(consumer, TinkersReforgedItems.FRYING_PAN, toolFolder);
        toolBuilding(consumer, TinkersReforgedItems.GREATSWORD, toolFolder);
        partRecipes(consumer, TinkersReforgedItems.GREAT_BLADE.get(), TinkersReforgedItems.great_blade_cast, 4, partFolder, castFolder);
        partRecipes(consumer, TinkersReforgedItems.LARGE_ROUND_PLATE.get(), TinkersReforgedItems.large_round_plate_cast, 6, partFolder, castFolder);
    }

    @Nonnull
    @Override
    public String getModId() {
        return TinkersReforged.MOD_ID;
    }

    private void oreFurnace(Consumer<FinishedRecipe> consumer, TagKey<Item> ore, Supplier<Item> item, String name, boolean value) {
        String end = value ? "raw": "ore";
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ore), item.get(), 0, 200).unlockedBy("has_item", has(item.get())).save(consumer, modResource("smelting/"+end+"/"+name));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ore), item.get(), 0.5f, 100).unlockedBy("has_item", has(item.get())).save(consumer, modResource("blasting/"+end+"/"+name));
    }

    private void metalComposite(Consumer<FinishedRecipe> consumer, Item input, Item output, FluidObject<?> fluid, boolean forgeTag, String folder, String name) {
        ItemCastingRecipeBuilder.tableRecipe(output)
                .setFluidAndTime(fluid, forgeTag, FluidValues.INGOT)
                .setCast(input, true)
                .setSwitchSlots()
                .save(consumer, modResource(folder + "/metal/" + name));
    }

    private void metalComposite(Consumer<FinishedRecipe> consumer, Block input, Item output, FluidObject<?> fluid, boolean forgeTag, String folder, String name) {
        ItemCastingRecipeBuilder.basinRecipe(output)
                .setFluidAndTime(fluid, forgeTag, FluidValues.GLASS_BLOCK)
                .setCast(input, true)
                .setSwitchSlots()
                .save(consumer, modResource(folder + "/metal/" + name));
    }

    public void createCast(Consumer<FinishedRecipe> consumer, CastType type, IMaterialItem part, String folder) {
        Item cast = TinkersReforgedItems.casts.get(type).get();
        this.createCast(consumer, cast, MaterialIngredient.fromItem(part), folder);
    }

    public void createCast(Consumer<FinishedRecipe> consumer, CastType type, String input, String folder) {
        this.createCast(consumer, type, getItemTag("forge", input), folder);
    }

    public void createCast(Consumer<FinishedRecipe> consumer, CastType type, TagKey<Item> input, String folder) {
        Item cast = TinkersReforgedItems.casts.get(type).get();
        this.createCast(consumer,cast, Ingredient.of(input), folder);
    }

    public void createCast(Consumer<FinishedRecipe> consumer, Item cast, Ingredient input, String folder) {
        ItemCastingRecipeBuilder.tableRecipe(cast)
                .setFluidAndTime(TinkerFluids.moltenAluminum, true, FluidValues.INGOT)
                .setCast(input, true)
                .setSwitchSlots()
                .save(consumer, modResource(folder + "aluminum_casts/" + cast.getRegistryName().getPath()));
    }

    public void gemBlock(Consumer<FinishedRecipe> consumer, String name, Item block, Item gem) {
        ConditionalRecipe.builder().addCondition(this.TRUE()).addRecipe(
                        ShapedRecipeBuilder.shaped(block, 1)
                                .pattern("XXX")
                                .pattern("XYX")
                                .pattern("XXX")
                                .define('X', ItemTags.create(new ResourceLocation("forge:gems/" + name)))
                                .define('Y', gem)
                                .group("")
                                .unlockedBy("has_gem", has(gem))
                                ::save
                )
                .generateAdvancement()
                .build(consumer, new ResourceLocation(TinkersReforged.MOD_ID, gem.getRegistryName().getPath() + "_to_block"));
    }

    public void blockIngotNuggetCompression(Consumer<FinishedRecipe> consumer, String name, Item block, Item ingot, Item nugget) {
        ConditionalRecipe.builder().addCondition(this.TRUE()).addRecipe(
                        ShapedRecipeBuilder.shaped(block, 1)
                                .pattern("XXX")
                                .pattern("XYX")
                                .pattern("XXX")
                                .define('X', ItemTags.create(new ResourceLocation("forge:ingots/" + name)))
                                .define('Y', ingot)
                                .group("")
                                .unlockedBy("has_ingot", has(ingot))
                                ::save
                )
                .generateAdvancement()
                .build(consumer, new ResourceLocation(TinkersReforged.MOD_ID, ingot.getRegistryName().getPath() + "_to_block"));

        ConditionalRecipe.builder().addCondition(this.TRUE()).addRecipe(
                        ShapelessRecipeBuilder.shapeless(ingot, 9)
                                .requires(block)
                                .group("")
                                .unlockedBy("has_block", has(block))
                                ::save
                )
                .generateAdvancement()
                .build(consumer, new ResourceLocation(TinkersReforged.MOD_ID, block.getRegistryName().getPath() + "_to_ingot"));

        ConditionalRecipe.builder().addCondition(this.TRUE()).addRecipe(
                        ShapedRecipeBuilder.shaped(ingot, 1)
                                .pattern("XXX")
                                .pattern("XYX")
                                .pattern("XXX")
                                .define('X', ItemTags.create(new ResourceLocation("forge:nuggets/" + name)))
                                .define('Y', nugget)
                                .group("")
                                .unlockedBy("has_nugget", has(nugget))
                                ::save
                )
                .generateAdvancement()
                .build(consumer, new ResourceLocation(TinkersReforged.MOD_ID, nugget.getRegistryName().getPath() + "_to_ingot"));

        ConditionalRecipe.builder().addCondition(this.TRUE()).addRecipe(
                        ShapelessRecipeBuilder.shapeless(nugget, 9)
                                .requires(ingot)
                                .group("")
                                .unlockedBy("has_ingot", has(ingot))
                                ::save
                )
                .generateAdvancement()
                .build(consumer, new ResourceLocation(TinkersReforged.MOD_ID, ingot.getRegistryName().getPath() + "_to_nugget"));
    }

    private void partRecipes(Consumer<FinishedRecipe> consumer, IMaterialItem part, CastObject cast, int cost, String partFolder, String castFolder) {
        String name = Objects.requireNonNull(part.asItem().getRegistryName()).getPath();

        // Part Builder
        PartRecipeBuilder.partRecipe(part)
                .setPattern(modResource(name))
                .setPatternItem(CompoundIngredient.of(Ingredient.of(TinkerTags.Items.DEFAULT_PATTERNS), Ingredient.of(cast.getGoldCast().get())))
                .setCost(cost)
                .save(consumer, modResource(partFolder + "builder/" + name));

        // Material Casting
        String castingFolder = partFolder + "casting/";
        MaterialCastingRecipeBuilder.tableRecipe(part)
                .setItemCost(cost)
                .setCast(cast.getMultiUseTag(), false)
                .save(consumer, modResource(castingFolder + name + "_gold_cast"));
        MaterialCastingRecipeBuilder.tableRecipe(part)
                .setItemCost(cost)
                .setCast(cast.getSingleUseTag(), true)
                .save(consumer, modResource(castingFolder + name + "_sand_cast"));
        CompositeCastingRecipeBuilder.table(part, cost)
                .save(consumer, modResource(castingFolder + name + "_composite"));

        // Cast Casting
        MaterialIngredient ingredient = MaterialIngredient.fromItem(part);
        castCreation(consumer, ingredient, cast, castFolder, Objects.requireNonNull(part.asItem().getRegistryName()).getPath());
    }

    private void castCreation(Consumer<FinishedRecipe> consumer, Ingredient input, CastObject cast, String folder, String name) {
        ItemCastingRecipeBuilder.tableRecipe(cast.getGoldCast().get())
                .setFluidAndTime(TinkerFluids.moltenGold, true, FluidValues.INGOT)
                .setCast(input, true)
                .setSwitchSlots()
                .save(consumer, modResource(folder + "gold_casts/" + name));
        MoldingRecipeBuilder.moldingTable(cast.getSandCast().get())
                .setMaterial(TinkerSmeltery.blankSandCast)
                .setPattern(input, false)
                .save(consumer, modResource(folder + "sand_casts/" + name));
        MoldingRecipeBuilder.moldingTable(cast.getRedSandCast().get())
                .setMaterial(TinkerSmeltery.blankRedSandCast)
                .setPattern(input, false)
                .save(consumer, modResource(folder + "red_sand_casts/" + name));
    }

    /** Adds recipes for a plate armor texture */
    private void plateTexture(Consumer<FinishedRecipe> consumer, Ingredient tool, MaterialId material, boolean optional, String folder) {
        plateTexture(consumer, tool, material, "ingots/" + material.getPath(), optional, folder);
    }

    private void gemMaterialRecipe(Consumer<FinishedRecipe> consumer, MaterialVariantId material, String folder, String name) {
        String matName = material.getLocation('/').getPath();
        // ingot
        TagKey<Item> gemTag = getItemTag("forge", "gems/" + name);
        materialRecipe(consumer, material, Ingredient.of(gemTag), 1, 1, folder + matName + "/gem");;

        materialRecipe(consumer, material, Ingredient.of(getItemTag("forge", "storage_blocks/" + name)), 9, 1, ItemOutput.fromTag(gemTag, 1), folder + matName + "/block");
    }

    /** Adds recipes for a plate armor texture with a custom tag */
    private void plateTexture(Consumer<FinishedRecipe> consumer, Ingredient tool, MaterialVariantId material, String tag, boolean optional, String folder) {
        Ingredient ingot = Ingredient.of(getItemTag("forge", tag));
        if (optional) {
            consumer = withCondition(consumer, tagCondition(tag));
        }
        SwappableModifierRecipeBuilder.modifier(TinkerModifiers.embellishment, material.toString())
                .setTools(tool)
                .addInput(ingot).addInput(ingot).addInput(ingot)
                .save(consumer, wrap(TinkerModifiers.embellishment.getId(), folder, "_" + material.getLocation('_').getPath()));
    }

    private void gemMeltingCasting(Consumer<FinishedRecipe> consumer, Supplier<Item> gem, Supplier<Block> gemBlock, FluidObject<ForgeFlowingFluid> fluid, String folder, String name, IByproduct ...byproduct) {
        gemMeltingCasting(consumer, gem.get(), gemBlock.get(), fluid, folder, name, byproduct);
    }

    private void gemMeltingCasting(Consumer<FinishedRecipe> consumer, Item gem, Block gemBlock, FluidObject<ForgeFlowingFluid> fluid, String folder, String name, IByproduct ...byproduct) {
        String castingFolder = folder+"/casting/";
        String meltingFolder = folder+"/melting/";

        gemBlockCasting(consumer, () -> gemBlock, fluid, castingFolder+name+"/"+gem);
        gemCasting(consumer, fluid, gem, meltingFolder+name+"/"+gem);

        gemMelting(consumer, fluid.get(), name, true, FluidValues.LARGE_GEM_BLOCK, meltingFolder, false, byproduct);
    }

    private void gemBlockCasting(Consumer<FinishedRecipe> consumer, Supplier<Block> block, FluidObject<ForgeFlowingFluid> fluid, String folder) {
        ItemCastingRecipeBuilder.basinRecipe(block.get())
                .setFluidAndTime(fluid, true, FluidValues.LARGE_GEM_BLOCK)
                .setSwitchSlots()
                .save(consumer, modResource(folder));
    }
}
