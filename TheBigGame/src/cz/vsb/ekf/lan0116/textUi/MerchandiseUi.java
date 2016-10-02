package cz.vsb.ekf.lan0116.textUi;

import cz.vsb.ekf.lan0116.events.TradeEvent;
import cz.vsb.ekf.lan0116.util.ListManageUtil;
import cz.vsb.ekf.lan0116.world.buildings.Shop;
import cz.vsb.ekf.lan0116.world.items.Merchandise;

import java.util.List;

class MerchandiseUi extends AbstractLocationUi<Shop> {

    private LocationUi locationUi;

    MerchandiseUi(Context context) {
        super(context);
        locationUi = new LocationUi(context);
    }

    @Override
    public Shop getLoc() {
        return (Shop) this.getContext().getHero().getPosition();
    }

    /**
     * Prints merchandise and asks if user wants to buy something or leave
     */
    @Override
    public void show() {
        System.out.println();
        List<Merchandise> merchandiseList = this.getLoc().getMerchandise();
        int lineCounter = 1;
        for (Merchandise merchandise : merchandiseList) {
            System.out.printf("%d %s, cost: %d%n", lineCounter++,
                    this.get(merchandise.getName()), merchandise.getCost());
        }
        System.out.printf("%n%s%n",this.get(TextUtil.quote("shop_offer")));
        System.out.printf("%s%n",this.get("textUi.MerchandiseUi.decline"));
        int choice = (Integer.parseInt(this.getContext().getScanner().nextLine()) - 1);
        if (!(choice >= 0)) {
            System.out.println(this.get(TextUtil.quote("shop_unhappy")));
            this.travel();
        } else {
            Merchandise merchandiseToPurchase = ListManageUtil.getMerchandise(merchandiseList, choice);
            this.getContext().getEventHandler().handleEvent(new TradeEvent(merchandiseToPurchase));
            System.out.printf("%s %s%n",
                    this.getContext().getLocalization().get(merchandiseToPurchase.getName()),
                    this.get("textUi.MerchandiseUi.purchased"));
            System.out.println(this.get(TextUtil.quote("shop_happy")));
            locationUi.show();
        }
    }
}
