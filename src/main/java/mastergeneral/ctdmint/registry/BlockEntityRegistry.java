package mastergeneral.ctdmint.registry;

import mastergeneral.ctdmint.block.MintBlocks;
import mastergeneral.ctdmint.block.entity.SellingBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityRegistry {
    public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "ctdmint");

    public static final RegistryObject<BlockEntityType<SellingBlockEntity>> selling_block = TILES.register("selling_block", () -> BlockEntityType.Builder.of(SellingBlockEntity::new, MintBlocks.selling_block).build(null));
}
