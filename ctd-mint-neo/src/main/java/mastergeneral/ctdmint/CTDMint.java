package mastergeneral.ctdmint;

import com.themastergeneral.ctdcore.helpers.ModUtils;
import mastergeneral.ctdmint.registry.ItemRegistry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.BasicItemListing;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;

import static mastergeneral.ctdmint.MintTab.CREATIVE_MODE_TABS;
import static mastergeneral.ctdmint.registry.ItemRegistry.ITEMS;

@Mod(CTDMint.MODID)
public class CTDMint {
    public static final String MODID = "ctdmint";
    public static final Logger LOGGER = LogUtils.getLogger();

    public CTDMint(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::setup);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("CTD Mint is launching for " + ModUtils.getLoader() + " v" + ModUtils.getLoaderVersion());
    }

}
