package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitGodGift extends AbstractTrait {

    public TraitGodGift() {
        super("ref_god_gift",0x0);
    }

    @Override
    public int onToolDamage(ItemStack tool, int damage, int newDamage, EntityLivingBase entity) {
        ToolHelper.healTool(tool, (int)(newDamage*0.05f), entity);
        return super.onToolDamage(tool, damage, newDamage, entity);
    }

    @Override
    public void onPlayerHurt(ItemStack tool, EntityPlayer player, EntityLivingBase attacker, LivingHurtEvent event) {
        attacker.attackEntityFrom(DamageSource.causeThornsDamage(attacker).setDamageBypassesArmor(), 2*(player.getMaxHealth()*0.05f));
    }
}
