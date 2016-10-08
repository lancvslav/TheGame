package cz.vsb.ekf.lan0116.textUi.heroUi;

import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.locationUi.LocationUi;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractUi;

public class RestHeroUi extends AbstractUi {

    private InventoryUi inventoryUi;
    private LocationUi locationUi;

    public RestHeroUi(Context context) {
        super(context);
    }

    @Override
    public void show() {
        System.out.println();
        switch (this.choice(
                this.get("textUi.RestHeroUi.inventory"),
                this.get("textUi.RestHeroUi.consume"),
                this.get("textUi.RestHeroUi.getUp"))) {
            case 0:
                inventoryUi = new InventoryUi(getContext());
                inventoryUi.show();
                break;
            case 1:
                System.out.println("\n" + this.get("textUi.RestHeroUi.starve"));
                this.show();
                break;
            case 2:
                locationUi = new LocationUi(getContext());
                locationUi.show();
        }
    }

}
