package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.block.OreBlock;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedFluids;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedBlocks;
import mrthomas20121.tinkers_reforged.api.material.EnumGem;
import mrthomas20121.tinkers_reforged.api.material.EnumMetal;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
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
                OreBlock oreBlock = TinkersReforgedBlocks.ORES.get(metal);
                blockWithItem(oreBlock.ore());
                blockWithItem(oreBlock.deepslateOre());
            }

            for(EnumMetal.BlockType blockType: EnumMetal.BlockType.values()) {
                blockWithItem(TinkersReforgedBlocks.METAL_BLOCKS.get(metal).get(blockType));
            }
        }

        for(EnumGem gem: EnumGem.values()) {
            OreBlock oreBlock = TinkersReforgedBlocks.GEM_ORES.get(gem);
            blockWithItem(oreBlock.ore());
            blockWithItem(oreBlock.deepslateOre());

            blockWithItem(TinkersReforgedBlocks.GEMS_BLOCKS.get(gem));
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

    public void fluid(FluidObject<ForgeFlowingFluid> fluid) {
        ResourceLocation name = fluid.getBlock().getRegistryName();
        simpleBlock(fluid.getBlock(), models().cubeAll(name.getPath().replace("_fluid", ""), new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/fluid/" + name.getPath().replace("_fluid", "")+"/still")));
        itemModels().cubeAll(name.getPath(), new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/fluid/" + name.getPath().replace("_fluid", "")+"/still"));
    }
}
