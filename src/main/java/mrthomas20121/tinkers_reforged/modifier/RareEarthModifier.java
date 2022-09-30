package mrthomas20121.tinkers_reforged.modifier;

import mrthomas20121.tinkers_reforged.init.TinkersReforgedItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RareEarthModifier extends Modifier {

    public RareEarthModifier() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void lootEvent(LivingDropsEvent event) {
        List<ItemStack> stacks = new ArrayList<>();
        if(event.getEntity() instanceof LivingEntity livingEntity && livingEntity.getMobType() != MobType.UNDEFINED) {
            if (event.getSource().getEntity() instanceof Player player) {
                // check if the item is correct
                if (ModifierUtil.getModifierLevel(player.getMainHandItem(), this.getId()) > 0) {
                    event.getDrops().clear();
                    Random random = livingEntity.getLevel().random;
                    int count = random.nextInt(1, 3);
                    if (livingEntity.getBlockY() <= 0) {
                        stacks.add(new ItemStack(Blocks.COBBLED_DEEPSLATE, count));
                    } else {
                        stacks.add(new ItemStack(Blocks.COBBLESTONE, count));
                    }

                    if (random.nextFloat() > 0.3d) {
                        stacks.add(new ItemStack(Items.GOLD_NUGGET, random.nextInt(3, 9)));
                    }
                    if (random.nextFloat() > 0.2d) {
                        stacks.add(new ItemStack(Items.IRON_NUGGET, random.nextInt(3, 9)));
                        stacks.add(new ItemStack(TinkersReforgedItems.aluminum_nugget.get(), random.nextInt(2, 7)));
                    }
                    if (random.nextFloat() > 0.1d) {
                        stacks.add(new ItemStack(Items.DIAMOND, random.nextInt(1, 3)));
                        stacks.add(new ItemStack(TinkersReforgedItems.raw_aluminum.get(), random.nextInt(1, 3)));
                    }
                    stacks.stream().map(stack -> new ItemEntity(livingEntity.level, livingEntity.getBlockX(), livingEntity.getBlockY(), livingEntity.getBlockZ(), stack)).forEach(event.getDrops()::add);
                }
            }
        }
    }
}
