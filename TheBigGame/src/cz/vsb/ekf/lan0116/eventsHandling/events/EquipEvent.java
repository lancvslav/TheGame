package cz.vsb.ekf.lan0116.eventsHandling.events;

import cz.vsb.ekf.lan0116.world.items.Item;

public class EquipEvent extends Event {

    private final Item weaponToEquip;

    public EquipEvent(EventType type, Item weaponToEquip) {
        super(EventType.EQUIP);
        this.weaponToEquip = weaponToEquip;
    }

    public Item getItemToEquip() {
        return weaponToEquip;
    }
}
