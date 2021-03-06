package cz.vsb.ekf.lan0116.world.location.building.shop.consumableShop;

import cz.vsb.ekf.lan0116.world.creature.humanoid.Humanoid;
import cz.vsb.ekf.lan0116.world.item.Merchandise;
import cz.vsb.ekf.lan0116.world.location.type.ShopType;

import java.util.List;

public class FoodShop extends ConsumableShop {
    public FoodShop(String shopName, Humanoid merchant, List<Merchandise> food) {
        super(shopName, merchant, ShopType.FOOD_SHOP, food);
    }
}
