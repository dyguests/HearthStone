package com.fanhl.hearthstone.http

import com.fanhl.hearthstone.logic.Engine
import com.fanhl.hearthstone.model.manual.Action

/**
 * 网络通信用
 * Created by fanhl on 15/3/17.
 */
class GameConnection {
    Engine engine

    boolean notifyServer(Action action) {
        Thread.sleep(2000)
        true
    }
}
