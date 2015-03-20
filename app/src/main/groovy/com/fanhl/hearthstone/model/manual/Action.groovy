package com.fanhl.hearthstone.model.manual


import com.fanhl.util.ChainList

/**
 * Created by fanhl on 15/1/5.
 * FIXME 对此类使用策略模式
 */
class Action extends ChainList<Operate> implements ChainList.Chainable<Action> {
    Action prev, next

    int playerIndex
    int type
    def obj



    public class Type {
        public static final int GAME_PREPARE = 1000;

        public static final int ROUND_NEXT = 2000;

        public static final int TURN_NEXT = 3000;

        public static final int ACTION_DASH = 4001;
        public static final int ACTION_PASS = 4002;
    }

    @Override
    String toString() { "playerIndex:$playerIndex type:$type obj:${obj.toString()}" }
}
