package cz.vsb.ekf.lan0116.world.location.building.shop.consumableShop;

import cz.vsb.ekf.lan0116.world.location.type.ShopType;

public class DrinkShop extends ConsumableShop {

    public DrinkShop(String shopName, String merchantId) {
        super(shopName, merchantId,ShopType.DRINK_SHOP);
    }
}
