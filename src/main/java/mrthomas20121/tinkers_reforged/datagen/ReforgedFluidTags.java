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
    public static final TagKey<Fluid> FELSTEEL = create("forge:molten_felsteel");
    public static final TagKey<Fluid> KEPU = create("forge:molten_kepu");
    public static final TagKey<Fluid> CHRORUS_METAL = create("forge:molten_chorus_metal");
    public static final TagKey<Fluid> CHORUS = create("forge:molten_chorus");
    public static final TagKey<Fluid> SHULKER = create("forge:molten_shulker");
    public static final TagKey<Fluid> DURASTEEL = create("forge:molten_durasteel");
    public static final TagKey<Fluid> PROTO_LAVA = create("forge:molten_proto_lava");

    // tinkers reforged tags
    public static final TagKey<Fluid> DURALUMIN_ = create("tinkers_reforged:molten_duralumin");
    public static final TagKey<Fluid> ELECTRICAL_COPPER_ = create("tinkers_reforged:molten_electrical_copper");
    public static final TagKey<Fluid> LAVIUM_ = create("tinkers_reforged:molten_lavium");
    public static final TagKey<Fluid> QIVIUM_ = create("tinkers_reforged:molten_qivium");
    public static final TagKey<Fluid> BLAZING_COPPER_ = create("tinkers_reforged:molten_blazing_copper");
    public static final TagKey<Fluid> GAUSUM_ = create("tinkers_reforged:molten_gausum");
    public static final TagKey<Fluid> LAPIS_ = create("tinkers_reforged:molten_lapis");
    public static final TagKey<Fluid> FELSTEEL_ = create("tinkers_reforged:molten_felsteel");
    public static final TagKey<Fluid> KEPU_ = create("tinkers_reforged:molten_kepu");
    public static final TagKey<Fluid> CHRORUS_METAL_ = create("tinkers_reforged:molten_chorus_metal");
    public static final TagKey<Fluid> CHORUS_ = create("tinkers_reforged:molten_chorus");
    public static final TagKey<Fluid> SHULKER_ = create("tinkers_reforged:molten_shulker");
    public static final TagKey<Fluid> DURASTEEL_ = create("tinkers_reforged:molten_durasteel");
    public static final TagKey<Fluid> PROTO_LAVA_ = create("tinkers_reforged:molten_proto_lava");

    private static TagKey<Fluid> create(String name) {
        return FluidTags.create(new ResourceLocation(name));
    }

    public ReforgedFluidTags(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, TinkersReforged.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

        tag(BLAZING_COPPER).add(TinkersReforgedFluids.blazing_copper.get());
        tag(DURALUMIN).add(TinkersReforgedFluids.duralumin.getStill());
        tag(ELECTRICAL_COPPER).add(TinkersReforgedFluids.electrical_copper.get());
        tag(LAVIUM).add(TinkersReforgedFluids.lavium.get());
        tag(QIVIUM).add(TinkersReforgedFluids.qivium.get());
        tag(GAUSUM).add(TinkersReforgedFluids.gausum.get());
        tag(LAPIS).add(TinkersReforgedFluids.lapis.get());
        tag(FELSTEEL).add(TinkersReforgedFluids.felsteel.get());
        tag(KEPU).add(TinkersReforgedFluids.kepu.get());
        tag(CHRORUS_METAL).add(TinkersReforgedFluids.chorus_metal.get());
        tag(CHORUS).add(TinkersReforgedFluids.chorus.get());
        tag(SHULKER).add(TinkersReforgedFluids.shulker.get());
        tag(DURASTEEL).add(TinkersReforgedFluids.durasteel.get());
        tag(PROTO_LAVA).add(TinkersReforgedFluids.proto_lava.get());

        tag(BLAZING_COPPER_).add(TinkersReforgedFluids.blazing_copper.get());
        tag(DURALUMIN_).add(TinkersReforgedFluids.duralumin.get());
        tag(ELECTRICAL_COPPER_).add(TinkersReforgedFluids.electrical_copper.get());
        tag(LAVIUM_).add(TinkersReforgedFluids.lavium.get());
        tag(QIVIUM_).add(TinkersReforgedFluids.qivium.get());
        tag(GAUSUM_).add(TinkersReforgedFluids.gausum.get());
        tag(LAPIS_).add(TinkersReforgedFluids.lapis.get());
        tag(FELSTEEL_).add(TinkersReforgedFluids.felsteel.get());
        tag(KEPU_).add(TinkersReforgedFluids.kepu.get());
        tag(CHRORUS_METAL_).add(TinkersReforgedFluids.chorus_metal.get());
        tag(CHORUS_).add(TinkersReforgedFluids.chorus.get());
        tag(SHULKER_).add(TinkersReforgedFluids.shulker.get());
        tag(DURASTEEL_).add(TinkersReforgedFluids.durasteel.get());
        tag(PROTO_LAVA_).add(TinkersReforgedFluids.proto_lava.get());
    }
}
