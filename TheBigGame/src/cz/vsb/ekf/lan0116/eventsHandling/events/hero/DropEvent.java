package cz.vsb.ekf.lan0116.eventsHandling.events.hero;

import cz.vsb.ekf.lan0116.eventsHandling.events.EventSuperType;
import cz.vsb.ekf.lan0116.eventsHandling.events.EventTypeInterface;
import cz.vsb.ekf.lan0116.world.items.Item;

public class DropEvent implements EventTypeInterface {

    private final Item itemToDrop;

    public DropEvent(Item item) {
        this.itemToDrop = item;
    }

    public Item getItemToDrop() {
        return itemToDrop;
    }

    @Override
    public EventSuperType getEventSuperType() {
        return EventSuperType.HERO_EVENT;
    }
}
