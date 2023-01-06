package mrthomas20121.tinkers_reforged.datagen.tcon;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.library.materials.definition.MaterialId;

public class ReforgedMaterialIds {

    public static final MaterialId aluminum = createMaterial("aluminum");
    public static final MaterialId duralumin = createMaterial("duralumin");
    public static final MaterialId electrical_copper = createMaterial("electrical_copper");
    public static final MaterialId lavium = createMaterial("lavium");
    public static final MaterialId qivium = createMaterial("qivium");
    public static final MaterialId gausum = createMaterial("gausum");
    public static final MaterialId felsteel = createMaterial("felsteel");
    public static final MaterialId chorus_metal = createMaterial("chorus_metal");
    public static final MaterialId kepu = createMaterial("kepu");
    public static final MaterialId durasteel = createMaterial("durasteel");
    public static final MaterialId crusteel = createMaterial("crusteel");
    public static final MaterialId wavy = createMaterial("wavy");
    public static final MaterialId yokel = createMaterial("yokel");
    public static final MaterialId baolian = createMaterial("baolian");
    public static final MaterialId epidote = createMaterial("epidote");
    public static final MaterialId galu = createMaterial("galu");
    public static final MaterialId hureaulite = createMaterial("hureaulite");
    public static final MaterialId red_beryl = createMaterial("red_beryl");
    public static final MaterialId ender_bone = createMaterial("ender_bone");
    public static final MaterialId blazing_copper = createMaterial("blazing_copper");
    public static final MaterialId magma_steel = createMaterial("magma_steel");
    public static final MaterialId cyber_steel = createMaterial("cyber_steel");
    public static final MaterialId piroot = createMaterial("piroot");
    public static final MaterialId gelot = createMaterial("gelot");

    public static MaterialId createMaterial(String name) {
        return new MaterialId(new ResourceLocation(TinkersReforged.MOD_ID, name));
    }
}