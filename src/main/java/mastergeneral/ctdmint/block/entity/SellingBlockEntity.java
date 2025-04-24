package mastergeneral.ctdmint.block.entity;

import mastergeneral.ctdmint.item.ModItems;
import mastergeneral.ctdmint.recipe.SellingRecipe;
import mastergeneral.ctdmint.registry.BlockEntityRegistry;
import mastergeneral.ctdmint.registry.RecipeRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.util.*;

public class SellingBlockEntity extends BlockEntity {

    public final ItemStackHandler items = new ItemStackHandler(1);
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> items);
    private int progress = 0;
    private static final int PROCESS_TIME = 30;

    public SellingBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.selling_block.get(), pos, state);
    }

    public void tick() {
        if (level == null || level.isClientSide()) return;

        ItemStack input = items.getStackInSlot(0);
        if (input.isEmpty()) {
            progress = 0;
            return;
        }

        Optional<SellingRecipe> recipeOpt = findRecipe(input);
        if (recipeOpt.isEmpty()) {
            progress = 0;
            return;
        }

        SellingRecipe recipe = recipeOpt.get();
        List<ItemStack> outputs = calculateCurrencyOutput(recipe.getValue());

        if (!canOutputToTopContainer(outputs)) {
            progress = 0;
            return;
        }

        progress++;
        if (progress >= PROCESS_TIME) {
            items.extractItem(0, 1, false);
            outputToTopContainer(outputs);
            progress = 0;
        }
    }

    private Optional<SellingRecipe> findRecipe(ItemStack input) {
        return level.getRecipeManager()
                .getRecipeFor(RecipeRegistry.SELLING_TYPE.get(), new SimpleContainer(items.getStackInSlot(0)), level);
    }

    private boolean canOutputToTopContainer(List<ItemStack> outputs) {
        BlockEntity above = level.getBlockEntity(worldPosition.above());
        if (above == null) return false;

        LazyOptional<IItemHandler> cap = above.getCapability(ForgeCapabilities.ITEM_HANDLER, Direction.DOWN);
        if (!cap.isPresent()) return false;

        IItemHandler handler = cap.orElse(null);
        for (ItemStack out : outputs) {
            ItemStack remaining = tryInsertStack(handler, out.copy(), true);
            if (!remaining.isEmpty()) return false;
        }
        return true;
    }

    private void outputToTopContainer(List<ItemStack> outputs) {
        BlockEntity above = level.getBlockEntity(worldPosition.above());
        if (above == null) return;

        LazyOptional<IItemHandler> cap = above.getCapability(ForgeCapabilities.ITEM_HANDLER, Direction.DOWN);
        if (!cap.isPresent()) return;

        IItemHandler handler = cap.orElse(null);
        for (ItemStack out : outputs) {
            tryInsertStack(handler, out.copy(), false);
        }
    }

    private ItemStack tryInsertStack(IItemHandler handler, ItemStack stack, boolean simulate) {
        for (int i = 0; i < handler.getSlots(); i++) {
            stack = handler.insertItem(i, stack, simulate);
            if (stack.isEmpty()) break;
        }
        return stack;
    }

    private List<ItemStack> calculateCurrencyOutput(float value) {
        List<ItemStack> output = new ArrayList<>();

        Map<Float, Item> denominations = new HashMap<>();
        denominations.put(0.01f, ModItems.coin_1.asItem());
        denominations.put(0.05f, ModItems.coin_5.asItem());
        denominations.put(0.1f, ModItems.coin_10.asItem());
        denominations.put(0.25f, ModItems.coin_25.asItem());
        denominations.put(0.5f, ModItems.coin_50.asItem());
        denominations.put(1f, ModItems.bill_1.asItem());
        denominations.put(2f, ModItems.bill_2.asItem());
        denominations.put(5f, ModItems.bill_5.asItem());
        denominations.put(10f, ModItems.bill_10.asItem());
        denominations.put(20f, ModItems.bill_20.asItem());
        denominations.put(50f, ModItems.bill_50.asItem());
        denominations.put(100f, ModItems.bill_100.asItem());
        denominations.put(500f, ModItems.bill_500.asItem());
        denominations.put(1000f, ModItems.bill_1000.asItem());
        denominations.put(5000f, ModItems.bill_5000.asItem());
        denominations.put(10000f, ModItems.bill_10000.asItem());
        denominations.put(50000f, ModItems.bill_50000.asItem());
        denominations.put(100000f, ModItems.bill_100000.asItem());
        denominations.put(500000f, ModItems.bill_500000.asItem());
        denominations.put(1000000f, ModItems.bill_1000000.asItem());
        denominations.put(5000000f, ModItems.bill_5000000.asItem());

        // Sort the denominations from largest to smallest
        List<Map.Entry<Float, Item>> sorted = new ArrayList<>(denominations.entrySet());
        sorted.sort((a, b) -> Float.compare(b.getKey(), a.getKey())); // Descending

        for (Map.Entry<Float, Item> entry : sorted) {
            while (value >= entry.getKey()) {
                output.add(new ItemStack(entry.getValue()));
                value -= entry.getKey();
            }
        }

        return output;
    }


    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        items.deserializeNBT(tag.getCompound("items"));
        progress = tag.getInt("progress");
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("items", items.serializeNBT());
        tag.putInt("progress", progress);
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return handler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        handler.invalidate();
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket()
    {
        return ClientboundBlockEntityDataPacket.create(this);
    }

}

