package mrthomas20121.tinkers_reforged.util;

import net.minecraft.tags.TagKey;

import java.util.List;

public interface EnumTag<T> {

    TagKey<T> createTag(String name);

    List<String> getTags();
}
