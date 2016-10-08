package cz.vsb.ekf.lan0116.eventsHandling.events;

import cz.vsb.ekf.lan0116.eventsHandling.EventHandler;
import cz.vsb.ekf.lan0116.eventsHandling.Response;
import cz.vsb.ekf.lan0116.eventsHandling.failures.FightFailure;
import cz.vsb.ekf.lan0116.world.creature.Creature;

public class FightRoundEvent extends Event {

    private final Creature attacker;
    private final Creature defender;
    private final float attackersHit;
    private final float counterHit;
    private final EventHandler eventHandler;
    private final Response responseFifhtRound;

    public FightRoundEvent(EventType type, Creature attacker, Creature defender, EventHandler eventHandler) {
        super(EventType.FIGHT_ROUND_EVENT);
        this.attacker = attacker;
        this.defender = defender;
        this.attackersHit = this.attackersHit();
        this.counterHit = this.counterHit();
        this.eventHandler = eventHandler;
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
        return this.eventHandler.handleEvent(new InflictDamageEvent(creature, dmg));
    }

//    private void handleAttack(Creature creature){
//        switch (creature.getAttack()){
//
//        }
//
//    }

}
