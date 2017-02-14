package cz.vsb.ekf.lan0116.world.location.building.shop.consumableShop;

import cz.vsb.ekf.lan0116.world.creature.humanoid.Humanoid;
import cz.vsb.ekf.lan0116.world.item.Merchandise;
import cz.vsb.ekf.lan0116.world.location.building.shop.Shop;
import cz.vsb.ekf.lan0116.world.location.type.LocationType;

import java.util.List;

public class ConsumableShop extends Shop {

    public ConsumableShop(String shopName, Humanoid merchant, LocationType consumableType,
                          List<Merchandise> merchandise) {
        super(shopName, merchant, consumableType, merchandise);
    }
}
