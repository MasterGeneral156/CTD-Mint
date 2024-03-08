package mastergeneral.ctdmint;

import mastergeneral.ctdmint.item.ItemCurrency;
import mastergeneral.ctdmint.item.ModItems;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
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
				inv.add(new ItemStack(ModItems.bill_5000000));
				start -= 1000000F;
			}
			else if ((start >= 1000000F) && (start < 5000000F))
			{
				inv.add(new ItemStack(ModItems.bill_1000000));
				start -= 500000F;
			}
			else if ((start >= 500000F) && (start < 1000000F))
			{
				inv.add(new ItemStack(ModItems.bill_500000));
				start -= 500000F;
			}
			else if ((start >= 100000F) && (start < 500000F))
			{
				inv.add(new ItemStack(ModItems.bill_100000));
				start -= 100000F;
			}
			else if ((start >= 50000F) && (start < 100000F))
			{
				inv.add(new ItemStack(ModItems.bill_50000));
				start -= 50000F;
			}
			else if ((start >= 10000F) && (start < 50000F))
			{
				inv.add(new ItemStack(ModItems.bill_10000));
				start -= 10000F;
			}
			else if ((start >= 5000F) && (start < 10000F))
			{
				inv.add(new ItemStack(ModItems.bill_5000));
				start -= 5000F;
			}
			else if ((start >= 1000F) && (start < 5000F))
			{
				inv.add(new ItemStack(ModItems.bill_1000));
				start -= 1000F;
			}
			else if ((start >= 500F) && (start < 1000F))
			{
				inv.add(new ItemStack(ModItems.bill_500));
				start -= 500F;
			}
			else if ((start >= 100F) && (start < 500F))
			{
				inv.add(new ItemStack(ModItems.bill_100));
				start -= 100F;
			}
			else if ((start >= 50F) && (start < 100F))
			{
				inv.add(new ItemStack(ModItems.bill_50));
				start -= 50F;
			}
			else if ((start >= 20F) && (start < 50F))
			{
				inv.add(new ItemStack(ModItems.bill_20));
				start -= 20F;
			}
			else if ((start >= 10F) && (start < 20F))
			{
				inv.add(new ItemStack(ModItems.bill_10));
				start -= 10F;
			}
			else if ((start >= 5F) && (start < 10F))
			{
				inv.add(new ItemStack(ModItems.bill_5));
				start -=  5F;
			}
			else if ((start >= 2F) && (start < 5F))
			{
				inv.add(new ItemStack(ModItems.bill_2));
				start -= 2F;
			}
			else if ((start >= 1F) && (start < 2F))
			{
				inv.add(new ItemStack(ModItems.bill_1));
				start -= 1F;
			}
			else if ((start >= 0.5F) && (start < 1F))
			{
				inv.add(new ItemStack(ModItems.coin_50));
				start -= 0.5F;
			}
			else if ((start >= 0.25F) && (start < 0.5F))
			{
				inv.add(new ItemStack(ModItems.coin_25));
				start -= 0.25F;
			}
			else if ((start >= 0.1F) && (start < 0.25F))
			{
				inv.add(new ItemStack(ModItems.coin_10));
				start -= 0.1F;
			}
			else if ((start >= 0.05F) && (start < 0.1F))
			{
				inv.add(new ItemStack(ModItems.coin_5));
				start -= 0.05F;
			}
			else if ((start >= 0.01F) && (start < 0.05F))
			{
				inv.add(new ItemStack(ModItems.coin_1));
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
