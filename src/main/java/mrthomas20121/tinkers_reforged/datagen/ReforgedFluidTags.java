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

    public static final ITag.INamedTag<Fluid> DURALUMIN = FluidTags.bind("forge:duralumin");
    public static final ITag.INamedTag<Fluid> ELECTRICAL_COPPER = FluidTags.bind("forge:electrical_copper");
    public static final ITag.INamedTag<Fluid> LAVIUM = FluidTags.bind("forge:lavium");
    public static final ITag.INamedTag<Fluid> QIVIUM = FluidTags.bind("forge:qivium");

    public ReforgedFluidTags(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, TinkersReforged.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(DURALUMIN).add(Resources.duralumin.getFluid());
        tag(ELECTRICAL_COPPER).add(Resources.electrical_copper.getFluid());
        tag(LAVIUM).add(Resources.lavium.getFluid());
        tag(QIVIUM).add(Resources.qivium.getFluid());
    }
}
