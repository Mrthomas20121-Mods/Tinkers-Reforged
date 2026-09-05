package mrthomas20121.tinkers_reforged.data.material;

import mrthomas20121.tinkers_reforged.api.data.Metal;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.materials.definition.MaterialId;

public class TinkersReforgedMaterialDataProvider extends AbstractMaterialDataProvider {

    public TinkersReforgedMaterialDataProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addMaterials() {
        addTinkerMaterial(Metal.YTTRIUM.asMaterial(), 3, ORDER_WEAPON+ORDER_HARVEST, false);
        addTinkerMaterial(Metal.ASTATINE.asMaterial(), 3, ORDER_NETHER+ORDER_HARVEST, false);
        addTinkerMaterial(Metal.GRAPHITE.asMaterial(), 4, ORDER_NETHER+ORDER_HARVEST, false);
        addTinkerMaterial(Metal.BARIUM.asMaterial(), 4, ORDER_NETHER+ORDER_HARVEST, false);
        addTinkerMaterial(Metal.TELLURIUM.asMaterial(), 4, ORDER_NETHER+ORDER_HARVEST, false);
        addTinkerMaterial(Metal.ACTINIUM.asMaterial(), 4, ORDER_NETHER+ORDER_HARVEST, false);
        addTinkerMaterial(Metal.THALLIUM.asMaterial(), 5, ORDER_END+ORDER_WEAPON, false);
        addTinkerMaterial(Metal.BERKELIUM.asMaterial(), 5, ORDER_END+ORDER_HARVEST, false);
        addTinkerMaterial(Metal.GERMANIUM.asMaterial(), 5, ORDER_NETHER+ORDER_HARVEST, false);
        addTinkerMaterial(Metal.SLIMEBRONZE.asMaterial(), 3, ORDER_GENERAL+ORDER_SPECIAL, false);
    }

    private void addTinkerMaterial(MaterialId location, int tier, int order, boolean craftable) {
        material(location).tier(tier).sort(order).craftable(craftable);
    }

    @Override
    public String getName() {
        return "Tinkers Reforged Material Data Provider";
    }
}
