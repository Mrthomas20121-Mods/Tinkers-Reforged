package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedFluids;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ReforgedFluidTags extends FluidTagsProvider {

    // forge tags
    public static final TagKey<Fluid> DURALUMIN = create("forge:molten_duralumin");
    public static final TagKey<Fluid> ELECTRICAL_COPPER = create("forge:molten_electrical_copper");
    public static final TagKey<Fluid> LAVIUM = create("forge:molten_lavium");
    public static final TagKey<Fluid> QIVIUM = create("forge:molten_qivium");
    public static final TagKey<Fluid> BLAZING_COPPER = create("forge:molten_blazing_copper");
    public static final TagKey<Fluid> LAPIS = create("forge:molten_lapis");
    public static final TagKey<Fluid> GAUSUM = create("forge:molten_gausum");
    public static final TagKey<Fluid> REDSTONE = create("forge:redstone");

    // tinkers reforged tags
    public static final TagKey<Fluid> DURALUMIN_ = create("tinkers_reforged:molten_duralumin");
    public static final TagKey<Fluid> ELECTRICAL_COPPER_ = create("tinkers_reforged:molten_electrical_copper");
    public static final TagKey<Fluid> LAVIUM_ = create("tinkers_reforged:molten_lavium");
    public static final TagKey<Fluid> QIVIUM_ = create("tinkers_reforged:molten_qivium");
    public static final TagKey<Fluid> BLAZING_COPPER_ = create("tinkers_reforged:molten_blazing_copper");
    public static final TagKey<Fluid> GAUSUM_ = create("tinkers_reforged:molten_gausum");
    public static final TagKey<Fluid> LAPIS_ = create("tinkers_reforged:molten_lapis");

    private static TagKey<Fluid> create(String name) {
        return FluidTags.create(new ResourceLocation(name));
    }

    public ReforgedFluidTags(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, TinkersReforged.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

        tag(BLAZING_COPPER).add(TinkersReforgedFluids.blazing_copper.getStill());
        tag(DURALUMIN).add(TinkersReforgedFluids.duralumin.getStill());
        tag(ELECTRICAL_COPPER).add(TinkersReforgedFluids.electrical_copper.getStill());
        tag(LAVIUM).add(TinkersReforgedFluids.lavium.getStill());
        tag(QIVIUM).add(TinkersReforgedFluids.qivium.getStill());
        tag(GAUSUM).add(TinkersReforgedFluids.gausum.getStill());
        tag(LAPIS).add(TinkersReforgedFluids.lapis.getStill());

        tag(BLAZING_COPPER_).add(TinkersReforgedFluids.blazing_copper.getStill());
        tag(DURALUMIN_).add(TinkersReforgedFluids.duralumin.getStill());
        tag(ELECTRICAL_COPPER_).add(TinkersReforgedFluids.electrical_copper.getStill());
        tag(LAVIUM_).add(TinkersReforgedFluids.lavium.getStill());
        tag(QIVIUM_).add(TinkersReforgedFluids.qivium.getStill());
        tag(GAUSUM_).add(TinkersReforgedFluids.gausum.getStill());
        tag(LAPIS_).add(TinkersReforgedFluids.lapis.getStill());
    }
}
