package noobsdev.electro.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import noobsdev.electro.blocks.entity.CitrineBlockEntity;
import noobsdev.electro.blocks.entity.GemPolishingStationBlockEntity;
import noobsdev.electro.items.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CitrineBlock extends BlockWithEntity implements BlockEntityProvider {
    private static final VoxelShape SHAPE = CitrineBlock.createCuboidShape(0,0,0,16,16,16);
    private static final Random RANDOM = Random.create();

    public static final String blockId = "citrine_block";

    public CitrineBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }
    public static void dropRandomItem(World world, BlockPos pos) {

        for(int x = 1; x <= 3; x++) {
            Item[] items = new Item[] {ModItems.RUBY, Items.DIAMOND, Items.EMERALD};
            Item randomItem = items[RANDOM.nextInt(items.length)];

            // Создаем предмет
            world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY() + 1, pos.getZ(), randomItem.getDefaultStack()));
        }
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {

        if(Screen.hasShiftDown()) {
            tooltip.add(Text.literal(" "));
            tooltip.add(Text.translatable("tooltip.electro." + blockId));
            tooltip.add(Text.literal(" "));
        }else {
            tooltip.add(Text.literal(" "));
            tooltip.add(Text.translatable("tooltip.electro." + blockId + ".shift"));
            tooltip.add(Text.literal(" "));

        }
        super.appendTooltip(stack, world, tooltip, options);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CitrineBlockEntity(pos,state);
    }
}
