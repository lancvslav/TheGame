package cz.vsb.ekf.lan0116.world.location.building.shop.consumableShop;

import cz.vsb.ekf.lan0116.util.ListManageUtil;
import cz.vsb.ekf.lan0116.util.ResourceType;
import cz.vsb.ekf.lan0116.util.ResourceUtil;
import cz.vsb.ekf.lan0116.world.location.building.shop.Shop;
import cz.vsb.ekf.lan0116.world.location.type.LocationType;

public class ConsumableShop extends Shop {

    public ConsumableShop(String shopName, LocationType consumableType) {
        super(shopName, consumableType);
        this.setMerchandise(ListManageUtil.consumableList(ResourceUtil.getResource(ResourceType.CONSUMABLE, shopName)));
    }
}
