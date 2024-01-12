package mrthomas20121.tinkers_reforged.modifier.wip;

import mrthomas20121.tinkers_reforged.util.EntityLootModifierHook;
import mrthomas20121.tinkers_reforged.util.TinkersReforgedHooks;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.Collection;

public class RuptureModifier extends Modifier implements EntityLootModifierHook {

    public RuptureModifier() {
        registerHooks(new ModifierHookMap.Builder().addHook(this, TinkersReforgedHooks.ENTITY_LOOT_MODIFIER));
    }

    @Override
    public void onLootDrop(IToolStackView tool, LivingEntity attacker, Collection<ItemEntity> items, int looting, DamageSource source, LivingEntity entity, boolean isRecentlyHit, LivingDropsEvent event) {
        if(attacker instanceof Player player) {
            items.forEach(itemEntity -> {
                if(player.getInventory().add(itemEntity.getItem())) {
                    event.getDrops().remove(itemEntity);
                }
            });
        }
    }

    @Override
    public void onExperienceDrop(IToolStackView tool, Player player, LivingExperienceDropEvent event) {
        event.setDroppedExperience(0);
    }
}
