package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.*;
import net.minecraft.data.*;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.fluids.FluidStack;
import slimeknights.mantle.recipe.ingredient.EntityIngredient;
import slimeknights.mantle.recipe.ingredient.FluidIngredient;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.data.recipe.*;
import slimeknights.tconstruct.library.recipe.FluidValues;
import slimeknights.tconstruct.library.recipe.alloying.AlloyRecipeBuilder;
import slimeknights.tconstruct.library.recipe.casting.ItemCastingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.entitymelting.EntityMeltingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.fuel.MeltingFuelBuilder;
import slimeknights.tconstruct.library.recipe.ingredient.MaterialIngredient;
import slimeknights.tconstruct.library.recipe.melting.IMeltingContainer;
import slimeknights.tconstruct.library.recipe.melting.MeltingRecipeBuilder;
import slimeknights.tconstruct.library.tools.part.IMaterialItem;
import slimeknights.tconstruct.shared.TinkerMaterials;
import slimeknights.tconstruct.smeltery.data.Byproduct;
import slimeknights.tconstruct.tools.TinkerToolParts;
import slimeknights.tconstruct.tools.data.material.MaterialIds;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class ReforgedRecipes extends RecipeProvider implements IConditionBuilder, IMaterialRecipeHelper, IToolRecipeHelper, ISmelteryRecipeHelper, ICommonRecipeHelper {

    public ReforgedRecipes(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void buildCraftingRecipes(@Nonnull Consumer<FinishedRecipe> consumer) {

        String materialFolder = "materials/";
        String meltingFolder = "smeltery/melting/";
        String gemFolder = meltingFolder+"/gem/";
        String castingFolder = "smeltery/casting/";
        String castFolder = "smeltery/casts/";
        String alloyFolder = "smeltery/alloy/";

        blockIngotNuggetCompression(consumer, "aluminum", TinkersReforgedBlocks.aluminum_block.get().asItem(), TinkersReforgedItems.aluminum_ingot.get(), TinkersReforgedItems.aluminum_nugget.get());
        blockIngotNuggetCompression(consumer, "duralumin", TinkersReforgedBlocks.duralumin_block.get().asItem(), TinkersReforgedItems.duralumin_ingot.get(), TinkersReforgedItems.duralumin_nugget.get());
        blockIngotNuggetCompression(consumer, "electrical_copper", TinkersReforgedBlocks.electrical_copper_block.get().asItem(), TinkersReforgedItems.electrical_copper_ingot.get(), TinkersReforgedItems.electrical_copper_nugget.get());
        blockIngotNuggetCompression(consumer, "lavium", TinkersReforgedBlocks.lavium_block.get().asItem(), TinkersReforgedItems.lavium_ingot.get(), TinkersReforgedItems.lavium_nugget.get());
        blockIngotNuggetCompression(consumer, "qivium", TinkersReforgedBlocks.qivium_block.get().asItem(), TinkersReforgedItems.qivium_ingot.get(), TinkersReforgedItems.qivium_nugget.get());
        blockIngotNuggetCompression(consumer, "gausum", TinkersReforgedBlocks.gausum_block.get().asItem(), TinkersReforgedItems.gausum_ingot.get(), TinkersReforgedItems.gausum_nugget.get());
        blockIngotNuggetCompression(consumer, "felsteel", TinkersReforgedBlocks.felsteel_block.get().asItem(), TinkersReforgedItems.felsteel_ingot.get(), TinkersReforgedItems.felsteel_nugget.get());
        blockIngotNuggetCompression(consumer, "kepu", TinkersReforgedBlocks.kepu_block.get().asItem(), TinkersReforgedItems.kepu_ingot.get(), TinkersReforgedItems.kepu_nugget.get());
        blockIngotNuggetCompression(consumer, "chorus_metal", TinkersReforgedBlocks.chorus_metal_block.get().asItem(), TinkersReforgedItems.chorus_metal_ingot.get(), TinkersReforgedItems.chorus_metal_nugget.get());

        metalCasting(consumer, TinkersReforgedFluids.duralumin, TinkersReforgedBlocks.duralumin_block.get(), TinkersReforgedItems.duralumin_ingot.get(), TinkersReforgedItems.duralumin_nugget.get(), castingFolder, "duralumin");
        metalCasting(consumer, TinkersReforgedFluids.electrical_copper, TinkersReforgedBlocks.electrical_copper_block.get(), TinkersReforgedItems.electrical_copper_ingot.get(), TinkersReforgedItems.electrical_copper_nugget.get(), castingFolder, "electrical_copper");
        metalCasting(consumer, TinkersReforgedFluids.lavium, TinkersReforgedBlocks.lavium_block.get(), TinkersReforgedItems.lavium_ingot.get(), TinkersReforgedItems.lavium_nugget.get(), castingFolder, "lavium");
        metalCasting(consumer, TinkersReforgedFluids.qivium, TinkersReforgedBlocks.qivium_block.get(), TinkersReforgedItems.qivium_ingot.get(), TinkersReforgedItems.qivium_nugget.get(), castingFolder, "qivium");
        metalCasting(consumer, TinkersReforgedFluids.gausum, TinkersReforgedBlocks.gausum_block.get(), TinkersReforgedItems.gausum_ingot.get(), TinkersReforgedItems.gausum_nugget.get(), castingFolder, "gausum");
        metalCasting(consumer, TinkersReforgedFluids.felsteel, TinkersReforgedBlocks.felsteel_block.get(), TinkersReforgedItems.felsteel_ingot.get(), TinkersReforgedItems.felsteel_nugget.get(), castingFolder, "felsteel");
        metalCasting(consumer, TinkersReforgedFluids.kepu, TinkersReforgedBlocks.kepu_block.get(), TinkersReforgedItems.kepu_ingot.get(), TinkersReforgedItems.kepu_nugget.get(), castingFolder, "kepu");
        metalCasting(consumer, TinkersReforgedFluids.chorus_metal, TinkersReforgedBlocks.chorus_metal_block.get(), TinkersReforgedItems.chorus_metal_ingot.get(), TinkersReforgedItems.chorus_metal_nugget.get(), castingFolder, "chorus_metal");

        materialMeltingCasting(consumer, ReforgedMaterials.duralumin, TinkersReforgedFluids.duralumin, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterials.electrical_copper, TinkersReforgedFluids.electrical_copper, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterials.lavium, TinkersReforgedFluids.lavium, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterials.qivium, TinkersReforgedFluids.qivium, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterials.gausum, TinkersReforgedFluids.gausum, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterials.felsteel, TinkersReforgedFluids.felsteel, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterials.chorus_metal, TinkersReforgedFluids.chorus_metal, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterials.kepu, TinkersReforgedFluids.kepu, materialFolder);

        metalMelting(consumer, TinkersReforgedFluids.duralumin.get(), "duralumin", false, meltingFolder, false);
        metalMelting(consumer, TinkersReforgedFluids.electrical_copper.get(), "electrical_copper", false, meltingFolder, false);
        metalMelting(consumer, TinkersReforgedFluids.lavium.get(), "lavium", false, meltingFolder, false);
        metalMelting(consumer, TinkersReforgedFluids.qivium.get(), "qivium", false, meltingFolder, false);
        metalMelting(consumer, TinkersReforgedFluids.gausum.get(), "gausum", false, meltingFolder, false);
        metalMelting(consumer, TinkersReforgedFluids.felsteel.get(), "felsteel", false, meltingFolder, false);
        metalMelting(consumer, TinkersReforgedFluids.kepu.get(), "kepu", true, meltingFolder, false, Byproduct.AMETHYST);
        metalMelting(consumer, TinkersReforgedFluids.chorus_metal.get(), "chorus_metal", false, meltingFolder, false);

        metalMaterialRecipe(consumer, ReforgedMaterials.gausum, materialFolder, "gausum", false);
        metalMaterialRecipe(consumer, ReforgedMaterials.duralumin, materialFolder, "duralumin", false);
        metalMaterialRecipe(consumer, ReforgedMaterials.electrical_copper, materialFolder, "electrical_copper", false);
        metalMaterialRecipe(consumer, ReforgedMaterials.lavium, materialFolder, "lavium", false);
        metalMaterialRecipe(consumer, ReforgedMaterials.qivium, materialFolder, "qivium", false);
        metalMaterialRecipe(consumer, ReforgedMaterials.felsteel, materialFolder, "felsteel", false);
        metalMaterialRecipe(consumer, ReforgedMaterials.chorus_metal, materialFolder, "chorus_metal", false);
        metalMaterialRecipe(consumer, ReforgedMaterials.kepu, materialFolder, "kepu", false);

        materialComposite(consumer, MaterialIds.cobalt, ReforgedMaterials.lavium, TinkerFluids.liquidSoul, true, 500, materialFolder+"lavium_");
        materialComposite(consumer, MaterialIds.cobalt, ReforgedMaterials.qivium, TinkerFluids.magma, true, 500, materialFolder+"qivium_");
        metalComposite(consumer, TinkerMaterials.cobalt.getIngot(), TinkersReforgedItems.lavium_ingot.get(), TinkerFluids.liquidSoul, false, materialFolder, "lavium");
        metalComposite(consumer, TinkerMaterials.cobalt.getIngot(), TinkersReforgedItems.qivium_ingot.get(), TinkerFluids.magma, true, materialFolder, "qivium");
        metalComposite(consumer, Items.REDSTONE, TinkersReforgedItems.electrical_copper_dust.get(), TinkersReforgedFluids.blazing_copper, true, materialFolder, "electrical_copper");

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

        AlloyRecipeBuilder.alloy(TinkersReforgedFluids.chorus_metal.get(), FluidValues.INGOT)
                .addInput(TinkersReforgedFluids.kepu.get(), FluidValues.INGOT)
                .addInput(TinkersReforgedFluids.chorus.get(), FluidValues.INGOT)
                .addInput(TinkersReforgedFluids.shulker.get(), FluidValues.INGOT)
                .save(consumer, modResource(alloyFolder+"chorus_metal"));

        AlloyRecipeBuilder.alloy(TinkersReforgedFluids.proto_lava.get(), FluidValues.INGOT)
                .addInput(TinkerFluids.moltenEnder.get(), FluidValues.SLIMEBALL)
                .addInput(TinkersReforgedFluids.chorus.get(), FluidValues.INGOT/2)
                .addInput(FluidTags.LAVA, FluidValues.GLASS_BLOCK)
                .save(consumer, modResource(alloyFolder+"proto_lava"));

        MeltingRecipeBuilder.melting(Ingredient.of(TinkersReforgedItems.raw_aluminum.get()), new FluidStack(TinkerFluids.moltenAluminum.get(), FluidValues.INGOT), 900, 50).save(consumer, new ResourceLocation(TinkersReforged.MOD_ID, "smeltery/raw_aluminum"));
        MeltingRecipeBuilder.melting(Ingredient.of(TinkersReforgedItems.raw_kepu.get()), new FluidStack(TinkersReforgedFluids.kepu.get(), FluidValues.INGOT), 900, 50).addByproduct(new FluidStack(TinkersReforgedFluids.chorus.get(), FluidValues.INGOT/2)).save(consumer, new ResourceLocation(TinkersReforged.MOD_ID, "smeltery/raw_kepu"));

        MeltingRecipeBuilder.melting(Ingredient.of(Tags.Items.STORAGE_BLOCKS_LAPIS), TinkersReforgedFluids.lapis.get(), FluidValues.METAL_BLOCK).save(consumer, modResource(meltingFolder+"lapis_block"));
        MeltingRecipeBuilder.melting(Ingredient.of(Tags.Items.GEMS_LAPIS), TinkersReforgedFluids.lapis.get(), FluidValues.GEM).save(consumer, modResource(meltingFolder+"lapis_gem"));
        MeltingRecipeBuilder.melting(Ingredient.of(Items.SHULKER_SHELL), TinkersReforgedFluids.shulker.get(), FluidValues.INGOT/2).save(consumer, modResource(meltingFolder+"shulker_shell"));
        EntityMeltingRecipeBuilder.melting(EntityIngredient.of(EntityType.SHULKER), new FluidStack(TinkersReforgedFluids.shulker.get(), FluidValues.INGOT)).save(consumer, modResource(meltingFolder+"/entity/shulker"));

        MeltingRecipeBuilder.melting(Ingredient.of(Items.CHORUS_FLOWER), TinkersReforgedFluids.chorus.get(), FluidValues.GLASS_BLOCK).save(consumer, modResource(meltingFolder+"chorus_flower"));
        MeltingRecipeBuilder.melting(Ingredient.of(Items.CHORUS_FRUIT), TinkersReforgedFluids.chorus.get(), FluidValues.INGOT).save(consumer, modResource(meltingFolder+"chorus_fruit"));
        MeltingRecipeBuilder.melting(Ingredient.of(Items.POPPED_CHORUS_FRUIT), TinkersReforgedFluids.chorus.get(), FluidValues.INGOT).save(consumer, modResource(meltingFolder+"popped_chorus_fruit"));
        ingotCasting(consumer, TinkersReforgedFluids.chorus, Items.CHORUS_FRUIT, castFolder+"chorus_fruit");

        MeltingRecipeBuilder.melting(Ingredient.of(Tags.Items.ORES_LAPIS), TinkersReforgedFluids.lapis.get(), FluidValues.INGOT, 2.0f)
                .setOre(IMeltingContainer.OreRateType.GEM)
                .addByproduct(new FluidStack(TinkerFluids.moltenDiamond.get(), FluidValues.GEM))
                .save(consumer, modResource(gemFolder + "molten_lapis/ore"));

        ItemCastingRecipeBuilder.basinRecipe(Blocks.LAPIS_BLOCK)
                .setFluidAndTime(TinkersReforgedFluids.lapis, true, FluidValues.METAL_BLOCK)
                .setSwitchSlots()
                .save(consumer, modResource(castFolder+"lapis_block"));

        gemCasting(consumer, TinkersReforgedFluids.lapis, Items.LAPIS_LAZULI, castFolder+"lapis_lazuli_gem");

        MeltingRecipeBuilder.melting(Ingredient.of(ReforgedItemsTags.ALUMINUM_CASTS), new FluidStack(TinkerFluids.moltenAluminum.get(), FluidValues.INGOT), 700, 50).save(consumer, new ResourceLocation(TinkersReforged.MOD_ID, "smeltery/aluminum_from_cast"));

        MeltingFuelBuilder.fuel(FluidIngredient.of(new FluidStack(TinkersReforgedFluids.blazing_copper.get(), 50)), 150, 1800).save(consumer, modResource("smeltery/fuel/blazing_copper"));

        MeltingFuelBuilder.fuel(FluidIngredient.of(new FluidStack(TinkersReforgedFluids.proto_lava.get(), 50)), 100, 2500).save(consumer, modResource("smeltery/fuel/proto_lava"));

        createCast(consumer, CastType.ingot, Tags.Items.INGOTS, castFolder);
        createCast(consumer, CastType.nugget, Tags.Items.NUGGETS, castFolder);
        createCast(consumer, CastType.gem, Tags.Items.GEMS, castFolder);
        createCast(consumer, CastType.rod, Tags.Items.RODS, castFolder);

        createCast(consumer, CastType.plate, "plates", castFolder);
        createCast(consumer, CastType.gear, "gears", castFolder);
        createCast(consumer, CastType.coin, "coins", castFolder);
        createCast(consumer, CastType.wire, "wires", castFolder);

        createCast(consumer, CastType.broad_axe_head, TinkerToolParts.broadAxeHead.get(), castFolder);
        createCast(consumer, CastType.broad_blade, TinkerToolParts.broadBlade.get(), castFolder);
        createCast(consumer, CastType.hammer_head, TinkerToolParts.hammerHead.get(), castFolder);
        createCast(consumer, CastType.large_plate, TinkerToolParts.largePlate.get(), castFolder);
        createCast(consumer, CastType.pickaxe_head, TinkerToolParts.pickHead.get(), castFolder);
        createCast(consumer, CastType.repair_kit, TinkerToolParts.repairKit.get(), castFolder);
        createCast(consumer, CastType.small_axe_head, TinkerToolParts.smallAxeHead.get(), castFolder);
        createCast(consumer, CastType.small_blade, TinkerToolParts.smallBlade.get(), castFolder);
        createCast(consumer, CastType.tool_binding, TinkerToolParts.toolBinding.get(), castFolder);
        createCast(consumer, CastType.tool_handle, TinkerToolParts.toolHandle.get(), castFolder);
        createCast(consumer, CastType.tough_handle, TinkerToolParts.toughHandle.get(), castFolder);

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

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ReforgedItemsTags.ALUMINUM_ORE), TinkersReforgedItems.aluminum_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.aluminum_ingot.get())).save(consumer, modResource("aluminum_ingot_from_smelting_deepslate_aluminum_ore"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ReforgedItemsTags.ALUMINUM_ORE), TinkersReforgedItems.aluminum_ingot.get(), 0.5f, 100).unlockedBy("has_item", has(TinkersReforgedItems.aluminum_ingot.get())).save(consumer, modResource("aluminum_ingot_from_blasting_aluminum_ore"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.raw_aluminum.get()), TinkersReforgedItems.aluminum_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.aluminum_ingot.get())).save(consumer, modResource("aluminum_ingot_from_smelting_raw_aluminum"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(TinkersReforgedItems.raw_aluminum.get()), TinkersReforgedItems.aluminum_ingot.get(), 0.5f, 100).unlockedBy("has_item", has(TinkersReforgedItems.aluminum_ingot.get())).save(consumer, modResource("aluminum_ingot_from_blasting_raw_aluminum"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ReforgedItemsTags.KEPU_ORE), TinkersReforgedItems.kepu_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.kepu_ingot.get())).save(consumer, modResource("kepu_ingot_from_smelting_kepu_ore"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ReforgedItemsTags.KEPU_ORE), TinkersReforgedItems.kepu_ingot.get(), 0.5f, 100).unlockedBy("has_item", has(TinkersReforgedItems.kepu_ingot.get())).save(consumer, modResource("kepu_ingot_from_blasting_kepu_ore"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.raw_kepu.get()), TinkersReforgedItems.kepu_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.kepu_ingot.get())).save(consumer, modResource("kepu_ingot_from_smelting_raw_kepu"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(TinkersReforgedItems.raw_kepu.get()), TinkersReforgedItems.kepu_ingot.get(), 0.5f, 100).unlockedBy("has_item", has(TinkersReforgedItems.kepu_ingot.get())).save(consumer, modResource("kepu_ingot_from_blasting_raw_kepu"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.kepu_dust.get()), TinkersReforgedItems.kepu_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.kepu_ingot.get())).save(consumer, modResource("kepu_ingot_from_smelting_kepu_dust"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.aluminum_dust.get()), TinkersReforgedItems.aluminum_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.aluminum_ingot.get())).save(consumer, modResource("aluminum_ingot_from_smelting_aluminum_dust"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.duralumin_dust.get()), TinkersReforgedItems.duralumin_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.duralumin_ingot.get())).save(consumer, modResource("duralumin_ingot_from_smelting_duralumin_dust"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.lavium_dust.get()), TinkersReforgedItems.lavium_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.lavium_ingot.get())).save(consumer, modResource("lavium_ingot_from_smelting_lavium_dust"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.qivium_dust.get()), TinkersReforgedItems.qivium_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.qivium_ingot.get())).save(consumer, modResource("qivium_ingot_from_smelting_qivium_dust"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.gausum_dust.get()), TinkersReforgedItems.gausum_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.gausum_ingot.get())).save(consumer, modResource("gausum_ingot_from_smelting_gausum_dust"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.felsteel_dust.get()), TinkersReforgedItems.felsteel_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.felsteel_ingot.get())).save(consumer, modResource("felsteel_ingot_from_smelting_felsteel_dust"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TinkersReforgedItems.electrical_copper_dust.get()), TinkersReforgedItems.electrical_copper_ingot.get(), 0, 200).unlockedBy("has_item", has(TinkersReforgedItems.electrical_copper_ingot.get())).save(consumer, modResource("electrical_copper_ingot_from_smelting_electrical_copper_dust"));
    }

    @Nonnull
    @Override
    public String getModId() {
        return TinkersReforged.MOD_ID;
    }

    private void metalComposite(Consumer<FinishedRecipe> consumer, Item input, Item output, FluidObject<?> fluid, boolean forgeTag, String folder, String name) {
        ItemCastingRecipeBuilder.tableRecipe(output)
                .setFluidAndTime(fluid, forgeTag, FluidValues.INGOT)
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
}
