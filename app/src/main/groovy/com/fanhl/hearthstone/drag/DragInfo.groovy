package com.fanhl.hearthstone.drag

import android.view.View
import groovy.transform.ToString

/**
 * 存放拖拽的对象的信息
 *
 * 将DragInfo改为OperateInfo
 * 因为此对象不仅包含拖拽信息,还是点击的信息
 *
 * Created by fanhl on 15/3/13.
 */
@ToString
class DragInfo {
    View srcView
//    def srcData

    View destView
//    def destData


}
