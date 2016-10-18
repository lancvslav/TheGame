package cz.vsb.ekf.lan0116.world.items.type;

public enum ConsumableType implements ItemType {
    DRINK(ItemSuperType.CONSUMABLE),
    FOOD(ItemSuperType.CONSUMABLE),;

    private final ItemSuperType superType;

    ConsumableType(ItemSuperType superType) {
        this.superType = superType;
    }

    @Override
    public ItemSuperType getSuperType() {
        return this.superType;
    }

}
