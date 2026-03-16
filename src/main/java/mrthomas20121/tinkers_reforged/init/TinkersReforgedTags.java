package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import slimeknights.tconstruct.library.materials.definition.IMaterial;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.materials.definition.MaterialManager;

public class TinkersReforgedTags {

    public static TagKey<IMaterial> MATERIALS = tag(TinkersReforged.getResource("materials"));

    public static TagKey<IMaterial> tag(ResourceLocation name) {
        return TagKey.create(MaterialManager.REGISTRY_KEY, name);
    }
}
