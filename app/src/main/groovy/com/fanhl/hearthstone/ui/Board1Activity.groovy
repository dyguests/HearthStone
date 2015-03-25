package com.fanhl.hearthstone.ui

import android.os.Bundle
import com.arasthel.swissknife.SwissKnife
import com.arasthel.swissknife.annotations.InjectView
import com.fanhl.hearthstone.App
import com.fanhl.hearthstone.R
import com.fanhl.hearthstone.logic.Engine
import com.fanhl.hearthstone.logic.Presenter
import com.fanhl.hearthstone.model.Game
import com.fanhl.hearthstone.widget.container.GameView

public class Board1Activity extends AbstractBaseActivity {
    Engine engine
    Presenter presenter

    @InjectView(R.id.gameView)
    GameView gameView

    Game game

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board1)
        SwissKnife.inject(this)
        init()
    }

    void init() {
        game = new Game()
        presenter = new Presenter(gameView, game)

        engine = new Engine(presenter, gameView, game)

        engine.gameConnection = ((App) getApplication()).gameConnection

        engine.execute()

        gameView.data = game
    }

    @Override
    protected void onDestroy() {
        super.onDestroy()
        engine.destroy()
    }
}
