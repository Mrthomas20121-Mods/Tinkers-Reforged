package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.Resources;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ReforgedItemsTags extends ItemTagsProvider {

    public static final ITag.INamedTag<Item> INGOTS = ItemTags.bind("forge:ingots");
    public static final ITag.INamedTag<Item> DUSTS = ItemTags.bind("forge:dusts");
    public static final ITag.INamedTag<Item> NUGGETS = ItemTags.bind("forge:nuggets");
    public static final ITag.INamedTag<Item> ORES = ItemTags.bind("forge:ores");

    public static final ITag.INamedTag<Item> DURALUMIN_INGOT = ItemTags.bind("forge:ingots/duralumin");
    public static final ITag.INamedTag<Item> DURALUMIN_DUST = ItemTags.bind("forge:dusts/duralumin");
    public static final ITag.INamedTag<Item> DURALUMIN_NUGGET = ItemTags.bind("forge:nuggets/duralumin");

    public static final ITag.INamedTag<Item> ELECTRICAL_COPPER_INGOT = ItemTags.bind("forge:ingots/electrical_copper");
    public static final ITag.INamedTag<Item> ELECTRICAL_COPPER_DUST = ItemTags.bind("forge:dusts/electrical_copper");
    public static final ITag.INamedTag<Item> ELECTRICAL_COPPER_NUGGET = ItemTags.bind("forge:nuggets/electrical_copper");

    public static final ITag.INamedTag<Item> LAVIUM_INGOT = ItemTags.bind("forge:ingots/lavium");
    public static final ITag.INamedTag<Item> LAVIUM_DUST = ItemTags.bind("forge:dusts/lavium");
    public static final ITag.INamedTag<Item> LAVIUM_NUGGET = ItemTags.bind("forge:nuggets/lavium");

    public static final ITag.INamedTag<Item> QIVIUM_INGOT = ItemTags.bind("forge:ingots/qivium");
    public static final ITag.INamedTag<Item> QIVIUM_DUST = ItemTags.bind("forge:dusts/qivium");
    public static final ITag.INamedTag<Item> QIVIUM_NUGGET = ItemTags.bind("forge:nuggets/qivium");

    public static final ITag.INamedTag<Item> ALUMINUM_ORE = ItemTags.bind("forge:ores/aluminum");
    public static final ITag.INamedTag<Item> ALUMINUM_INGOT = ItemTags.bind("forge:ingots/aluminum");
    public static final ITag.INamedTag<Item> ALUMINUM_DUST = ItemTags.bind("forge:dusts/aluminum");
    public static final ITag.INamedTag<Item> ALUMINUM_NUGGET = ItemTags.bind("forge:nuggets/aluminum");

    public ReforgedItemsTags(DataGenerator gen, BlockTagsProvider blockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, blockTagsProvider, TinkersReforged.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

        tag(ORES).add(Resources.aluminum_ore.get().asItem());
        tag(INGOTS)
                .add(Resources.aluminum_ingot.get())
                .add(Resources.duralumin_ingot.get())
                .add(Resources.electrical_copper_ingot.get())
                .add(Resources.lavium_ingot.get())
                .add(Resources.qivium_ingot.get());

        tag(DUSTS)
                .add(Resources.aluminum_dust.get())
                .add(Resources.duralumin_dust.get())
                .add(Resources.electrical_copper_dust.get())
                .add(Resources.lavium_dust.get())
                .add(Resources.qivium_dust.get());

        tag(NUGGETS)
                .add(Resources.aluminum_nugget.get())
                .add(Resources.duralumin_nugget.get())
                .add(Resources.electrical_copper_nugget.get())
                .add(Resources.lavium_nugget.get())
                .add(Resources.qivium_nugget.get());

        tag(DURALUMIN_INGOT).add(Resources.duralumin_ingot.get());
        tag(DURALUMIN_DUST).add(Resources.duralumin_dust.get());
        tag(DURALUMIN_NUGGET).add(Resources.duralumin_nugget.get());

        tag(ELECTRICAL_COPPER_INGOT).add(Resources.electrical_copper_ingot.get());
        tag(ELECTRICAL_COPPER_DUST).add(Resources.electrical_copper_dust.get());
        tag(ELECTRICAL_COPPER_NUGGET).add(Resources.electrical_copper_nugget.get());

        tag(LAVIUM_INGOT).add(Resources.lavium_ingot.get());
        tag(LAVIUM_DUST).add(Resources.lavium_dust.get());
        tag(LAVIUM_NUGGET).add(Resources.lavium_nugget.get());

        tag(QIVIUM_INGOT).add(Resources.qivium_ingot.get());
        tag(QIVIUM_DUST).add(Resources.qivium_dust.get());
        tag(QIVIUM_NUGGET).add(Resources.qivium_nugget.get());

        tag(ALUMINUM_ORE).add(Resources.aluminum_ore.get().asItem());
        tag(ALUMINUM_INGOT).add(Resources.aluminum_ingot.get());
        tag(ALUMINUM_DUST).add(Resources.aluminum_dust.get());
        tag(ALUMINUM_NUGGET).add(Resources.aluminum_nugget.get());
    }
}
