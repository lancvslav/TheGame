package cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent;

import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.EventHandler;
import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.SignInEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.TravelEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.items.ConsumeEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.items.DropEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.items.EquipEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.npc.InteractEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.npc.TalkEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.npc.shoping.InitiateDialogueEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.npc.shoping.PurchaseEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.type.HeroType;
import cz.vsb.ekf.lan0116.eventSystem.failures.EquipFailure;
import cz.vsb.ekf.lan0116.eventSystem.failures.InventoryFailure;
import cz.vsb.ekf.lan0116.eventSystem.failures.PurchaseFailure;
import cz.vsb.ekf.lan0116.eventSystem.failures.TravelFailure;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.ResponseChannel;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.speech.SpeechResponse;
import cz.vsb.ekf.lan0116.world.World;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;
import cz.vsb.ekf.lan0116.world.creature.hero.HeroInteraction;
import cz.vsb.ekf.lan0116.world.creature.humanoid.Humanoid;
import cz.vsb.ekf.lan0116.world.item.Consumable;
import cz.vsb.ekf.lan0116.world.item.Item;
import cz.vsb.ekf.lan0116.world.item.Weapon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HeroChannel extends EventHandler {

    public HeroChannel(Hero hero, World world, ResponseChannel responseChannel) {
        super(hero, world, responseChannel);
    }

    /**
     * Handles rawEvent of HeroType and provides Response
     *
     * @param rawEvent triggered by the player
     * @return Response on triggered rawEvent
     */
    @Override
    public Response handleEvent(Event rawEvent) {
        HeroType eventType = (HeroType) rawEvent.getType();
        Hero hero = this.getHero();
        switch (eventType) {
            case CONSUME:
                Consumable subjectOfConsumption = ((ConsumeEvent) rawEvent).getSubjectOfConsumption();
                //PREPARED TO DISTINCT SECONDARY STAT (ENERGY, MANA, RAGE)
                //ConsumableType consumableType = (ConsumableType) subjectOfConsumption.getItemType();
                hero.setCurrentLifeEssence(
                        hero.getCurrentLifeEssence() + subjectOfConsumption.getReplenishValue());
                if (hero.getCurrentLifeEssence() > hero.getMaxLifeEssence()) {
                    hero.setCurrentLifeEssence(hero.getMaxLifeEssence());
                }
                return Response.SUCCESS;
            case DROP:
                DropEvent dropEvent = (DropEvent) rawEvent;
                if (!hero.getInventory().getInventoryList().contains(dropEvent.getItemToDrop())) {
                    return new Response(InventoryFailure.NOT_IN_INVENTORY);
                }
                hero.getInventory().dropItem(dropEvent.getItemToDrop());
                return Response.SUCCESS;
            case EQUIP:
                return this.handleEquipEvent((EquipEvent) rawEvent);
            case GET_READY:
                this.getInteraction().setStatus(HeroInteraction.HeroStatus.READY);
                return Response.SUCCESS;
            case INITIATE_DIALOGUE:
                /**
                 *
                 */
                InitiateDialogueEvent initiateDialogueEvent = (InitiateDialogueEvent) rawEvent;
                Humanoid npc = initiateDialogueEvent.getNpc();
                //if player is same clazz as npc is, friendly dialogue should pop up
                if(npc.getClazz().equals(hero.getClazz())){
                    List<SpeechResponse> speechLog = new ArrayList<>();
                }
                throw new UnsupportedOperationException();
            case INTERACT:
                InteractEvent interactEvent = (InteractEvent) rawEvent;
                this.getInteraction().setSubjectOfInteraction(interactEvent.getNpc());
                this.getInteraction().setStatus(HeroInteraction.HeroStatus.INTERACTING);
                return Response.SUCCESS;
            case REST:
                this.getInteraction().setStatus(HeroInteraction.HeroStatus.RESTING);
                return Response.SUCCESS;
            case SIGN_IN:
                SignInEvent signInEvent = (SignInEvent) rawEvent;
                LinkedList<Creature> queue = new LinkedList<>(signInEvent.getTournament().getEnemyList());
                this.getInteraction().setEnemyQueue(queue);
                return Response.SUCCESS;
            case STOP_INTERACTING:
                /**
                 *
                 */
                throw new UnsupportedOperationException();
            case STOP_TALKING:
                /**
                 *
                 */
                throw new UnsupportedOperationException();
            case TALK:
                TalkEvent talkEvent = (TalkEvent) rawEvent;
                this.getInteraction().setSubjectOfInteraction(talkEvent.getNpc());
                this.getInteraction().setStatus(HeroInteraction.HeroStatus.TALKING);
                return Response.SUCCESS;
            case TRADE:
                this.getInteraction().setStatus(HeroInteraction.HeroStatus.SHOPPING);
                return Response.SUCCESS;
            case TRAVEL:
                TravelEvent travelEvent = (TravelEvent) rawEvent;
                if (!(hero.getHeroInteraction().getPosition().getGateways().contains(travelEvent.getGateway()))) {
                    return new Response(TravelFailure.NO_GATEWAY);
                }
                this.getInteraction().setPosition(travelEvent.getGateway().getTarget());
                LinkedList<Creature> emptyQueue = new LinkedList<>();
                this.getInteraction().setEnemyQueue(emptyQueue);
                this.getInteraction().setStatus(HeroInteraction.HeroStatus.READY);
                return Response.SUCCESS;
            case PURCHASE:
                PurchaseEvent purchaseEvent = (PurchaseEvent) rawEvent;
                if (hero.getCoins() < purchaseEvent.getMerchandise().getCost()) {
                    return new Response(PurchaseFailure.NOT_ENOUGH_GOLD);
                }
                hero.setCoins(this.getHero().getCoins() - purchaseEvent.getMerchandise().getCost());
                hero.getInventory().addItem(purchaseEvent.getMerchandise());
                this.getInteraction().setStatus(HeroInteraction.HeroStatus.INTERACTING);
                return Response.SUCCESS;
            default:
                throw new UnsupportedOperationException("Event type " + rawEvent.getType() + " is not supported.");
        }
    }

    /**
     * Due to a little bit more complex logic processing of equipEvent was moved here
     */
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
