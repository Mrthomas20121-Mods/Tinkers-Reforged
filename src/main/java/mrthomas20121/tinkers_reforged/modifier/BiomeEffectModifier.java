package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.ToolStatsModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.display.TooltipModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.mining.BreakSpeedModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import javax.annotation.Nonnull;
import java.util.List;

// bring back Aridiculous from 1.12
// Increase mining speed and damage in hot/dry area, decreases a bit in wet area
public class BiomeEffectModifier extends Modifier implements BreakSpeedModifierHook, MeleeDamageModifierHook, TooltipModifierHook {

    public BiomeEffectModifier() {
        this.registerHooks(new ModifierHookMap.Builder()
                .addHook(this, TinkerHooks.TOOLTIP)
                .addHook(this, TinkerHooks.BREAK_SPEED)
                .addHook(TinkerHooks.MELEE_DAMAGE)
        );
    }

    @Override
    public void onBreakSpeed(IToolStackView tool, ModifierEntry modifier, PlayerEvent.BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {
        Level world = event.getEntityLiving().level;
        float coeff = calcArid(world, event.getPos());
        event.setNewSpeed(event.getNewSpeed()+event.getOriginalSpeed()*coeff);
    }

    @Override
    public float getMeleeDamage(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float baseDamage, float damage) {
        float extraDamage = 2f * calcArid(context.getAttacker().level, context.getAttacker().blockPosition());
        return damage+extraDamage;
    }

    private float calcArid(Level level, BlockPos pos) {
        Biome biome = level.getBiome(pos).value();
        float rain = level.isRaining() ? biome.getDownfall() / 2 : 0f;
        return (float)(Math.pow(1.25, 3d*(0.5f+biome.getBaseTemperature() - biome.getDownfall()) - 1.25d)) - rain;
    }



    @Override
    public void addTooltip(IToolStackView tool, ModifierEntry modifier, @Nullable Player player, List<Component> tooltip, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
        if(player != null) {
            float calc = calcArid(player.level, player.blockPosition());
            float baseStat = tool.getStats().get(ToolStats.MINING_SPEED)*calc;
            float extraDmg = calc*2;

            addMiningSpeedToolTip(tool, (float) Math.floor(baseStat), tooltip);
            TooltipModifierHook.addDamageBoost(tool, this, (float)Math.floor(extraDmg), tooltip);
        }
    }

    public void addMiningSpeedToolTip(IToolStackView tool, float amount, List<Component> tooltip) {
        TooltipModifierHook.addStatBoost(tool, this, ToolStats.MINING_SPEED, TinkerTags.Items.MELEE_OR_UNARMED, amount, tooltip);
    }
}
