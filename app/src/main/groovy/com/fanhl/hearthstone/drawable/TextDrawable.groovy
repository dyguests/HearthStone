package com.fanhl.hearthstone.drawable

import android.graphics.*
import android.graphics.drawable.Drawable
import android.text.TextPaint

/**居中显示文字的Drawable
 * Created by fanhl on 15/3/25.
 */
class TextDrawable extends Drawable {
    public static final String DEFAULT_TEXT = "NA."
    public static final int DEFAULT_TEXT_SIZE = 20
    public static final int DEFAULT_TEXT_COLOR = Color.GREEN

    /**
     * Drawable宽度与文字大小的比率
     */
    public static float WIDTH2TEXT_SIZE = 1.0f

    protected TextPaint paint
    protected float offsetY

    def data

    TextDrawable() {
        paint = new TextPaint()
        paint.setFlags(Paint.ANTI_ALIAS_FLAG)
        paint.setTextAlign(Paint.Align.CENTER)
        paint.setColor(DEFAULT_TEXT_COLOR)
        paint.setTextSize(DEFAULT_TEXT_SIZE)//not use
        refreshOffsetY()
    }

    void onDraw(Canvas canvas, Paint paint) {
        String text = data ? "$data" : DEFAULT_TEXT
        canvas.drawText(text, ((float) (width / 2)), ((float) (height / 2 + offsetY)), paint)
    }

    @Override
    void draw(Canvas canvas) {
        final Rect r = getBounds()

        final int count = canvas.save()
        canvas.translate(r.left, r.top)
        onDraw(canvas, paint)
        canvas.restoreToCount(count)
    }

    /**
     * 为了使文字垂直居中的垂直偏移量
     */
    protected void refreshOffsetY() {
        offsetY = -(float) ((paint.getFontMetrics().top + paint.getFontMetrics().bottom) / 2)
    }

    @Override
    void setAlpha(int alpha) {}

    @Override
    void setColorFilter(ColorFilter cf) {}

    @Override
    int getOpacity() { PixelFormat.TRANSLUCENT }

    @Override
    protected void onBoundsChange(Rect bounds) {
        paint.setTextSize(((float) (getWidth() * WIDTH2TEXT_SIZE)))
        refreshOffsetY()
    }

    float getWidth() {
        def rect = getBounds()
        rect.right - rect.left
    }

    float getHeight() {
        def rect = getBounds()
        rect.bottom - rect.top
    }
}
