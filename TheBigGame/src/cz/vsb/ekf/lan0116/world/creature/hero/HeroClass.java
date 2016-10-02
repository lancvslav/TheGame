package cz.vsb.ekf.lan0116.world.creature.hero;

public enum HeroClass {
    WARRIOR(20, 10, 2),
    RANGER(14, 7, 6),
    SORCERER(10, 5, 10),;

    private final int health;
    private final int defense;
    private final int damage;

    HeroClass(int health, int defense, int damage) {
        this.health = health;
        this.defense = defense;
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public int getDefense() {
        return defense;
    }

    public int getDamage() {
        return damage;
    }

}
