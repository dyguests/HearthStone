package com.fanhl.hearthstone.logic

import com.fanhl.hearthstone.model.Game
import com.fanhl.hearthstone.model.manual.Action
import com.fanhl.hearthstone.model.manual.Operate
import com.fanhl.hearthstone.widget.container.GameView
import com.fanhl.util.Lg

/**
 * Created by fanhl on 15/3/17.
 */
class Presenter {
    static def lgd = Lg.d.curry Presenter.class.getSimpleName()

    Engine engine
    GameView gameView
    Game game

    //----------------存放一些输入输出相关参数--------------------
    /**
     * 正在处理的action,因为有可能需要多个手势操作组合到一起才算一个action
     */
    Action tempAction
    /**
     * 当当前处理正在进行时,不能再次进行处理
     */
    boolean isProcessing = false

    Presenter(GameView gameView, Game game) {
        this.gameView = gameView
        gameView.presenter = this
        this.game = game
    }

    boolean validate(Operate operate) {
        //FIXME game.isMyRound
        //isAnimation over
        //isProcessOver
        //isServerResponse over
        //tempAction

        //FIXME
        (!isProcessing) && 1 == 1
    }

    def processOperate(Operate operate) {
        if (!validate(null)) return

        //is fullAction

        Action action = createAction(null)

        //sendServer
        requestAction(action)
    }

    Action createAction(String s) {
        new Action()
    }

    /**
     * 请求,将action发送给engine
     * @param action
     */
    def requestAction(Action action) {
        lgd "上传action"

        isProcessing = true

        engine.offerAction(action)
    }

    /**
     * 响应,处理engine返回的action
     * @param action
     */
    def responseAction(Action action) {
        lgd "响应action"

        isProcessing = false

        //dispatch
        //判断是什么操作
        //对应数据变更
        //动画处理
        //gameView. change anime

        gameView.getHandler().post {
//            gameView.demo1View.setText("通信完成,PVM ECS ${System.currentTimeMillis()}")
        }
    }
}
