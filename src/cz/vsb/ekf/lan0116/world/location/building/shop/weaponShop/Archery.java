package cz.vsb.ekf.lan0116.world.location.building.shop.weaponShop;

import cz.vsb.ekf.lan0116.world.creature.humanoid.Humanoid;
import cz.vsb.ekf.lan0116.world.item.Merchandise;

import java.util.List;

public class Archery extends WeaponShop {


    public Archery(String shopName, Humanoid merchant, List<Merchandise> weapons) {
        super(shopName, merchant, weapons);
    }
}
