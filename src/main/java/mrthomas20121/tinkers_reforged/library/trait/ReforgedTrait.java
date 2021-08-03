package mrthomas20121.tinkers_reforged.library.trait;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

import java.util.List;

public class ReforgedTrait extends AbstractTrait {

    public ReforgedTrait(String name, int color) {
        super(name, color);
    }

    public void onTooltip(ItemStack tool, EntityPlayer player, List<String> toolTip) {}

    public void onItemRightClick(ItemStack tool, World world, EntityPlayer player, BlockPos pos, EnumHand hand) {}

    public void onBlockRightClick(ItemStack tool, World world, EntityPlayer player, BlockPos pos, EnumHand hand) {}

    public void onEntityRightClick(ItemStack tool, World world, EntityPlayer player, BlockPos pos, Entity target, EnumHand hand) {}

    public void onEntityAttack(ItemStack tool, EntityPlayer player, EntityLivingBase target, DamageSource source, float amount, LivingAttackEvent event) {}

    public void onEntityHeal(ItemStack tool, EntityLivingBase entity, float amount) {}

    public void onPlayerHeal(ItemStack tool, EntityPlayer player, float amount) {}
}
