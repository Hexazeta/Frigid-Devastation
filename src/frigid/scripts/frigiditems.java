package frigid.scripts;

import frigid.scripts.frigiditems;

public class frigiditems {

    public static Item citrine,carborundum,cobalt,lithium,kyanite,duralumin,manganese;

    public static void load() {

        citrine = new Item("citrine");
        citrine.color = frigiditems.citrine;

        carborundum = new Item("carborundum");
        carborundum.color = frigiditems.carborundum;

        cobalt = new Item("cobalt");
        cobalt.color = frigiditems.cobalt;

        lithium = new Item("lithium");
        lithium.color = frigiditems.lithium;

        kyanite = new Item("kyanite");
        kyanite.color = frigiditems.kyanite;

        duralumin = new Item("duralumin");
        duralumin.color = frigiditems.duralumin;

        manganese = new Item("manganese");
        manganese.color = frigiditems.manganese;

    }







}