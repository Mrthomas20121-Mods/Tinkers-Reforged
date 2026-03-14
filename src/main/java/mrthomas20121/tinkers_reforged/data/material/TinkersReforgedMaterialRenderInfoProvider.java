package mrthomas20121.tinkers_reforged.data.material;

import mrthomas20121.tinkers_reforged.api.data.Metal;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.tools.data.material.MaterialRenderInfoProvider;

public class TinkersReforgedMaterialRenderInfoProvider extends MaterialRenderInfoProvider {

    public TinkersReforgedMaterialRenderInfoProvider(PackOutput packOutput, AbstractMaterialSpriteProvider spriteProvider, ExistingFileHelper existingFileHelper) {
        super(packOutput, spriteProvider, existingFileHelper);
    }

    @Override
    protected void addMaterialRenderInfo() {

        buildRenderInfo(Metal.GRAPHITE.asMaterial()).color(0x1c1c20).fallbacks("metal");
        buildRenderInfo(Metal.YTTRIUM.asMaterial()).color(0x451318).fallbacks("metal");
        buildRenderInfo(Metal.BARIUM.asMaterial()).color(0x2a1d5b).fallbacks("metal");
        buildRenderInfo(Metal.ASTATINE.asMaterial()).color(0xe99475).fallbacks("metal");
        buildRenderInfo(Metal.TELLURIUM.asMaterial()).color(0x522728).fallbacks("metal");
        buildRenderInfo(Metal.GERMANIUM.asMaterial()).color(0x4c183c).fallbacks("metal");
        buildRenderInfo(Metal.BERKELIUM.asMaterial()).color(0x40541e).fallbacks("metal");
        buildRenderInfo(Metal.ACTINIUM.asMaterial()).color(0x403e2f).fallbacks("metal");
        buildRenderInfo(Metal.THALLIUM.asMaterial()).color(0x28373c).fallbacks("metal");
    }
}
