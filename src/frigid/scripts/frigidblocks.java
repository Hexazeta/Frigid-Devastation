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
            requirements(Category.crafting, with(Items.copper, 30, Items.lead, 25));
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(Items.silicon, 1);
            craftTime = 40f;
            size = 2;
            hasPower = true;
            hasLiquids = false;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;

            consumeItems(with(frigiditems.citrine, 1, Items.graphite, 2));
            consumePower(0.50f);
    }};

    }
}
