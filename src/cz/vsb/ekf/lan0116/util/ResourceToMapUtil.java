package cz.vsb.ekf.lan0116.util;

import cz.vsb.ekf.lan0116.combat.Attack;
import cz.vsb.ekf.lan0116.combat.AttackProperty;
import cz.vsb.ekf.lan0116.world.creature.Animal;
import cz.vsb.ekf.lan0116.world.creature.Beast;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.CreatureClass;
import cz.vsb.ekf.lan0116.world.creature.humanoid.Humanoid;
import cz.vsb.ekf.lan0116.world.item.Consumable;
import cz.vsb.ekf.lan0116.world.item.Merchandise;
import cz.vsb.ekf.lan0116.world.item.Weapon;
import cz.vsb.ekf.lan0116.world.item.type.ConsumableType;
import cz.vsb.ekf.lan0116.world.item.type.WeaponType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceToMapUtil {

    private ResourceToMapUtil() {
    }

    public static Map<String, Attack> createAttackMap(List<String> attackResource) {
        Map<String, Attack> attackMap = new HashMap<>();
        for (String toSplit : attackResource) {
            String[] split = toSplit.split(";");
            String name = split[0];
            String property = split[1].toUpperCase();
            AttackProperty attackProperty = AttackProperty.valueOf(property);
            float penetration = Float.parseFloat(split[2]);
            float multiplier = Float.parseFloat(split[3]);
            float staminaReq = Float.parseFloat(split[4]);
            Attack attack = new Attack(name, attackProperty, penetration, multiplier, staminaReq);
            attackMap.put(name, attack);
        }
        return attackMap;
    }

    public static Map<String, Consumable> createConsumableMap(List<String> consumableResource) {
        Map<String, Consumable> consumableMap = new HashMap<>();
        for (String toSplit : consumableResource) {
            String[] split = toSplit.split(";");
            String name = split[0];
            int cost = Integer.parseInt(split[1]);
            int replenishValue = Integer.parseInt(split[2]);
            String type = split[3].toUpperCase();
            ConsumableType consumableType = ConsumableType.valueOf(type);
            Consumable consumable = new Consumable(name, consumableType, cost, replenishValue);
            consumableMap.put(name, consumable);
        }
        return consumableMap;
    }

    public static Map<String, Creature> createCreatureMap(List<String> creatureResource) {
        Map<String, Creature> creatureMap = new HashMap<>();
        for (String toSplit : creatureResource) {
            String[] split = toSplit.split(";");
            String name = split[0];
            float maxHp = Integer.parseInt(split[1]);
            float maxStamina = Integer.parseInt(split[2]);
            float attackPower = Integer.parseInt(split[3]);
            float defense = Integer.parseInt(split[4]);
            String attackSection = split[5];
            String[] attacks = attackSection.split(","); //Using simple comma to separate single attacks
            String clazz = split[7];
            CreatureClass creatureClass = CreatureClass.valueOf(clazz);
            Creature creature;
            //useless switch, only made for possible improvement in future
            switch (split[8]) {
                case "animal":
                    creature = new Animal(name, creatureClass, maxHp, maxStamina, attackPower, defense, attacks);
                    break;
                case "beast":
                    creature = new Beast(name, creatureClass, maxHp, maxStamina, attackPower, defense, attacks);
                    break;
                case "humanoid":
                    String weapon = split[6];
                    creature = new Humanoid(name, creatureClass, maxHp, maxStamina, attackPower, defense, weapon,
                            attacks);
                    break;
                default:
                    creature = new Creature(name, creatureClass, maxHp, maxStamina, attackPower, defense, attacks);
                    break;
            }
            creatureMap.put(name, creature);
        }
        return creatureMap;
    }

    public static Map<String, Merchandise> createMerchandiseMap(List<String> merchandiseResource) {
        Map<String, Merchandise> merchandiseMap = new HashMap<>();
        for (String toSplit : merchandiseResource) {
            String[] split = toSplit.split(";");
            String name = split[0];
            int cost = Integer.parseInt(split[1]);
            Merchandise merchandise = new Merchandise(name, null, cost);
            merchandiseMap.put(name, merchandise);
        }
        return merchandiseMap;
    }

    public static Map<String, Weapon> createWeaponMap(List<String> weaponResource, Map<String, Attack> attackMap) {
        Map<String, Weapon> weaponMap = new HashMap<>();
        for (String toSplit : weaponResource) {
            String[] split = toSplit.split(";");
            String name = split[0];
            int cost = Integer.parseInt(split[1]);
            int damageRatio = Integer.parseInt(split[2]);
            String type = split[3].toUpperCase();
            WeaponType weaponType = WeaponType.valueOf(type);
            String attackSection = split[4];
            String[] attackIdArray = attackSection.split(",");
            Attack[] attacks = new Attack[attackIdArray.length];
            int i = 0;
            for (String attackId : attackIdArray) {
                attacks[i] = attackMap.get(attackId);
                i++;
            }
            Weapon weapon = new Weapon(name, cost, damageRatio, weaponType, attacks);
            weaponMap.put(name, weapon);
        }
        return weaponMap;
    }

}
