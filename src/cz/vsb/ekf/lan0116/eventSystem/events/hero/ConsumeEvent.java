package cz.vsb.ekf.lan0116.eventSystem.events.hero;

import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.HeroType;
import cz.vsb.ekf.lan0116.world.item.Consumable;

public class ConsumeEvent implements Event {

    private final Consumable subjectOfConsumption;

    public ConsumeEvent(Consumable subjectOfConsumption) {
        this.subjectOfConsumption = subjectOfConsumption;
    }

    public Consumable getSubjectOfConsumption() {
        return subjectOfConsumption;
    }

    @Override
    public EventType getType() {
        return HeroType.CONSUME;
    }
}
