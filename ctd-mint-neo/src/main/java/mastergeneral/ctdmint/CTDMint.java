package mastergeneral.ctdmint;

import com.themastergeneral.ctdcore.helpers.ModUtils;
import mastergeneral.ctdmint.registry.ItemRegistry;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
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

        NeoForge.EVENT_BUS.addListener(this::onVillagerTrades);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("CTD Mint is launching for " + ModUtils.getLoader() + " v" + ModUtils.getLoaderVersion());
    }

    @SubscribeEvent
    public void onVillagerTrades(VillagerTradesEvent event)
    {
        if (event.getType() != VillagerProfession.NONE)
        {
            event.getTrades().get(1).add(new BasicItemListing(
                    new ItemStack(Items.GOLD_NUGGET, 1),
                    new ItemStack(ItemRegistry.bill_2.get(), 10),
                    10, 20, 1F
            ));

            event.getTrades().get(1).add(new BasicItemListing(
                    new ItemStack(Items.GOLD_INGOT, 1),
                    new ItemStack(ItemRegistry.bill_50.get(), 4),
                    5, 20, 1F
            ));

            event.getTrades().get(1).add(new BasicItemListing(
                    new ItemStack(Items.GOLD_BLOCK, 1),
                    new ItemStack(ItemRegistry.bill_500.get(), 4),
                    1, 20, 1F
            ));

            //Iron
            event.getTrades().get(1).add(new BasicItemListing(
                    new ItemStack(Items.IRON_NUGGET, 1),
                    new ItemStack(ItemRegistry.bill_1.get(), 10),
                    10, 20, 1F
            ));


            event.getTrades().get(1).add(new BasicItemListing(
                    new ItemStack(Items.IRON_INGOT, 1),
                    new ItemStack(ItemRegistry.bill_10.get(), 10),
                    5, 20, 1F
            ));


            event.getTrades().get(1).add(new BasicItemListing(
                    new ItemStack(Items.IRON_BLOCK, 1),
                    new ItemStack(ItemRegistry.bill_100.get(), 10),
                    1, 20, 1F
            ));

            //Emerald
            event.getTrades().get(1).add(new BasicItemListing(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ItemRegistry.bill_10.get(), 5),
                    5, 20, 1F
            ));


            event.getTrades().get(1).add(new BasicItemListing(
                    new ItemStack(Items.EMERALD_BLOCK, 1),
                    new ItemStack(ItemRegistry.bill_50.get(), 10),
                    2, 20, 1F
            ));

            //Diamond
            event.getTrades().get(1).add(new BasicItemListing(
                    new ItemStack(Items.DIAMOND, 1),
                    new ItemStack(ItemRegistry.bill_20.get(), 2),
                    8, 20, 1F
            ));


            event.getTrades().get(1).add(new BasicItemListing(
                    new ItemStack(Items.DIAMOND_BLOCK, 1),
                    new ItemStack(ItemRegistry.bill_100.get(), 4),
                    1, 20, 1F
            ));

            //Ameythst
            event.getTrades().get(1).add(new BasicItemListing(
                    new ItemStack(Items.AMETHYST_SHARD, 1),
                    new ItemStack(ItemRegistry.bill_20.get(), 6),
                    8, 20, 1F
            ));


            event.getTrades().get(1).add(new BasicItemListing(
                    new ItemStack(Items.AMETHYST_BLOCK, 1),
                    new ItemStack(ItemRegistry.bill_100.get(), 12),
                    2, 20, 1F
            ));

            //Copper
            event.getTrades().get(1).add(new BasicItemListing(
                    new ItemStack(Items.COPPER_INGOT, 1),
                    new ItemStack(ItemRegistry.bill_1.get(), 2),
                    8, 20, 1F
            ));


            event.getTrades().get(1).add(new BasicItemListing(
                    new ItemStack(Items.COPPER_BLOCK, 1),
                    new ItemStack(ItemRegistry.bill_5.get(), 4),
                    1, 20, 1F
            ));

            if (event.getType() == VillagerProfession.TOOLSMITH)
            {
                //Coal
                event.getTrades().get(1).add(new BasicItemListing(
                        new ItemStack(Items.COAL, 16),
                        new ItemStack(ItemRegistry.bill_5.get(), 2),
                        5, 20, 1F
                ));


                event.getTrades().get(1).add(new BasicItemListing(
                        new ItemStack(Items.COAL_BLOCK, 16),
                        new ItemStack(ItemRegistry.bill_5.get(), 10),
                        1, 20, 1F
                ));
            }

            if (event.getType() == VillagerProfession.LEATHERWORKER)
            {
                event.getTrades().get(1).add(new BasicItemListing(
                        new ItemStack(Items.LEATHER, 8),
                        new ItemStack(ItemRegistry.bill_20.get(), 1),
                        5, 20, 1F
                ));

                event.getTrades().get(1).add(new BasicItemListing(
                        new ItemStack(Items.RABBIT_HIDE, 14),
                        new ItemStack(ItemRegistry.bill_5.get(), 3),
                        5, 20, 1F
                ));
            }

            if (event.getType() == VillagerProfession.LIBRARIAN)
            {
                event.getTrades().get(1).add(new BasicItemListing(
                        new ItemStack(Items.BOOK, 12),
                        new ItemStack(ItemRegistry.bill_10.get(), 3),
                        5, 20, 1F
                ));

                event.getTrades().get(1).add(new BasicItemListing(
                        new ItemStack(Items.PAPER, 36),
                        new ItemStack(ItemRegistry.bill_20.get(), 2),
                        3, 20, 1F
                ));

                event.getTrades().get(1).add(new BasicItemListing(
                        new ItemStack(Items.ENCHANTED_BOOK, 1),
                        new ItemStack(ItemRegistry.bill_50.get(), 3),
                        5, 20, 1F
                ));

                event.getTrades().get(1).add(new BasicItemListing(
                        new ItemStack(Items.WRITABLE_BOOK, 1),
                        new ItemStack(ItemRegistry.bill_5.get(), 3),
                        5, 20, 1F
                ));
            }

            if (event.getType() == VillagerProfession.CARTOGRAPHER)
            {
                event.getTrades().get(1).add(new BasicItemListing(
                        new ItemStack(Items.MAP, 1),
                        new ItemStack(ItemRegistry.bill_50.get(), 2),
                        3, 20, 1F
                ));

                event.getTrades().get(1).add(new BasicItemListing(
                        new ItemStack(Items.PAPER, 36),
                        new ItemStack(ItemRegistry.bill_20.get(), 2),
                        3, 20, 1F
                ));

                event.getTrades().get(1).add(new BasicItemListing(
                        new ItemStack(Items.COMPASS, 1),
                        new ItemStack(ItemRegistry.bill_5.get(), 5),
                        3, 20, 1F
                ));

                event.getTrades().get(1).add(new BasicItemListing(
                        new ItemStack(Items.FILLED_MAP, 1),
                        new ItemStack(ItemRegistry.bill_50.get(), 2),
                        3, 20, 1F
                ));
            }

        }
    }

}
