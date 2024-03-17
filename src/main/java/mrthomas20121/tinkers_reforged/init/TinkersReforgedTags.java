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

        public static final TagKey<Block> NEED_KEPU_TOOLS = create("tinkers_reforged:need_kepu_tools");
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
