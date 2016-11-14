package cz.vsb.ekf.lan0116.eventSystem.serverEvents.combat;

import cz.vsb.ekf.lan0116.eventSystem.serverEvents.ServerEvent;

import java.util.List;

public class FightRoundResponse implements ServerEvent {
    List<FightResponse> battleLog;

    public FightRoundResponse(List<FightResponse> battleLog) {
        this.battleLog = battleLog;
    }

    @Override
    public ServerEventType getType() {
        return ServerEventType.FIGHT_ROUND_SUMMARY;
    }

    public List<FightResponse> getBattleLog() {
        return battleLog;
    }
}
