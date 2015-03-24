package com.fanhl.hearthstone.builder

import com.fanhl.hearthstone.drag.DragInfo
import com.fanhl.hearthstone.model.manual.Operate
import com.fanhl.hearthstone.util.DataValidator
import com.fanhl.hearthstone.lang.Datable

/**
 * 根据手势输入,生成操作对象
 * Created by fanhl on 15/3/20.
 */
class OperateBuilder {
    static Operate create(DragInfo dragInfo) {
        def srcView = dragInfo.srcView
        def destView = dragInfo.destView

        def srcData = ((Datable) srcView).data
        def destData = ((Datable) destView).data

//        if (srcView instanceof Datable) srcData = ((Datable) srcView).data
//        if (destView instanceof Datable) destData = ((Datable) destView).data

        def b = DataValidator.isRole(srcData) && DataValidator.isRole(destData)
        if (b) {
            return createAttack(dragInfo)
        }
        return null
    }

    static Operate createAttack(DragInfo dragInfo) {
        def srcView = dragInfo.srcView
        def destView = dragInfo.destView

        def srcData = ((Datable) srcView).data
        def destData = ((Datable) destView).data

        new Operate(type: Operate.Type.ATTACK,
                obj1: srcData,
                obj2: destData)
    }


}
