package com.fanhl.hearthstone.widget.element

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import com.fanhl.hearthstone.drawable.AttackDrawable
import com.fanhl.hearthstone.lang.MInt

class Demo2View extends View {
    AttackDrawable attackDrawable = new AttackDrawable();
//    TextDrawable attackDrawable = new TextDrawable();

    {
        attackDrawable.data = new MInt(86,1)
    }

    Demo2View(Context context) {
        super(context)
    }

    Demo2View(Context context, AttributeSet attrs) {
        super(context, attrs)
    }

    Demo2View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr)
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas)
        attackDrawable.setBounds(0, 0, width, height)
        attackDrawable.draw(canvas)
    }
}