package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.common.Tags;

public class ItemNetheriteExchanger extends ItemExchangerBase {

    public ItemNetheriteExchanger() {
        super(new Properties().durability(DefaultValues.netheriteMaxDmg).rarity(Rarity.EPIC));
    }

    @Override
    public String getHarvestLevel() {
        return ModConfigs.CONFIG.netheriteMaxHarvestLevel.get();
    }

    @Override
    public String getDefaultHarvestLevel() {
        return DefaultValues.netheriteMaxHarvestLevel;
    }

    @Override
    public int getMaxRange() {
        return ModConfigs.CONFIG.netheriteMaxRange.get();
    }

    @Override
    public int getTier() {
        return 8;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.vanillaModule.get();
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.is(Tags.Items.INGOTS_NETHERITE);
    }

}
