package mastergeneral.ctdmint.item;

import com.themastergeneral.ctdcore.item.CTDItem;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ItemCurrency extends CTDItem {

	public float value;
	
	public ItemCurrency(ResourceKey<Item> key, float value)
	{
		super(key, new Properties().fireResistant());
		this.value = value;
	}
	
	public float returnValue()
	{
		return value;
	}
}
