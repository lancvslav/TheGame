package cz.vsb.ekf.lan0116.util.cloner;

public interface CloneInterface<T extends Object> {
    T clone(String objectId);
}
