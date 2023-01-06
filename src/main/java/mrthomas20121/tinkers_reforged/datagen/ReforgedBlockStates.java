package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedFluids;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedBlocks;
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
        blockWithItem(TinkersReforgedBlocks.aluminum_ore);
        blockWithItem(TinkersReforgedBlocks.deepslate_aluminum_ore);
        blockWithItem(TinkersReforgedBlocks.aluminum_block);
        blockWithItem(TinkersReforgedBlocks.blazing_copper_block);
        blockWithItem(TinkersReforgedBlocks.duralumin_block);
        blockWithItem(TinkersReforgedBlocks.electrical_copper_block);
        blockWithItem(TinkersReforgedBlocks.lavium_block);
        blockWithItem(TinkersReforgedBlocks.qivium_block);
        blockWithItem(TinkersReforgedBlocks.gausum_block);
        blockWithItem(TinkersReforgedBlocks.felsteel_block);
        blockWithItem(TinkersReforgedBlocks.kepu_ore);
        blockWithItem(TinkersReforgedBlocks.kepu_block);
        blockWithItem(TinkersReforgedBlocks.chorus_metal_block);
        blockWithItem(TinkersReforgedBlocks.raw_kepu_block);
        blockWithItem(TinkersReforgedBlocks.raw_aluminum_block);
        blockWithItem(TinkersReforgedBlocks.durasteel_block);
        blockWithItem(TinkersReforgedBlocks.crusteel_block);
        blockWithItem(TinkersReforgedBlocks.yokel_block);
        blockWithItem(TinkersReforgedBlocks.wavy_block);
        blockWithItem(TinkersReforgedBlocks.baolian_block);
        blockWithItem(TinkersReforgedBlocks.epidote_block);
        blockWithItem(TinkersReforgedBlocks.deepslate_epidote_ore);
        blockWithItem(TinkersReforgedBlocks.galu_block);
        blockWithItem(TinkersReforgedBlocks.magma_steel_block);
        blockWithItem(TinkersReforgedBlocks.cyber_steel_block);
        blockWithItem(TinkersReforgedBlocks.hureaulite_block);
        blockWithItem(TinkersReforgedBlocks.deepslate_hureaulite_ore);
        blockWithItem(TinkersReforgedBlocks.red_beryl_block);
        blockWithItem(TinkersReforgedBlocks.gelot_block);
        blockWithItem(TinkersReforgedBlocks.piroot_block);
        blockWithItem(TinkersReforgedBlocks.red_beryl_ore);
        blockWithItem(TinkersReforgedBlocks.deepslate_red_beryl_ore);

        fluid(TinkersReforgedFluids.duralumin);
        fluid(TinkersReforgedFluids.electrical_copper);
        fluid(TinkersReforgedFluids.lavium);
        fluid(TinkersReforgedFluids.qivium);
        fluid(TinkersReforgedFluids.blazing_copper);
        fluid(TinkersReforgedFluids.redstone);
        fluid(TinkersReforgedFluids.gausum);
        fluid(TinkersReforgedFluids.lapis);
        fluid(TinkersReforgedFluids.felsteel);
        fluid(TinkersReforgedFluids.kepu);
        fluid(TinkersReforgedFluids.chorus_metal);
        fluid(TinkersReforgedFluids.chorus);
        fluid(TinkersReforgedFluids.shulker);
        fluid(TinkersReforgedFluids.durasteel);
        fluid(TinkersReforgedFluids.proto_lava);
        fluid(TinkersReforgedFluids.kelp);
        fluid(TinkersReforgedFluids.yokel);
        fluid(TinkersReforgedFluids.wavy);
        fluid(TinkersReforgedFluids.crusteel);
        fluid(TinkersReforgedFluids.baolian);
        fluid(TinkersReforgedFluids.epidote);
        fluid(TinkersReforgedFluids.galu);
        fluid(TinkersReforgedFluids.magma_steel);
        fluid(TinkersReforgedFluids.cyber_steel);
        fluid(TinkersReforgedFluids.coal);
        fluid(TinkersReforgedFluids.hureaulite);
        fluid(TinkersReforgedFluids.red_beryl);
        fluid(TinkersReforgedFluids.gelot);
        fluid(TinkersReforgedFluids.piroot);
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
