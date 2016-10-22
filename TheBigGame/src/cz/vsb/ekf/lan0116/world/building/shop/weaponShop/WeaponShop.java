package cz.vsb.ekf.lan0116.world.building.shop.weaponShop;

import cz.vsb.ekf.lan0116.util.ListManageUtil;
import cz.vsb.ekf.lan0116.util.ResourceType;
import cz.vsb.ekf.lan0116.util.ResourceUtil;
import cz.vsb.ekf.lan0116.world.building.shop.Shop;

public class WeaponShop extends Shop {

    public WeaponShop(String shopName) {
        super(shopName);
        this.setMerchandise(ListManageUtil.weaponsList(ResourceUtil.getResource(ResourceType.WEAPONS, shopName)));
    }

}
