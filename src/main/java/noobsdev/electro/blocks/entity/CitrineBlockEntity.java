package noobsdev.electro.blocks.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import noobsdev.electro.Electro;

public class CitrineBlockEntity extends BlockEntity {
    private int clickCount = 0;

    public CitrineBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CITRINE_BLOCK_ENTITY, pos, state);
    }

    public int getClickCount() {
        return clickCount;
    }

    public void incrementClickCount() {
        clickCount++;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.clickCount = nbt.getInt("ClickCount");
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("ClickCount", clickCount);
    }
}
