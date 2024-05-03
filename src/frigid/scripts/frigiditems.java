package frigid.scripts;

import frigid.scripts.frigiditems;

public class frigiditems {

    public static Item citrine,carborundum,cobalt,lithium,kyanite,duralumin,manganese;

    public static void load() {

        citrine = new Item("citrine");
        citrine.color = Pal2.citrine;

        carborundum = new Item("carborundum");
        carborundum.color = Pal2.carborundum;

        cobalt = new Item("cobalt");
        cobalt.color = Pal2.cobalt;

        lithium = new Item("lithium");
        lithium.color = Pal2.lithium;

        kyanite = new Item("kyanite");
        kyanite.color = Pal2.kyanite;

        duralumin = new Item("duralumin");
        duralumin.color = Pal2.duralumin;

        manganese = new Item("manganese");
        manganese.color = Pal2.manganese;

    }







}