package com.fanhl.hearthstone.model.manual


import com.fanhl.util.ChainList

/**
 * Created by fanhl on 15/1/5.
 * FIXME 对此类使用策略模式
 */
class Action extends ChainList<Operate> implements ChainList.Chainable<Action> {
    Action prev, next

    int playerIndex
    Type type
//    def obj


    public static enum Type {
        GAME_PREPARE(1000),
        ROUND_NEXT(2000),
        TURN_NEXT(3000),
        ACTION_DASH(4001),
        ACTION_ATTACK(4002)

        int i

        def Type(int i) { this.i = i }
    }

    @Override
    String toString() { "playerIndex:$playerIndex type:$type obj:${obj.toString()}" }
}
