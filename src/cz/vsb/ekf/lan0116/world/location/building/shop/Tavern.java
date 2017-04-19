package cz.vsb.ekf.lan0116.world.location.building.shop;

import cz.vsb.ekf.lan0116.world.creature.humanoid.Humanoid;
import cz.vsb.ekf.lan0116.world.item.Merchandise;
import cz.vsb.ekf.lan0116.world.location.building.Building;
import cz.vsb.ekf.lan0116.world.location.type.TavernType;

import java.util.List;

public class Tavern extends Building {

    private Humanoid innkeeper;
    private List<Merchandise> drinkList;
    private List<Merchandise> foodList;

    public Tavern(Humanoid innkeeper, String shopName, List<Merchandise> drinkList, List<Merchandise> foodList) {
        super(shopName, TavernType.TAVERN);
        this.innkeeper = innkeeper;
        this.drinkList = drinkList;
        this.foodList = foodList;
    }

    public List<Merchandise> getDrinkList() {
        return drinkList;
    }

    public List<Merchandise> getFoodList() {
        return foodList;
    }

    public Humanoid getInnkeeper() {
        return innkeeper;
    }
}
