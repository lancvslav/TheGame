package cz.vsb.ekf.lan0116.world.buildings;

import cz.vsb.ekf.lan0116.world.Location;
import cz.vsb.ekf.lan0116.world.LocationType;
import cz.vsb.ekf.lan0116.world.items.Merchandise;

import java.util.List;

public class Shop extends Location {

    private List<Merchandise> merchandise;

    public Shop(String shopName) {
        super(shopName, LocationType.SHOP);
//        this.merchandise = FileManageUtil.merchandiseList(ResourceUtil.getResource(ResourceType.MERCHANDISE, shopName.toLowerCase().replace(" ", "")));
    }

    protected void setMerchandise(List<? extends Merchandise> merchandise) {
        this.merchandise = (List<Merchandise>) merchandise;
    }

    public List<Merchandise> getMerchandise() {
        return merchandise;
    }

}
