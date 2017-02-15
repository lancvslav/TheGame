package cz.vsb.ekf.lan0116.textUi.locationUi.buildingUi.shopUi;

import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractCreatureUi;

public class MerchantUi extends AbstractCreatureUi {
    protected MerchantUi(Context context) {
        super(context);
    }

    @Override
    public void show() {
        switch (this.choice(this.get("textUi.MerchantUi.talk"),
                this.get("textUi.MerchantUi.trade"),
                this.get("textUi.MerchantUi.leave"))) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
    }


}
