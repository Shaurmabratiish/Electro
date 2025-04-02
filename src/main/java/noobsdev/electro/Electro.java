package noobsdev.electro;

import net.fabricmc.api.ModInitializer;
import noobsdev.electro.items.ModItemGroups;
import noobsdev.electro.items.ModItems;

public class Electro implements ModInitializer {


    public static final String MOD_ID = "electro";


    @Override
    public void onInitialize() {
        ModItemGroups.registerItemGroups();
        ModItems.register();
    }
}
