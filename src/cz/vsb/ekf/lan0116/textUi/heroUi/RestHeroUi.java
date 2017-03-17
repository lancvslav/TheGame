package cz.vsb.ekf.lan0116.textUi.heroUi;

import cz.vsb.ekf.lan0116.eventSystem.events.hero.GetReadyEvent;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractHeroUi;

public class RestHeroUi extends AbstractHeroUi {

    public RestHeroUi(Context context) {
        super(context);
    }

    @Override
    public void show() {
        this.decisions();
    }

    protected void decisions() {
        switch (this.choice(
                this.get("textUi.RestHeroUi.inventory"),
                this.get("textUi.RestHeroUi.consume"),
                "status",
                //localize, or maybe don't, just testing for now
                this.get("textUi.RestHeroUi.getUp"))) {
            case 0:
                new InventoryUi(getContext()).show();
                break;
            case 1:
                System.out.println("\n" + this.get("textUi.RestHeroUi.starve"));
                this.decisions();
                break;
            case 2:
                System.out.println(this.getHero().getCurrentLifeEssence() + " " + this.get("") + " " +
                        this.getHero().getCurrentStamina() + " " + this.get("textUi.textEvents.stamina"));
                break;
            case 3:
                this.getContext().getSession().fireEvent(new GetReadyEvent());
                break;
        }
    }
}
