package cz.vsb.ekf.lan0116.eventSystem.serverEvents;

public interface ServerEvent {
    ServerEventType getType();

    enum ServerEventType {
        FIGHT_ROUND_SUMMARY,
        GAME_OVER,
        /**/;
    }
}
