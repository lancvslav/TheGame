package cz.vsb.ekf.lan0116.world.location.building.shop.consumableShop;

import cz.vsb.ekf.lan0116.world.location.type.ShopType;

public class FoodShop extends ConsumableShop {
    public FoodShop(String shopName, String merchantId) {
        super(shopName, merchantId,ShopType.FOOD_SHOP);
    }
}
