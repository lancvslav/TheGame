package cz.vsb.ekf.lan0116.eventsHandling.events.hero;

import cz.vsb.ekf.lan0116.eventsHandling.events.Event;
import cz.vsb.ekf.lan0116.eventsHandling.events.EventSuperType;
import cz.vsb.ekf.lan0116.eventsHandling.events.EventType;
import cz.vsb.ekf.lan0116.eventsHandling.events.type.HeroType;
import cz.vsb.ekf.lan0116.util.ListManageUtil;
import cz.vsb.ekf.lan0116.world.items.Merchandise;

import java.util.List;

public class TradeEvent implements Event {

    private final Merchandise merchandise;

    public TradeEvent(List<Merchandise> listWithItem, int index) {
        this.merchandise = ListManageUtil.getMerchandise(listWithItem, index);
    }

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

    @Override
    public EventSuperType getSuperType() {
        this.getType().getEventSuperType()
    }

    @Override
    public Class getResponseType() {
        return null;
    }
}
