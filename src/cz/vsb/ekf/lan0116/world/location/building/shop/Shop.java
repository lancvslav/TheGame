package cz.vsb.ekf.lan0116.world.location.building.shop;

import cz.vsb.ekf.lan0116.world.item.Merchandise;
import cz.vsb.ekf.lan0116.world.location.building.Building;
import cz.vsb.ekf.lan0116.world.location.type.LocationType;

import java.util.ArrayList;
import java.util.List;

public class Shop extends Building {

    private List<Merchandise> merchandise;

    public Shop(String shopName, LocationType shopType) {
        super(shopName, shopType);
    }

    protected void setMerchandise(List<Merchandise> merchandise) {
        this.merchandise = merchandise;
    }

    protected void setMerchandise(List<Merchandise>... lists) {
        List<Merchandise> listToSet = new ArrayList<>();
        for (List<? extends Merchandise> list : lists) {
            listToSet.addAll(list);
        }
        this.setMerchandise(listToSet);
    }

    public List<Merchandise> getMerchandise() {
        return merchandise;
    }

}
