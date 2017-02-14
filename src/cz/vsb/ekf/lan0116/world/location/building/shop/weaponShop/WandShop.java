package cz.vsb.ekf.lan0116.world.location.building.shop.weaponShop;

import cz.vsb.ekf.lan0116.world.creature.humanoid.Merchant;
import cz.vsb.ekf.lan0116.world.item.Merchandise;

import java.util.List;

public class WandShop extends WeaponShop {

    public WandShop(String shopName, Merchant merchant, List<Merchandise> weapons) {
        super(shopName, merchant, weapons);
    }

//    public WandShop() {
//        super("world.building.shop.weapon_shop.wand_shop","merchant.weapons.wizard");
//    }


}
