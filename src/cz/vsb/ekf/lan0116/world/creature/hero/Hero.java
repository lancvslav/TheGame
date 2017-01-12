package cz.vsb.ekf.lan0116.world.creature.hero;

import cz.vsb.ekf.lan0116.combat.Attack;
import cz.vsb.ekf.lan0116.combat.AttackProperty;
import cz.vsb.ekf.lan0116.world.creature.CreatureClass;
import cz.vsb.ekf.lan0116.world.creature.humanoid.Humanoid;
import cz.vsb.ekf.lan0116.world.item.Weapon;
import cz.vsb.ekf.lan0116.world.item.type.WeaponType;

import java.util.Objects;

public abstract class Hero extends Humanoid {

    private Inventory inventory;
    private int coins;
    private final HeroInteraction heroInteraction;


    public Hero(String name, CreatureClass creatureClass) {
        super(name, creatureClass, creatureClass.getHealth(), creatureClass.getStamina(),
                creatureClass.getDamage(), creatureClass.getDefense());
        Attack attack = new Attack("attack.strike", AttackProperty.NONE, 0, 1, 1);
        Weapon weapon = new Weapon("item.weapon.flower", 0, 1, WeaponType.UNISEX, attack);
        this.setWeapon(weapon);
        this.inventory = new Inventory(this.getWeapon());
        this.coins = 1000;
        this.heroInteraction = new HeroInteraction();
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

    public HeroInteraction getHeroInteraction() {
        return heroInteraction;
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
