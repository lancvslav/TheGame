package cz.vsb.ekf.lan0116.world.creature.hero;

import cz.vsb.ekf.lan0116.util.ListManageUtil;
import cz.vsb.ekf.lan0116.world.creature.creatureType.Humanoid;

import java.util.Objects;

public abstract class Hero extends Humanoid {

    private Inventory inventory;
    private int coins;
    private HeroClass clazz;
    private final HeroInteraction heroInteraction;


    public Hero(String name, HeroClass heroClass) {
        super(name, heroClass.getHealth(), heroClass.getStamina(), heroClass.getDamage(), heroClass.getDefense());
        this.setWeapon(ListManageUtil.getWeaponObject("item.weapon.flower"));
        this.inventory = new Inventory(this.getWeapon());
        this.coins = 1000;
        this.clazz = heroClass;
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

    public HeroClass getClazz() {
        return clazz;
    }

    public HeroInteraction getHeroInteraction() {
        return heroInteraction;
    }

    @Override
    public float getAttackPower() {
        return super.getAttackPower() + this.getWeapon().getDamageRatio();
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
