package cz.vsb.ekf.lan0116.textUi.locationUi.buildingUi.tavern;

import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.TextUtil;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractLocationUi;
import cz.vsb.ekf.lan0116.world.building.shop.Tavern;
import cz.vsb.ekf.lan0116.world.item.type.ConsumableType;

public class TavernUi extends AbstractLocationUi<Tavern> {

    public TavernUi(Context context) {
        super(context);
    }

    @Override
    public void show() {
        //You are at
        System.out.println("\n" + this.get(TextUtil.quote("current_location"))
                + " " + this.get(this.getLoc().getName()));

        System.out.println(this.get("textUi.ShopUi.doors"));
        for (int i = 0; i < this.getLoc().getGateways().size(); i++) {
            System.out.println(this.get(this.getLoc().getGateways().get(i).getTarget().getName()));
        }
        this.decisions();
    }

    @Override
    public void decisions() {
        switch (this.choice(
                this.get("drink offer"),
                this.get("food offer"),
                this.get("rumor"),
                this.get("leave this place")
        )) {
            case 0:
                new TavernOfferUi(this.getContext(), ConsumableType.DRINK).show();
                break;
            case 1:
                new TavernOfferUi(this.getContext(), ConsumableType.FOOD).show();
                break;
            case 2:
                System.out.println("I won't tell you anything.");
                this.decisions();
                break;
            case 3:
                this.travel();
                break;
        }
    }
}
