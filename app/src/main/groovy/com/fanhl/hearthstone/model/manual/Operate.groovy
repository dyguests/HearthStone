package com.fanhl.hearthstone.model.manual


import com.fanhl.util.NodeList

/**
 * 操作(如一个Action[出一个211,摸一张牌]分成两个操作:[1.出一个211,2.摸一张牌])
 *
 * 改成策略模式
 *
 * Created by fanhl on 15/2/1.
 */
class Operate implements NodeList.Nodeable<Operate> {
    Operate prev, next

}
