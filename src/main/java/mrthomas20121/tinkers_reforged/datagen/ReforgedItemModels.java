package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.Resources;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class ReforgedItemModels extends ItemModelProvider {

    public ReforgedItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, TinkersReforged.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        itemWithModel(Resources.aluminum_dust, "item/generated");
        itemWithModel(Resources.aluminum_ingot, "item/generated");
        itemWithModel(Resources.aluminum_nugget, "item/generated");

        itemWithModel(Resources.duralumin_dust, "item/generated");
        itemWithModel(Resources.duralumin_ingot, "item/generated");
        itemWithModel(Resources.duralumin_nugget, "item/generated");

        itemWithModel(Resources.electrical_copper_dust, "item/generated");
        itemWithModel(Resources.electrical_copper_ingot, "item/generated");
        itemWithModel(Resources.electrical_copper_nugget, "item/generated");

        itemWithModel(Resources.lavium_dust, "item/generated");
        itemWithModel(Resources.lavium_ingot, "item/generated");
        itemWithModel(Resources.lavium_nugget, "item/generated");

        itemWithModel(Resources.qivium_dust, "item/generated");
        itemWithModel(Resources.qivium_ingot, "item/generated");
        itemWithModel(Resources.qivium_nugget, "item/generated");

        itemWithModel(Resources.duralumin.getBucket(), "item/generated");
        itemWithModel(Resources.electrical_copper.getBucket(), "item/generated");
        itemWithModel(Resources.lavium.getBucket(), "item/generated");
        itemWithModel(Resources.qivium.getBucket(), "item/generated");
    }

    public void itemWithModel(RegistryObject<? extends Item> registryObject, String model) {
        ResourceLocation id = registryObject.getId();
        ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "item/" + id.getPath());
        singleTexture(id.getPath(), new ResourceLocation(model), "layer0", textureLocation);
    }
}
