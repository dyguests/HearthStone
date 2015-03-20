package com.fanhl.hearthstone.model

import com.fanhl.hearthstone.model.manual.Round
import com.fanhl.util.ChainList


/**
 * 存放棋谱(之前的操作)
 *
 * Created by fanhl on 15/1/24.
 */
class Manual {
    @Delegate
    ChainList<Round> rounds = new ChainList<Round>()


}
