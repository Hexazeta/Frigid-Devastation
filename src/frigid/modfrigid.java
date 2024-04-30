package frigid;

import mindustry.mod.*;
import frigid.gen.*;
import frigid.scripts.*;

public class modfrigid extends Mod{
    @Override
    public void loadContent(){
        EntityRegistry.register();
        frigidunits.load();
    }
}
