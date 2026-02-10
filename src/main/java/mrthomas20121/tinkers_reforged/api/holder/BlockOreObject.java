package mrthomas20121.tinkers_reforged.api.holder;

import net.minecraft.world.level.block.DropExperienceBlock;
import slimeknights.mantle.registration.object.ItemObject;

import java.util.Objects;
import java.util.function.Supplier;

public class BlockOreObject extends ItemObject<DropExperienceBlock> {

    private final Supplier<? extends DropExperienceBlock> deepslate;

    public BlockOreObject(ItemObject<DropExperienceBlock> ore, ItemObject<DropExperienceBlock> deepslate) {
        super(ore);
        this.deepslate = deepslate;
    }

    public DropExperienceBlock getDeepslateOre() {
        return Objects.requireNonNull(deepslate.get(), "BlockOreObject is missing a deepslate ore block");
    }
}
