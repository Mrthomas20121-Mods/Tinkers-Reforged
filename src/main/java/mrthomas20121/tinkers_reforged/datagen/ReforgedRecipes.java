package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.*;
import net.minecraft.data.*;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.fluids.FluidStack;
import slimeknights.mantle.recipe.ingredient.FluidIngredient;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.data.recipe.*;
import slimeknights.tconstruct.library.recipe.FluidValues;
import slimeknights.tconstruct.library.recipe.alloying.AlloyRecipeBuilder;
import slimeknights.tconstruct.library.recipe.casting.ItemCastingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.fuel.MeltingFuelBuilder;
import slimeknights.tconstruct.library.recipe.ingredient.MaterialIngredient;
import slimeknights.tconstruct.library.recipe.melting.IMeltingContainer;
import slimeknights.tconstruct.library.recipe.melting.MeltingRecipeBuilder;
import slimeknights.tconstruct.library.tools.part.IMaterialItem;
import slimeknights.tconstruct.shared.TinkerMaterials;
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

        metalCasting(consumer, TinkersReforgedFluids.duralumin, TinkersReforgedBlocks.duralumin_block.get(), TinkersReforgedItems.duralumin_ingot.get(), TinkersReforgedItems.duralumin_nugget.get(), castingFolder, "duralumin");
        metalCasting(consumer, TinkersReforgedFluids.electrical_copper, TinkersReforgedBlocks.electrical_copper_block.get(), TinkersReforgedItems.electrical_copper_ingot.get(), TinkersReforgedItems.electrical_copper_nugget.get(), castingFolder, "electrical_copper");
        metalCasting(consumer, TinkersReforgedFluids.lavium, TinkersReforgedBlocks.lavium_block.get(), TinkersReforgedItems.lavium_ingot.get(), TinkersReforgedItems.lavium_nugget.get(), castingFolder, "lavium");
        metalCasting(consumer, TinkersReforgedFluids.qivium, TinkersReforgedBlocks.qivium_block.get(), TinkersReforgedItems.qivium_ingot.get(), TinkersReforgedItems.qivium_nugget.get(), castingFolder, "qivium");
        metalCasting(consumer, TinkersReforgedFluids.gausum, TinkersReforgedBlocks.gausum_block.get(), TinkersReforgedItems.gausum_ingot.get(), TinkersReforgedItems.gausum_nugget.get(), castingFolder, "gausum");

        materialMeltingCasting(consumer, ReforgedMaterials.duralumin, TinkersReforgedFluids.duralumin, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterials.electrical_copper, TinkersReforgedFluids.electrical_copper, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterials.lavium, TinkersReforgedFluids.lavium, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterials.qivium, TinkersReforgedFluids.qivium, materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterials.gausum, TinkersReforgedFluids.gausum, materialFolder);

        metalMelting(consumer, TinkersReforgedFluids.duralumin.getStill(), "duralumin", false, meltingFolder, false);
        metalMelting(consumer, TinkersReforgedFluids.electrical_copper.getStill(), "electrical_copper", false, meltingFolder, false);
        metalMelting(consumer, TinkersReforgedFluids.lavium.getStill(), "lavium", false, meltingFolder, false);
        metalMelting(consumer, TinkersReforgedFluids.qivium.getStill(), "qivium", false, meltingFolder, false);
        metalMelting(consumer, TinkersReforgedFluids.gausum.getStill(), "gausum", false, meltingFolder, false);

        metalMaterialRecipe(consumer, ReforgedMaterials.gausum, materialFolder, "gausum", false);
        metalMaterialRecipe(consumer, ReforgedMaterials.duralumin, materialFolder, "duralumin", false);
        metalMaterialRecipe(consumer, ReforgedMaterials.electrical_copper, materialFolder, "electrical_copper", false);
        metalMaterialRecipe(consumer, ReforgedMaterials.lavium, materialFolder, "lavium", false);
        metalMaterialRecipe(consumer, ReforgedMaterials.qivium, materialFolder, "qivium", false);

        materialComposite(consumer, MaterialIds.cobalt, ReforgedMaterials.lavium, TinkerFluids.liquidSoul, true, 500, materialFolder+"lavium_");
        materialComposite(consumer, MaterialIds.cobalt, ReforgedMaterials.qivium, TinkerFluids.magma, true, 500, materialFolder+"qivium_");
        metalComposite(consumer, TinkerMaterials.cobalt.getIngot(), TinkersReforgedItems.lavium_ingot.get(), TinkerFluids.liquidSoul, false, materialFolder, "lavium");
        metalComposite(consumer, TinkerMaterials.cobalt.getIngot(), TinkersReforgedItems.qivium_ingot.get(), TinkerFluids.magma, true, materialFolder, "qivium");

        metalComposite(consumer, Items.REDSTONE, TinkersReforgedItems.electrical_copper_dust.get(), TinkersReforgedFluids.blazing_copper, true, materialFolder, "electrical_copper");

        AlloyRecipeBuilder.alloy(TinkersReforgedFluids.duralumin.getStill(), FluidValues.INGOT*5)
                .addInput(TinkerFluids.moltenCopper.get(), FluidValues.INGOT)
                .addInput(TinkerFluids.moltenAluminum.get(), FluidValues.METAL_BLOCK)
                .save(consumer, modResource(alloyFolder+"duralumin"));

        AlloyRecipeBuilder.alloy(TinkersReforgedFluids.blazing_copper.getStill(), FluidValues.METAL_BLOCK)
                .addInput(TinkerFluids.moltenCopper.get(), FluidValues.METAL_BLOCK)
                .addInput(TinkerFluids.blazingBlood.get(), FluidValues.GLASS_BLOCK)
                .save(consumer, modResource(alloyFolder+"blazing_copper"));

        AlloyRecipeBuilder.alloy(TinkersReforgedFluids.electrical_copper.getStill(), FluidValues.INGOT*2)
                .addInput(TinkersReforgedFluids.blazing_copper.getStill(), FluidValues.INGOT*2)
                .addInput(TinkersReforgedFluids.redstone.getStill(), FluidValues.GLASS_BLOCK)
                .save(consumer, modResource(alloyFolder+"electrical_copper"));

        AlloyRecipeBuilder.alloy(TinkersReforgedFluids.gausum.getStill(), FluidValues.INGOT*2)
                .addInput(TinkersReforgedFluids.blazing_copper.getStill(), FluidValues.INGOT*2)
                .addInput(TinkerFluids.moltenDebris.get(), FluidValues.INGOT*2)
                .addInput(TinkersReforgedFluids.lapis.getStill(), FluidValues.METAL_BLOCK)
                .save(consumer, modResource(alloyFolder+"gausum"));

        MeltingRecipeBuilder.melting(Ingredient.of(Tags.Items.STORAGE_BLOCKS_LAPIS), TinkersReforgedFluids.lapis.getStill(), FluidValues.METAL_BLOCK).save(consumer, modResource(meltingFolder+"lapis_block"));
        MeltingRecipeBuilder.melting(Ingredient.of(Tags.Items.GEMS_LAPIS), TinkersReforgedFluids.lapis.getStill(), FluidValues.GEM).save(consumer, modResource(meltingFolder+"lapis_gem"));

        MeltingRecipeBuilder.melting(Ingredient.of(Tags.Items.ORES_LAPIS), TinkersReforgedFluids.lapis.get(), FluidValues.INGOT, 2.0f)
                .setOre(IMeltingContainer.OreRateType.GEM)
                .addByproduct(new FluidStack(TinkerFluids.moltenDiamond.get(), FluidValues.GEM * 3))
                .addByproduct(new FluidStack(TinkerFluids.moltenGold.get(), FluidValues.INGOT * 3))
                .save(consumer, modResource(gemFolder + "molten_lapis/ore"));

        ItemCastingRecipeBuilder.basinRecipe(Blocks.LAPIS_BLOCK)
                .setFluidAndTime(TinkersReforgedFluids.lapis, true, FluidValues.METAL_BLOCK)
                .setSwitchSlots()
                .save(consumer, modResource(castFolder+"lapis_block"));

        gemCasting(consumer, TinkersReforgedFluids.lapis, Items.LAPIS_LAZULI, castFolder+"lapis_lazuli_gem");

        MeltingRecipeBuilder.melting(Ingredient.of(ReforgedItemsTags.ALUMINUM_CASTS), new FluidStack(TinkerFluids.moltenAluminum.get(), FluidValues.INGOT), 700, 50).save(consumer, new ResourceLocation(TinkersReforged.MOD_ID, "smeltery/aluminum_from_cast"));

        MeltingFuelBuilder.fuel(FluidIngredient.of(new FluidStack(TinkersReforgedFluids.blazing_copper.getStill(), 50)), 150, 1800).save(consumer, modResource("smeltery/fuel/blazing_copper"));

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

        materialRecipe(consumer, ReforgedMaterials.duralumin, Ingredient.of(ReforgedItemsTags.DURALUMIN_INGOT), FluidValues.INGOT, 1, materialFolder+"duralumin_repair");
        materialRecipe(consumer, ReforgedMaterials.electrical_copper, Ingredient.of(ReforgedItemsTags.ELECTRICAL_COPPER_INGOT), FluidValues.INGOT, 1, materialFolder+"electrical_copper_repair");
        materialRecipe(consumer, ReforgedMaterials.gausum, Ingredient.of(ReforgedItemsTags.GAUSUM_INGOT), FluidValues.INGOT, 1, materialFolder+"gausum_repair");
        materialRecipe(consumer, ReforgedMaterials.lavium, Ingredient.of(ReforgedItemsTags.LAVIUM_INGOT), FluidValues.INGOT, 1, materialFolder+"lavium_repair");
        materialRecipe(consumer, ReforgedMaterials.qivium, Ingredient.of(ReforgedItemsTags.QIVIUM_INGOT), FluidValues.INGOT, 1, materialFolder+"qivium_repair");
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
