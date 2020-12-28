package mrthomas20121.tinkers_reforged.library.block;

import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;

public class ReforgedBlockGlass extends BlockGlass {

    public ReforgedBlockGlass()
    {
        super(Material.GLASS, false);
        this.setHardness(5);
        this.setHarvestLevel("pickaxe", 1);
        this.setResistance(200);
    }
}
