package mrthomas20121.tinkers_reforged;

import mrthomas20121.tinkers_reforged.util.TinkersReforgedHooks;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.item.IModifiable;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

import java.util.Collection;

@Mod.EventBusSubscriber(modid = TinkersReforged.MOD_ID)
public class CommonEvents {

    @SubscribeEvent
    public static void lootEvent(LivingDropsEvent event) {
        Collection<ItemEntity> drops = event.getDrops();
        int looting = event.getLootingLevel();
        DamageSource source = event.getSource();
        LivingEntity entity = event.getEntity();
        boolean isRecentlyHit = event.isRecentlyHit();

        if(source.getDirectEntity() instanceof LivingEntity attacker) {
            ItemStack stack = attacker.getMainHandItem();
            if (stack.is(TinkerTags.Items.MODIFIABLE)) {
                IToolStackView toolstack = ToolStack.from(stack);
                toolstack.getDefinitionData().getModule(TinkersReforgedHooks.ENTITY_LOOT_MODIFIER).onLootDrop(toolstack, attacker, drops, looting, source, entity, isRecentlyHit, event);
            }
        }
    }

    @SubscribeEvent
    public static void expDropEvent(LivingExperienceDropEvent event) {
        Player player = event.getAttackingPlayer();
        if(player != null) {
            ItemStack stack = player.getMainHandItem();
            if (stack.is(TinkerTags.Items.MODIFIABLE)) {
                IToolStackView toolstack = ToolStack.from(stack);
                toolstack.getDefinitionData().getModule(TinkersReforgedHooks.ENTITY_LOOT_MODIFIER).onExperienceDrop(toolstack, player, event);
            }
        }
    }
}
