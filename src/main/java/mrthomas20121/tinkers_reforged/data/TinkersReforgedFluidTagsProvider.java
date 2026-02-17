package mrthomas20121.tinkers_reforged.data;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.data.Metal;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.registration.object.FluidObject;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class TinkersReforgedFluidTagsProvider extends FluidTagsProvider {

    public TinkersReforgedFluidTagsProvider(PackOutput p_255941_, CompletableFuture<HolderLookup.Provider> p_256600_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_255941_, p_256600_, TinkersReforged.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        for(Metal metal: Metal.values) {
            fluidTag(TinkersReforgedFluids.METALS.get(metal));
        }
    }

    private void fluidTag(FluidObject<?> fluid) {
        tag(Objects.requireNonNull(fluid.getCommonTag())).add(fluid.get());
    }
}
