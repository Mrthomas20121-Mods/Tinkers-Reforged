package mrthomas20121.tinkers_reforged.modifiers;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.modifiers.ModifierTrait;

import java.util.ArrayList;

public class ModLensMiner extends ModifierTrait {
    public ModLensMiner()
    {
        super("ref_lens_miner", 0x8F8F8F);
        addAspects(ModifierAspect.harvestOnly, new ModifierAspect.SingleAspect(this));
    }
    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
        ArrayList<ItemStack> items = new ArrayList<>();
        String[] names = OreDictionary.getOreNames();
        for(String name: names)
        {
            if(name.startsWith("ore") && !name.equals("ore"))
            {
                NonNullList<ItemStack> itemStacks = OreDictionary.getOres(name);
                if(!itemStacks.isEmpty())
                {
                    if(!itemStacks.get(0).getItem().getRegistryName().getNamespace().equals("tfc")) items.add(OreDictionary.getOres(name).get(0));
                }
            }
        }
        int chance = world.rand.nextInt(100);
        if(chance >= 49)
        {
            if(!world.isRemote)
            {
                int rand = world.rand.nextInt(items.size());
                if(rand < items.size())
                {
                    world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), items.get(rand)));
                }
            }
        }
    }
}
