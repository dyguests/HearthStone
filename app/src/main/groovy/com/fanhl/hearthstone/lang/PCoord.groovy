package com.fanhl.hearthstone.lang

/**
 * 百分比坐标
 * The percentage of coordinate
 *
 * Created by fanhl on 15/3/25.
 */
class PCoord {
    /**
     * 百分比坐标,取值应该在[0,1]之间
     */
    float x, y

    PCoord(float x = 0, float y = 0) {
        this.x = x
        this.y = y
    }
}
