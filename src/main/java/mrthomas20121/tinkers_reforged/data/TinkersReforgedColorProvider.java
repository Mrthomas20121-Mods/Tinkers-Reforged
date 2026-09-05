package mrthomas20121.tinkers_reforged.data;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.data.Metal;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.ModifierId;

public class TinkersReforgedColorProvider extends MantleColorGenerator {

    public TinkersReforgedColorProvider(PackOutput packOutput) {
        super(packOutput, TinkersReforged.MOD_ID);
    }

    @Override
    public void addColors() {
        materialAndModifier(0x94A47B, Metal.SLIMEBRONZE, TinkersReforgedModifierIds.OVERFRACTURE);
        materialAndModifier(0x1c1c20, Metal.GRAPHITE, TinkersReforgedModifierIds.CLEAVAGE, TinkersReforgedModifierIds.HEAT_PROOF);
        materialAndModifier(0xAC2C32, Metal.YTTRIUM, TinkersReforgedModifierIds.CHASM);
        materialAndModifier(0xe99475, Metal.ASTATINE, TinkersReforgedModifierIds.SUBAQUATIC, TinkersReforgedModifierIds.AGILITY);
        materialAndModifier(0x2a1d5b, Metal.BARIUM, TinkersReforgedModifierIds.FRAIL);
        materialAndModifier(0x522728, Metal.TELLURIUM, TinkersReforgedModifierIds.TRIAD, TinkersReforgedModifierIds.FRICTION);
        materialAndModifier(0x403e2f, Metal.ACTINIUM, TinkersReforgedModifierIds.FLAMING, TinkersReforgedModifierIds.ROAST);
        materialAndModifier(0x28373c, Metal.THALLIUM, TinkersReforgedModifierIds.IONIZE, TinkersReforgedModifierIds.LUNGFUL);
        materialAndModifier(0x4c183c, Metal.GERMANIUM, TinkersReforgedModifierIds.GEOGRAPHICAL, TinkersReforgedModifierIds.DECAY_IMMUNITY);
        materialAndModifier(0x40541e, Metal.BERKELIUM, TinkersReforgedModifierIds.CLOSE_COMBAT, TinkersReforgedModifierIds.HEALTH_UP);
    }

    private void materialAndModifier(int color, Metal metal, ModifierId... modifiers) {
        materialAndModifier(color, metal.asMaterial(), modifiers);
    }

    private void materialAndModifier(int color, MaterialId materialId, ModifierId... modifiers) {
        addMaterial(materialId, color);

        for(ModifierId id: modifiers) {
            addModifier(id, color);
        }
    }
}
