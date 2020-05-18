package com.mrthomas20121.libs;

import c4.conarm.lib.materials.ArmorMaterials;
import c4.conarm.lib.materials.CoreMaterialStats;
import c4.conarm.lib.materials.PlatesMaterialStats;
import c4.conarm.lib.materials.TrimMaterialStats;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class ArmorRegistryLib extends RegistryLib {
    private CoreMaterialStats coreStats;
    private PlatesMaterialStats platesStats;
    private TrimMaterialStats trimStats;

    public ArmorRegistryLib(Material mat) {
        super(mat);
    }

    public void setCoreStats(float durability, float defence) {
        this.coreStats = new CoreMaterialStats(durability, defence);
    }

    public void setPlatesStats(float modifier, float durability, float toughness) {
        this.platesStats = new PlatesMaterialStats(modifier, durability, toughness);
    }

    public void setTrimStats(float extradurability) {
        this.trimStats = new TrimMaterialStats(extradurability);
    }

    @Override
    public void addMaterialTrait(AbstractTrait trait, String dependency) {
        ArmorMaterials.addArmorTrait(this.getMat(), trait, dependency);
    }
    @Override
    public void addMaterialTrait(AbstractTrait trait) {
        ArmorMaterials.addArmorTrait(this.getMat(), trait);
    }
    public void registerArmor() {
        TinkerRegistry.addMaterialStats(this.getMat(), this.coreStats, this.platesStats, this.trimStats);
    }

}
