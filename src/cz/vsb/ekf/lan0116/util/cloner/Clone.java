package cz.vsb.ekf.lan0116.util.cloner;

import cz.vsb.ekf.lan0116.util.ResourceCache;

public abstract class Clone<Object> implements CloneInterface {
    private ResourceCache cache;

    public Clone(ResourceCache cache) {
        this.cache = cache;
    }

    public ResourceCache getCache() {
        return cache;
    }
}
