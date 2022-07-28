package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.CastType;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedBlocks;
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
import net.minecraft.world.level.block.Block;
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

        tag(TinkerTags.Items.MODIFIABLE).add(TinkersReforgedItems.GREATSWORD.get(), TinkersReforgedItems.FRYING_PAN.get());
        tag(TinkerTags.Items.MELEE).add(TinkersReforgedItems.GREATSWORD.get(), TinkersReforgedItems.FRYING_PAN.get());
        tag(TinkerTags.Items.SWORD).add(TinkersReforgedItems.GREATSWORD.get(), TinkersReforgedItems.FRYING_PAN.get());
        tag(TinkerTags.Items.MELEE_PRIMARY).add(TinkersReforgedItems.GREATSWORD.get(), TinkersReforgedItems.FRYING_PAN.get());
        tag(TinkerTags.Items.HARVEST).add(TinkersReforgedItems.GREATSWORD.get(), TinkersReforgedItems.FRYING_PAN.get());
        tag(TinkerTags.Items.ONE_HANDED).add(TinkersReforgedItems.GREATSWORD.get(), TinkersReforgedItems.FRYING_PAN.get());
        tag(TinkerTags.Items.DURABILITY).add(TinkersReforgedItems.GREATSWORD.get(), TinkersReforgedItems.FRYING_PAN.get());
        tag(TinkerTags.Items.MULTIPART_TOOL).add(TinkersReforgedItems.GREATSWORD.get(), TinkersReforgedItems.FRYING_PAN.get());
        tag(TinkerTags.Items.TOOL_PARTS).add(TinkersReforgedItems.GREAT_BLADE.get(), TinkersReforgedItems.LARGE_ROUND_PLATE.get());

        tag(Tags.Items.BONES).add(TinkersReforgedItems.ender_bone.get());

        tag(RAW_ALUMINUM).add(TinkersReforgedItems.raw_aluminum.get());
        tag(RAW_KEPU).add(TinkersReforgedItems.raw_kepu.get());

        tag(RAW_ALUMINUM_BLOCK).add(TinkersReforgedItems.raw_aluminum_block.get());
        tag(RAW_KEPU_BLOCK).add(TinkersReforgedItems.raw_kepu_block.get());

        tag(ORES).add(TinkersReforgedItems.aluminum_ore.get(), TinkersReforgedItems.kepu_ore.get(), TinkersReforgedItems.deepslate_aluminum_ore.get());

        tag(ItemTags.LECTERN_BOOKS).add(TinkersReforgedItems.book.get());

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

        tag(INGOTS)
                .add(TinkersReforgedItems.aluminum_ingot.get())
                .add(TinkersReforgedItems.duralumin_ingot.get())
                .add(TinkersReforgedItems.electrical_copper_ingot.get())
                .add(TinkersReforgedItems.lavium_ingot.get())
                .add(TinkersReforgedItems.qivium_ingot.get())
                .add(TinkersReforgedItems.gausum_ingot.get())
                .add(TinkersReforgedItems.felsteel_ingot.get())
                .add(TinkersReforgedItems.kepu_ingot.get())
                .add(TinkersReforgedItems.chorus_metal_ingot.get())
                .add(TinkersReforgedItems.durasteel_ingot.get())
                .add(TinkersReforgedItems.crusteel_ingot.get())
                .add(TinkersReforgedItems.wavy_ingot.get())
                .add(TinkersReforgedItems.yokel_ingot.get());

        tag(DUSTS)
                .add(TinkersReforgedItems.aluminum_dust.get())
                .add(TinkersReforgedItems.duralumin_dust.get())
                .add(TinkersReforgedItems.electrical_copper_dust.get())
                .add(TinkersReforgedItems.lavium_dust.get())
                .add(TinkersReforgedItems.qivium_dust.get())
                .add(TinkersReforgedItems.gausum_dust.get())
                .add(TinkersReforgedItems.felsteel_dust.get())
                .add(TinkersReforgedItems.kepu_dust.get())
                .add(TinkersReforgedItems.chorus_metal_dust.get())
                .add(TinkersReforgedItems.durasteel_dust.get())
                .add(TinkersReforgedItems.crusteel_dust.get())
                .add(TinkersReforgedItems.wavy_dust.get())
                .add(TinkersReforgedItems.yokel_dust.get());

        tag(NUGGETS)
                .add(TinkersReforgedItems.aluminum_nugget.get())
                .add(TinkersReforgedItems.duralumin_nugget.get())
                .add(TinkersReforgedItems.electrical_copper_nugget.get())
                .add(TinkersReforgedItems.lavium_nugget.get())
                .add(TinkersReforgedItems.qivium_nugget.get())
                .add(TinkersReforgedItems.gausum_nugget.get())
                .add(TinkersReforgedItems.felsteel_nugget.get())
                .add(TinkersReforgedItems.kepu_nugget.get())
                .add(TinkersReforgedItems.chorus_metal_nugget.get())
                .add(TinkersReforgedItems.durasteel_nugget.get())
                .add(TinkersReforgedItems.crusteel_nugget.get())
                .add(TinkersReforgedItems.wavy_nugget.get())
                .add(TinkersReforgedItems.yokel_nugget.get());

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

        tag(TinkerTags.Items.ANVIL_METAL)
                .add(TinkersReforgedBlocks.duralumin_block.get().asItem())
                .add(TinkersReforgedBlocks.aluminum_block.get().asItem())
                .add(TinkersReforgedBlocks.electrical_copper_block.get().asItem())
                .add(TinkersReforgedBlocks.lavium_block.get().asItem())
                .add(TinkersReforgedBlocks.qivium_block.get().asItem())
                .add(TinkersReforgedBlocks.gausum_block.get().asItem())
                .add(TinkersReforgedBlocks.felsteel_block.get().asItem())
                .add(TinkersReforgedBlocks.kepu_block.get().asItem())
                .add(TinkersReforgedBlocks.chorus_metal_block.get().asItem())
                .add(TinkersReforgedBlocks.durasteel_block.get().asItem())
                .add(TinkersReforgedBlocks.crusteel_block.get().asItem())
                .add(TinkersReforgedBlocks.wavy_block.get().asItem())
                .add(TinkersReforgedBlocks.yokel_block.get().asItem());

        TagsProvider.TagAppender<Item> builder = tag(ALUMINUM_CASTS);
        for(CastType type: CastType.values()) {
            Item cast = TinkersReforgedItems.casts.get(type).get();
            builder.add(cast);
            TagKey<Item> castTag = create("tconstruct:casts/multi_use/%s".formatted(type.name().toLowerCase()));
            tag(castTag).add(cast);
        }

        addCastTag(TinkersReforgedItems.great_blade_cast);
        addCastTag(TinkersReforgedItems.large_round_plate_cast);
    }

    public void addCastTag(CastObject object) {
        TagKey<Item> multiUseTag = object.getMultiUseTag();
        TagKey<Item> singleUseTag = object.getSingleUseTag();
        tag(multiUseTag).add(object.getGoldCast().get());
        tag(singleUseTag).add(object.getSandCast().get(), object.getRedSandCast().get());

        tag(TinkerTags.Items.GOLD_CASTS).add(object.getGoldCast().get());
        tag(TinkerTags.Items.SAND_CASTS).add(object.getSandCast().get());
        tag(TinkerTags.Items.RED_SAND_CASTS).add(object.getRedSandCast().get());
        tag(TinkerTags.Items.MULTI_USE_CASTS).addTag(multiUseTag);
        tag(TinkerTags.Items.SINGLE_USE_CASTS).addTag(singleUseTag);
    }
}
