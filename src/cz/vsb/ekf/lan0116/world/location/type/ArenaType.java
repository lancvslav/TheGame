package cz.vsb.ekf.lan0116.world.location.type;

public enum ArenaType implements LocationType {
    ARENA,;

    @Override
    public LocationSuperType getSuperType() {
        return LocationSuperType.ARENA;
    }
}
