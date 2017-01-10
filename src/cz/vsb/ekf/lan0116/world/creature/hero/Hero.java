package cz.vsb.ekf.lan0116.world.creature.hero;

import cz.vsb.ekf.lan0116.util.ListManageUtil;
import cz.vsb.ekf.lan0116.world.creature.CreatureClass;
import cz.vsb.ekf.lan0116.world.creature.humanoid.Humanoid;

import java.util.Objects;

public abstract class Hero extends Humanoid {

    private Inventory inventory;
    private int coins;
    private final HeroInteraction heroInteraction;


    public Hero(String name, CreatureClass creatureClass) {
        super(name, creatureClass, creatureClass.getHealth(), creatureClass.getStamina(),
                creatureClass.getDamage(), creatureClass.getDefense());
        this.setWeapon(ListManageUtil.getWeaponObject("item.weapon.flower"));
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
