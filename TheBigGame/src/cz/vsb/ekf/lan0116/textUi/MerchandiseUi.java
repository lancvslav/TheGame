package cz.vsb.ekf.lan0116.textUi;

import cz.vsb.ekf.lan0116.eventsHandling.Response;
import cz.vsb.ekf.lan0116.eventsHandling.events.TradeEvent;
import cz.vsb.ekf.lan0116.eventsHandling.failures.TradeFailure;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractLocationUi;
import cz.vsb.ekf.lan0116.textUi.locationUi.LocationUi;
import cz.vsb.ekf.lan0116.util.ListManageUtil;
import cz.vsb.ekf.lan0116.world.buildings.Shop;
import cz.vsb.ekf.lan0116.world.items.Merchandise;

import java.util.List;

public class MerchandiseUi extends AbstractLocationUi<Shop> {

    private LocationUi locationUi;

    public MerchandiseUi(Context context) {
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
        this.printArray(merchandiseToArray(merchandiseList));
        System.out.println("\n" + this.get(TextUtil.quote("shop_offer")));
        System.out.printf("%d %s%n", merchandiseList.size(), this.get("textUi.MerchandiseUi.decline"));
        int choice = Integer.parseInt(this.getContext().getScanner().nextLine());
        if (choice >= (merchandiseList.size())) {
            System.out.println(this.get(TextUtil.quote("shop_unhappy")));
            this.travel();
        } else {
            Merchandise merchandiseToPurchase = ListManageUtil.getMerchandise(merchandiseList, choice);
            Response response = this.getContext().getEventHandler().handleEvent(new TradeEvent(merchandiseToPurchase));
            if (response.isSuccess()) {
                System.out.println(this.getContext().getLocalization().get(merchandiseToPurchase.getName()) + " " +
                        this.get("textUi.MerchandiseUi.purchased"));
            } else {
                TradeFailure failureCause = (TradeFailure) response.getFailureCause();
                switch (failureCause){
                    case NOT_ENOUGH_GOLD:
                        System.out.println("Not enough gold.");
                        this.show();
                }
            }
            locationUi.show();
        }
    }
}
