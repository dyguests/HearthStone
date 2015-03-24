package com.fanhl.hearthstone.model.manual


import com.fanhl.util.ChainList

/**
 * 操作(如一个Action[出一个211,摸一张牌]分成两个操作:[1.出一个211,2.摸一张牌])
 *
 * 改成策略模式
 *
 * Created by fanhl on 15/2/1.
 */
class Operate implements ChainList.Chainable<Operate> {
    Operate prev, next

    Type type
    def obj1
    def obj2
    def obj3

    /**
     * 操作类型
     */
    public static enum Type {
        /*攻击(A攻击B)*/ ATTACK(0),
        /*放置(把A放置到B中的C位置)*/PUT(1),
        /*使用(使用A)*/USE(2),
        /*使用(使用A指向B)*/USE2(3),
        /*使用技能(使用A)*/SKILL(4),
        /*使用技能(使用A指向B)*/SKILL2(5),
        /*选中(选中A)*/SELECT(6)

        int i

        def Type(int i) { this.i = i }
    }
}
