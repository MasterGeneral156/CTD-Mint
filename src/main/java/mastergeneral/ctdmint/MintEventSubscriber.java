package mastergeneral.ctdmint;

import mastergeneral.ctdmint.item.ModItems;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CTDMint.MODID)
public class MintEventSubscriber {

	@SubscribeEvent
    public static void onVillagerTradesSetup(VillagerTradesEvent event) 
	{
        event.getTrades().get(1).add(new MintTrades(Items.GOLD_NUGGET, 1, ModItems.bill_2, 10, 10, 20, 1F));
        event.getTrades().get(1).add(new MintTrades(Items.GOLD_INGOT, 1, ModItems.bill_50, 4, 5, 20, 1F));
        event.getTrades().get(1).add(new MintTrades(Items.GOLD_BLOCK, 1, ModItems.bill_500, 4, 1, 20, 1F));
        
        event.getTrades().get(1).add(new MintTrades(Items.IRON_NUGGET, 1, ModItems.bill_1, 10, 10, 20, 1F));
        event.getTrades().get(1).add(new MintTrades(Items.IRON_INGOT, 1, ModItems.bill_10, 10, 5, 20, 1F));
        event.getTrades().get(1).add(new MintTrades(Items.IRON_BLOCK, 1, ModItems.bill_100, 10, 1, 20, 1F));
        
        event.getTrades().get(1).add(new MintTrades(Items.EMERALD, 1, ModItems.bill_10, 5, 5, 20, 1F));
        event.getTrades().get(1).add(new MintTrades(Items.EMERALD_BLOCK, 1, ModItems.bill_50, 10, 2, 20, 1F));
        
        event.getTrades().get(1).add(new MintTrades(Items.DIAMOND, 1, ModItems.bill_20, 2, 8, 20, 1F));
        event.getTrades().get(1).add(new MintTrades(Items.DIAMOND_BLOCK, 1, ModItems.bill_100, 4, 1, 20, 1F));
        
        event.getTrades().get(1).add(new MintTrades(Items.AMETHYST_SHARD, 1, ModItems.bill_20, 6, 8, 20, 1F));
        event.getTrades().get(1).add(new MintTrades(Items.AMETHYST_BLOCK, 1, ModItems.bill_100, 12, 2, 20, 1F));
        
        event.getTrades().get(1).add(new MintTrades(Items.COPPER_INGOT, 1, ModItems.bill_1, 2, 8, 20, 1F));
        event.getTrades().get(1).add(new MintTrades(Items.COPPER_BLOCK, 1, ModItems.bill_5, 4, 1, 20, 1F));
        
        if (event.getType() == VillagerProfession.TOOLSMITH)
        {
        	event.getTrades().get(1).add(new MintTrades(Items.COAL, 16, ModItems.bill_5, 2, 5, 20, 1F));
            event.getTrades().get(1).add(new MintTrades(Items.COAL_BLOCK, 16, ModItems.bill_5, 10, 1, 20, 1F));
        }
        
        if (event.getType() == VillagerProfession.LEATHERWORKER)
        {
        	event.getTrades().get(1).add(new MintTrades(ModItems.bill_20, 1, ModItems.wallet, 1, 1, 20, 1F));
        	event.getTrades().get(1).add(new MintTrades(ModItems.bill_5, 1, ModItems.coin_pouch, 1, 1, 20, 1F));
        }
        
        if (event.getType() == VillagerProfession.LIBRARIAN)
        {
        	event.getTrades().get(1).add(new MintTrades(ModItems.bill_500, 1, ModItems.atm_card, 1, 1, 20, 1F));
        }
    }
}
