package mrthomas20121.tinkers_reforged.api.material;

import mrthomas20121.tinkers_reforged.api.OreData;
import mrthomas20121.tinkers_reforged.util.EnumData;

import java.util.HashMap;
import java.util.Map;

public class ReforgedData {

    public static final Map<EnumData, EnumMaterial> enumMaterialMap = new HashMap<>();
    public static final Map<EnumData, OreData> oreData = new HashMap<>();

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

        // ore data
        oreData.put(EnumMetal.ALUMINUM, new OreData(50, 4, -60, 120));
        //oreData.put(EnumMetal.GALLIUM, new OreData(40, 6, -60, 120));
        oreData.put(EnumMetal.KEPU, new OreData(20, 3, -20, 100));
        oreData.put(EnumMetal.TITANIUM, new OreData(18, 4, -20, 100));
        oreData.put(EnumGem.EPIDOTE, new OreData(30, 4, -60, 5));
        oreData.put(EnumGem.HUREAULITE, new OreData(30, 4, -60, 5));
        oreData.put(EnumGem.RED_BERYL, new OreData(40, 4, -60, 50));
    }
}
