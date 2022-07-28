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
        buildRenderInfo(ReforgedMaterials.duralumin).color(0xA2DC8F).fallbacks("metal");
        buildRenderInfo(ReforgedMaterials.electrical_copper).color(0xC9A25E).fallbacks("metal");
        buildRenderInfo(ReforgedMaterials.lavium).color(0x4ED3AD).fallbacks("metal");
        buildRenderInfo(ReforgedMaterials.qivium).color(0xF4708A).fallbacks("metal");
        buildRenderInfo(ReforgedMaterials.gausum).color(0x75BCC6).fallbacks("metal");
        buildRenderInfo(ReforgedMaterials.felsteel).color(0xAED104).fallbacks("metal");
        buildRenderInfo(ReforgedMaterials.chorus_metal).color(0xA884B7).fallbacks("metal");
        buildRenderInfo(ReforgedMaterials.kepu).color(0x53B5CC).fallbacks("metal");
        buildRenderInfo(ReforgedMaterials.durasteel).color(0x5D5BB7).fallbacks("rock");
        buildRenderInfo(ReforgedMaterials.crusteel).color(0xBD9E2A).fallbacks("metal");
        buildRenderInfo(ReforgedMaterials.wavy).color(0xBC897E).fallbacks("metal");
        buildRenderInfo(ReforgedMaterials.yokel).color(0xBC897E).fallbacks("metal");
        buildRenderInfo(ReforgedMaterials.ender_bone).color(0x2CCDB1).fallbacks("bone");
    }

    @Nonnull
    @Override
    public String getName() {
        return "Tinkers Reforged Render info provider!";
    }
}
