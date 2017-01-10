package cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent;

import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.EventHandler;
import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.ResponseChannel;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.*;
import cz.vsb.ekf.lan0116.eventSystem.events.type.HeroType;
import cz.vsb.ekf.lan0116.eventSystem.failures.EquipFailure;
import cz.vsb.ekf.lan0116.eventSystem.failures.InventoryFailure;
import cz.vsb.ekf.lan0116.eventSystem.failures.TradeFailure;
import cz.vsb.ekf.lan0116.eventSystem.failures.TravelFailure;
import cz.vsb.ekf.lan0116.world.World;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;
import cz.vsb.ekf.lan0116.world.item.Consumable;
import cz.vsb.ekf.lan0116.world.item.Item;
import cz.vsb.ekf.lan0116.world.item.Weapon;

import java.util.LinkedList;

public class HeroChannel extends EventHandler {

    public HeroChannel(Hero hero, World world, ResponseChannel responseChannel) {
        super(hero, world, responseChannel);
    }

    @Override
    public Response handleEvent(Event event) {
        HeroType eventType = (HeroType) event.getType();
        switch (eventType) {
            case CONSUME:
                ConsumeEvent consumeEvent = (ConsumeEvent) event;
                Consumable subjectOfConsumption = ((ConsumeEvent) event).getSubjectOfConsumption();
                //PREPARED TO DISTINCT SECONDARY STAT (ENERGY, MANA, RAGE)
                //ConsumableType consumableType = (ConsumableType) subjectOfConsumption.getItemType();
                this.getHero().setCurrentLifeEssence(
                        this.getHero().getCurrentLifeEssence() + subjectOfConsumption.getReplenishValue());
                if (this.getHero().getCurrentLifeEssence() > this.getHero().getMaxLifeEssence()) {
                    this.getHero().setCurrentLifeEssence(this.getHero().getMaxLifeEssence());
                }
                return Response.SUCCESS;
            case DROP:
                DropEvent dropEvent = (DropEvent) event;
                if (!this.getHero().getInventory().getInventoryList().contains(dropEvent.getItemToDrop())) {
                    return new Response(InventoryFailure.NOT_IN_INVENTORY);
                }
                this.getHero().getInventory().dropItem(dropEvent.getItemToDrop());
                return Response.SUCCESS;
            case EQUIP:
                return this.handleEquipEvent((EquipEvent) event);
            case SIGN_IN:
                SignInEvent signInEvent = (SignInEvent) event;
                LinkedList<Creature> queue = new LinkedList<>(signInEvent.getTournament().getEnemyList());
                this.getHero().getHeroInteraction().setEnemyQueue(queue);
                return Response.SUCCESS;
                //return;
            case TRADE:
                TradeEvent tradeEvent = (TradeEvent) event;
                if (this.getHero().getCoins() < tradeEvent.getMerchandise().getCost()) {
                    return new Response(TradeFailure.NOT_ENOUGH_GOLD);
                }
                this.getHero().setCoins(this.getHero().getCoins() - tradeEvent.getMerchandise().getCost());
                this.getHero().getInventory().addItem(tradeEvent.getMerchandise());
                return Response.SUCCESS;
            case TRAVEL:
                TravelEvent travelEvent = (TravelEvent) event;
                if (!(this.getHero().getHeroInteraction()
                        .getPosition().getGateways().contains(travelEvent.getGateway()))) {
                    return new Response(TravelFailure.NO_GATEWAY);
                }
                this.getHero().getHeroInteraction().setPosition(travelEvent.getGateway().getTarget());
                return Response.SUCCESS;
            default:
                throw new UnsupportedOperationException("Event type " + event.getType() + " is not supported.");
        }
    }

    private Response handleEquipEvent(EquipEvent equipEvent) {
        Item itemToEquip = equipEvent.getItemToEquip();
        if (!this.getHero().getInventory().getInventoryList().contains(itemToEquip)) {
            return new Response(InventoryFailure.NOT_IN_INVENTORY);
        }
        switch (itemToEquip.getItemType().getSuperType()) {
            case WEAPON:
                Weapon weapon = (Weapon) itemToEquip;
                if (weapon.getType().getAvailableFor().contains(this.getHero().getClazz())) {
                    this.getHero().setWeapon(weapon);
                    return Response.SUCCESS;
                } else {
                    return new Response(EquipFailure.CLAZZ_DIFF);
                }
            default:
                return new Response(EquipFailure.NOT_A_WEAPON);
        }
    }

}
