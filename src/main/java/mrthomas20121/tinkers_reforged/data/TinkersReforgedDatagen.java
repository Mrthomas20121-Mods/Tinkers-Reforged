package mrthomas20121.tinkers_reforged.data;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.data.Metal;
import mrthomas20121.tinkers_reforged.data.material.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import slimeknights.tconstruct.fluids.data.FluidBlockstateModelProvider;
import slimeknights.tconstruct.fluids.data.FluidBucketModelProvider;
import slimeknights.tconstruct.library.client.data.material.MaterialPaletteDebugGenerator;
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.library.client.data.material.TrimMaterialPaletteGenerator;
import slimeknights.tconstruct.tools.data.material.MaterialIds;
import slimeknights.tconstruct.tools.data.sprite.TinkerPartSpriteProvider;

import java.util.concurrent.CompletableFuture;

public class TinkersReforgedDatagen {

    public static void init(GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        boolean client = event.includeClient();
        boolean server = event.includeServer();

        // server
        TinkersReforgedBlockTagsProvider provider = new TinkersReforgedBlockTagsProvider(packOutput, lookupProvider, existingFileHelper);
        dataGenerator.addProvider(server, provider);
        dataGenerator.addProvider(server, new TinkersReforgedItemTagsProvider(packOutput, lookupProvider, provider.contentsGetter(), existingFileHelper));
        dataGenerator.addProvider(server, new TinkersReforgedFluidTagsProvider(packOutput, lookupProvider, existingFileHelper));
        dataGenerator.addProvider(server, new TinkersReforgedMaterialTagsProvider(packOutput, existingFileHelper));
        dataGenerator.addProvider(server, new TinkersReforgedRecipeProvider(packOutput));
        dataGenerator.addProvider(server, new TinkersReforgedModifierProvider(packOutput));
        dataGenerator.addProvider(server, new TinkersReforgedRegistrySets(packOutput, lookupProvider));

        TinkerPartSpriteProvider partSprites = new TinkerPartSpriteProvider();
        TinkersReforgedMaterialDataProvider materialDataProvider = new TinkersReforgedMaterialDataProvider(packOutput);
        TinkersReforgedMaterialSpriteProvider materialSpriteProvider = new TinkersReforgedMaterialSpriteProvider();
        dataGenerator.addProvider(server, materialDataProvider);
        dataGenerator.addProvider(server, new TinkersReforgedMaterialTraitProvider(packOutput, materialDataProvider));
        dataGenerator.addProvider(server, new TinkersReforgedMaterialStatsDataProvider(packOutput, materialDataProvider));
        dataGenerator.addProvider(server, TinkersReforgedBlockLoot.create(packOutput));

        // client
        dataGenerator.addProvider(client, new TinkersReforgedMaterialRenderInfoProvider(packOutput, materialSpriteProvider, existingFileHelper));
        dataGenerator.addProvider(client, new MaterialPartTextureGenerator(packOutput, existingFileHelper, partSprites, materialSpriteProvider));
        dataGenerator.addProvider(client, new MaterialPaletteDebugGenerator(packOutput, TinkersReforged.MOD_ID, materialSpriteProvider));
        dataGenerator.addProvider(client, new TrimMaterialPaletteGenerator(packOutput, TinkersReforged.MOD_ID, existingFileHelper, materialSpriteProvider, Metal.TRIM_MATERIALS));

        dataGenerator.addProvider(client, new TinkersReforgedLangProvider(packOutput));
        dataGenerator.addProvider(client, new TinkersReforgedBlockstateProvider(packOutput, existingFileHelper));
        dataGenerator.addProvider(client, new TinkersReforgedItemModelProvider(packOutput, existingFileHelper));
        dataGenerator.addProvider(client, new TinkersReforgedFluidTextureProvider(packOutput));
        dataGenerator.addProvider(client, new FluidBucketModelProvider(packOutput, TinkersReforged.MOD_ID));
        dataGenerator.addProvider(client, new FluidBlockstateModelProvider(packOutput, TinkersReforged.MOD_ID));
        dataGenerator.addProvider(client, new TinkersReforgedColorProvider(packOutput));
    }
}
