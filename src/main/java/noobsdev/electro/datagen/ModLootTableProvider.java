package noobsdev.electro.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import noobsdev.electro.blocks.ModBlocks;
import noobsdev.electro.items.ModItems;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.OMEGA_RUBY_BLOCK);

        addDrop(ModBlocks.RAW_RUBY_BLOCK,rubyOre(ModBlocks.RAW_RUBY_BLOCK, ModItems.RAW_RUBY));

    }
    public LootTable.Builder rubyOre(Block drop, Item item) {
        return dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ItemEntry.builder(item)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider
                                .create(2.0F, 4.0F))).apply(ApplyBonusLootFunction
                                .oreDrops(Enchantments.FORTUNE))));
    }
}
