package mrthomas20121.tinkers_reforged.api.material;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.library.materials.definition.MaterialId;

public class ReforgedMaterialIds {

    public static MaterialId blazium = create("blazium");
    public static MaterialId bomin = create("bomin");
    public static MaterialId duralumin = create("duralumin");
    public static MaterialId durasteel = create("durasteel");
    public static MaterialId electric_copper = create("electric_copper");
    public static MaterialId ender_bone = create("ender_bone");
    public static MaterialId epidote = create("epidote");
    public static MaterialId etryx = create("etryx");
    public static MaterialId ferobolt = create("gallium");
    public static MaterialId hornium = create("hornium");
    public static MaterialId hurealite = create("hureaulite");
    public static MaterialId kepu = create("kepu");
    public static MaterialId lavium = create("lavium");
    public static MaterialId mosite = create("mosite");
    public static MaterialId qivium = create("qivium");
    public static MaterialId red_beryl = create("red_beryl");
    public static MaterialId tiberium = create("tiberium");
    public static MaterialId titanium = create("titanium");

    private static MaterialId create(String name) {
        return new MaterialId(new ResourceLocation(TinkersReforged.MOD_ID, name));
    }
}
