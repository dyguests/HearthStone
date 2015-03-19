package com.fanhl.hearthstone.lang

/**
 * 可角色的
 *
 * Created by fanhl on 15/3/19.
 */
trait Roleable {
    MInt attack
    MInt blood

    /**被冻住*/
    boolean isFrozen = false
    /**已攻击*/
    boolean isAttacked = false
}