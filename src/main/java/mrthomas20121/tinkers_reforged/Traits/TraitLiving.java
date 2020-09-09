package mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitLiving extends AbstractTrait {
    public TraitLiving()
    {
        super("ref_living", 0x0);
    }

    @Override
    public void onBlock(ItemStack tool, EntityPlayer player, LivingHurtEvent event) {
        if(player.getHealth() != player.getMaxHealth()) player.heal(2);
    }
}
