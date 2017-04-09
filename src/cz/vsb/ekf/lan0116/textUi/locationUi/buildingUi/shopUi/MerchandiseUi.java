package cz.vsb.ekf.lan0116.textUi.locationUi.buildingUi.shopUi;

import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.npc.InteractEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.npc.shoping.PurchaseEvent;
import cz.vsb.ekf.lan0116.eventSystem.failures.PurchaseFailure;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.TextUtil;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractLocationUi;
import cz.vsb.ekf.lan0116.world.item.Merchandise;
import cz.vsb.ekf.lan0116.world.location.building.shop.Shop;

import java.util.List;

public class MerchandiseUi extends AbstractLocationUi<Shop> {

    private List<Merchandise> merchandiseList;

    public MerchandiseUi(Context context) {
        super(context);
        merchandiseList = this.getLoc().getMerchandise();
    }

    @Override
    public Shop getLoc() {
        return (Shop) this.getContext().getHero().getHeroInteraction().getPosition();
    }

    /**
     * Prints merchandise and asks if player wants to buy something or leave
     */
    @Override
    public void show() {
        this.printArray(merchandiseToArray(merchandiseList));
        //QUOTE SPECIFIED FOR CURRENT SHOP type
        System.out.println("\n" + this.get(TextUtil.quote(
                this.getLoc().getType().toString().toLowerCase() + "_offer")));
        System.out.printf("%d %s%n", merchandiseList.size(), this.get("textUi.MerchandiseUi.decline"));
        this.decisions();
    }

    /**
     * Prints merchandise of shop with indexes. It also gives choice to decline offer
     */
    @Override
    public void decisions() {
        int choice = Integer.parseInt(this.getContext().getScanner().nextLine());
        if (choice >= (merchandiseList.size())) {
            System.out.println(this.get(TextUtil.quote(this.getLoc().getType()
                    .toString().toLowerCase() + "_unhappy")));
            this.getContext().getSession().fireEvent(new InteractEvent(this.getLoc().getMerchant()));
        } else {
            Merchandise merchandiseToPurchase = this.getLoc().getMerchandise().get(choice);
            Response responseTrade = this.getContext().
                    getSession().fireEvent(new PurchaseEvent(merchandiseToPurchase));
            if (responseTrade.isSuccess()) {
                System.out.println(
                        this.get(TextUtil.quote(this.getLoc().getType().toString().toLowerCase() + "_happy")));
                System.out.println(this.getContext().getLocalization().get(merchandiseToPurchase.getName()) + " " +
                        this.get("textUi.MerchandiseUi.purchased"));
            } else {
                PurchaseFailure failureCause = (PurchaseFailure) responseTrade.getFailureCause();
                switch (failureCause) {
                    case NOT_ENOUGH_GOLD:
                        System.out.println(this.get("textUi.MerchandiseUi.not_enough_gold"));
                        this.decisions();
                        break;
                }
            }
        }
    }
}

