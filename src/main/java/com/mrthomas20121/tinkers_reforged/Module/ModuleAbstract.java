package com.mrthomas20121.tinkers_reforged.Module;

import slimeknights.tconstruct.library.traits.AbstractTrait;

public class ModuleAbstract {

    private AbstractTrait trait;
    private String dependency;

    public ModuleAbstract(AbstractTrait trait, String dep) {
        if(dep == null) {
            this.dependency = "";
        }
        else {
            this.dependency = dep;
        }
        this.trait = trait;
    }

    public AbstractTrait getTrait() {
        return this.trait;
    }
    public String getDependency() {
        return this.dependency;
    }

    public boolean hasDependency() {
        return this.dependency.isEmpty();
    }
    public static ModuleAbstract from(AbstractTrait trait, String dep) {
        return new ModuleAbstract(trait, dep);
    }
}
