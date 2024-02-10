package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.cast.CastType;
import mrthomas20121.tinkers_reforged.api.cast.TinkerCastType;
import mrthomas20121.tinkers_reforged.api.tag.MetalTags;
import mrthomas20121.tinkers_reforged.api.tag.RTags;
import mrthomas20121.tinkers_reforged.init.*;
import mrthomas20121.tinkers_reforged.item.CastObject;
import mrthomas20121.tinkers_reforged.api.material.EnumGem;
import mrthomas20121.tinkers_reforged.api.material.EnumMetal;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.common.TinkerTags;

import javax.annotation.Nullable;

import static mrthomas20121.tinkers_reforged.init.TinkersReforgedTags.Items.*;
import static net.minecraftforge.common.Tags.Items.*;

public class ReforgedItemsTags extends ItemTagsProvider {

    private static TagKey<Item> create(String name) {
        return ItemTags.create(new ResourceLocation(name));
    }

    public ReforgedItemsTags(DataGenerator gen, BlockTagsProvider blockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, blockTagsProvider, TinkersReforged.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

        tag(TinkerTags.Items.MODIFIABLE).add(TinkersReforgedItems.GREATSWORD.get(), TinkersReforgedItems.LONGSWORD.get());
        tag(TinkerTags.Items.MELEE).add(TinkersReforgedItems.GREATSWORD.get(), TinkersReforgedItems.LONGSWORD.get());
        tag(TinkerTags.Items.SWORD).add(TinkersReforgedItems.GREATSWORD.get(), TinkersReforgedItems.LONGSWORD.get());
        tag(TinkerTags.Items.MELEE_PRIMARY).add(TinkersReforgedItems.GREATSWORD.get(), TinkersReforgedItems.LONGSWORD.get());
        tag(TinkerTags.Items.HARVEST).add(TinkersReforgedItems.GREATSWORD.get(), TinkersReforgedItems.LONGSWORD.get());
        tag(TinkerTags.Items.HELD).add(TinkersReforgedItems.GREATSWORD.get(), TinkersReforgedItems.LONGSWORD.get());
        tag(TinkerTags.Items.DURABILITY).add(TinkersReforgedItems.GREATSWORD.get(), TinkersReforgedItems.LONGSWORD.get());
        tag(TinkerTags.Items.MULTIPART_TOOL).add(TinkersReforgedItems.GREATSWORD.get(), TinkersReforgedItems.LONGSWORD.get());
        tag(TinkerTags.Items.TOOL_PARTS).add(TinkersReforgedItems.GREAT_BLADE.get(), TinkersReforgedItems.LONG_BLADE.get());

        // gem tags
        for(EnumGem gem: EnumGem.values()) {
            TagKey<Item> ORE = TinkersReforgedTags.Items.create("forge:ores/%s".formatted(gem.getName()));
            tag(ORE).add(TinkersReforgedBlocks.GEM_ORES.get(gem).ore().get().asItem(), TinkersReforgedBlocks.GEM_ORES.get(gem).deepslateOre().get().asItem());
            tag(ORES).add(TinkersReforgedBlocks.GEM_ORES.get(gem).ore().get().asItem(), TinkersReforgedBlocks.GEM_ORES.get(gem).deepslateOre().get().asItem());

            TagKey<Item> PLATES = TinkersReforgedTags.Items.create("forge:plates");

            TagKey<Item> BLOCK = TinkersReforgedTags.Items.create("forge:storage_blocks/%s".formatted(gem.getName()));
            tag(BLOCK).add(TinkersReforgedBlocks.GEMS_BLOCKS.get(gem).get().asItem());
            tag(TinkerTags.Items.ANVIL_METAL).add(TinkersReforgedBlocks.GEMS_BLOCKS.get(gem).get().asItem());

            for(EnumGem.ItemType itemType: EnumGem.ItemType.values()) {
                TagKey<Item> tagKey = TinkersReforgedTags.Items.create("forge:%s/%s".formatted(itemType.getName()+"s", gem.getName()));

                tag(tagKey).add(TinkersReforgedItems.GEMS.get(gem).get(itemType).get());

                switch (itemType) {
                    case GEM -> tag(GEMS).add(TinkersReforgedItems.GEMS.get(gem).get(itemType).get());
                    case DUST -> tag(DUSTS).add(TinkersReforgedItems.GEMS.get(gem).get(itemType).get());
                    case PLATE -> tag(PLATES).add(TinkersReforgedItems.GEMS.get(gem).get(itemType).get());
                }
            }
        }

        // metal tags
        for(EnumMetal metal: EnumMetal.values()) {
            MetalTags tags = RTags.getTagsForMetal(metal);
            if(metal.isThisOre()) {
                tag(tags.raw_ore).add(TinkersReforgedItems.RAW_ORES.get(metal).get());
                tag(tags.rawBlockItem).add(TinkersReforgedBlocks.RAW_ORES.get(metal).get().asItem());
                tag(tags.oreBlockItem).add(TinkersReforgedBlocks.ORES.get(metal).ore().get().asItem(), TinkersReforgedBlocks.ORES.get(metal).deepslateOre().get().asItem());
                tag(ORES).add(TinkersReforgedBlocks.ORES.get(metal).ore().get().asItem(), TinkersReforgedBlocks.ORES.get(metal).deepslateOre().get().asItem());
            }

            TagKey<Item> PLATES = TinkersReforgedTags.Items.create("forge:plates");

            tag(tags.storageItem).add(TinkersReforgedBlocks.METAL_BLOCKS.get(metal).get(EnumMetal.BlockType.BLOCK).get().asItem());
            tag(TinkerTags.Items.ANVIL_METAL).add(TinkersReforgedBlocks.METAL_BLOCKS.get(metal).get(EnumMetal.BlockType.BLOCK).get().asItem());

            for(EnumMetal.ItemType itemType: EnumMetal.ItemType.values()) {

                switch (itemType) {
                    case INGOT -> {
                        tag(tags.ingot).add(TinkersReforgedItems.METALS.get(metal).get(itemType).get());
                        tag(INGOTS).add(TinkersReforgedItems.METALS.get(metal).get(itemType).get());
                        tag(ItemTags.BEACON_PAYMENT_ITEMS).add(TinkersReforgedItems.METALS.get(metal).get(itemType).get());
                    }
                    case NUGGET -> {
                        tag(tags.nugget).add(TinkersReforgedItems.METALS.get(metal).get(itemType).get());
                        tag(NUGGETS).add(TinkersReforgedItems.METALS.get(metal).get(itemType).get());
                    }
                    case DUST -> {
                        tag(tags.dust).add(TinkersReforgedItems.METALS.get(metal).get(itemType).get());
                        tag(DUSTS).add(TinkersReforgedItems.METALS.get(metal).get(itemType).get());
                    }
                    case PLATE -> {
                        tag(tags.plate).add(TinkersReforgedItems.METALS.get(metal).get(itemType).get());
                        tag(PLATES).add(TinkersReforgedItems.METALS.get(metal).get(itemType).get());
                    }
                }
            }
        }

        tag(ItemTags.LECTERN_BOOKS).add(TinkersReforgedItems.book.get());

        TagsProvider.TagAppender<Item> builder = tag(ALUMINUM_CASTS);
        for(CastType type: CastType.values()) {
            Item cast = TinkersReforgedItems.ALU_CASTS.get(type).get();
            builder.add(cast);
            TagKey<Item> castTag = create("tconstruct:casts/multi_use/%s".formatted(type.name().toLowerCase()));
            tag(castTag).add(cast);
        }
        tag(TinkerTags.Items.CASTS).addTag(ALUMINUM_CASTS);

        TagsProvider.TagAppender<Item> gold_casts = tag(TinkerTags.Items.GOLD_CASTS);
        TagsProvider.TagAppender<Item> sand_casts = tag(TinkerTags.Items.SAND_CASTS);
        TagsProvider.TagAppender<Item> red_sand_casts = tag(TinkerTags.Items.RED_SAND_CASTS);
        TagsProvider.TagAppender<Item> multi_use_casts = tag(TinkerTags.Items.MULTI_USE_CASTS);
        TagsProvider.TagAppender<Item> single_use_casts = tag(TinkerTags.Items.SINGLE_USE_CASTS);

        addCastTag(TinkerCastType.Type.GREAT_BLADE, gold_casts, sand_casts, red_sand_casts, multi_use_casts, single_use_casts);
        addCastTag(TinkerCastType.Type.LONG_BLADE, gold_casts, sand_casts, red_sand_casts, multi_use_casts, single_use_casts);
    }

    public void addCastTag(TinkerCastType.Type castType, TagsProvider.TagAppender<Item> gold, TagsProvider.TagAppender<Item> sand, TagsProvider.TagAppender<Item> red_sand, TagsProvider.TagAppender<Item> multi_use, TagsProvider.TagAppender<Item> single_use) {
        CastObject object = new CastObject(castType.getName());
        TagKey<Item> multiUseTag = object.getMultiUseTag();
        TagKey<Item> singleUseTag = object.getSingleUseTag();
        tag(multiUseTag).add(TinkersReforgedItems.CASTS.get(TinkerCastType.GOLD).get(castType).get());
        tag(singleUseTag).add(TinkersReforgedItems.CASTS.get(TinkerCastType.SAND).get(castType).get(), TinkersReforgedItems.CASTS.get(TinkerCastType.RED_SAND).get(castType).get());

        gold.add(TinkersReforgedItems.CASTS.get(TinkerCastType.GOLD).get(castType).get());
        sand.add(TinkersReforgedItems.CASTS.get(TinkerCastType.SAND).get(castType).get());
        red_sand.add(TinkersReforgedItems.CASTS.get(TinkerCastType.RED_SAND).get(castType).get());
        multi_use.addTag(multiUseTag);
       single_use.addTag(singleUseTag);
    }
}
