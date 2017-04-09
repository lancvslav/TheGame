package cz.vsb.ekf.lan0116.textUi.locationUi.buildingUi.shopUi;

import cz.vsb.ekf.lan0116.eventSystem.events.hero.npc.InteractEvent;
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
        System.out.println(this.get("textUi.ShopUi.you_see"));
        this.decisions();
    }

    @Override
    public void decisions() {
        switch (this.choice(
                this.get("textUi.menu.rest"),
                this.get("textUi.ShopUi.talk"),
                this.get("textUi.ShopUi.leave"))) {
            case 0:
                this.getContext().getSession().fireEvent(new RestEvent());
                break;
            case 1:
                this.getContext().getSession().fireEvent(new InteractEvent(this.getLoc().getMerchant()));
                break;
            case 2:
                this.travel();
                break;
        }
    }
}
