package cz.vsb.ekf.lan0116.world.location.building.shop.weaponShop;

import cz.vsb.ekf.lan0116.util.ListManageUtil;
import cz.vsb.ekf.lan0116.util.ResourceType;
import cz.vsb.ekf.lan0116.util.ResourceUtil;
import cz.vsb.ekf.lan0116.world.location.building.shop.Shop;
import cz.vsb.ekf.lan0116.world.location.type.ShopType;

public class WeaponShop extends Shop {

    public WeaponShop(String shopName) {
        super(shopName, ShopType.WEAPON_SHOP);
        this.setMerchandise(ListManageUtil.weaponsList(ResourceUtil.getResource(ResourceType.WEAPON, shopName)));
    }

}
