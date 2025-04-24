package mastergeneral.ctdmint.registry;

import mastergeneral.ctdmint.block.MintBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "ctdmint");

    public static final RegistryObject<Block> selling_block = BLOCKS.register("selling_block", () -> MintBlocks.selling_block);
}
