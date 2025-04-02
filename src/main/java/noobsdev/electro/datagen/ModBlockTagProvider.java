package noobsdev.electro.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import noobsdev.electro.blocks.ModBlocks;
import noobsdev.electro.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS)
                .add(ModBlocks.RUBY_BLOCK)
                .forceAddTag(BlockTags.GOLD_ORES)
                .forceAddTag(BlockTags.EMERALD_ORES)
                .forceAddTag(BlockTags.DIAMOND_ORES)
                .forceAddTag(BlockTags.COPPER_ORES)
                .forceAddTag(BlockTags.COAL_ORES)
                .forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.LAPIS_ORES)
                .forceAddTag(BlockTags.REDSTONE_ORES);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.RAW_RUBY_BLOCK)
                .add(ModBlocks.RUBY_BLOCK);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.OMEGA_RUBY_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RAW_RUBY_BLOCK)
                .add(ModBlocks.OMEGA_RUBY_BLOCK)
                .add(ModBlocks.RUBY_BLOCK);

    }
}
