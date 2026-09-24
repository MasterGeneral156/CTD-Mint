/**
 *  Project:	CTD Mint 26.2
 * 	File:		mastergeneral.ctdmint.MintTab
 * 	Author:		TheMasterGeneral
 * 	Website: 	https://github.com/MasterGeneral156/CTD-Mint
 * 	License:	MIT License
 *
 * 				Copyright (c) 2026 TheMasterGeneral
 *
 * 				Permission is hereby granted, free of charge, to any person obtaining a copy
 * 				of this software and associated documentation files (the "Software"), to deal
 * 				in the Software without restriction, including without limitation the rights
 * 				to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * 				copies of the Software, and to permit persons to whom the Software is
 * 				furnished to do so, subject to the following conditions:
 *
 * 				The above copyright notice and this permission notice shall be included in all
 * 				copies or substantial portions of the Software.
 *
 * 				THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * 				IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * 				FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * 				AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * 				LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * 				OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * 				SOFTWARE.
 */
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
