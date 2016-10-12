package cz.vsb.ekf.lan0116.eventsHandling.events.hero;

import cz.vsb.ekf.lan0116.eventsHandling.events.Event;
import cz.vsb.ekf.lan0116.eventsHandling.events.EventSuperType;
import cz.vsb.ekf.lan0116.world.items.Item;

public class DropEvent implements Event {

    private final Item itemToDrop;

    public DropEvent(Item item) {
        this.itemToDrop = item;
    }

    public Item getItemToDrop() {
        return itemToDrop;
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
