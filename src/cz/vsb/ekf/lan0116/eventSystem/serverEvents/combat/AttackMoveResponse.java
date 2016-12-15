package cz.vsb.ekf.lan0116.eventSystem.serverEvents.combat;

import cz.vsb.ekf.lan0116.eventSystem.serverEvents.ServerEvent;

import java.util.List;

public class AttackMoveResponse implements ServerEvent {
    List<FightResponse> battleLog;

    public AttackMoveResponse(List<FightResponse> battleLog) {
        this.battleLog = battleLog;
    }

    @Override
    public ServerEventType getType() {
        return ServerEventType.ATTACK_MOVE_SUMMARY;
    }

    public List<FightResponse> getBattleLog() {
        return battleLog;
    }
}
