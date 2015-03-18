package com.fanhl.hearthstone.drag

import android.view.View
import groovy.transform.ToString

/**
 * 存放拖拽的对象的信息
 * Created by fanhl on 15/3/13.
 */
@ToString
class DragInfo {
    View srcView
    View destView

    def data


}
