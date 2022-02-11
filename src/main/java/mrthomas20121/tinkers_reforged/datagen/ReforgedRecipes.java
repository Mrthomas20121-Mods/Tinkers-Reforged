package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.CastItems;
import mrthomas20121.tinkers_reforged.api.CastType;
import mrthomas20121.tinkers_reforged.init.Resources;
import net.minecraft.data.*;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.fluids.FluidStack;
import slimeknights.mantle.recipe.FluidIngredient;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.data.recipe.*;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.recipe.FluidValues;
import slimeknights.tconstruct.library.recipe.alloying.AlloyRecipeBuilder;
import slimeknights.tconstruct.library.recipe.casting.ItemCastingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.casting.material.MaterialFluidRecipeBuilder;
import slimeknights.tconstruct.library.recipe.fuel.MeltingFuelBuilder;
import slimeknights.tconstruct.library.recipe.ingredient.MaterialIngredient;
import slimeknights.tconstruct.library.recipe.melting.MeltingRecipeBuilder;
import slimeknights.tconstruct.library.tools.part.IMaterialItem;
import slimeknights.tconstruct.shared.TinkerMaterials;
import slimeknights.tconstruct.smeltery.data.Byproduct;
import slimeknights.tconstruct.tools.TinkerToolParts;
import slimeknights.tconstruct.tools.data.material.MaterialIds;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Consumer;

public class ReforgedRecipes extends RecipeProvider implements IConditionBuilder, IMaterialRecipeHelper, IToolRecipeHelper, ISmelteryRecipeHelper, ICommonRecipeHelper {

    public ReforgedRecipes(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void buildShapelessRecipes(@Nonnull Consumer<IFinishedRecipe> consumer) {

        String materialFolder = "materials/";
        String meltingFolder = "melting/";
        String castingFolder = "casting/";
        String castFolder = "smeltery/casts/";

        String alloyFolder = "alloy/";

        blockIngotNuggetCompression(consumer, "aluminum", Resources.aluminum_block.get().asItem(), Resources.aluminum_ingot.get(), Resources.aluminum_nugget.get());
        blockIngotNuggetCompression(consumer, "duralumin", Resources.duralumin_block.get().asItem(), Resources.duralumin_ingot.get(), Resources.duralumin_nugget.get());
        blockIngotNuggetCompression(consumer, "electrical_copper", Resources.electrical_copper_block.get().asItem(), Resources.electrical_copper_ingot.get(), Resources.electrical_copper_nugget.get());
        blockIngotNuggetCompression(consumer, "lavium", Resources.lavium_block.get().asItem(), Resources.lavium_ingot.get(), Resources.lavium_nugget.get());
        blockIngotNuggetCompression(consumer, "qivium", Resources.qivium_block.get().asItem(), Resources.qivium_ingot.get(), Resources.qivium_nugget.get());

        metalCasting(consumer, Resources.duralumin.asObject(), Resources.duralumin_block.get(), Resources.duralumin_ingot.get(), Resources.duralumin_nugget.get(), castingFolder, "duralumin");
        metalCasting(consumer, Resources.electrical_copper.asObject(), Resources.electrical_copper_block.get(), Resources.electrical_copper_ingot.get(), Resources.electrical_copper_nugget.get(), castingFolder, "electrical_copper");
        metalCasting(consumer, Resources.lavium.asObject(), Resources.lavium_block.get(), Resources.lavium_ingot.get(), Resources.lavium_nugget.get(), castingFolder, "lavium");
        metalCasting(consumer, Resources.qivium.asObject(), Resources.qivium_block.get(), Resources.qivium_ingot.get(), Resources.qivium_nugget.get(), castingFolder, "qivium");

        materialMeltingCasting(consumer, ReforgedMaterials.duralumin, Resources.duralumin.asObject(), materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterials.electrical_copper, Resources.electrical_copper.asObject(), materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterials.lavium, Resources.lavium.asObject(), materialFolder);
        materialMeltingCasting(consumer, ReforgedMaterials.qivium, Resources.qivium.asObject(), materialFolder);

        metalMelting(consumer, Resources.duralumin.getFluid(), "duralumin", false, meltingFolder, false);
        metalMelting(consumer, Resources.electrical_copper.getFluid(), "electrical_copper", false, meltingFolder, false);
        metalMelting(consumer, Resources.lavium.getFluid(), "lavium", false, meltingFolder, false);
        metalMelting(consumer, Resources.qivium.getFluid(), "qivium", false, meltingFolder, false);

        metalMaterialRecipe(consumer, ReforgedMaterials.duralumin, materialFolder, "duralumin", false);
        metalMaterialRecipe(consumer, ReforgedMaterials.electrical_copper, materialFolder, "electrical_copper", false);
        metalMaterialRecipe(consumer, ReforgedMaterials.lavium, materialFolder, "lavium", false);
        metalMaterialRecipe(consumer, ReforgedMaterials.qivium, materialFolder, "qivium", false);

        materialComposite(consumer, MaterialIds.cobalt, ReforgedMaterials.lavium, TinkerFluids.liquidSoul, 500, false, materialFolder+"lavium_");
        materialComposite(consumer, MaterialIds.cobalt, ReforgedMaterials.qivium, TinkerFluids.magma, 500, true, materialFolder+"qivium_");
        metalComposite(consumer, TinkerMaterials.cobalt.getIngot(), Resources.lavium_ingot.get(), TinkerFluids.liquidSoul, false, materialFolder, "lavium");
        metalComposite(consumer, TinkerMaterials.cobalt.getIngot(), Resources.qivium_ingot.get(), TinkerFluids.magma, true, materialFolder, "qivium");

        metalComposite(consumer, Items.REDSTONE, Resources.electrical_copper_dust.get(), Resources.blazing_copper.asObject(), true, materialFolder, "electrical_copper");

        AlloyRecipeBuilder.alloy(Resources.duralumin.getFluid(), FluidValues.INGOT*4)
                .addInput(TinkerFluids.moltenCopper.get(), FluidValues.INGOT)
                .addInput(TinkerFluids.moltenAluminum.get(), FluidValues.METAL_BLOCK)
                .build(consumer, prefix(Resources.duralumin.getBlock(), alloyFolder));

        AlloyRecipeBuilder.alloy(Resources.blazing_copper.getFluid(), FluidValues.GLASS_BLOCK)
                .addInput(TinkerFluids.moltenCopper.get(), FluidValues.METAL_BLOCK)
                .addInput(TinkerFluids.blazingBlood.get(), FluidValues.GLASS_BLOCK)
                .build(consumer, prefix(Resources.blazing_copper.getBlock(), alloyFolder));

        AlloyRecipeBuilder.alloy(Resources.electrical_copper.getFluid(), FluidValues.INGOT)
                .addInput(Resources.blazing_copper.getFluid(), FluidValues.INGOT*2)
                .addInput(Resources.redstone.getFluid(), FluidValues.GLASS_BLOCK)
                .build(consumer, prefix(Resources.electrical_copper.getBlock(), alloyFolder));

        ItemCastingRecipeBuilder.tableRecipe(CastItems.casts.get(CastType.blank).get())
                .setFluidAndTime(TinkerFluids.moltenAluminum, true, FluidValues.INGOT)
                .setSwitchSlots()
                .build(consumer, modResource(castFolder+"blank"));

        MeltingRecipeBuilder.melting(Ingredient.of(ReforgedItemsTags.ALUMINUM_CASTS), new FluidStack(TinkerFluids.moltenAluminum.get().getFluid(), FluidValues.INGOT), 700, 50).build(consumer, new ResourceLocation(TinkersReforged.MOD_ID, "smeltery/aluminum_from_cast"));
        MeltingRecipeBuilder.melting(Ingredient.of(Items.REDSTONE), new FluidStack(Resources.redstone.getFluid(), 100), 700, 50).build(consumer, new ResourceLocation(TinkersReforged.MOD_ID, "smeltery/redstone_dust"));
        MeltingRecipeBuilder.melting(Ingredient.of(Items.REDSTONE_BLOCK), new FluidStack(Resources.redstone.getFluid(), 900), 700, 50).build(consumer, new ResourceLocation(TinkersReforged.MOD_ID, "smeltery/redstone_block"));
        oreMelting(consumer, Resources.redstone.getFluid(), 200, "ores/redstone", 1.5f, "smeltery/redstone_ore", false, Byproduct.TIN);

        MeltingFuelBuilder.fuel(FluidIngredient.of(new FluidStack(Resources.blazing_copper.getFluid(), 50)), 150, 1500).build(consumer, new ResourceLocation(TinkersReforged.MOD_ID, "smeltery/fuel/blazing_copper_fuel"));

        addCast(consumer, CastType.ingot, Tags.Items.INGOTS, castFolder);
        addCast(consumer, CastType.nugget, Tags.Items.NUGGETS, castFolder);
        addCast(consumer, CastType.gem, Tags.Items.GEMS, castFolder);
        addCast(consumer, CastType.rod, Tags.Items.RODS, castFolder);

        addCast(consumer, CastType.plate, "plates", castFolder);
        addCast(consumer, CastType.gear, "gears", castFolder);
        addCast(consumer, CastType.coin, "coins", castFolder);
        addCast(consumer, CastType.wire, "wires", castFolder);

        addCast(consumer, CastType.broad_axe_head, TinkerToolParts.broadAxeHead.get(), castFolder);
        addCast(consumer, CastType.broad_blade, TinkerToolParts.broadBlade.get(), castFolder);
        addCast(consumer, CastType.hammer_head, TinkerToolParts.hammerHead.get(), castFolder);
        addCast(consumer, CastType.large_plate, TinkerToolParts.largePlate.get(), castFolder);
        addCast(consumer, CastType.pickaxe_head, TinkerToolParts.pickaxeHead.get(), castFolder);
        addCast(consumer, CastType.repair_kit, TinkerToolParts.repairKit.get(), castFolder);
        addCast(consumer, CastType.small_axe_head, TinkerToolParts.smallAxeHead.get(), castFolder);
        addCast(consumer, CastType.small_blade, TinkerToolParts.smallBlade.get(), castFolder);
        addCast(consumer, CastType.tool_binding, TinkerToolParts.toolBinding.get(), castFolder);
        addCast(consumer, CastType.tool_handle, TinkerToolParts.toolHandle.get(), castFolder);
        addCast(consumer, CastType.tough_handle, TinkerToolParts.toughHandle.get(), castFolder);
    }

    @Nonnull
    @Override
    public String getModId() {
        return TinkersReforged.MOD_ID;
    }

    private void metalComposite(Consumer<IFinishedRecipe> consumer, Item input, Item output, FluidObject<?> fluid, boolean forgeTag, String folder, String name) {
        ItemCastingRecipeBuilder.tableRecipe(output)
                .setFluidAndTime(fluid, forgeTag, FluidValues.INGOT)
                .setCast(input, true)
                .setSwitchSlots()
                .build(consumer, modResource(folder + "/metal/" + name));
    }

    public void addCast(Consumer<IFinishedRecipe> consumer, CastType type, IMaterialItem part, String folder) {
        Item cast = CastItems.casts.get(type).get();
        castCreation(consumer, MaterialIngredient.fromItem(part), cast, folder, Objects.requireNonNull(part.asItem().getRegistryName()).getPath());
    }

    public void addCast(Consumer<IFinishedRecipe> consumer, CastType type, ITag.INamedTag<Item> tag, String folder) {
        Item cast = CastItems.casts.get(type).get();
        castCreation(consumer, tag, cast, folder);
    }

    public void addCast(Consumer<IFinishedRecipe> consumer, CastType type, String tag, String folder) {
        Item cast = CastItems.casts.get(type).get();
        castCreation(withCondition(consumer, tagCondition(tag)), getTag("forge", tag), cast, folder);
    }

    public void blockIngotNuggetCompression(Consumer<IFinishedRecipe> consumer, String name, Item block, Item ingot, Item nugget) {
        ConditionalRecipe.builder().addCondition(this.TRUE()).addRecipe(
                        ShapedRecipeBuilder.shaped(block, 1)
                                .pattern("XXX")
                                .pattern("XYX")
                                .pattern("XXX")
                                .define('X', ItemTags.bind("forge:ingots/" + name))
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
                                .define('X', ItemTags.bind("forge:nuggets/" + name))
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

    /**
     * Adds recipe to create a cast
     * @param consumer  Recipe consumer
     * @param input     Item consumed to create cast
     * @param cast      Produced cast
     * @param folder    Output folder
     */
    private void castCreation(Consumer<IFinishedRecipe> consumer, ITag.INamedTag<Item> input, Item cast, String folder) {
        castCreation(consumer, Ingredient.of(input), cast, folder, input.getName().getPath());
    }

    /**
     * Adds recipe to create a cast
     * @param consumer  Recipe consumer
     * @param input     Item consumed to create cast
     * @param cast      Produced cast
     * @param folder    Output folder
     * @param name      Cast name
     */
    private void castCreation(Consumer<IFinishedRecipe> consumer, Ingredient input, Item cast, String folder, String name) {
        ItemCastingRecipeBuilder.tableRecipe(cast)
                .setFluidAndTime(TinkerFluids.moltenAluminum, true, FluidValues.INGOT)
                .setCast(input, true)
                .setSwitchSlots()
                .build(consumer, modResource(folder + "aluminum_casts/" + name));
    }
}
