package com.fanhl.hearthstone.drawable

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.fanhl.hearthstone.lang.MInt

/**居中显示MInt的drawable
 * Created by fanhl on 15/3/25.
 */
class MIntDrawable extends TextDrawable {
    MInt data

    {
        WIDTH2TEXT_SIZE = 0.6f
    }

    @Override
    void onDraw(Canvas canvas, Paint strokePaint, Paint fillPaint) {
        String text = data ? "$data" : DEFAULT_TEXT


        if (data?.isNormal()) fillPaint.setColor(Color.WHITE)
        else if (data?.isStrengthen()) fillPaint.setColor(Color.GREEN)
        else if (data?.isWeaken()) fillPaint.setColor(Color.RED)

        float x = (float) (width / 2)
        float y = (float) (height / 2 + offsetY)

        canvas.drawText(text, x, y, strokePaint)
        canvas.drawText(text, x, y, fillPaint)
    }
}
