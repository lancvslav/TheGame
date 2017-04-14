package cz.vsb.ekf.lan0116.eventSystem.serverEvents;

public interface ServerEvent {
    ServerEventType getType();

    enum ServerEventType {
        BATTLE_LOG,
        GAME_OVER,
        SPEECH,
        /**/;
    }
}
