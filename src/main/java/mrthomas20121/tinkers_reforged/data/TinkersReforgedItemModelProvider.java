package mrthomas20121.tinkers_reforged.data;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.data.Metal;
import mrthomas20121.tinkers_reforged.api.holder.BlockMetalObject;
import mrthomas20121.tinkers_reforged.api.holder.ItemMetalObject;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedBlocks;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class TinkersReforgedItemModelProvider extends ItemModelProvider {

    private final ModelFile.UncheckedModelFile GENERATED = new ModelFile.UncheckedModelFile("item/generated");

    public TinkersReforgedItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TinkersReforged.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for(Metal metal: Metal.values) {
            String name = metal.getSerializedName();
            ItemMetalObject itemMetalObject = TinkersReforgedItems.METALS.get(metal);

            basicItem(id(itemMetalObject.getIngot()), "material/"+name+"_ingot");
            basicItem(id(itemMetalObject.getDust()), "material/"+name+"_dust");
            basicItem(id(itemMetalObject.getNugget()), "material/"+name+"_nugget");
            basicItem(id(itemMetalObject.getPlate()), "material/"+name+"_plate");
            basicItem(id(itemMetalObject.getGear()), "material/"+name+"_gear");

            BlockMetalObject metalObject = TinkersReforgedBlocks.METAl_BLOCKS.get(metal);

            itemBlock(metalObject.get());
            platform(name, metalObject.getPlatform());

            if(metal.equals(Metal.BARIUM)) {
                itemBlock(TinkersReforgedBlocks.BARIUM_ORE.get());
                itemBlock(TinkersReforgedBlocks.BARIUM_ORE.getRawOreBlock());
                basicItem(id(TinkersReforgedBlocks.BARIUM_ORE.getRawItem()), "material/raw_"+name);
            }
            else if(metal.equals(Metal.THALLIUM)) {
                itemBlock(TinkersReforgedBlocks.THALLIUM_ORE.get());
                itemBlock(TinkersReforgedBlocks.THALLIUM_ORE.getRawOreBlock());
                basicItem(id(TinkersReforgedBlocks.THALLIUM_ORE.getRawItem()), "material/raw_"+name);
            }
            else if(metal.equals(Metal.YTTRIUM)) {
                itemBlock(TinkersReforgedBlocks.YTTRIUM_ORE.get());
                itemBlock(TinkersReforgedBlocks.YTTRIUM_ORE.getDeepslateOre());
                itemBlock(TinkersReforgedBlocks.YTTRIUM_ORE.getRawOreBlock());
                basicItem(id(TinkersReforgedBlocks.YTTRIUM_ORE.getRawItem()), "material/raw_"+name);
            }
        }
    }

    private void itemBlock(Block block) {
        ResourceLocation id = id(block);
        withExistingParent(id.getPath(), "tinkers_reforged:block/"+id.getPath());
    }

    private void platform(String name, Block block) {
        withExistingParent(id(block).getPath(), "tinkers_reforged:block/platform/"+name+"/bottom");
    }

    private ResourceLocation id(ItemLike item) {
        return ForgeRegistries.ITEMS.getKey(item.asItem());
    }

    /** Generated item with a texture */
    private ItemModelBuilder generated(ResourceLocation item, ResourceLocation texture) {
        return getBuilder(item.toString()).parent(GENERATED).texture("layer0", texture);
    }

    /** Generated item with a texture */
    private ItemModelBuilder generated(ResourceLocation item, String texture) {
        return generated(item, new ResourceLocation(item.getNamespace(), texture));
    }

    /** Generated item with a texture */
    private ItemModelBuilder generated(ItemLike item, String texture) {
        return generated(id(item), texture);
    }

    /** Generated item with a texture */
    private ItemModelBuilder basicItem(ResourceLocation item, String texture) {
        return generated(item, "item/" + texture);
    }
}
