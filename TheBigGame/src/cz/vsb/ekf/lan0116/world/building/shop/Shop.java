package cz.vsb.ekf.lan0116.world.building.shop;

import cz.vsb.ekf.lan0116.world.Location;
import cz.vsb.ekf.lan0116.world.LocationType;
import cz.vsb.ekf.lan0116.world.item.Merchandise;

import java.util.ArrayList;
import java.util.List;

public class Shop extends Location {

    private List<Merchandise> merchandise;

    public Shop(String shopName) {
        super(shopName, LocationType.SHOP);
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
