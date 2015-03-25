package com.fanhl.hearthstone.widget.container

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import com.fanhl.hearthstone.R
import com.fanhl.hearthstone.lang.Datable
import com.fanhl.hearthstone.logic.Presenter
import com.fanhl.hearthstone.model.Game
import com.fanhl.util.Lg
import groovy.transform.InheritConstructors

/**
 * Created by fanhl on 15/3/17.
 */
@InheritConstructors
class GameView extends AbstractContainerView implements Datable<Game> {
    static final def lgd = Lg.d.curry GameView.class.getSimpleName()


    LinearLayout manualView
//    LinearLayout belongsContainer
    BelongView[] belongViews

    Button nextTurnButton


    Game data


    @Override
    void init(Context context, AttributeSet attributeSet, int defStyleAttr) {
        LayoutInflater inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
        inflater.inflate(R.layout.view_game, this)
        assignViews()
    }

    private void assignViews() {
        manualView = (LinearLayout) findViewById(R.id.manualView)
//        belongsContainer = (LinearLayout) findViewById(R.id.belongsContainer)
        belongViews = new BelongView[2]
        belongViews[1] = (BelongView) findViewById(R.id.belongRival)
        belongViews[0] = (BelongView) findViewById(R.id.belongMe)

        nextTurnButton = (Button) findViewById(R.id.nextTurnButton)
    }

    @Override
    void setPresenter(Presenter presenter) {
        this.presenter = presenter
        belongViews*.presenter = presenter
    }

    void setData(Game game) {
        this.data = game
        belongViews[0].data = game.belongs[0]
        belongViews[1].data = game.belongs[1]
    }

    View findViewByData(def data) {
        View view = belongViews.find { it.data == data }
        if (view) return view

        view = belongViews[0].findViewByData(data)
        if (view) return view

        view = belongViews[1].findViewByData(data)
        view
    }
}
