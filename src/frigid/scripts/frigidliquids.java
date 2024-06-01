package frigid.scripts;

import arc.graphics.Color;
import mindustry.type.Liquid;

public class frigidliquids {

    public static Liquid mythril,orichalcum;

    public static void load() {

        mythril = new Liquid("mythril"){{color = Color.valueOf("0g94fa");}};

        orichalcum = new Liquid("orichalcum"){{color = Color.valueOf("ed7118");}};
    }}
