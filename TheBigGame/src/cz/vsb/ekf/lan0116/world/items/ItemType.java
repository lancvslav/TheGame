package cz.vsb.ekf.lan0116.world.items;

public enum ItemType implements ItemSubType {
    MELEE(ItemSuperType.WEAPON),
    RANGED(ItemSuperType.WEAPON),
    WAND(ItemSuperType.WEAPON),
    FOOD(ItemSuperType.CONSUMABLE),
    DRINK(ItemSuperType.CONSUMABLE),;

    private final ItemSuperType superType;

    ItemType(ItemSuperType superType) {
        this.superType = superType;
    }

    @Override
    public ItemSuperType getSuperType() {
        return this.superType;
    }

}
