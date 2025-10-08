package mastergeneral.ctdmint.item;

import com.themastergeneral.ctdcore.item.CTDItem;

public class ItemCurrency extends CTDItem {

	public float value;
	
	public ItemCurrency(float value, Properties prop)
	{
		super(prop.fireResistant());
		this.value = value;
	}
	
	public float returnValue()
	{
		return value;
	}
}
