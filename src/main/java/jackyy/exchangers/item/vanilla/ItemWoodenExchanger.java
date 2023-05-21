package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfigs;
import jackyy.exchangers.util.DefaultValues;
import jackyy.exchangers.util.Reference;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ItemTags;

public class ItemWoodenExchanger extends ItemExchangerBase {

    public ItemWoodenExchanger() {
        super(new Properties().maxDamage(DefaultValues.woodenMaxDmg).rarity(Reference.RARITY_TIER1));
    }

    @Override
    public int getHarvestLevel() {
        return ModConfigs.CONFIG.woodenMaxHarvestLevel.get();
    }

    @Override
    public int getMaxRange() {
        return ModConfigs.CONFIG.woodenMaxRange.get();
    }

    @Override
    public int getTier() {
        return 1;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfigs.CONFIG.vanillaModule.get();
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return ItemTags.LOGS.contains(repair.getItem());
    }

}
