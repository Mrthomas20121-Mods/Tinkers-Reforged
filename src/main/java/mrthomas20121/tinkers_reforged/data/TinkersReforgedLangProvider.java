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
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.ModifierId;

public class TinkersReforgedLangProvider extends LanguageProvider {
    public TinkersReforgedLangProvider(PackOutput output) {
        super(output, TinkersReforged.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

        add("itemGroup.tinkers_reforged.tab", "Tinkers Reforged Resources");
        add("attribute.name.tinkers_reforged.player.ender_pearl_reduction", "Ender Pearl Reduction");

        for(Metal metal: Metal.values) {
            String serializedName = metal.getSerializedName();
            add(TinkersReforged.makeDescriptionId("fluid", "molten_" + serializedName), "Molten " + capitalize(serializedName));
        }


        add(TinkersReforged.makeDescriptionId("fluid", "charred_prismarine"), "Charred Prismarine");
        add(TinkersReforged.makeDescriptionId("fluid", "molten_serandite"), "Molten Serandite");
        add(TinkersReforged.makeDescriptionId("fluid", "molten_uranophane"), "Molten Uranophane");

        add(TinkersReforgedFluids.CHARRED_PRISMARINE.getBucket(), "Charred Prismarine Bucket");
        add(TinkersReforgedFluids.MOLTEN_SERANDITE.getBucket(), "Molten Serandite Bucket");
        add(TinkersReforgedFluids.MOLTEN_URANOPHANE.getBucket(), "Molten Uranophane Bucket");

        addItem(TinkersReforgedItems.BOOK, "Reforging Guide");
        add("item.tinkers_reforged.reforging_guide.tooltip", "The Book all about tinkers reforged\nBy MRT");

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

        material(Metal.SLIMEBRONZE, "This is what happens when a slime fuse with another", "Mine non-effective blocks 4 per level faster at the cost of 4 overslime per level", "", "");
        material(Metal.GRAPHITE, "I could write a novel with this", "Increases fortune level above sea level", "", "Grants 3% protection above the sea level");
        material(Metal.YTTRIUM, "Don't stop me now", "Gain +1.5 mining speed, attack damage and projectile damage per level but your repair cost is doubled", "", "Immunity to Cactus Damage, you can hug them now");
        material(Metal.ASTATINE, "100% waterproof", "Gain more damage underwater", "Gain more damage underwater", "Gain +0.1 Swim Speed and Entity Gravity per level");
        material(Metal.BARIUM, "Don't be so soft", "Attackers get weaker as you attack them or they attack you", "", "");
        material(Metal.TELLURIUM, "Not be confused with the Pokemon move", "Your attack deal 2% of the target max health instead of flat damage. \nModifiers that boost damage still works with this.", "", "Grants 2% protection while in the air");
        material(Metal.ACTINIUM, "Boil 'em, mash 'em, stick 'em in a stew", "Increases fortune level while on fire", "", "Increases looting level while on fire(helmet/boots only)");
        material(Metal.THALLIUM, "I heard it's great at deflecting bullets in the wild west", "Deals +3 damage per level against bosses", "Deals +3 damage per level against bosses", "Grants 5% dragonbreath protection");
        material(Metal.GERMANIUM, "Like the germ in Germany, I am sick on this mic", "Gain Damage, Mining Speed and Power by 3 per level if you're not in the overworld.", "", "Immune to wither mob effect.");
        material(Metal.BERKELIUM, "Berserker has nothing on this","Deal +4 damage per level but lose 0.1 entity range per level", "", "2 Extra Max HP per level at the cost of 0.2 attack speed per level");

        modifier(TinkersReforgedModifierIds.IONIZE, "Boss won't like this", "Deal more damage against bosses");
        modifier(TinkersReforgedModifierIds.LUNGFUL, "Don't smoke dragonbreath, it's bad for your lungs", "Extra protection against dragonbreath damage");
        modifier(TinkersReforgedModifierIds.TRIAD, "Tinkers Construct: Triad edition", "Your attack deal a percentage of the target max health instead of flat damage.");
        modifier(TinkersReforgedModifierIds.OVERFRACTURE, "Who Fractured the slime?", "Mine non-effective blocks faster at the cost of overslime");
        modifier(TinkersReforgedModifierIds.GROWTH, "Mom, Look how tall I am!", "Gain more mining speed, attack damage and projectile damage at the cost repair cost.");
        modifier(TinkersReforgedModifierIds.SAFEGUARD, "Give cactus a hug", "Immunity to Cactus Damage.");
        modifier(TinkersReforgedModifierIds.AGILITY, "I'm just as fast as dolphins now", "Gain more Swim Speed and Entity Gravity.");
        modifier(TinkersReforgedModifierIds.FRICTION, "You better stay airborne", "Extra Protection while in the air");
        modifier(TinkersReforgedModifierIds.LAND_PROTECTION, "Stay on land if you want to survive", "Protect you above the sea level");
        modifier(TinkersReforgedModifierIds.FRAIL, "Aren't you skinny?", "Attackers may get weaker");
        modifier(TinkersReforgedModifierIds.CLOSE_COMBAT, "Aren't you a bit too short for this?", "Deal more damage at the cost of losing entity range.");
        modifier(TinkersReforgedModifierIds.DECAY_IMMUNITY, "Not this time, wither!", "Immunity to wither mob effect.");
        modifier(TinkersReforgedModifierIds.HEALTH_UP, "Stay Healthy", "Extra Max HP at the cost of attack speed");
        modifier(TinkersReforgedModifierIds.ROAST, "You got Roasted!", "Increases looting level while on fire");
        modifier(TinkersReforgedModifierIds.FLAMING, "Flaming Hot!", "Increases fortune level while on fire");
        modifier(TinkersReforgedModifierIds.SUBAQUATIC, "Now I know how Aquaman feels like", "Deal more damage underwater");
        modifier(TinkersReforgedModifierIds.SURFACE_RESOURCES, "It's everywhere!", "Increase fortune above sea level");
        modifier(TinkersReforgedModifierIds.GEOGRAPHICAL, "The Overworld is overrated", "Gain Damage, Mining Speed and Power if you're not in the overworld.");

        add("modifier.tinkers_reforged.ionize.ionize_attack_damage", "Ionize Damage");
        add("modifier.tinkers_reforged.geographical.mining_speed", "Geographical Mining Speed");
        add("modifier.tinkers_reforged.geographical.attack_damage", "Geographical Attack Damage");
    }

    /**
     * Capitalize a lowercase string, to capitalize every words if _ is present
     * @param s string to capitalize
     * @return
     */
    private String capitalize(String s) {
        if(s.contains("_")) {
            String[] split = s.split("_");

            StringBuilder result = new StringBuilder(30);

            for(String value: split) {
                result.append(StringUtils.capitalize(value));
                result.append(" ");
            }

            return result.toString().trim();
        }

        return StringUtils.capitalize(s);
    }

    private void material(MaterialId id, String flavor, String encyclopedia, String ranged, String armor) {
        String material = id.getPath();

        String key = TinkersReforged.makeDescriptionId("material", material);

        add(key, capitalize(material));

        if(!flavor.isEmpty()) {
            add(key+".flavor", flavor);
        }
        else if(!encyclopedia.isEmpty()) {
            add(key+".encyclopedia", encyclopedia);
        }
        else if(!ranged.isEmpty()) {
            add(key+".ranged", ranged);
        }
        else if(!armor.isEmpty()) {
            add(key+".armor", armor);
        }

    }

    private void material(Metal metal, String flavor, String encyclopedia, String ranged, String armor) {
        this.material(metal.asMaterial(), flavor, encyclopedia, ranged, armor);
    }

    private void modifier(ModifierId id, String flavor, String description) {
        String modifier = id.getPath();

        String key = TinkersReforged.makeDescriptionId("modifier", modifier);

        add(key, capitalize(modifier));

        add(key+".flavor", flavor);
        add(key+".description", description);
    }
}
