package gregtechmod.api.items;

import ic2.api.item.IElectricItem;

public class GT_EnergyStoreIC_Item extends GT_EnergyStore_Item implements IElectricItem {
	public GT_EnergyStoreIC_Item(String aName, int aCharge, int aTransfer, int aTier, int aEmptyID, int aFullID) {
		super(aName, aCharge, aTransfer, aTier, aEmptyID, aFullID);
	}
}