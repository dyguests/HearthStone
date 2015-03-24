package com.fanhl.hearthstone.lang

import groovy.transform.AutoClone

/**
 * 用于存放由多个值组成的数值
 *
 * Created by fanhl on 15/1/23.
 */
@AutoClone
class MInt {
    /**基本值*/
    int base
    /**加成值*/
    int add
    /**回合加成值*/
    int tmpAdd
    /**实际值(对某些类型无效,给血量用,像这样显示 current/(base+add+tmpAdd+site))*/
    int current

    public MInt(int base = 0, int add = 0, int tmpAdd = 0) {
        this.base = base
        this.add = add
        this.tmpAdd = tmpAdd
        this.current = base + add + tmpAdd + getOutValue()
    }

    /**
     * 取得外部加成
     * @return
     */
    int getOutValue() { 0 }


    public static MInt plus(MInt value, MInt right) {
        value.current += right.current
        value
    }

    public static MInt minus(MInt value, MInt right) {
        value.current -= right.current
        value
    }

    @Override
    String toString() { current }
}