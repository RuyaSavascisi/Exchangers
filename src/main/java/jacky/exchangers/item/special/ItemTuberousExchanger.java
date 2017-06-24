package jacky.exchangers.item.special;

import java.util.List;

import jacky.exchangers.helper.StringHelper;
import jacky.exchangers.item.ItemExchanger;
import jacky.exchangers.util.Tier;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemTuberousExchanger extends ItemExchanger {

	public ItemTuberousExchanger() {
		super("potato", Tier.ZERO, 0);
	}

	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag bool) {
		super.addInformation(stack, world, tooltip, bool);
		tooltip.add(getTier().getFormattedText());
		if (StringHelper.isShiftKeyDown()) {
			tooltip.add(StringHelper.localize("tooltip.tuberousExchanger.warning"));
		}
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {
		ItemStack stack = player.getHeldItem(hand);
		return killPlayer(player, stack) ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);
		boolean result = killPlayer(player, stack);
		return ActionResult.newResult(result ? EnumActionResult.SUCCESS : EnumActionResult.FAIL, stack);
	}

	private static boolean killPlayer(EntityPlayer player, ItemStack stack) {
		stack = ItemStack.EMPTY;
		player.attackEntityFrom(new EntityDamageSource("exchangerpotato", player), 100000.0F);
		player.world.createExplosion(player, player.posX, player.posY, player.posZ, 1.0F, false);
		return true;

	}

}
