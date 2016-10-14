package cz.vsb.ekf.lan0116.eventsHandling.eventHandler.channel;

import cz.vsb.ekf.lan0116.eventsHandling.Response;
import cz.vsb.ekf.lan0116.eventsHandling.eventHandler.EventHandler;
import cz.vsb.ekf.lan0116.eventsHandling.events.Event;
import cz.vsb.ekf.lan0116.eventsHandling.events.hero.DropEvent;
import cz.vsb.ekf.lan0116.eventsHandling.events.hero.EquipEvent;
import cz.vsb.ekf.lan0116.eventsHandling.events.hero.TradeEvent;
import cz.vsb.ekf.lan0116.eventsHandling.events.hero.TravelEvent;
import cz.vsb.ekf.lan0116.eventsHandling.events.type.HeroType;
import cz.vsb.ekf.lan0116.eventsHandling.failures.EquipFailure;
import cz.vsb.ekf.lan0116.eventsHandling.failures.InventoryFailure;
import cz.vsb.ekf.lan0116.eventsHandling.failures.TradeFailure;
import cz.vsb.ekf.lan0116.eventsHandling.failures.TravelFailure;
import cz.vsb.ekf.lan0116.world.World;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;
import cz.vsb.ekf.lan0116.world.items.Item;
import cz.vsb.ekf.lan0116.world.items.Weapon;

public class HeroChannel extends EventHandler {

    public HeroChannel(Hero hero, World world) {
        super(hero, world);
    }

    @Override
    public Response handleEvent(Event event) {
        HeroType eventType = (HeroType) event.getType();
        switch (eventType) {
            case DROP:
                DropEvent dropEvent = (DropEvent) event;
                if (!this.getHero().getInventory().getInventoryList().contains(dropEvent.getItemToDrop())) {
                    return new Response(InventoryFailure.NOT_IN_INVENTORY);
                }
                this.getHero().getInventory().dropItem(dropEvent.getItemToDrop());
                return Response.SUCCESS;
            case EQUIP:
                return this.handleEquipEvent((EquipEvent) event);
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
                if (!(this.getHero().getPosition().getGateways().contains(travelEvent.getGateway()))) {
                    return new Response(TravelFailure.NO_GATEWAY);
                }
                this.getHero().setPosition(travelEvent.getGateway().getTarget());
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