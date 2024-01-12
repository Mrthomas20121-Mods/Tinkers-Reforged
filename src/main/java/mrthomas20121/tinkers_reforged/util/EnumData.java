package mrthomas20121.tinkers_reforged.util;

import java.util.Locale;

public interface EnumData {

    String name();

    default String getName() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
