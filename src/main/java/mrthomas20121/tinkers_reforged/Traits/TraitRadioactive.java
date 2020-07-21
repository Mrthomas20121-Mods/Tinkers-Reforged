package mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitRadioactive extends AbstractTrait {
    public TraitRadioactive() {
        super("ref_radioactive", 0x8CFFAC);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if(entity.isEntityAlive()) {
            if(entity instanceof EntityLivingBase) {
                if( ((EntityLivingBase)entity).isPotionActive(MobEffects.POISON) && isSelected ) {
                    int rand = world.rand.nextInt(100);
                    if(rand>50) {
                        ((EntityLivingBase)entity).removePotionEffect(MobEffects.POISON);
                    }
                }
                else if( ((EntityLivingBase)entity).isPotionActive(MobEffects.WITHER) && isSelected ) {
                    int rand = world.rand.nextInt(100);
                    if(rand>50) {
                        ((EntityLivingBase)entity).removePotionEffect(MobEffects.WITHER); 
                    }
                }
            }
        }
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
        if(this.isToolWithTrait(tool)) {
            int rand = world.rand.nextInt(100);
            if(rand<10 && wasEffective) {
                player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 100, 1));
            }
            else if(rand>90 && wasEffective) {
                player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 100, 1));
            }
            else {
                if(wasEffective) {
                    player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 100, 0));
                }
            }
        }
    }
}
