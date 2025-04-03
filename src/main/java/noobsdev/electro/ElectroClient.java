package noobsdev.electro;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import noobsdev.electro.screen.GemPolishingScreen;
import noobsdev.electro.screen.ModScreenHandlers;


public class ElectroClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        HandledScreens.register(ModScreenHandlers.GEM_POLISHING_SCREEN_HANDLER, GemPolishingScreen::new);

    }

}