package cz.vsb.ekf.lan0116.world.item;

import cz.vsb.ekf.lan0116.world.item.type.ItemType;

public class Item {

    private final String name;
    private final ItemType itemType;

    public Item(String name, ItemType itemType) {
        this.name = name;
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public ItemType getItemType() {
        return itemType;
    }

}