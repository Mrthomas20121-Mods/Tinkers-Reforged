package mrthomas20121.tinkers_reforged.datagen.tcon;

import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.client.data.spritetransformer.GreyToColorMapping;

import javax.annotation.Nonnull;

public class ReforgedMaterialSpriteProvider extends AbstractMaterialSpriteProvider {

    @Nonnull
    @Override
    public String getName() {
        return "Tinkers Reforged Material Sprite Provider";
    }

    @Override
    protected void addAllMaterials() {
        buildMaterial(ReforgedMaterialIds.aluminum)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF4C3D3B).addARGB(102, 0xFF675B57).addARGB(140, 0xFFB7A196).addARGB(178, 0xFFC2AEA0).addARGB(216, 0xFFD2C1B0).addARGB(255, 0xFFE4D5C1).build());
        buildMaterial(ReforgedMaterialIds.blazing_copper)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF9A031E).addARGB(102, 0xFFA7261D).addARGB(140, 0xFFBA3E1B).addARGB(178, 0xFFCF5218).addARGB(216, 0xFFEC751B).addARGB(255, 0xFFFB8B24).build());
        buildMaterial(ReforgedMaterialIds.qivium)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF5E0B2A).addARGB(102, 0xFF7C1A3D).addARGB(140, 0xFFD14B6A).addARGB(178, 0xFFE85A7B).addARGB(216, 0xFFF4708A).addARGB(255, 0xFFFF8499).build());
        buildMaterial(ReforgedMaterialIds.lavium)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF093D2A).addARGB(102, 0xFF13563F).addARGB(140, 0xFF259670).addARGB(178, 0xFF38B58F).addARGB(216, 0xFF4ED3AD).addARGB(255, 0xFF63E8CD).build());
        buildMaterial(ReforgedMaterialIds.electrical_copper)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF331B0B).addARGB(102, 0xFF4F2B12).addARGB(140, 0xFF996B3A).addARGB(178, 0xFFB5874F).addARGB(216, 0xFFC9A25E).addARGB(255, 0xFFDDC275).build());
        buildMaterial(ReforgedMaterialIds.duralumin)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF063A04).addARGB(102, 0xFF1F571B).addARGB(140, 0xFF74B267).addARGB(178, 0xFF8CC97D).addARGB(216, 0xFFA2DC8F).addARGB(255, 0xFFC4FAA9).build());
        buildMaterial(ReforgedMaterialIds.gausum)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF83DBE9).addARGB(102, 0xFF8EFAFF).addARGB(140, 0xFF305A60).addARGB(178, 0xFF42777F).addARGB(216, 0xFF4F8F99).addARGB(255, 0xFF75BCC6).build());
        buildMaterial(ReforgedMaterialIds.felsteel)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF282800).addARGB(102, 0xFF404201).addARGB(140, 0xFF7E8E00).addARGB(178, 0xFF91B200).addARGB(216, 0xFFAED104).addARGB(255, 0xFFC4EE06).build());
        buildMaterial(ReforgedMaterialIds.chorus_metal)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF130D16).addARGB(102, 0xFF2C2035).addARGB(140, 0xFF6C527A).addARGB(178, 0xFF876796).addARGB(216, 0xFFA884B7).addARGB(255, 0xFFC4A7CE).build());
        buildMaterial(ReforgedMaterialIds.kepu)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF0C2B3D).addARGB(102, 0xFF133D54).addARGB(140, 0xFF2C6F89).addARGB(178, 0xFF3D95AF).addARGB(216, 0xFF53B5CC).addARGB(255, 0xFF6ED5EA).build());
        buildMaterial(ReforgedMaterialIds.durasteel)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF080614).addARGB(102, 0xFF130F30).addARGB(140, 0xFF302C70).addARGB(178, 0xFF494499).addARGB(216, 0xFF5D5BB7).addARGB(255, 0xFF7073CC).build());
        buildMaterial(ReforgedMaterialIds.crusteel)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF161309).addARGB(102, 0xFF261E0E).addARGB(140, 0xFF6A521C).addARGB(178, 0xFF8C6920).addARGB(216, 0xFFA78527).addARGB(255, 0xFFBD9E2A).build());
        buildMaterial(ReforgedMaterialIds.wavy)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF190D0D).addARGB(102, 0xFF2D1817).addARGB(140, 0xFF513430).addARGB(178, 0xFF724C47).addARGB(216, 0xFF996B61).addARGB(255, 0xFFBC897E).build());
        buildMaterial(ReforgedMaterialIds.yokel)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF0E1409).addARGB(102, 0xFF233319).addARGB(140, 0xFF6B915D).addARGB(178, 0xFF8BBA7C).addARGB(216, 0xFFA6D89E).addARGB(255, 0xFFC0EFB9).build());
        buildMaterial(ReforgedMaterialIds.baolian)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF391E2C).addARGB(102, 0xFF462D38).addARGB(140, 0xFF8D737E).addARGB(178, 0xFF967D8A).addARGB(216, 0xFFAF97A7).addARGB(255, 0xFFBBA3B5).build());
        buildMaterial(ReforgedMaterialIds.galu)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF27292F).addARGB(102, 0xFF374341).addARGB(140, 0xFF5F796E).addARGB(178, 0xFF6F8F82).addARGB(216, 0xFF8FB9A9).addARGB(255, 0xFF9FCDBB).build());
        buildMaterial(ReforgedMaterialIds.epidote)
                .meleeHarvest()
                .fallbacks("crystal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF464434).addARGB(102, 0xFF585832).addARGB(140, 0xFF747936).addARGB(178, 0xFFA3B257).addARGB(216, 0xFFE9F496).addARGB(255, 0xFFF4FFCC).build());
        buildMaterial(ReforgedMaterialIds.hureaulite)
                .meleeHarvest()
                .fallbacks("crystal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF48060F).addARGB(102, 0xFF640D0B).addARGB(140, 0xFF872611).addARGB(178, 0xFFB7431F).addARGB(216, 0xFFD37851).addARGB(255, 0xFFECBEA4).build());
        buildMaterial(ReforgedMaterialIds.red_beryl)
                .meleeHarvest()
                .fallbacks("crystal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF6E1105).addARGB(102, 0xFF951A0B).addARGB(140, 0xFFB60F28).addARGB(178, 0xFFDE4476).addARGB(216, 0xFFEB91B9).addARGB(255, 0xFFF2DAE9).build());
        buildMaterial(ReforgedMaterialIds.cyber_steel)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF3C3972).addARGB(102, 0xFF544399).addARGB(140, 0xFF7368C5).addARGB(178, 0xFF8C89D3).addARGB(216, 0xFFA1A0D4).addARGB(255, 0xFFA1A0D4).build());
        buildMaterial(ReforgedMaterialIds.magma_steel)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF190A0D).addARGB(102, 0xFF47111B).addARGB(140, 0xFF5E1320).addARGB(178, 0xFF823130).addARGB(216, 0xFF93453F).addARGB(255, 0xFFB25D52).build());

        buildMaterial(ReforgedMaterialIds.ender_bone)
                .meleeHarvest()
                .fallbacks("bone")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF063931).addARGB(102, 0xFF233319).addARGB(140, 0xFF0B4D42).addARGB(178, 0xFF258474).addARGB(216, 0xFF349988).addARGB(255, 0xFF2CCDB1).build());
        buildMaterial(ReforgedMaterialIds.gelot)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF0D4652).addARGB(102, 0xFF146168).addARGB(140, 0xFF349E97).addARGB(178, 0xFF47B89F).addARGB(216, 0xFF75ECB9).addARGB(255, 0xFFA1F3CD).build());
        buildMaterial(ReforgedMaterialIds.piroot)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF5E0814).addARGB(102, 0xFF770E26).addARGB(140, 0xFFB02B5E).addARGB(178, 0xFFCA3D88).addARGB(216, 0xFFFF6AD8).addARGB(255, 0xFFFF99E9).build());
    }
}
