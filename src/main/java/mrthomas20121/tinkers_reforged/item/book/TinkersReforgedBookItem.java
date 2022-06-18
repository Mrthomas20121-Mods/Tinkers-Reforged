package mrthomas20121.tinkers_reforged.item.book;

import mrthomas20121.tinkers_reforged.client.TinkersReforgedBook;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slimeknights.mantle.item.LecternBookItem;

import javax.annotation.Nonnull;

public class TinkersReforgedBookItem extends LecternBookItem {
    public TinkersReforgedBookItem(Properties props) {
        super(props);
    }

    @Nonnull
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, @Nonnull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (world.isClientSide) {
            TinkersReforgedBook.REFORGING_GUIDE.openGui(hand, stack);
        }
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
    }

    @Override
    public void openLecternScreenClient(@Nonnull BlockPos pos, @Nonnull ItemStack stack) {
        TinkersReforgedBook.REFORGING_GUIDE.openGui(pos, stack);
    }
}
