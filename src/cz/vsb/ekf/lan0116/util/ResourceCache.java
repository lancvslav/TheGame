package cz.vsb.ekf.lan0116.util;

import cz.vsb.ekf.lan0116.combat.Attack;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.item.Consumable;
import cz.vsb.ekf.lan0116.world.item.Merchandise;
import cz.vsb.ekf.lan0116.world.item.Weapon;

import java.util.Map;

public class ResourceCache {

    private Map<String, Attack> attackMap;
    private Map<String, Consumable> consumableMap;
    private Map<String, Creature> creatureMap;
    private Map<String, Merchandise> merchandiseMap;
    private Map<String, Weapon> weaponMap;

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

//    public List<Attack> attackList(List<String> attackIdList) {
//        List<Attack> list = new ArrayList<>();
//        for (String id : attackIdList) {
//            Attack attack = attackMap.get(id);
//            list.add(attack);
//        }
//        return list;
//    }
//
//    public Attack cloneAttack(String attackId) {
//        return attackMap.get(attackId);
//    }
//
//    public List<Merchandise> consumableList(List<String> consumableIdList) {
//        List<Merchandise> list = new ArrayList<>();
//        for (String id : consumableIdList) {
//            Consumable consumable = consumableMap.get(id);
//            list.add(consumable);
//        }
//        return list;
//    }
//
//    public Consumable cloneConsumable(String consumableId) {
//        return consumableMap.get(consumableId);
//    }
//
//    public List<Creature> creatureList(List<String> creatureIdList) {
//        List<Creature> list = new ArrayList<>();
//        for (String id : creatureIdList) {
//            Creature enemy = creatureMap.get(id);
//            list.add(enemy);
//        }
//        return list;
//    }
//
//    public Creature cloneCreature(String creatureId) {
//        return creatureMap.get(creatureId);
//    }
//
//    public List<Merchandise> merchandiseList(List<String> merchandiseListString) {
//        List<Merchandise> list = new ArrayList<>();
//        for (String id : merchandiseListString) {
//            Merchandise merchandise = merchandiseMap.get(id);
//            list.add(merchandise);
//        }
//        return list;
//    }
//
//    public Merchandise getMerchandiseToBuy(List<Merchandise> listWithItem, int index) {
//        return listWithItem.get(index);
//    }
//
//    public List<Merchandise> weaponsList(List<String> weaponListString) {
//        List<Merchandise> list = new ArrayList<>();
//        for (String id : weaponListString) {
//            Weapon weapon = weaponMap.get(id);
//            list.add(weapon);
//        }
//        return list;
//    }
//
//    public Weapon cloneWeapon(String weaponId) {
//        return weaponMap.get(weaponId);
//    }
}
