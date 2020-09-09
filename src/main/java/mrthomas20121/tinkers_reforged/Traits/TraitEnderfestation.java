package mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitEnderfestation extends AbstractTrait {
    public TraitEnderfestation() {
        super("enderfestation", 0x1D3D37);
        this.aspects.add(ModifierAspect.harvestOnly);
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
        if(!world.isRemote) {
            if(state.getBlock().getRegistryName().toString().contains("end")) {
                if(( ((WorldServer)world).rand.nextFloat() < 0.40)) {
                    EntityEndermite entityendermite = new EntityEndermite(world);
                    entityendermite.setSpawnedByPlayer(true);
                    entityendermite.setLocationAndAngles(player.posX, player.posY, player.posZ, player.rotationYaw, player.rotationPitch);
                    world.spawnEntity(entityendermite);
                }
            }
            else {
                if(( ((WorldServer)world).rand.nextFloat() < 0.05)) {
                    EntityEndermite entityendermite = new EntityEndermite(world);
                    entityendermite.setSpawnedByPlayer(true);
                    entityendermite.setLocationAndAngles(player.posX, player.posY, player.posZ, player.rotationYaw, player.rotationPitch);
                    world.spawnEntity(entityendermite);
                }
            }
        }
    }

}
