package cz.vsb.ekf.lan0116.eventsHandling.eventHandler;

import cz.vsb.ekf.lan0116.eventsHandling.Response;
import cz.vsb.ekf.lan0116.eventsHandling.events.*;
import cz.vsb.ekf.lan0116.eventsHandling.events.hero.DropEvent;
import cz.vsb.ekf.lan0116.eventsHandling.events.hero.EquipEvent;
import cz.vsb.ekf.lan0116.eventsHandling.events.hero.TradeEvent;
import cz.vsb.ekf.lan0116.eventsHandling.events.hero.TravelEvent;
import cz.vsb.ekf.lan0116.eventsHandling.failures.EquipFailure;
import cz.vsb.ekf.lan0116.eventsHandling.failures.InventoryFailure;
import cz.vsb.ekf.lan0116.eventsHandling.failures.TradeFailure;
import cz.vsb.ekf.lan0116.eventsHandling.failures.TravelFailure;
import cz.vsb.ekf.lan0116.world.World;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;
import cz.vsb.ekf.lan0116.world.items.Item;
import cz.vsb.ekf.lan0116.world.items.Weapon;

public class ChannelGame implements EventHandler{

    private final Hero hero;
    private final World world;

    public ChannelGame(Hero hero, World world) {
        this.hero = hero;
        this.world = world;
    }

    public Response handleEvent(Event event) {
        switch (event.getSuperType()) {
            case DROP:
                DropEvent dropEvent = (DropEvent) event;
                if (!hero.getInventory().getInventoryList().contains(dropEvent.getItemToDrop())) {
                    return new Response(InventoryFailure.NOT_IN_INVENTORY);
                }
                hero.getInventory().dropItem(dropEvent.getItemToDrop());
                return Response.SUCCESS;
            case EQUIP:
                return this.handleEquipEvent((EquipEvent) event);
            case FIGHT_ROUND_EVENT:

            case INFLICT_DAMAGE:
                InflictDamageEvent inflictDamageEvent = (InflictDamageEvent) event;
                float currentHp = inflictDamageEvent.getCreature().getCurrentHp();
                inflictDamageEvent.getCreature().setCurrentHp(currentHp - inflictDamageEvent.getDamage());
                if (inflictDamageEvent.getCreature().getCurrentHp() < 0) {
                    inflictDamageEvent.getCreature().setCurrentHp(0);
                }
                return Response.SUCCESS;
            case NEW_GAME:
                hero.setPosition(world.getStartLocation());
                return Response.SUCCESS;
            case RESPAWN:
                hero.setCurrentHp(hero.getMaxHp());
                hero.setPosition(world.getStartLocation());
                return Response.SUCCESS;
            case TRADE:
                TradeEvent tradeEvent = (TradeEvent) event;
                if (hero.getCoins() < tradeEvent.getMerchandise().getCost()) {
                    return new Response(TradeFailure.NOT_ENOUGH_GOLD);
                }
                hero.setCoins(hero.getCoins() - tradeEvent.getMerchandise().getCost());
                hero.getInventory().addItem(tradeEvent.getMerchandise());
                return Response.SUCCESS;
            case TRAVEL:
                TravelEvent travelEvent = (TravelEvent) event;
                if (!(hero.getPosition().getGateways().contains(travelEvent.getGateway()))) {
                    return new Response(TravelFailure.NO_GATEWAY);
                }
                hero.setPosition(travelEvent.getGateway().getTarget());
                return Response.SUCCESS;
            default:
                throw new UnsupportedOperationException("Event type " + event.getSuperType() + " is not supported.");
        }
    }

    private Response handleEquipEvent(EquipEvent equipEvent) {
        Item itemToEquip = equipEvent.getItemToEquip();
        if (!hero.getInventory().getInventoryList().contains(itemToEquip)) {
            return new Response(InventoryFailure.NOT_IN_INVENTORY);
        }
        switch (itemToEquip.getItemType().getSuperType()) {
            case WEAPON:
                Weapon weapon = (Weapon) itemToEquip;
                if (weapon.getType().getAvailableFor().contains(hero.getClazz())) {
                    hero.setWeapon(weapon);
                    return Response.SUCCESS;
                } else {
                    return new Response(EquipFailure.CLAZZ_DIFF);
                }
            default:
                return new Response(EquipFailure.NOT_A_WEAPON);
        }
    }

}
