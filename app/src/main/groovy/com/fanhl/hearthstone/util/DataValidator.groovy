package com.fanhl.hearthstone.util

import com.fanhl.hearthstone.lang.Roleable

/**
 * Created by fanhl on 15/3/24.
 */
class DataValidator {
    static boolean isRole(data) {
        def b = data instanceof Roleable
        b
    }
}
