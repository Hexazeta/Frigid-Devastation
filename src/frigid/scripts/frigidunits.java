package frigid.scripts;

import mindustry.*;
import arc.graphics.Color;
import mindustry.ai.types.GroundAI;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.graphics.Layer;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class frigidunits {
    public static UnitType

            //ballistic,ground
            ballistic,
            
            //spiker kaboom
            spiker;

    public static void load() { 

        ballistic = new UnitType("ballistic"){{
            constructor = MechUnit::create;
            aiController = GroundAI::new;

            speed = 0.75f;
            drag = 0.11f;
            hitSize = 24f;
            rotateSpeed = 3f;
            health = 5040;
            armor = 6f;

            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit - 1f;
            targetAir = false;
            researchCostMultiplier = 0f;

            outlineColor = Color.valueOf("2b2626");

            weapons.add(new Weapon("ballistic-cannon"){{

                x = 10;
                y = 4;
                shoot.shots = 3;
                range = 25;
                alternate = true;
                mirror = true;
                reload = 24f;
                inaccuracy = 10f;

                shootSound = Vars.tree.loadSound("pewpewpew");
                bullet = new BasicBulletType(6, 120){{
                    fragBullets = 5;
                    width = 11;
                    height = 19;
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
