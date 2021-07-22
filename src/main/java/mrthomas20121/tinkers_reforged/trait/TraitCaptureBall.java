package mrthomas20121.tinkers_reforged.trait;

import mrthomas20121.tinkers_reforged.library.trait.RightClickTrait;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import slimeknights.tconstruct.library.utils.ToolHelper;

/**
 * TraitCaptureBall.java
 * @author mrthomas20121
 * Trait Effect - Allow you to capture a mob by rightclicking an entity
 */
public class TraitCaptureBall extends RightClickTrait {

    private final static String key = "capture_ball";
    private final static String entity_data = "entity";

    public TraitCaptureBall() {
        super("ref_capture_ball", 0x0);
    }

    @Override
    public void onRightClick(PlayerInteractEvent.RightClickItem event) {
        ItemStack tool = event.getEntityPlayer().getHeldItem(EnumHand.MAIN_HAND);
        BlockPos pos = event.getPos();
        World world = event.getWorld();
        if(doesEntityExist(world, pos) && isToolWithTrait(tool)) {
            if(tool.hasTagCompound()) {
                NBTTagCompound tag = tool.getTagCompound();
                // check if the tag has the entity data
                if(tag.hasKey(key)) {
                    // read the entity data from the tool tag
                    NBTTagCompound base = tag.getCompoundTag(key);
                    Entity entity = getEntityFromNBT(base, world);
                    entity.deserializeNBT(tag.getCompoundTag(entity_data));
                    entity.setPosition(pos.getX(), pos.getY(), pos.getZ());
                    if(!world.isRemote) {
                        ((WorldServer) world).spawnParticle(EnumParticleTypes.TOTEM, pos.getX() + 0.5, pos.getY() + 0.2, pos.getZ() + 0.5, 2, 0, 0, 0, 0.0, 0);
                    }
                    world.spawnEntity(entity);
                }
                else {
                    Entity entity = getEntityFromPos(world, pos);
                    if(entity != null) {
                        world.removeEntity(entity);
                        NBTTagCompound entityData = new NBTTagCompound();
                        entityData.setTag(entity_data, entity.serializeNBT());
                        tag.setTag(key, entityData);
                        if(!world.isRemote) {
                            ((WorldServer) world).spawnParticle(EnumParticleTypes.TOTEM, pos.getX() + 0.5, pos.getY() + 0.2, pos.getZ() + 0.5, 2, 0, 0, 0, 0.0, 0);
                        }
                        // damage the tool after capturing the entity
                        ToolHelper.damageTool(tool, 10, event.getEntityPlayer());
                    }
                }
            }
        }
    }

    private Entity getEntityFromNBT(NBTTagCompound tag, World world) {
        NBTTagCompound data = tag.getCompoundTag(entity_data);
        return EntityList.createEntityFromNBT(data, world);
    }

    private boolean doesEntityExist(World world, BlockPos pos) {
        boolean bool = false;
        for(Entity entity: world.loadedEntityList) {
            if(entity.getPosition().equals(pos)) {
                bool = true;
                break;
            }
        }
        return bool;
    }

    private Entity getEntityFromPos(World world, BlockPos pos) {
        for(Entity entity: world.loadedEntityList) {
            if(entity.getPosition().equals(pos)) {
                return entity;
            }
        }
        return null;
    }
}
