package mrthomas20121.tinkers_reforged.api.tag;

import mrthomas20121.tinkers_reforged.api.material.EnumMetal;

import java.util.HashMap;
import java.util.Map;

public class RTags {

    private static Map<EnumMetal, MetalTags> METAl_TAGS = new HashMap<>();

    public static MetalTags getTagsForMetal(EnumMetal metal) {
        return METAl_TAGS.get(metal);
    }

    static {
        for(EnumMetal metal: EnumMetal.values()) {
            METAl_TAGS.put(metal, new MetalTags(metal));
        }
    }
}
