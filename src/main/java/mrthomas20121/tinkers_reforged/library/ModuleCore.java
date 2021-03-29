package mrthomas20121.tinkers_reforged.library;

import mrthomas20121.biolib.library.ModuleBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;

import java.util.ArrayList;

public abstract class ModuleCore {

    protected ModuleBase base;
    private final ResourceLocation name;

    public ModuleCore(ResourceLocation name) {
        this.name = name;
    }

    public ModuleCore(String name) {
        this(new ResourceLocation(name, "module_"+name));
    }

    public abstract boolean canLoad();

    public abstract void preInit(FMLPreInitializationEvent var1);

    public abstract void init(FMLInitializationEvent var1);

    public abstract void postInit(FMLPostInitializationEvent var1);

    public void setMaterialClass(ModuleBase base) {
        this.base = base;
    }

    public ModuleBase getMaterialClass() {
        return base;
    }

    protected boolean isDepLoaded() {
        return Loader.isModLoaded(this.name.getNamespace());
    }

    public ArrayList<Modifier> getModifiers() {
        return new ArrayList<>();
    }
}
