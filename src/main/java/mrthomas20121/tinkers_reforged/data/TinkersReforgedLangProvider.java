package mrthomas20121.tinkers_reforged.data;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.data.Metal;
import mrthomas20121.tinkers_reforged.api.holder.BlockMetalObject;
import mrthomas20121.tinkers_reforged.api.holder.ItemMetalObject;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedBlocks;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedFluids;
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
            String serializedName = metal.getSerializedName();
            add(TinkersReforged.makeDescriptionId("fluid", "molten_" + serializedName), "Molten " + capitalize(serializedName));
        }

        for(Metal metal: Metal.values) {
            String name = capitalize(metal.getSerializedName());
            ItemMetalObject itemMetalObject = TinkersReforgedItems.METALS.get(metal);

            add(itemMetalObject.getIngot(), name + " Ingot");
            add(itemMetalObject.getNugget(), name + " Nugget");
            add(itemMetalObject.getDust(), name + " Dust");
            add(itemMetalObject.getPlate(), name + " Plate");
            add(itemMetalObject.getGear(), name + " Gear");

            if(metal.equals(Metal.YTTRIUM)) {
                add(TinkersReforgedBlocks.YTTRIUM_ORE.getRawItem(), "Raw " +name);
            }
            else if(metal.equals(Metal.BARIUM)) {
                add(TinkersReforgedBlocks.BARIUM_ORE.getRawItem(), "Raw " +name);
            }
            else if(metal.equals(Metal.THALLIUM)) {
                add(TinkersReforgedBlocks.THALLIUM_ORE.getRawItem(), "Raw " +name);
            }

            add(TinkersReforgedFluids.METALS.get(metal).getBucket(), "Molten " + name + " Bucket");
        }

        for(Metal metal: Metal.values) {
            String name = capitalize(metal.getSerializedName());
            BlockMetalObject blockMetalObject = TinkersReforgedBlocks.METAl_BLOCKS.get(metal);

            add(blockMetalObject.get(), name+" Block");
            add(blockMetalObject.getPlatform(), name+" Platform");

            if(metal.equals(Metal.YTTRIUM)) {
                add(TinkersReforgedBlocks.YTTRIUM_ORE.get(), name + " Ore");
                add(TinkersReforgedBlocks.YTTRIUM_ORE.getDeepslateOre(), "Deepslate " +name + " Ore");
                add(TinkersReforgedBlocks.YTTRIUM_ORE.getRawOreBlock(), "Block of Raw " +name);
            }
            else if(metal.equals(Metal.BARIUM)) {
                add(TinkersReforgedBlocks.BARIUM_ORE.get(), name + " Ore");
                add(TinkersReforgedBlocks.BARIUM_ORE.getRawOreBlock(), "Block of Raw " +name);
            }
            else if(metal.equals(Metal.THALLIUM)) {
                add(TinkersReforgedBlocks.THALLIUM_ORE.get(), name + " Ore");
                add(TinkersReforgedBlocks.THALLIUM_ORE.getRawOreBlock(), "Block of Raw " +name);
            }
        }
    }

    private String capitalize(String s) {
        return StringUtils.capitalize(s);
    }
}
