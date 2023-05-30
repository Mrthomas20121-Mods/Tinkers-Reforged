package mrthomas20121.tinkers_reforged.datagen.tcon;

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

        addDefaultTraits(ReforgedMaterialIds.aluminum, TinkersReforgedModifiers.aluminum_rotective_mantle);

        addDefaultTraits(ReforgedMaterialIds.blazing_copper, TinkersReforgedModifiers.blazing_copper_spark);

        addDefaultTraits(ReforgedMaterialIds.qivium, TinkersReforgedModifiers.qivium_anti_armor);

        addDefaultTraits(ReforgedMaterialIds.lavium, TinkersReforgedModifiers.lavium_aridzone);

        addDefaultTraits(ReforgedMaterialIds.duralumin, TinkersReforgedModifiers.duralumin_ultra_durable);

        addDefaultTraits(ReforgedMaterialIds.electrical_copper, TinkersReforgedModifiers.electrical_copper_electrostatic);

        addDefaultTraits(ReforgedMaterialIds.gausum, TinkersReforgedModifiers.gausum_titanic_damage);

        addDefaultTraits(ReforgedMaterialIds.felsteel, TinkersReforgedModifiers.felsteel_fel_debris);

        addDefaultTraits(ReforgedMaterialIds.chorus_metal, TinkersReforgedModifiers.chorus_metal_requiem);

        addDefaultTraits(ReforgedMaterialIds.kepu, TinkersReforgedModifiers.ender_upgrade);

        addDefaultTraits(ReforgedMaterialIds.durasteel, TinkersReforgedModifiers.durasteel_adapting);

        addDefaultTraits(ReforgedMaterialIds.wavy, TinkersReforgedModifiers.spore_shot);

        addDefaultTraits(ReforgedMaterialIds.crusteel, TinkersReforgedModifiers.giant_cells);

        addDefaultTraits(ReforgedMaterialIds.yokel, TinkersReforgedModifiers.terra);

        addDefaultTraits(ReforgedMaterialIds.baolian, TinkersReforgedModifiers.rare_earth);

        addDefaultTraits(ReforgedMaterialIds.epidote, TinkersReforgedModifiers.water_power);

        addDefaultTraits(ReforgedMaterialIds.galu, TinkersReforgedModifiers.effective_boost);

        addDefaultTraits(ReforgedMaterialIds.hureaulite, TinkersReforgedModifiers.wet_soil);

        addDefaultTraits(ReforgedMaterialIds.red_beryl, TinkersReforgedModifiers.crystallized_punch);

        addDefaultTraits(ReforgedMaterialIds.magma_steel, TinkersReforgedModifiers.magma_steel_unbending);

        addDefaultTraits(ReforgedMaterialIds.cyber_steel, TinkersReforgedModifiers.cyber_steel_swift_eye);

        addDefaultTraits(ReforgedMaterialIds.ender_bone, TinkersReforgedModifiers.collapsed);

        addDefaultTraits(ReforgedMaterialIds.gelot, TinkersReforgedModifiers.tenacity);

        addDefaultTraits(ReforgedMaterialIds.piroot, TinkersReforgedModifiers.half_powered_fists);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Tinkers Reforged Material Traits";
    }
}
