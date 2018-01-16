package jackyy.exchangers.integration;

import jackyy.exchangers.Exchangers;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;

public class EnderIOIntegration {

    public static ItemStack capacitorBankBasic;
    public static ItemStack capacitorBank;
    public static ItemStack capacitorBankVibrant;
    public static ItemStack basicCapacitor;
    public static ItemStack doubleLayerCapacitor;
    public static ItemStack octadicCapacitor;
    public static ItemStack pulsatingCrystal;
    public static ItemStack vibrantCrystal;
    public static ItemStack enderCrystal;
    public static ItemStack bucketNutrientDistillation;
    public static ItemStack bucketDewOfTheVoid;
    public static ItemStack bucketVaporOfLevity;

    public static void init() {
        Exchangers.logger.info("Fetching items for Ender IO integration...");

        Block capBankBlock = Block.REGISTRY.getObject(new ResourceLocation(Exchangers.EIO, "block_cap_bank"));
        capacitorBankBasic = new ItemStack(capBankBlock, 1, 1);
        capacitorBank = new ItemStack(capBankBlock, 1, 2);
        capacitorBankVibrant = new ItemStack(capBankBlock, 1, 3);

        Item capacitorItem = Item.REGISTRY.getObject(new ResourceLocation(Exchangers.EIO, "item_basic_capacitor"));
        if (capacitorItem != null) {
            basicCapacitor = new ItemStack(capacitorItem, 1, 0);
            doubleLayerCapacitor = new ItemStack(capacitorItem, 1, 1);
            octadicCapacitor = new ItemStack(capacitorItem, 1, 2);
        }

        Item eioMaterialsItem = Item.REGISTRY.getObject(new ResourceLocation(Exchangers.EIO, "item_material"));
        if (eioMaterialsItem != null) {
            pulsatingCrystal = new ItemStack(eioMaterialsItem, 1, 13);
            vibrantCrystal = new ItemStack(eioMaterialsItem, 1, 14);
            enderCrystal = new ItemStack(eioMaterialsItem, 1, 15);
        }

        Fluid nutrientDistillation = FluidRegistry.getFluid("nutrient_distillation");
        bucketNutrientDistillation = FluidUtil.getFilledBucket(new FluidStack(nutrientDistillation, 1000));
        Fluid dewOfTheVoid = FluidRegistry.getFluid("ender_distillation");
        bucketDewOfTheVoid = FluidUtil.getFilledBucket(new FluidStack(dewOfTheVoid, 1000));
        Fluid vaporOfLevity = FluidRegistry.getFluid("vapor_of_levity");
        bucketVaporOfLevity = FluidUtil.getFilledBucket(new FluidStack(vaporOfLevity, 1000));
    }

}
