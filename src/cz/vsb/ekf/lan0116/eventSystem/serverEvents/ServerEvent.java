package cz.vsb.ekf.lan0116.eventSystem.serverEvents;

public interface ServerEvent {
    ServerEventType getType();

    enum ServerEventType {
        ATTACK_MOVE_SUMMARY,
        GAME_OVER,
        /**/;
    }
}
