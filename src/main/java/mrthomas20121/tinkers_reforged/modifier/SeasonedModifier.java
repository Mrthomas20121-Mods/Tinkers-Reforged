package mrthomas20121.tinkers_reforged.modifier;

import mrthomas20121.tinkers_reforged.util.EntityLootModifierHook;
import mrthomas20121.tinkers_reforged.util.TinkersReforgedHooks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.registries.ForgeRegistries;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.Collection;

public class SeasonedModifier extends Modifier implements EntityLootModifierHook {

    private static final ResourceLocation netherStar = new ResourceLocation("minecraft:nether_star");

    public SeasonedModifier() {
        registerHooks(new ModifierHookMap.Builder().addHook(this, TinkersReforgedHooks.ENTITY_LOOT_MODIFIER));
    }

    @Override
    public void onLootDrop(IToolStackView tool, LivingEntity attacker, Collection<ItemEntity> items, int looting, DamageSource source, LivingEntity entity, boolean isRecentlyHit, LivingDropsEvent event) {
        items.forEach(itemEntity -> {
            ResourceLocation location = ForgeRegistries.ITEMS.getKey(itemEntity.getItem().getItem());
            if(location != null && location.equals(netherStar)) {
                return;
            }
            event.getDrops().add(itemEntity);
        });
    }

    @Override
    public void onExperienceDrop(IToolStackView tool, Player player, LivingExperienceDropEvent event) {
        event.setDroppedExperience(0);
    }
}
