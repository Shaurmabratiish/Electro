package noobsdev.electro.items;


import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import noobsdev.electro.Electro;
import noobsdev.electro.blocks.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(Electro.MOD_ID, "ruby"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby")).icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {

        entries.add(ModItems.RUBY);
        entries.add(ModBlocks.RUBY_BLOCK);
        entries.add(ModBlocks.OMEGA_RUBY_BLOCK);
        entries.add(ModItems.RAW_RUBY);
        entries.add(ModBlocks.RAW_RUBY_BLOCK);

        entries.add(ModItems.METAL);

    }).build());


    public static void registerItemGroups() {

    }
}
