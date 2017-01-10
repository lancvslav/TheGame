package cz.vsb.ekf.lan0116.textUi.heroUi;

import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.items.DropEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.items.EquipEvent;
import cz.vsb.ekf.lan0116.eventSystem.failures.EquipFailure;
import cz.vsb.ekf.lan0116.eventSystem.failures.InventoryFailure;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractHeroUi;
import cz.vsb.ekf.lan0116.world.item.Item;

public class InventoryUi extends AbstractHeroUi {

    public InventoryUi(Context context) {
        super(context);
    }

    @Override
    public void show() {
        if (this.getContext().getHero().getInventory().getInventoryList().isEmpty()) {
            System.out.printf("\n%s\n%n", this.get("textUi.InventoryUi.empty"));
            return;
        }
        this.decisions();
    }

    private void decisions() {
        switch (this.choice(
                this.get("textUi.InventoryUi.choice0.inspect"),
                this.get("textUi.InventoryUi.choice1.equip"),
                this.get("textUi.InventoryUi.choice2.drop"),
                this.get("textUi.InventoryUi.choice3.close"))) {
            case 0:
                this.printArray(itemsToArray(this.getContext().getHero().getInventory().getInventoryList()));
                System.out.println(this.get("textUi.InventoryUi.which_one"));
                int choiceTemp = Integer.parseInt(this.getContext().getScanner().nextLine());
                try {
                    Item itemToShow = this.getContext().getHero().getInventory().getItem(choiceTemp);
                    switch (itemToShow.getItemType().getSuperType()) {
                        case CONSUMABLE:
                            this.printConsumable(itemToShow);
                            break;
                        case WEAPON:
                            this.printWeapon(itemToShow);
                            break;
                    }
                    this.decisions();
                } catch (IndexOutOfBoundsException ex) {
                    System.out.println(this.get("textUi.InventoryUi.don't_own"));
                    this.decisions();
                }
                break;
            case 1:
                this.printArray(itemsToArray(this.getContext().getHero().getInventory().getInventoryList()));
                System.out.println(this.get("textUi.InventoryUi.which_one"));
                choiceTemp = Integer.parseInt(getContext().getScanner().nextLine());
                Response responseEquip = this.getContext()
                        .getEventPublisher().getResponse(
                                new EquipEvent(this.getContext().getHero().getInventory().getItem(choiceTemp)));
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
                this.decisions();
                break;
            case 2:
                this.printArray(itemsToArray(this.getContext().getHero().getInventory().getInventoryList()));
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
                        Response responseDrop = this.getContext()
                                .getEventPublisher().getResponse(new DropEvent(this.getContext()
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
                        this.decisions();
                        break;
                    case 1:
                        this.decisions();
                }
                break;
            case 3:
                //close (return;)
        }
    }

}
