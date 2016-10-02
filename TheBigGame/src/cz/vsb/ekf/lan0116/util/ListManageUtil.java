package cz.vsb.ekf.lan0116.util;

import cz.vsb.ekf.lan0116.combat.Attacks;
import cz.vsb.ekf.lan0116.world.items.Merchandise;
import cz.vsb.ekf.lan0116.world.items.Weapon;
import cz.vsb.ekf.lan0116.world.items.WeaponType;
import cz.vsb.ekf.lan0116.world.wilderness.Enemy;

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

    public static Merchandise getMerchandise(List<Merchandise> itemsListString, int index) {
        return itemsListString.get(index);
    }

//    public static List<Merchandise> weaponsList(List<String> weaponListString) {
//        List<Merchandise> list = new ArrayList<>();
//        for (String line : weaponListString) {
//            String[] split = line.split(";");
//            String name = split[0];
//            int cost = Integer.parseInt(split[1]);
//            int dmg = Integer.parseInt(split[2]);
//            String type = split[3].toUpperCase();
//            WeaponType weaponType = WeaponType.valueOf(type);
//            list.add(new Weapon(name, cost, dmg, weaponType));
//        }
//        return list;
//    }

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
            int maxHp = Integer.parseInt(split[1]);
            int attack = Integer.parseInt(split[2]);
            int defense = Integer.parseInt(split[3]);
            String attackString = split[4].toUpperCase();
            Attacks specialAttack = Attacks.valueOf(attackString);
            Enemy enemy = new Enemy(name, maxHp, attack, defense, specialAttack);
            list.add(enemy);
        }
        return list;
    }

    public static Enemy getEnemy(List<Enemy> enemiesListString, int index) {
        return enemiesListString.get(index);
    }


}
