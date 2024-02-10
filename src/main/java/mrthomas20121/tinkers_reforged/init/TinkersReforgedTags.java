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

        public static final Map<EnumMetal, Map<EnumMetal.BlockType, TagKey<Item>>> METAL_ORES = Helpers.mapOfKeys(EnumMetal.class, EnumMetal::isThisOre, (metal) ->
                Helpers.mapOfKeys(EnumMetal.BlockType.class, (itemType) -> create("forge:ores/" + metal.getName())));

        public static final Map<EnumMetal, Map<EnumMetal.ItemType, TagKey<Item>>> METALS = Helpers.mapOfKeys(EnumMetal.class, (metal) ->
                Helpers.mapOfKeys(EnumMetal.ItemType.class, (itemType) -> create("forge:"+itemType.getName() + "s/" + metal.getName())));

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
        public static final TagKey<Item> GELOT_BLOCK = create("forge:storage_blocks/gelot");
        public static final TagKey<Item> PIROOT_BLOCK = create("forge:storage_blocks/piroot");

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

        public static final TagKey<Item> GELOT_INGOT = create("forge:ingots/gelot");
        public static final TagKey<Item> GELOT_DUST = create("forge:dusts/gelot");
        public static final TagKey<Item> GELOT_NUGGET = create("forge:nuggets/gelot");

        public static final TagKey<Item> PIROOT_INGOT = create("forge:ingots/piroot");
        public static final TagKey<Item> PIROOT_DUST = create("forge:dusts/piroot");
        public static final TagKey<Item> PIROOT_NUGGET = create("forge:nuggets/piroot");

        public static final TagKey<Item> HUREAULITE_GEM = create("forge:gems/hureaulite");

        public static final TagKey<Item> RED_BERYL_GEM = create("forge:gems/red_beryl");

        public static final TagKey<Item> ALUMINUM_CASTS = create("tinkers_reforged:casts/aluminum");
    }
}
