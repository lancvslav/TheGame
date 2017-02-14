package cz.vsb.ekf.lan0116.util.cloner.creature;

import cz.vsb.ekf.lan0116.util.ResourceCache;
import cz.vsb.ekf.lan0116.util.cloner.Clone;
import cz.vsb.ekf.lan0116.world.creature.Beast;

public class BeastCloning extends Clone {
    public BeastCloning(ResourceCache cache) {
        super(cache);
    }

    @Override
    public Beast clone(String objectId) {
        Beast cachedB = (Beast) this.getCache().getCreatureMap().get(objectId);
        return new Beast(cachedB.getName(), cachedB.getClazz(), cachedB.getMaxLifeEssence(), cachedB.getMaxStamina(),
                cachedB.getAttackPower(), cachedB.getDefense());
    }
}
