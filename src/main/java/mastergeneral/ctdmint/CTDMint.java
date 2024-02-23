package mastergeneral.ctdmint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mastergeneral.ctdmint.registry.ItemRegistry;
import net.minecraftforge.common.MinecraftForge;
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
        
        MinecraftForge.EVENT_BUS.register(this);
        ItemRegistry.ITEMS.register(modbus);
	}
	
	private void setup(final FMLCommonSetupEvent event)
    {
		LOGGER.info("CTD Mint is launching.");
    }

}
