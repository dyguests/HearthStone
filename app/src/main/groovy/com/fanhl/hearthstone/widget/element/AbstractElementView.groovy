package com.fanhl.hearthstone.widget.element

import android.content.Context
import android.util.AttributeSet
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import com.fanhl.hearthstone.R
import com.fanhl.hearthstone.drag.DragInfo
import com.fanhl.hearthstone.logic.Presenter
import com.fanhl.util.Lg

/**
 * 所有要MVP交互的view的抽象类
 * 所有子类看情况实现setPresenter方法
 *
 *
 * Created by fanhl on 15/3/19.
 */
abstract class AbstractElementView extends View {
    static def lgd = Lg.d.curry AbstractElementView.class.getSimpleName()

    protected Presenter presenter
    protected int newWidthMeasureSpec
    protected int newHeightMeasureSpec

    AbstractElementView(Context context) {
        super(context)
        init(context, null, 0)
    }

    AbstractElementView(Context context, AttributeSet attrs) {
        super(context, attrs)
        init(context, attrs, 0)
    }

    AbstractElementView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr)
        init(context, attrs, defStyleAttr)
    }

    void init(Context context, AttributeSet attrs, int defStyleAttr) {
        initMeasureSpec(context)
    }

    private void initMeasureSpec(Context context) {
        int heroWidth = context.getResources().getDimension(R.dimen.view_hero_width)
        int heroHeight = context.getResources().getDimension(R.dimen.view_hero_height)
        //注意,这里要用  android.view.View.MeasureSpec ,一定要写全包名
        newWidthMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(heroWidth, android.view.View.MeasureSpec.EXACTLY)
        newHeightMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(heroHeight, android.view.View.MeasureSpec.EXACTLY)
    }

    /**
     *
     * @param event
     * @return
     */
    @Override
    boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: onTouchDown(); return true
            default: return super.onTouchEvent(event)
        }
    }

    /**
     * 按下时处理
     */
    protected abstract void onTouchDown()

    @Override
    boolean onDragEvent(DragEvent event) {
        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED: return true
            case DragEvent.ACTION_DRAG_ENTERED: return true
            case DragEvent.ACTION_DRAG_LOCATION: return true
            case DragEvent.ACTION_DROP: onDragDrop(event); return true
            case DragEvent.ACTION_DRAG_EXITED: return true
            case DragEvent.ACTION_DRAG_ENDED: onDragEnded(event); return true
            default: return true
        }
    }

    /**
     * 拖拽松手时处理
     * @param event
     */
    abstract void onDragDrop(DragEvent event)

    void onDragEnded(DragEvent event) {
        final DragInfo dragInfo = (DragInfo) event.getLocalState()
        if (dragInfo.srcView == this) {
            onSelfDragEnded(dragInfo)
        }
    }

    /**
     * 拖拽结束后,发生拖拽手势的View的处理
     * @param dragInfo
     */
    protected abstract void onSelfDragEnded(DragInfo dragInfo)

    /**
     * 绑定view的presenter,及子view的presenter
     * @param presenter
     */
    void setPresenter(Presenter presenter) {
        this.presenter = presenter
    }
}
