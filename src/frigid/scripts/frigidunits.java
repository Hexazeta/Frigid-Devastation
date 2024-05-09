package frigid.scripts;

import mindustry.ai.types.BuilderAI;
import mindustry.*;
import arc.graphics.Color;
import mindustry.ai.types.GroundAI;
import mindustry.content.Fx;
import mindustry.entities.bullet.*;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.*;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class frigidunits {
    public static UnitType
            //core
            lunar,

            //ballistic,ground
            ballistic,
            
            //spiker kaboom
            spiker;

    public static void load() {
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
            engineOffset = 6f;
            hitSize = 8f;
            alwaysUnlocked = true;

            weapons.add(new Weapon("small-basic-weapon"){{
                top = false;
                reload = 15f;
                x = 2.75f;
                y = 1f;
                shoot = new ShootSpread(){{
                    shots = 2;
                    shotDelay = 3f;
                    spread = 2f;
                }};

                inaccuracy = 3f;
                ejectEffect = Fx.casing1;

                bullet = new BasicBulletType(2.5f, 11) {{
                    width = 6.5f;
                    height = 11f;
                    lifetime = 70f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    buildingDamageMultiplier = 0.01f;
                    homingPower = 0.04f;
                }};
            }});

            weapons.add(new Weapon("small-mount-weapon"){{
                top = false;
                reload = 15f;
                x = 1f;
                y = 2f;
                shoot = new ShootSpread(){{
                    shots = 2;
                    shotDelay = 3f;
                    spread = 2f;
                }};

                inaccuracy = 3f;
                ejectEffect = Fx.casing1;

                bullet = new BasicBulletType(3.5f, 11){{
                    width = 6.5f;
                    height = 11f;
                    lifetime = 70f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    buildingDamageMultiplier = 0.01f;
                    homingPower = 0.04f;
                }};
            }});
        }};

        ballistic = new UnitType("ballistic"){{
            constructor = MechUnit::create;
            aiController = GroundAI::new;

            speed = 0.55f;
            hitSize = 12f;
            rotateSpeed = 3f;
            health = 5000;
            armor = 6f;

            outlineColor = Color.valueOf("2b2626");

            weapons.add(new Weapon("ballistic-weapon"){{
                x = 12;
                y = 6;

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
                bullet = new BasicBulletType(6f, 120){{
                    width = 11;
                    height = 19;
                    fragBullets = 3;
                    fragLifeMin = 0f;
                    fragRandomSpread = 60f;

                    fragBullet = new BasicBulletType(3f, 24){{
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
