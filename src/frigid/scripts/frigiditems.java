package frigid.scripts;

import arc.graphics.Color;
import mindustry.type.Item;

public class frigiditems {

    public static Item citrine, duralumin, kyanite, carborundum, manganese,
            cobalt, lithium, cryolite, cythoride, chromium, nickel, mythril,
            orichalcum, frostamalgum, mythrarite, solidrite, quantum, singularite;

    public static void load() {

        citrine = new Item("citrine"){{
            color = Color.valueOf("a34f05");
        }};

        duralumin = new Item("duralumin"){{
            color = Color.valueOf("6d7a87");
        }};

        kyanite = new Item("kyanite"){{
            color = Color.valueOf("7bbfe0");
        }};

        carborundum = new Item("carborundum"){{
            color = Color.valueOf("122a82");
        }};

        manganese = new Item("manganese"){{
            color = Color.valueOf("570034");
        }};

        cobalt = new Item("cobalt"){{
            color = Color.valueOf("4262d6");
        }};

        lithium = new Item("lithium"){{
            color = Color.valueOf("a39955");
        }};

        cryolite = new Item("cryolite"){{
            color = Color.valueOf("b0a082");
        }};

        cythoride = new Item("cythoride"){{
            color = Color.valueOf("5f9e0d");
        }};

        chromium = new Item("chromium"){{
            color = Color.valueOf("68aba4");
        }};

        nickel = new Item("nickel"){{
            color = Color.valueOf("9e270d");
        }};

        mythrarite = new Item("mythrarite"){{
            color = Color.valueOf("899c8c");
        }};

        solidrite = new Item("solidrite"){{
            color = Color.valueOf("d9d9d9");
        }};

    }}