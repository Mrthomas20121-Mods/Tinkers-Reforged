package mrthomas20121.tinkers_reforged.data;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.data.Metal;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedTags;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.data.tinkering.AbstractMaterialTagProvider;

public class TinkersReforgedMaterialTagsProvider extends AbstractMaterialTagProvider {

    public TinkersReforgedMaterialTagsProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, TinkersReforged.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        for(Metal metal: Metal.values) {
            tag(TinkersReforgedTags.MATERIALS).add(metal.asMaterial());
        }

        tag(TinkerTags.Materials.BARTERED).add(Metal.BARIUM.asMaterial(), Metal.TELLURIUM.asMaterial(), Metal.ACTINIUM.asMaterial());
        tag(TinkerTags.Materials.NETHER).add(Metal.BARIUM.asMaterial(), Metal.TELLURIUM.asMaterial(), Metal.ACTINIUM.asMaterial());
        tag(TinkerTags.Materials.NETHER_GATED).add(Metal.BARIUM.asMaterial(), Metal.TELLURIUM.asMaterial(), Metal.ACTINIUM.asMaterial());
    }

    @Override
    public String getName() {
        return "Tinkers Reforged Material Tags Provider";
    }
}
