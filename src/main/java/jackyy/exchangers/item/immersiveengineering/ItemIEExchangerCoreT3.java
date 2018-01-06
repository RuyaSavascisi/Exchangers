package jackyy.exchangers.item.immersiveengineering;

import jackyy.exchangers.Config;
import jackyy.exchangers.Exchangers;
import jackyy.exchangers.item.ItemCoreBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemIEExchangerCoreT3 extends ItemCoreBase {

    public ItemIEExchangerCoreT3(){
        setRegistryName(Exchangers.MODID + ":ieexcore_t3");
        setUnlocalizedName(Exchangers.MODID + ".ieexcore_t3");
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public boolean checkLoaded() {
        return Config.immersiveEngineeringModule && Loader.isModLoaded(Exchangers.IE);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }

}
