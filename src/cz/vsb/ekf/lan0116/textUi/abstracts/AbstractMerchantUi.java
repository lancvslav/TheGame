package cz.vsb.ekf.lan0116.textUi.abstracts;

import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.world.creature.humanoid.Humanoid;
import cz.vsb.ekf.lan0116.world.location.building.shop.Shop;

public abstract class AbstractMerchantUi<H extends Humanoid> extends AbstractCreatureUi {
    protected AbstractMerchantUi(Context context) {
        super(context);
    }

    public H getMerchant() {
        Shop shop = (Shop) this.getContext().getHero().getHeroInteraction().getPosition();
        return (H) shop.getMerchant();
    }
}
