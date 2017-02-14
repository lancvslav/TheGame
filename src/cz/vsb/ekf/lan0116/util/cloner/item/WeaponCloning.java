package cz.vsb.ekf.lan0116.util.cloner.item;

import cz.vsb.ekf.lan0116.util.ResourceCache;
import cz.vsb.ekf.lan0116.util.cloner.Clone;
import cz.vsb.ekf.lan0116.world.item.Weapon;

public class WeaponCloning extends Clone {
    public WeaponCloning(ResourceCache cache) {
        super(cache);
    }

    @Override
    public Weapon clone(String objectId) {
        Weapon cachedW = this.getCache().getWeaponMap().get(objectId);
        return new Weapon(cachedW.getName(), cachedW.getItemType(), cachedW.getCost(), cachedW.getDamageRatio(),
                cachedW.getMoveSet());
    }
}
