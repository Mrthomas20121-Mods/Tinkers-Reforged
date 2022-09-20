package mrthomas20121.tinkers_reforged.datagen;

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
        buildMaterial(ReforgedMaterials.qivium)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF5E0B2A).addARGB(102, 0xFF7C1A3D).addARGB(140, 0xFFD14B6A).addARGB(178, 0xFFE85A7B).addARGB(216, 0xFFF4708A).addARGB(255, 0xFFFF8499).build());
        buildMaterial(ReforgedMaterials.lavium)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF093D2A).addARGB(102, 0xFF13563F).addARGB(140, 0xFF259670).addARGB(178, 0xFF38B58F).addARGB(216, 0xFF4ED3AD).addARGB(255, 0xFF63E8CD).build());
        buildMaterial(ReforgedMaterials.electrical_copper)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF331B0B).addARGB(102, 0xFF4F2B12).addARGB(140, 0xFF996B3A).addARGB(178, 0xFFB5874F).addARGB(216, 0xFFC9A25E).addARGB(255, 0xFFDDC275).build());
        buildMaterial(ReforgedMaterials.duralumin)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF063A04).addARGB(102, 0xFF1F571B).addARGB(140, 0xFF74B267).addARGB(178, 0xFF8CC97D).addARGB(216, 0xFFA2DC8F).addARGB(255, 0xFFC4FAA9).build());
        buildMaterial(ReforgedMaterials.gausum)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF83DBE9).addARGB(102, 0xFF8EFAFF).addARGB(140, 0xFF305A60).addARGB(178, 0xFF42777F).addARGB(216, 0xFF4F8F99).addARGB(255, 0xFF75BCC6).build());
        buildMaterial(ReforgedMaterials.felsteel)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF282800).addARGB(102, 0xFF404201).addARGB(140, 0xFF7E8E00).addARGB(178, 0xFF91B200).addARGB(216, 0xFFAED104).addARGB(255, 0xFFC4EE06).build());
        buildMaterial(ReforgedMaterials.chorus_metal)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF130D16).addARGB(102, 0xFF2C2035).addARGB(140, 0xFF6C527A).addARGB(178, 0xFF876796).addARGB(216, 0xFFA884B7).addARGB(255, 0xFFC4A7CE).build());
        buildMaterial(ReforgedMaterials.kepu)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF0C2B3D).addARGB(102, 0xFF133D54).addARGB(140, 0xFF2C6F89).addARGB(178, 0xFF3D95AF).addARGB(216, 0xFF53B5CC).addARGB(255, 0xFF6ED5EA).build());
        buildMaterial(ReforgedMaterials.durasteel)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF080614).addARGB(102, 0xFF130F30).addARGB(140, 0xFF302C70).addARGB(178, 0xFF494499).addARGB(216, 0xFF5D5BB7).addARGB(255, 0xFF7073CC).build());
        buildMaterial(ReforgedMaterials.crusteel)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF161309).addARGB(102, 0xFF261E0E).addARGB(140, 0xFF6A521C).addARGB(178, 0xFF8C6920).addARGB(216, 0xFFA78527).addARGB(255, 0xFFBD9E2A).build());
        buildMaterial(ReforgedMaterials.wavy)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF190D0D).addARGB(102, 0xFF2D1817).addARGB(140, 0xFF513430).addARGB(178, 0xFF724C47).addARGB(216, 0xFF996B61).addARGB(255, 0xFFBC897E).build());
        buildMaterial(ReforgedMaterials.yokel)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF0E1409).addARGB(102, 0xFF233319).addARGB(140, 0xFF6B915D).addARGB(178, 0xFF8BBA7C).addARGB(216, 0xFFA6D89E).addARGB(255, 0xFFC0EFB9).build());
        buildMaterial(ReforgedMaterials.baolian)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF391E2C).addARGB(102, 0xFF462D38).addARGB(140, 0xFF8D737E).addARGB(178, 0xFF967D8A).addARGB(216, 0xFFAF97A7).addARGB(255, 0xFFBBA3B5).build());
        buildMaterial(ReforgedMaterials.galu)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF27292F).addARGB(102, 0xFF374341).addARGB(140, 0xFF5F796E).addARGB(178, 0xFF6F8F82).addARGB(216, 0xFF8FB9A9).addARGB(255, 0xFF9FCDBB).build());
        buildMaterial(ReforgedMaterials.hureaulite)
                .meleeHarvest()
                .fallbacks("crystal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFFAF5F47).addARGB(102, 0xFFB66850).addARGB(140, 0xFFDE997E).addARGB(178, 0xFFE5A588).addARGB(216, 0xFFF0B695).addARGB(255, 0xFFFCC9A5).build());
        buildMaterial(ReforgedMaterials.epidote)
                .meleeHarvest()
                .fallbacks("crystal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF4B3D1A).addARGB(102, 0xFF5B4819).addARGB(140, 0xFF795F19).addARGB(178, 0xFF8C7034).addARGB(216, 0xFF9B8364).addARGB(255, 0xFFA48E78).build());
        buildMaterial(ReforgedMaterials.red_beryl)
                .meleeHarvest()
                .fallbacks("crystal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF77152E).addARGB(102, 0xFF911934).addARGB(140, 0xFFF0405B).addARGB(178, 0xFFF1586B).addARGB(216, 0xFFF36E7C).addARGB(255, 0xFFF6828C).build());
        buildMaterial(ReforgedMaterials.ender_bone)
                .meleeHarvest()
                .fallbacks("bone")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF063931).addARGB(102, 0xFF233319).addARGB(140, 0xFF0B4D42).addARGB(178, 0xFF258474).addARGB(216, 0xFF349988).addARGB(255, 0xFF2CCDB1).build());
    }
}
