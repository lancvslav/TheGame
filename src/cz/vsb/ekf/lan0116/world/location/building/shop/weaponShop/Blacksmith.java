package cz.vsb.ekf.lan0116.world.location.building.shop.weaponShop;

import cz.vsb.ekf.lan0116.world.creature.humanoid.Merchant;
import cz.vsb.ekf.lan0116.world.item.Merchandise;

import java.util.List;

public class Blacksmith extends WeaponShop {

    public Blacksmith(String shopName, Merchant merchant, List<Merchandise> weapons) {
        super(shopName, merchant, weapons);
    }

//    public Blacksmith() {
//        super("world.building.shop.weapon_shop.blacksmith","merchant.weapons.blacksmith");
//    }

}
