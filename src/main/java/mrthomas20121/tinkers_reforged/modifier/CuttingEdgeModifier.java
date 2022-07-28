package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

public class CuttingEdgeModifier extends Modifier {

    public CuttingEdgeModifier() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void livingAttackEvent(LivingAttackEvent event) {
        if(event.getSource() instanceof EntityDamageSource source) {
            // get the attacker from the damage source
            Entity entity = source.getEntity();
            if(entity instanceof LivingEntity) {
                ItemStack stack = ((LivingEntity)entity).getMainHandItem();
                // check if the item is a tinkers tool
                if(ToolStack.isInitialized(stack)) {
                    IToolStackView tool = ToolStack.from(stack);
                    if(tool.getModifierLevel(this.getId()) >= 3) {
                        source.setMagic();
                    }
                }
            }
        }
    }
}
