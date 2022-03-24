package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.Resources;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;
import net.minecraft.fluid.Fluid;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ReforgedFluidTags extends FluidTagsProvider {

    // forge tags
    public static final ITag.INamedTag<Fluid> DURALUMIN = FluidTags.bind("forge:molten_duralumin");
    public static final ITag.INamedTag<Fluid> ELECTRICAL_COPPER = FluidTags.bind("forge:molten_electrical_copper");
    public static final ITag.INamedTag<Fluid> LAVIUM = FluidTags.bind("forge:molten_lavium");
    public static final ITag.INamedTag<Fluid> QIVIUM = FluidTags.bind("forge:molten_qivium");
    public static final ITag.INamedTag<Fluid> BLAZING_COPPER = FluidTags.bind("forge:molten_blazing_copper");
    public static final ITag.INamedTag<Fluid> LAPIS = FluidTags.bind("forge:molten_lapis");
    public static final ITag.INamedTag<Fluid> GAUSUM = FluidTags.bind("forge:molten_gausum");

    // tinkers reforged tags
    public static final ITag.INamedTag<Fluid> DURALUMIN_ = FluidTags.bind("tinkers_reforged:molten_duralumin");
    public static final ITag.INamedTag<Fluid> ELECTRICAL_COPPER_ = FluidTags.bind("tinkers_reforged:molten_electrical_copper");
    public static final ITag.INamedTag<Fluid> LAVIUM_ = FluidTags.bind("tinkers_reforged:molten_lavium");
    public static final ITag.INamedTag<Fluid> QIVIUM_ = FluidTags.bind("tinkers_reforged:molten_qivium");
    public static final ITag.INamedTag<Fluid> BLAZING_COPPER_ = FluidTags.bind("tinkers_reforged:molten_blazing_copper");
    public static final ITag.INamedTag<Fluid> GAUSUM_ = FluidTags.bind("tinkers_reforged:molten_gausum");
    public static final ITag.INamedTag<Fluid> LAPIS_ = FluidTags.bind("tinkers_reforged:molten_lapis");

    public ReforgedFluidTags(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, TinkersReforged.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

        tag(BLAZING_COPPER).add(Resources.blazing_copper.getStill());
        tag(DURALUMIN).add(Resources.duralumin.getStill());
        tag(ELECTRICAL_COPPER).add(Resources.electrical_copper.getStill());
        tag(LAVIUM).add(Resources.lavium.getStill());
        tag(QIVIUM).add(Resources.qivium.getStill());
        tag(GAUSUM).add(Resources.gausum.getStill());
        tag(LAPIS).add(Resources.lapis.getStill());

        tag(BLAZING_COPPER_).add(Resources.blazing_copper.getStill());
        tag(DURALUMIN_).add(Resources.duralumin.getStill());
        tag(ELECTRICAL_COPPER_).add(Resources.electrical_copper.getStill());
        tag(LAVIUM_).add(Resources.lavium.getStill());
        tag(QIVIUM_).add(Resources.qivium.getStill());
        tag(GAUSUM_).add(Resources.gausum.getStill());
        tag(LAPIS_).add(Resources.lapis.getStill());
    }
}
