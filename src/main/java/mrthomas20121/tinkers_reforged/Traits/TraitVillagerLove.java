package mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.traits.AbstractTraitLeveled;
import slimeknights.tconstruct.library.utils.TinkerUtil;

public class TraitVillagerLove extends AbstractTraitLeveled {
    public TraitVillagerLove(int levels) {
      super("ref_villager_love", 0xffffff, 3, levels);
    }
    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit) {
        if(wasHit && !target.isEntityAlive()) {
            NBTTagCompound modifierTag = TinkerUtil.getModifierTag(tool, "ref_villager_love");
            World world = player.getEntityWorld();
            int chance = world.rand.nextInt(100);
            if(chance > 49) {
                BlockPos pos = target.getPosition();
                EntityItem item_entity = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.EMERALD, 1*getLevel(modifierTag)));
                world.spawnEntity(item_entity);
            }
        }
    }
    @Override
    public void onHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean isCritical) {
        if(!(target instanceof EntityPlayer)) {
            target.setDropItemsWhenDead(false);
        }
    }
    private int getLevel(NBTTagCompound modifierNBT) {
        ModifierNBT data = new ModifierNBT(modifierNBT);
        return 1 * data.level;
      }
}