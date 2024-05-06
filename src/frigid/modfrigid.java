package frigid;

import mindustry.mod.*;
import frigid.scripts.*;

public class modfrigid extends Mod{
    @Override
    public void loadContent(){
        EntityRegistry.register();
        frigidunits.load();
        frigiditems.load();
    }

    private static class EntityRegistry {
        public static void register() {
        }
    }
}

