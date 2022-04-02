package mrthomas20121.tinkers_reforged.trait.lavium;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

import javax.annotation.Nonnull;

public class TraitMinerBlessing extends Modifier {

    public TraitMinerBlessing() {
        super(0x81B366);
    }

    @Override
    public void afterBlockBreak(@Nonnull IModifierToolStack tool, int level, @Nonnull ToolHarvestContext context) {
        if(context.isEffective()) {
            ServerWorld world = context.getWorld();
            if(!world.isClientSide()) {
                BlockPos pos = context.getPos();
                if(RANDOM.nextFloat() > 0.1f) {
                    world.addFreshEntity(new ItemEntity(world, pos.getX()+0.5d, pos.getY()+0.5d, pos.getZ()+0.5d, new ItemStack(Items.CHARCOAL)));
                }
                else if(RANDOM.nextFloat() > 0.2f) {
                    world.addFreshEntity(new ItemEntity(world, pos.getX()+0.5d, pos.getY()+0.5d, pos.getZ()+0.5d, new ItemStack(Items.COAL)));
                }
            }
        }
    }
}
