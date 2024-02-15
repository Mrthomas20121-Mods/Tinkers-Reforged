package mrthomas20121.tinkers_reforged.api.material;

import mrthomas20121.tinkers_reforged.util.EnumData;

import java.util.HashMap;
import java.util.Map;

public class ReforgedData {

    public static Map<EnumData, EnumMaterial> enumMaterialMap = new HashMap<>();

    static {
        // metals
        enumMaterialMap.put(EnumMetal.BLAZIUM, EnumMaterial.BLAZIUM);
        enumMaterialMap.put(EnumMetal.BOMIN, EnumMaterial.BOMIN);
        enumMaterialMap.put(EnumMetal.DURALUMIN, EnumMaterial.DURALUMIN);
        enumMaterialMap.put(EnumMetal.DURASTEEL, EnumMaterial.DURASTEEL);
        enumMaterialMap.put(EnumMetal.ELECTRIC_COPPER, EnumMaterial.ELECTRIC_COPPER);
        enumMaterialMap.put(EnumMetal.ETRYX, EnumMaterial.ETRYX);
        enumMaterialMap.put(EnumMetal.FEROBOLT, EnumMaterial.FEROBOLT);
        enumMaterialMap.put(EnumMetal.HORNIUM, EnumMaterial.HORNIUM);
        enumMaterialMap.put(EnumMetal.KEPU, EnumMaterial.KEPU);
        enumMaterialMap.put(EnumMetal.LAVIUM, EnumMaterial.LAVIUM);
        enumMaterialMap.put(EnumMetal.MOSITE, EnumMaterial.MOSITE);
        enumMaterialMap.put(EnumMetal.QIVIUM, EnumMaterial.QIVIUM);
        enumMaterialMap.put(EnumMetal.TIBERIUM, EnumMaterial.TIBERIUM);
        enumMaterialMap.put(EnumMetal.TITANIUM, EnumMaterial.TITANIUM);

        // gems
        enumMaterialMap.put(EnumGem.EPIDOTE, EnumMaterial.EPIDOTE);
        enumMaterialMap.put(EnumGem.HUREAULITE, EnumMaterial.HUREAULITE);
        enumMaterialMap.put(EnumGem.RED_BERYL, EnumMaterial.RED_BERYL);
    }
}
