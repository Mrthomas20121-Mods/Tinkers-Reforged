package mrthomas20121.tinkers_reforged.data;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.data.Metal;
import mrthomas20121.tinkers_reforged.api.holder.BlockMetalObject;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import slimeknights.tconstruct.shared.block.PlatformBlock;

public class TinkersReforgedBlockstateProvider extends BlockStateProvider {

    public TinkersReforgedBlockstateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TinkersReforged.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for(Metal metal: Metal.values) {
            String name = metal.getSerializedName();

            BlockMetalObject metalObject = TinkersReforgedBlocks.METAl_BLOCKS.get(metal);

            block(metalObject.get());
            platform(name, metalObject.getPlatform());

            if(metal.equals(Metal.BARIUM)) {
                block(TinkersReforgedBlocks.BARIUM_ORE.get());
                block(TinkersReforgedBlocks.BARIUM_ORE.getRawOreBlock());
            }
            else if(metal.equals(Metal.THALLIUM)) {
                block(TinkersReforgedBlocks.THALLIUM_ORE.get());
                block(TinkersReforgedBlocks.THALLIUM_ORE.getRawOreBlock());
            }
            else if(metal.equals(Metal.YTTRIUM)) {
                block(TinkersReforgedBlocks.YTTRIUM_ORE.get());
                block(TinkersReforgedBlocks.YTTRIUM_ORE.getDeepslateOre());
                block(TinkersReforgedBlocks.YTTRIUM_ORE.getRawOreBlock());
            }
        }
    }

    private ResourceLocation blockKey(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    public ResourceLocation blockTexture(Block block) {
        ResourceLocation name = blockKey(block);
        return new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/material/" + name.getPath());
    }

    private ResourceLocation extend(ResourceLocation rl, String suffix) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
    }

    public ModelFile cubeAll(Block block) {
        return models().cubeAll(blockKey(block).getPath(), blockTexture(block));
    }

    public void block(Block block) {
        simpleBlock(block, cubeAll(block));
    }

    public void platform(String name, PlatformBlock block) {
        getMultipartBuilder(block)
                .part()
                .modelFile(platformModel(name, "both","tconstruct:block/platform/both"))
                .addModel().condition(BlockStateProperties.UP, false).condition(BlockStateProperties.DOWN, false)
                .end()
                .part()
                .modelFile(platformModel(name, "top","tconstruct:block/platform/top"))
                .addModel().condition(BlockStateProperties.UP, false).condition(BlockStateProperties.DOWN, true)
                .end()
                .part()
                .modelFile(platformModel(name, "bottom", "tconstruct:block/platform/bottom"))
                .addModel().condition(BlockStateProperties.UP, true).condition(BlockStateProperties.DOWN, false)
                .end()
                .part()
                .modelFile(platformModel(name, "neither","tconstruct:block/platform/neither"))
                .addModel().condition(BlockStateProperties.UP, true).condition(BlockStateProperties.DOWN, true)
                .end()
                .part()
                .modelFile(platformModelSide(name))
                .rotationY(180)
                .addModel().condition(BlockStateProperties.NORTH, true)
                .end()
                .part()
                .rotationY(270)
                .modelFile(platformModelSide(name))
                .addModel().condition(BlockStateProperties.EAST, true)
                .end()
                .part()
                .modelFile(platformModelSide(name))
                .addModel().condition(BlockStateProperties.SOUTH, true)
                .end()
                .part()
                .rotationY(90)
                .modelFile(platformModelSide(name))
                .addModel().condition(BlockStateProperties.WEST, true)
                .end();
    }

    public BlockModelBuilder platformModel(String name, String type, String parent) {
        return models()
                .withExistingParent("tinkers_reforged:block/platform/" + name + "/" + type, parent)
                .texture("side", new ResourceLocation(TinkersReforged.MOD_ID, "block/platform/"+ name + "_side"))
                .texture("top", new ResourceLocation(TinkersReforged.MOD_ID, "block/platform/"+ name + "_top"));
    }

    public BlockModelBuilder platformModelSide(String name) {
        return models()
                .withExistingParent("tinkers_reforged:block/platform/" + name + "/side", "tconstruct:block/platform/side")
                .texture("side", new ResourceLocation(TinkersReforged.MOD_ID, "block/platform/"+ name + "_side"))
                .texture("particle", new ResourceLocation(TinkersReforged.MOD_ID, "block/platform/"+ name + "_top"));
    }
}
