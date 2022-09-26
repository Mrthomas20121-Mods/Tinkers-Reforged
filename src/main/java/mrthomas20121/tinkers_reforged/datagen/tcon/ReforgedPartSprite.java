package mrthomas20121.tinkers_reforged.datagen.tcon;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import slimeknights.tconstruct.library.client.data.material.AbstractPartSpriteProvider;

import javax.annotation.Nonnull;

public class ReforgedPartSprite extends AbstractPartSpriteProvider {

    public ReforgedPartSprite() {
        super(TinkersReforged.MOD_ID);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Tinkers Reforged Parts Generator";
    }

    @Override
    protected void addAllSpites() {

        addHead("large_round_plate");
        addHead("great_blade");

        buildTool("frying_pan").addBreakableHead("head").addHandle("handle");
        buildTool("greatsword").addBreakableHead("blade").addHandle("guard").addHandle("handle");
    }
}
