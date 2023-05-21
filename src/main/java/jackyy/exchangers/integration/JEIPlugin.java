package jackyy.exchangers.integration;

import jackyy.exchangers.registry.ModItems;
import jackyy.exchangers.util.Reference;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.ingredients.subtypes.IIngredientSubtypeInterpreter;
import mezz.jei.api.ingredients.subtypes.UidContext;
import mezz.jei.api.registration.ISubtypeRegistration;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fml.RegistryObject;

import java.util.Optional;

@JeiPlugin
public class JEIPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Reference.MODID, "jei_plugin");
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistration registration) {
        for (RegistryObject<Item> item : ModItems.ITEMS.getEntries()) {
            ItemStack stack = item.get().getDefaultInstance();
            if (stack.getCapability(CapabilityEnergy.ENERGY).isPresent()) {
                registration.registerSubtypeInterpreter(item.get(), INTERPRETER);
            }
        }
    }

    private static final IIngredientSubtypeInterpreter<ItemStack> INTERPRETER = (stack, context) -> {
        if (context == UidContext.Ingredient && stack.hasTag()) {
            Optional<IEnergyStorage> capability = stack.getCapability(CapabilityEnergy.ENERGY).resolve();
            if (capability.isPresent()) {
                IEnergyStorage energyStorage = capability.get();
                String subtype;
                if (energyStorage.getEnergyStored() == energyStorage.getMaxEnergyStored()) {
                    subtype = "filled";
                } else {
                    subtype = "empty";
                }
                return subtype;
            }
        }
        return IIngredientSubtypeInterpreter.NONE;
    };

}
