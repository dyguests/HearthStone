package com.fanhl.hearthstone.widget.element

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.DragEvent
import android.view.View
import com.fanhl.hearthstone.R
import com.fanhl.hearthstone.builder.OperateBuilder
import com.fanhl.hearthstone.drag.DragInfo
import com.fanhl.hearthstone.drawable.MIntDrawable
import com.fanhl.hearthstone.lang.Datable
import com.fanhl.hearthstone.model.Hero
import groovy.transform.InheritConstructors

/**
 * 英雄
 *
 * Created by fanhl on 15/3/18.
 */
@InheritConstructors
class HeroView extends AbstractElementView implements Datable<Hero> {
    Drawable foregroundDrawable

    MIntDrawable attackDrawable
    MIntDrawable bloodDrawable

    Hero data


    @Override
    void init(Context context, AttributeSet attrs, int defStyleAttr) {
        super.init(context, attrs, defStyleAttr)
        foregroundDrawable = getResources().getDrawable(R.drawable.hero_view_background)
        attackDrawable = new MIntDrawable()
        bloodDrawable = new MIntDrawable()
    }

    @Override
    protected float getInitWidth(Context context) {
        context.getResources().getDimension(R.dimen.view_hero_width)
    }

    @Override
    protected float getInitHeight(Context context) {
        context.getResources().getDimension(R.dimen.view_hero_height)
    }

    @Override
    protected void onTouchDown() {
        if (presenter.validateTouchDown(this)) {
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
        presenter.processOperate(OperateBuilder.create(dragInfo))
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas)

        foregroundDrawable?.with {
            setBounds(0, 0, width, height)
            draw(canvas)
        }
        attackDrawable.setBounds(0, 0, width, height)
        attackDrawable.draw(canvas)

//        bloodDrawable?.with {
//            setBounds(0, 0, width, height)
//            draw(canvas)
//        }
    }

    void setData(Hero data) {
        this.data = data
        attackDrawable.data = data.attack
        bloodDrawable.data = data.blood
    }
}
