package noobsdev.electro;

import net.fabricmc.api.ModInitializer;
import noobsdev.electro.blocks.ModBlocks;
import noobsdev.electro.blocks.entity.ModBlockEntities;
import noobsdev.electro.items.ModItemGroups;
import noobsdev.electro.items.ModItems;
import noobsdev.electro.screen.ModScreenHandlers;

public class Electro implements ModInitializer {


    public static final String MOD_ID = "electro";


    @Override
    public void onInitialize() {
        ModItemGroups.registerItemGroups();
        ModItems.register();
        ModBlocks.registerModBlocks();
        ModBlockEntities.registerBlocksEntities();
        ModScreenHandlers.registerScreenHandlers();
    }
}
