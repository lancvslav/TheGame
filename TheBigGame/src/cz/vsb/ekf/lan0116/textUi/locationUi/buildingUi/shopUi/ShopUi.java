package cz.vsb.ekf.lan0116.textUi.locationUi.buildingUi.shopUi;

import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.TextUtil;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractLocationUi;
import cz.vsb.ekf.lan0116.textUi.heroUi.RestHeroUi;
import cz.vsb.ekf.lan0116.world.building.shop.Shop;

public class ShopUi extends AbstractLocationUi<Shop> {

    private MerchandiseUi merchandiseUi;
    private RestHeroUi restHeroUi;

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
        System.out.println();
        switch (this.choice(
                this.get("textUi.ShopUi.ask"),
                this.get("textUi.menu.rest"),
                this.get("textUi.ShopUi.leave"))) {
            case 0:
                merchandiseUi = new MerchandiseUi(getContext());
                merchandiseUi.show();
                break;
            case 1:
                restHeroUi = new RestHeroUi(getContext());
                restHeroUi.show();
                break;
            case 2:
                this.travel();
                break;
        }
    }
}
