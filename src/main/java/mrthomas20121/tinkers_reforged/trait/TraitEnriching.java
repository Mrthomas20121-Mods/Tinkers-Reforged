package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitEnriching extends AbstractTrait {

    public TraitEnriching() {
        super("ref_enriching", 0x0);
    }

    @Override
    public void onPlayerHurt(ItemStack tool, EntityPlayer player, EntityLivingBase attacker, LivingHurtEvent event) {
        if(player.getHeldItemMainhand().equals(tool)) {
            player.heal(1.5f);
        }
    }
}
