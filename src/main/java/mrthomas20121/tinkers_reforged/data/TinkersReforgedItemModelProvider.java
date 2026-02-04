package mrthomas20121.tinkers_reforged.data;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.data.Metal;
import mrthomas20121.tinkers_reforged.api.item.ItemMetalObject;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
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
        }
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
