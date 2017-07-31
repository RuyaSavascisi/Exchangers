package me.jacky1356400.exchangers.item;

import cofh.api.energy.IEnergyContainerItem;
import me.jacky1356400.exchangers.helper.EnergyHelper;
import me.jacky1356400.exchangers.helper.NBTHelper;
import me.jacky1356400.exchangers.helper.StringHelper;
import me.jacky1356400.exchangers.util.EnergyContainerItemWrapper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import java.util.List;

public class ItemExchangerBasePowered extends ItemExchangerBase implements IEnergyContainerItem {

	@Override
	public int receiveEnergy(ItemStack container, int energy, boolean simulate) {
		return NBTHelper.receiveEnergy(container, energy, getMaxEnergyStored(container), simulate);
	}

	@Override
	public int extractEnergy(ItemStack container, int energy, boolean simulate) {
		return NBTHelper.extractEnergy(container, energy, simulate);
	}

	@Override
	public int getEnergyStored(ItemStack container) {
		return NBTHelper.getEnergyStored(container);
	}

    @Override
    public int getMaxEnergyStored(ItemStack container) {
        return 0;
    }

    @Override
	public boolean showDurabilityBar(ItemStack stack) {
		return true;
	}

	@Override
	public double getDurabilityForDisplay(ItemStack stack) {
		if (stack.getTagCompound() == null) {
			EnergyHelper.setDefaultEnergyTag(stack, 0);
		}
		return 1D - ((double) stack.getTagCompound().getInteger("Energy") / (double) getMaxEnergyStored(stack));
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean bool) {
		super.addInformation(stack, player, tooltip, bool);
		tooltip.add(StringHelper.formatNumber(getEnergyStored(stack)) + " / " + StringHelper.formatNumber(getMaxEnergyStored(stack)) + " RF");
	}

	@Override
	public boolean isDamaged(ItemStack stack) {
		return true;
	}

	@Override
	public boolean isPowered() {
		return true;
	}

    /* CAPABILITIES */
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt) {
        return new EnergyContainerItemWrapper(stack, this);
    }

}
