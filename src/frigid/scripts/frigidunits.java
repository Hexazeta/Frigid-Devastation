package frigid.scripts;

import static mindustry.Vars.*;
import mindustry.*;
import arc.graphics.Color;
import arc.math.Interp;
import arc.math.Mathf;
import arc.util.Time;
import mindustry.ai.types.BuilderAI;
import mindustry.ai.types.CargoAI;
import mindustry.ai.types.GroundAI;
import mindustry.content.Fx;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.part.HaloPart;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootHelix;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.*;
import mindustry.graphics.Layer;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class frigidunits {
    public static UnitType

            //ballistic,ground
            ballistic;
    ;

    public static void load() { 

     ballistic = new UnitType("ballistic"){{
            constructor = LegsUnit::create;
            aiController = GroundAI::new;

            speed = 1f;
            drag = 0.11f;
            hitSize = 9f;
            rotateSpeed = 3f;
            health = 650;
            armor = 1f;
            legStraightness = 0.3f;
            stepShake = 0f;

            legCount = 2;
            legLength = 8f;
            lockLegBase = true;
            legContinuousMove = true;
            legExtension = -2f;
            legBaseOffset = 3f;
            legMaxLength = 2f;
            legMinLength = 0.9f;
            legLengthScl = 0.96f;
            legForwardScl = 1.1f;
            rippleScale = 0.2f;

            legMoveSpace = 1.2f;
            allowLegStep = true;
            legPhysicsLayer = false;

            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit - 1f;
            targetAir = false;
            researchCostMultiplier = 0f;

            outlineColor = Color.valueOf("2b2626");

            weapons.add(new Weapon("ballistic-cannon"){{
                x = 0;
                y = 32;
                alternate = false;
                mirror = true;
                reload = 28f;

                shootSound = Vars.tree.loadSound("pew");
                inaccuracy = 15f;
                bullet = new MissileBulletType(3, 15){{
                    width = 8;
                    height = 8;
                    }};
                }});
            }};
        }};
