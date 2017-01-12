package cz.vsb.ekf.lan0116.world.creature.hero;

import cz.vsb.ekf.lan0116.world.item.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inventory {

    private List<Item> inventory;

    public Inventory() {
        this.inventory = new ArrayList<>();
    }

    public Inventory(Item item) {
        this.inventory = new ArrayList<>();
        this.inventory.add(item);
    }

    public Inventory(Item... items) {
        this.inventory = new ArrayList<>(Arrays.asList(items));
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
