package mastergeneral.ctdmint.item;

import java.util.List;

import javax.annotation.Nullable;

import com.themastergeneral.ctdcore.helpers.ModUtils;
import com.themastergeneral.ctdcore.helpers.ServerHelper;
import com.themastergeneral.ctdcore.item.CTDItem;

import mastergeneral.ctdmint.MintHelper;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemStorageCard extends CTDItem 
{
	public float stored;
	
	public ItemStorageCard(float stored) 
	{
		super(new Properties().stacksTo(1).fireResistant());
		this.stored = stored;
	}
	
	@Override
	public void onCraftedBy(ItemStack stack, Level worldIn, Player playerIn) 
	{
		if (!stack.hasTag())
		{
			CompoundTag compoundnbt = new CompoundTag();
			compoundnbt.putFloat("currentStored", 0);
			compoundnbt.putFloat("maxStored", stored);
			stack.setTag(compoundnbt);
		}
	}
	
	public void withdrawMoney(Player player, ItemStack stack, float remove)
	{
		MintHelper.givePlayerMoneyItem(player, remove);
		removeMoney(stack, remove);
	}
	
	public void depositMoney(Player player, ItemStack stack, float add)
	{
		addMoney(stack, add);
	}
	
	protected void removeMoney(ItemStack stackIn, float remove)
	{
		float current = getCurrentMoney(stackIn);
		float max = getMaxMoney(stackIn);
		if ((current - remove) >= 0)
		{
			CompoundTag compoundnbt = new CompoundTag();
			float toset = current - remove;
			compoundnbt.putFloat("currentStored", toset);
			compoundnbt.putFloat("maxStored", max);
			stackIn.setTag(compoundnbt);
		}
	}
	
	protected void addMoney(ItemStack stackIn, float add)
	{
		float current = getCurrentMoney(stackIn);
		float max = getMaxMoney(stackIn);
		if ((current + add) <= max)
		{
			CompoundTag compoundnbt = new CompoundTag();
			float toset = current + add;
			compoundnbt.putFloat("currentStored", toset);
			compoundnbt.putFloat("maxStored", max);
			stackIn.setTag(compoundnbt);
		}
	}
	
	protected ItemCurrency getBiggestBill(ItemStack stack)
	{
		if (stack.getItem() instanceof ItemStorageCard)
		{
			ItemStorageCard item = (ItemStorageCard) stack.getItem();
			float max = item.getCurrentMoney(stack);
			if (max >= 1000000F)
				return ModItems.bill_1000000;
			else if ((max >= 500000F) && (max < 1000000F))
				return ModItems.bill_500000;
			else if ((max >= 100000F) && (max < 500000F))
				return ModItems.bill_100000;
			else if ((max >= 50000F) && (max < 100000F))
				return ModItems.bill_50000;
			else if ((max >= 10000F) && (max < 50000F))
				return ModItems.bill_10000;
			else if ((max >= 5000F) && (max < 10000F))
				return ModItems.bill_5000;
			else if ((max >= 1000F) && (max < 5000F))
				return ModItems.bill_1000;
			else if ((max >= 500F) && (max < 1000F))
				return ModItems.bill_500;
			else if ((max >= 100F) && (max < 500F))
				return ModItems.bill_100;
			else if ((max >= 50F) && (max < 100F))
				return ModItems.bill_50;
			else if ((max >= 20F) && (max < 50F))
				return ModItems.bill_20;
			else if ((max >= 10F) && (max < 20F))
				return ModItems.bill_10;
			else if ((max >= 5F) && (max < 10F))
				return ModItems.bill_5;
			else if ((max >= 2F) && (max < 10F))
				return ModItems.bill_2;
			else if ((max >= 1F) && (max < 2F))
				return ModItems.bill_1;
			else if ((max >= 0.5F) && (max < 1F))
				return ModItems.coin_50;
			else if ((max >= 0.25F) && (max < 0.5F))
				return ModItems.coin_25;
			else if ((max >= 0.1F) && (max < 0.25F))
				return ModItems.coin_10;
			else if ((max >= 0.05F) && (max < 0.1F))
				return ModItems.coin_5;
			else if ((max >= 0.01F) && (max < 0.05F))
				return ModItems.coin_1;
			else
				return null;
		}
		else
			return null;
	}
	
	protected float getCurrentMoney(ItemStack stackIn)
	{
		if (stackIn.hasTag())
		{
			return (stackIn.getTag().getFloat("currentStored") >= 0.01F) ? stackIn.getTag().getFloat("currentStored") : 0F;
		}
		else
		{
			return 0;
		}
	}
	
	protected float getMaxMoney(ItemStack stackIn)
	{
		if (stackIn.hasTag())
		{
			return stackIn.getTag().getFloat("maxStored");
		}
		else
		{
			return 0;
		}
	}
	
	@Override
	public void inventoryTick(ItemStack stack, Level worldIn, Entity entityIn, int itemSlot, boolean isSelected) 
	{
		if (!stack.hasTag())
		{
			CompoundTag compoundnbt = new CompoundTag();
			compoundnbt.putFloat("currentStored", 0);
			compoundnbt.putFloat("maxStored", stored);
			stack.setTag(compoundnbt);
		}
	}
	
	@Override
	public boolean isBarVisible(ItemStack stack)
	{
		return true;
	}
	
	@Override
    public int getBarWidth(ItemStack stack) 
	{
		return Math.round(13.0F - (getMaxMoney(stack) - getCurrentMoney(stack)) * 13.0F / getMaxMoney(stack));
	}
	
	public int getBarColor(ItemStack stack) 
	{
	      float stackMaxDamage = getMaxMoney(stack);
	      float f = Math.max(0.0F, (stackMaxDamage - (float) (stackMaxDamage - getCurrentMoney(stack))) / stackMaxDamage);
	      return Mth.hsvToRgb(f / 3.0F, 1.0F, 1.0F);
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) 
	{
		ItemStack stack = playerIn.getMainHandItem();
		ItemStack offhand = playerIn.getOffhandItem();
		if (ServerHelper.isServerLevel(worldIn))
		{
			if (handIn == InteractionHand.MAIN_HAND)
			{
				//Remove currency when crouching without an item in offhand
				if (offhand.isEmpty() && playerIn.isCrouching())
				{
					ItemStorageCard card = (ItemStorageCard) stack.getItem();
					if (card.getCurrentMoney(stack) > 0F)
					{
						ItemCurrency giftedBill = getBiggestBill(stack);
						withdrawMoney(playerIn, stack, giftedBill.returnValue());
						playerIn.getCooldowns().addCooldown(this, 2);
						return InteractionResultHolder.success(stack);
					}
					else
						return InteractionResultHolder.fail(stack);
				}
				//add money
				else if (playerIn.getOffhandItem().getItem() instanceof ItemCurrency)
				{
					ItemCurrency currency = (ItemCurrency) offhand.getItem();
					if ((currency.returnValue() > 0F) && (currency.returnValue() != Float.NaN))
					{
						if (currency.returnValue() + getCurrentMoney(stack) <= getMaxMoney(stack))
						{
							addMoney(stack, currency.returnValue());
							playerIn.getOffhandItem().shrink(1);
							playerIn.getCooldowns().addCooldown(this, 2);
							return InteractionResultHolder.success(stack);
						}
						else
							return InteractionResultHolder.fail(stack);
					}
					else
						return InteractionResultHolder.fail(stack);
				}
			}
		}
		return InteractionResultHolder.fail(stack);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) 
	{
		if (!Screen.hasShiftDown())
			tooltip.add(ModUtils.displayString("Stored: $" + ModUtils.returnShortenedNumber(getCurrentMoney(stack)) + " / $" + ModUtils.returnShortenedNumber(getMaxMoney(stack))));
		else
		{
			float multi = getCurrentMoney(stack) * 100;
			long rounded = Math.round(multi);
			float display = (float) rounded / 100;
			tooltip.add(ModUtils.displayString("Stored: $" + display + " / $" + getMaxMoney(stack)));
		}
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
	}
}
