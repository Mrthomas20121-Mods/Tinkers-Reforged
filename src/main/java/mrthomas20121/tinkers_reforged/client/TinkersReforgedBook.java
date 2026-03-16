package mrthomas20121.tinkers_reforged.client;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import slimeknights.mantle.client.book.BookLoader;
import slimeknights.mantle.client.book.data.BookData;
import slimeknights.mantle.client.book.repository.FileRepository;
import slimeknights.mantle.client.book.transformer.BookTransformer;
import slimeknights.tconstruct.library.client.book.sectiontransformer.ModifierTagInjectorTransformer;
import slimeknights.tconstruct.library.client.book.sectiontransformer.ToolTagInjectorTransformer;
import slimeknights.tconstruct.library.client.book.sectiontransformer.materials.TierRangeMaterialSectionTransformer;

public class TinkersReforgedBook {

    public static final BookData BOOK = BookLoader.registerBook(TinkersReforged.getResource("reforging_guide"), false, false);

    public static void initBook() {
        addBookData(BOOK);
    }

    private static void addBookData(BookData book) {
        book.addTransformer(ToolTagInjectorTransformer.INSTANCE);
        book.addTransformer(ModifierTagInjectorTransformer.INSTANCE);

        book.addRepository(new FileRepository(TinkersReforged.getResource("book/reforging_guide")));
        book.addTransformer(TierRangeMaterialSectionTransformer.INSTANCE);
        book.addTransformer(BookTransformer.indexTranformer());
        // padding needs to be last to ensure page counts are right
        book.addTransformer(BookTransformer.paddingTransformer());
    }
}
