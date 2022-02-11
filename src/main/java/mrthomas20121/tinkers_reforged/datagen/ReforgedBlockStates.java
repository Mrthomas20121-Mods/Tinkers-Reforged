package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.ReforgedFluid;
import mrthomas20121.tinkers_reforged.init.Resources;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import slimeknights.mantle.registration.object.FluidObject;

public class ReforgedBlockStates extends BlockStateProvider {

    public ReforgedBlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, TinkersReforged.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(Resources.aluminum_ore);
        blockWithItem(Resources.aluminum_block);
        blockWithItem(Resources.duralumin_block);
        blockWithItem(Resources.electrical_copper_block);
        blockWithItem(Resources.lavium_block);
        blockWithItem(Resources.qivium_block);

        fluid(Resources.duralumin);
        fluid(Resources.electrical_copper);
        fluid(Resources.lavium);
        fluid(Resources.qivium);
        fluid(Resources.blazing_copper);
        fluid(Resources.redstone);
    }

    public void blockWithItem(RegistryObject<Block> registryObject) {
        //block model
        simpleBlock(registryObject.get());
        //itemblock model
        ResourceLocation id = registryObject.getId();
        ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "block/" + id.getPath());
        itemModels().cubeAll(id.getPath(), textureLocation);
    }

    public void fluid(ReforgedFluid fluid) {
        ResourceLocation name = fluid.getBlock().get().getRegistryName();
        simpleBlock(fluid.getBlock().get(), models().cubeAll(name.getPath(), new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/fluid/" + name.getPath()+"_still")));
    }
}
