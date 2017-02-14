package cz.vsb.ekf.lan0116.util.cloner.item;

import cz.vsb.ekf.lan0116.util.ResourceCache;
import cz.vsb.ekf.lan0116.util.cloner.Clone;
import cz.vsb.ekf.lan0116.world.item.Consumable;
import cz.vsb.ekf.lan0116.world.item.type.ConsumableType;

public class ConsumableCloning extends Clone {
    public ConsumableCloning(ResourceCache cache) {
        super(cache);
    }

    @Override
    public Consumable clone(String objectId) {
        Consumable cachedCon = this.getCache().getConsumableMap().get(objectId);
        return new Consumable(cachedCon.getName(), (ConsumableType) cachedCon.getItemType(), cachedCon.getCost(),
                cachedCon.getReplenishValue());
    }
}
