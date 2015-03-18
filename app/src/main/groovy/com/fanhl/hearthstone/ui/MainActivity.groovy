package com.fanhl.hearthstone.ui

import android.os.Bundle
import com.fanhl.hearthstone.App
import com.fanhl.hearthstone.R
import com.fanhl.hearthstone.http.GameConnection

public class MainActivity extends AbstractBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initGameConnection()

        findViewById(R.id.dragDemo).onClickListener = { openActivity(DragDemoActivity.class) }
        findViewById(R.id.board1).onClickListener = { openActivity(Board1Activity.class) }
    }

    def initGameConnection() {
        GameConnection gameConnection = new GameConnection()
        ((App) getApplication()).gameConnection = gameConnection
    }
}
