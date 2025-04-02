package noobsdev.electro.items.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import noobsdev.electro.util.ModTags;
import org.jetbrains.annotations.Nullable;
import java.util.List;
public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Settings setting) {
        super(setting);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        if(!context.getWorld().isClient){
            BlockPos block = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;
            for(int i =0; i <= block.getY() + 64;i++) {
                BlockState state = context.getWorld().getBlockState(block.down(i));
                BlockPos block2 = block.down(i);
                if(isValueBlock(state)) {
                    player.sendMessage(Text.literal("\n Найдена руда: §a" + state.getBlock().asItem().getName().getString() + " \n §fНа: ( §c" + block2.getX() + ", " + block2.getY() + ", " + block2.getZ() + "§f )"),false);

                    foundBlock = true;
                    break;
                }

            }
            if(!foundBlock){
                player.sendMessage(Text.literal(" \n Ничего не найдено. \n"));
            }

        }

        context.getStack().damage(1, context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS;
    }

    private boolean isValueBlock(BlockState state) {
        return state.isIn(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

        if(Screen.hasShiftDown()) {
            tooltip.add(Text.literal(" "));
            tooltip.add(Text.translatable("tooltip.electro.metal_detector"));
            tooltip.add(Text.translatable("tooltip.electro.metal_detector.2"));
            tooltip.add(Text.literal(" "));
        }else {
            tooltip.add(Text.literal(" "));
            tooltip.add(Text.translatable("tooltip.electro.metal_detector.shift"));
            tooltip.add(Text.literal(" "));

        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
