package cz.vsb.ekf.lan0116.world.item;

import cz.vsb.ekf.lan0116.world.item.type.WeaponType;

public class Weapon extends Merchandise {

    private final int damage;

    public Weapon(String name, int cost, int damage, WeaponType type) {
        super(name, type, cost);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public WeaponType getType() {
        return (WeaponType) super.getItemType();
    }

    @Override
    public String toString() {
        return super.toString() + ", damage: " + this.damage + " , weapon type:" + this.getType();
    }

}
