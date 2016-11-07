package cz.vsb.ekf.lan0116.world.location.type;

public enum StreetType implements LocationType {
    CROSS_ROAD,
    ROAD,
    SQUARE;

    @Override
    public LocationSuperType getSuperType() {
        return LocationSuperType.STREET;
    }
}
