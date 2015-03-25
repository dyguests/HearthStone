package com.fanhl.hearthstone.drawable

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.Shape
import android.text.TextPaint
import com.fanhl.hearthstone.lang.MInt

/**
 * Created by fanhl on 15/3/24.
 */
@Deprecated
class BloodDrawable extends ShapeDrawable {
    MInt data
    private TextPaint paint

    BloodDrawable() {
        super()
        paint = new TextPaint()
        paint.setFlags(Paint.ANTI_ALIAS_FLAG)
        paint.setTextAlign(Paint.Align.CENTER)//FIXME 这是原来的
        paint.setColor(Color.GREEN)//FIXME 写入资源文件
        paint.setTextSize(54f)
    }

    @Override
    protected void onDraw(Shape shape, Canvas canvas, Paint paint) {
//        super.onDraw(shape, canvas, paint)
        data?.with {
            canvas.drawText("${data.current}", 20, 20, paint)
        }
    }

    @Override
    void draw(Canvas canvas) {
        final Rect r = getBounds();

        final int count = canvas.save();
        canvas.translate(r.left, r.top);
        onDraw(null, canvas, paint);
        canvas.restoreToCount(count);
    }
}