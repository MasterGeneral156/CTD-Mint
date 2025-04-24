package mastergeneral.ctdmint.block.entity;

import mastergeneral.ctdmint.block.MintBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class MintBlockEntities {
    public static final BlockEntityType<SellingBlockEntity> SELLING_BLOCK = BlockEntityType.Builder.of(SellingBlockEntity::new, MintBlocks.selling_block).build(null);
}
