package cz.vsb.ekf.lan0116.eventsHandling.events;

import cz.vsb.ekf.lan0116.util.ListManageUtil;
import cz.vsb.ekf.lan0116.world.items.Merchandise;

import java.util.List;

public class TradeEvent implements EventTypeInterface {

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
    public EventSuperType getEventSuperType() {
        return EventSuperType.HERO_EVENT;
    }
}
