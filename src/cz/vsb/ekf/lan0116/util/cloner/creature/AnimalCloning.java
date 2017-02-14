package cz.vsb.ekf.lan0116.util.cloner.creature;

import cz.vsb.ekf.lan0116.util.ResourceCache;
import cz.vsb.ekf.lan0116.util.cloner.Clone;
import cz.vsb.ekf.lan0116.world.creature.Animal;

public class AnimalCloning extends Clone {
    public AnimalCloning(ResourceCache cache) {
        super(cache);
    }

    @Override
    public Animal clone(String objectId) {
        Animal cachedA = (Animal) this.getCache().getCreatureMap().get(objectId);
        return new Animal(cachedA.getName(), cachedA.getClazz(), cachedA.getMaxLifeEssence(), cachedA.getMaxStamina(),
                cachedA.getAttackPower(), cachedA.getDefense());
    }
}
