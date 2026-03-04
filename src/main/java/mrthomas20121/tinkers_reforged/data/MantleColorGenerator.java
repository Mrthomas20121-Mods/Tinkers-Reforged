package mrthomas20121.tinkers_reforged.data;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import slimeknights.mantle.data.GenericDataProvider;
import slimeknights.mantle.data.loadable.common.ColorLoadable;
import slimeknights.mantle.util.JsonHelper;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.ModifierId;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class MantleColorGenerator extends GenericDataProvider {

    private final Map<String, String> modifiers = new HashMap<>();
    protected final Map<String, String> materials = new HashMap<>();
    private final String modid;

    public MantleColorGenerator(PackOutput packOutput, String modid) {
        super(packOutput, PackOutput.Target.RESOURCE_PACK, "mantle");
        this.modid = modid;
    }

    abstract void addColors();

    protected void addModifier(ModifierId id, int color) {
        this.addModifier(id, "#"+ ColorLoadable.NO_ALPHA.getString(color));
    }

    protected void addModifier(ModifierId id, String color) {
        modifiers.put(id.getPath(), color);
    }

    protected void addMaterial(MaterialId id, String color) {
        materials.put(id.getPath(), color);
    }

    protected void addMaterial(MaterialId id, int color) {
        this.addMaterial(id, "#"+Integer.toHexString(color));
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput) {
        this.addColors();
        Gson gson = JsonHelper.DEFAULT_GSON;

        JsonObject object = new JsonObject();
        JsonElement modifiers = gson.toJsonTree(this.modifiers);
        JsonElement materials = gson.toJsonTree(this.materials);

        object.add("modifier."+this.modid, modifiers);
        object.add("material."+this.modid, materials);

        return saveJson(cachedOutput, new ResourceLocation(this.modid, "colors"), object);
    }

    @Override
    public @NotNull String getName() {
        return "Mantle Color Datagen";
    }
}
