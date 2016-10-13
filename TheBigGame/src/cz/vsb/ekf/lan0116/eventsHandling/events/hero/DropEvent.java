package cz.vsb.ekf.lan0116.eventsHandling.events.hero;

import cz.vsb.ekf.lan0116.eventsHandling.events.Event;
import cz.vsb.ekf.lan0116.eventsHandling.events.EventType;
import cz.vsb.ekf.lan0116.eventsHandling.events.type.HeroType;
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
    public EventType getType() {
        return HeroType.DROP;
    }

    @Override
    public Class getResponseType() {
        return null;
    }
}
