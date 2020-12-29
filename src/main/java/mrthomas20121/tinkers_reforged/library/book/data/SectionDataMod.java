package mrthomas20121.tinkers_reforged.library.book.data;

import mrthomas20121.tinkers_reforged.library.book.ModFileRepository;
import net.minecraftforge.fml.common.Loader;
import slimeknights.mantle.client.book.BookLoader;
import slimeknights.mantle.client.book.data.PageData;
import slimeknights.mantle.client.book.data.SectionData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SectionDataMod extends SectionData {

    public String mod = "";

    @Override
    protected ArrayList<PageData> getPages(String data) {
        if(source instanceof ModFileRepository) {
            // just filters out pages where the mod is not loaded
            Predicate<String> manager = ((ModFileRepository)source).getManager();
            return new ArrayList<>(Arrays.stream(BookLoader.GSON.fromJson(data, PageDataMod[].class))
                    .filter((page)->page.mod != null || manager.test(page.mod))
                    .collect(Collectors.toList()));
        }
        return super.getPages(data);
    }
}
