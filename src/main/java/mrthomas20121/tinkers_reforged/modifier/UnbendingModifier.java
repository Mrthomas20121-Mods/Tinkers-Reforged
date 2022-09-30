package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

public class UnbendingModifier extends Modifier {

    public UnbendingModifier() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void attackEvent(LivingDamageEvent event) {

        // check if the source entity is the player
        if(event.getSource().getEntity() instanceof Player player) {
            ItemStack item = player.getMainHandItem();
            ToolStack toolStack = ToolStack.from(item);

            // check if the toolstack has this modifier on it
            if(toolStack.getModifierLevel(this) >= 1) {
                if(event.getAmount() <= 5) {
                    event.getSource().bypassArmor();
                }
            }
        }
    }
}
