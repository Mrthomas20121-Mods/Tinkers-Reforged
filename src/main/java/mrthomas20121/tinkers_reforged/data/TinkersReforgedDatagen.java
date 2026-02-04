package mrthomas20121.tinkers_reforged.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;

public class TinkersReforgedDatagen {

    public static void init(GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        dataGenerator.addProvider(event.includeClient(), new TinkersReforgedLangProvider(packOutput));
        dataGenerator.addProvider(event.includeClient(), new TinkersReforgedItemModelProvider(packOutput, existingFileHelper));
    }
}
