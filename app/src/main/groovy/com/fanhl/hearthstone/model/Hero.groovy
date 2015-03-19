package com.fanhl.hearthstone.model

import com.fanhl.hearthstone.lang.Costable
import com.fanhl.hearthstone.lang.MInt
import com.fanhl.hearthstone.lang.Nameable
import com.fanhl.hearthstone.lang.Roleable

/**
 * Created by fanhl on 15/1/24.
 */
class Hero implements Nameable, Roleable, Costable, Cloneable {
    //护甲
    int armor

    Hero() {
        title = "战士"

        attack = new MInt(1)
        blood = new MInt(30)
        armor = 0
    }
}