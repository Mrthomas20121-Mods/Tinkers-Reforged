package mrthomas20121.tinkers_reforged.datagen;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.cast.CastType;
import mrthomas20121.tinkers_reforged.api.cast.TinkerCastType;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedItems;
import mrthomas20121.tinkers_reforged.api.material.EnumGem;
import mrthomas20121.tinkers_reforged.api.material.EnumMetal;
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
        itemWithModel(TinkersReforgedItems.ender_bone, "item/generated");

        for(EnumMetal metal: EnumMetal.values()) {

            if(metal.isThisOre()) {
                itemWithModel(TinkersReforgedItems.RAW_ORES.get(metal), "item/generated");
            }

            for(EnumMetal.ItemType itemType: EnumMetal.ItemType.values()) {
                itemWithModel(TinkersReforgedItems.METALS.get(metal).get(itemType), "item/generated");
            }
        }

        for(EnumGem gem: EnumGem.values()) {
            for(EnumGem.ItemType itemType: EnumGem.ItemType.values()) {
                itemWithModel(TinkersReforgedItems.GEMS.get(gem).get(itemType), "item/generated");
            }
        }

        for(TinkerCastType castType: TinkerCastType.values()) {
            for(TinkerCastType.Type type: TinkerCastType.Type.values()) {
                castModel(TinkersReforgedItems.CASTS.get(castType).get(type), castType, type);
            }
        }

        for(CastType castType: CastType.values()) {
            castModel(TinkersReforgedItems.ALU_CASTS.get(castType), castType);
        }
    }

    public void itemWithModel(RegistryObject<? extends Item> registryObject, String model) {
        ResourceLocation id = registryObject.getId();
        ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "item/" + id.getPath());
        singleTexture(id.getPath(), new ResourceLocation(model), "layer0", textureLocation);
    }

    public void castModel(RegistryObject<? extends Item> registryObject, TinkerCastType castType, TinkerCastType.Type type) {
        ResourceLocation id = registryObject.getId();
        ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "item/cast/%s/%s".formatted(castType.getName(), type.getName()));
        singleTexture(id.getPath(), new ResourceLocation("item/generated"), "layer0", textureLocation);
    }

    public void castModel(RegistryObject<? extends Item> registryObject, CastType castType) {
        ResourceLocation id = registryObject.getId();
        ResourceLocation textureLocation = new ResourceLocation(id.getNamespace(), "item/cast/%s/%s".formatted("aluminum", castType.getName()));
        singleTexture(id.getPath(), new ResourceLocation("item/generated"), "layer0", textureLocation);
    }
}
