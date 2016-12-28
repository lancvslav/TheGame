package cz.vsb.ekf.lan0116.eventSystem.serverEvents.combat;

import cz.vsb.ekf.lan0116.eventSystem.serverEvents.ServerEvent;

import java.util.List;

public class BattleLogServerEvent implements ServerEvent {
    List<FightResponse> battleLog;

    public BattleLogServerEvent(List<FightResponse> battleLog) {
        this.battleLog = battleLog;
    }

    @Override
    public ServerEventType getType() {
        return ServerEventType.BATTLE_LOG;
    }

    public List<FightResponse> getBattleLog() {
        return battleLog;
    }
}
