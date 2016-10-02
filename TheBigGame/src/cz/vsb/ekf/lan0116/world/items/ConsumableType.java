package cz.vsb.ekf.lan0116.world.items;

public enum ConsumableType implements ItemType {
    FOOD(ItemSuperType.CONSUMABLE),
    DRINK(ItemSuperType.CONSUMABLE),;

    private final ItemSuperType superType;

    ConsumableType(ItemSuperType superType) {
        this.superType = superType;
    }

    @Override
    public ItemSuperType getSuperType() {
        return this.superType;
    }

}
