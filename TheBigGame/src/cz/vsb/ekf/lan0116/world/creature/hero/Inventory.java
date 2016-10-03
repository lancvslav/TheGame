package cz.vsb.ekf.lan0116.world.creature.hero;

import cz.vsb.ekf.lan0116.world.items.Item;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inventory {

    private List<Item> inventory;

    public Inventory() {
        inventory = new ArrayList<>();
    }

    public Inventory(Item item) {
        inventory = new ArrayList<>();
        inventory.add(item);
    }

    public Inventory(Item... items) {
        inventory = new ArrayList<>(Arrays.asList(items));
    }

    public List<Item> getInventoryList() {
        return inventory;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void dropItem(Item item) {
        inventory.remove(item);
    }

    public Item getItem(int itemIndex) {
        return inventory.get(itemIndex);
    }

}
