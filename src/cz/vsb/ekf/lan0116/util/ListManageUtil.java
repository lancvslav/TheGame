package cz.vsb.ekf.lan0116.util;

import cz.vsb.ekf.lan0116.combat.Attack;
import cz.vsb.ekf.lan0116.combat.AttackProperty;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.CreatureClass;
import cz.vsb.ekf.lan0116.world.creature.creatureType.Humanoid;
import cz.vsb.ekf.lan0116.world.item.Consumable;
import cz.vsb.ekf.lan0116.world.item.Merchandise;
import cz.vsb.ekf.lan0116.world.item.Weapon;
import cz.vsb.ekf.lan0116.world.item.type.ConsumableType;
import cz.vsb.ekf.lan0116.world.item.type.WeaponType;

import java.util.ArrayList;
import java.util.List;

public class ListManageUtil {

    private ListManageUtil() {
    }

    public static List<Attack> attackList(List<String> attackIdList) {
        List<Attack> list = new ArrayList<>();
        for (String id : attackIdList) {
            Attack attack = ListManageUtil.getAttackObject(id);
            list.add(attack);
        }
        return list;
    }

    public static Attack getAttackObject(String attackId) {
        List<String> attackIdList = new ArrayList<>(ResourceUtil
                .getResource(ResourceType.ATTACK_ALL, "attacks"));
        String toSplit = "";
        int index = 0;
        while (toSplit.equals("") || index >= attackIdList.size()) {
            if (attackIdList.get(index).startsWith(attackId)) {
                toSplit = attackIdList.get(index);
            } else {
                index++;
            }
        }
        String[] split = toSplit.split(";");
        String name = split[0];
        String property = split[1].toUpperCase();
        AttackProperty attackProperty = AttackProperty.valueOf(property);
        float penetration = Float.parseFloat(split[2]);
        float multiplier = Float.parseFloat(split[3]);
        float staminaReq = Float.parseFloat(split[4]);
        return new Attack(name, attackProperty, penetration, multiplier, staminaReq);
    }


    public static List<Merchandise> consumableList(List<String> consumableListString) {
        List<Merchandise> list = new ArrayList<>();
        for (String line : consumableListString) {
            String[] split = line.split(";");
            String name = split[0];
            int cost = Integer.parseInt(split[1]);
            int replenishValue = Integer.parseInt(split[2]);
            String type = split[3].toUpperCase();
            ConsumableType consumableType = ConsumableType.valueOf(type);
            list.add(new Consumable(name, consumableType, cost, replenishValue));
        }
        return list;
    }

    public static Merchandise getConsumable(List<Merchandise> listWithConsumable, int index) {
        return listWithConsumable.get(index);
    }

    public static List<Creature> getEnemies(List<String> enemyIdList) {
        List<Creature> list = new ArrayList<>();
        for (String id : enemyIdList) {
            Creature enemy = ListManageUtil.getEnemyObject(id);
            list.add(enemy);
        }
        return list;
    }

    private static Creature getEnemyObject(String enemyId) {
        List<String> enemyIdList = new ArrayList<>(ResourceUtil
                .getResource(ResourceType.ENEMY_ALL, "enemies"));
        String toSplit = "";
        int index = 0;
        while (toSplit.equals("") || index >= enemyIdList.size()) {
            if (enemyIdList.get(index).startsWith(enemyId)) {
                toSplit = enemyIdList.get(index);
            } else {
                index++;
            }
        }
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
        if (split[8].equals("humanoid")) {
            String weapon = split[6];
            return new Humanoid(name, creatureClass, maxHp, maxStamina, attackPower, defense, weapon, attacks);
        }
        return new Creature(name, creatureClass, maxHp, maxStamina, attackPower, defense, attacks);
    }

    @Deprecated
    public static List<Merchandise> merchandiseList(List<String> merchandiseListString) {
        List<Merchandise> list = new ArrayList<>();
        for (String line : merchandiseListString) {
            String[] split = line.split(";");
            String name = split[0];
            int cost = Integer.parseInt(split[1]);
            list.add(new Merchandise(name, null, cost));
        }
        return list;
    }

    @Deprecated
    public static Merchandise getMerchandise(List<Merchandise> listWithItem, int index) {
        return listWithItem.get(index);
    }

    public static List<Merchandise> weaponsList(List<String> weaponListString) {
        List<Merchandise> list = new ArrayList<>();
        for (String id : weaponListString) {
            Weapon weapon = ListManageUtil.getWeaponObject(id);
            list.add(weapon);
        }
        return list;
    }

    public static Weapon getWeaponObject(String weaponId) {
        List<String> weaponIdList = new ArrayList<>(ResourceUtil
                .getResource(ResourceType.WEAPON_ALL, "weapons"));
        String toSplit = "";
        int index = 0;
        while (toSplit.equals("") || index >= weaponIdList.size()) {
            if (weaponIdList.get(index).startsWith(weaponId)) {
                toSplit = weaponIdList.get(index);
            } else {
                index++;
                if(index>=weaponIdList.size()){
                    System.out.println(toSplit);
                }
            }
        }
        String[] split = toSplit.split(";");
        String name = split[0];
        int cost = Integer.parseInt(split[1]);
        int damageRatio = Integer.parseInt(split[2]);
        String type = split[3].toUpperCase();
        WeaponType weaponType = WeaponType.valueOf(type);
        return new Weapon(name, cost, damageRatio, weaponType);
    }

}
