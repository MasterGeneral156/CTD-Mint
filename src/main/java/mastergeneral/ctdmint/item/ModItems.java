package mastergeneral.ctdmint.item;

public class ModItems {

	public static ItemCurrency coin_1 = new ItemCurrency(0.01F);
	public static ItemCurrency coin_5 = new ItemCurrency(0.05F);
	public static ItemCurrency coin_10 = new ItemCurrency(0.1F);
	public static ItemCurrency coin_25 = new ItemCurrency(0.25F);
	public static ItemCurrency coin_50 = new ItemCurrency(0.5F);
	
	public static ItemCurrency bill_1 = new ItemCurrency(1F);
	public static ItemCurrency bill_2 = new ItemCurrency(2F);
	public static ItemCurrency bill_5 = new ItemCurrency(5F);
	public static ItemCurrency bill_10 = new ItemCurrency(10F);
	public static ItemCurrency bill_20 = new ItemCurrency(20F);
	public static ItemCurrency bill_50 = new ItemCurrency(50F);
	public static ItemCurrency bill_100 = new ItemCurrency(100F);
	public static ItemCurrency bill_500 = new ItemCurrency(500F);
	public static ItemCurrency bill_1000 = new ItemCurrency(1000F);
	public static ItemCurrency bill_5000 = new ItemCurrency(5000F);
	public static ItemCurrency bill_10000 = new ItemCurrency(10000F);
	public static ItemCurrency bill_50000 = new ItemCurrency(50000F);
	public static ItemCurrency bill_100000 = new ItemCurrency(100000F);
	public static ItemCurrency bill_500000 = new ItemCurrency(500000F);
	public static ItemCurrency bill_1000000 = new ItemCurrency(1000000F);
	
	public static ItemStorageCard coin_pouch = new ItemStorageCard(12.75F);
	public static ItemStorageCard wallet = new ItemStorageCard(500F);
	public static ItemStorageCard money_bag = new ItemStorageCard(7500F);
	public static ItemStorageCard atm_card = new ItemStorageCard((float) Short.MAX_VALUE);
}
