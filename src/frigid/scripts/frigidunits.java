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
            ballistic,
            
            //spiker kaboom
            spiker;
    ;

    public static void load() { 

        ballistic = new UnitType("ballistic"){{
            constructor = MechUnit::create;
            aiController = GroundAI::new;

            speed = 0.25f;
            drag = 0.11f;
            hitSize = 24f;
            rotateSpeed = 3f;
            health = 5040;
            armor = 24f;

            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit - 1f;
            targetAir = false;
            researchCostMultiplier = 0f;

            outlineColor = Color.valueOf("2b2626");

            weapons.add(new Weapon("Frigid-ballistic-cannon"){{
                x = 10;
                y = 4;
                alternate = true;
                mirror = true;
                reload = 24f;
                inaccuracy = 1f;

                shootsound = Vars.tree.loadsound(pewpewpew.ogg)
                bullet = new BasicBulletType(6, 120){{
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
            legLengthScl = 0.5;
            legForwardScl = 0.5f;
            rippleScale = 0.5f;

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
    }};
