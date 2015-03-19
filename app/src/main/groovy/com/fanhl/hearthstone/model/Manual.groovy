package com.fanhl.hearthstone.model

import com.fanhl.hearthstone.model.manual.Round


/**
 * 存放棋谱(之前的操作)
 *
 * Created by fanhl on 15/1/24.
 */
class Manual {
    @Delegate
    com.fanhl.util.NodeList<Round> rounds = new com.fanhl.util.NodeList<Round>()


}
