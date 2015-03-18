package com.fanhl.hearthstone

import android.app.Application
import com.fanhl.hearthstone.http.GameConnection

/**
 * Created by fanhl on 15/3/17.
 */
class App extends Application{
    GameConnection gameConnection

    @Override
    void onCreate() {
        super.onCreate()
    }
}
