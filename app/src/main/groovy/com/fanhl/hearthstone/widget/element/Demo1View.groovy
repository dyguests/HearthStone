package com.fanhl.hearthstone.widget.element

import android.content.Context
import android.util.AttributeSet
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import com.fanhl.hearthstone.drag.DragInfo
import com.fanhl.hearthstone.logic.Presenter
import com.fanhl.util.Lg

/**
 * Created by fanhl on 15/3/17.
 */
class Demo1View extends TextView {
    static def lgd = Lg.d.curry Demo1View.class.getSimpleName()

    Presenter presenter

    Demo1View(Context context) {
        super(context)
        init(context, null, 0)
    }

    Demo1View(Context context, AttributeSet attrs) {
        super(context, attrs)
        init(context, attrs, 0)
    }

    Demo1View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr)
        init(context, attrs, defStyleAttr)
    }

    def init(Context context, AttributeSet attributeSet, int i) {
    }

    @Override
    boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (onTouchDown()) {
                    //新的action
                    DragInfo dragInfo = new DragInfo()
                    dragInfo.srcView = this

                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(this)
                    this.startDrag(null, shadowBuilder, dragInfo, 0)
                } else {
                    //继续处理上一个未完成的action
                }
                return true
            default: return super.onTouchEvent(event)
        }
    }

    boolean onTouchDown() {
        presenter.validateOperate(null)
    }

    @Override
    boolean onDragEvent(DragEvent event) {
        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED: return true
            case DragEvent.ACTION_DRAG_ENTERED: return true
            case DragEvent.ACTION_DRAG_LOCATION: return true
            case DragEvent.ACTION_DROP: return onDragDrop(event)
            case DragEvent.ACTION_DRAG_EXITED: return true
            case DragEvent.ACTION_DRAG_ENDED: return onDragEnded(event)
            default: return true
        }
    }

    boolean onDragDrop(DragEvent event) {
        final DragInfo dragInfo = (DragInfo) event.getLocalState()
        dragInfo.destView = this
        true
    }

    boolean onDragEnded(DragEvent event) {
        final DragInfo dragInfo = (DragInfo) event.getLocalState()
        if (dragInfo.srcView == this) {
            lgd "拖拽结束 $dragInfo"

            presenter.processOperate(null)
        }

        return true
    }

}
