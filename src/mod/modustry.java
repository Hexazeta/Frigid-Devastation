package mod;

import mindustry.mod.*;
import mod.scripts.*;

public class modustry extends Mod{
    @Override
    public void loadContent(){
        EntityRegistry.register();
        modblocks.load();
    }

    private static class EntityRegistry {
        public static void register() {
        }
    }
}

