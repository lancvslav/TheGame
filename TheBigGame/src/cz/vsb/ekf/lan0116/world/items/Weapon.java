package cz.vsb.ekf.lan0116.world.items;

public class Weapon extends Merchandise {

    private final int damage;
    private  WeaponType type;

    public Weapon(String name, int cost, int damage, WeaponType type) {
        super(name, cost);
        this.damage = damage;
        this.type = type;
    }

    public Weapon(String name, int cost, int dmg) {
        super(name, cost);
        this.damage = dmg;
    }

    public int getDamage() {
        return damage;
    }

    public WeaponType getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString() + ", damage: " + this.damage + " , weapon type:" + this.type;
    }

}
