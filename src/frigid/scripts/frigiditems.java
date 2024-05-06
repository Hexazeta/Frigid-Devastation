package frigid.scripts;

import arc.graphics.Color;
import mindustry.type.Item;

public class frigiditems {

    public static Item citrine, carborundum, cobalt, lithium, kyanite, duralumin, manganese;

    public static void load() {

        citrine = new Item("citrine"){{
            color = Color.valueOf("a34f05");
        }};

        carborundum = new Item("carborundum"){{
            color = Color.valueOf("122a82");
        }};

        cobalt = new Item("cobalt"){{
            color = Color.valueOf("4262d6");
        }};

        lithium = new Item("lithium"){{
            color = Color.valueOf("a39955");
        }};

        kyanite = new Item("kyanite"){{
            color = Color.valueOf("7bbfe0");
        }};

        duralumin = new Item("duralumin"){{
            color = Color.valueOf("6d7a87");
        }};

        manganese = new Item("manganese"){{
            color = Color.valueOf("570034");
        }};
        
    }}