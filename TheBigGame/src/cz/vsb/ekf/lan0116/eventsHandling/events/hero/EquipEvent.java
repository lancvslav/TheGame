package cz.vsb.ekf.lan0116.eventsHandling.events.hero;

import cz.vsb.ekf.lan0116.eventsHandling.events.Event;
import cz.vsb.ekf.lan0116.eventsHandling.events.EventSuperType;
import cz.vsb.ekf.lan0116.eventsHandling.events.EventType;
import cz.vsb.ekf.lan0116.world.items.Item;

public class EquipEvent implements Event {

    private final Item weaponToEquip;

    public EquipEvent(EventType type, Item weaponToEquip) {
        this.weaponToEquip = weaponToEquip;
    }

    public Item getItemToEquip() {
        return weaponToEquip;
    }

    @Override
    public EventSuperType getSuperType() {
        return EventSuperType.HERO_EVENT;
    }

    @Override
    public Class getResponseType() {
        return null;
    }
}
