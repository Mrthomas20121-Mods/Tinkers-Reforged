package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.CastType;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedItems;
import mrthomas20121.tinkers_reforged.item.CastObject;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.common.TinkerTags;

import javax.annotation.Nullable;

import static mrthomas20121.tinkers_reforged.init.TinkersReforgedTags.Items.*;

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
        tag(TinkerTags.Items.TOOL_PARTS).add(TinkersReforgedItems.GREAT_BLADE.get(), TinkersReforgedItems.LARGE_ROUND_PLATE.get(), TinkersReforgedItems.LONG_BLADE.get());

        tag(RAW_ALUMINUM).add(TinkersReforgedItems.raw_aluminum.get());
        tag(RAW_KEPU).add(TinkersReforgedItems.raw_kepu.get());

        tag(RAW_ALUMINUM_BLOCK).add(TinkersReforgedItems.raw_aluminum_block.get());
        tag(RAW_KEPU_BLOCK).add(TinkersReforgedItems.raw_kepu_block.get());

        tag(Tags.Items.ORES).add(
                TinkersReforgedItems.aluminum_ore.get(),
                TinkersReforgedItems.kepu_ore.get(),
                TinkersReforgedItems.deepslate_aluminum_ore.get(),
                TinkersReforgedItems.deepslate_epidote_ore.get(),
                TinkersReforgedItems.deepslate_hureaulite_ore.get(),
                TinkersReforgedItems.red_beryl_ore.get(),
                TinkersReforgedItems.deepslate_red_beryl_ore.get()
        );

        tag(ItemTags.LECTERN_BOOKS).add(TinkersReforgedItems.book.get());

        tag(Tags.Items.STORAGE_BLOCKS)
                .add(
                        TinkersReforgedItems.kepu_block.get(),
                        TinkersReforgedItems.raw_aluminum_block.get(),
                        TinkersReforgedItems.raw_kepu_block.get(),
                        TinkersReforgedItems.duralumin_block.get(),
                        TinkersReforgedItems.aluminum_block.get(),
                        TinkersReforgedItems.electrical_copper_block.get(),
                        TinkersReforgedItems.lavium_block.get(),
                        TinkersReforgedItems.qivium_block.get(),
                        TinkersReforgedItems.gausum_block.get(),
                        TinkersReforgedItems.felsteel_block.get(),
                        TinkersReforgedItems.chorus_metal_block.get(),
                        TinkersReforgedItems.durasteel_block.get(),
                        TinkersReforgedItems.crusteel_block.get(),
                        TinkersReforgedItems.wavy_block.get(),
                        TinkersReforgedItems.yokel_block.get(),
                        TinkersReforgedItems.baolian_block.get(),
                        TinkersReforgedItems.epidote_block.get(),
                        TinkersReforgedItems.galu_block.get(),
                        TinkersReforgedItems.hureaulite_block.get(),
                        TinkersReforgedItems.red_beryl_block.get(),
                        TinkersReforgedItems.magma_steel_block.get(),
                        TinkersReforgedItems.cyber_steel_block.get(),
                        TinkersReforgedItems.gelot_block.get(),
                        TinkersReforgedItems.piroot_block.get()
                );

        tag(BLAZING_COPPER_BLOCK).add(TinkersReforgedItems.blazing_copper_block.get());
        tag(DURALUMIN_BLOCK).add(TinkersReforgedItems.duralumin_block.get());
        tag(ALUMINUM_BLOCK).add(TinkersReforgedItems.aluminum_block.get());
        tag(ELECTRICAL_COPPER_BLOCK).add(TinkersReforgedItems.electrical_copper_block.get());
        tag(LAVIUM_BLOCK).add(TinkersReforgedItems.lavium_block.get());
        tag(QIVIUM_BLOCK).add(TinkersReforgedItems.qivium_block.get());
        tag(GAUSUM_BLOCK).add(TinkersReforgedItems.gausum_block.get());
        tag(FELSTEEL_BLOCK).add(TinkersReforgedItems.felsteel_block.get());
        tag(KEPU_BLOCK).add(TinkersReforgedItems.kepu_block.get());
        tag(CHORUS_METAl_BLOCK).add(TinkersReforgedItems.chorus_metal_block.get());
        tag(DURASTEEL_BLOCK).add(TinkersReforgedItems.durasteel_block.get());
        tag(CRUSTEEL_BLOCK).add(TinkersReforgedItems.crusteel_block.get());
        tag(WAVY_BLOCK).add(TinkersReforgedItems.wavy_block.get());
        tag(YOKEL_BLOCK).add(TinkersReforgedItems.yokel_block.get());
        tag(BAOLIAN_BLOCK).add(TinkersReforgedItems.baolian_block.get());
        tag(EPIDOTE_BLOCK).add(TinkersReforgedItems.epidote_block.get());
        tag(GALU_BLOCK).add(TinkersReforgedItems.galu_block.get());
        tag(MAGMA_STEEL_BLOCK).add(TinkersReforgedItems.magma_steel_block.get());
        tag(CYBER_STEEL_BLOCK).add(TinkersReforgedItems.cyber_steel_block.get());
        tag(HUREAULITE_BLOCK).add(TinkersReforgedItems.hureaulite_block.get());
        tag(RED_BERYL_BLOCK).add(TinkersReforgedItems.red_beryl_block.get());
        tag(GELOT_BLOCK).add(TinkersReforgedItems.gelot_block.get());
        tag(PIROOT_BLOCK).add(TinkersReforgedItems.piroot_block.get());

        tag(EPIDOTE_ORE).add(TinkersReforgedItems.deepslate_epidote_ore.get());
        tag(HUREAULITE_ORE).add(TinkersReforgedItems.deepslate_hureaulite_ore.get());
        tag(RED_BERYL_ORE).add(TinkersReforgedItems.red_beryl_ore.get(), TinkersReforgedItems.deepslate_red_beryl_ore.get());

        tag(EPIDOTE_GEM).add(TinkersReforgedItems.epidote_gem.get());
        tag(HUREAULITE_GEM).add(TinkersReforgedItems.hureaulite_gem.get());
        tag(RED_BERYL_GEM).add(TinkersReforgedItems.red_beryl_gem.get());

        tag(Tags.Items.GEMS).add(
                TinkersReforgedItems.epidote_gem.get(),
                TinkersReforgedItems.hureaulite_gem.get(),
                TinkersReforgedItems.red_beryl_gem.get()
        );

        tag(ItemTags.BEACON_PAYMENT_ITEMS).add(
                TinkersReforgedItems.aluminum_ingot.get(),
                TinkersReforgedItems.duralumin_ingot.get(),
                TinkersReforgedItems.electrical_copper_ingot.get(),
                TinkersReforgedItems.lavium_ingot.get(),
                TinkersReforgedItems.qivium_ingot.get(),
                TinkersReforgedItems.gausum_ingot.get(),
                TinkersReforgedItems.felsteel_ingot.get(),
                TinkersReforgedItems.kepu_ingot.get(),
                TinkersReforgedItems.chorus_metal_ingot.get(),
                TinkersReforgedItems.durasteel_ingot.get(),
                TinkersReforgedItems.crusteel_ingot.get(),
                TinkersReforgedItems.wavy_ingot.get(),
                TinkersReforgedItems.yokel_ingot.get(),
                TinkersReforgedItems.baolian_ingot.get(),
                TinkersReforgedItems.galu_ingot.get(),
                TinkersReforgedItems.blazing_copper_ingot.get(),
                TinkersReforgedItems.magma_steel_ingot.get(),
                TinkersReforgedItems.cyber_steel_ingot.get()
        );

        tag(Tags.Items.INGOTS).add(
                TinkersReforgedItems.aluminum_ingot.get(),
                TinkersReforgedItems.duralumin_ingot.get(),
                TinkersReforgedItems.electrical_copper_ingot.get(),
                TinkersReforgedItems.lavium_ingot.get(),
                TinkersReforgedItems.qivium_ingot.get(),
                TinkersReforgedItems.gausum_ingot.get(),
                TinkersReforgedItems.felsteel_ingot.get(),
                TinkersReforgedItems.kepu_ingot.get(),
                TinkersReforgedItems.chorus_metal_ingot.get(),
                TinkersReforgedItems.durasteel_ingot.get(),
                TinkersReforgedItems.crusteel_ingot.get(),
                TinkersReforgedItems.wavy_ingot.get(),
                TinkersReforgedItems.yokel_ingot.get(),
                TinkersReforgedItems.baolian_ingot.get(),
                TinkersReforgedItems.galu_ingot.get(),
                TinkersReforgedItems.blazing_copper_ingot.get(),
                TinkersReforgedItems.magma_steel_ingot.get(),
                TinkersReforgedItems.cyber_steel_ingot.get(),
                TinkersReforgedItems.gelot_ingot.get(),
                TinkersReforgedItems.piroot_ingot.get()
        );

        tag(Tags.Items.DUSTS).add(
                TinkersReforgedItems.aluminum_dust.get(),
                TinkersReforgedItems.duralumin_dust.get(),
                TinkersReforgedItems.electrical_copper_dust.get(),
                TinkersReforgedItems.lavium_dust.get(),
                TinkersReforgedItems.qivium_dust.get(),
                TinkersReforgedItems.gausum_dust.get(),
                TinkersReforgedItems.felsteel_dust.get(),
                TinkersReforgedItems.kepu_dust.get(),
                TinkersReforgedItems.chorus_metal_dust.get(),
                TinkersReforgedItems.durasteel_dust.get(),
                TinkersReforgedItems.crusteel_dust.get(),
                TinkersReforgedItems.wavy_dust.get(),
                TinkersReforgedItems.yokel_dust.get(),
                TinkersReforgedItems.baolian_dust.get(),
                TinkersReforgedItems.galu_dust.get(),
                TinkersReforgedItems.blazing_copper_dust.get(),
                TinkersReforgedItems.magma_steel_dust.get(),
                TinkersReforgedItems.cyber_steel_dust.get(),
                TinkersReforgedItems.gelot_dust.get(),
                TinkersReforgedItems.piroot_dust.get()
        );

        tag(Tags.Items.NUGGETS).add(
                TinkersReforgedItems.aluminum_nugget.get(),
                TinkersReforgedItems.durasteel_nugget.get(),
                TinkersReforgedItems.electrical_copper_nugget.get(),
                TinkersReforgedItems.lavium_nugget.get(),
                TinkersReforgedItems.qivium_nugget.get(),
                TinkersReforgedItems.gausum_nugget.get(),
                TinkersReforgedItems.felsteel_nugget.get(),
                TinkersReforgedItems.kepu_nugget.get(),
                TinkersReforgedItems.chorus_metal_nugget.get(),
                TinkersReforgedItems.durasteel_nugget.get(),
                TinkersReforgedItems.crusteel_nugget.get(),
                TinkersReforgedItems.wavy_nugget.get(),
                TinkersReforgedItems.yokel_nugget.get(),
                TinkersReforgedItems.baolian_ingot.get(),
                TinkersReforgedItems.galu_nugget.get(),
                TinkersReforgedItems.blazing_copper_nugget.get(),
                TinkersReforgedItems.magma_steel_nugget.get(),
                TinkersReforgedItems.cyber_steel_nugget.get(),
                TinkersReforgedItems.gelot_nugget.get(),
                TinkersReforgedItems.piroot_ingot.get()
        );

        tag(BLAZING_COPPER_INGOT).add(TinkersReforgedItems.blazing_copper_ingot.get());
        tag(BLAZING_COPPER_DUST).add(TinkersReforgedItems.blazing_copper_dust.get());
        tag(BLAZING_COPPER_NUGGET).add(TinkersReforgedItems.blazing_copper_nugget.get());

        tag(DURALUMIN_INGOT).add(TinkersReforgedItems.duralumin_ingot.get());
        tag(DURALUMIN_DUST).add(TinkersReforgedItems.duralumin_dust.get());
        tag(DURALUMIN_NUGGET).add(TinkersReforgedItems.duralumin_nugget.get());

        tag(ELECTRICAL_COPPER_INGOT).add(TinkersReforgedItems.electrical_copper_ingot.get());
        tag(ELECTRICAL_COPPER_DUST).add(TinkersReforgedItems.electrical_copper_dust.get());
        tag(ELECTRICAL_COPPER_NUGGET).add(TinkersReforgedItems.electrical_copper_nugget.get());

        tag(LAVIUM_INGOT).add(TinkersReforgedItems.lavium_ingot.get());
        tag(LAVIUM_DUST).add(TinkersReforgedItems.lavium_dust.get());
        tag(LAVIUM_NUGGET).add(TinkersReforgedItems.lavium_nugget.get());

        tag(QIVIUM_INGOT).add(TinkersReforgedItems.qivium_ingot.get());
        tag(QIVIUM_DUST).add(TinkersReforgedItems.qivium_dust.get());
        tag(QIVIUM_NUGGET).add(TinkersReforgedItems.qivium_nugget.get());

        tag(ALUMINUM_ORE).add(TinkersReforgedItems.aluminum_ore.get(), TinkersReforgedItems.deepslate_aluminum_ore.get());
        tag(ALUMINUM_INGOT).add(TinkersReforgedItems.aluminum_ingot.get());
        tag(ALUMINUM_DUST).add(TinkersReforgedItems.aluminum_dust.get());
        tag(ALUMINUM_NUGGET).add(TinkersReforgedItems.aluminum_nugget.get());

        tag(GAUSUM_INGOT).add(TinkersReforgedItems.gausum_ingot.get());
        tag(GAUSUM_DUST).add(TinkersReforgedItems.gausum_dust.get());
        tag(GAUSUM_NUGGET).add(TinkersReforgedItems.gausum_nugget.get());

        tag(FELSTEEL_INGOT).add(TinkersReforgedItems.felsteel_ingot.get());
        tag(FELSTEEL_DUST).add(TinkersReforgedItems.felsteel_dust.get());
        tag(FELSTEEL_NUGGET).add(TinkersReforgedItems.felsteel_nugget.get());

        tag(CHORUS_METAL_INGOT).add(TinkersReforgedItems.chorus_metal_ingot.get());
        tag(CHORUS_METAL_DUST).add(TinkersReforgedItems.chorus_metal_dust.get());
        tag(CHORUS_METAL_NUGGET).add(TinkersReforgedItems.chorus_metal_nugget.get());

        tag(KEPU_ORE).add(TinkersReforgedItems.kepu_ore.get());
        tag(KEPU_INGOT).add(TinkersReforgedItems.kepu_ingot.get());
        tag(KEPU_DUST).add(TinkersReforgedItems.kepu_dust.get());
        tag(KEPU_NUGGET).add(TinkersReforgedItems.kepu_nugget.get());

        tag(MAGMA_STEEL_INGOT).add(TinkersReforgedItems.magma_steel_ingot.get());
        tag(MAGMA_STEEL_DUST).add(TinkersReforgedItems.magma_steel_dust.get());
        tag(MAGMA_STEEL_NUGGET).add(TinkersReforgedItems.magma_steel_nugget.get());

        tag(CYBER_STEEL_INGOT).add(TinkersReforgedItems.cyber_steel_ingot.get());
        tag(CYBER_STEEL_DUST).add(TinkersReforgedItems.cyber_steel_dust.get());
        tag(CYBER_STEEL_NUGGET).add(TinkersReforgedItems.cyber_steel_nugget.get());

        tag(DURASTEEL_INGOT).add(TinkersReforgedItems.durasteel_ingot.get());
        tag(DURASTEEL_DUST).add(TinkersReforgedItems.durasteel_dust.get());
        tag(DURASTEEL_NUGGET).add(TinkersReforgedItems.durasteel_nugget.get());

        tag(CRUSTEEL_INGOT).add(TinkersReforgedItems.crusteel_ingot.get());
        tag(CRUSTEEL_DUST).add(TinkersReforgedItems.crusteel_dust.get());
        tag(CRUSTEEL_NUGGET).add(TinkersReforgedItems.crusteel_nugget.get());

        tag(WAVY_INGOT).add(TinkersReforgedItems.wavy_ingot.get());
        tag(WAVY_DUST).add(TinkersReforgedItems.wavy_dust.get());
        tag(WAVY_NUGGET).add(TinkersReforgedItems.wavy_nugget.get());

        tag(YOKEL_INGOT).add(TinkersReforgedItems.yokel_ingot.get());
        tag(YOKEL_DUST).add(TinkersReforgedItems.yokel_dust.get());
        tag(YOKEL_NUGGET).add(TinkersReforgedItems.yokel_nugget.get());

        tag(BAOLIAN_INGOT).add(TinkersReforgedItems.baolian_ingot.get());
        tag(BAOLIAN_DUST).add(TinkersReforgedItems.baolian_dust.get());
        tag(BAOLIAN_NUGGET).add(TinkersReforgedItems.baolian_nugget.get());

        tag(GALU_INGOT).add(TinkersReforgedItems.galu_ingot.get());
        tag(GALU_DUST).add(TinkersReforgedItems.galu_dust.get());
        tag(GALU_NUGGET).add(TinkersReforgedItems.galu_nugget.get());

        tag(GELOT_INGOT).add(TinkersReforgedItems.gelot_ingot.get());
        tag(GELOT_DUST).add(TinkersReforgedItems.gelot_dust.get());
        tag(GELOT_NUGGET).add(TinkersReforgedItems.gelot_nugget.get());

        tag(PIROOT_INGOT).add(TinkersReforgedItems.piroot_ingot.get());
        tag(PIROOT_DUST).add(TinkersReforgedItems.piroot_dust.get());
        tag(PIROOT_NUGGET).add(TinkersReforgedItems.piroot_nugget.get());

        tag(TinkerTags.Items.ANVIL_METAL)
                .add(
                        TinkersReforgedItems.kepu_block.get(),
                        TinkersReforgedItems.raw_aluminum_block.get(),
                        TinkersReforgedItems.raw_kepu_block.get(),
                        TinkersReforgedItems.duralumin_block.get(),
                        TinkersReforgedItems.aluminum_block.get(),
                        TinkersReforgedItems.electrical_copper_block.get(),
                        TinkersReforgedItems.lavium_block.get(),
                        TinkersReforgedItems.qivium_block.get(),
                        TinkersReforgedItems.gausum_block.get(),
                        TinkersReforgedItems.felsteel_block.get(),
                        TinkersReforgedItems.chorus_metal_block.get(),
                        TinkersReforgedItems.durasteel_block.get(),
                        TinkersReforgedItems.crusteel_block.get(),
                        TinkersReforgedItems.wavy_block.get(),
                        TinkersReforgedItems.yokel_block.get(),
                        TinkersReforgedItems.baolian_block.get(),
                        TinkersReforgedItems.epidote_block.get(),
                        TinkersReforgedItems.galu_block.get(),
                        TinkersReforgedItems.hureaulite_block.get(),
                        TinkersReforgedItems.red_beryl_block.get(),
                        TinkersReforgedItems.blazing_copper_block.get(),
                        TinkersReforgedItems.magma_steel_block.get(),
                        TinkersReforgedItems.cyber_steel_block.get(),
                        TinkersReforgedItems.gelot_block.get(),
                        TinkersReforgedItems.piroot_block.get()
                );

        TagsProvider.TagAppender<Item> builder = tag(ALUMINUM_CASTS);
        for(CastType type: CastType.values()) {
            Item cast = TinkersReforgedItems.castMap.get(type).get();
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

        addCastTag(TinkersReforgedItems.great_blade_cast, gold_casts, sand_casts, red_sand_casts, multi_use_casts, single_use_casts);
        addCastTag(TinkersReforgedItems.long_blade_cast, gold_casts, sand_casts, red_sand_casts, multi_use_casts, single_use_casts);
    }

    public void addCastTag(CastObject object, TagsProvider.TagAppender<Item> gold, TagsProvider.TagAppender<Item> sand, TagsProvider.TagAppender<Item> red_sand, TagsProvider.TagAppender<Item> multi_use, TagsProvider.TagAppender<Item> single_use) {
        TagKey<Item> multiUseTag = object.getMultiUseTag();
        TagKey<Item> singleUseTag = object.getSingleUseTag();
        tag(multiUseTag).add(object.getGoldCast().get());
        tag(singleUseTag).add(object.getSandCast().get(), object.getRedSandCast().get());

        gold.add(object.getGoldCast().get());
        sand.add(object.getSandCast().get());
        red_sand.add(object.getRedSandCast().get());
        multi_use.addTag(multiUseTag);
       single_use.addTag(singleUseTag);
    }
}
