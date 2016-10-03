package cz.vsb.ekf.lan0116.eventsHandling.events;

import cz.vsb.ekf.lan0116.util.ListManageUtil;
import cz.vsb.ekf.lan0116.world.items.Merchandise;
import java.util.List;

public class TradeEvent extends Event {

    private final Merchandise merchandise;

    public TradeEvent(List<Merchandise> listWithItem, int index) {
        super(EventType.TRADE);
        this.merchandise = ListManageUtil.getMerchandise(listWithItem, index);
    }

    public TradeEvent(Merchandise merchandise) {
        super(EventType.TRADE);
        this.merchandise = merchandise;
    }

    public Merchandise getMerchandise() {
        return merchandise;
    }

}
