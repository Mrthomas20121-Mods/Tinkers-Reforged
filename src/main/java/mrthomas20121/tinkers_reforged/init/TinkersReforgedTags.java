package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.util.Helpers;
import mrthomas20121.tinkers_reforged.api.material.EnumGem;
import mrthomas20121.tinkers_reforged.api.material.EnumMetal;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

import java.util.Map;

public class TinkersReforgedTags {

    public static void init() {
        Blocks.init();
        Items.init();
        Entities.init();
        Fluids.init();
    }

    public static class Fluids {
        public static void init() {}

        private static TagKey<Fluid> create(String p_203849_) {
            return TagKey.create(Registry.FLUID_REGISTRY, new ResourceLocation(p_203849_));
        }
    }

    public static class Entities {
        public static void init() {}

        public static TagKey<EntityType<?>> NETHER_MOBS = create("tinkers_reforged:nether_mobs");

        public static TagKey<EntityType<?>> create(String p_203849_) {
            return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(p_203849_));
        }
    }

    public static class Blocks {

        public static void init() {}

        public static TagKey<Block> create(String name) {
            return BlockTags.create(new ResourceLocation(name));
        }

        // terra modifier tag
        public static final TagKey<Block> ROCK_TYPE_BLOCKS = create("tinkers_reforged:rock_type_blocks");

        public static final TagKey<Block> NEED_KEPU_TOOLS = create("tinkers_reforged:need_kepu_tools");
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
        public static final TagKey<Block> GELOT_BLOCK = create("forge:storage_blocks/piroot");
        public static final TagKey<Block> PIROOT_BLOCK = create("forge:storage_blocks/piroot");

        // raw blocks
        public static final TagKey<Block> RAW_ALUMINUM = create("forge:storage_blocks/raw_aluminum");
        public static final TagKey<Block> RAW_KEPU = create("forge:storage_blocks/raw_kepu");
    }

    public static class Items {

        public static void init() {}

        public static TagKey<Item> create(String name) {
            return ItemTags.create(new ResourceLocation(name));
        }

        public static final Map<EnumGem, TagKey<Item>> GEM_ORES = Helpers.mapOfKeys(EnumGem.class, (gem) ->
                create("forge:ores/" + gem.getName()));

        public static final Map<EnumGem, TagKey<Item>> GEMS_RAW_ORES = Helpers.mapOfKeys(EnumGem.class, (gem) ->
                create("forge:raw_materials/" + gem.getName()));

        public static final Map<EnumMetal, TagKey<Item>> METAL_ORES = Helpers.mapOfKeys(EnumMetal.class, EnumMetal::isThisOre, (metal) ->
                create("forge:ores/" + metal.getName()));

        public static final Map<EnumMetal, TagKey<Item>> METAL_RAW_ORES = Helpers.mapOfKeys(EnumMetal.class, EnumMetal::isThisOre, (metal) ->
                create("forge:raw_materials/" + metal.getName()));

        public static final Map<EnumMetal, Map<EnumMetal.ItemType, TagKey<Item>>> METALS = Helpers.mapOfKeys(EnumMetal.class, (metal) ->
                Helpers.mapOfKeys(EnumMetal.ItemType.class, (itemType) -> create("forge:"+itemType.getName() + "s/" + metal.getName())));

        public static final TagKey<Item> ALUMINUM_CASTS = create("tinkers_reforged:casts/aluminum");
    }
}
