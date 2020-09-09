package mrthomas20121.tinkers_reforged.modules;

import java.util.ArrayList;

import mrthomas20121.biolib.block.BlockFluid;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.resources.Resource;
import mrthomas20121.tinkers_reforged.resources.Resources;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = TinkersReforged.MODID)
public class ModuleFluids {
    public static ArrayList<ItemBlock> blockFluids = new ArrayList<>();

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> r = event.getRegistry();

        for(Resource resource: Resources.materials)
        {
            if(FluidRegistry.isFluidRegistered(resource.getFluid()))
            {
                registerFluidBlock(r, resource.getFluid());
            }
        }
    }

    public static void registerFluidBlock(IForgeRegistry<Block> r, Fluid f) {
        BlockFluid fluidBlock = new BlockFluid(f);
        fluidBlock.setRegistryName(TinkersReforged.MODID, "molten_"+f.getName());
        f.setUnlocalizedName(f.getName());
        ItemBlock itemBlock = new ItemBlock(fluidBlock);
        itemBlock.setRegistryName(fluidBlock.getRegistryName());
        blockFluids.add(itemBlock);
        r.register(fluidBlock);
    }
}
