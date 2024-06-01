package frigid;

import mindustry.mod.*;
import frigid.scripts.*;

public class modfrigid extends Mod{
    @Override
    public void loadContent(){
        EntityRegistry.register();
        frigidliquids.load();
        frigidunits.load();
        frigiditems.load();
        frigidblocks.load();
    }

    private static class EntityRegistry {
        public static void register() {
        }
    }
}

