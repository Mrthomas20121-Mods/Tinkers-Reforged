package mrthomas20121.tinkers_reforged.data.material;

import mrthomas20121.tinkers_reforged.api.data.Metal;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;

public class TinkersReforgedMaterialDataProvider extends AbstractMaterialDataProvider {

    public TinkersReforgedMaterialDataProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addMaterials() {
        addMaterial(Metal.YTTRIUM.asMaterial(), 3, ORDER_WEAPON+ORDER_HARVEST, false);
        addMaterial(Metal.ASTATINE.asMaterial(), 3, ORDER_NETHER+ORDER_HARVEST, false);
        addMaterial(Metal.GRAPHITE.asMaterial(), 4, ORDER_NETHER+ORDER_HARVEST, false);
        addMaterial(Metal.BARIUM.asMaterial(), 4, ORDER_NETHER+ORDER_HARVEST, false);
        addMaterial(Metal.TELLURIUM.asMaterial(), 4, ORDER_NETHER+ORDER_HARVEST, false);
        addMaterial(Metal.ACTINIUM.asMaterial(), 4, ORDER_NETHER+ORDER_HARVEST, false);
        addMaterial(Metal.THALLIUM.asMaterial(), 5, ORDER_END+ORDER_WEAPON, false);
        addMaterial(Metal.BERKELIUM.asMaterial(), 5, ORDER_END+ORDER_HARVEST, false);
        addMaterial(Metal.GERMANIUM.asMaterial(), 5, ORDER_NETHER+ORDER_HARVEST, false);
        addMaterial(Metal.SLIMEBRONZE.asMaterial(), 3, ORDER_GENERAL+ORDER_SPECIAL, false);
    }

    @Override
    public String getName() {
        return "Tinkers Reforged Material Data Provider";
    }
}
