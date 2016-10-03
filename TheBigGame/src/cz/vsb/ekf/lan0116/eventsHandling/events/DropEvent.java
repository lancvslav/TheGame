package cz.vsb.ekf.lan0116.eventsHandling.events;

import cz.vsb.ekf.lan0116.world.items.Item;

public class DropEvent extends Event {
    
    private final Item itemToDrop;
    
    public DropEvent(Item item) {
        super(EventType.DROP);
        this.itemToDrop = item;
    }
    
    public Item getItemToDrop() {
        return itemToDrop;
    }
    
}
