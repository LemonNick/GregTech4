package gregtechmod.api.items;

import gregtechmod.api.GregTech_API;
import gregtechmod.api.util.GT_ModHandler;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GT_EnergyStore_Item extends GT_Generic_Item {
	protected int mCharge, mTransfer, mTier, mEmptyID, mFullID;
	
	public GT_EnergyStore_Item(String aUnlocalized, int aCharge, int aTransfer, int aTier, int aEmptyID, int aFullID) { // TODO remove IDs
		super(aUnlocalized, null);
		setMaxStackSize(1);
		setMaxDamage(100);
		setNoRepair();
		mCharge = aCharge;
		mTransfer = aTransfer;
		mTier = aTier;
		mEmptyID = aEmptyID;
		mFullID = aFullID;
	}
    
    @Override
	public boolean getShareTag() {
        return true;
    }
    
	@Override
	@SideOnly(Side.CLIENT)
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void getSubItems(Item item, CreativeTabs var2, List var3) {
        ItemStack tCharged = new ItemStack(GregTech_API.sItemList[mFullID], 1, 0), tUncharged = new ItemStack(GregTech_API.sItemList[mEmptyID], 1, getMaxDamage() - 1);
        GT_ModHandler.chargeElectricItem(tCharged, Integer.MAX_VALUE, Integer.MAX_VALUE, true, false);
        if (this == GregTech_API.sItemList[mFullID]) var3.add(tCharged);
        if (this == GregTech_API.sItemList[mEmptyID]) var3.add(tUncharged);
    }
    
	@Override
    public int getItemEnchantability() {
        return 0;
    }
	
	@Override
    public boolean isBookEnchantable(ItemStack itemstack1, ItemStack itemstack2) {
        return false;
    }
	
	@Override
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
        return false;
    }
	
	@Override
	public int getTier(ItemStack aStack) {
		return mTier;
	}
}
