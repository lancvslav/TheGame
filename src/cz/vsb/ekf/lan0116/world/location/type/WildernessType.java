package cz.vsb.ekf.lan0116.world.location.type;

public enum WildernessType implements LocationType {
    WILDERNESS,;

    @Override
    public LocationSuperType getSuperType() {
        return LocationSuperType.WILDERNESS;
    }
}
