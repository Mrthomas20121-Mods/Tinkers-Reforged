package mrthomas20121.tinkers_reforged.data;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.data.Metal;
import mrthomas20121.tinkers_reforged.api.item.ItemMetalObject;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import org.apache.commons.lang3.StringUtils;

public class TinkersReforgedLangProvider extends LanguageProvider {
    public TinkersReforgedLangProvider(PackOutput output) {
        super(output, TinkersReforged.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

        add("itemGroup.tinkers_reforged.metal", "Tinkers Reforged Metals");

        for(Metal metal: Metal.values) {
            String name = capitalize(metal.getSerializedName());
            ItemMetalObject itemMetalObject = TinkersReforgedItems.METALS.get(metal);

            add(itemMetalObject.getIngot(), name + " Ingot");
            add(itemMetalObject.getNugget(), name + " Nugget");
            add(itemMetalObject.getDust(), name + " Dust");
            add(itemMetalObject.getPlate(), name + " Plate");
            add(itemMetalObject.getGear(), name + " Gear");
        }
    }

    private String capitalize(String s) {
        return StringUtils.capitalize(s);
    }
}
