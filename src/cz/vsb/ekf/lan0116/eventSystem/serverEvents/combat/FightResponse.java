package cz.vsb.ekf.lan0116.eventSystem.serverEvents.combat;

public interface FightResponse {

    FightResponseType getType();

    enum FightResponseType {
        DAMAGE_INFLICTION,
        STAMINA_CONSUMPTION,
        HEALING,
        INFORMATION,
        SPEECH,
        YOU_DIED,;
    }
}
