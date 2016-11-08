package cz.vsb.ekf.lan0116.eventSystem.serverEvents.fight;

public interface FightResponse {
    FightResponseType getType();

    enum FightResponseType {
        DAMAGE_INFLICTION,
        SPEECH,
        INFORMATION,
        /**/;
    }
}
