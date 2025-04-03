package noobsdev.electro.items.custom;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import noobsdev.electro.blocks.custom.CitrineBlock;
import noobsdev.electro.blocks.entity.CitrineBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CustomKey extends Item {

    private static final String itemId = "key";

    public CustomKey(Settings settings) {
        super(settings);
    }


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient) {
            BlockEntity blockEntity = context.getWorld().getBlockEntity(context.getBlockPos());
            PlayerEntity player = context.getPlayer();
            if (blockEntity instanceof CitrineBlockEntity customBlockEntity) {
                context.getStack().damage(1, context.getPlayer(),
                        playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

                World world = context.getWorld();
                BlockPos pos = context.getBlockPos();

                customBlockEntity.incrementClickCount();
                player.sendMessage(Text.literal(customBlockEntity.getClickCount() + "\n loll"));

                CitrineBlock.dropRandomItem(world, pos);

                if (customBlockEntity.getClickCount() > 3) {
                    world.breakBlock(pos, false);
                }
                // Сохраняем данные
                blockEntity.markDirty();
            }else {
                player.sendMessage(Text.literal("че за хуйня"));
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

        if (Screen.hasShiftDown()) {
            tooltip.add(Text.literal(" "));
            tooltip.add(Text.translatable("tooltip.electro." + itemId));
            tooltip.add(Text.translatable("tooltip.electro." + itemId + ".2"));
            tooltip.add(Text.literal(" "));
        } else {
            tooltip.add(Text.literal(" "));
            tooltip.add(Text.translatable("tooltip.electro." + itemId + ".shift"));
            tooltip.add(Text.literal(" "));

        }

    }
}
