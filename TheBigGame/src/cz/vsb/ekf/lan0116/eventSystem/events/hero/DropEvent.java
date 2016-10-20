package cz.vsb.ekf.lan0116.eventSystem.events.hero;

import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.HeroType;
import cz.vsb.ekf.lan0116.world.item.Item;

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

}
