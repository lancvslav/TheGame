package cz.vsb.ekf.lan0116.eventsHandling.events.combat;

import cz.vsb.ekf.lan0116.eventsHandling.events.Event;
import cz.vsb.ekf.lan0116.eventsHandling.events.EventType;
import cz.vsb.ekf.lan0116.eventsHandling.events.type.CombatType;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.Enemy;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;

public class FightRoundEvent implements Event {

    private final Hero hero;
    private final Enemy enemy;

    public FightRoundEvent(Enemy enemy, Context context) {
        this.hero = context.getHero();
        this.enemy = enemy;
    }

    public Hero getHero() {
        return hero;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    @Override
    public EventType getType() {
        return CombatType.ROUND;
    }


    /**
     * @return Damage done
     */
    private float attackersHit() {
        float hitPower = hero.getAttack();
        return this.defending(this.hero, hitPower);
    }

    /**
     * @return Damage done by defender
     */
    private float counterHit() {
        float hitPower = enemy.getAttack();
        return this.defending(this.enemy, hitPower);
    }

    private float defending(Creature defender, float hitPower) {
        float damageDone = ((hitPower) / (1 + (defender.getDefense() / 100)));
        if (damageDone > 0) {
            return damageDone;
        } else {
            return 0;
        }
    }
}

//    private Response inflict(Creature creature, float dmg) {
//        return this.channelGame.handleEvent(new InflictDamageEvent(creature, dmg));
//    }


