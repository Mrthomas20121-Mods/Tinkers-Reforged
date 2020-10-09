package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitNuclearWaste extends AbstractTrait {

    private Potion[] effects = {
        MobEffects.ABSORPTION, 
        MobEffects.BLINDNESS, 
        MobEffects.FIRE_RESISTANCE, 
        MobEffects.GLOWING, 
        MobEffects.HASTE, 
        MobEffects.HEALTH_BOOST, 
        MobEffects.HUNGER,
        MobEffects.INVISIBILITY,
        MobEffects.JUMP_BOOST,
        MobEffects.LUCK,
        MobEffects.MINING_FATIGUE,
        MobEffects.NIGHT_VISION,
        MobEffects.POISON,
        MobEffects.REGENERATION,
        MobEffects.RESISTANCE,
        MobEffects.SLOWNESS,
        MobEffects.SPEED,
        MobEffects.STRENGTH,
        MobEffects.UNLUCK,
        MobEffects.WATER_BREATHING,
        MobEffects.WEAKNESS,
        MobEffects.WITHER
    };

    public TraitNuclearWaste() {
        super("nuclear_waste", 0xFFFFFF);
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
        if(wasEffective) {
            if(!world.isRemote) {
                int random_effect = world.rand.nextInt(effects.length);
                int effect_duration = world.rand.nextInt(50)*10;
                int amplitude = world.rand.nextInt(3);
                player.addPotionEffect(new PotionEffect(effects[random_effect], effect_duration, amplitude));
            }
        }
    }
    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        if(!player.world.isRemote) {
            int random_effect = player.world.rand.nextInt(effects.length);
            int effect_duration = player.world.rand.nextInt(50)*10;
            int amplitude = player.world.rand.nextInt(4);
            player.addPotionEffect(new PotionEffect(effects[random_effect], effect_duration, amplitude));
        }
        return newDamage;
    }

    @Override
    public void onArmorTick(ItemStack tool, World world, EntityPlayer player) { }
}
