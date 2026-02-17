package mrthomas20121.tinkers_reforged.data.model;

import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.client.model.generators.loaders.CompositeModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TinkersReforgedCompositeModelBuilder<T extends ModelBuilder<T>> extends CompositeModelBuilder<T> {

    public TinkersReforgedCompositeModelBuilder(T parent, ExistingFileHelper existingFileHelper) {
        super(parent, existingFileHelper);
    }
}
