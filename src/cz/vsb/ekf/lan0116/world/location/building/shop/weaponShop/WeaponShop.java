package cz.vsb.ekf.lan0116.world.location.building.shop.weaponShop;

import cz.vsb.ekf.lan0116.world.creature.humanoid.Merchant;
import cz.vsb.ekf.lan0116.world.item.Merchandise;
import cz.vsb.ekf.lan0116.world.location.building.shop.Shop;
import cz.vsb.ekf.lan0116.world.location.type.ShopType;

import java.util.List;

public class WeaponShop extends Shop {

    public WeaponShop(String shopName, Merchant merchant, List<Merchandise> weapons) {
        super(shopName, merchant, ShopType.WEAPON_SHOP, weapons);
    }

}
