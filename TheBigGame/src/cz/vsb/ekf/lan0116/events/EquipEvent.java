package cz.vsb.ekf.lan0116.events;

import cz.vsb.ekf.lan0116.world.items.Weapon;

public class EquipEvent extends Event {

    private final Weapon weaponToEquip;

    public EquipEvent(EventType type, Weapon weaponToEquip) {
        super(EventType.EQUIP);
        this.weaponToEquip = weaponToEquip;
    }

    public Weapon getWeaponToEquip() {
        return weaponToEquip;
    }
}
