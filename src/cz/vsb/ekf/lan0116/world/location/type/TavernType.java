package cz.vsb.ekf.lan0116.world.location.type;

public enum TavernType implements LocationType {
    TAVERN,;

    @Override
    public LocationSuperType getSuperType() {
        return LocationSuperType.TAVERN;
    }
}
