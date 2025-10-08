package mastergeneral.ctdmint;

import mastergeneral.ctdmint.registry.ItemRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MintTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CTDMint.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MINT_TAB =
            CREATIVE_MODE_TABS.register("mint_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("ctdmint.itemgroup.name"))
                    .icon(() -> new ItemStack(ItemRegistry.bill_5000000.get()))
                    .displayItems((parameters, output) -> {
                        // Add all registered items
                        ItemRegistry.ITEMS.getEntries().forEach(item -> output.accept(item.get()));

                    })
                    .build());
}
