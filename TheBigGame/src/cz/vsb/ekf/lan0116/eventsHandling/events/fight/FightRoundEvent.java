//package cz.vsb.ekf.lan0116.eventsHandling.events.fight;
//
//import cz.vsb.ekf.lan0116.eventsHandling.Response;
//import cz.vsb.ekf.lan0116.eventsHandling.eventHandler.ChannelGame;
//import cz.vsb.ekf.lan0116.eventsHandling.events.Event;
//import cz.vsb.ekf.lan0116.eventsHandling.events.EventSuperType;
//import cz.vsb.ekf.lan0116.eventsHandling.events.EventType;
//import cz.vsb.ekf.lan0116.eventsHandling.failures.FightFailure;
//import cz.vsb.ekf.lan0116.world.creature.Creature;
//
//public class FightRoundEvent implements Event {
//
//    private final Creature attacker;
//    private final Creature defender;
//    private final float attackersHit;
//    private final float counterHit;
//    private final ChannelGame channelGame;
//    private final Response responseFifhtRound;
//
//    public FightRoundEvent(EventType type, Creature attacker, Creature defender, ChannelGame channelGame) {
//        this.attacker = attacker;
//        this.defender = defender;
//        this.attackersHit = this.attackersHit();
//        this.counterHit = this.counterHit();
//        this.channelGame = channelGame;
//        if (inflict(defender, attackersHit).isSuccess() && inflict(attacker, counterHit).isSuccess()) {
//            this.responseFifhtRound = new Response();
//        } else {
//            this.responseFifhtRound = new Response(FightFailure.DONT_KNOW_YET);
//        }
//
//    }
//
//    public Creature getAttacker() {
//        return attacker;
//    }
//
//    public Creature getDefender() {
//        return defender;
//    }
//
//
//    public float getAttackersHit() {
//        return attackersHit;
//    }
//
//    public float getCounterHit() {
//        return counterHit;
//    }
//
//    /**
//     * @return Damage done
//     */
//    private float attackersHit() {
//        float hitPower = attacker.getAttack();
//        return this.defending(this.defender, hitPower);
//    }
//
//    /**
//     * @return Damage done by defender
//     */
//    private float counterHit() {
//        float hitPower = defender.getAttack();
//        return this.defending(this.attacker, hitPower);
//    }
//
//    private float defending(Creature defender, float hitPower) {
//        float damageDone = ((hitPower) / (1 + (defender.getDefense() / 100)));
//        if (damageDone > 0) {
//            return damageDone;
//        } else {
//            return 0;
//        }
//    }
//
////    private Response inflict(Creature creature, float dmg) {
////        return this.channelGame.handleEvent(new InflictDamageEvent(creature, dmg));
////    }
//
//
//    @Override
//    public EventSuperType getEventSuperType() {
//        return EventSuperType.FIGHT_EVENT;
//    }
//
//    @Override
//    public EventSuperType getSuperType() {
//        return EventSuperType.FIGHT_EVENT;
//    }
//
//    @Override
//    public Class getResponseType() {
//        return null;
//    }
//}
