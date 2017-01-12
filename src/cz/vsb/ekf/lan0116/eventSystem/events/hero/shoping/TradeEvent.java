package cz.vsb.ekf.lan0116.eventSystem.events.hero.shoping;

import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.HeroType;
import cz.vsb.ekf.lan0116.world.item.Merchandise;

public class TradeEvent implements Event {

    private final Merchandise merchandise;

    public TradeEvent(Merchandise merchandise) {
        this.merchandise = merchandise;
    }

    public Merchandise getMerchandise() {
        return merchandise;
    }

    @Override
    public EventType getType() {
        return HeroType.TRADE;
    }

}
