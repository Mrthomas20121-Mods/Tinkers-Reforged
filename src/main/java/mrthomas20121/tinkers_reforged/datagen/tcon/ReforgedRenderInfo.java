package mrthomas20121.tinkers_reforged.datagen.tcon;

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
        buildRenderInfo(ReforgedMaterialIds.aluminum).color(0xE4D5C1).fallbacks("metal");
        buildRenderInfo(ReforgedMaterialIds.blazing_copper).color(0xFB8B24).fallbacks("metal");
        buildRenderInfo(ReforgedMaterialIds.duralumin).color(0xA2DC8F).fallbacks("metal");
        buildRenderInfo(ReforgedMaterialIds.electrical_copper).color(0xC9A25E).fallbacks("metal");
        buildRenderInfo(ReforgedMaterialIds.lavium).color(0x4ED3AD).fallbacks("metal");
        buildRenderInfo(ReforgedMaterialIds.qivium).color(0xF4708A).fallbacks("metal");
        buildRenderInfo(ReforgedMaterialIds.gausum).color(0x75BCC6).fallbacks("metal");
        buildRenderInfo(ReforgedMaterialIds.felsteel).color(0xAED104).fallbacks("metal");
        buildRenderInfo(ReforgedMaterialIds.chorus_metal).color(0xA884B7).fallbacks("metal");
        buildRenderInfo(ReforgedMaterialIds.kepu).color(0x53B5CC).fallbacks("metal");
        buildRenderInfo(ReforgedMaterialIds.durasteel).color(0x5D5BB7).fallbacks("rock");
        buildRenderInfo(ReforgedMaterialIds.crusteel).color(0xBD9E2A).fallbacks("metal");
        buildRenderInfo(ReforgedMaterialIds.wavy).color(0xBC897E).fallbacks("metal");
        buildRenderInfo(ReforgedMaterialIds.yokel).color(0xBC897E).fallbacks("metal");
        buildRenderInfo(ReforgedMaterialIds.baolian).color(0xBBA3B5).fallbacks("metal");
        buildRenderInfo(ReforgedMaterialIds.epidote).color(0xE9F496).fallbacks("crystal");
        buildRenderInfo(ReforgedMaterialIds.galu).color(0x8FB9A9).fallbacks("metal");
        buildRenderInfo(ReforgedMaterialIds.hureaulite).color(0xD37851).fallbacks("crystal");
        buildRenderInfo(ReforgedMaterialIds.red_beryl).color(0xEB91B9).fallbacks("crystal");
        buildRenderInfo(ReforgedMaterialIds.ender_bone).color(0x2CCDB1).fallbacks("bone");
    }

    @Nonnull
    @Override
    public String getName() {
        return "Tinkers Reforged Render info provider!";
    }
}
