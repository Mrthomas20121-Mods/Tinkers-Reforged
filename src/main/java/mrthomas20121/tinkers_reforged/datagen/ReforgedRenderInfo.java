package mrthomas20121.tinkers_reforged.datagen;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialRenderInfoProvider;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;

import javax.annotation.Nonnull;

public class ReforgedRenderInfo extends AbstractMaterialRenderInfoProvider {

    public ReforgedRenderInfo(DataGenerator gen, AbstractMaterialSpriteProvider spriteProvider) {
        super(gen, spriteProvider);
    }

    @Override
    protected void addMaterialRenderInfo() {
        buildRenderInfo(ReforgedMaterials.duralumin).color(0xD1F1C1).fallbacks("metal");
        buildRenderInfo(ReforgedMaterials.electrical_copper).color(0xE0B475).fallbacks("metal");
        buildRenderInfo(ReforgedMaterials.lavium).color(0x81B366).fallbacks("metal");
        buildRenderInfo(ReforgedMaterials.qivium).color(0xFF8F84).fallbacks("metal");
        buildRenderInfo(ReforgedMaterials.gausum).color(0x75BCC6).fallbacks("metal");
    }

    @Nonnull
    @Override
    public String getName() {
        return "Tinkers Reforged Render info provider!";
    }
}
