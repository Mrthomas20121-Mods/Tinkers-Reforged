package mrthomas20121.tinkers_reforged.data;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.TinkersReforgedByproduct;
import mrthomas20121.tinkers_reforged.api.data.Metal;
import mrthomas20121.tinkers_reforged.api.holder.BlockMetalObject;
import mrthomas20121.tinkers_reforged.api.holder.BlockOreObject;
import mrthomas20121.tinkers_reforged.api.holder.BlockOverworldOreObject;
import mrthomas20121.tinkers_reforged.api.holder.ItemMetalObject;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedBlocks;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedFluids;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import org.jetbrains.annotations.NotNull;
import slimeknights.mantle.recipe.data.IRecipeHelper;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.data.recipe.IByproduct;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.ISmelteryRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.SmelteryRecipeBuilder;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.recipe.FluidValues;
import slimeknights.tconstruct.library.recipe.alloying.AlloyRecipeBuilder;
import slimeknights.tconstruct.library.recipe.casting.ItemCastingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.fuel.MeltingFuelBuilder;
import slimeknights.tconstruct.library.recipe.melting.MeltingRecipeBuilder;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;
import slimeknights.tconstruct.smeltery.data.Byproduct;
import slimeknights.tconstruct.tools.data.material.MaterialIds;

import java.util.function.Consumer;

public class TinkersReforgedRecipeProvider extends RecipeProvider implements IConditionBuilder, IRecipeHelper, ISmelteryRecipeHelper, IMaterialRecipeHelper {
    public TinkersReforgedRecipeProvider(PackOutput generator) {
        super(generator);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        String materialFolder = "tools/materials/";

        for(Metal metal: Metal.values) {
            String metalName = metal.getSerializedName();
            ItemMetalObject itemMetalObject = TinkersReforgedItems.METALS.get(metal);
            BlockMetalObject blockMetalObject = TinkersReforgedBlocks.METAl_BLOCKS.get(metal);
            FluidObject<ForgeFlowingFluid> fluid = TinkersReforgedFluids.METALS.get(metal);

            // ingot, nugget, etc... recipe
            metalCraftingRecipes(metal, metalName, itemMetalObject, blockMetalObject, consumer);

            LOGGER.info(fluid.getId().toString());

            if(metal.equals(Metal.BARIUM)) {
                metal(consumer, fluid).ore(Byproduct.DEBRIS).metal().dust().gear().plate();
            }
            else if(metal.equals(Metal.YTTRIUM)) {
                metal(consumer, fluid).ore(TinkersReforgedByproduct.GRAPHITE).metal().dust().gear().plate();
            }
            else if(metal.equals(Metal.THALLIUM)) {
                metal(consumer, fluid).ore(Byproduct.IRON).metal().dust().gear().plate();
            }
            else {
                metal(consumer, fluid).metal().dust().gear().plate();
            }

            MaterialId material = metal.asMaterial();
            metalMaterialRecipe(consumer, material, materialFolder, metalName, false);
            materialMeltingCasting(consumer, material, TinkersReforgedFluids.METALS.get(metal), "smeltery/");
        }

        MeltingRecipeBuilder.melting(Ingredient.of(Items.PRISMARINE_SHARD, Items.PRISMARINE_CRYSTALS), TinkersReforgedFluids.CHARRED_PRISMARINE, FluidValues.BRICK).save(consumer, location("smeltery/melting/prismarine_shard"));
        MeltingRecipeBuilder.melting(Ingredient.of(Blocks.PRISMARINE, Blocks.DARK_PRISMARINE), TinkersReforgedFluids.CHARRED_PRISMARINE, FluidValues.BRICK_BLOCK).save(consumer, location("smeltery/melting/prismarine_block"));
        MeltingRecipeBuilder.melting(Ingredient.of(Blocks.PRISMARINE_SLAB, Blocks.DARK_PRISMARINE_SLAB), TinkersReforgedFluids.CHARRED_PRISMARINE, FluidValues.BRICK_BLOCK/2).save(consumer, location("smeltery/melting/prismarine_slab"));
        MeltingRecipeBuilder.melting(Ingredient.of(Blocks.PRISMARINE_STAIRS, Blocks.DARK_PRISMARINE_STAIRS), TinkersReforgedFluids.CHARRED_PRISMARINE, 750).save(consumer, location("smeltery/melting/prismarine_stairs"));

        // special cases for prismarine brick because for some reason vanilla craft it from 9 shard
        MeltingRecipeBuilder.melting(Ingredient.of(Blocks.PRISMARINE_BRICKS), TinkersReforgedFluids.CHARRED_PRISMARINE, FluidValues.BRICK*9).save(consumer, location("smeltery/melting/prismarine_brick"));
        MeltingRecipeBuilder.melting(Ingredient.of(Blocks.PRISMARINE_BRICK_SLAB), TinkersReforgedFluids.CHARRED_PRISMARINE, (FluidValues.BRICK*9)/2).save(consumer, location("smeltery/melting/prismarine_brick_slab"));
        MeltingRecipeBuilder.melting(Ingredient.of(Blocks.PRISMARINE_BRICK_STAIRS), TinkersReforgedFluids.CHARRED_PRISMARINE, (FluidValues.BRICK*9)/3).save(consumer, location("smeltery/melting/prismarine_brick_stairs"));

        ItemCastingRecipeBuilder.basinRecipe(Blocks.PRISMARINE)
                .setFluidAndTime(TinkersReforgedFluids.CHARRED_PRISMARINE, FluidValues.BRICK_BLOCK)
                .save(consumer, location("smeltery/casting/prismarine_block"));

        ItemCastingRecipeBuilder.tableRecipe(Items.PRISMARINE_SHARD)
                .setCast(TinkerSmeltery.gemCast.getMultiUseTag(), false)
                .setFluidAndTime(TinkersReforgedFluids.CHARRED_PRISMARINE, FluidValues.BRICK)
                .save(consumer, location("smeltery/casting/prismarine_shard_gold"));

        ItemCastingRecipeBuilder.tableRecipe(Items.PRISMARINE_SHARD)
                .setCast(TinkerSmeltery.gemCast.getSingleUseTag(), true)
                .setFluidAndTime(TinkersReforgedFluids.CHARRED_PRISMARINE, FluidValues.BRICK)
                .save(consumer, location("smeltery/casting/prismarine_shard_sand"));

        materialMeltingCasting(consumer, MaterialIds.prismarine, TinkersReforgedFluids.CHARRED_PRISMARINE, "smeltery/");

        AlloyRecipeBuilder.alloy(TinkersReforgedFluids.METALS.get(Metal.SLIMEBRONZE), FluidValues.INGOT*2)
                .addInput(TinkersReforgedFluids.CHARRED_PRISMARINE.getCommonTag(), FluidValues.BRICK_BLOCK)
                .addInput(TinkerFluids.moltenCopper.getCommonTag(), FluidValues.INGOT*2)
                .addInput(new FluidStack(TinkerFluids.earthSlime.get(), FluidValues.SLIMEBALL*2))
                .save(consumer, location("smeltery/melting/alloy/slimebronze"));

        AlloyRecipeBuilder.alloy(TinkersReforgedFluids.METALS.get(Metal.ASTATINE), FluidValues.INGOT*2)
                .addInput(TinkersReforgedFluids.CHARRED_PRISMARINE.getCommonTag(), FluidValues.BRICK_BLOCK)
                .addInput(TinkersReforgedFluids.METALS.get(Metal.YTTRIUM).getCommonTag(), FluidValues.INGOT)
                .save(consumer, location("smeltery/melting/alloy/astatine"));

        AlloyRecipeBuilder.alloy(TinkersReforgedFluids.METALS.get(Metal.TELLURIUM), FluidValues.INGOT*2)
                .addInput(TinkersReforgedFluids.METALS.get(Metal.BARIUM).getCommonTag(), FluidValues.INGOT)
                .addInput(TinkerFluids.magma.getCommonTag(), FluidValues.SLIMEBALL*2)
                .save(consumer, location("smeltery/melting/alloy/tellurium"));

        AlloyRecipeBuilder.alloy(TinkersReforgedFluids.METALS.get(Metal.ACTINIUM), FluidValues.INGOT*2)
                .addInput(TinkersReforgedFluids.METALS.get(Metal.BARIUM).getCommonTag(), FluidValues.INGOT)
                .addInput(TinkerFluids.moltenCobalt.getCommonTag(), FluidValues.INGOT)
                .save(consumer, location("smeltery/melting/alloy/actinium"));

        AlloyRecipeBuilder.alloy(TinkersReforgedFluids.METALS.get(Metal.BERKELIUM), FluidValues.INGOT*4)
                .addInput(TinkersReforgedFluids.METALS.get(Metal.THALLIUM).getCommonTag(), FluidValues.INGOT*3)
                .addInput(TinkerFluids.moltenNetherite.getCommonTag(), FluidValues.INGOT)
                .save(consumer, location("smeltery/melting/alloy/berkelium"));

        AlloyRecipeBuilder.alloy(TinkersReforgedFluids.METALS.get(Metal.GERMANIUM), FluidValues.INGOT*4)
                .addInput(TinkersReforgedFluids.METALS.get(Metal.THALLIUM).getCommonTag(), FluidValues.INGOT*3)
                .addInput(TinkerFluids.moltenRoseGold.getCommonTag(), FluidValues.INGOT)
                .save(consumer, location("smeltery/melting/alloy/germanium"));

        MeltingFuelBuilder.fuel(new FluidStack(TinkersReforgedFluids.MOLTEN_URANOPHANE.get(), 50), 175)
                .save(consumer, location("smeltery/melting/fuel/molten_uranophane"));

        MeltingFuelBuilder.fuel(new FluidStack(TinkersReforgedFluids.MOLTEN_SERANDITE.get(), 50), 200)
                .save(consumer, location("smeltery/melting/fuel/molten_serandite"));


    }

    private void metalCraftingRecipes(Metal metal, String metalName, ItemMetalObject itemMetalObject, BlockMetalObject blockMetalObject, Consumer<FinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, blockMetalObject.get())
                .define('I', metal.getIngotTag())
                .define('X', itemMetalObject.getIngot())
                .pattern("III")
                .pattern("IXI")
                .pattern("III")
                .group("metal")
                .unlockedBy(getHasName(itemMetalObject.getIngot()), has(metal.getIngotTag()))
                .save(consumer, location("crafting/metal/"+ metalName+"/block_from_ingot"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemMetalObject.getIngot())
                .define('N', metal.getNuggetTag())
                .define('X', itemMetalObject.getNugget())
                .pattern("NNN")
                .pattern("NXN")
                .pattern("NNN")
                .group("metal")
                .unlockedBy(getHasName(itemMetalObject.getNugget()), has(metal.getNuggetTag()))
                .save(consumer, location("crafting/metal/"+ metalName+"/ingot_from_nugget"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, itemMetalObject.getIngot(), 9)
                .requires(metal.getBlockItemTag())
                .group("metal")
                .unlockedBy(getHasName(blockMetalObject.get()), has(metal.getBlockItemTag()))
                .save(consumer, location("crafting/metal/"+ metalName+"/ingot_from_block"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, itemMetalObject.getNugget(), 9)
                .requires(metal.getIngotTag())
                .group("metal")
                .unlockedBy(getHasName(itemMetalObject.getIngot()), has(metal.getIngotTag()))
                .save(consumer, location("crafting/metal/"+ metalName+"/nugget_from_ingot"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemMetalObject.getGear())
                .define('X', Tags.Items.NUGGETS_IRON)
                .define('I', metal.getIngotTag())
                .pattern(" I ")
                .pattern("IXI")
                .pattern(" I ")
                .group("metal")
                .unlockedBy(getHasName(itemMetalObject.getIngot()), has(metal.getIngotTag()))
                .save(consumer, location("crafting/metal/"+ metalName +"/gear"));

        if(metal.equals(Metal.YTTRIUM)) {
            BlockOverworldOreObject ore = TinkersReforgedBlocks.YTTRIUM_ORE;
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ore.getRawOreBlock())
                    .define('X', metal.getRawItemTag())
                    .pattern("XXX")
                    .pattern("XXX")
                    .pattern("XXX")
                    .group("metal")
                    .unlockedBy(getHasName(ore.getRawItem()), has(metal.getRawItemTag()))
                    .save(consumer, location("crafting/metal/"+ metalName +"/raw_material_to_block"));

            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ore.getRawItem(), 9)
                    .requires(metal.getRawBlockItemTag())
                    .group("metal")
                    .unlockedBy(getHasName(itemMetalObject.getIngot()), has(metal.getIngotTag()))
                    .save(consumer, location("crafting/metal/"+ metalName+"/raw_block_to_material"));

            SimpleCookingRecipeBuilder.smelting(Ingredient.of(metal.getRawItemTag()), RecipeCategory.MISC, itemMetalObject.getIngot(), 0.7f, 200)
                    .group("metal")
                    .unlockedBy(getHasName(ore.getRawItem()), has(metal.getRawItemTag()))
                    .save(consumer, location("smelting/"+metalName+"/raw_material_to_ingot"));
            SimpleCookingRecipeBuilder.smelting(Ingredient.of(metal.getOreBlockItem()), RecipeCategory.MISC, itemMetalObject.getIngot(), 0.7f, 200)
                    .group("metal")
                    .unlockedBy(getHasName(ore.get()), has(metal.getOreBlockItem()))
                    .save(consumer, location("smelting/"+metalName+"/ore_to_ingot"));

            SimpleCookingRecipeBuilder.blasting(Ingredient.of(metal.getRawItemTag()), RecipeCategory.MISC, itemMetalObject.getIngot(), 0.7f, 100)
                    .group("metal")
                    .unlockedBy(getHasName(ore.getRawItem()), has(metal.getRawItemTag()))
                    .save(consumer, location("blasting/"+metalName+"/raw_material_to_ingot"));
            SimpleCookingRecipeBuilder.blasting(Ingredient.of(metal.getOreBlockItem()), RecipeCategory.MISC, itemMetalObject.getIngot(), 0.7f, 100)
                    .group("metal")
                    .unlockedBy(getHasName(ore.get()), has(metal.getOreBlockItem()))
                    .save(consumer, location("blasting/"+metalName+"/ore_to_ingot"));

            SimpleCookingRecipeBuilder.smelting(Ingredient.of(metal.getDustTag()), RecipeCategory.MISC, itemMetalObject.getIngot(), 0.4f, 200)
                    .group("metal")
                    .unlockedBy(getHasName(itemMetalObject.getDust()), has(metal.getDustTag()))
                    .save(consumer, location("smelting/"+metalName+"/dust_to_ingot"));
            SimpleCookingRecipeBuilder.blasting(Ingredient.of(metal.getDustTag()), RecipeCategory.MISC, itemMetalObject.getIngot(), 0.4f, 100)
                    .group("metal")
                    .unlockedBy(getHasName(itemMetalObject.getDust()), has(metal.getDustTag()))
                    .save(consumer, location("blasting/"+metalName+"/dust_to_ingot"));
        }
        else if(metal.equals(Metal.BARIUM)) {
            BlockOreObject ore = TinkersReforgedBlocks.BARIUM_ORE;
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ore.getRawOreBlock())
                    .define('X', metal.getRawItemTag())
                    .pattern("XXX")
                    .pattern("XXX")
                    .pattern("XXX")
                    .group("metal")
                    .unlockedBy(getHasName(ore.getRawItem()), has(metal.getRawItemTag()))
                    .save(consumer, location("crafting/metal/"+ metalName +"/raw_material_to_block"));

            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ore.getRawItem(), 9)
                    .requires(metal.getRawBlockItemTag())
                    .group("metal")
                    .unlockedBy(getHasName(itemMetalObject.getIngot()), has(metal.getIngotTag()))
                    .save(consumer, location("crafting/metal/"+ metalName+"/raw_block_to_material"));

            SimpleCookingRecipeBuilder.smelting(Ingredient.of(metal.getRawItemTag()), RecipeCategory.MISC, itemMetalObject.getIngot(), 0.7f, 200)
                    .group("metal")
                    .unlockedBy(getHasName(ore.getRawItem()), has(metal.getRawItemTag()))
                    .save(consumer, location("smelting/"+metalName+"/raw_material_to_ingot"));
            SimpleCookingRecipeBuilder.smelting(Ingredient.of(metal.getOreBlockItem()), RecipeCategory.MISC, itemMetalObject.getIngot(), 0.7f, 200)
                    .group("metal")
                    .unlockedBy(getHasName(ore.get()), has(metal.getOreBlockItem()))
                    .save(consumer, location("smelting/"+metalName+"/ore_to_ingot"));

            SimpleCookingRecipeBuilder.blasting(Ingredient.of(metal.getRawItemTag()), RecipeCategory.MISC, itemMetalObject.getIngot(), 0.7f, 100)
                    .group("metal")
                    .unlockedBy(getHasName(ore.getRawItem()), has(metal.getRawItemTag()))
                    .save(consumer, location("blasting/"+metalName+"/raw_material_to_ingot"));
            SimpleCookingRecipeBuilder.blasting(Ingredient.of(metal.getOreBlockItem()), RecipeCategory.MISC, itemMetalObject.getIngot(), 0.7f, 100)
                    .group("metal")
                    .unlockedBy(getHasName(ore.get()), has(metal.getOreBlockItem()))
                    .save(consumer, location("blasting/"+metalName+"/ore_to_ingot"));

            SimpleCookingRecipeBuilder.smelting(Ingredient.of(metal.getDustTag()), RecipeCategory.MISC, itemMetalObject.getIngot(), 0.4f, 200)
                    .group("metal")
                    .unlockedBy(getHasName(itemMetalObject.getDust()), has(metal.getDustTag()))
                    .save(consumer, location("smelting/"+metalName+"/dust_to_ingot"));
            SimpleCookingRecipeBuilder.blasting(Ingredient.of(metal.getDustTag()), RecipeCategory.MISC, itemMetalObject.getIngot(), 0.4f, 100)
                    .group("metal")
                    .unlockedBy(getHasName(itemMetalObject.getDust()), has(metal.getDustTag()))
                    .save(consumer, location("blasting/"+metalName+"/dust_to_ingot"));
        }
        else if(metal.equals(Metal.THALLIUM)) {
            BlockOreObject ore = TinkersReforgedBlocks.THALLIUM_ORE;
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ore.getRawOreBlock())
                    .define('X', metal.getRawItemTag())
                    .pattern("XXX")
                    .pattern("XXX")
                    .pattern("XXX")
                    .group("metal")
                    .unlockedBy(getHasName(ore.getRawItem()), has(metal.getRawItemTag()))
                    .save(consumer, location("crafting/metal/"+ metalName +"/raw_material_to_block"));

            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ore.getRawItem(), 9)
                    .requires(metal.getRawBlockItemTag())
                    .group("metal")
                    .unlockedBy(getHasName(itemMetalObject.getIngot()), has(metal.getIngotTag()))
                    .save(consumer, location("crafting/metal/"+ metalName+"/raw_block_to_material"));

            SimpleCookingRecipeBuilder.smelting(Ingredient.of(metal.getRawItemTag()), RecipeCategory.MISC, itemMetalObject.getIngot(), 0.7f, 200)
                    .group("metal")
                    .unlockedBy(getHasName(ore.getRawItem()), has(metal.getRawItemTag()))
                    .save(consumer, location("smelting/"+metalName+"/raw_material_to_ingot"));
            SimpleCookingRecipeBuilder.smelting(Ingredient.of(metal.getOreBlockItem()), RecipeCategory.MISC, itemMetalObject.getIngot(), 0.7f, 200)
                    .group("metal")
                    .unlockedBy(getHasName(ore.get()), has(metal.getOreBlockItem()))
                    .save(consumer, location("smelting/"+metalName+"/ore_to_ingot"));

            SimpleCookingRecipeBuilder.blasting(Ingredient.of(metal.getRawItemTag()), RecipeCategory.MISC, itemMetalObject.getIngot(), 0.7f, 100)
                    .group("metal")
                    .unlockedBy(getHasName(ore.getRawItem()), has(metal.getRawItemTag()))
                    .save(consumer, location("blasting/"+metalName+"/raw_material_to_ingot"));
            SimpleCookingRecipeBuilder.blasting(Ingredient.of(metal.getOreBlockItem()), RecipeCategory.MISC, itemMetalObject.getIngot(), 0.7f, 100)
                    .group("metal")
                    .unlockedBy(getHasName(ore.get()), has(metal.getOreBlockItem()))
                    .save(consumer, location("blasting/"+metalName+"/ore_to_ingot"));

            SimpleCookingRecipeBuilder.smelting(Ingredient.of(metal.getDustTag()), RecipeCategory.MISC, itemMetalObject.getIngot(), 0.4f, 200)
                    .group("metal")
                    .unlockedBy(getHasName(itemMetalObject.getDust()), has(metal.getDustTag()))
                    .save(consumer, location("smelting/"+metalName+"/dust_to_ingot"));
            SimpleCookingRecipeBuilder.blasting(Ingredient.of(metal.getDustTag()), RecipeCategory.MISC, itemMetalObject.getIngot(), 0.4f, 100)
                    .group("metal")
                    .unlockedBy(getHasName(itemMetalObject.getDust()), has(metal.getDustTag()))
                    .save(consumer, location("blasting/"+metalName+"/dust_to_ingot"));
        }
    }

    public SmelteryRecipeBuilder metal(Consumer<FinishedRecipe> consumer, FluidObject<?> fluid) {
        return molten(consumer, fluid).castingFolder("smeltery/casting/metal").meltingFolder("smeltery/melting/metal");
    }

    @NotNull
    @Override
    public String getModId() {
        return TinkersReforged.MOD_ID;
    }
}
