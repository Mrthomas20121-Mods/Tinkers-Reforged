package mrthomas20121.tinkers_reforged.client;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.resources.ResourceLocation;
import slimeknights.mantle.client.book.BookLoader;
import slimeknights.mantle.client.book.data.BookData;
import slimeknights.mantle.client.book.repository.FileRepository;
import slimeknights.mantle.client.book.transformer.BookTransformer;
import slimeknights.tconstruct.library.client.book.sectiontransformer.ToolSectionTransformer;

import static slimeknights.tconstruct.library.TinkerBookIDs.MATERIALS_BOOK_ID;

public class TinkersReforgedBook extends BookData {

    public static final ResourceLocation id = new ResourceLocation(TinkersReforged.MOD_ID, "reforging_guide");
    public static final BookData REFORGING_GUIDE = BookLoader.registerBook(id,    false, false);

    public static void initBook() {
        REFORGING_GUIDE.addTransformer(ToolSectionTransformer.INSTANCE);
        REFORGING_GUIDE.addTransformer(new TinkersReforgedMaterialSection());
        addStandardData(REFORGING_GUIDE, id);
    }

    private static void addStandardData(BookData book, ResourceLocation id) {
        book.addRepository(new FileRepository(new ResourceLocation(id.getNamespace(), "book/" + id.getPath())));
        book.addTransformer(BookTransformer.indexTranformer());
        // padding needs to be last to ensure page counts are right
        book.addTransformer(BookTransformer.paddingTransformer());
    }
}
