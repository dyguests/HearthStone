package com.fanhl.hearthstone.widget.container

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.widget.LinearLayout
import com.arasthel.swissknife.SwissKnife
import com.arasthel.swissknife.annotations.InjectView
import com.fanhl.hearthstone.R
import com.fanhl.hearthstone.logic.Presenter
import com.fanhl.hearthstone.model.manual.Operate
import com.fanhl.hearthstone.widget.element.Demo1View
import com.fanhl.util.Lg

/**
 * Created by fanhl on 15/3/17.
 */
class GameView extends LinearLayout {
    static final def lgd = Lg.d.curry GameView.class.getSimpleName()

    Presenter presenter

    @InjectView(R.id.demo1View)
    Demo1View demo1View


    GameView(Context context) {
        super(context)
        init(context, null, 0)
    }

    GameView(Context context, AttributeSet attrs) {
        super(context, attrs)
        init(context, attrs, 0)
    }

    GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr)
        init(context, attrs, defStyleAttr)
    }

    def init(Context context, AttributeSet attributeSet, int i) {
        LayoutInflater inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
        inflater.inflate(R.layout.view_game, this)
        SwissKnife.inject(this)
    }

    void setPresenter(Presenter presenter) {
        this.presenter = presenter
        demo1View.presenter = presenter
    }

}
