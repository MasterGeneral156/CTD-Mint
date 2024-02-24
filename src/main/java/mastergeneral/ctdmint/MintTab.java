package mastergeneral.ctdmint;

import mastergeneral.ctdmint.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MintTab {

	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CTDMint.MODID);
	
	public static final RegistryObject<CreativeModeTab> MINT_TAB = CREATIVE_MODE_TABS.register("mint_tab", () -> CreativeModeTab.builder()
			.withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ModItems.bill_50000.getDefaultInstance())
            .title(Component.translatable("ctdmint.itemgroup.name"))
            .build());
	
}
