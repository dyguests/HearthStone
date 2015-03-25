package com.fanhl.hearthstone.lang

/**
 * Created by fanhl on 15/3/25.
 */
trait Attackable {
    MInt attack
    MInt blood

    /**已攻击*/
    boolean isAttacked = false
}