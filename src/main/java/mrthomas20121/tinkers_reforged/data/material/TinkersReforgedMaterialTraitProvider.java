package mrthomas20121.tinkers_reforged.data.material;

import mrthomas20121.tinkers_reforged.api.TinkersReforgedModifierIds;
import mrthomas20121.tinkers_reforged.api.data.Metal;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.library.materials.stats.MaterialStatsId;

import static slimeknights.tconstruct.library.materials.MaterialRegistry.AMMO;
import static slimeknights.tconstruct.library.materials.MaterialRegistry.ARMOR;
import static slimeknights.tconstruct.library.materials.MaterialRegistry.MELEE_HARVEST;
import static slimeknights.tconstruct.library.materials.MaterialRegistry.RANGED;

public class TinkersReforgedMaterialTraitProvider extends AbstractMaterialTraitDataProvider {

    public TinkersReforgedMaterialTraitProvider(PackOutput packOutput, AbstractMaterialDataProvider materials) {
        super(packOutput, materials);
    }

    @Override
    protected void addMaterialTraits() {
        material(Metal.YTTRIUM.asMaterial()).addTraits(MELEE_HARVEST, TinkersReforgedModifierIds.MINING_FRENZY);
        material(Metal.THALLIUM.asMaterial()).addTraits(MELEE_HARVEST, TinkersReforgedModifierIds.IONIZE);
    }

    @Override
    public String getName() {
        return "Tinkers Reforged Material Trait Data Provider";
    }
}
