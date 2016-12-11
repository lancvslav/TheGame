package cz.vsb.ekf.lan0116.util;

import cz.vsb.ekf.lan0116.combat.Attack;
import cz.vsb.ekf.lan0116.combat.AttackProperty;
import cz.vsb.ekf.lan0116.world.creature.enemy.Enemy;
import cz.vsb.ekf.lan0116.world.creature.enemy.EnemyAttackDeprecated;
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

    //FINISH IT, ENEMY!
    public static List<Attack> attackList(List<String> attackListString) {
        List<Attack> list = new ArrayList<>();
        for (String line : attackListString) {
            Attack attack = ListManageUtil.getAttackObject(line);
            list.add(attack);
        }
        return list;
    }

    public static Attack getAttackObject(String attackId) {
        List<String> attackListString = new ArrayList<>(ResourceUtil
                .getResource(ResourceType.ATTACK_ALL, "attacks"));
        int index = attackListString.indexOf(attackId);
        String toSplit = attackListString.get(index);
        String[] split = toSplit.split(";");
        String name = split[0];
        String property = split[1];
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

    //USE ATTACKS AS TEMPLATE
    public static List<Enemy> getEnemies(List<String> enemyIdList) {
        List<Enemy> list = new ArrayList<>();
        for (String id : enemyIdList) {
            ListManageUtil.getEnemyObject(id);
            String[] split = id.split(";");
            String name = split[0];
            float maxHp = Integer.parseInt(split[1]);
            float maxStamina = Integer.parseInt(split[2]);
            float attack = Integer.parseInt(split[3]);
            float defense = Integer.parseInt(split[4]);
            String attackString = split[5].toUpperCase();
            EnemyAttackDeprecated specialAttack = EnemyAttackDeprecated.valueOf(attackString);
            Enemy enemy = new Enemy(name, maxHp, maxStamina, attack, defense, specialAttack);
            list.add(enemy);
        }
        return list;
    }

    private static Enemy getEnemyObject(String enemyId) {
        return null;
    }

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

    public static Merchandise getMerchandise(List<Merchandise> listWithItem, int index) {
        return listWithItem.get(index);
    }

    public static List<Merchandise> weaponsList(List<String> weaponListString) {
        List<Merchandise> list = new ArrayList<>();
        for (String line : weaponListString) {
            String[] split = line.split(";");
            String name = split[0];
            int cost = Integer.parseInt(split[1]);
            int dmg = Integer.parseInt(split[2]);
            String type = split[3].toUpperCase();
            WeaponType weaponType = WeaponType.valueOf(type);
            list.add(new Weapon(name, cost, dmg, weaponType));
        }
        return list;
    }

    public static Weapon getWeapon(List<Weapon> listWithWeapon, int index) {
        return listWithWeapon.get(index);
    }

}
