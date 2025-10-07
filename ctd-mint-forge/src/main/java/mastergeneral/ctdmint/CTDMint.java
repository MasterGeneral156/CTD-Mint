package mastergeneral.ctdmint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.themastergeneral.ctdcore.helpers.ModUtils;

import mastergeneral.ctdmint.item.ModItems;
import mastergeneral.ctdmint.registry.ItemRegistry;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("ctdmint")
public class CTDMint {
	
	public static CTDMint instance;
	public static final Logger LOGGER = LogManager.getLogger();
	
	public static final String MODID = "ctdmint";
	
	public CTDMint(FMLJavaModLoadingContext context)
	{
		instance = this;
        // Register the setup method for modloading
        var modBusGroup = context.getModBusGroup();

        FMLCommonSetupEvent.getBus(modBusGroup).addListener(this::setup);
        BuildCreativeModeTabContentsEvent.getBus(modBusGroup).addListener(this::fillTab);

        ItemRegistry.ITEMS.register(modBusGroup);
        MintTab.CREATIVE_MODE_TABS.register(modBusGroup);
	}
	
	private void setup(final FMLCommonSetupEvent event)
    {
		LOGGER.info("CTD Mint is launching for " + ModUtils.getLoader() + " v" + ModUtils.getLoaderVersion());
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
    		ev.accept(ModItems.bill_100000);
    		ev.accept(ModItems.bill_500000);
    		ev.accept(ModItems.bill_1000000);
    		ev.accept(ModItems.bill_5000000);
    		
    		//ev.accept(ModItems.coin_pouch);
    		//ev.accept(ModItems.wallet);
    		//ev.accept(ModItems.money_bag);
    		//ev.accept(ModItems.atm_card);
    	}
	}

}
