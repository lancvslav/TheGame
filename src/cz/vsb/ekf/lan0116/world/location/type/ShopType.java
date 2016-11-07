package cz.vsb.ekf.lan0116.world.location.type;

public enum ShopType implements LocationType {
    DRINK_SHOP,
    FOOD_SHOP,
    WEAPON_SHOP,;

    @Override
    public LocationSuperType getSuperType() {
        return LocationSuperType.SHOP;
    }
}
