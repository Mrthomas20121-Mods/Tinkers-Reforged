package mrthomas20121.tinkers_reforged.modifier;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.library.utils.TooltipKey;

import javax.annotation.Nonnull;
import java.util.List;

public class ModifierAdaptating extends Modifier {

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
    public int afterEntityHit(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float damageDealt) {
        ModDataNBT persistantData = tool.getPersistentData();
        LivingEntity target = context.getLivingTarget();
        if(target != null && target.isDeadOrDying() && damageDealt > 0) {
            if(target.getMobType().equals(MobType.UNDEAD)) {
                if(persistantData.contains(KEY, 5)) {
                    persistantData.putFloat(KEY, persistantData.getFloat(KEY)+0.1f);
                }
                else {
                    persistantData.putFloat(KEY, 0.1f);
                }
            }
        }
        return super.afterEntityHit(tool, level, context, damageDealt);
    }



    @Override
    public void addInformation(@Nonnull IToolStackView tool, int level, @Nullable Player player, @Nonnull List<Component> tooltip, @Nonnull TooltipKey tooltipKey, @Nonnull TooltipFlag tooltipFlag) {
        if(tooltipKey == TooltipKey.SHIFT) {
            if(player != null) {
                ModDataNBT persistantData = tool.getPersistentData();
                if(persistantData.contains(KEY, 5)) {
                    float value = persistantData.getFloat(KEY);
                    tooltip.add(new TranslatableComponent("modifier.adapting.bonus", value));
                }
            }
        }
    }
}
