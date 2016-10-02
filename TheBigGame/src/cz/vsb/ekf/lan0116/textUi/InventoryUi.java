package cz.vsb.ekf.lan0116.textUi;

import cz.vsb.ekf.lan0116.events.DropEvent;
import cz.vsb.ekf.lan0116.events.EquipEvent;
import cz.vsb.ekf.lan0116.events.EventType;
import cz.vsb.ekf.lan0116.world.items.Item;
import cz.vsb.ekf.lan0116.world.items.Weapon;

class InventoryUi extends AbstractUi {

    private RestHeroUi restHeroUi;

    InventoryUi(Context context) {
        super(context);
        restHeroUi = new RestHeroUi(context);
    }

    @Override
    public void show() {
        if (this.getContext().getHero().getInventory().getInventory().isEmpty()) {
            System.out.printf("\n%s\n%n", this.get("textUi.InventoryUi.empty"));
            restHeroUi.show();
            return;
        }
        System.out.println();
        int lineCounter = 0;
        for (Item item : this.getContext().getHero().getInventory().getInventory()) {
            System.out.println((lineCounter++) + " " + this.get(item.getName()));
        }
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
                try {
                    this.getContext().getEventHandler().handleEvent(new EquipEvent(EventType.EQUIP,
                            (Weapon) this.getContext().getHero().getInventory().getItem(choiceTemp)));
                    System.out.println("You are wielding " +
                            this.get(this.getContext().getHero().getWeapon().getName()));
                } catch (ClassCastException ex) {
                    System.out.println("You can't wield that.");
                    this.show();
                }
                break;
            case 2:
                System.out.println(this.get("textUi.InventoryUi.which_one"));
                choiceTemp = Integer.parseInt(getContext().getScanner().nextLine());
                System.out.println(
                        this.get("textUi.Inventory.really0") + " " +
                                this.get(this.getContext().getHero().
                                        getInventory().getInventory().get(choiceTemp).getName())
                                + this.get("textUi.Inventory.really1"));
                switch (this.choice(
                        this.get("textUi.menu.yes"),
                        this.get("textUi.menu.no"))) {
                    case 0:
                        this.getContext().getEventHandler().handleEvent(new DropEvent(this.getContext()
                                .getHero().getInventory().getInventory().get(choiceTemp)));
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
