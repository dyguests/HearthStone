package com.fanhl.hearthstone.model.manual

import com.fanhl.util.ChainList

/**
 * 回合(每人一回合,这里不用Turn)
 * Created by fanhl on 15/1/5.
 */
class Round extends ChainList<Action> implements ChainList.Chainable<Round> {
    Round prev, next


}
