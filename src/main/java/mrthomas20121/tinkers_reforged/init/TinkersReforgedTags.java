package mrthomas20121.tinkers_reforged.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class TinkersReforgedTags {

    public static void init() {
        Blocks.init();
        Items.init();
        Fluids.init();
    }

    public static class Blocks {

        public static void init() {}

        private static TagKey<Block> create(String name) {
            return BlockTags.create(new ResourceLocation(name));
        }

        // terra modifier tag
        public static final TagKey<Block> ROCK_TYPE_BLOCKS = create("tinkers_reforged:rock_type_blocks");
        // ores
        public static final TagKey<Block> ALUMINUM_ORE = create("forge:ores/aluminum");
        public static final TagKey<Block> KEPU_ORE = create("forge:ores/kepu");
        public static final TagKey<Block> EPIDOTE_ORE = create("forge:ores/epidote");
        public static final TagKey<Block> HUREAULITE_ORE = create("forge:ores/hureaulite");
        public static final TagKey<Block> RED_BERYL_ORE = create("forge:ores/red_beryl");

        // storage blocks
        public static final TagKey<Block> BLAZING_COPPER = create("forge:storage_blocks/blazing_copper");
        public static final TagKey<Block> DURALUMIN = create("forge:storage_blocks/duralumin");
        public static final TagKey<Block> ALUMINUM = create("forge:storage_blocks/aluminum");
        public static final TagKey<Block> ELECTRICAL_COPPER = create("forge:storage_blocks/electrical_copper");
        public static final TagKey<Block> LAVIUM = create("forge:storage_blocks/lavium");
        public static final TagKey<Block> QIVIUM = create("forge:storage_blocks/qivium");
        public static final TagKey<Block> GAUSUM = create("forge:storage_blocks/gausum");
        public static final TagKey<Block> FELSTEEL = create("forge:storage_blocks/felsteel");
        public static final TagKey<Block> KEPU = create("forge:storage_blocks/kepu");
        public static final TagKey<Block> DURASTEEL = create("forge:storage_blocks/durasteel");
        public static final TagKey<Block> CHORUS_METAl = create("forge:storage_blocks/chorus_metal");
        public static final TagKey<Block> CRUSTEEL = create("forge:storage_blocks/crusteel");
        public static final TagKey<Block> WAVY = create("forge:storage_blocks/wavy");
        public static final TagKey<Block> YOKEL = create("forge:storage_blocks/yokel");
        public static final TagKey<Block> BAOLIAN = create("forge:storage_blocks/baolian");
        public static final TagKey<Block> EPIDOTE = create("forge:storage_blocks/epidote");
        public static final TagKey<Block> GALU = create("forge:storage_blocks/galu");
        public static final TagKey<Block> MAGMA_STEEL = create("forge:storage_blocks/magma_steel");
        public static final TagKey<Block> CYBER_STEEL = create("forge:storage_blocks/cyber_steel");
        public static final TagKey<Block> HUREAULITE = create("forge:storage_blocks/yokel");
        public static final TagKey<Block> RED_BERYL = create("forge:storage_blocks/red_beryl");

        // raw blocks
        public static final TagKey<Block> RAW_ALUMINUM = create("forge:storage_blocks/raw_aluminum");
        public static final TagKey<Block> RAW_KEPU = create("forge:storage_blocks/raw_kepu");
    }

    public static class Items {

        public static void init() {}

        private static TagKey<Item> create(String name) {
            return ItemTags.create(new ResourceLocation(name));
        }

        // ores
        public static final TagKey<Item> ALUMINUM_ORE = create("forge:ores/aluminum");
        public static final TagKey<Item> KEPU_ORE = create("forge:ores/kepu");
        public static final TagKey<Item> EPIDOTE_ORE = create("forge:ores/epidote");
        public static final TagKey<Item> HUREAULITE_ORE = create("forge:ores/hureaulite");
        public static final TagKey<Item> RED_BERYL_ORE = create("forge:ores/red_beryl");

        // storage blocks
        public static final TagKey<Item> BLAZING_COPPER_BLOCK = create("forge:storage_blocks/blazing_copper");
        public static final TagKey<Item> DURALUMIN_BLOCK = create("forge:storage_blocks/duralumin");
        public static final TagKey<Item> ALUMINUM_BLOCK = create("forge:storage_blocks/aluminum");
        public static final TagKey<Item> ELECTRICAL_COPPER_BLOCK = create("forge:storage_blocks/electrical_copper");
        public static final TagKey<Item> LAVIUM_BLOCK = create("forge:storage_blocks/lavium");
        public static final TagKey<Item> QIVIUM_BLOCK = create("forge:storage_blocks/qivium");
        public static final TagKey<Item> GAUSUM_BLOCK = create("forge:storage_blocks/gausum");
        public static final TagKey<Item> FELSTEEL_BLOCK = create("forge:storage_blocks/felsteel");
        public static final TagKey<Item> KEPU_BLOCK = create("forge:storage_blocks/kepu");
        public static final TagKey<Item> MAGMA_STEEL_BLOCK = create("forge:storage_blocks/magma_steel");
        public static final TagKey<Item> CYBER_STEEL_BLOCK = create("forge:storage_blocks/cyber_steel");
        public static final TagKey<Item> DURASTEEL_BLOCK = create("forge:storage_blocks/durasteel");
        public static final TagKey<Item> CHORUS_METAl_BLOCK = create("forge:storage_blocks/chorus_metal");
        public static final TagKey<Item> CRUSTEEL_BLOCK = create("forge:storage_blocks/crusteel");
        public static final TagKey<Item> WAVY_BLOCK = create("forge:storage_blocks/wavy");
        public static final TagKey<Item> YOKEL_BLOCK = create("forge:storage_blocks/yokel");
        public static final TagKey<Item> BAOLIAN_BLOCK = create("forge:storage_blocks/baolian");
        public static final TagKey<Item> EPIDOTE_BLOCK = create("forge:storage_blocks/epidote");
        public static final TagKey<Item> HUREAULITE_BLOCK = create("forge:storage_blocks/hureaulite");
        public static final TagKey<Item> GALU_BLOCK = create("forge:storage_blocks/galu");
        public static final TagKey<Item> RED_BERYL_BLOCK = create("forge:storage_blocks/red_beryl");

        // raw blocks
        public static final TagKey<Item> RAW_ALUMINUM_BLOCK = create("forge:storage_blocks/raw_aluminum");
        public static final TagKey<Item> RAW_KEPU_BLOCK = create("forge:storage_blocks/raw_kepu");

        public static final TagKey<Item> RAW_ALUMINUM = create("forge:raw_materials/aluminum");
        public static final TagKey<Item> RAW_KEPU = create("forge:raw_materials/raw_kepu");

        public static final TagKey<Item> BLAZING_COPPER_INGOT = create("forge:ingots/blazing_copper");
        public static final TagKey<Item> BLAZING_COPPER_DUST = create("forge:dusts/blazing_copper");
        public static final TagKey<Item> BLAZING_COPPER_NUGGET = create("forge:nuggets/blazing_copper");

        public static final TagKey<Item> DURALUMIN_INGOT = create("forge:ingots/duralumin");
        public static final TagKey<Item> DURALUMIN_DUST = create("forge:dusts/duralumin");
        public static final TagKey<Item> DURALUMIN_NUGGET = create("forge:nuggets/duralumin");

        public static final TagKey<Item> ELECTRICAL_COPPER_INGOT = create("forge:ingots/electrical_copper");
        public static final TagKey<Item> ELECTRICAL_COPPER_DUST = create("forge:dusts/electrical_copper");
        public static final TagKey<Item> ELECTRICAL_COPPER_NUGGET = create("forge:nuggets/electrical_copper");

        public static final TagKey<Item> LAVIUM_INGOT = create("forge:ingots/lavium");
        public static final TagKey<Item> LAVIUM_DUST = create("forge:dusts/lavium");
        public static final TagKey<Item> LAVIUM_NUGGET = create("forge:nuggets/lavium");

        public static final TagKey<Item> QIVIUM_INGOT = create("forge:ingots/qivium");
        public static final TagKey<Item> QIVIUM_DUST = create("forge:dusts/qivium");
        public static final TagKey<Item> QIVIUM_NUGGET = create("forge:nuggets/qivium");

        public static final TagKey<Item> ALUMINUM_INGOT = create("forge:ingots/aluminum");
        public static final TagKey<Item> ALUMINUM_DUST = create("forge:dusts/aluminum");
        public static final TagKey<Item> ALUMINUM_NUGGET = create("forge:nuggets/aluminum");

        public static final TagKey<Item> GAUSUM_INGOT = create("forge:ingots/gausum");
        public static final TagKey<Item> GAUSUM_DUST = create("forge:dusts/gausum");
        public static final TagKey<Item> GAUSUM_NUGGET = create("forge:nuggets/gausum");

        public static final TagKey<Item> FELSTEEL_INGOT = create("forge:ingots/felsteel");
        public static final TagKey<Item> FELSTEEL_DUST = create("forge:dusts/felsteel");
        public static final TagKey<Item> FELSTEEL_NUGGET = create("forge:nuggets/felsteel");

        public static final TagKey<Item> CHORUS_METAL_INGOT = create("forge:ingots/chorus_metal");
        public static final TagKey<Item> CHORUS_METAL_DUST = create("forge:dusts/chorus_metal");
        public static final TagKey<Item> CHORUS_METAL_NUGGET = create("forge:nuggets/chorus_metal");

        public static final TagKey<Item> KEPU_INGOT = create("forge:ingots/kepu");
        public static final TagKey<Item> KEPU_DUST = create("forge:dusts/kepu");
        public static final TagKey<Item> KEPU_NUGGET = create("forge:nuggets/kepu");

        public static final TagKey<Item> MAGMA_STEEL_INGOT = create("forge:ingots/magma_steel");
        public static final TagKey<Item> MAGMA_STEEL_DUST = create("forge:dusts/magma_steel");
        public static final TagKey<Item> MAGMA_STEEL_NUGGET = create("forge:nuggets/magma_steel");

        public static final TagKey<Item> CYBER_STEEL_INGOT = create("forge:ingots/cyber_steel");
        public static final TagKey<Item> CYBER_STEEL_DUST = create("forge:dusts/cyber_steel");
        public static final TagKey<Item> CYBER_STEEL_NUGGET = create("forge:nuggets/cyber_steel");

        public static final TagKey<Item> DURASTEEL_INGOT = create("forge:ingots/durasteel");
        public static final TagKey<Item> DURASTEEL_DUST = create("forge:dusts/durasteel");
        public static final TagKey<Item> DURASTEEL_NUGGET = create("forge:nuggets/durasteel");

        public static final TagKey<Item> CRUSTEEL_INGOT = create("forge:ingots/crusteel");
        public static final TagKey<Item> CRUSTEEL_DUST = create("forge:dusts/crusteel");
        public static final TagKey<Item> CRUSTEEL_NUGGET = create("forge:nuggets/crusteel");

        public static final TagKey<Item> WAVY_INGOT = create("forge:ingots/wavy");
        public static final TagKey<Item> WAVY_DUST = create("forge:dusts/wavy");
        public static final TagKey<Item> WAVY_NUGGET = create("forge:nuggets/wavy");

        public static final TagKey<Item> YOKEL_INGOT = create("forge:ingots/yokel");
        public static final TagKey<Item> YOKEL_DUST = create("forge:dusts/yokel");
        public static final TagKey<Item> YOKEL_NUGGET = create("forge:nuggets/yokel");

        public static final TagKey<Item> BAOLIAN_INGOT = create("forge:ingots/baolian");
        public static final TagKey<Item> BAOLIAN_DUST = create("forge:dusts/baolian");
        public static final TagKey<Item> BAOLIAN_NUGGET = create("forge:nuggets/baolian");

        public static final TagKey<Item> EPIDOTE_GEM = create("forge:gems/epidote");

        public static final TagKey<Item> GALU_INGOT = create("forge:ingots/galu");
        public static final TagKey<Item> GALU_DUST = create("forge:dusts/galu");
        public static final TagKey<Item> GALU_NUGGET = create("forge:nuggets/galu");

        public static final TagKey<Item> HUREAULITE_GEM = create("forge:gems/hureaulite");

        public static final TagKey<Item> RED_BERYL_GEM = create("forge:gems/red_beryl");

        public static final TagKey<Item> ALUMINUM_CASTS = create("tinkers_reforged:casts/aluminum");
    }

    public static class Fluids {

        public static void init() {}

        private static TagKey<Fluid> create(String name) {
            return FluidTags.create(new ResourceLocation(name));
        }

        // forge tags
        public static final TagKey<Fluid> DURALUMIN = create("forge:molten_duralumin");
        public static final TagKey<Fluid> ELECTRICAL_COPPER = create("forge:molten_electrical_copper");
        public static final TagKey<Fluid> LAVIUM = create("forge:molten_lavium");
        public static final TagKey<Fluid> QIVIUM = create("forge:molten_qivium");
        public static final TagKey<Fluid> BLAZING_COPPER = create("forge:molten_blazing_copper");
        public static final TagKey<Fluid> LAPIS = create("forge:molten_lapis");
        public static final TagKey<Fluid> GAUSUM = create("forge:molten_gausum");
        public static final TagKey<Fluid> REDSTONE = create("forge:redstone");
        public static final TagKey<Fluid> FELSTEEL = create("forge:molten_felsteel");
        public static final TagKey<Fluid> KEPU = create("forge:molten_kepu");
        public static final TagKey<Fluid> CHRORUS_METAL = create("forge:molten_chorus_metal");
        public static final TagKey<Fluid> CHORUS = create("forge:molten_chorus");
        public static final TagKey<Fluid> SHULKER = create("forge:molten_shulker");
        public static final TagKey<Fluid> DURASTEEL = create("forge:molten_durasteel");
        public static final TagKey<Fluid> CRUSTEEL = create("forge:molten_crusteel");
        public static final TagKey<Fluid> WAVY = create("forge:molten_wavy");
        public static final TagKey<Fluid> YOKEL = create("forge:molten_yokel");
        public static final TagKey<Fluid> KELP = create("forge:molten_kelp");
        public static final TagKey<Fluid> PROTO_LAVA = create("forge:molten_proto_lava");
        public static final TagKey<Fluid> BAOLIAN = create("forge:molten_baolian");
        public static final TagKey<Fluid> EPIDOTE = create("forge:molten_epidote");
        public static final TagKey<Fluid> GALU = create("forge:molten_galu");
        public static final TagKey<Fluid> COAL = create("forge:coal");
        public static final TagKey<Fluid> MAGMA_STEEL = create("forge:molten_magma_steel");
        public static final TagKey<Fluid> CYBER_STEEL = create("forge:molten_cyber_steel");
        public static final TagKey<Fluid> HUREAULITE = create("forge:molten_hureaulite");
        public static final TagKey<Fluid> RED_BERYL = create("forge:molten_red_beryl");

        // tinkers reforged tags
        public static final TagKey<Fluid> DURALUMIN_ = create("tinkers_reforged:molten_duralumin");
        public static final TagKey<Fluid> ELECTRICAL_COPPER_ = create("tinkers_reforged:molten_electrical_copper");
        public static final TagKey<Fluid> LAVIUM_ = create("tinkers_reforged:molten_lavium");
        public static final TagKey<Fluid> QIVIUM_ = create("tinkers_reforged:molten_qivium");
        public static final TagKey<Fluid> BLAZING_COPPER_ = create("tinkers_reforged:molten_blazing_copper");
        public static final TagKey<Fluid> GAUSUM_ = create("tinkers_reforged:molten_gausum");
        public static final TagKey<Fluid> REDSTONE_ = create("tinkers_reforged:redstone");
        public static final TagKey<Fluid> LAPIS_ = create("tinkers_reforged:molten_lapis");
        public static final TagKey<Fluid> FELSTEEL_ = create("tinkers_reforged:molten_felsteel");
        public static final TagKey<Fluid> KEPU_ = create("tinkers_reforged:molten_kepu");
        public static final TagKey<Fluid> CHRORUS_METAL_ = create("tinkers_reforged:molten_chorus_metal");
        public static final TagKey<Fluid> CHORUS_ = create("tinkers_reforged:molten_chorus");
        public static final TagKey<Fluid> SHULKER_ = create("tinkers_reforged:molten_shulker");
        public static final TagKey<Fluid> DURASTEEL_ = create("tinkers_reforged:molten_durasteel");
        public static final TagKey<Fluid> CRUSTEEL_ = create("tinkers_reforged:molten_crusteel");
        public static final TagKey<Fluid> WAVY_ = create("tinkers_reforged:molten_wavy");
        public static final TagKey<Fluid> YOKEL_ = create("tinkers_reforged:molten_yokel");
        public static final TagKey<Fluid> KELP_ = create("tinkers_reforged:molten_kelp");
        public static final TagKey<Fluid> PROTO_LAVA_ = create("tinkers_reforged:molten_proto_lava");
        public static final TagKey<Fluid> BAOLIAN_ = create("tinkers_reforged:molten_baolian");
        public static final TagKey<Fluid> EPIDOTE_ = create("tinkers_reforged:molten_epidote");
        public static final TagKey<Fluid> GALU_ = create("tinkers_reforged:molten_galu");
        public static final TagKey<Fluid> MAGMA_STEEL_ = create("tinkers_reforged:molten_magma_steel");
        public static final TagKey<Fluid> CYBER_STEEL_ = create("tinkers_reforged:molten_cyber_steel");
        public static final TagKey<Fluid> HUREAULITE_ = create("tinkers_reforged:molten_hureaulite");
        public static final TagKey<Fluid> RED_BERYL_ = create("tinkers_reforged:molten_red_beryl");
    }
}
