package mrthomas20121.tinkers_reforged.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

public class TinkersReforgedDatagen {

    public static void init(GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // server
        TinkersReforgedBlockTagsProvider provider = new TinkersReforgedBlockTagsProvider(packOutput, lookupProvider, existingFileHelper);
        dataGenerator.addProvider(event.includeServer(), provider);
        dataGenerator.addProvider(event.includeServer(), new TinkersReforgedItemTagsProvider(packOutput, lookupProvider, provider.contentsGetter(), existingFileHelper));

        // client
        dataGenerator.addProvider(event.includeClient(), new TinkersReforgedLangProvider(packOutput));
        dataGenerator.addProvider(event.includeClient(), new TinkersReforgedBlockstateProvider(packOutput, existingFileHelper));
        dataGenerator.addProvider(event.includeClient(), new TinkersReforgedItemModelProvider(packOutput, existingFileHelper));
    }
}
