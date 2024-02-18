package mrthomas20121.tinkers_reforged.datagen.tcon;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.cast.CastType;
import mrthomas20121.tinkers_reforged.api.cast.TinkerCastType;
import mrthomas20121.tinkers_reforged.api.material.*;
import mrthomas20121.tinkers_reforged.datagen.ReforgedByproduct;
import mrthomas20121.tinkers_reforged.init.*;
import mrthomas20121.tinkers_reforged.item.CastObject;
import net.minecraft.data.*;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
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
import slimeknights.mantle.recipe.data.ICommonRecipeHelper;
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

        for(EnumMetal metal: EnumMetal.values()) {
            blockIngotNuggetCompression(
                    consumer,
                    metal.getName(),
                    TinkersReforgedBlocks.METAL_BLOCKS.get(metal).get(EnumMetal.BlockType.BLOCK).get().asItem(),
                    TinkersReforgedItems.METALS.get(metal).get(EnumMetal.ItemType.INGOT).get(),
                    TinkersReforgedItems.METALS.get(metal).get(EnumMetal.ItemType.NUGGET).get()
            );
        }

        for(EnumGem gem: EnumGem.values()) {
            gemBlock(
                    consumer,
                    gem.getName(),
                    TinkersReforgedBlocks.GEMS_BLOCKS.get(gem).get().asItem(),
                    TinkersReforgedItems.GEMS.get(gem).get(EnumGem.ItemType.GEM).get()
            );
        }
    }

    public void alloyRecipes(Consumer<FinishedRecipe> consumer) {
        String alloyFolder = "smeltery/alloy/";

        for(EnumFluidAlloy alloy: EnumFluidAlloy.values()) {
            AlloyRecipeBuilder builder = AlloyRecipeBuilder.alloy(alloy.output.get(), alloy.temp);
            for(Supplier<FluidStack> s: alloy.inputs) {
                builder.addInput(s.get());
            }
            builder.save(consumer, modResource(alloyFolder+"magma_steel"));
        }
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

        materialRecipe(consumer, ReforgedMaterialIds.ender_bone, Ingredient.of(TinkersReforgedItems.ender_bone.get()), 1, 1, materialFolder + "ender_bone");

        Ingredient plate = Ingredient.of(TinkerTools.plateArmor.values().stream().map(ItemStack::new));

        // embellishment and material recipe
        for(EnumMaterial material: EnumMaterial.values()) {
            plateTexture(consumer, plate, material.id, false, slotless);

            if(material.equals(EnumMaterial.EPIDOTE) || material.equals(EnumMaterial.HUREAULITE) || material.equals(EnumMaterial.RED_BERYL)) {
                gemMaterialRecipe(consumer, material.id, materialFolder, material.getName());
            }
            else if(!material.equals(EnumMaterial.ENDER_BONE)) {
                materialMeltingCasting(consumer, material.id, TinkersReforgedFluids.ALL_FLUIDS.get(material.fluid), materialFolder);
                //metalMelting(consumer, TinkersReforgedFluids.ALL_FLUIDS.get(material.fluid).get(), "", false, meltingFolder, false);
                metalMaterialRecipe(consumer, material.id, materialFolder, material.getName(), false);
            }
        }

        EntityMeltingRecipeBuilder.melting(EntityIngredient.of(EntityType.SHULKER), new FluidStack(TinkerFluids.moltenEnder.get(), FluidValues.INGOT)).save(consumer, modResource(meltingFolder+"/entity/shulker"));

        ItemCastingRecipeBuilder.tableRecipe(TinkersReforgedItems.book.get())
                .setFluidAndTime(TinkerFluids.moltenAluminum, true, FluidValues.INGOT)
                .setCast(Items.BOOK, false)
                .save(consumer, modResource(castingFolder + "book"));

        ItemCastingRecipeBuilder.tableRecipe(TinkersReforgedItems.ender_bone.get())
                .setFluidAndTime(TinkerFluids.moltenEnder, true, FluidValues.SLIMEBALL)
                .setCast(Items.BONE, false)
                .save(consumer, modResource(castingFolder + "ender_bone"));

        MeltingRecipeBuilder.melting(Ingredient.of(TinkersReforgedTags.Items.ALUMINUM_CASTS), new FluidStack(TinkerFluids.moltenAluminum.get(), FluidValues.INGOT), 700, 50).save(consumer, new ResourceLocation(TinkersReforged.MOD_ID, "smeltery/aluminum_from_cast"));

        MeltingFuelBuilder.fuel(FluidIngredient.of(new FluidStack(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.BLAZIUM).get(), 50)), 150, 1800).save(consumer, modResource("smeltery/fuel/blazium"));

        MeltingFuelBuilder.fuel(FluidIngredient.of(new FluidStack(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.PROTO_LAVA).get(), 50)), 100, 2500).save(consumer, modResource("smeltery/fuel/proto_lava"));

        createCast(consumer, CastType.INGOT, Tags.Items.INGOTS, castFolder);
        createCast(consumer, CastType.NUGGET, Tags.Items.NUGGETS, castFolder);
        createCast(consumer, CastType.GEM, Tags.Items.GEMS, castFolder);
        createCast(consumer, CastType.ROD, Tags.Items.RODS, castFolder);

        createCast(consumer, CastType.PLATE, "plates", castFolder);
        createCast(consumer, CastType.GEAR, "gears", castFolder);
        createCast(withCondition(consumer, new NotCondition(new TagEmptyCondition("forge:coins"))), CastType.COIN, "coins", castFolder);
        createCast(withCondition(consumer, new NotCondition(new TagEmptyCondition("forge:wires"))), CastType.WIRE, "wires", castFolder);

        createCast(consumer, CastType.BROAD_AXE_HEAD, TinkerToolParts.broadAxeHead.get(), castFolder);
        createCast(consumer, CastType.BROAD_BLADE, TinkerToolParts.broadBlade.get(), castFolder);
        createCast(consumer, CastType.HAMMER_HEAD, TinkerToolParts.hammerHead.get(), castFolder);
        createCast(consumer, CastType.ROUND_PLATE, TinkerToolParts.roundPlate.get(), castFolder);
        createCast(consumer, CastType.LARGE_PLATE, TinkerToolParts.largePlate.get(), castFolder);
        createCast(consumer, CastType.PICK_HEAD, TinkerToolParts.pickHead.get(), castFolder);
        createCast(consumer, CastType.REPAIR_KIT, TinkerToolParts.repairKit.get(), castFolder);
        createCast(consumer, CastType.SMALL_AXE_HEAD, TinkerToolParts.smallAxeHead.get(), castFolder);
        createCast(consumer, CastType.SMALL_BLADE, TinkerToolParts.smallBlade.get(), castFolder);
        createCast(consumer, CastType.TOOL_BINDING, TinkerToolParts.toolBinding.get(), castFolder);
        createCast(consumer, CastType.TOOL_HANDLE, TinkerToolParts.toolHandle.get(), castFolder);
        createCast(consumer, CastType.TOUGH_HANDLE, TinkerToolParts.toughHandle.get(), castFolder);

        createCast(consumer, CastType.GREAT_BLADE, TinkersReforgedItems.GREAT_BLADE.get(), castFolder);
        createCast(consumer, CastType.LONG_BLADE, TinkersReforgedItems.LONG_BLADE.get(), castFolder);

        for(EnumMetal metal: EnumMetal.values()) {

            if(metal.isThisOre()) {
                Supplier<Item> ingot = TinkersReforgedItems.METALS.get(metal).get(EnumMetal.ItemType.INGOT);
                oreFurnace(consumer, TinkersReforgedTags.Items.METAL_ORES.get(metal), ingot, metal.getName(), false);
                oreFurnace(consumer, TinkersReforgedTags.Items.METAL_RAW_ORES.get(metal), ingot, metal.getName(), true);

                ShapelessRecipeBuilder.shapeless(TinkersReforgedItems.RAW_ORES.get(metal).get(), 9)
                        .requires(TinkersReforgedBlocks.RAW_ORES.get(metal).get())
                        .group("building")
                        .unlockedBy("has_item", has(TinkersReforgedItems.RAW_ORES.get(metal).get()))
                        .save(consumer, modResource("crafting/raw_"+metal.getName()));
            }

            metalMelting(consumer, metal.fluid.get(), metal.getName(), metal.isThisOre(), meltingFolder, false);
            metalCasting(consumer, metal.fluid, TinkersReforgedBlocks.METAL_BLOCKS.get(metal).get(EnumMetal.BlockType.BLOCK).get(), TinkersReforgedItems.METALS.get(metal).get(EnumMetal.ItemType.INGOT).get(), TinkersReforgedItems.METALS.get(metal).get(EnumMetal.ItemType.NUGGET).get(), castingFolder, metal.getName());

            Item ingot = TinkersReforgedItems.METALS.get(metal).get(EnumMetal.ItemType.INGOT).get();
            Item dust = TinkersReforgedItems.METALS.get(metal).get(EnumMetal.ItemType.DUST).get();
            SimpleCookingRecipeBuilder.smelting(Ingredient.of(dust), ingot, 0, 200).unlockedBy("has_item", has(ingot)).save(consumer, modResource("tinkers_reforged:crafting/%s_ingot_from_smelting_%s_dust".formatted(metal.getName(), metal.getName())));
        }

        for(EnumGem gem: EnumGem.values()) {
            FluidObject<ForgeFlowingFluid> fluid = TinkersReforgedFluids.ALL_FLUIDS.get(gem.fluid);

            Supplier<Item> gemItem = TinkersReforgedItems.GEMS.get(gem).get(EnumGem.ItemType.GEM);
            oreFurnace(consumer, TinkersReforgedTags.Items.GEM_ORES.get(gem), gemItem, gem.getName(), false);
            oreFurnace(consumer, TinkersReforgedTags.Items.GEM_ORES.get(gem), gemItem, gem.getName(), true);

            gemMeltingCasting(consumer, TinkersReforgedItems.GEMS.get(gem).get(EnumGem.ItemType.GEM), TinkersReforgedBlocks.GEMS_BLOCKS.get(gem), fluid, "smeltery", gem.getName(), ReforgedByproduct.ALUMINUM);

            Item dust = TinkersReforgedItems.GEMS.get(gem).get(EnumGem.ItemType.DUST).get();
            SimpleCookingRecipeBuilder.smelting(Ingredient.of(dust), gemItem.get(), 0, 200).unlockedBy("has_item", has(gemItem.get())).save(consumer, modResource("tinkers_reforged:crafting/%s_gem_from_smelting_%s_dust".formatted(gem.getName(), gem.getName())));
        }

        toolBuilding(consumer, TinkersReforgedItems.LONGSWORD, toolFolder);
        toolBuilding(consumer, TinkersReforgedItems.GREATSWORD, toolFolder);
        partRecipes(consumer, TinkersReforgedItems.GREAT_BLADE.get(), TinkerCastType.Type.GREAT_BLADE, 4, partFolder, castFolder);
        partRecipes(consumer, TinkersReforgedItems.LONG_BLADE.get(), TinkerCastType.Type.LONG_BLADE, 3, partFolder, castFolder);
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

    private void metalComposite(Consumer<FinishedRecipe> consumer, Item input, ItemLike output, FluidObject<?> fluid, boolean forgeTag, String folder, String name) {
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
        Item cast = TinkersReforgedItems.castMap.get(type).get();
        this.createCast(consumer, cast, MaterialIngredient.fromItem(part), folder);
    }

    public void createCast(Consumer<FinishedRecipe> consumer, CastType type, String input, String folder) {
        this.createCast(consumer, type, getItemTag("forge", input), folder);
    }

    public void createCast(Consumer<FinishedRecipe> consumer, CastType type, TagKey<Item> input, String folder) {
        Item cast = TinkersReforgedItems.castMap.get(type).get();
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

    private void partRecipes(Consumer<FinishedRecipe> consumer, IMaterialItem part, TinkerCastType.Type cast, int cost, String partFolder, String castFolder) {
        String name = Objects.requireNonNull(part.asItem().getRegistryName()).getPath();
        CastObject object = new CastObject(cast.getName());

        // Part Builder
        PartRecipeBuilder.partRecipe(part)
                .setPattern(modResource(name))
                .setPatternItem(CompoundIngredient.of(Ingredient.of(TinkerTags.Items.DEFAULT_PATTERNS), Ingredient.of(TinkersReforgedItems.CASTS.get(TinkerCastType.GOLD).get(cast).get())))
                .setCost(cost)
                .save(consumer, modResource(partFolder + "builder/" + name));

        // Material Casting
        String castingFolder = partFolder + "casting/";
        MaterialCastingRecipeBuilder.tableRecipe(part)
                .setItemCost(cost)
                .setCast(object.getMultiUseTag(), false)
                .save(consumer, modResource(castingFolder + name + "_gold_cast"));
        MaterialCastingRecipeBuilder.tableRecipe(part)
                .setItemCost(cost)
                .setCast(object.getSingleUseTag(), true)
                .save(consumer, modResource(castingFolder + name + "_sand_cast"));
        CompositeCastingRecipeBuilder.table(part, cost)
                .save(consumer, modResource(castingFolder + name + "_composite"));

        // Cast Casting
        MaterialIngredient ingredient = MaterialIngredient.fromItem(part);
        castCreation(consumer, ingredient, cast, castFolder, Objects.requireNonNull(part.asItem().getRegistryName()).getPath());
    }

    private void castCreation(Consumer<FinishedRecipe> consumer, Ingredient input, TinkerCastType.Type cast, String folder, String name) {
        ItemCastingRecipeBuilder.tableRecipe(TinkersReforgedItems.CASTS.get(TinkerCastType.GOLD).get(cast).get())
                .setFluidAndTime(TinkerFluids.moltenGold, true, FluidValues.INGOT)
                .setCast(input, true)
                .setSwitchSlots()
                .save(consumer, modResource(folder + "gold_casts/" + name));
        MoldingRecipeBuilder.moldingTable(TinkersReforgedItems.CASTS.get(TinkerCastType.SAND).get(cast).get())
                .setMaterial(TinkerSmeltery.blankSandCast)
                .setPattern(input, false)
                .save(consumer, modResource(folder + "sand_casts/" + name));
        MoldingRecipeBuilder.moldingTable(TinkersReforgedItems.CASTS.get(TinkerCastType.RED_SAND).get(cast).get())
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

        gemMelting(consumer, fluid.get(), name, true, 9, meltingFolder, false, byproduct);
    }

    private void gemBlockCasting(Consumer<FinishedRecipe> consumer, Supplier<Block> block, FluidObject<ForgeFlowingFluid> fluid, String folder) {
        ItemCastingRecipeBuilder.basinRecipe(block.get())
                .setFluidAndTime(fluid, true, FluidValues.LARGE_GEM_BLOCK)
                .setSwitchSlots()
                .save(consumer, modResource(folder));
    }
}
