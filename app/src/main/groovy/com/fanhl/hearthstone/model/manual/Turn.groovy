package com.fanhl.hearthstone.model.manual

import com.fanhl.util.ChainList

/**
 * 炉石中不会用到Turn这个东西
 *
 * Created by fanhl on 15/1/6.
 */
@Deprecated
class Turn extends ChainList<Action> implements ChainList.Chainable<Turn> {
    Turn prev, next
}
