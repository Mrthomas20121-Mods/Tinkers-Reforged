package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.behavior.AttributesModifierHook;
import slimeknights.tconstruct.library.modifiers.modules.behavior.AttributeModule;
import slimeknights.tconstruct.library.modifiers.util.ModifierAttribute;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.UUID;
import java.util.function.BiConsumer;

public class ResistorModifier extends Modifier implements AttributesModifierHook {

    private static final UUID knockback_resistance = AttributeModule.getUUID("tinkers_reforged.knockback_resistance", EquipmentSlot.MAINHAND);

    public ResistorModifier() {
        this.registerHooks(new ModifierHookMap.Builder().addHook(this, TinkerHooks.ATTRIBUTES));
    }

    @Override
    public void addAttributes(IToolStackView tool, ModifierEntry modifier, EquipmentSlot slot, BiConsumer<Attribute, AttributeModifier> consumer) {
        if(slot.equals(EquipmentSlot.MAINHAND)) {
            consumer.accept(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(knockback_resistance, "tinkers_reforged.knockback_resistance_mainhand", 0.5D, AttributeModifier.Operation.ADDITION));
        }
    }
}
