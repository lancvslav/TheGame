package cz.vsb.ekf.lan0116.textUi.locationUi;

import cz.vsb.ekf.lan0116.eventSystem.events.hero.GetReadyEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.shoping.TradeEvent;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractMerchantUi;

public class InteractUi extends AbstractMerchantUi {
    public InteractUi(Context context) {
        super(context);
    }

    @Override
    public void show() {
        this.decisions();
    }

    @Override
    protected void decisions() {
        switch (this.choice(this.get("textUi.InteractUi.talk"),
                this.get("textUi.InteractUi.trade"),
                this.get("textUi.InteractUi.leave"))) {
            case 0:
                //talk Ui?
                break;
            case 1:
                this.getContext().getEventPublisher().getResponse(new TradeEvent(this.getMerchant()));
                break;
            case 2:
                this.getContext().getEventPublisher().getResponse(new GetReadyEvent());
                break;
        }
    }
}
