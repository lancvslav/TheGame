package cz.vsb.ekf.lan0116.eventSystem.events.hero.npc.shoping;

import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.HeroType;
import cz.vsb.ekf.lan0116.world.creature.humanoid.Humanoid;

public class TradeEvent implements Event {

    private Humanoid merchant;

    public TradeEvent(Humanoid merchant) {
        this.merchant = merchant;
    }

    public Humanoid getMerchant() {
        return merchant;
    }

    @Override
    public EventType getType() {
        return HeroType.TRADE;
    }
}
