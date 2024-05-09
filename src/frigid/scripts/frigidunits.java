package frigid.scripts;

import mindustry.*;
import arc.graphics.Color;
import mindustry.ai.types.GroundAI;
import mindustry.content.Fx;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class frigidunits {
    public static UnitType
            //core
            luna,

            //ballistic,ground
            ballistic,
            
            //spiker kaboom
            spiker;

    public static void load() {
        luna = new UnitType("luna"){{



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
                x = 10;
                y = 4;

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
                bullet = new BasicBulletType(6, 120){{
                    width = 11;
                    height = 19;
                    fragBullets = 3;
                    fragLifeMin = 0f;
                    fragRandomSpread = 60f;

                    fragBullet = new BasicBulletType(3, 24){{
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
