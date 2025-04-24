package mastergeneral.ctdmint.block;

import com.themastergeneral.ctdcore.block.CTDBlock;
import mastergeneral.ctdmint.block.entity.SellingBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class SellingBlock extends CTDBlock implements EntityBlock {

    public SellingBlock() {
        super(Properties.of().dynamicShape());
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SellingBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide ? null : (level0, pos0, state0, blockEntity) -> ((SellingBlockEntity) blockEntity).tick();
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof SellingBlockEntity processor) {
                Containers.dropContents(level, pos, new SimpleContainer(processor.items.getStackInSlot(0)));
                level.updateNeighbourForOutputSignal(pos, this);
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        level.updateNeighbourForOutputSignal(pos, this);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return defaultBlockState();
    }
}
