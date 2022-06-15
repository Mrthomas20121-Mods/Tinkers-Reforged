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

    public static class Blocks {

        public void init() {}

        private static TagKey<Block> create(String name) {
            return BlockTags.create(new ResourceLocation(name));
        }

        // terra modifier tag
        public static final TagKey<Block> ROCK_TYPE_BLOCKS = create("tinkers_reforged:rock_type_blocks");
        // ores
        public static final TagKey<Block> ALUMINUM_ORE = create("forge:ores/aluminum");
        public static final TagKey<Block> KEPU_ORE = create("forge:ores/kepu");

        // storage blocks
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

        // raw blocks
        public static final TagKey<Block> RAW_ALUMINUM = create("forge:storage_blocks/raw_aluminum");
        public static final TagKey<Block> RAW_KEPU = create("forge:storage_blocks/raw_kepu");
    }

    public static class Items {

        public void init() {}

        private static TagKey<Item> create(String name) {
            return ItemTags.create(new ResourceLocation(name));
        }

        // ores
        public static final TagKey<Item> ALUMINUM_ORE = create("forge:ores/aluminum");
        public static final TagKey<Item> KEPU_ORE = create("forge:ores/kepu");

        // storage blocks
        public static final TagKey<Item> DURALUMIN = create("forge:storage_blocks/duralumin");
        public static final TagKey<Item> ALUMINUM = create("forge:storage_blocks/aluminum");
        public static final TagKey<Item> ELECTRICAL_COPPER = create("forge:storage_blocks/electrical_copper");
        public static final TagKey<Item> LAVIUM = create("forge:storage_blocks/lavium");
        public static final TagKey<Item> QIVIUM = create("forge:storage_blocks/qivium");
        public static final TagKey<Item> GAUSUM = create("forge:storage_blocks/gausum");
        public static final TagKey<Item> FELSTEEL = create("forge:storage_blocks/felsteel");
        public static final TagKey<Item> KEPU = create("forge:storage_blocks/kepu");
        public static final TagKey<Item> DURASTEEL = create("forge:storage_blocks/durasteel");
        public static final TagKey<Item> CHORUS_METAl = create("forge:storage_blocks/chorus_metal");
        public static final TagKey<Item> CRUSTEEL = create("forge:storage_blocks/crusteel");
        public static final TagKey<Item> WAVY = create("forge:storage_blocks/wavy");
        public static final TagKey<Item> YOKEL = create("forge:storage_blocks/yokel");

        // raw blocks
        public static final TagKey<Item> RAW_ALUMINUM = create("forge:storage_blocks/raw_aluminum");
        public static final TagKey<Item> RAW_KEPU = create("forge:storage_blocks/raw_kepu");
    }

    public static class Fluids {

        public void init() {}

        private static TagKey<Fluid> create(String name) {
            return FluidTags.create(new ResourceLocation(name));
        }


    }
}
