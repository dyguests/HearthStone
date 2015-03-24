package com.fanhl.hearthstone.drawable

import android.graphics.*
import android.graphics.drawable.Drawable
import android.text.TextPaint
import com.fanhl.hearthstone.lang.MInt

/**
 * Created by fanhl on 15/3/24.
 */
class AttackDrawable extends Drawable {
    public static final String DEFAULT_TEXT = "0"

    MInt data
    private TextPaint paint

    AttackDrawable() {
        super()
        paint = new TextPaint()
        paint.setFlags(Paint.ANTI_ALIAS_FLAG)
        paint.setTextAlign(Paint.Align.CENTER)
        paint.setColor(Color.GREEN)
//        paint.setTextSize(getWidth())
        paint.setTextSize(50)
    }

    void onDraw(Canvas canvas, Paint paint) {
        String text = data ? "${data.current}" : DEFAULT_TEXT
        canvas.drawText(text, 110, 150, paint)
    }

    @Override
    void draw(Canvas canvas) {
        final Rect r = getBounds()

        final int count = canvas.save()
        canvas.translate(r.left, r.top)
        onDraw(canvas, paint)
        canvas.restoreToCount(count)
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds)
        paint.setTextSize(getWidth())
    }

    float getWidth() {
        def rect = getBounds()
        rect.right - rect.left
    }

    @Override
    void setAlpha(int alpha) {

    }

    @Override
    void setColorFilter(ColorFilter cf) {

    }

    @Override
    int getOpacity() {
//        return 0
        return PixelFormat.TRANSLUCENT
    }
}