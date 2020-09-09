package mrthomas20121.tinkers_reforged.Traits;

import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;
import vazkii.botania.api.mana.ManaItemHandler;

import java.util.List;

public class TraitManaInfusion extends AbstractTrait {
    public TraitManaInfusion()
    {
        super("ref_mana_infusion", 0x0);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if(isSelected)
        {
            if(entity instanceof EntityPlayer)
            {
                EntityPlayer player = (EntityPlayer)entity;
                IBaublesItemHandler baubleInv = BaublesApi.getBaublesHandler(player);;
                NonNullList<ItemStack> manaStacks = player.inventory.mainInventory;
                for(ItemStack manaStack: manaStacks)
                {
                    if(tool.isItemDamaged())
                    {
                        if(ManaItemHandler.requestManaExact(manaStack, player, 100, true)) ToolHelper.repairTool(tool, 10);
                    }
                }
                int size = baubleInv.getSlots();
                for(int slot = 0; slot < size; slot++)
                {
                    ItemStack stackInSlot = baubleInv.getStackInSlot(slot);
                    if(!stackInSlot.isEmpty())
                    {
                        if(tool.isItemDamaged())
                        {
                            if(ManaItemHandler.requestManaExact(stackInSlot, player, 100, true)) ToolHelper.repairTool(tool, 10);
                        }
                    }

                }

            }
        }
    }
}
