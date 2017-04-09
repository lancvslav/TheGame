package cz.vsb.ekf.lan0116.util.cloner.creature;

import cz.vsb.ekf.lan0116.util.ResourceCache;
import cz.vsb.ekf.lan0116.util.cloner.Clone;
import cz.vsb.ekf.lan0116.world.creature.humanoid.Humanoid;

public class HumanoidCloning extends Clone {
    public HumanoidCloning(ResourceCache cache) {
        super(cache);
    }

    @Override
    public Humanoid clone(String objectId) {
        Humanoid cachedHum = (Humanoid) this.getCache().getCreatureMap().get(objectId);
        if (cachedHum.getDialogue() != null) {
            return new Humanoid(cachedHum.getName(), cachedHum.getClazz(), cachedHum.getMaxLifeEssence(),
                    cachedHum.getMaxStamina(), cachedHum.getAttackPower(), cachedHum.getDefense(), cachedHum.getWeapon(), cachedHum.getDialogue());
        }
        return new Humanoid(cachedHum.getName(), cachedHum.getClazz(), cachedHum.getMaxLifeEssence(),
                cachedHum.getMaxStamina(), cachedHum.getAttackPower(), cachedHum.getDefense(), cachedHum.getWeapon());
    }
}
