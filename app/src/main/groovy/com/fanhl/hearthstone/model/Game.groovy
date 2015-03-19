package com.fanhl.hearthstone.model

/**
 * Created by fanhl on 15/3/14.
 */
class Game {
    Environment environment
    Manual manual
    Belong[] belongs

    Game() {
        environment = new Environment()
        manual = new Manual()
        belongs = [new Belong(), new Belong()]
    }
}
