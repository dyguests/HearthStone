package com.fanhl.hearthstone.logic

import android.view.View
import com.fanhl.hearthstone.builder.ActionBuilder
import com.fanhl.hearthstone.lang.Roleable
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
    List<Operate> tmpOperates = []

    /**
     * 当当前处理正在进行时,不能再次进行处理
     */
    boolean isProcessing = false

    Presenter(GameView gameView, Game game) {
        this.gameView = gameView
        gameView.presenter = this
        this.game = game
    }

    boolean validateTouchDown(View view) {
        //FIXME game.isMyRound
        //isAnimation over
        //isProcessOver
        //isServerResponse over
        //tempAction

        //FIXME
        (!isProcessing) && view
    }

    boolean validateOperate(Operate operate) {
        //FIXME game.isMyRound
        //isAnimation over
        //isProcessOver
        //isServerResponse over
        //tempAction

        //FIXME
        (!isProcessing) && operate
    }

    /**
     * 处理操作
     * @param operate
     * @return
     */
    def processOperate(Operate operate) {
        if (!validateOperate(operate)) return

        //is fullAction

        Action action = createAction(operate)

        //sendServer
        requestAction(action)
    }

    Action createAction(Operate operate) {
        if (operate) tmpOperates << operate

        //如果可以合成一个action
        if (true) {
            def action = ActionBuilder.create(tmpOperates)
            tmpOperates.clear()
            return action
        }
        null
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

        //uiHandler
        gameView.getHandler().post {
//            gameView.demo1View.setText("通信完成,PVM ECS ${System.currentTimeMillis()}")

            if (action.type == Action.Type.ACTION_ATTACK) {
                def operate = action[0]

                Roleable attacker = operate.obj1
                //受害者
                Roleable victim = operate.obj2

                View attackerView = gameView.findViewByData(attacker)
                View victimView = gameView.findViewByData(victim)

                animateAttack(attackerView, victimView)

                logicAttack(attacker, victim)

                lgd "攻击结束 $attacker\n$victim"
            }
        }
    }

    def animateAttack(View attackerView, View victimView) {
        lgd "一个炫酷的攻击动画"
        attackerView.invalidate()
        victimView.invalidate()
    }

    private void logicAttack(Roleable attacker, Roleable victim) {
        lgd "攻击;逻辑"
        victim.blood.current -= attacker.attack.current
        attacker.blood.current -= victim.attack.current
    }
}
