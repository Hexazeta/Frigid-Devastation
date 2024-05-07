package frigid.scripts;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.production.*;
import static mindustry.type.ItemStack.*;

public class frigidblocks {

    public static Block
        carborundumCompressor,kyanitePress,duraluminSmelter;

    public static void load(){

        carborundumCompressor = new GenericCrafter("carborundum-compressor"){{
            requirements(Category.crafting, with(frigiditems.duralumin, 30, Items.graphite, 25));
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(frigiditems.carborundum, 2);
            craftTime = 40f;
            size = 3;
            hasPower = true;
            hasLiquids = false;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;

            consumeItems(with(frigiditems.citrine, 3, Items.graphite, 2));
            consumePower(0.50f);
    }};

    }
}
