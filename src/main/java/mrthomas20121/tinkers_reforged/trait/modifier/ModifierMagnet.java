package mrthomas20121.tinkers_reforged.trait.modifier;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.modifiers.ModifierTrait;

import java.util.List;

public class ModifierMagnet extends ModifierTrait {

    public ModifierMagnet() {
        super("ref_magnet", 0xBC0000);
        this.addAspects(ModifierAspect.toolOnly, ModifierAspect.weaponOnly);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if(isSelected) {
            final List<EntityItem> items = world.getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(entity.getPosition().add(-5, -5, -5), entity.getPosition().add(6, 6, 6)));
            for(final EntityItem item: items) {
                if(entity instanceof EntityPlayer) {
                    EntityPlayer player = (EntityPlayer)entity;
                    if(!item.getItem().isEmpty())
                        player.inventory.addItemStackToInventory(item.getItem());
                }
            }
        }
    }
}
