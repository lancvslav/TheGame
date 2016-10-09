package cz.vsb.ekf.lan0116.eventsHandling.events;

import cz.vsb.ekf.lan0116.eventsHandling.eventHandler.EventHandlerMain;
import cz.vsb.ekf.lan0116.eventsHandling.Response;
import cz.vsb.ekf.lan0116.eventsHandling.failures.FightFailure;
import cz.vsb.ekf.lan0116.world.creature.Creature;

public class FightRoundEvent implements Event {

    private final Creature attacker;
    private final Creature defender;
    private final float attackersHit;
    private final float counterHit;
    private final EventHandlerMain eventHandlerMain;
    private final Response responseFifhtRound;

    public FightRoundEvent(EventType type, Creature attacker, Creature defender, EventHandlerMain eventHandlerMain) {
                this.attacker = attacker;
        this.defender = defender;
        this.attackersHit = this.attackersHit();
        this.counterHit = this.counterHit();
        this.eventHandlerMain = eventHandlerMain;
        if (inflict(defender, attackersHit).isSuccess() && inflict(attacker, counterHit).isSuccess()) {
            this.responseFifhtRound = new Response();
        } else {
            this.responseFifhtRound = new Response(FightFailure.DONT_KNOW_YET);
        }

    }

    public Creature getAttacker() {
        return attacker;
    }

    public Creature getDefender() {
        return defender;
    }


    public float getAttackersHit() {
        return attackersHit;
    }

    public float getCounterHit() {
        return counterHit;
    }

    /**
     * @return Damage done
     */
    private float attackersHit() {
        float hitPower = attacker.getAttack();
        return this.defending(this.defender, hitPower);
    }

    /**
     * @return Damage done by defender
     */
    private float counterHit() {
        float hitPower = defender.getAttack();
        return this.defending(this.attacker, hitPower);
    }

    private float defending(Creature defender, float hitPower) {
        float damageDone = ((hitPower) / (1 + (defender.getDefense() / 100)));
        if (damageDone > 0) {
            return damageDone;
        } else {
            return 0;
        }
    }

    private Response inflict(Creature creature, float dmg) {
        return this.eventHandlerMain.handleEvent(new InflictDamageEvent(creature, dmg));
    }

    @Override
    public EventType getType() {
        return EventType.FIGHT_ROUND_EVENT;
    }

    @Override
    public Class getResponseType() {
        return null;
    }

//    private void handleAttack(Creature creature){
//        switch (creature.getAttack()){
//
//        }
//
//    }

}
