package cz.vsb.ekf.lan0116.textUi.heroUi;

import cz.vsb.ekf.lan0116.eventsHandling.Response;
import cz.vsb.ekf.lan0116.eventsHandling.events.DropEvent;
import cz.vsb.ekf.lan0116.eventsHandling.events.EquipEvent;
import cz.vsb.ekf.lan0116.eventsHandling.events.EventType;
import cz.vsb.ekf.lan0116.eventsHandling.failures.EquipFailure;
import cz.vsb.ekf.lan0116.eventsHandling.failures.InventoryFailure;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractUi;
import cz.vsb.ekf.lan0116.world.items.Item;

public class InventoryUi extends AbstractUi {

    private RestHeroUi restHeroUi;

    public InventoryUi(Context context) {
        super(context);
        restHeroUi = new RestHeroUi(context);
    }

    @Override
    public void show() {
        if (this.getContext().getHero().getInventory().getInventoryList().isEmpty()) {
            System.out.printf("\n%s\n%n", this.get("textUi.InventoryUi.empty"));
            restHeroUi.show();
            return;
        }
        System.out.println();
        this.printArray(itemsToArray(this.getContext().getHero().getInventory().getInventoryList()));
        System.out.println();

        System.out.println();
        switch (this.choice(
                this.get("textUi.InventoryUi.choice0.inspect"),
                this.get("textUi.InventoryUi.choice1.equip"),
                this.get("textUi.InventoryUi.choice2.drop"),
                this.get("textUi.InventoryUi.choice3.close"))) {
            case 0:
                System.out.println(this.get("textUi.InventoryUi.which_one"));
                int choiceTemp = Integer.parseInt(this.getContext().getScanner().nextLine());
                try {
                    Item itemToShow = this.getContext().getHero().getInventory().getItem(choiceTemp);
                    System.out.println((itemToShow));
                    this.show();
                } catch (IndexOutOfBoundsException ex) {
                    System.out.println(this.get("textUi.InventoryUi.don't_own"));
                    this.show();
                }
                break;
            case 1:
                System.out.println(this.get("textUi.InventoryUi.which_one"));
                choiceTemp = Integer.parseInt(getContext().getScanner().nextLine());
                Response responseEquip = this.getContext().getEventHandler().handleEvent(new EquipEvent(EventType.EQUIP,
                        this.getContext().getHero().getInventory().getItem(choiceTemp)));
                if (responseEquip.isSuccess()) {
                    System.out.println(this.get("textUi.InventoryUi.wielding") + " " +
                            this.get(this.getContext().getHero().getWeapon().getName()));
                } else {
                    EquipFailure failureCause = (EquipFailure) responseEquip.getFailureCause();
                    switch (failureCause) {
                        case CLAZZ_DIFF:
                            System.out.println(this.get("textUi.InventoryUi.not_eligible"));
                            break;
                        case NOT_A_WEAPON:
                            System.out.println(this.get("textUi.InventoryUi.not_a_weapon"));
                            break;
                    }
                }
                this.show();
                break;
            case 2:
                System.out.println(this.get("textUi.InventoryUi.which_one"));
                choiceTemp = Integer.parseInt(getContext().getScanner().nextLine());
                System.out.println(
                        this.get("textUi.InventoryUi.really0") + " " +
                                this.get(this.getContext().getHero().
                                        getInventory().getInventoryList().get(choiceTemp).getName())
                                + this.get("textUi.InventoryUi.really1"));
                switch (this.choice(
                        this.get("textUi.menu.yes"),
                        this.get("textUi.menu.no"))) {
                    case 0:
                        Response responseDrop = this.getContext().getEventHandler()
                                .handleEvent(new DropEvent(this.getContext()
                                        .getHero().getInventory().getInventoryList().get(choiceTemp)));
                        if (responseDrop.isSuccess()) {
                            System.out.println(this.get("textUi.InventoryUi.dropped"));
                        } else {
                            InventoryFailure failureCause = (InventoryFailure) responseDrop.getFailureCause();
                            switch (failureCause) {
                                case NOT_IN_INVENTORY:
                                    System.out.println(this.get("textUi.InventoryUi.not_in_inventory"));
                                    break;
                            }
                        }
                        this.show();
                        break;
                    case 1:
                        this.show();
                }
                break;
            case 3:
                restHeroUi.show();
                break;
        }
    }
}
