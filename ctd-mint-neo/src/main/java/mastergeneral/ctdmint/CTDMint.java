/**
 *  Project:	CTD Mint 26.1
 * 	File:		mastergeneral.ctdmint.CTDMint
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

import com.themastergeneral.ctdcore.helpers.ModUtils;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

import static mastergeneral.ctdmint.MintTab.CREATIVE_MODE_TABS;
import static mastergeneral.ctdmint.registry.ItemRegistry.ITEMS;

@Mod(CTDMint.MODID)
public class CTDMint {
    public static final String MODID = "ctdmint";
    public static final Logger LOGGER = LogUtils.getLogger();

    public CTDMint(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::setup);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("CTD Mint is launching for " + ModUtils.getLoader() + " v" + ModUtils.getLoaderVersion());
    }

}
