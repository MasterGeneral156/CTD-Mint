package mastergeneral.ctdmint.item;

import mastergeneral.ctdmint.registry.ItemRegistry;

public class ModItems {

	public static ItemCurrency coin_1 = new ItemCurrency(ItemRegistry.ITEMS.key("coin_1"), 0.01F);
	public static ItemCurrency coin_5 = new ItemCurrency(ItemRegistry.ITEMS.key("coin_5"), 0.05F);
	public static ItemCurrency coin_10 = new ItemCurrency(ItemRegistry.ITEMS.key("coin_10"), 0.1F);
	public static ItemCurrency coin_25 = new ItemCurrency(ItemRegistry.ITEMS.key("coin_25"), 0.25F);
	public static ItemCurrency coin_50 = new ItemCurrency(ItemRegistry.ITEMS.key("coin_50"), 0.5F);
	
	public static ItemCurrency bill_1 = new ItemCurrency(ItemRegistry.ITEMS.key("bill_1"), 1F);
	public static ItemCurrency bill_2 = new ItemCurrency(ItemRegistry.ITEMS.key("bill_2"), 2F);
	public static ItemCurrency bill_5 = new ItemCurrency(ItemRegistry.ITEMS.key("bill_5"), 5F);
	public static ItemCurrency bill_10 = new ItemCurrency(ItemRegistry.ITEMS.key("bill_10"), 10F);
	public static ItemCurrency bill_20 = new ItemCurrency(ItemRegistry.ITEMS.key("bill_20"), 20F);
	public static ItemCurrency bill_50 = new ItemCurrency(ItemRegistry.ITEMS.key("bill_50"), 50F);
	public static ItemCurrency bill_100 = new ItemCurrency(ItemRegistry.ITEMS.key("bill_100"), 100F);
	public static ItemCurrency bill_500 = new ItemCurrency(ItemRegistry.ITEMS.key("bill_500"), 500F);
	public static ItemCurrency bill_1000 = new ItemCurrency(ItemRegistry.ITEMS.key("bill_1000"), 1000F);
	public static ItemCurrency bill_5000 = new ItemCurrency(ItemRegistry.ITEMS.key("bill_5000"), 5000F);
	public static ItemCurrency bill_10000 = new ItemCurrency(ItemRegistry.ITEMS.key("bill_10000"), 10000F);
	public static ItemCurrency bill_50000 = new ItemCurrency(ItemRegistry.ITEMS.key("bill_50000"), 50000F);
	public static ItemCurrency bill_100000 = new ItemCurrency(ItemRegistry.ITEMS.key("bill_100000"), 100000F);
	public static ItemCurrency bill_500000 = new ItemCurrency(ItemRegistry.ITEMS.key("bill_500000"), 500000F);
	public static ItemCurrency bill_1000000 = new ItemCurrency(ItemRegistry.ITEMS.key("bill_1000000"), 1000000F);
	public static ItemCurrency bill_5000000 = new ItemCurrency(ItemRegistry.ITEMS.key("bill_5000000"), 5000000F);
	
	//public static ItemStorageCard coin_pouch = new ItemStorageCard(12.75F);
	//public static ItemStorageCard wallet = new ItemStorageCard(500F);
	//public static ItemStorageCard money_bag = new ItemStorageCard(7500F);
	//public static ItemStorageCard atm_card = new ItemStorageCard((float) Short.MAX_VALUE);
}
