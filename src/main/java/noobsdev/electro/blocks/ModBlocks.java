package noobsdev.electro.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.floatprovider.UniformFloatProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import noobsdev.electro.Electro;
import noobsdev.electro.blocks.custom.CitrineBlock;
import noobsdev.electro.blocks.custom.GemPollishingBlock;
import noobsdev.electro.blocks.custom.SoundBlock;

public class ModBlocks {

    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block OMEGA_RUBY_BLOCK = registerBlock("omega_ruby_block",
            new SoundBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.WOOD)));
    public static final Block RAW_RUBY_BLOCK = registerBlock("raw_ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE).sounds(BlockSoundGroup.AMETHYST_BLOCK)));


    public static final Block GEM_POLLISHING_STATION = registerBlock("gem_polishing_station",
            new GemPollishingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE).nonOpaque()));

    public static final Block CITRINE_BLOCK = registerBlock("citrine_block",
            new CitrineBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK, new Identifier(Electro.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Electro.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {

    }

}
