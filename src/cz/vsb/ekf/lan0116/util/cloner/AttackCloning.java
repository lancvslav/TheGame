package cz.vsb.ekf.lan0116.util.cloner;

import cz.vsb.ekf.lan0116.combat.Attack;
import cz.vsb.ekf.lan0116.util.ResourceCache;

public class AttackCloning extends Clone<Attack> {

    public AttackCloning(ResourceCache cache) {
        super(cache);
    }

    @Override
    public Attack clone(String objectId) {
        Attack cachedA = this.getCache().getAttackMap().get(objectId);
        return new Attack(cachedA.getName(), cachedA.getProperty(), cachedA.getPenetration(),
                cachedA.getMultiplier(), cachedA.getStaminaConsumption());
    }
}
