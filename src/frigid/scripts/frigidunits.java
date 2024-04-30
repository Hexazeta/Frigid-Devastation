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
            constructor = mechUnit::create;
            aiController = GroundAI::new;

            speed = 0.5f;
            drag = 0.11f;
            hitSize = 24f;
            rotateSpeed = 3f;
            health = 5040;
            armor = 10f;

            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit - 1f;
            targetAir = false;
            researchCostMultiplier = 0f;

            outlineColor = Color.valueOf("2b2626");

            weapons.add(new Weapon("ballistic-cannon"){{
                x = 12;
                y = 0;
                alternate = true;
                mirror = true;
                reload = 28f;

                shootSound = Vars.tree.loadSound("pew");
                inaccuracy = 1f;
                bullet = new BasicBulletType(4, 15){{
                    width = 8;
                    height = 16;
                    }};
                }});
            }};
        }};
