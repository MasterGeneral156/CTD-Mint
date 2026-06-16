/**
 *  Project:	CTD Mint 26.2
 * 	File:		mastergeneral.ctdmint.MintHelper
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

import mastergeneral.ctdmint.item.ItemCurrency;
import mastergeneral.ctdmint.registry.ItemRegistry;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class MintHelper {

	public static void givePlayerMoneyItem(Player player, float money)
	{
		Inventory inv = player.getInventory();
		float start = money;
		while (start > 0F)
		{
			if (start >= 5000000F)
			{
				inv.add(new ItemStack(ItemRegistry.bill_5000000.asItem()));
				start -= 1000000F;
			}
			else if ((start >= 1000000F) && (start < 5000000F))
			{
				inv.add(new ItemStack(ItemRegistry.bill_1000000.asItem()));
				start -= 500000F;
			}
			else if ((start >= 500000F) && (start < 1000000F))
			{
				inv.add(new ItemStack(ItemRegistry.bill_500000.asItem()));
				start -= 500000F;
			}
			else if ((start >= 100000F) && (start < 500000F))
			{
				inv.add(new ItemStack(ItemRegistry.bill_100000.asItem()));
				start -= 100000F;
			}
			else if ((start >= 50000F) && (start < 100000F))
			{
				inv.add(new ItemStack(ItemRegistry.bill_50000.asItem()));
				start -= 50000F;
			}
			else if ((start >= 10000F) && (start < 50000F))
			{
				inv.add(new ItemStack(ItemRegistry.bill_10000.asItem()));
				start -= 10000F;
			}
			else if ((start >= 5000F) && (start < 10000F))
			{
				inv.add(new ItemStack(ItemRegistry.bill_5000.asItem()));
				start -= 5000F;
			}
			else if ((start >= 1000F) && (start < 5000F))
			{
				inv.add(new ItemStack(ItemRegistry.bill_1000.asItem()));
				start -= 1000F;
			}
			else if ((start >= 500F) && (start < 1000F))
			{
				inv.add(new ItemStack(ItemRegistry.bill_500.asItem()));
				start -= 500F;
			}
			else if ((start >= 100F) && (start < 500F))
			{
				inv.add(new ItemStack(ItemRegistry.bill_100.asItem()));
				start -= 100F;
			}
			else if ((start >= 50F) && (start < 100F))
			{
				inv.add(new ItemStack(ItemRegistry.bill_50.asItem()));
				start -= 50F;
			}
			else if ((start >= 20F) && (start < 50F))
			{
				inv.add(new ItemStack(ItemRegistry.bill_20.asItem()));
				start -= 20F;
			}
			else if ((start >= 10F) && (start < 20F))
			{
				inv.add(new ItemStack(ItemRegistry.bill_10.asItem()));
				start -= 10F;
			}
			else if ((start >= 5F) && (start < 10F))
			{
				inv.add(new ItemStack(ItemRegistry.bill_5.asItem()));
				start -=  5F;
			}
			else if ((start >= 2F) && (start < 5F))
			{
				inv.add(new ItemStack(ItemRegistry.bill_2.asItem()));
				start -= 2F;
			}
			else if ((start >= 1F) && (start < 2F))
			{
				inv.add(new ItemStack(ItemRegistry.bill_1.asItem()));
				start -= 1F;
			}
			else if ((start >= 0.5F) && (start < 1F))
			{
				inv.add(new ItemStack(ItemRegistry.coin_50.asItem()));
				start -= 0.5F;
			}
			else if ((start >= 0.25F) && (start < 0.5F))
			{
				inv.add(new ItemStack(ItemRegistry.coin_25.asItem()));
				start -= 0.25F;
			}
			else if ((start >= 0.1F) && (start < 0.25F))
			{
				inv.add(new ItemStack(ItemRegistry.coin_10.asItem()));
				start -= 0.1F;
			}
			else if ((start >= 0.05F) && (start < 0.1F))
			{
				inv.add(new ItemStack(ItemRegistry.coin_5.asItem()));
				start -= 0.05F;
			}
			else if ((start >= 0.01F) && (start < 0.05F))
			{
				inv.add(new ItemStack(ItemRegistry.coin_1.asItem()));
				start -=  0.01F;
			}
		}
	}
	
	public static float currencyToFloat(ItemStack stack)
	{
		if (stack.getItem() instanceof ItemCurrency item)
			return item.returnValue();
		else
			return 0F;
	}
}
