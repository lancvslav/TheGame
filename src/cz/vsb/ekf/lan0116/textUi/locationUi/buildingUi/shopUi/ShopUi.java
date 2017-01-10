package cz.vsb.ekf.lan0116.textUi.locationUi.buildingUi.shopUi;

import cz.vsb.ekf.lan0116.eventSystem.events.hero.RestEvent;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.TextUtil;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractLocationUi;
import cz.vsb.ekf.lan0116.world.location.building.shop.Shop;

public class ShopUi extends AbstractLocationUi<Shop> {

    public ShopUi(Context context) {
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
                this.get("textUi.ShopUi.ask"),
                this.get("textUi.menu.rest"),
                this.get("textUi.ShopUi.leave"))) {
            case 0:
                new MerchandiseUi(getContext()).show();
                break;
            case 1:
                this.getContext().getEventPublisher().getResponse(new RestEvent());
                break;
            case 2:
                this.travel();
                break;
        }
    }
}
