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
        addMaterial(ReforgedMaterialIds.aluminum, 1, ORDER_GENERAL, false);
        addMaterial(ReforgedMaterialIds.duralumin, 2, ORDER_GENERAL, false);
        addMaterial(ReforgedMaterialIds.yokel, 2, ORDER_GENERAL, false);
        addMaterial(ReforgedMaterialIds.epidote, 2, ORDER_GENERAL, false);
        addMaterial(ReforgedMaterialIds.hureaulite, 2, ORDER_GENERAL, false);
        addMaterial(ReforgedMaterialIds.red_beryl, 2, ORDER_GENERAL, false);
        addMaterial(ReforgedMaterialIds.ender_bone, 2, ORDER_GENERAL, true);
        addMaterial(ReforgedMaterialIds.blazing_copper, 2, ORDER_NETHER, false);
        addMaterial(ReforgedMaterialIds.electrical_copper, 3, ORDER_NETHER, false);
        addMaterial(ReforgedMaterialIds.wavy, 3, ORDER_NETHER, false);
        addMaterial(ReforgedMaterialIds.galu, 3, ORDER_NETHER, false);
        addMaterial(ReforgedMaterialIds.baolian, 3, ORDER_NETHER, false);
        addMaterial(ReforgedMaterialIds.lavium, 3, ORDER_NETHER, false);
        addMaterial(ReforgedMaterialIds.qivium, 3, ORDER_NETHER, false);
        addMaterial(ReforgedMaterialIds.felsteel, 3, ORDER_NETHER, false);
        addMaterial(ReforgedMaterialIds.crusteel, 3, ORDER_NETHER, false);
        addMaterial(ReforgedMaterialIds.magma_steel, 4, ORDER_NETHER, false);
        addMaterial(ReforgedMaterialIds.gausum, 4, ORDER_END, false);
        addMaterial(ReforgedMaterialIds.chorus_metal, 4, ORDER_END, false);
        addMaterial(ReforgedMaterialIds.kepu, 4, ORDER_END, false);
        addMaterial(ReforgedMaterialIds.durasteel, 4, ORDER_END, false);
        addMaterial(ReforgedMaterialIds.cyber_steel, 4, ORDER_END, false);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Tinkers Reforged Materials";
    }

}
