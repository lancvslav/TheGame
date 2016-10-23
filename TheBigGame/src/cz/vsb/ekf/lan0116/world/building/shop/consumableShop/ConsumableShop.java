package cz.vsb.ekf.lan0116.world.building.shop.consumableShop;

import cz.vsb.ekf.lan0116.util.ListManageUtil;
import cz.vsb.ekf.lan0116.util.ResourceType;
import cz.vsb.ekf.lan0116.util.ResourceUtil;
import cz.vsb.ekf.lan0116.world.LocationType;
import cz.vsb.ekf.lan0116.world.building.shop.Shop;

public class ConsumableShop extends Shop {

    public ConsumableShop(String shopName, LocationType shopType) {
        super(shopName, shopType);
        this.setMerchandise(ListManageUtil.consumableList(ResourceUtil.getResource(ResourceType.CONSUMABLE,shopName)));
    }
}
