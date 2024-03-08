package mastergeneral.ctdmint.registry;

import mastergeneral.ctdmint.CTDMint;
import mastergeneral.ctdmint.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CTDMint.MODID);
	
	//Coins
	public static final RegistryObject<Item> coin_1 = ITEMS.register("coin_1", () -> ModItems.coin_1);
	public static final RegistryObject<Item> coin_5 = ITEMS.register("coin_5", () -> ModItems.coin_5);
	public static final RegistryObject<Item> coin_10 = ITEMS.register("coin_10", () -> ModItems.coin_10);
	public static final RegistryObject<Item> coin_25 = ITEMS.register("coin_25", () -> ModItems.coin_25);
	public static final RegistryObject<Item> coin_50 = ITEMS.register("coin_50", () -> ModItems.coin_50);
	
	//Bills
	public static final RegistryObject<Item> bill_1 = ITEMS.register("bill_1", () -> ModItems.bill_1);
	public static final RegistryObject<Item> bill_2 = ITEMS.register("bill_2", () -> ModItems.bill_2);
	public static final RegistryObject<Item> bill_5 = ITEMS.register("bill_5", () -> ModItems.bill_5);
	public static final RegistryObject<Item> bill_10 = ITEMS.register("bill_10", () -> ModItems.bill_10);
	public static final RegistryObject<Item> bill_20 = ITEMS.register("bill_20", () -> ModItems.bill_20);
	public static final RegistryObject<Item> bill_50 = ITEMS.register("bill_50", () -> ModItems.bill_50);
	public static final RegistryObject<Item> bill_100 = ITEMS.register("bill_100", () -> ModItems.bill_100);
	public static final RegistryObject<Item> bill_500 = ITEMS.register("bill_500", () -> ModItems.bill_500);
	public static final RegistryObject<Item> bill_1000 = ITEMS.register("bill_1000", () -> ModItems.bill_1000);
	public static final RegistryObject<Item> bill_5000 = ITEMS.register("bill_5000", () -> ModItems.bill_5000);
	public static final RegistryObject<Item> bill_10000 = ITEMS.register("bill_10000", () -> ModItems.bill_10000);
	public static final RegistryObject<Item> bill_50000 = ITEMS.register("bill_50000", () -> ModItems.bill_50000);
	public static final RegistryObject<Item> bill_100000 = ITEMS.register("bill_100000", () -> ModItems.bill_100000);
	public static final RegistryObject<Item> bill_500000 = ITEMS.register("bill_500000", () -> ModItems.bill_500000);
	public static final RegistryObject<Item> bill_1000000 = ITEMS.register("bill_1000000", () -> ModItems.bill_1000000);
	public static final RegistryObject<Item> bill_5000000 = ITEMS.register("bill_5000000", () -> ModItems.bill_5000000);
	
	//Money Storage
	public static final RegistryObject<Item> wallet = ITEMS.register("wallet", () -> ModItems.wallet);
	public static final RegistryObject<Item> atm_card = ITEMS.register("atm_card", () -> ModItems.atm_card);
	public static final RegistryObject<Item> money_bag = ITEMS.register("money_bag", () -> ModItems.money_bag);
	public static final RegistryObject<Item> coin_pouch = ITEMS.register("coin_pouch", () -> ModItems.coin_pouch);
}
