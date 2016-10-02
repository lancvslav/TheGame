package cz.vsb.ekf.lan0116.events;

import cz.vsb.ekf.lan0116.world.World;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;
import cz.vsb.ekf.lan0116.world.items.Item;
import cz.vsb.ekf.lan0116.world.items.Weapon;

public class EventHandler {

    private final Hero hero;
    private final World world;

    public EventHandler(Hero hero, World world) {
        this.hero = hero;
        this.world = world;
    }

    public Response handleEvent(Event event) {
        switch (event.getType()) {
            case DROP:
                DropEvent dropEvent = (DropEvent) event;
                if (!(hero.getInventory().getInventory().contains(dropEvent.getItemToDrop()))) {
                    return new Response(null);
                }
                hero.getInventory().dropItem(dropEvent.getItemToDrop());
                return Response.SUCCESS;
            case EQUIP:
                return this.handleEquipEvent((EquipEvent) event);
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
                    return new Response(null);
                }
                hero.setCoins(hero.getCoins() - tradeEvent.getMerchandise().getCost());
                hero.getInventory().addItem(tradeEvent.getMerchandise());
                return Response.SUCCESS;
            case TRAVEL:
                TravelEvent travelEvent = (TravelEvent) event;
                if (!(hero.getPosition().getGateways().contains(travelEvent.getGateway()))) {
                    return new Response(null);
                }
                hero.setPosition(travelEvent.getGateway().getTarget());
                return Response.SUCCESS;
            default:
                throw new UnsupportedOperationException("Event type " + event.getType() + " is not supported.");
        }
    }

    private Response handleEquipEvent(EquipEvent equipEvent) {
        Item itemToEquip = equipEvent.getItemToEquip();
        switch (itemToEquip.getItemType().getSuperType()) {
            case WEAPON:
                Weapon weapon = (Weapon) itemToEquip;
                if (weapon.getType().getAvailableFor().contains(hero.getClazz())) {
                    hero.setWeapon(weapon);
                    return Response.SUCCESS;
                } else {
                    return new Response(null);
                }
            default:
                return new Response(null);
        }
    }

}
