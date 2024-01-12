package mrthomas20121.tinkers_reforged.modifier.wip;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierAttribute;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.UUID;
import java.util.function.BiConsumer;

public class ResistorModifier extends Modifier {

    private static final UUID knockback_resistance = ModifierAttribute.getUUID("tinkers_reforged.knockback_resistance", EquipmentSlot.MAINHAND);

    @Override
    public void addAttributes(IToolStackView tool, int level, EquipmentSlot slot, BiConsumer<Attribute, AttributeModifier> consumer) {
        if(slot.equals(EquipmentSlot.MAINHAND)) {
            consumer.accept(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(knockback_resistance, "tinkers_reforged.knockback_resistance_mainhand", 0.5D, AttributeModifier.Operation.ADDITION));
        }
    }
}
