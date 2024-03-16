package mrthomas20121.tinkers_reforged.datagen.tcon;

import mrthomas20121.tinkers_reforged.init.TinkersReforgedItems;
import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.tinkering.AbstractStationSlotLayoutProvider;
import slimeknights.tconstruct.tools.TinkerToolParts;

import javax.annotation.Nonnull;

public class ReforgedToolSlotLayout extends AbstractStationSlotLayoutProvider {

    public ReforgedToolSlotLayout(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void addLayouts() {

        defineModifiable(TinkersReforgedItems.GREATSWORD)
                .sortIndex(SORT_WEAPON)
                .addInputItem(TinkersReforgedItems.GREAT_BLADE.get(), 48, 26)
                .addInputItem(TinkerToolParts.toolHandle, 12, 62)
                .addInputItem(TinkerToolParts.toolHandle, 30, 44)
                .build();

        defineModifiable(TinkersReforgedItems.LONGSWORD)
                .sortIndex(SORT_WEAPON)
                .addInputItem(TinkersReforgedItems.GREAT_BLADE.get(), 48, 26)
                .addInputItem(TinkerToolParts.toolHandle, 12, 62)
                .addInputItem(TinkerToolParts.toolHandle, 30, 44)
                .build();
    }

    @Nonnull
    @Override
    public String getName() {
        return "Tinkers Reforged Tool Slot Layout";
    }
}
