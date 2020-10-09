package mrthomas20121.tinkers_reforged.trait;

import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import vazkii.botania.api.mana.ManaItemHandler;

public class TraitManaBoost extends AbstractTrait {
    public TraitManaBoost()
    {
        super("ref_mana_boost", 0x0);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {

        int tempDamage = 0;

        if(player instanceof EntityPlayer)
        {
            EntityPlayer entityPlayer = (EntityPlayer)player;
            IBaublesItemHandler baubleInv = BaublesApi.getBaublesHandler(entityPlayer);;
            NonNullList<ItemStack> manaStacks = entityPlayer.inventory.mainInventory;
            for(ItemStack manaStack: manaStacks)
            {
                if(tool.isItemDamaged())
                {
                    if(ManaItemHandler.requestManaExact(manaStack, entityPlayer, tool.getMaxDamage(), true)) tempDamage = 15;
                }
            }
            int size = baubleInv.getSlots();
            for(int slot = 0; slot < size; slot++)
            {
                ItemStack stackInSlot = baubleInv.getStackInSlot(slot);
                if(!stackInSlot.isEmpty())
                {
                    if(tool.isItemDamaged() && tempDamage == 0)
                    {
                        if(ManaItemHandler.requestManaExact(stackInSlot, entityPlayer, tool.getMaxDamage(), true)) tempDamage = 15;
                    }
                }

            }
        }
        if(tempDamage > 0) return newDamage+tempDamage;
        return newDamage;
    }
}
