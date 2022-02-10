package mrthomas20121.tinkers_reforged.api;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.Resources;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import slimeknights.mantle.registration.object.FluidObject;

public class ReforgedFluid extends AbstractFluid {

    protected ReforgedFluid(String name, String stillTexture, String flowTexture, int temp, int light) {
        super(name, FluidAttributes.builder(new ResourceLocation(stillTexture), new ResourceLocation(flowTexture))
                .density(4000)
                .viscosity(2500)
                .temperature(temp)
                .sound(SoundEvents.BUCKET_FILL, SoundEvents.BUCKET_EMPTY));

        block = BLOCKS.register(name, () -> new FlowingFluidBlock(stillFluid, AbstractBlock.Properties.of(Material.LAVA).noCollission().strength(100.0F).lightLevel((state) ->  light).noDrops()));
        bucket = ITEMS.register(bucket(name), () -> new BucketItem(stillFluid, new Item.Properties().craftRemainder(net.minecraft.item.Items.BUCKET).stacksTo(1).tab(Resources.group)));

        properties.bucket(bucket).block(block).explosionResistance(1000f).tickRate(9);

        object = new FluidObject<>(new ResourceLocation(TinkersReforged.MOD_ID, name), name, stillFluid, flowingFluid, block);
    }

    public RegistryObject<Item> getBucket() {
        return this.bucket;
    }

    public RegistryObject<FlowingFluidBlock> getBlock() {
        return this.block;
    }

    public RegistryObject<ForgeFlowingFluid.Source> getStillFluid() {
        return this.stillFluid;
    }

    public RegistryObject<ForgeFlowingFluid.Flowing> getFlowingFluid() {
        return this.flowingFluid;
    }

    public static ReforgedFluid register(String key, int temp, int light) {
        String still = String.format("%s:block/fluid/%s_still", TinkersReforged.MOD_ID, key);
        String flow = String.format("%s:block/fluid/%s_flowing", TinkersReforged.MOD_ID, key);
        return new ReforgedFluid(key, still, flow, temp, light);
    }
}
