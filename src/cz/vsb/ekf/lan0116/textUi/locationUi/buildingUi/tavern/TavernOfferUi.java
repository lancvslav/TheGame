package cz.vsb.ekf.lan0116.textUi.locationUi.buildingUi.tavern;

import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.items.ConsumeEvent;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractLocationUi;
import cz.vsb.ekf.lan0116.util.ObjectFactory;
import cz.vsb.ekf.lan0116.world.location.building.shop.Tavern;
import cz.vsb.ekf.lan0116.world.item.Consumable;
import cz.vsb.ekf.lan0116.world.item.Merchandise;
import cz.vsb.ekf.lan0116.world.item.type.ConsumableType;

import java.util.ArrayList;
import java.util.List;

public class TavernOfferUi extends AbstractLocationUi<Tavern> {

    private ConsumableType offerDemand;
    private List<Merchandise> consumables;

    private TavernUi tavernUi;

    public TavernOfferUi(Context context, ConsumableType offerDemand) {
        super(context);
        this.offerDemand = offerDemand;
    }

    @Override
    public void show() {
     this.decisions();
    }

    @Override
    public void decisions() {
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
        this.printArray(merchandiseToArray(consumables));
        switch (offerDemand) {
            case DRINK:
                System.out.println("\n" + this.get("textUi.TavernUi.offer_drink"));
                System.out.printf("%d %s%n", consumables.size(), this.get("textUi.TavernUi.decline_drink"));
                break;
            case FOOD:
                System.out.println("\n" + this.get("textUi.TavernUi.offer_food"));
                System.out.printf("%d %s%n", consumables.size(), this.get("textUi.TavernUi.decline_food"));
                break;
        }
        int choice = Integer.parseInt(this.getContext().getScanner().nextLine());
        if (choice >= (consumables.size())) {
            System.out.println(this.get("textUi.no_money"));
            new TavernUi(this.getContext()).show();
        } else {
            String consumableId = consumables.get(choice).getName();
            Consumable consumableReceived = ObjectFactory.getConsumableObject(consumableId);
            Response consumeResponse = this.getContext().getEventPublisher()
                    .getResponse(new ConsumeEvent(consumableReceived));
            if (consumeResponse.isSuccess()) {
                System.out.println(this.get("textUi.resources.drink_shop_happy0"));
                System.out.println(this.get(consumableReceived.getName()) + " " + this.get("textUi.consumed"));
            }
            tavernUi = new TavernUi(this.getContext());
            tavernUi.decisions();
        }
    }
}
