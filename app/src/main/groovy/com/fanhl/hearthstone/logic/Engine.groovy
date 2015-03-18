package com.fanhl.hearthstone.logic

import com.fanhl.hearthstone.http.GameConnection
import com.fanhl.hearthstone.model.Game
import com.fanhl.hearthstone.model.manual.Action
import com.fanhl.hearthstone.widget.container.GameView
import com.fanhl.util.Lg

/**
 * Created by fanhl on 15/3/17.
 */
class Engine {
    static def lgd = Lg.d.curry Engine.class.getSimpleName()

    static boolean RUN_FLAG = false

    GameConnection gameConnection

    Presenter presenter
    GameView boardView
    Game game

    Queue<Action> actionQueue = new LinkedList<>()

    Engine(Presenter presenter, GameView boardView, Game game) {
        this.presenter = presenter
        presenter.engine = this

        this.boardView = boardView
        this.game = game
    }

    def execute() {
        lgd '启动游戏'

        if (RUN_FLAG) return
        RUN_FLAG = true

        //FIXME 为啥用timer用不了
        Thread.start "游戏线程", {
            while (RUN_FLAG) {
                Action action = actionQueue.poll()
                if (action != null) processAction(action)
                Thread.sleep(100)//FIXME 临时
            }
        }
    }

    def destroy() {
        lgd '停止游戏'
        RUN_FLAG = false
    }

    def offerAction(Action action) { actionQueue << action }

    def processAction(Action action) {
        if (notifyServer(action)) {
            presenter.responseAction(action)
        } else {
            presenter.responseAction(null)
        }
    }

    /**
     * 将这个消息发送给服务器(通知当前所有玩家)
     * @param action
     * @return
     */
    boolean notifyServer(Action action) { gameConnection.notifyServer(action) }

    void setGameConnection(GameConnection gameConnection) {
        this.gameConnection = gameConnection
        gameConnection.engine = this
    }

}
