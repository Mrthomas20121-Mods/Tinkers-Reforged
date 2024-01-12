package mrthomas20121.tinkers_reforged.modifier.wip;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.common.ForgeMod;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierAttribute;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import java.util.UUID;
import java.util.function.BiConsumer;

public class LongRangeModifier extends Modifier {

    private static final UUID attackRange = ModifierAttribute.getUUID("tinkers_reforged.attack_range_buff", EquipmentSlot.MAINHAND);
    private static final UUID reach = ModifierAttribute.getUUID("tinkers_reforged.reach_distance_buff", EquipmentSlot.MAINHAND);

    @Override
    public void addToolStats(ToolRebuildContext context, int level, ModifierStatsBuilder builder) {
        ToolStats.ATTACK_DAMAGE.multiply(builder, 0.8f);
    }

    @Override
    public void addAttributes(IToolStackView tool, int level, EquipmentSlot slot, BiConsumer<Attribute, AttributeModifier> consumer) {
        if(slot.equals(EquipmentSlot.MAINHAND)) {
            consumer.accept(ForgeMod.ATTACK_RANGE.get(), new AttributeModifier(attackRange, "tinkers_reforged.attack_range_buff_mainhand", 0.5D, AttributeModifier.Operation.ADDITION));
            consumer.accept(ForgeMod.REACH_DISTANCE.get(), new AttributeModifier(reach, "tinkers_reforged.reach_distance_buff_mainhand", 0.5D, AttributeModifier.Operation.ADDITION));
        }
    }
}
