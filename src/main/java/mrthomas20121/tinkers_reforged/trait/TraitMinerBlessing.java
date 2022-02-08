package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTableManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;
import net.minecraftforge.common.ForgeHooks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class TraitMinerBlessing extends Modifier {

    public TraitMinerBlessing() {
        super(0x0);
    }

    @Override
    public void afterBlockBreak(@Nonnull IModifierToolStack tool, int level, @Nonnull ToolHarvestContext context) {
        if(context.isEffective()) {
            BlockState state = context.getState();
            ResourceLocation name = Objects.requireNonNull(state.getBlock().getRegistryName());
            if(name.getPath().contains("ore")) {
                ResourceLocation loot = Objects.requireNonNull(state.getBlock().getLootTable());
                ServerWorld world = context.getWorld();
                if(!world.isClientSide()) {
                    LootTableManager manager = world.getServer().getLootTables();
                    LootTable table = manager.get(loot);
                    List<ItemStack> stackList = table.getRandomItems(new LootContext.Builder(world).withRandom(world.random).create(new LootParameterSet.Builder().build()));
                    BlockPos pos = context.getPos();
                    for(ItemStack item: stackList) {
                        world.addFreshEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), item));
                    }
                }
            }
        }
    }
}
