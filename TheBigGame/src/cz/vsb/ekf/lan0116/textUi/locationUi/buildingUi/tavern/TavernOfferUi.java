package cz.vsb.ekf.lan0116.textUi.locationUi.buildingUi.tavern;

import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.TextUtil;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractLocationUi;
import cz.vsb.ekf.lan0116.util.ListManageUtil;
import cz.vsb.ekf.lan0116.world.building.shop.Tavern;
import cz.vsb.ekf.lan0116.world.item.Merchandise;
import cz.vsb.ekf.lan0116.world.item.type.ConsumableType;

import java.util.ArrayList;
import java.util.List;

public class TavernOfferUi extends AbstractLocationUi<Tavern> {

    private ConsumableType offerDemand;

    private TavernUi tavernUi;

    public TavernOfferUi(Context context, ConsumableType offerDemand) {
        super(context);
        this.offerDemand = offerDemand;
    }

    @Override
    public void show() {
        List<Merchandise> consumables;
        System.out.println();
        switch (offerDemand) {
            case DRINK:
                consumables = this.getLoc().getDrinkList();
                break;
            case FOOD:
                consumables = this.getLoc().getFoodList();
                break;
            default:
                consumables = new ArrayList<>();
        }
        this.printArray(consumablesToArray(consumables));
        switch (offerDemand) {
            case DRINK:
                System.out.printf("%d %s%n", consumables.size(), this.get("textUi.TavernUi.decline_drink"));
                break;
            case FOOD:
                System.out.printf("%d %s%n", consumables.size(), this.get("textUi.TavernUi.decline_food"));
                break;
        }
        int choice = Integer.parseInt(this.getContext().getScanner().nextLine());
        if (choice >= (consumables.size())) {
            System.out.println(this.get(TextUtil.quote("shop_unhappy")));
            new TavernUi(this.getContext()).show();
        }else{
            Merchandise consumableRecieved = ListManageUtil.getConsumable(consumables,choice);
        }


    }
}
