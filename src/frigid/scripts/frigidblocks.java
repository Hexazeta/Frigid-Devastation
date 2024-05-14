package frigid.scripts;

import arc.struct.Seq;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.distribution.Duct;
import mindustry.world.blocks.distribution.StackConveyor;
import mindustry.world.blocks.heat.HeatProducer;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.units.Reconstructor;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawHeatOutput;
import mindustry.world.draw.DrawMulti;

import static mindustry.type.ItemStack.*;

public class frigidblocks {

    public static Block

        //item transfer
        duct,platedConveyor,multiPLatedConveyor,

        //crafters
        heater,carborundumCompressor,kyanitePress,duraluminSmelter,metalAmalgamate,

        //unit factory or some shit idk
        ballisticFactory,ballisticReconstructor;


    public static void load(){

        //item transfer
        duct = new Duct("duct"){{
            requirements(Category.distribution, with(Items.graphite, 1));
            health = 90;
            speed = 5f;
        }};

        platedConveyor = new StackConveyor("plated-conveyor"){{
            requirements(Category.distribution, with(frigiditems.carborundum, 1,
                    frigiditems.kyanite, 1, frigiditems.manganese, 1, frigiditems.duralumin, 1));
            health = 160;
            speed = 5f / 60f;
            itemCapacity = 10;
        }};

        multiPLatedConveyor = new StackConveyor("multi-plated-conveyor"){{
            requirements(Category.distribution, with(
                    Items.thorium, 1,frigiditems.lithium, 1, frigiditems.soldrite, 1));
            health = 250;
            speed = 5f / 60f;
            itemCapacity = 20;

            outputRouter = false;
            hasPower = true;
            consumesPower = true;
            conductivePower = true;

            underBullets = true;
            baseEfficiency = 1f;
            consumePower(2f / 60f);
        }};

        //crafters

        heater = new HeatProducer("heater"){{
            requirements(Category.crafting, with(Items.graphite, 50));

            drawer = new DrawMulti(new DrawDefault(), new DrawHeatOutput());
            size = 2;
            heatOutput = 3f;
            craftTime = 60f * 8f;
            ambientSound = Sounds.hum;
            consumeItem(Items.graphite);
        }};

        duraluminSmelter = new HeatCrafter("duralumin-smelter"){{
            requirements(Category.crafting,
                    with(frigiditems.cryolite, 30, Items.graphite, 25));
            itemCapacity = 20;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(frigiditems.duralumin, 2);
            craftTime = 45f;
            size = 3;
            heatRequirement = 3;
            hasPower = true;
            hasLiquids = false;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;
            consumePower(15f);
            consumeItems(with(frigiditems.cryolite, 3));
        }};

        carborundumCompressor = new HeatCrafter("carborundum-compressor"){{
            requirements(Category.crafting,
                    with(frigiditems.duralumin, 30, frigiditems.citrine, 25));
            itemCapacity = 20;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(frigiditems.carborundum, 3);
            craftTime = 60f;
            size = 3;
            heatRequirement = 5;
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
            hasPower = true;
            hasLiquids = false;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;
            consumePower(35f);
            consumeItems(with(frigiditems.citrine, 3, frigiditems.cryolite, 2));
        }};

        metalAmalgamate = new HeatCrafter("metal-amalgamate"){{
            requirements(Category.crafting,
                    with(Items.graphite, 1));
            squareSprite = false;
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

        //unit factory
        ballisticFactory = new UnitFactory("ballistic-factory"){{
            requirements(Category.units, with(
                    frigiditems.cryolite, 50, frigiditems.citrine, 120, Items.graphite, 80));
            plans = Seq.with(
                    new UnitPlan(frigidunits.ceres,
                            60f * 15, with(frigiditems.citrine, 45, frigiditems.duralumin, 20))
            );
            size = 3;
            consumePower(1.2f);
        }};

        ballisticReconstructor = new Reconstructor("ballistic-reconstructor"){{
            requirements(Category.units, with(
                    Items.graphite, 350, frigiditems.carborundum, 550,
                    frigiditems.duralumin, 350, frigiditems.kyanite, 550));

            size = 5;
            consumePower(6f);
            consumeItems(with(frigiditems.carborundum, 130, frigiditems.kyanite, 80, frigiditems.duralumin, 90));

            constructTime = 60f * 30f;

            upgrades.addAll(
                    new UnitType[]{frigidunits.ceres, frigidunits.haumea}
            );
        }};

    }
}
