package cz.vsb.ekf.lan0116.world.location.building.shop;

import cz.vsb.ekf.lan0116.util.ListManageUtil;
import cz.vsb.ekf.lan0116.util.ResourceType;
import cz.vsb.ekf.lan0116.util.ResourceUtil;
import cz.vsb.ekf.lan0116.world.creature.humanoid.Humanoid;
import cz.vsb.ekf.lan0116.world.item.Merchandise;
import cz.vsb.ekf.lan0116.world.location.building.Building;
import cz.vsb.ekf.lan0116.world.location.type.TavernType;

import java.util.List;

public class Tavern extends Building {

    private List<Merchandise> drinkList;
    private List<Merchandise> foodList;
    private Humanoid inkeeper;

    public Tavern() {
        super("world.building.shop.tavern", TavernType.TAVERN);
        this.drinkList = ListManageUtil.consumableList(ResourceUtil.getResource(ResourceType.DRINK, this.getName()));
        this.foodList = ListManageUtil.consumableList(ResourceUtil.getResource(ResourceType.FOOD, this.getName()));
    }

    public List<Merchandise> getDrinkList() {
        return drinkList;
    }

    public List<Merchandise> getFoodList() {
        return foodList;
    }

    public Humanoid getInkeeper() {
        return inkeeper;
    }
}
