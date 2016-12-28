package cz.vsb.ekf.lan0116.eventSystem.events.combat;

import cz.vsb.ekf.lan0116.combat.Attack;
import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.CombatType;

public class FightRoundEvent implements Event {

    private final Attack attack;

    public FightRoundEvent(Attack attack) {
        this.attack = attack;
    }

    public Attack getAttack() {
        return attack;
    }

    @Override
    public EventType getType() {
        return CombatType.ATTACK_MOVE;
    }
}
