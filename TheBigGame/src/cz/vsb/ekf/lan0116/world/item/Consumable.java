package cz.vsb.ekf.lan0116.world.item;

import cz.vsb.ekf.lan0116.world.item.type.ConsumableType;

public class Consumable extends Merchandise {

    private final int replenishValue;

    public Consumable(String name, ConsumableType consumableType, int cost, int replenishValue) {
        super(name, consumableType, cost);
        this.replenishValue = replenishValue;
    }
}
