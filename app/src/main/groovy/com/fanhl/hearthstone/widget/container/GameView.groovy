package com.fanhl.hearthstone.widget.container

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.fanhl.hearthstone.R
import com.fanhl.hearthstone.logic.Presenter
import com.fanhl.util.Lg

/**
 * Created by fanhl on 15/3/17.
 */
class GameView extends LinearLayout {
    static final def lgd = Lg.d.curry GameView.class.getSimpleName()

    Presenter presenter



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
        assignViews()
    }

    private void assignViews() {
    }

    void setPresenter(Presenter presenter) {
        this.presenter = presenter
    }

}
