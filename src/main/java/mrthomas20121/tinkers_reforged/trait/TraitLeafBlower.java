package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitLeafBlower extends AbstractTrait {

    public TraitLeafBlower()
    {
        super("ref_leafblower", 0x0);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        World world = player.getEntityWorld();
        BlockPos pos = player.getPosition().down();

        NonNullList<ItemStack> oredicts = OreDictionary.getOres("grass");

        for(ItemStack ore: oredicts)
        {
            if(ore.getItem() instanceof ItemBlock)
            {
                ItemBlock itemBlock = (ItemBlock)ore.getItem();

                if(itemBlock.getBlock().getDefaultState() == world.getBlockState(pos))
                {
                    return newDamage*2;
                }
            }
        }


        return newDamage;
    }
}
