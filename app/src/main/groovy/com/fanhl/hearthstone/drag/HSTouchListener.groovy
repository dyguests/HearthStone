package com.fanhl.hearthstone.drag

import android.view.MotionEvent
import android.view.View

/**
 * 按下拖动
 * Created by fanhl on 15/3/13.
 */
class HSTouchListener implements View.OnTouchListener {
    @Override
    boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (isLastActionOver()) {
                    //新的action

                    DragInfo dragInfo = new DragInfo()
                    dragInfo.srcView = v

                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v)
                    v.startDrag(null, shadowBuilder, dragInfo, 0)
                } else {
                    //继续处理上一个未完成的action
                }
                return true
            default: return false
        }
    }

    boolean isLastActionOver() {
        true
    }
}
