package cz.vsb.ekf.lan0116.textUi.locationUi.buildingUi.shopUi;

import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.shoping.TradeEvent;
import cz.vsb.ekf.lan0116.eventSystem.failures.TradeFailure;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.TextUtil;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractLocationUi;
import cz.vsb.ekf.lan0116.util.ListManageUtil;
import cz.vsb.ekf.lan0116.world.location.building.shop.Shop;
import cz.vsb.ekf.lan0116.world.item.Merchandise;

import java.util.List;

public class MerchandiseUi extends AbstractLocationUi<Shop> {

    private ShopUi shopUi;
    private List<Merchandise> merchandiseList;

    public MerchandiseUi(Context context) {
        super(context);
    }

    @Override
    public Shop getLoc() {
        return (Shop) this.getContext().getHero().getHeroInteraction().getPosition();
    }

    /**
     * Prints merchandise and asks if user wants to buy something or leave
     */
    @Override
    public void show() {
        merchandiseList = this.getLoc().getMerchandise();
        this.printArray(merchandiseToArray(merchandiseList));
        //QUOTE SPECIFIED FOR CURRENT SHOP type
        System.out.println("\n" + this.get(TextUtil.quote(
                this.getLoc().getType().toString().toLowerCase() + "_offer")));
        System.out.printf("%d %s%n", merchandiseList.size(), this.get("textUi.MerchandiseUi.decline"));
        this.decisions();
    }

    @Override
    public void decisions() {
        int choice = Integer.parseInt(this.getContext().getScanner().nextLine());
        if (choice >= (merchandiseList.size())) {
            System.out.println(this.get(TextUtil.quote(this.getLoc().getType()
                    .toString().toLowerCase() + "_unhappy")));
            this.travel();
        } else {
            Merchandise merchandiseToPurchase = ListManageUtil.getMerchandiseToBuy(merchandiseList, choice);
            Response responseTrade = this.getContext().
                    getEventPublisher().getResponse(new TradeEvent(merchandiseToPurchase));
            if (responseTrade.isSuccess()) {
                System.out.println(
                        this.get(TextUtil.quote(this.getLoc().getType().toString().toLowerCase() + "_happy")));
                System.out.println(this.getContext().getLocalization().get(merchandiseToPurchase.getName()) + " " +
                        this.get("textUi.MerchandiseUi.purchased"));
                shopUi = new ShopUi(this.getContext());
                shopUi.decisions();
            } else {
                TradeFailure failureCause = (TradeFailure) responseTrade.getFailureCause();
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

