package cz.vsb.ekf.lan0116.util.cloner;

public interface iClone<T extends Object> {
    T clone(String objectId);
}
