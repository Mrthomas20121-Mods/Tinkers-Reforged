package mrthomas20121.tinkers_reforged.modifier;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedModifiers;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierId;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

@Mod.EventBusSubscriber(modid = TinkersReforged.MOD_ID)
public class SparkModifier extends Modifier {

    @SubscribeEvent
    public static void critEvent(CriticalHitEvent event) {
        if(event.getEntityLiving() instanceof Player player) {
            ItemStack mainHandItem = player.getMainHandItem();
            if(ToolStack.isInitialized(mainHandItem)) {
                ToolStack stack = ToolStack.from(mainHandItem);
                if(stack.getModifierLevel(TinkersReforgedModifiers.blazing_copper_spark.get()) < 0) {
                    event.setDamageModifier(event.getDamageModifier()+5f);
                }
            }
        }
    }
}