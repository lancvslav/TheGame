package cz.vsb.ekf.lan0116.world.location.building.shop.consumableShop;

import cz.vsb.ekf.lan0116.world.creature.humanoid.Merchant;
import cz.vsb.ekf.lan0116.world.item.Merchandise;
import cz.vsb.ekf.lan0116.world.location.building.shop.Shop;
import cz.vsb.ekf.lan0116.world.location.type.LocationType;

import java.util.List;

public class ConsumableShop extends Shop {

    public ConsumableShop(String shopName, Merchant merchant, LocationType consumableType,
                          List<Merchandise> merchandise) {
        super(shopName, merchant, consumableType, merchandise);
        //        this.setMerchandise(ObjectFactory.consumableList(ResourceUtil
//                .getResource(ResourceType.CONSUMABLE_SHOP, shopName)));
    }
}
