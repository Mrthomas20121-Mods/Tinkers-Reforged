package mrthomas20121.tinkers_reforged.trait;

import mrthomas20121.tinkers_reforged.library.trait.ReforgedTrait;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitSignal extends ReforgedTrait {
    public TraitSignal() {
        super("ref_signal", 0xE65B10);
    }

    @Override
    public void onEntityRightClick(ItemStack tool, World world, EntityPlayer player, BlockPos pos, Entity target, EnumHand hand) {
        if(isToolWithTrait(tool)) {
            if(target instanceof EntityCreeper) {
                if(!world.isRemote) ((EntityCreeper) target).ignite();
                ToolHelper.damageTool(player.getHeldItem(EnumHand.MAIN_HAND), 10, player);
            }
        }
    }
}
