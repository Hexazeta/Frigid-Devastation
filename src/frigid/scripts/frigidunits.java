package frigid.scripts;

import mindustry.ai.types.BuilderAI;
import mindustry.*;
import arc.graphics.Color;
import mindustry.ai.types.GroundAI;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.*;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.*;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.unit.ErekirUnitType;
import mindustry.type.weapons.RepairBeamWeapon;

import static mindustry.Vars.tilesize;

public class frigidunits {
    public static UnitType

            //abwubdaobdwubdoawbwaobfawobfoabfw
            //tester
            tester,router,

            //core
            lunar,

            //ballistic,ground
            ceres,haumea,
            
            //spiker kaboom
            spiker;

    public static void load() {

        float coreFleeRange = 500f;

        router = new ErekirUnitType("router"){{
            constructor = UnitEntity::create;
            coreUnitDock = true;
            controller = u -> new BuilderAI(true, coreFleeRange);
            isEnemy = false;
            envDisabled = 0;

            range = 65f;
            faceTarget = true;
            targetPriority = -2;
            lowAltitude = false;
            mineWalls = true;
            mineFloor = false;
            mineHardnessScaling = false;
            flying = true;
            mineSpeed = 9f;
            mineTier = 3;
            buildSpeed = 1.5f;
            drag = 0.08f;
            speed = 7.5f;
            rotateSpeed = 8f;
            accel = 0.08f;
            itemCapacity = 110;
            health = 700f;
            armor = 3f;
            hitSize = 12f;
            buildBeamOffset = 8f;
            payloadCapacity = 2f * 2f * tilesize * tilesize;
            pickupUnits = false;
            vulnerableWithPayloads = true;

            fogRadius = 0f;
            targetable = false;
            hittable = false;

            engineOffset = 7.5f;
            engineSize = 3.4f;

            setEnginesMirror(
                    new UnitEngine(35 / 4f, -13 / 4f, 2.7f, 315f),
                    new UnitEngine(28 / 4f, -35 / 4f, 2.7f, 315f)
            );

            weapons.add(new RepairBeamWeapon(){{
                widthSinMag = 0.11f;
                reload = 20f;
                x = 19f/4f;
                y = 19f/4f;
                rotate = false;
                shootY = 0f;
                beamWidth = 0.7f;
                aimDst = 0f;
                shootCone = 40f;
                mirror = true;

                repairSpeed = 3.6f / 2f;
                fractionRepairSpeed = 0.03f;

                targetUnits = false;
                targetBuildings = true;
                autoTarget = false;
                controllable = true;
                laserColor = Pal.accent;
                healColor = Pal.accent;

                bullet = new BulletType(){{
                    maxRange = 65f;
                }};
            }});
        }};

        tester = new UnitType("dagger"){{
            aiController = GroundAI::new;
            constructor = MechUnit::create;

            speed = 10;
            rotateSpeed = 100;
            health = 18000;
            armor = 24;

            weapons.add(new Weapon("large-weapon"){{
                reload = 120f;
                x = 4f;
                y = 2f;
                top = false;
                ejectEffect = Fx.casing4;

                recoil = 6f;
                shake = 3f;
                shoot.shots = 3;
                shoot.shotDelay = 6f;
                alternate = true;
                mirror = true;
                inaccuracy = 7.5f;

                bullet = new BasicBulletType(8f, 128){{
                    width = 19f;
                    height = 29f;
                    lifetime = 60f;
                    shootEffect = Fx.shootBig;

                    hitEffect = Fx.blastExplosion;
                    splashDamage = 36f;
                    splashDamageRadius = 17f;

                    fragBullets = 7;
                    fragLifeMin = 0f;
                    fragRandomSpread = 60f;

                    fragBullet = new BasicBulletType(6f,32){{
                        width = 9f;
                        height = 14;
                        lifetime = 60;

                        hitEffect = Fx.flakExplosionBig;
                        splashDamage = 6f;
                        splashDamageRadius = 7f;

                        fragBullets = 7;
                        fragLifeMin = 0f;
                        fragRandomSpread = 60f;

                        fragBullet = new BasicBulletType(4f,4){{
                            width = 4f;
                            height = 7;
                            lifetime = 60;

                            hitEffect = Fx.sapped;
                        }};

                    }};
                }};
            }});
        }};

        lunar = new UnitType("lunar"){{
            aiController = BuilderAI::new;
            constructor = UnitEntity::create;

            lowAltitude = true;
            flying = true;
            mineSpeed = 6.5f;
            mineTier = 1;
            buildSpeed = 0.5f;
            drag = 0.05f;
            speed = 6f;
            rotateSpeed = 15f;
            accel = 0.1f;
            fogRadius = 0f;
            itemCapacity = 30;
            health = 240f;
            hitSize = 8f;
            alwaysUnlocked = true;

            engineOffset = 7.5f;
            engineSize = 3.4f;
            setEnginesMirror(new UnitEngine(27 / 4f, -3 / 4f, 2.7f, 315f));

            weapons.add(new RepairBeamWeapon(){{
                widthSinMag = 0.11f;
                reload = 20f;
                x = 0f;
                y = 27f/4f;
                rotate = false;
                shootY = 0f;
                beamWidth = 0.7f;
                aimDst = 0f;
                shootCone = 40f;
                mirror = false;

                repairSpeed = 3.6f / 2f;
                fractionRepairSpeed = 0.03f;

                targetUnits = false;
                targetBuildings = true;
                autoTarget = false;
                controllable = true;
                laserColor = Pal.accent;
                healColor = Pal.accent;

                bullet = new BulletType(){{
                    maxRange = 65f;
                }};
            }});

            outlineColor = Color.valueOf("282b54");
        }};

        ceres = new UnitType("ceres"){{
            constructor = MechUnit::create;
            aiController = GroundAI::new;

            speed = 1f;
            hitSize = 6f;
            rotateSpeed = 4.5f;
            health = 350;
            armor = 1f;

            outlineColor = Color.valueOf("2b2626");

            weapons.add(new Weapon("frigid-devastation-ceres-weapon"){{
                top = false;
                x = 8f;
                y = 0f;

                reload = 6f;
                mirror = true;
                ejectEffect = Fx.casing2Double;
                shoot.shots = 2;
                inaccuracy = 1;

                bullet = new BasicBulletType(3f, 15){{
                    width = 5;
                    height = 11;
                }};
            }});

        }};

        haumea = new UnitType("haumea"){{
            constructor = MechUnit::create;
            aiController = GroundAI::new;

            speed = 0.55f;
            hitSize = 24f;
            rotateSpeed = 3f;
            health = 2500;
            armor = 6f;

            outlineColor = Color.valueOf("2b2626");

            weapons.add(new Weapon("frigid-devastation-haumea-cannon"){{
                layerOffset = -0.00001f;
                top = false;
                x = 14;
                y = 0;

                recoil = 2f;
                shake = 1f;
                ejectEffect = Fx.casing3;
                shoot.shots = 2;
                shoot.shotDelay = 4f;
                alternate = true;
                mirror = true;
                reload = 24f;
                inaccuracy = 5f;

                shootSound = Vars.tree.loadSound("pewpewpew");
                bullet = new BasicBulletType(6f, 36){{
                    hitEffect = Fx.blastExplosion;
                    width = 11;
                    height = 19;
                    fragBullets = 5;
                    fragLifeMin = 0f;
                    fragRandomSpread = 60f;

                    fragBullet = new BasicBulletType(3f, 6){{
                        hitEffect = Fx.flakExplosion;
                        width = 3;
                        height = 6;
                    }};
                }};
            }});
        }};

        spiker = new UnitType("spiker"){{
            constructor = LegsUnit::create;
            aiController = GroundAI::new;

            legCount = 8;
            legLength = 16f;
            lockLegBase = true;
            legContinuousMove = true;
            legExtension = -1f;
            legBaseOffset = 1f;
            legMaxLength = 1f;
            legMinLength = 1f;
            legLengthScl = 0.5f;
            legForwardScl = 0.5f;
            rippleScale = 0.5f;
            rotateToBuilding = true;
            legMoveSpace = 2f;
            allowLegStep = true;
            legPhysicsLayer = false;

            speed = 1f;
            drag = 0.11f;
            hitSize = 24f;
            rotateSpeed = 3f;
            health = 5040;
            armor = 24f;

            outlineColor = Color.valueOf("2b2626");

        }};
    }}
