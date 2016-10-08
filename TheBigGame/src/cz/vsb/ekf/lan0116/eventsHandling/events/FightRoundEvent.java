package cz.vsb.ekf.lan0116.eventsHandling.events;

import cz.vsb.ekf.lan0116.world.creature.Creature;

public class FightRoundEvent extends Event {

    private final Creature attacker;
    private final Creature defender;
    private final float attackersHit;
    private final float counterHit;

    public FightRoundEvent(EventType type, Creature attacker, Creature defender) {
        super(EventType.FIGHT_ROUND_EVENT);
        this.attacker = attacker;
        this.defender = defender;
        this.attackersHit = this.attackersHit();
        this.counterHit = this.counterHit();
        this.inflict(defender, attackersHit);
        this.inflict(attacker,counterHit);
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
        return this.defending(hitPower);
    }

    private float counterHit() {
        float hitPower = defender.getAttack();
        return this.defending(hitPower);
    }

    private float defending(float hitPower) {
        float damageDone = ((hitPower) / (1 + (defender.getDefense() / 100)));
        if (damageDone > 0) {
            return damageDone;
        } else {
            return 0;
        }
    }

    private void inflict(Creature creature, float dmg) {
        creature.setCurrentHp(creature.getCurrentHp() - dmg);
    }

//    private void handleAttack(Creature creature){
//        switch (creature.getAttack()){
//
//        }
//
//    }

}
