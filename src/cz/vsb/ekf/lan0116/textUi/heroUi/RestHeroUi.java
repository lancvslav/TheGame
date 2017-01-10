package cz.vsb.ekf.lan0116.textUi.heroUi;

import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractHeroUi;
import cz.vsb.ekf.lan0116.textUi.locationUi.LocationUi;

public class RestHeroUi extends AbstractHeroUi {

    private InventoryUi inventoryUi;
    private LocationUi locationUi;

    public RestHeroUi(Context context) {
        super(context);
    }

    @Override
    public void show() {
        this.decisions();
    }

    private void decisions() {
        switch (this.choice(
                this.get("textUi.RestHeroUi.inventory"),
                this.get("textUi.RestHeroUi.consume"),
                "status",
                //localize, or maybe don't, just testing for now
                this.get("textUi.RestHeroUi.getUp"))) {
            case 0:
                inventoryUi = new InventoryUi(getContext());
                inventoryUi.show();
                break;
            case 1:
                System.out.println("\n" + this.get("textUi.RestHeroUi.starve"));
                this.decisions();
                break;
            case 2:
                System.out.println(this.getHero().getCurrentLifeEssence());
                break;
            case 3:
                locationUi = new LocationUi(getContext());
                locationUi.decisions();
                break;
        }
    }
}
