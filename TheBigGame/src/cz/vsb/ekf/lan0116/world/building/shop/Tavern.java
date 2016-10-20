package cz.vsb.ekf.lan0116.world.building.shop;

import cz.vsb.ekf.lan0116.util.ListManageUtil;
import cz.vsb.ekf.lan0116.util.ResourceType;
import cz.vsb.ekf.lan0116.util.ResourceUtil;
import cz.vsb.ekf.lan0116.world.LocationType;
import cz.vsb.ekf.lan0116.world.building.Building;
import cz.vsb.ekf.lan0116.world.item.Merchandise;

import java.util.List;

public class Tavern extends Building {

    private List<Merchandise> drinkList;
    private List<Merchandise> foodList;

    public Tavern() {
        super("world.buildings.shop.tavern", LocationType.TAVERN);
        this.drinkList = ListManageUtil.consumableList(ResourceUtil.getResource(ResourceType.DRINK, this.getName()));
        this.foodList = ListManageUtil.consumableList(ResourceUtil.getResource(ResourceType.FOOD, this.getName()));
    }

    public List<Merchandise> getDrinkList() {
        return drinkList;
    }

    public List<Merchandise> getFoodList() {
        return foodList;
    }
}
