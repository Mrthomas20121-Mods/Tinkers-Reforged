package mrthomas20121.tinkers_reforged.api.data;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum TinkerMaterial implements StringRepresentable {

    GRAPHITE(Metal.GRAPHITE),
    YTTRIUM(Metal.YTTRIUM),
    BARIUM(Metal.BARIUM),
    ASTATINE(Metal.ASTATINE),
    TELLURIUM(Metal.TELLURIUM),
    GERMANIUM(Metal.GERMANIUM),
    BERKELIUM(Metal.BERKELIUM),
    ACTINIUM(Metal.ACTINIUM),
    THALLIUM(Metal.THALLIUM);

    private final Metal element;

    TinkerMaterial(Metal element) {
        this.element = element;
    }

    @NotNull
    public Metal getElement() {
        return element;
    }

    @Override
    public @NotNull String getSerializedName() {
        return this.element.getSerializedName();
    }
}
