package mrthomas20121.tinkers_reforged.api.data;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public enum Metal implements StringRepresentable {
    GRAPHITE(),
    YTTRIUM(),
    BARIUM(),
    ASTATINE(),
    TELLURIUM(),
    GERMANIUM(),
    BERKELIUM(),
    ACTINIUM(),
    THALLIUM();

    public static final Metal[] values = Metal.values();

    private final String serializedName = this.name().toLowerCase(Locale.ROOT);

    @Override
    public @NotNull String getSerializedName() {
        return this.serializedName;
    }
}
