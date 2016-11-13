package cz.vsb.ekf.lan0116.world.creature.hero;

public enum HeroClass {
    RANGER(14, 20, 7, 6),
    SORCERER(10, 18, 5, 10),
    WARRIOR(20, 22, 10, 2),;

    private final float health;
    private final float stamina;
    private final float defense;
    private final float damage;

    HeroClass(int health, float stamina, int defense, int damage) {
        this.health = health;
        this.stamina = stamina;
        this.defense = defense;
        this.damage = damage;
    }

    public float getHealth() {
        return health;
    }

    public float getStamina() {
        return stamina;
    }

    public float getDefense() {
        return defense;
    }

    public float getDamage() {
        return damage;
    }

}
