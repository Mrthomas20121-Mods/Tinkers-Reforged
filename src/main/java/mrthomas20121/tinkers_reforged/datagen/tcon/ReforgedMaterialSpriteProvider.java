package mrthomas20121.tinkers_reforged.datagen.tcon;

import mrthomas20121.tinkers_reforged.api.material.EnumMaterial;
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

        for(EnumMaterial material: EnumMaterial.values()) {
            MaterialSpriteInfoBuilder builder = buildMaterial(material.id);
            if(material.equals(EnumMaterial.FEROBOLT)) {
                builder.ranged().fallbacks(material.fallback);
            }
            else {
                builder.ranged().meleeHarvest();
            }
            builder.fallbacks(material.fallback).colorMapper(material.palette.colorMapping);
        }
    }
}
