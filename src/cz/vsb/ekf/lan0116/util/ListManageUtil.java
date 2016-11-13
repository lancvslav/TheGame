package cz.vsb.ekf.lan0116.util;

import cz.vsb.ekf.lan0116.world.creature.enemy.EnemyAttacks;
import cz.vsb.ekf.lan0116.world.item.Consumable;
import cz.vsb.ekf.lan0116.world.item.Merchandise;
import cz.vsb.ekf.lan0116.world.item.type.ConsumableType;
import cz.vsb.ekf.lan0116.world.item.type.WeaponType;
import cz.vsb.ekf.lan0116.world.item.Weapon;
import cz.vsb.ekf.lan0116.world.creature.enemy.Enemy;

import java.util.ArrayList;
import java.util.List;

public class ListManageUtil {

    private ListManageUtil() {
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

    public static List<Enemy> getEnemies(List<String> enemiesListString) {
        List<Enemy> list = new ArrayList<>();
        for (String line : enemiesListString) {
            String[] split = line.split(";");
            String name = split[0];
            float maxHp = Integer.parseInt(split[1]);
            float maxStamina = Integer.parseInt(split[2]);
            float attack = Integer.parseInt(split[3]);
            float defense = Integer.parseInt(split[4]);
            String attackString = split[5].toUpperCase();
            EnemyAttacks specialAttack = EnemyAttacks.valueOf(attackString);
            Enemy enemy = new Enemy(name, maxHp,maxStamina, attack, defense, specialAttack);
            list.add(enemy);
        }
        return list;
    }

    public static Enemy getEnemy(List<Enemy> enemiesListString, int index) {
        return enemiesListString.get(index);
    }

}
