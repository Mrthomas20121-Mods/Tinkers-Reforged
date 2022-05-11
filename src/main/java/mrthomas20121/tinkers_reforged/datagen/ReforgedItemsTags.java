package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.CastType;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedBlocks;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedItems;
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

public class ReforgedItemsTags extends ItemTagsProvider {

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

    public static final TagKey<Item> ALUMINUM_CASTS = create("tinkers_reforged:casts/aluminum");

    private static TagKey<Item> create(String name) {
        return ItemTags.create(new ResourceLocation(name));
    }

    public ReforgedItemsTags(DataGenerator gen, BlockTagsProvider blockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, blockTagsProvider, TinkersReforged.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

        tag(ORES).add(TinkersReforgedItems.aluminum_ore.get().asItem());
        tag(INGOTS)
                .add(TinkersReforgedItems.aluminum_ingot.get())
                .add(TinkersReforgedItems.duralumin_ingot.get())
                .add(TinkersReforgedItems.electrical_copper_ingot.get())
                .add(TinkersReforgedItems.lavium_ingot.get())
                .add(TinkersReforgedItems.qivium_ingot.get())
                .add(TinkersReforgedItems.gausum_ingot.get());

        tag(DUSTS)
                .add(TinkersReforgedItems.aluminum_dust.get())
                .add(TinkersReforgedItems.duralumin_dust.get())
                .add(TinkersReforgedItems.electrical_copper_dust.get())
                .add(TinkersReforgedItems.lavium_dust.get())
                .add(TinkersReforgedItems.qivium_dust.get())
                .add(TinkersReforgedItems.gausum_dust.get());

        tag(NUGGETS)
                .add(TinkersReforgedItems.aluminum_nugget.get())
                .add(TinkersReforgedItems.duralumin_nugget.get())
                .add(TinkersReforgedItems.electrical_copper_nugget.get())
                .add(TinkersReforgedItems.lavium_nugget.get())
                .add(TinkersReforgedItems.qivium_nugget.get())
                .add(TinkersReforgedItems.gausum_nugget.get());

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

        tag(ALUMINUM_ORE).add(TinkersReforgedItems.aluminum_ore.get().asItem());
        tag(ALUMINUM_INGOT).add(TinkersReforgedItems.aluminum_ingot.get());
        tag(ALUMINUM_DUST).add(TinkersReforgedItems.aluminum_dust.get());
        tag(ALUMINUM_NUGGET).add(TinkersReforgedItems.aluminum_nugget.get());

        tag(GAUSUM_INGOT).add(TinkersReforgedItems.gausum_ingot.get());
        tag(GAUSUM_DUST).add(TinkersReforgedItems.gausum_dust.get());
        tag(GAUSUM_NUGGET).add(TinkersReforgedItems.gausum_nugget.get());

        tag(TinkerTags.Items.ANVIL_METAL)
                .add(TinkersReforgedBlocks.duralumin_block.get().asItem())
                .add(TinkersReforgedBlocks.aluminum_block.get().asItem())
                .add(TinkersReforgedBlocks.electrical_copper_block.get().asItem())
                .add(TinkersReforgedBlocks.lavium_block.get().asItem())
                .add(TinkersReforgedBlocks.qivium_block.get().asItem())
                .add(TinkersReforgedBlocks.gausum_block.get().asItem());

        TagsProvider.TagAppender<Item> builder = tag(ALUMINUM_CASTS);
        for(CastType type: CastType.values()) {
            Item cast = TinkersReforgedItems.casts.get(type).get();
            builder.add(cast);
            TagKey<Item> castTag = create(String.format("tconstruct:casts/multi_use/%s", type.name().toLowerCase()));
            tag(castTag).add(cast);
        }
    }
}
