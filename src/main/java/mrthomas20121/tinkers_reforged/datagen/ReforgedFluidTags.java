package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedFluids;
import mrthomas20121.tinkers_reforged.api.material.ReforgedFluid;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.mantle.registration.object.FluidObject;

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

        for(ReforgedFluid fluid: ReforgedFluid.values()) {
            for(TagKey<Fluid> t: fluid.getFluid()) {
                tag(t).add(
                        TinkersReforgedFluids.ALL_FLUIDS.get(fluid).getStill(),
                        TinkersReforgedFluids.ALL_FLUIDS.get(fluid).getFlowing()
                );

                tagAll(TinkersReforgedFluids.ALL_FLUIDS.get(fluid));
            }
        }
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
