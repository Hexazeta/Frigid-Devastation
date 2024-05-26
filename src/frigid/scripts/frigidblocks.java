package frigid.scripts;

import arc.graphics.Color;
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
import mindustry.world.blocks.power.HeaterGenerator;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.blocks.units.Reconstructor;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.world.draw.*;

import static mindustry.type.ItemStack.*;

public class frigidblocks {

    public static Block

        //item transfer
        duct, platedConveyor, multiPLatedConveyor,

        //crafters
        heater, burner, duraluminSmelter, kyanitePress, carborundumCompressor,
        duraluminCrucible,kyaniteMultiPress,carborundumMultiCompressor,
        cythorideMixer, metalAmalgamate, compositeManufacture, solidriteFoundry,
        mythrariteMixer, smallMetalAmalgamate,
        siliconFoundry,

        //payload
        container,vault,silo,

        //unit factory or some shit idk
        ballisticFactory,ballisticReconstructor;


    public static void load(){

        //item transfer
        duct = new Duct("duct"){{
            requirements(Category.distribution, with(Items.graphite, 1));
            health = 90;
            speed = 3f;
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
                    Items.thorium, 1,frigiditems.lithium, 1, frigiditems.solidrite, 1));
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

        burner = new HeaterGenerator("burner"){{
            requirements(Category.power, with(Items.graphite, 150));
            squareSprite = false;
            size = 3;
            liquidCapacity = 50f;
            heatOutput = 5;
            consumeLiquid(Liquids.water, 10f / 60f);
            consumeItem(Items.graphite);
            itemDuration = 60f * 3f;
            itemCapacity = 10;
            powerProduction = 2.5f;
            }};

        duraluminSmelter = new HeatCrafter("duralumin-smelter"){{
            requirements(Category.crafting,
                    with(frigiditems.cryolite, 150, Items.graphite, 100));
            squareSprite = false;
            itemCapacity = 30;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(frigiditems.duralumin, 2);
            craftTime = 45f;
            size = 3;
            heatRequirement = 3;
            hasPower = false;
            hasLiquids = false;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawHeatRegion(){{color = Color.valueOf("ff6060ff");}},
                    new DrawFlame(Color.valueOf("ffef99"))
            );
            consumeItems(with(frigiditems.cryolite, 3));
        }};

        kyanitePress = new GenericCrafter("kyanite-press"){{
            requirements(Category.crafting,
                    with(frigiditems.duralumin, 30, Items.graphite, 25));
            itemCapacity = 30;
            updateEffect = Fx.plasticburn;
            outputItem = new ItemStack(frigiditems.kyanite, 3);
            craftTime = 40f;
            size = 3;
            hasPower = true;
            hasLiquids = false;
            drawer = new DrawMulti(new DrawDefault(), new DrawFade());
            consumePower(2f / 3f);
            consumeItems(with(frigiditems.citrine, 3, frigiditems.cryolite, 2));
        }};

        carborundumCompressor = new HeatCrafter("carborundum-compressor"){{
            requirements(Category.crafting,
                    with(frigiditems.duralumin, 30, frigiditems.citrine, 25));
            itemCapacity = 30;
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

        cythorideMixer = new GenericCrafter("cythoride-mixer"){{
            requirements(Category.crafting,
                    with(frigiditems.duralumin, 30, frigiditems.citrine, 25));
            itemCapacity = 30;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(frigiditems.cythoride, 5);
            craftTime = 60f;
            size = 4;
            hasPower = false;
            hasLiquids = true;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;
            consumePower(3f);
            consumeItems(with(frigiditems.lithium, 7, Items.thorium, 3));
            consumeLiquid( Liquids.water, 1f / 6f);
        }};

        duraluminCrucible = new HeatCrafter("duralumin-crucible"){{
            requirements(Category.crafting,
                    with(frigiditems.cryolite, 150, Items.graphite, 100));
            squareSprite = false;
            itemCapacity = 40;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(frigiditems.duralumin, 5);
            craftTime = 35f;
            size = 4;
            heatRequirement = 8;
            hasPower = true;
            hasLiquids = false;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;
            consumePower(2.5f);
            consumeItems(with(frigiditems.cryolite, 7));
        }};

        kyaniteMultiPress = new HeatCrafter("kyanite-multi-press"){{
            requirements(Category.crafting,
                    with(frigiditems.duralumin, 30, Items.graphite, 25));
            itemCapacity = 40;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(frigiditems.kyanite, 6);
            craftTime = 55f;
            size = 4;
            hasPower = true;
            hasLiquids = false;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;
            heatRequirement = 5;
            consumePower(5f / 2f);
            consumeItems(with(frigiditems.citrine, 5, frigiditems.cryolite, 4));
        }};

        carborundumMultiCompressor = new HeatCrafter("carborundum-multi-compressor"){{
            requirements(Category.crafting,
                    with(frigiditems.duralumin, 30, frigiditems.citrine, 25));
            itemCapacity = 40;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(frigiditems.carborundum, 8);
            craftTime = 55f;
            size = 4;
            heatRequirement = 10;
            hasPower = false;
            hasLiquids = false;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;
            consumePower(4f);
            consumeItems(with(frigiditems.citrine, 3, Items.graphite, 5,frigiditems.manganese, 1));
        }};

        metalAmalgamate = new HeatCrafter("metal-amalgamate"){{
            requirements(Category.crafting,
                    with(Items.graphite, 1));
            squareSprite = false;
            itemCapacity = 610;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(Items.copper, 190);
            craftTime = 120f;
            size = 9;
            heatRequirement = 210;
            hasPower = true;
            hasLiquids = true;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;
            consumeItems(with(frigiditems.citrine, 37, frigiditems.cryolite, 33,
                    frigiditems.manganese, 24, frigiditems.cobalt, 18, Items.thorium, 13,
                    frigiditems.lithium, 21, Items.graphite, 41));
            consumeLiquid( Liquids.water, 2);
            consumePower(125f);
        }};

        compositeManufacture = new HeatCrafter("composite-manufacture"){{
            requirements(Category.crafting,
                    with(Items.graphite, 1));
            outputItems = ItemStack.with(frigiditems.carborundum, 6,
                    frigiditems.kyanite, 6, frigiditems.duralumin, 5);
            itemCapacity = 50;
            size = 5;
            heatRequirement = 10;
            hasPower = true;
            hasLiquids = false;
            craftTime = 80f;
            consumeItems(with(frigiditems.manganese, 2,frigiditems.citrine, 8,
                    frigiditems.cryolite, 7, Items.graphite, 3));
            consumePower(10f);
        }};

        solidriteFoundry = new HeatCrafter("solidrite-foundry"){{
            requirements(Category.crafting,
                    with(Items.graphite, 2));
            squareSprite = false;
            itemCapacity = 50;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(frigiditems.solidrite, 9);
            craftTime = 65f;
            size = 4;
            heatRequirement = 15;
            hasPower = true;
            hasLiquids = false;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;

            consumeItems(with(frigiditems.cobalt, 5, frigiditems.chromium, 6, frigiditems.nickel, 7));
            consumePower(7f);
        }};

        mythrariteMixer = new GenericCrafter("mythrarite-mixer"){{
            requirements(Category.crafting,
                    with(frigiditems.duralumin, 30, frigiditems.citrine, 25));
            itemCapacity = 40;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(frigiditems.mythrarite, 5);
            craftTime = 60f;
            size = 4;
            hasPower = false;
            hasLiquids = false;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;
            consumePower(3f);
            consumeItems(with(frigiditems.cythoride, 3, frigiditems.manganese, 2));
        }};

        smallMetalAmalgamate = new HeatCrafter("small-metal-amalgamate"){{
            requirements(Category.crafting,
                    with(Items.graphite, 1));
            squareSprite = false;
            itemCapacity = 120;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(Items.copper, 64);
            craftTime = 60f;
            size = 6;
            heatRequirement = 100;
            hasPower = true;
            hasLiquids = false;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;
            consumeItems(with(frigiditems.cobalt, 36, frigiditems.mythrarite, 9,
                    frigiditems.duralumin, 25, frigiditems.carborundum, 16));
            consumePower(31.25f);
        }};

        siliconFoundry = new GenericCrafter("silicon-foundry"){{
            requirements(Category.crafting,
                    with(frigiditems.duralumin, 30, Items.graphite, 25));
            liquidCapacity = 20;
            itemCapacity = 90;
            craftEffect = Fx.smeltsmoke;
            updateEffect = Fx.plasticburn;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
            outputItem = new ItemStack(Items.silicon, 32);
            craftTime = 225f;
            size = 4;
            hasPower = true;
            hasLiquids = true;
            consumePower(5f);
            consumeLiquid( Liquids.water, 1f / 6f);
            consumeItems(with(Items.pyratite, 4, Items.graphite, 4, Items.sand, 18));
        }};

        //payload
        container = new StorageBlock("container"){{
            requirements(Category.effect, with(Items.graphite, 100));
            squareSprite = false;
            size = 2;
            itemCapacity = 400;
            scaledHealth = 55;
        }};

        vault = new StorageBlock("vault"){{
            requirements(Category.effect, with(Items.graphite, 100));
            size = 3;
            itemCapacity = 3000;
            scaledHealth = 55;
        }};

        silo = new StorageBlock("silo"){{
            requirements(Category.effect, with(Items.titanium, 100));
            size = 4;
            itemCapacity = 20000;
            scaledHealth = 55;
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
