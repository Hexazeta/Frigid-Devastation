package frigid.scripts;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.content.*;
import mindustry.entities.UnitSorts;
import mindustry.entities.bullet.PointLaserBulletType;
import mindustry.entities.pattern.ShootBarrel;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.ContinuousTurret;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.heat.HeatProducer;
import mindustry.world.blocks.power.BeamNode;
import mindustry.world.blocks.power.HeaterGenerator;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.blocks.units.Reconstructor;
import mindustry.world.blocks.units.UnitAssembler;
import mindustry.world.blocks.units.UnitAssemblerModule;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.world.draw.*;
import mindustry.world.meta.Env;
import org.w3c.dom.ranges.Range;

import java.awt.font.NumericShaper;

import static mindustry.type.ItemStack.*;

public class frigidblocks {

    public static Block

        //defnecese
        graphiteWall,graphiteWallLarge,graphiteWallHuge,
        //power or some shit
        powerNode,beamNode, burner,

        //item transfer
        duct, reinforcedDuct, ductRouter, overflowDuct, underflowDuct, ductBridge,
        platedConveyor, platedRouter, multiPLatedConveyor,

        //crafters
        heater, duraluminSmelter, kyanitePress, carborundumCompressor,manganeseConcentrator,
        duraluminCrucible,kyaniteMultiPress,carborundumMultiCompressor,
        cythorideMixer, metalAmalgamate, compositeManufacture, solidriteFoundry,
        mythrariteMixer, smallMetalAmalgamate, quantumForger,

        //payload
        container,vault,silo,

        //unit factory or some shit idk
        ballisticFactory, ballisticReconstructor,
        fusionAssembler, basicAssemblerModule, advancedAssemblerModule,

        //core
        coreMercury,

        //tureet
        breaker;


    public static void load(){

        //defencse
        int wallHealthMultiplier = 4;

        graphiteWall = new Wall("graphite-wall"){{
            requirements(Category.defense, with(Items.graphite, 6));
            health = 210 * wallHealthMultiplier;
            armor = 1f;
            buildCostMultiplier = 8f;
        }};

        graphiteWallLarge = new Wall("graphite-wall-large"){{
            requirements(Category.defense, ItemStack.mult(graphiteWall.requirements, 4));
            health = 210 * wallHealthMultiplier * 4;
            armor = 2f;
            buildCostMultiplier = 5f;
            size = 2;
        }};

        graphiteWallHuge = new Wall("graphite-wall-huge"){{
            requirements(Category.defense, ItemStack.mult(graphiteWall.requirements, 9));
            health = 210 * wallHealthMultiplier * 9;
            armor = 2f;
            buildCostMultiplier = 5f;
            size = 3;
        }};

        //power stuff
        powerNode = new PowerNode("power-node"){{
            requirements(Category.power, with(Items.graphite, 2, frigiditems.duralumin, 1));
            maxNodes = 20;
            laserRange = 5;
        }};

        beamNode = new BeamNode("beam-node"){{
            requirements(Category.power, with(Items.graphite, 7, frigiditems.duralumin, 3));
            consumesPower = outputsPower = true;
            health = 100;
            range = 20;
            fogRadius = 1;
            researchCost = with(Items.graphite, 7, frigiditems.duralumin, 3);

            consumePowerBuffered(1500f);
        }};

        burner = new HeaterGenerator("burner"){{
            requirements(Category.power, with(Items.graphite, 150));
            squareSprite = false;
            size = 3;
            liquidCapacity = 50f;
            heatOutput = 5;
            drawer = new DrawMulti(new DrawRegion("-bottom"),
                    new DrawLiquidTile(Liquids.water),
                    new DrawDefault(), new DrawHeatOutput());
            consumeLiquid(Liquids.water, 10f / 60f);
            consumeItem(Items.graphite);
            itemDuration = 60f * 3f;
            itemCapacity = 10;
            powerProduction = 6.5f;
        }};

        //item transfer
        duct = new Duct("duct"){{
            requirements(Category.distribution, with(Items.graphite, 1));
            health = 90;
            speed = 3f;
        }};

        ductRouter = new DuctRouter("duct-router"){{
            requirements(Category.distribution, with(frigiditems.citrine, 10));
            health = 90;
            speed = 3f;
            regionRotated1 = 1;
            solid = false;
            researchCost = with(Items.graphite, 2);
        }};

        overflowDuct = new OverflowDuct("overflow-duct"){{
            requirements(Category.distribution, with(Items.graphite, 8, frigiditems.citrine, 8));
            health = 90;
            speed = 3f;
            solid = false;
            researchCostMultiplier = 1.5f;
        }};

        underflowDuct = new OverflowDuct("underflow-duct"){{
            requirements(Category.distribution, with(Items.graphite, 8, frigiditems.citrine, 8));
            health = 90;
            speed = 3f;
            solid = false;
            researchCostMultiplier = 1.5f;
            invert = true;
        }};

        ductBridge = new DuctBridge("duct-bridge"){{
            requirements(Category.distribution, with(frigiditems.citrine, 20));
            range = 8;
            health = 90;
            speed = 4f;
            buildCostMultiplier = 2f;
            researchCostMultiplier = 0.3f;
        }};

        reinforcedDuct = new Duct("reinforced-duct"){{
            requirements(Category.distribution, with(Items.graphite, 1, frigiditems.kyanite, 1));
            health = 125;
            speed = 3f;
            armored = true;
        }};

        platedConveyor = new StackConveyor("plated-conveyor"){{
            requirements(Category.distribution, with(frigiditems.carborundum, 1,
                    frigiditems.kyanite, 1, frigiditems.manganese, 1, frigiditems.duralumin, 1));
            health = 160;
            speed = 5f / 60f;
            itemCapacity = 10;
        }};

        platedRouter = new StackRouter("plated-router"){{
            requirements(Category.distribution, with(frigiditems.manganese, 5, frigiditems.lithium, 1));
            health = 160;

            speed = 5f;

            hasPower = false;
            consumesPower = false;
            conductivePower = false;
            baseEfficiency = 1f;
            underBullets = true;
            solid = false;
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

        duraluminSmelter = new HeatCrafter("duralumin-smelter"){{
            requirements(Category.crafting,
                    with(frigiditems.cryolite, 150, Items.graphite, 100));
            itemCapacity = 30;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(frigiditems.duralumin, 1);
            craftTime = 40f;
            size = 3;
            heatRequirement = 3;
            hasPower = false;
            hasLiquids = false;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawHeatInput(),
                    new DrawFlame(Color.valueOf("ffef99"))
            );
            consumeItems(with(frigiditems.cryolite, 3));
            maxEfficiency = 5f;
        }};

        kyanitePress = new GenericCrafter("kyanite-press"){{
            requirements(Category.crafting,
                    with(frigiditems.duralumin, 30, Items.graphite, 25));
            itemCapacity = 30;
            updateEffect = Fx.plasticburn;
            outputItem = new ItemStack(frigiditems.kyanite, 3);
            craftTime = 60f;
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
            updateEffect = Fx.coalSmeltsmoke;
            outputItem = new ItemStack(frigiditems.carborundum, 3);
            craftTime = 80f;
            size = 3;
            heatRequirement = 5;
            hasPower = false;
            hasLiquids = false;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;
            drawer = new DrawMulti(new DrawDefault(), new DrawHeatInput());
            consumeItems(with(frigiditems.citrine, 3, Items.graphite, 2));
            maxEfficiency = 5f;
        }};

        manganeseConcentrator = new GenericCrafter("manganese-concentrator") {{
            requirements(Category.crafting, with( Items.graphite, 1, frigiditems.duralumin, 1,
                    frigiditems.carborundum, 1, frigiditems.kyanite, 1));
            squareSprite = true;
            size = 3;
            itemCapacity = 30;
            liquidCapacity = 90f;
            craftTime = 135f;
            hasPower = true;
            hasLiquids = true;
            craftEffect = Fx.steam;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(Liquids.water),
                    new DrawCells(), new DrawCells(){{
                        color = Color.valueOf("570034");
                        particleColorFrom = Color.valueOf("800f53");
                        particleColorTo = Color.valueOf("2e00026");
                        particles = 200;
                        range = 9f;
            }},
                    new DrawCircles(){{
                        timeScl = 400;
                        color = Color.valueOf("570034").a(0.24f);
                        strokeMax = 1.2f;
                        radius = 9f;
                        amount = 5;
                    }},
                    new DrawDefault());
            consumeLiquid(Liquids.water, 15f / 60f);
            consumePower(2.5f);
            outputItem = new ItemStack(frigiditems.manganese, 3);
        }};

        cythorideMixer = new GenericCrafter("cythoride-mixer"){{
            requirements(Category.crafting,
                    with(frigiditems.duralumin, 30, frigiditems.citrine, 25));
            itemCapacity = 30;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(frigiditems.cythoride, 5);
            craftTime = 180f;
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
            itemCapacity = 50;
            liquidCapacity = 20;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(frigiditems.duralumin, 3);
            craftTime = 30f;
            size = 4;
            heatRequirement = 8;
            hasPower = true;
            hasLiquids = false;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;
            consumePower(2.5f);
            consumeItems(with(frigiditems.cryolite, 8));
            consumeLiquid(Liquids.water, 10f / 60f);
            maxEfficiency = 5f;
        }};

        kyaniteMultiPress = new HeatCrafter("kyanite-multi-press"){{
            requirements(Category.crafting,
                    with(frigiditems.duralumin, 30, Items.graphite, 25));
            itemCapacity = 50;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(frigiditems.kyanite, 6);
            craftTime = 60f;
            size = 4;
            hasPower = true;
            hasLiquids = true;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;
            heatRequirement = 5;
            consumePower(5f / 2f);
            consumeItems(with(frigiditems.citrine, 5, frigiditems.cryolite, 4));
            maxEfficiency = 5f;
        }};

        carborundumMultiCompressor = new HeatCrafter("carborundum-multi-compressor"){{
            requirements(Category.crafting,
                    with(frigiditems.duralumin, 30, frigiditems.citrine, 25));
            itemCapacity = 50;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(frigiditems.carborundum, 8);
            craftTime = 60f;
            size = 4;
            heatRequirement = 10;
            hasPower = false;
            hasLiquids = false;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;
            consumePower(4f);
            consumeItems(with(frigiditems.citrine, 3, Items.graphite, 5,frigiditems.manganese, 1));
            maxEfficiency = 5f;
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
            maxEfficiency = 8f;
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

        quantumForger = new GenericCrafter("quantum-forger"){{
            requirements(Category.crafting,
                    with(Items.graphite, 1));
            itemCapacity = 30;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(frigiditems.quantum, 3);
            craftTime = 60f;
            size = 3;
            hasPower = true;
            hasLiquids = true;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;
            consumeLiquid(frigidliquids.orichalcum, 15f / 60f);
            consumeLiquid(frigidliquids.mythril, 20f / 60f);
            consumePower(2.6f);
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

        fusionAssembler = new UnitAssembler("fusion-assembler"){{
            requirements(Category.units, with(Items.copper, 1));
            regionSuffix = "-dark";
            size = 9;
            //TODO different reqs
            plans.add(
                    new AssemblerUnitPlan(UnitTypes.spiroct, 60f * 30f, PayloadStack.list(UnitTypes.crawler, 2, UnitTypes.atrax, 1, Blocks.titaniumWallLarge, 5)),
                    new AssemblerUnitPlan(UnitTypes.arkyid, 60f * 40f, PayloadStack.list(UnitTypes.atrax, 4, UnitTypes.spiroct, 2, Blocks.thoriumWallLarge, 10, Blocks.plastaniumWallLarge, 8)),
                    new AssemblerUnitPlan(UnitTypes.toxopid, 60f * 50f, PayloadStack.list(UnitTypes.crawler, 10, UnitTypes.atrax, 8, UnitTypes.spiroct, 5, Blocks.phaseWallLarge, 20, Blocks.surgeWallLarge, 15, Blocks.plastaniumWallLarge, 10))

            );
            areaSize = 27;

            consumePower(3.5f);
            consumeLiquid(Liquids.cryofluid, 12f / 60f);
        }};

        basicAssemblerModule = new UnitAssemblerModule("basic-assembler-module"){{
            requirements(Category.units, with(Items.copper, 1));
            consumePower(4f);
            regionSuffix = "-dark";
            researchCostMultiplier = 0.75f;

            size = 5;
        }};

        advancedAssemblerModule = new UnitAssemblerModule("advanced-assembler-module"){{
            requirements(Category.units, with(Items.copper, 1));
            consumePower(4f);
            regionSuffix = "-dark";
            researchCostMultiplier = 0.75f;
            tier = 2;
            size = 7;
        }};

        //core

        coreMercury = new CoreBlock("core-mercury"){{
            requirements(Category.effect, with(Items.graphite, 2000, frigiditems.citrine, 3000, frigiditems.cryolite, 1500));

            unitType = frigidunits.lunar;
            health = 5000;
            itemCapacity = 13000;
            size = 5;
            thrusterLength = 40/4f;

            unitCapModifier = 24;
            researchCostMultiplier = 0.11f;
        }};

        //turret

        breaker = new ContinuousTurret("breaker"){{
            requirements(Category.turret, with(Items.silicon, 2));

            shootType = new PointLaserBulletType(){{
                damage = 125f;
                buildingDamageMultiplier = 0.3f;
                hitColor = Color.valueOf("fda981");
            }};

            shoot = new ShootBarrel(){{
                barrels = new float[]{
                        -16, 2f, 0,
                        0, 0, 0,
                        16, 2f, 0
                };
                shots = 4;
                shotDelay = 5f;
            }};

            shootSound = Sounds.none;
            loopSoundVolume = 1f;
            loopSound = Sounds.laserbeam;

            shootWarmupSpeed = 0.1f;
            shootCone = 360f;

            aimChangeSpeed = 0.9f;
            rotateSpeed = 0.9f;

            shootY = 0.5f;
            size = 5;
            range = 250f;
            scaledHealth = 1000;

            //TODO is this a good idea to begin with?
            unitSort = UnitSorts.strongest;

            consumeLiquid(Liquids.slag, 25f / 60f);
        }};

    }
}
