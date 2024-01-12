package mrthomas20121.tinkers_reforged.util;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.Collection;
import java.util.function.Function;

public interface EntityLootModifierHook {

    EntityLootModifierHook DEFAULT = new EntityLootModifierHook() {
        @Override
        public void onLootDrop(IToolStackView tool, LivingEntity attacker, Collection<ItemEntity> items, int looting, DamageSource source, LivingEntity entity, boolean isRecentlyHit, LivingDropsEvent event) {

        }

        @Override
        public void onExperienceDrop(IToolStackView tool, Player player, LivingExperienceDropEvent event) {

        }
    };

    Function<Collection<EntityLootModifierHook>, EntityLootModifierHook> SUM_MERGER = SumMerger::new;

    void onLootDrop(IToolStackView tool, LivingEntity attacker, Collection<ItemEntity> items, int looting, DamageSource source, LivingEntity entity, boolean isRecentlyHit, LivingDropsEvent event);

    void onExperienceDrop(IToolStackView tool, Player player, LivingExperienceDropEvent event);



    /** Constructor for a merger that sums all children */
    record SumMerger(Collection<EntityLootModifierHook> modules) implements EntityLootModifierHook {
        @Override
        public void onLootDrop(IToolStackView tool, LivingEntity attacker, Collection<ItemEntity> items, int looting, DamageSource source, LivingEntity entity, boolean isRecentlyHit, LivingDropsEvent event) {
            modules.forEach(hook -> hook.onLootDrop(tool, attacker, items, looting, source, entity, isRecentlyHit, event));
        }

        @Override
        public void onExperienceDrop(IToolStackView tool, Player player, LivingExperienceDropEvent event) {
            modules.forEach(hook -> hook.onExperienceDrop(tool, player, event));
        }
    }
}
