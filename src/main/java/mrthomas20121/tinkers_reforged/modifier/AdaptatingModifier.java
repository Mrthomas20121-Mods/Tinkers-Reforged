package mrthomas20121.tinkers_reforged.modifier;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.TinkersReforgedConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import javax.annotation.Nonnull;
import java.util.List;

public class AdaptatingModifier extends Modifier {

    private final ResourceLocation KEY = new ResourceLocation(TinkersReforged.MOD_ID, "adapting_mod");

    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        ModDataNBT persistantData = tool.getPersistentData();
        if(persistantData.contains(KEY, 5)) {
            float value = persistantData.getFloat(KEY);
            return damage+value;
        }
        return super.getEntityDamage(tool, level, context, baseDamage, damage);
    }

    @Override
    public void onBreakSpeed(@Nonnull IToolStackView tool, int level, @Nonnull PlayerEvent.BreakSpeed event, @Nonnull Direction sideHit, boolean isEffective, float miningSpeedModifier) {
        ModDataNBT persistantData = tool.getPersistentData();
        if(persistantData.contains(KEY, 5)) {
            float value = persistantData.getFloat(KEY);
            event.setNewSpeed(event.getOriginalSpeed()+value);
        }
    }

    @Override
    public void onRemoved(IToolStackView tool) {
        // remove adapting data
        tool.getPersistentData().remove(KEY);
    }

    @Override
    public int afterEntityHit(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float damageDealt) {
        ModDataNBT persistantData = tool.getPersistentData();
        LivingEntity target = context.getLivingTarget();
        if(target != null && target.isDeadOrDying() && damageDealt > 0) {

            if(target.getMobType().equals(MobType.UNDEAD) || target.getMobType().equals(MobType.ARTHROPOD) || target instanceof Creeper) {
                if(persistantData.contains(KEY, 5)) {
                    if(persistantData.getFloat(KEY) <= TinkersReforgedConfig.COMMON.adaptingModifierCap.get()) {
                        persistantData.putFloat(KEY, persistantData.getFloat(KEY)+0.25f);
                    }
                }
                else {
                    persistantData.putFloat(KEY, 0.25f*level);
                }
            }
        }
        return super.afterEntityHit(tool, level, context, damageDealt);
    }

    @Override
    public void addInformation(@Nonnull IToolStackView tool, int level, @Nullable Player player, @Nonnull List<Component> tooltip, @Nonnull TooltipKey tooltipKey, @Nonnull TooltipFlag tooltipFlag) {
        if(player != null) {
            ModDataNBT persistantData = tool.getPersistentData();
            if(persistantData.contains(KEY, 5)) {
                float value = persistantData.getFloat(KEY);

                // if it's equal to the cap
                if(value==TinkersReforgedConfig.COMMON.adaptingModifierCap.get()) {
                    addDamageTooltip(tool, value, tooltip);
                    addSpeedTooltip(tool, value, tooltip);
                    tooltip.add(new TranslatableComponent("modifier.tinkers_reforged.adapting.cap").withStyle(ChatFormatting.RED));
                }
                else {
                    addDamageTooltip(tool, value, tooltip);
                    addSpeedTooltip(tool, value, tooltip);
                }
            }
            else {
                addDamageTooltip(tool, 0f, tooltip);
                addSpeedTooltip(tool, 0f, tooltip);
            }
        }
    }

    protected void addSpeedTooltip(IToolStackView tool, float amount, List<Component> tooltip) {
        addStatTooltip(tool, ToolStats.MINING_SPEED, TinkerTags.Items.MELEE_OR_UNARMED, amount, tooltip);
    }
}
