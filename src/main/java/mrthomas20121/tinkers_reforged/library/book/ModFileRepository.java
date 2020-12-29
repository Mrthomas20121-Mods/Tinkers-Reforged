package mrthomas20121.tinkers_reforged.library.book;

import mrthomas20121.tinkers_reforged.library.book.data.SectionDataMod;
import net.minecraftforge.fml.common.Loader;
import slimeknights.mantle.client.book.BookLoader;
import slimeknights.mantle.client.book.data.SectionData;
import slimeknights.mantle.client.book.repository.FileRepository;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ModFileRepository extends FileRepository {

    private Predicate<String> manager;

    public ModFileRepository(String location) {
        super(location);
        manager = Loader::isModLoaded;
    }

    @Override
    public List<SectionData> getSections() {
        // same as super, except we remove any where the related module is not loaded
        return Arrays.stream(BookLoader.GSON.fromJson(resourceToString(getResource(getResourceLocation("index.json"))), SectionDataMod[].class))
                .filter((section)->section.mod.isEmpty() || manager.test(section.mod))
                .collect(Collectors.toList());
    }

    public Predicate<String> getManager() {
        return manager;
    }
}
