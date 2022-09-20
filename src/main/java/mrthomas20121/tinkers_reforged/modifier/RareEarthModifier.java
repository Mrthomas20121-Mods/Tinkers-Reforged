package mrthomas20121.tinkers_reforged.modifier;

import mrthomas20121.tinkers_reforged.init.TinkersReforgedItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RareEarthModifier extends Modifier {

    @Nonnull
    @Override
    public List<ItemStack> processLoot(@Nonnull IToolStackView tool, int level, @Nonnull List<ItemStack> generatedLoot, @Nonnull LootContext context) {

        List<ItemStack> stacks = new ArrayList<>();
        Entity entity = context.getParamOrNull(LootContextParams.KILLER_ENTITY);
        if(entity instanceof LivingEntity livingEntity && livingEntity.getMobType() != MobType.UNDEFINED) {
            Random random = entity.getLevel().random;
            int count = random.nextInt(1, 3);
            if(entity.getBlockY() <= 0) {
                stacks.add(new ItemStack(Blocks.COBBLED_DEEPSLATE, count));
            }
            else {
                stacks.add(new ItemStack(Blocks.COBBLESTONE, count));
            }

            if(random.nextFloat() > 0.3d) {
                stacks.add(new ItemStack(Items.GOLD_NUGGET, random.nextInt(3, 9)));
            }
            if(random.nextFloat() > 0.2d) {
                stacks.add(new ItemStack(Items.IRON_NUGGET, random.nextInt(3, 9)));
                stacks.add(new ItemStack(TinkersReforgedItems.aluminum_nugget.get(), random.nextInt(2, 7)));
            }
            if(random.nextFloat() > 0.1d) {
                stacks.add(new ItemStack(Items.DIAMOND, random.nextInt(1, 3)));
                stacks.add(new ItemStack(TinkersReforgedItems.raw_aluminum.get(), random.nextInt(1, 3)));
            }

            return stacks;
        }

        return super.processLoot(tool, level, generatedLoot, context);
    }
}
