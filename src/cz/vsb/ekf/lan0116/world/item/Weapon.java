package cz.vsb.ekf.lan0116.world.item;

import cz.vsb.ekf.lan0116.combat.Attack;
import cz.vsb.ekf.lan0116.util.ListManageUtil;
import cz.vsb.ekf.lan0116.world.item.type.WeaponType;

import java.util.Arrays;
import java.util.List;

public class Weapon extends Merchandise {

    private final int damageRatio;
    private List<Attack> moveSet;

    public Weapon(String weaponId){
        ListManageUtil.getWeaponObject(weaponId);
    }

    public Weapon(String name, int cost, int damageRatio, WeaponType type, String... attackId) {
        super(name, type, cost);
        this.damageRatio = damageRatio;
        this.moveSet = ListManageUtil.attackList(Arrays.asList(attackId));
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
        return super.toString() + ", damageRatio: " + this.damageRatio + " , weapon type:"
                + this.getType().toString().toLowerCase();
    }

}
