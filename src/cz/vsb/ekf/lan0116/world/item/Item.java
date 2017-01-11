package cz.vsb.ekf.lan0116.world.item;

import cz.vsb.ekf.lan0116.world.item.type.ItemType;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) &&
                Objects.equals(itemType, item.itemType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, itemType);
    }
}
