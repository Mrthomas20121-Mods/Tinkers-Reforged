package mrthomas20121.tinkers_reforged.datagen.tcon;

import mrthomas20121.tinkers_reforged.api.material.EnumMaterial;
import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;

import javax.annotation.Nonnull;

public class ReforgedMaterials extends AbstractMaterialDataProvider {

    public ReforgedMaterials(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void addMaterials() {
        //addMaterial(ReforgedMaterialIds.aluminum, 1, ORDER_GENERAL, false);

        for(EnumMaterial material: EnumMaterial.values()) {
            addMaterial(material.id, material.tier, material.order, material.craftable);
        }
    }

    @Nonnull
    @Override
    public String getName() {
        return "Tinkers Reforged Materials";
    }

}
