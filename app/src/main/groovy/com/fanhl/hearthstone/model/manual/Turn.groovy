package com.fanhl.hearthstone.model.manual

import com.fanhl.util.NodeList

/**
 * 炉石中不会用到Turn这个东西
 *
 * Created by fanhl on 15/1/6.
 */
@Deprecated
class Turn extends NodeList<Action> implements NodeList.Nodeable<Turn> {
    Turn prev, next
}
