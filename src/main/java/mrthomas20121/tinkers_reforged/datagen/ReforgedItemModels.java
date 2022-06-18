package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.CastType;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedItems;
import mrthomas20121.tinkers_reforged.item.CastObject;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ReforgedItemModels extends ItemModelProvider {

    public ReforgedItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, TinkersReforged.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        itemWithModel(TinkersReforgedItems.book, "item/generated");

        itemWithModel(TinkersReforgedItems.aluminum_dust, "item/generated");
        itemWithModel(TinkersReforgedItems.aluminum_ingot, "item/generated");
        itemWithModel(TinkersReforgedItems.aluminum_nugget, "item/generated");

        itemWithModel(TinkersReforgedItems.duralumin_dust, "item/generated");
        itemWithModel(TinkersReforgedItems.duralumin_ingot, "item/generated");
        itemWithModel(TinkersReforgedItems.duralumin_nugget, "item/generated");

        itemWithModel(TinkersReforgedItems.electrical_copper_dust, "item/generated");
        itemWithModel(TinkersReforgedItems.electrical_copper_ingot, "item/generated");
        itemWithModel(TinkersReforgedItems.electrical_copper_nugget, "item/generated");

        itemWithModel(TinkersReforgedItems.lavium_dust, "item/generated");
        itemWithModel(TinkersReforgedItems.lavium_ingot, "item/generated");
        itemWithModel(TinkersReforgedItems.lavium_nugget, "item/generated");

        itemWithModel(TinkersReforgedItems.qivium_dust, "item/generated");
        itemWithModel(TinkersReforgedItems.qivium_ingot, "item/generated");
        itemWithModel(TinkersReforgedItems.qivium_nugget, "item/generated");

        itemWithModel(TinkersReforgedItems.gausum_dust, "item/generated");
        itemWithModel(TinkersReforgedItems.gausum_ingot, "item/generated");
        itemWithModel(TinkersReforgedItems.gausum_nugget, "item/generated");

        itemWithModel(TinkersReforgedItems.felsteel_ingot, "item/generated");
        itemWithModel(TinkersReforgedItems.felsteel_dust, "item/generated");
        itemWithModel(TinkersReforgedItems.felsteel_nugget, "item/generated");

        itemWithModel(TinkersReforgedItems.kepu_ingot, "item/generated");
        itemWithModel(TinkersReforgedItems.kepu_dust, "item/generated");
        itemWithModel(TinkersReforgedItems.kepu_nugget, "item/generated");

        itemWithModel(TinkersReforgedItems.chorus_metal_ingot, "item/generated");
        itemWithModel(TinkersReforgedItems.chorus_metal_dust, "item/generated");
        itemWithModel(TinkersReforgedItems.chorus_metal_nugget, "item/generated");

        itemWithModel(TinkersReforgedItems.durasteel_ingot, "item/generated");
        itemWithModel(TinkersReforgedItems.durasteel_dust, "item/generated");
        itemWithModel(TinkersReforgedItems.durasteel_nugget, "item/generated");

        itemWithModel(TinkersReforgedItems.raw_aluminum, "item/generated");
        itemWithModel(TinkersReforgedItems.raw_kepu, "item/generated");

        itemWithModel(TinkersReforgedItems.crusteel_ingot, "item/generated");
        itemWithModel(TinkersReforgedItems.crusteel_dust, "item/generated");
        itemWithModel(TinkersReforgedItems.crusteel_nugget, "item/generated");

        itemWithModel(TinkersReforgedItems.wavy_ingot, "item/generated");
        itemWithModel(TinkersReforgedItems.wavy_dust, "item/generated");
        itemWithModel(TinkersReforgedItems.wavy_nugget, "item/generated");

        itemWithModel(TinkersReforgedItems.yokel_ingot, "item/generated");
        itemWithModel(TinkersReforgedItems.yokel_dust, "item/generated");
        itemWithModel(TinkersReforgedItems.yokel_nugget, "item/generated");

        for(CastType type : CastType.values()) {
            castModel(TinkersReforgedItems.casts.get(type), type);
        }

        castModel(TinkersReforgedItems.large_round_plate_cast);
        castModel(TinkersReforgedItems.great_blade_cast);
    }

    public void castModel(CastObject object) {
        itemWithModel(object.getGoldCast(), "item/generated");
        itemWithModel(object.getSandCast(), "item/generated");
        itemWithModel(object.getRedSandCast(), "item/generated");
    }

    public void itemWithModel(RegistryObject<? extends Item> registryObject, String model) {
        ResourceLocation id = registryObject.getId();
        ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "item/" + id.getPath());
        singleTexture(id.getPath(), new ResourceLocation(model), "layer0", textureLocation);
    }

    public void castModel(RegistryObject<? extends Item> registryObject, CastType type) {
        ResourceLocation id = registryObject.getId();
        ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "item/cast/" + type.name().toLowerCase());
        singleTexture(id.getPath(), new ResourceLocation("item/generated"), "layer0", textureLocation);
    }
}
