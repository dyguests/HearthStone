package com.fanhl.hearthstone.widget.element

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.DragEvent
import android.view.View
import com.fanhl.hearthstone.R
import com.fanhl.hearthstone.drag.DragInfo
import groovy.transform.InheritConstructors

/**
 * Created by fanhl on 15/3/18.
 */
@InheritConstructors
class HeroView extends AbstractElementView {
    Drawable foregroundDrawable

    @Override
    void init(Context context, AttributeSet attrs, int defStyleAttr) {
        super.init(context, attrs, defStyleAttr)
        foregroundDrawable = getResources().getDrawable(R.drawable.hero_view_background)
    }

    @Override
    protected void onTouchDown() {
        if (true) {
            //新的action
            DragInfo dragInfo = new DragInfo()
            dragInfo.srcView = this

            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(this)
            this.startDrag(null, shadowBuilder, dragInfo, 0)
        } else {
            //继续处理上一个未完成的action
        }
    }


    @Override
    void onDragDrop(DragEvent event) {
        final DragInfo dragInfo = (DragInfo) event.getLocalState()
        dragInfo.destView = this
    }


    @Override
    protected void onSelfDragEnded(DragInfo dragInfo) {
        lgd "拖拽结束 $dragInfo"

        //FIXME 之后去掉?号
        presenter?.processOperate("drag this form a to b")
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(newWidthMeasureSpec, newHeightMeasureSpec)
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas)

        foregroundDrawable?.with {
            setBounds(0, 0, width, height)
            draw(canvas)
        }
    }

}
