package com.fanhl.hearthstone.model

import com.fanhl.hearthstone.model.container.Belong

/**
 * Created by fanhl on 15/3/14.
 */
class Game {

    int currentRoundIndex = 0

    Environment environment
    Manual manual
    Belong[] belongs

    Game() {
        environment = new Environment()
        manual = new Manual()
        belongs = [new Belong(), new Belong()]
    }
}
