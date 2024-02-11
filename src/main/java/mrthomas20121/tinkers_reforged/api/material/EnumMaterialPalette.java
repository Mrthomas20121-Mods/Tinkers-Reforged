package mrthomas20121.tinkers_reforged.api.material;

import mrthomas20121.tinkers_reforged.util.EnumData;
import slimeknights.tconstruct.library.client.data.spritetransformer.GreyToColorMapping;

import static slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider.ORDER_NETHER;

public enum EnumMaterialPalette implements EnumData {

    BLAZIUM(0xffb0383a, 0xffc85441, 0xffe8714b, 0xffed8a4e, 0xfff5a952, 0xffffc756, 0xed8a4e),
    BOMIN(0xff313127, 0xff494230, 0xff706348, 0xff827559, 0xff94876a, 0xffa6997a, 0x706348),
    DURALUMIN(0xff466030, 0xff6a7a44, 0xff89a166, 0xff9bb879, 0xffcddbac, 0xffebf1c8, 0x9bb879),
    DURASTEEL(0xff372649, 0xff61477a, 0xff8661a5, 0xff9a6fad, 0xffb582ba, 0xffd195c8, 0x9a6fad),
    ELECTRIC_COPPER(0xff7b491d, 0xff945f23, 0xffa46d27, 0xffcc9332, 0xffd8a437, 0xfff5c943, 0xa46d27),
    ENDER_BONE(0xff063931, 0xff0b4d42, 0xff105e51, 0xff258474, 0xff349988, 0xff2ccdb1, 0x349988),
    EPIDOTE(0xff464434, 0xff585832, 0xff676b30, 0xffa3b157, 0xffc9d87a, 0xffeffaa4, 0xa3b157),
    ETRYX(0xff220b32, 0xff472369, 0xff582d82, 0xff6a4b99, 0xff8269b6, 0xff9883d3, 0x6a4b99),
    FEROBOLT(0xff3f292b, 0xff604543, 0xff84625c, 0xffa37b73, 0xffc5a58f, 0xffdbbea1, 0xc5a58f),
    HORNIUM(0xffcc595b, 0xfffb6364, 0xfffb7f79, 0xfffca294, 0xfffdc4af, 0xffffe1cc, 0xfdc4af),
    HUREAULITE(0xff983d19, 0xffbb5624, 0xffcf7b4b, 0xffdc8f5d, 0xfff0cfae, 0xfffff3d4, 0xcf7b4b),
    KEPU(0xff0e2f60, 0xff144776, 0xff15648d, 0xff16749b, 0xff4d8ea4, 0xff629eaa, 0x16749b),
    LAVIUM(0xff285f2e, 0xff3c7a3e, 0xff51944c, 0xff6db156, 0xffa6cd5e, 0xffc4df62, 0x6db156),
    MOSITE(0xff53505e, 0xff6b6f78, 0xff707c80, 0xff859490, 0xff9aa49a, 0xb0b5a5, 0x9aa49a),
    QIVIUM(0xff630912, 0xffa61e2d, 0xffd23038, 0xffdc413c, 0xffec5541, 0xfffd6746, 0xec5541),
    RED_BERYL(0xff6e1105, 0xffa11309, 0xffbb1533, 0xffda3a6d, 0xffe775a2, 0xffeeb2ce, 0xda3a6d),
    TIBERIUM(0xff202616, 0xff45502c, 0xff556233, 0xff718433, 0xff839a26, 0xff96b10b, 0x839a26),
    TITANIUM(0xff3c4247, 0xff4e575d, 0xff697880, 0xff889ca7, 0xffa7b4bd, 0xfff2f2f2, 0xa7b4bd);

    public final int baseColor;
    public final GreyToColorMapping colorMapping;

    EnumMaterialPalette(int color6, int color5, int color4, int color3, int color2, int color, int defaultColor) {
        this.baseColor = defaultColor;
        this.colorMapping = GreyToColorMapping.builderFromBlack().addARGB(63, color6).addARGB(102, color5).addARGB(140, color4).addARGB(178, color3).addARGB(216, color2).addARGB(255, color).build();
    }
}
