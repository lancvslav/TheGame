package cz.vsb.ekf.lan0116.eventsHandling.events.hero;

import cz.vsb.ekf.lan0116.eventsHandling.events.Event;
import cz.vsb.ekf.lan0116.eventsHandling.events.EventType;
import cz.vsb.ekf.lan0116.eventsHandling.events.type.HeroType;
import cz.vsb.ekf.lan0116.world.items.Item;

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

    @Override
    public Class getResponseType() {
        return null;
    }
}
