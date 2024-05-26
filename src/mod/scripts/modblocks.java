package mod.scripts;

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

public class modblocks {

    public static Block
        //funny ahh crafters
        siliconFoundry,plastaniumMultiCompressor,pyratiteMultiMixer;

    public static void load(){

        siliconFoundry = new GenericCrafter("silicon-foundry"){{
            requirements(Category.crafting,
                    with( Items.graphite, 100));
            squareSprite = false;
            liquidCapacity = 20;
            itemCapacity = 90;
            craftTime = 225f;
            size = 3;
            hasPower = true;
            hasLiquids = true;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;
            consumeItems(with(Items.sand, 18, Items.pyratite, 4, Items.graphite, 4));
            consumePower(5f);
            consumeLiquid(Liquids.water, 1f / 6f);
            outputItem = new ItemStack(Items.silicon, 32);
        }};

        plastaniumMultiCompressor = new GenericCrafter("plastanium-multi-compressor"){{
            requirements(Category.crafting,
                    with( Items.graphite, 100));
            squareSprite = false;
            liquidCapacity = 100;
            itemCapacity = 30;
            craftTime = 45f;
            size = 3;
            hasPower = true;
            hasLiquids = true;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;
            consumeItems(with(Items.titanium, 3));
            consumePower(5f);
            consumeLiquid(Liquids.oil, 5f / 12f);
            outputItem = new ItemStack(Items.plastanium, 2);
        }};

        pyratiteMultiMixer= new GenericCrafter("plastanium-multi-mixer"){{
            requirements(Category.crafting,
                    with( Items.graphite, 100));
            squareSprite = false;
            itemCapacity = 30;
            craftTime = 45f;
            size = 3;
            hasPower = true;
            hasLiquids = true;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;
            consumeItems(with(Items.titanium, 3));
            consumePower(5f);
            outputItem = new ItemStack(Items.plastanium, 2);
        }};
    }
}
