package cz.vsb.ekf.lan0116.world.creature.hero;

import cz.vsb.ekf.lan0116.world.Location;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.items.Weapon;

import java.util.Objects;

public class Hero extends Creature {

    private Location position;
    private Weapon weapon;
    private Inventory inventory;
    private int coins;
    private HeroClass clazz;

    public Hero(String name, HeroClass heroClass) {
        super(name, heroClass.getHealth(), heroClass.getDamage(), heroClass.getDefense());
        this.weapon = new Weapon("item.weapon.flower", 0, 1);
        this.inventory = new Inventory(this.getWeapon());
        this.coins = 1000;
        this.clazz = heroClass;
    }

    public Location getPosition() {
        return position;
    }

    public void setPosition(Location position) {
        this.position = position;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public HeroClass getClazz() {
        return clazz;
    }

    public void setClazz(HeroClass clazz) {
        this.clazz = clazz;
    }

//    /**
//     * Heals hero for ammount of hp given in parameter
//     *
//     * @param healAmount
//     */
//    public void heal(int healAmount) {
//        int ableToHeal = this.getMaxHp() - this.getCurrentHp();
//        if (healAmount > ableToHeal) {
//            this.setCurrentHp(this.getMaxHp());
//        } else {
//            this.setCurrentHp(this.getCurrentHp() + healAmount);
//        }
//    }
//
//    /**
//     * Damages hero for ammount of hp given in parameter
//     *
//     * @param damage
//     */
//    public void inflict(int damage) {
//        int damageDone = damage - this.getDefense();
//        if (damageDone > 0) {
//            if (this.getCurrentHp() <= (damageDone)) {
//            } else {
//                this.setCurrentHp(this.getCurrentHp() - damageDone);
//            }
//        }
//    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.getName());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hero other = (Hero) obj;
        return Objects.equals(this.getName(), other.getName());
    }

}