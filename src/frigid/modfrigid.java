package frigid;

import mindustry.mod.*;
import frigid.gen.*;
import frigid.scripts.*;

public static final String NAME = "frigid-devastation";

public class modfrigid extends Mod{
    @Override
    public void loadContent(){
        EntityRegistry.register();
        frigidunits.load();
    }
}
