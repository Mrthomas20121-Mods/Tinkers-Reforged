package mrthomas20121.tinkers_reforged.datagen.tcon;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;

import javax.annotation.Nonnull;

public class ReforgedMaterials extends AbstractMaterialDataProvider {

    public ReforgedMaterials(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void addMaterials() {
        addMaterial(ReforgedMaterialIds.duralumin, 3, ORDER_HARVEST, false);
        addMaterial(ReforgedMaterialIds.electrical_copper, 3, ORDER_GENERAL, false);
        addMaterial(ReforgedMaterialIds.lavium, 4, ORDER_HARVEST, false);
        addMaterial(ReforgedMaterialIds.qivium, 4, ORDER_WEAPON, false);
        addMaterial(ReforgedMaterialIds.gausum, 4, ORDER_HARVEST, false);
        addMaterial(ReforgedMaterialIds.felsteel, 4, ORDER_HARVEST, false);
        addMaterial(ReforgedMaterialIds.chorus_metal, 4, ORDER_HARVEST, false);
        addMaterial(ReforgedMaterialIds.kepu, 4, ORDER_HARVEST, false);
        addMaterial(ReforgedMaterialIds.durasteel, 4, ORDER_SPECIAL, false);
        addMaterial(ReforgedMaterialIds.crusteel, 4, ORDER_HARVEST, false);
        addMaterial(ReforgedMaterialIds.wavy, 4, ORDER_SPECIAL, false);
        addMaterial(ReforgedMaterialIds.yokel, 4, ORDER_WEAPON, false);
        addMaterial(ReforgedMaterialIds.baolian, 3, ORDER_HARVEST, false);
        addMaterial(ReforgedMaterialIds.galu, 3, ORDER_HARVEST, false);
        addMaterial(ReforgedMaterialIds.epidote, 2, ORDER_GENERAL, false);
        addMaterial(ReforgedMaterialIds.hureaulite, 2, ORDER_GENERAL, false);
        addMaterial(ReforgedMaterialIds.red_beryl, 2, ORDER_GENERAL, false);
        addMaterial(ReforgedMaterialIds.ender_bone, 2, ORDER_SPECIAL, true);
        addMaterial(ReforgedMaterialIds.blazing_copper, 2, ORDER_SPECIAL, false);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Tinkers Reforged Materials";
    }

}
