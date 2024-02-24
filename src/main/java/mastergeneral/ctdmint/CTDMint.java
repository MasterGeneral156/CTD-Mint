package mastergeneral.ctdmint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mastergeneral.ctdmint.item.ModItems;
import mastergeneral.ctdmint.registry.ItemRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("ctdmint")
public class CTDMint {
	
	public static CTDMint instance;
	public static final Logger LOGGER = LogManager.getLogger();
	
	public static final String MODID = "ctdmint";
	
	public CTDMint()
	{
		instance = this;
		IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        modbus.addListener(this::setup);
        modbus.addListener(this::fillTab);
        
        MinecraftForge.EVENT_BUS.register(this);
        ItemRegistry.ITEMS.register(modbus);
        MintTab.CREATIVE_MODE_TABS.register(modbus);
	}
	
	private void setup(final FMLCommonSetupEvent event)
    {
		LOGGER.info("CTD Mint is launching.");
    }
	
	private void fillTab(BuildCreativeModeTabContentsEvent ev)
	{
    	
    	if (ev.getTab() == MintTab.MINT_TAB.get())
    	{
    		ev.accept(ModItems.coin_1);
    		ev.accept(ModItems.coin_5);
    		ev.accept(ModItems.coin_10);
    		ev.accept(ModItems.coin_25);
    		ev.accept(ModItems.coin_50);
    		
    		ev.accept(ModItems.bill_1);
    		ev.accept(ModItems.bill_2);
    		ev.accept(ModItems.bill_5);
    		ev.accept(ModItems.bill_10);
    		ev.accept(ModItems.bill_20);
    		ev.accept(ModItems.bill_50);
    		ev.accept(ModItems.bill_100);
    		ev.accept(ModItems.bill_500);
    		ev.accept(ModItems.bill_1000);
    		ev.accept(ModItems.bill_5000);
    		ev.accept(ModItems.bill_10000);
    		ev.accept(ModItems.bill_50000);
    		
    		ev.accept(ModItems.coin_pouch);
    		ev.accept(ModItems.wallet);
    		ev.accept(ModItems.money_bag);
    		ev.accept(ModItems.atm_card);
    	}
	}

}
