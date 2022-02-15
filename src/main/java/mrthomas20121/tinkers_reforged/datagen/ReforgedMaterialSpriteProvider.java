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
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF75091E).addARGB(102, 0xFF8E0D29).addARGB(140, 0xFFC94341).addARGB(178, 0xFFDA5B55).addARGB(216, 0xFFF6796F).addARGB(255, 0xFFFF8F84).build());
        buildMaterial(ReforgedMaterials.lavium)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF183310).addARGB(102, 0xFF264A19).addARGB(140, 0xFF5F8943).addARGB(178, 0xFF6A964F).addARGB(216, 0xFF76A45B).addARGB(255, 0xFF81B366).build());
        buildMaterial(ReforgedMaterials.electrical_copper)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF331A0A).addARGB(102, 0xFF482410).addARGB(140, 0xFF956640).addARGB(178, 0xFFAE8253).addARGB(216, 0xFFC79C65).addARGB(255, 0xFFE0B475).build());
        buildMaterial(ReforgedMaterials.duralumin)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF3F4C37).addARGB(102, 0xFF526147).addARGB(140, 0xFF95AC7E).addARGB(178, 0xFFA8C295).addARGB(216, 0xFFBDDAAB).addARGB(255, 0xFFD1F1C1).build());
        buildMaterial(ReforgedMaterials.gausum)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF83DBE9).addARGB(102, 0xFF8EFAFF).addARGB(140, 0xFF305A60).addARGB(178, 0xFF42777F).addARGB(216, 0xFF4F8F99).addARGB(255, 0xFF75BCC6).build());
    }
}
