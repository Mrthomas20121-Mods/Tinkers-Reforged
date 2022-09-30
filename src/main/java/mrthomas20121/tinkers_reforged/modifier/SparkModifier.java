package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

public class SparkModifier extends Modifier {

    public SparkModifier() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void critEvent(CriticalHitEvent event) {
        if(event.getEntityLiving() instanceof Player player) {
            ItemStack mainHandItem = player.getMainHandItem();
            ToolStack stack = ToolStack.from(mainHandItem);
            if(stack.getModifierLevel(this) < 0) {
                event.setDamageModifier(5f);
            }
        }
    }
}
