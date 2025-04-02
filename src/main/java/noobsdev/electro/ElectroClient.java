package noobsdev.electro;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;

public class ElectroClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

    }
    public static Boolean screen() {
        return MinecraftClient.getInstance().options.sneakKey.isPressed();
    }
}