package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;

public class SwiftEyeModifier extends Modifier {

    public SwiftEyeModifier() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void lootEvent(LivingDropsEvent event) {
        if(event.getEntity() instanceof EnderMan enderMan) {
            if(event.getSource().getEntity() instanceof Player player) {
                if(ModifierUtil.getModifierLevel(player.getMainHandItem(), this.getId()) > 0) {
                    event.getDrops().clear();
                    event.getDrops().add(new ItemEntity(enderMan.level, enderMan.getBlockX(), enderMan.getBlockY(), enderMan.getBlockZ(), new ItemStack(Items.ENDER_EYE)));
                }
            }
        }
    }
}
