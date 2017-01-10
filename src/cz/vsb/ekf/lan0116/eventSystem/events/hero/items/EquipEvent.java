package cz.vsb.ekf.lan0116.eventSystem.events.hero.items;

import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.HeroType;
import cz.vsb.ekf.lan0116.world.item.Item;

public class EquipEvent implements Event {

    private final Item weaponToEquip;

    public EquipEvent(Item weaponToEquip) {
        this.weaponToEquip = weaponToEquip;
    }

    public Item getItemToEquip() {
        return weaponToEquip;
    }

    @Override
    public EventType getType() {
        return HeroType.EQUIP;
    }

}
