package mrthomas20121.tinkers_reforged.data.material;

import mrthomas20121.tinkers_reforged.data.TinkersReforgedModifierIds;
import mrthomas20121.tinkers_reforged.api.data.Metal;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.tools.TinkerModifiers;

import static slimeknights.tconstruct.library.materials.MaterialRegistry.ARMOR;
import static slimeknights.tconstruct.library.materials.MaterialRegistry.MELEE_HARVEST;

public class TinkersReforgedMaterialTraitProvider extends AbstractMaterialTraitDataProvider {

    public TinkersReforgedMaterialTraitProvider(PackOutput packOutput, AbstractMaterialDataProvider materials) {
        super(packOutput, materials);
    }

    @Override
    protected void addMaterialTraits() {
        material(Metal.SLIMEBRONZE.asMaterial())
                .addTraits(MELEE_HARVEST, TinkersReforgedModifierIds.OVERFRACTURE, TinkerModifiers.overslime.getId());
        material(Metal.GRAPHITE.asMaterial())
                .addTraits(MELEE_HARVEST, TinkersReforgedModifierIds.SURFACE_RESOURCES)
                .addTraits(ARMOR, TinkersReforgedModifierIds.LAND_PROTECTION);
        material(Metal.YTTRIUM.asMaterial())
                .addTraits(MELEE_HARVEST, TinkersReforgedModifierIds.GROWTH)
                .addTraits(ARMOR, TinkersReforgedModifierIds.SAFEGUARD);
        material(Metal.ASTATINE.asMaterial())
                .addTraits(MELEE_HARVEST, TinkersReforgedModifierIds.SUBAQUATIC)
                .addTraits(ARMOR, TinkersReforgedModifierIds.AGILITY);
        material(Metal.BARIUM.asMaterial())
                .addDefaultTraits(TinkersReforgedModifierIds.FRAIL);
        material(Metal.TELLURIUM.asMaterial())
                .addTraits(MELEE_HARVEST, TinkersReforgedModifierIds.TRIAD)
                .addTraits(ARMOR, TinkersReforgedModifierIds.FRICTION);
        material(Metal.ACTINIUM.asMaterial())
                .addTraits(MELEE_HARVEST, TinkersReforgedModifierIds.FLAMING)
                .addTraits(ARMOR, TinkersReforgedModifierIds.ROAST);
        material(Metal.THALLIUM.asMaterial())
                .addDefaultTraits(TinkersReforgedModifierIds.IONIZE)
                .addTraits(ARMOR, TinkersReforgedModifierIds.LUNGFUL);
        material(Metal.BERKELIUM.asMaterial())
                .addDefaultTraits(TinkersReforgedModifierIds.CLOSE_COMBAT)
                .addTraits(ARMOR, TinkersReforgedModifierIds.HEALTH_UP);
        material(Metal.GERMANIUM.asMaterial())
                .addDefaultTraits(TinkersReforgedModifierIds.GEOGRAPHICAL)
                .addTraits(ARMOR, TinkersReforgedModifierIds.DECAY_IMMUNITY);
    }

    @Override
    public String getName() {
        return "Tinkers Reforged Material Trait Data Provider";
    }
}
