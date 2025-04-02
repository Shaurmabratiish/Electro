package noobsdev.electro.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import noobsdev.electro.blocks.ModBlocks;
import noobsdev.electro.items.ModItems;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {

    private static List<ItemConvertible> SMELT = List.of(ModItems.RAW_RUBY,
            ModBlocks.RAW_RUBY_BLOCK);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        offerSmelting(recipeExporter, SMELT, RecipeCategory.MISC, ModItems.RUBY,
                0.7f,200, "ruby");

    }
}
