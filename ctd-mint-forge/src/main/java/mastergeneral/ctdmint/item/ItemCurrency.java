package mastergeneral.ctdmint.item;

import com.themastergeneral.ctdcore.item.CTDItem;

public class ItemCurrency extends CTDItem {

	public float value;
	
	public ItemCurrency(float value) 
	{
		super(new Properties().fireResistant());
		this.value = value;
	}
	
	public float returnValue()
	{
		return value;
	}
}
