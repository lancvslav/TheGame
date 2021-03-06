package cz.vsb.ekf.lan0116.world.item;

import cz.vsb.ekf.lan0116.world.item.type.ItemType;

public class Merchandise extends Item {

    private final int cost;

    public Merchandise(String name, ItemType itemType, int cost) {
        super(name, itemType);
        this.cost = cost;
      }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return this.getName() + ", cost: " + this.cost;
    }

}
