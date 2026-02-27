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
        addMaterial(Metal.ACTINIUM.asMaterial(), 3, ORDER_NETHER+ORDER_HARVEST, false);
    }

    @Override
    public String getName() {
        return "Tinkers Reforged Material Data Provider";
    }
}
