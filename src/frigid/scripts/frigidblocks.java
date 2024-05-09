package frigid.scripts;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.production.*;
import static mindustry.type.ItemStack.*;

public class frigidblocks {

    public static Block
        carborundumCompressor,kyanitePress,duraluminSmelter,metalAmalgamate;

    public static void load(){

        carborundumCompressor = new HeatCrafter("carborundum-compressor"){{
            requirements(Category.crafting,
                    with(frigiditems.duralumin, 30, frigiditems.citrine, 25));
            itemCapacity = 20;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(frigiditems.carborundum, 3);
            craftTime = 40f;
            size = 3;
            heatRequirement = 3;
            hasPower = false;
            hasLiquids = false;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;

            consumeItems(with(frigiditems.citrine, 3, Items.graphite, 2));
        }};

        kyanitePress = new GenericCrafter("kyanite-press"){{
            requirements(Category.crafting,
                    with(frigiditems.duralumin, 30, Items.graphite, 25));
            itemCapacity = 20;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(frigiditems.kyanite, 3);
            craftTime = 40f;
            size = 3;
            hasPower = false;
            hasLiquids = false;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;

            consumeItems(with(frigiditems.citrine, 3, frigiditems.cryolite, 2));
        }};

        metalAmalgamate = new HeatCrafter("metal-amalgamate"){{
            requirements(Category.crafting,
                    with(Items.graphite, 1));
            itemCapacity = 120;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(Items.copper, 30);
            craftTime = 80f;
            size = 7;
            heatRequirement = 120;
            hasPower = true;
            hasLiquids = true;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;

            consumeItems(with(frigiditems.citrine, 5, frigiditems.cryolite, 5,
                    frigiditems.manganese, 4, frigiditems.cobalt, 4, Items.thorium, 3,
                    frigiditems.lithium, 4, Items.graphite, 5));
            consumeLiquid( Liquids.water, 2);
            consumePower(100f);
        }};
    }
}
