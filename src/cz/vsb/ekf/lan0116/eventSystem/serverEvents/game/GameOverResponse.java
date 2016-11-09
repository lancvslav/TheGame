package cz.vsb.ekf.lan0116.eventSystem.serverEvents.game;

import cz.vsb.ekf.lan0116.eventSystem.serverEvents.ServerEvent;

public class GameOverResponse implements ServerEvent {
    private final Reason reason;

    public GameOverResponse(Reason reason) {
        this.reason = reason;
    }

    @Override
    public ServerEventType getType() {
        return ServerEventType.GAME_OVER;
    }

    public Reason getReason() {
        return reason;
    }

    public enum Reason {
        DEFEAT,
        SURRENDER,
        /**/;
    }
}
