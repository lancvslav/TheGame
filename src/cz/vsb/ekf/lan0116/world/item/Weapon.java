package cz.vsb.ekf.lan0116.world.item;

import cz.vsb.ekf.lan0116.combat.Attack;
import cz.vsb.ekf.lan0116.world.item.type.ItemType;
import cz.vsb.ekf.lan0116.world.item.type.WeaponType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Weapon extends Merchandise {

    private final int damageRatio;
    private List<Attack> moveSet;

    public Weapon(String name, ItemType itemType, int cost, int damageRatio, List<Attack> moveSet) {
        super(name, itemType, cost);
        this.damageRatio = damageRatio;
        this.moveSet = moveSet;
    }

    public Weapon(String name, int cost, int damageRatio, WeaponType type, Attack... attacks) {
        super(name, type, cost);
        this.damageRatio = damageRatio;
        this.moveSet = new ArrayList<>(Arrays.asList(attacks));
    }

    public int getDamageRatio() {
        return damageRatio;
    }

    public List<Attack> getMoveSet() {
        return moveSet;
    }

    public WeaponType getType() {
        return (WeaponType) super.getItemType();
    }

    @Override
    public String toString() {
        return "testing weapon to string";
    }

}
