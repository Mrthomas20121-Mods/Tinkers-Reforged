package mrthomas20121.tinkers_reforged.library;

import slimeknights.tconstruct.library.materials.Material;

public class OredictEntry {

    private String value;
    private boolean representating;
    private int oredict_value;

    public OredictEntry(String value, boolean representating)
    {
        this.value = value;
        this.representating = representating;

        if(value.contains("gear")) oredict_value = Material.VALUE_Ingot*4;
        else if(value.contains("nugget")) oredict_value = Material.VALUE_Nugget;
        else if(value.contains("block")) oredict_value = Material.VALUE_Block;
        else {
            oredict_value = Material.VALUE_Ingot;
        }
    }

    public OredictEntry(String value)
    {
        this(value, false);
    }

    public String getValue() {
        return value;
    }

    public boolean isRepresentating() {
        return representating;
    }

    public int getOredictValue() {
        return oredict_value;
    }
}
