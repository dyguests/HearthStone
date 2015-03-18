package com.fanhl.hearthstone.model.manual

import com.fanhl.util.NodeList

/**
 * 回合(每人一回合,这里不用Turn)
 * Created by fanhl on 15/1/5.
 */
class Round extends NodeList<Action> implements NodeList.Nodeable<Round> {
    Round prev, next


}
