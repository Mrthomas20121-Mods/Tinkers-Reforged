package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.Resources;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
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
    public static final ITag.INamedTag<Fluid> REDSTONE = FluidTags.bind("forge:redstone");

    // tinkers reforged tags
    public static final ITag.INamedTag<Fluid> DURALUMIN_ = FluidTags.bind("tinkers_reforged:molten_duralumin");
    public static final ITag.INamedTag<Fluid> ELECTRICAL_COPPER_ = FluidTags.bind("tinkers_reforged:molten_electrical_copper");
    public static final ITag.INamedTag<Fluid> LAVIUM_ = FluidTags.bind("tinkers_reforged:molten_lavium");
    public static final ITag.INamedTag<Fluid> QIVIUM_ = FluidTags.bind("tinkers_reforged:molten_qivium");
    public static final ITag.INamedTag<Fluid> BLAZING_COPPER_ = FluidTags.bind("tinkers_reforged:molten_blazing_copper");
    public static final ITag.INamedTag<Fluid> REDSTONE_ = FluidTags.bind("tinkers_reforged:redstone");

    public static final ITag.INamedTag<Fluid> LAVA = FluidTags.bind("minecraft:lava");
    public static final ITag.INamedTag<Fluid> WATER = FluidTags.bind("minecraft:water");

    public ReforgedFluidTags(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, TinkersReforged.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

        // lava tag
        tag(LAVA)
                .add(
                        Resources.blazing_copper.getFluid(),
                        Resources.duralumin.getFluid(),
                        Resources.electrical_copper.getFluid(),
                        Resources.lavium.getFluid(),
                        Resources.qivium.getFluid(),
                        Resources.blazing_copper.getFlowingFluid().get(),
                        Resources.duralumin.getFlowingFluid().get(),
                        Resources.electrical_copper.getFlowingFluid().get(),
                        Resources.lavium.getFlowingFluid().get(),
                        Resources.qivium.getFlowingFluid().get()
                );
        // water tag
        tag(WATER).add(Resources.redstone.getFluid(), Resources.redstone.getFlowingFluid().get());

        tag(REDSTONE).add(Resources.redstone.getFluid());
        tag(BLAZING_COPPER).add(Resources.blazing_copper.getFluid());
        tag(DURALUMIN).add(Resources.duralumin.getFluid());
        tag(ELECTRICAL_COPPER).add(Resources.electrical_copper.getFluid());
        tag(LAVIUM).add(Resources.lavium.getFluid());
        tag(QIVIUM).add(Resources.qivium.getFluid());

        tag(REDSTONE_).add(Resources.redstone.getFluid());
        tag(BLAZING_COPPER_).add(Resources.blazing_copper.getFluid());
        tag(DURALUMIN_).add(Resources.duralumin.getFluid());
        tag(ELECTRICAL_COPPER_).add(Resources.electrical_copper.getFluid());
        tag(LAVIUM_).add(Resources.lavium.getFluid());
        tag(QIVIUM_).add(Resources.qivium.getFluid());
    }
}
