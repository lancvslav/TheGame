package cz.vsb.ekf.lan0116.world.location.building.shop.consumableShop;

import cz.vsb.ekf.lan0116.util.ObjectFactory;
import cz.vsb.ekf.lan0116.util.ResourceType;
import cz.vsb.ekf.lan0116.util.ResourceUtil;
import cz.vsb.ekf.lan0116.world.location.building.shop.Shop;
import cz.vsb.ekf.lan0116.world.location.type.LocationType;

public class ConsumableShop extends Shop {

    public ConsumableShop(String shopName, String merchantId, LocationType consumableType) {
        super(shopName, merchantId, consumableType);
        this.setMerchandise(ObjectFactory.consumableList(ResourceUtil
                .getResource(ResourceType.CONSUMABLE_SHOP, shopName)));
    }
}
