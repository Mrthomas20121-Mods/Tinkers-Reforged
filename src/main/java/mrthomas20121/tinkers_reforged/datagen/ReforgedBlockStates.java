package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.block.IOreBlock;
import mrthomas20121.tinkers_reforged.block.OverworldOreBlock;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedFluids;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedBlocks;
import mrthomas20121.tinkers_reforged.api.material.EnumGem;
import mrthomas20121.tinkers_reforged.api.material.EnumMetal;
import mrthomas20121.tinkers_reforged.util.EnumData;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.mantle.registration.object.FluidObject;

public class ReforgedBlockStates extends BlockStateProvider {

    public ReforgedBlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, TinkersReforged.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for(EnumMetal metal: EnumMetal.values()) {

            if(metal.isThisOre()) {
                blockWithItem(TinkersReforgedBlocks.RAW_ORES.get(metal));
                if(metal.isThisOverworldOre()) {
                    OverworldOreBlock oreBlock = (OverworldOreBlock) TinkersReforgedBlocks.ORES.get(metal);
                    blockWithItem(oreBlock.ore());
                    blockWithItem(oreBlock.deepslateOre());
                }
                else {
                    IOreBlock oreBlock = TinkersReforgedBlocks.ORES.get(metal);
                    blockWithItem(oreBlock.ore());
                }
            }

            metalBlock(metal, TinkersReforgedBlocks.METAL_BLOCKS.get(metal).get(EnumMetal.BlockType.BLOCK));
        }

        for(EnumGem gem: EnumGem.values()) {
            OverworldOreBlock oreBlock = TinkersReforgedBlocks.GEM_ORES.get(gem);
            blockWithItem(oreBlock.ore());
            blockWithItem(oreBlock.deepslateOre());

            metalBlock(gem, TinkersReforgedBlocks.GEMS_BLOCKS.get(gem));
        }

        TinkersReforgedFluids.ALL_FLUIDS.values().forEach(this::fluid);
    }

    public void blockWithItem(RegistryObject<Block> registryObject) {
        //block model
        simpleBlock(registryObject.get());
        //itemblock model
        ResourceLocation id = registryObject.getId();
        ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "block/" + id.getPath());
        itemModels().cubeAll(id.getPath(), textureLocation);
    }

    public void metalBlock(EnumData data, RegistryObject<Block> registryObject) {
        //block model
        simpleBlock(registryObject.get(), cubeAll(registryObject, data));
        //itemblock model
        ResourceLocation id = registryObject.getId();
        ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "block/metal/"+data.getName());
        itemModels().cubeAll(id.getPath(), textureLocation);
    }

    public ModelFile cubeAll(RegistryObject<Block> block, EnumData data) {
        ResourceLocation id = block.getId();
        return models().cubeAll(name(block.get()), new ResourceLocation(id.getNamespace(), "block/metal/"+data.getName()));
    }

    private String name(Block block) {
        return block.getRegistryName().getPath();
    }

    public void fluid(FluidObject<ForgeFlowingFluid> fluid) {
        ResourceLocation name = fluid.getBlock().getRegistryName();
        simpleBlock(fluid.getBlock(), models().cubeAll(name.getPath().replace("_fluid", ""), new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/fluid/" + name.getPath().replace("_fluid", "")+"/still")));
        itemModels().cubeAll(name.getPath(), new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/fluid/" + name.getPath().replace("_fluid", "")+"/still"));
    }
}
