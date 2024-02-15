package mrthomas20121.tinkers_reforged.datagen.tcon;

import mrthomas20121.tinkers_reforged.api.material.EnumMaterial;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedModifiers;
import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;

import javax.annotation.Nonnull;

public class ReforgedTraits extends AbstractMaterialTraitDataProvider {

    public ReforgedTraits(DataGenerator gen, AbstractMaterialDataProvider materials) {
        super(gen, materials);
    }

    @Override
    protected void addMaterialTraits() {

        for(EnumMaterial material: EnumMaterial.values()) {
            this.addDefaultTraits(material.id, material.mod);
        }
    }

    @Nonnull
    @Override
    public String getName() {
        return "Tinkers Reforged Material Traits";
    }
}
