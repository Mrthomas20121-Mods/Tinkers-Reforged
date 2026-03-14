package mrthomas20121.tinkers_reforged.data.material;

import mrthomas20121.tinkers_reforged.api.data.Metal;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.client.data.spritetransformer.GreyToColorMapping;

public class TinkersReforgedMaterialSpriteProvider extends AbstractMaterialSpriteProvider {

    @Override
    public String getName() {
        return "Tinkers Reforged Material Sprite Provider";
    }

    @Override
    protected void addAllMaterials() {

        buildMaterial(Metal.GRAPHITE.asMaterial())
                .meleeHarvest().armor().ranged()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0XFF1C1C20).addARGB(102, 0XFF303038).addARGB(140, 0XFF41424C).addARGB(178, 0XFF50525E).addARGB(216, 0XFF646774).build());

        buildMaterial(Metal.YTTRIUM.asMaterial())
                .meleeHarvest().armor().ranged()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0XFF451318).addARGB(102, 0XFF8E2429).addARGB(140, 0XFFAC2C32).addARGB(178, 0XFFDA5257).addARGB(216, 0XFFFF6B70).build());

        buildMaterial(Metal.BARIUM.asMaterial())
                .meleeHarvest().armor().ranged()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0XFF2A1D5B).addARGB(102, 0XFF51428F).addARGB(140, 0XFF6E60AA).addARGB(178, 0XFF8F82CE).addARGB(216, 0XFFAEA0F0).build());

        buildMaterial(Metal.ASTATINE.asMaterial())
                .meleeHarvest().armor().ranged()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0XFFE99475).addARGB(102, 0XFFEB8056).addARGB(140, 0XFFED713B).addARGB(178, 0XFFF7DEC9).addARGB(216, 0XFFFFF3DE).build());

        buildMaterial(Metal.TELLURIUM.asMaterial())
                .meleeHarvest().armor().ranged()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0XFF522728).addARGB(102, 0XFF8E413D).addARGB(140, 0XFFA6514E).addARGB(178, 0XFFCC7070).addARGB(216, 0XFFED8585).build());

        buildMaterial(Metal.GERMANIUM.asMaterial())
                .meleeHarvest().armor().ranged()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0XFF4C183C).addARGB(102, 0XFF9A297A).addARGB(140, 0XFFAD4E8E).addARGB(178, 0XFFC16EA6).addARGB(216, 0XFFD581B7).build());

        buildMaterial(Metal.BERKELIUM.asMaterial())
                .meleeHarvest().armor().ranged()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0XFF40541E).addARGB(102, 0XFF778735).addARGB(140, 0XFF9DA957).addARGB(178, 0XFFC5CC78).addARGB(216, 0XFFDFE68A).build());

        buildMaterial(Metal.ACTINIUM.asMaterial())
                .meleeHarvest().armor().ranged()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0XFF403E2F).addARGB(102, 0XFF66614F).addARGB(140, 0XFF857F6C).addARGB(178, 0XFFBCB4A2).addARGB(216, 0XFFDFD4BF).build());

        buildMaterial(Metal.THALLIUM.asMaterial())
                .meleeHarvest().armor().ranged()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0XFF28373C).addARGB(102, 0XFF54666C).addARGB(140, 0XFF6C7F85).addARGB(178, 0XFFA2B6BC).addARGB(216, 0XFFBFD7DF).build());
    }
}
