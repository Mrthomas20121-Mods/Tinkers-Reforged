package mrthomas20121.tinkers_reforged.trait;

import mrthomas20121.tinkers_reforged.library.trait.RightClickTrait;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitSignal extends RightClickTrait {
    public TraitSignal() {
        super("ref_signal", 0xE65B10);
    }

    @Override
    public void onRightClick(PlayerInteractEvent.RightClickItem event) {
        World world = event.getWorld();
        EntityPlayer player = event.getEntityPlayer();
        EntityCreeper creeper = this.getEntityFromPos(EntityCreeper.class, world, event.getPos());
        if(creeper != null) {
            creeper.ignite();
            ToolHelper.damageTool(player.getHeldItem(EnumHand.MAIN_HAND), 10, player);
        }
    }

    public <T extends Entity> T getEntityFromPos(Class<T> entityClass, World world, BlockPos pos) {
        for(Entity entity: world.loadedEntityList) {
            if(entityClass.isInstance(entity) && entity.getPosition().equals(pos)) {
                return entityClass.cast(entity);
            }
        }
        return null;
    }
}
