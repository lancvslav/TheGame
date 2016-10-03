package cz.vsb.ekf.lan0116.textUi.locationUi;

import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.TextUtil;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractLocationUi;
import cz.vsb.ekf.lan0116.textUi.heroUi.RestHeroUi;
import cz.vsb.ekf.lan0116.world.Street;

class StreetUi extends AbstractLocationUi<Street> {

    RestHeroUi restHeroUi;

    public StreetUi(Context context) {
        super(context);
    }

    @Override
    public void show() {
        System.out.printf("\n%s %s%n", this.get(TextUtil.quote("current_location")), this.get(this.getLoc().getName()));
        System.out.println(this.get("textUi.StreetUi.paths"));
        for (int i = 0; i < this.getLoc().getGateways().size(); i++) {
            System.out.println(this.get(this.getLoc().getGateways().get(i).getTarget().getName()));
        }
        System.out.println("\n" + this.get(TextUtil.quote("location_decision")));
        switch (this.choice(
                this.get("textUi.menu.trouble"),
                this.get("textUi.menu.rest"),
                this.get("textUi.menu.somewhere"))) {
            case 0:
                System.out.printf("\n%s %s%n", this.get("textUi.location.just"), this.get(this.getLoc().getName()));
                break;
            case 1:
                restHeroUi = new RestHeroUi(getContext());
                restHeroUi.show();
                break;
            case 2:
                this.travel();
                break;
        }
    }

}
