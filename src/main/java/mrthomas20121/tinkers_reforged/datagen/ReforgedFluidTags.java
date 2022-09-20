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

import static mrthomas20121.tinkers_reforged.init.TinkersReforgedTags.Fluids.*;

public class ReforgedFluidTags extends FluidTagsProvider {

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
        tag(CRUSTEEL).add(TinkersReforgedFluids.crusteel.get());
        tag(WAVY).add(TinkersReforgedFluids.wavy.get());
        tag(KELP).add(TinkersReforgedFluids.kelp.get());
        tag(YOKEL).add(TinkersReforgedFluids.yokel.get());
        tag(PROTO_LAVA).add(TinkersReforgedFluids.proto_lava.get());
        tag(BAOLIAN).add(TinkersReforgedFluids.baolian.get());
        tag(EPIDOTE).add(TinkersReforgedFluids.epidote.get());
        tag(GALU).add(TinkersReforgedFluids.galu.get());
        tag(HUREAULITE).add(TinkersReforgedFluids.hureaulite.get());
        tag(RED_BERYL).add(TinkersReforgedFluids.red_beryl.get());

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
        tag(CRUSTEEL_).add(TinkersReforgedFluids.crusteel.get());
        tag(WAVY_).add(TinkersReforgedFluids.wavy.get());
        tag(KELP_).add(TinkersReforgedFluids.kelp.get());
        tag(YOKEL_).add(TinkersReforgedFluids.yokel.get());
        tag(PROTO_LAVA_).add(TinkersReforgedFluids.proto_lava.get());
        tag(BAOLIAN_).add(TinkersReforgedFluids.baolian.get());
        tag(EPIDOTE_).add(TinkersReforgedFluids.epidote.get());
        tag(GALU_).add(TinkersReforgedFluids.galu.get());
        tag(HUREAULITE_).add(TinkersReforgedFluids.hureaulite.get());
        tag(RED_BERYL_).add(TinkersReforgedFluids.red_beryl.get());
    }
}
