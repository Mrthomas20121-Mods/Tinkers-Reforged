package mrthomas20121.tinkers_reforged.item;

import mrthomas20121.tinkers_reforged.client.TinkersReforgedBook;
import net.minecraft.world.item.ItemStack;
import slimeknights.mantle.client.book.BookScreenOpener;
import slimeknights.mantle.item.AbstractBookItem;

public class ReforgingGuideBookItem extends AbstractBookItem {

    public ReforgingGuideBookItem() {
        super(new Properties().stacksTo(1));
    }



    @Override
    public BookScreenOpener getBook(ItemStack stack) {
        return TinkersReforgedBook.BOOK;
    }
}
