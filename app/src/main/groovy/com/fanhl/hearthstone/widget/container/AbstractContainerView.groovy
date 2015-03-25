package com.fanhl.hearthstone.widget.container

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

/**
 * Created by fanhl on 15/3/25.
 */
abstract class AbstractContainerView extends LinearLayout{

    AbstractContainerView(Context context) {
        super(context)
        init(context, null, 0)
    }

    AbstractContainerView(Context context, AttributeSet attrs) {
        super(context, attrs)
        init(context, attrs, 0)
    }

    AbstractContainerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr)
        init(context, attrs, defStyleAttr)
    }

    abstract void init(Context context, AttributeSet attributeSet, int defStyleAttr)
}
