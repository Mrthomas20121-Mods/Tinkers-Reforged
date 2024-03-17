package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.common.ForgeMod;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.behavior.AttributesModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.build.ToolStatsModifierHook;
import slimeknights.tconstruct.library.modifiers.modules.behavior.AttributeModule;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import java.util.UUID;
import java.util.function.BiConsumer;

public class LongRangeModifier extends Modifier implements ToolStatsModifierHook, AttributesModifierHook {

    private static final UUID attackRange = AttributeModule.getUUID("tinkers_reforged.attack_range_buff", EquipmentSlot.MAINHAND);
    private static final UUID reach = AttributeModule.getUUID("tinkers_reforged.reach_distance_buff", EquipmentSlot.MAINHAND);

    public LongRangeModifier() {
        this.registerHooks(ModifierHookMap.builder().addHook(this, TinkerHooks.TOOL_STATS).addHook(this, TinkerHooks.ATTRIBUTES));
    }

    @Override
    public void addAttributes(IToolStackView tool, ModifierEntry modifier, EquipmentSlot slot, BiConsumer<Attribute, AttributeModifier> consumer) {
        if(slot.equals(EquipmentSlot.MAINHAND)) {
            consumer.accept(ForgeMod.ATTACK_RANGE.get(), new AttributeModifier(attackRange, "tinkers_reforged.attack_range_buff_mainhand", 0.5D, AttributeModifier.Operation.ADDITION));
            consumer.accept(ForgeMod.REACH_DISTANCE.get(), new AttributeModifier(reach, "tinkers_reforged.reach_distance_buff_mainhand", 0.5D, AttributeModifier.Operation.ADDITION));
        }
    }

    @Override
    public void addToolStats(ToolRebuildContext context, ModifierEntry modifier, ModifierStatsBuilder builder) {
        ToolStats.ATTACK_DAMAGE.multiply(builder, 0.8f);
    }
}
