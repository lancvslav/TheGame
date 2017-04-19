package cz.vsb.ekf.lan0116.eventSystem.serverEvents;

/**
 * Event triggered implicitly through players actions, can not be triggered explicitly by player
 */
public interface ServerEvent {
    ServerEventType getType();

    enum ServerEventType {
        BATTLE_LOG,
        GAME_OVER,
        SPEECH,
        /**/;
    }
}
