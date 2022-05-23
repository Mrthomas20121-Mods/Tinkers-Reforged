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
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.common.TinkerTags;

import javax.annotation.Nullable;

public class ReforgedItemsTags extends ItemTagsProvider {

    private static final TagKey<Item> RAW_ALUMINUM = create("forge:storage_blocks/raw_aluminum");
    private static final TagKey<Item> RAW_KEPU = create("forge:storage_blocks/raw_kepu");

    public static final TagKey<Item> INGOTS = create("forge:ingots");
    public static final TagKey<Item> DUSTS = create("forge:dusts");
    public static final TagKey<Item> NUGGETS = create("forge:nuggets");
    public static final TagKey<Item> ORES = create("forge:ores");

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

    public static final TagKey<Item> ALUMINUM_ORE = create("forge:ores/aluminum");
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

    public static final TagKey<Item> KEPU_ORE = create("forge:ores/kepu");
    public static final TagKey<Item> KEPU_INGOT = create("forge:ingots/kepu");
    public static final TagKey<Item> KEPU_DUST = create("forge:dusts/kepu");
    public static final TagKey<Item> KEPU_NUGGET = create("forge:nuggets/kepu");

    public static final TagKey<Item> ALUMINUM_CASTS = create("tinkers_reforged:casts/aluminum");

    private static final TagKey<Item> DURALUMIN = create("forge:storage_blocks/duralumin");
    private static final TagKey<Item> ALUMINUM = create("forge:storage_blocks/aluminum");
    private static final TagKey<Item> ELECTRICAL_COPPER = create("forge:storage_blocks/electrical_copper");
    private static final TagKey<Item> LAVIUM = create("forge:storage_blocks/lavium");
    private static final TagKey<Item> QIVIUM = create("forge:storage_blocks/qivium");
    private static final TagKey<Item> GAUSUM = create("forge:storage_blocks/gausum");
    private static final TagKey<Item> FELSTEEL = create("forge:storage_blocks/felsteel");
    private static final TagKey<Item> KEPU = create("forge:storage_blocks/kepu");
    private static final TagKey<Item> CHORUS_METAl = create("forge:storage_blocks/chorus_metal");

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

        tag(RAW_ALUMINUM).add(TinkersReforgedItems.raw_aluminum_block.get());
        tag(RAW_KEPU).add(TinkersReforgedItems.raw_kepu_block.get());

        tag(ORES).add(TinkersReforgedItems.aluminum_ore.get(), TinkersReforgedItems.kepu_ore.get(), TinkersReforgedItems.deepslate_aluminum_ore.get());

        tag(DURALUMIN).add(TinkersReforgedItems.duralumin_block.get());
        tag(ALUMINUM).add(TinkersReforgedItems.aluminum_block.get());
        tag(ELECTRICAL_COPPER).add(TinkersReforgedItems.electrical_copper_block.get());
        tag(LAVIUM).add(TinkersReforgedItems.lavium_block.get());
        tag(QIVIUM).add(TinkersReforgedItems.qivium_block.get());
        tag(GAUSUM).add(TinkersReforgedItems.gausum_block.get());
        tag(FELSTEEL).add(TinkersReforgedItems.felsteel_block.get());
        tag(KEPU).add(TinkersReforgedItems.kepu_block.get());
        tag(CHORUS_METAl).add(TinkersReforgedItems.chorus_metal_block.get());

        tag(INGOTS)
                .add(TinkersReforgedItems.aluminum_ingot.get())
                .add(TinkersReforgedItems.duralumin_ingot.get())
                .add(TinkersReforgedItems.electrical_copper_ingot.get())
                .add(TinkersReforgedItems.lavium_ingot.get())
                .add(TinkersReforgedItems.qivium_ingot.get())
                .add(TinkersReforgedItems.gausum_ingot.get())
                .add(TinkersReforgedItems.felsteel_ingot.get())
                .add(TinkersReforgedItems.kepu_ingot.get())
                .add(TinkersReforgedItems.chorus_metal_ingot.get());

        tag(DUSTS)
                .add(TinkersReforgedItems.aluminum_dust.get())
                .add(TinkersReforgedItems.duralumin_dust.get())
                .add(TinkersReforgedItems.electrical_copper_dust.get())
                .add(TinkersReforgedItems.lavium_dust.get())
                .add(TinkersReforgedItems.qivium_dust.get())
                .add(TinkersReforgedItems.gausum_dust.get())
                .add(TinkersReforgedItems.felsteel_dust.get())
                .add(TinkersReforgedItems.kepu_dust.get())
                .add(TinkersReforgedItems.chorus_metal_dust.get());

        tag(NUGGETS)
                .add(TinkersReforgedItems.aluminum_nugget.get())
                .add(TinkersReforgedItems.duralumin_nugget.get())
                .add(TinkersReforgedItems.electrical_copper_nugget.get())
                .add(TinkersReforgedItems.lavium_nugget.get())
                .add(TinkersReforgedItems.qivium_nugget.get())
                .add(TinkersReforgedItems.gausum_nugget.get())
                .add(TinkersReforgedItems.felsteel_nugget.get())
                .add(TinkersReforgedItems.kepu_nugget.get())
                .add(TinkersReforgedItems.chorus_metal_nugget.get());

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
                .add(TinkersReforgedBlocks.durasteel_block.get().asItem());

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

        TagKey<Item> goldTag = create("tconstruct:casts/gold");
        TagKey<Item> sandTag = create("tconstruct:casts/sand");
        TagKey<Item> redSandTag = create("tconstruct:casts/red_sand");
        tag(goldTag).add(object.getGoldCast().get());
        tag(sandTag).add(object.getSandCast().get());
        tag(redSandTag).add(object.getRedSandCast().get());
        tag(TinkerTags.Items.MULTI_USE_CASTS).addTag(multiUseTag);
        tag(TinkerTags.Items.SINGLE_USE_CASTS).addTag(singleUseTag);
    }
}
