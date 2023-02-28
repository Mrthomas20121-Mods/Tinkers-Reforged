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
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.common.TinkerTags;

import javax.annotation.Nullable;

public class ReforgedFluidTags extends FluidTagsProvider {

    private static TagKey<Fluid> create(String name) {
        return FluidTags.create(new ResourceLocation(name));
    }

    public ReforgedFluidTags(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, TinkersReforged.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {

        tag(TinkerTags.Fluids.AVERAGE_METAL_SPILLING);

        tagAll(TinkersReforgedFluids.redstone);
        tagAll(TinkersReforgedFluids.lapis);
        tagAll(TinkersReforgedFluids.blazing_copper);
        tagAll(TinkersReforgedFluids.duralumin);
        tagAll(TinkersReforgedFluids.electrical_copper);
        tagAll(TinkersReforgedFluids.lavium);
        tagAll(TinkersReforgedFluids.qivium);
        tagAll(TinkersReforgedFluids.gausum);
        tagAll(TinkersReforgedFluids.felsteel);
        tagAll(TinkersReforgedFluids.kepu);
        tagAll(TinkersReforgedFluids.chorus_metal);
        tagAll(TinkersReforgedFluids.shulker);
        tagAll(TinkersReforgedFluids.durasteel);
        tagAll(TinkersReforgedFluids.crusteel);
        tagAll(TinkersReforgedFluids.wavy);
        tagAll(TinkersReforgedFluids.proto_lava);
        tagAll(TinkersReforgedFluids.baolian);
        tagAll(TinkersReforgedFluids.epidote);
        tagAll(TinkersReforgedFluids.hureaulite);
        tagAll(TinkersReforgedFluids.red_beryl);
        tagAll(TinkersReforgedFluids.galu);
        tagAll(TinkersReforgedFluids.magma_steel);
        tagAll(TinkersReforgedFluids.cyber_steel);
        tagAll(TinkersReforgedFluids.gelot);
        tagAll(TinkersReforgedFluids.piroot);
    }

    /** Tags this fluid using local tags */
    private void tagLocal(FluidObject<?> fluid) {
        tag(fluid.getLocalTag()).add(fluid.getStill(), fluid.getFlowing());
    }

    /** Tags this fluid with local and forge tags */
    private void tagAll(FluidObject<?> fluid) {
        tagLocal(fluid);
        tag(fluid.getForgeTag()).addTag(fluid.getLocalTag());
    }
}
