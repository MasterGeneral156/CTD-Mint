/**
 *  Project:	CTD Mint 26.1
 * 	File:		mastergeneral.ctdmint.registry.ItemRegistry
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
package mastergeneral.ctdmint.registry;

import mastergeneral.ctdmint.item.ItemCurrency;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static mastergeneral.ctdmint.CTDMint.MODID;

public class ItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
	
	//Coins
    public static final DeferredItem<Item> coin_1 = ITEMS.registerItem("coin_1", props -> new ItemCurrency(0.01f, props));
    public static final DeferredItem<Item> coin_5 = ITEMS.registerItem("coin_5", props -> new ItemCurrency(0.05f, props));
    public static final DeferredItem<Item> coin_10 = ITEMS.registerItem("coin_10", props -> new ItemCurrency(0.1f, props));
    public static final DeferredItem<Item> coin_25 = ITEMS.registerItem("coin_25", props -> new ItemCurrency(0.25f, props));
    public static final DeferredItem<Item> coin_50 = ITEMS.registerItem("coin_50", props -> new ItemCurrency(0.5f, props));
	
	//Bills
    public static final DeferredItem<Item> bill_1 = ITEMS.registerItem("bill_1", props -> new ItemCurrency(1f, props));
    public static final DeferredItem<Item> bill_2 = ITEMS.registerItem("bill_2", props -> new ItemCurrency(2f, props));
    public static final DeferredItem<Item> bill_5 = ITEMS.registerItem("bill_5", props -> new ItemCurrency(5f, props));
    public static final DeferredItem<Item> bill_10 = ITEMS.registerItem("bill_10", props -> new ItemCurrency(10f, props));
    public static final DeferredItem<Item> bill_20 = ITEMS.registerItem("bill_20", props -> new ItemCurrency(20f, props));
    public static final DeferredItem<Item> bill_50 = ITEMS.registerItem("bill_50", props -> new ItemCurrency(50f, props));
    public static final DeferredItem<Item> bill_100 = ITEMS.registerItem("bill_100", props -> new ItemCurrency(100f, props));
    public static final DeferredItem<Item> bill_500 = ITEMS.registerItem("bill_500", props -> new ItemCurrency(500f, props));
    public static final DeferredItem<Item> bill_1000 = ITEMS.registerItem("bill_1000", props -> new ItemCurrency(1000f, props));
    public static final DeferredItem<Item> bill_5000 = ITEMS.registerItem("bill_5000", props -> new ItemCurrency(5000f, props));
    public static final DeferredItem<Item> bill_10000 = ITEMS.registerItem("bill_10000", props -> new ItemCurrency(10000f, props));
    public static final DeferredItem<Item> bill_50000 = ITEMS.registerItem("bill_50000", props -> new ItemCurrency(50000f, props));
    public static final DeferredItem<Item> bill_100000 = ITEMS.registerItem("bill_100000", props -> new ItemCurrency(100000f, props));
    public static final DeferredItem<Item> bill_500000 = ITEMS.registerItem("bill_500000", props -> new ItemCurrency(500000f, props));
    public static final DeferredItem<Item> bill_1000000 = ITEMS.registerItem("bill_1000000", props -> new ItemCurrency(1000000f, props));
    public static final DeferredItem<Item> bill_5000000 = ITEMS.registerItem("bill_5000000", props -> new ItemCurrency(5000000f, props));

	
	//Money Storage
	//public static final RegistryObject<Item> wallet = ITEMS.register("wallet", () -> ModItems.wallet);
	//public static final RegistryObject<Item> atm_card = ITEMS.register("atm_card", () -> ModItems.atm_card);
	//public static final RegistryObject<Item> money_bag = ITEMS.register("money_bag", () -> ModItems.money_bag);
	//public static final RegistryObject<Item> coin_pouch = ITEMS.register("coin_pouch", () -> ModItems.coin_pouch);
}
