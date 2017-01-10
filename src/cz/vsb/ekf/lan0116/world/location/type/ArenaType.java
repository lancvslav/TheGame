package cz.vsb.ekf.lan0116.world.location.type;

public enum ArenaType implements LocationType {
    ARENA,
    TOURNAMENT,
    /**/;

    @Override
    public LocationSuperType getSuperType() {
        return LocationSuperType.ARENA;
    }
}
