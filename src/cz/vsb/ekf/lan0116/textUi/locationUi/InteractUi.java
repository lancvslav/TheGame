package cz.vsb.ekf.lan0116.textUi.locationUi;

import cz.vsb.ekf.lan0116.eventSystem.events.hero.GetReadyEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.npc.TalkEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.npc.shoping.TradeEvent;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractMerchantUi;
import cz.vsb.ekf.lan0116.world.creature.humanoid.Humanoid;

/**
 * Shown when InteractEvent is triggered
 */
public class InteractUi extends AbstractMerchantUi {
    public InteractUi(Humanoid subject, Context context) {
        super(subject, context);
    }

    @Override
    public void show() {
        this.decisions();
    }

    /**
     * Prints decisions: talk, trade, leave
     */
    @Override
    protected void decisions() {
        switch (this.choice(this.get("textUi.InteractUi.talk"),
                this.get("textUi.InteractUi.trade"),
                this.get("textUi.InteractUi.leave"))) {
            case 0:
                this.getContext().getSession().fireEvent(new TalkEvent(this.getMerchant()));
                break;
            case 1:
                this.getContext().getSession().fireEvent(new TradeEvent(this.getMerchant()));
                break;
            case 2:
                this.getContext().getSession().fireEvent(new GetReadyEvent());
                break;
        }
    }
}
