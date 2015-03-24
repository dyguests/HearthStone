package com.fanhl.hearthstone.builder

import com.fanhl.hearthstone.model.manual.Action
import com.fanhl.hearthstone.model.manual.Operate

/**
 * 根据operate合成action
 * Created by fanhl on 15/3/23.
 */
class ActionBuilder {
    static Action create(List<Operate> operates) {
        def size = operates.size()
        def operate0 = operates[0]

        if (operate0.type == Operate.Type.ATTACK) return createAttack(operate0)

        null
    }

    static Action createAttack(Operate operate) {
        def action = new Action(type: Action.Type.ACTION_ATTACK)
        action << operate
        action
    }
}