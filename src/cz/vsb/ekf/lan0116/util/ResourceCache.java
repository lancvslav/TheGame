package cz.vsb.ekf.lan0116.util;

import cz.vsb.ekf.lan0116.combat.Attack;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.item.Consumable;
import cz.vsb.ekf.lan0116.world.item.Merchandise;
import cz.vsb.ekf.lan0116.world.item.Weapon;

import java.util.Map;

public class ResourceCache {

    private final Map<String, Attack> attackMap;
    private final Map<String, Consumable> consumableMap;
    private final Map<String, Creature> creatureMap;
    private final Map<String, Merchandise> merchandiseMap;
    private final Map<String, Weapon> weaponMap;

    public ResourceCache(Map<String, Attack> attackMap, Map<String, Consumable> consumableMap, Map<String,
            Creature> creatureMap, Map<String, Merchandise> merchandiseMap, Map<String, Weapon> weaponMap) {
        this.attackMap = attackMap;
        this.consumableMap = consumableMap;
        this.creatureMap = creatureMap;
        this.merchandiseMap = merchandiseMap;
        this.weaponMap = weaponMap;
    }

    public Map<String, Attack> getAttackMap() {
        return attackMap;
    }

    public Map<String, Consumable> getConsumableMap() {
        return consumableMap;
    }

    public Map<String, Creature> getCreatureMap() {
        return creatureMap;
    }

    public Map<String, Merchandise> getMerchandiseMap() {
        return merchandiseMap;
    }

    public Map<String, Weapon> getWeaponMap() {
        return weaponMap;
    }
}
