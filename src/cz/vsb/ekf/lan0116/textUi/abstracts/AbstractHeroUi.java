package cz.vsb.ekf.lan0116.textUi.abstracts;

import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;
import cz.vsb.ekf.lan0116.world.item.Consumable;
import cz.vsb.ekf.lan0116.world.item.Item;
import cz.vsb.ekf.lan0116.world.item.Weapon;

public abstract class AbstractHeroUi extends AbstractCreatureUi {

    protected AbstractHeroUi(Context context) {
        super(context.getHero(), context);
    }

    public Hero getHero() {
        return this.getContext().getHero();
    }

    /**
     * Prints desired Consumable
     */
    protected void printConsumable(Item itemToPrint) {
        Consumable item = (Consumable) itemToPrint;
        System.out.println(this.get(item.getName()) + ", "
                + this.get("textUi.InventoryUi.replenish") + ": " + item.getReplenishValue() + ", "
                + this.get("textUi.InventoryUi.value") + ": " + item.getCost() + ", "
                + this.get("textUi.InventoryUi.type") + ": " + this.get(item.getItemType().toString().toLowerCase()));
    }

    /**
     * Prints desired weapon
     */
    protected void printWeapon(Item itemToPrint) {
        Weapon item = (Weapon) itemToPrint;
        System.out.println(this.get(item.getName()) + ", "
                + this.get("textUi.InventoryUi.damage_ratio") + " " + item.getDamageRatio() + ", "
                + this.get("textUi.InventoryUi.value") + " " + item.getCost() + ", "
                + this.get("textUi.InventoryUi.type") + " " + this.get(item.getItemType().toString().toLowerCase()));
    }
}
