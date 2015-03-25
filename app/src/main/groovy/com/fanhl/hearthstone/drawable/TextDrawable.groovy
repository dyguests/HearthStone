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
    public static final int DEFAULT_TEXT_COLOR = Color.BLACK

    /**
     * Drawable宽度与文字大小的比率
     */
    public static float WIDTH2TEXT_SIZE = 1.0f

    protected TextPaint strokePaint
    protected TextPaint fillPaint

    protected float offsetY

    def data

    TextDrawable() {
        strokePaint = new TextPaint()
        strokePaint.setFlags(Paint.ANTI_ALIAS_FLAG)
        strokePaint.setTextAlign(Paint.Align.CENTER)
        strokePaint.setStrokeWidth(2f)
        strokePaint.setStyle(Paint.Style.STROKE)
        strokePaint.setColor(DEFAULT_TEXT_COLOR)
        strokePaint.setTextSize(DEFAULT_TEXT_SIZE)//not use
//        strokePaint.setFakeBoldText(true) // 外层text采用粗体

        fillPaint = new TextPaint()
        fillPaint.setFlags(Paint.ANTI_ALIAS_FLAG)
        fillPaint.setTextAlign(Paint.Align.CENTER)
        strokePaint.setStyle(Paint.Style.FILL)
        fillPaint.setColor(DEFAULT_TEXT_COLOR)
        fillPaint.setTextSize(DEFAULT_TEXT_SIZE)//not use


        refreshOffsetY()
    }

    void onDraw(Canvas canvas, Paint strokePaint, Paint fillPaint) {
        String text = data ? "$data" : DEFAULT_TEXT

        float x = (float) (width / 2)
        float y = (float) (height / 2 + offsetY)

        canvas.drawText(text, x, y, fillPaint)
        canvas.drawText(text, x, y, strokePaint)
    }

    @Override
    void draw(Canvas canvas) {
        final Rect r = getBounds()

        final int count = canvas.save()
        canvas.translate(r.left, r.top)
        onDraw(canvas, strokePaint, fillPaint)
        canvas.restoreToCount(count)
    }

    /**
     * 为了使文字垂直居中的垂直偏移量
     */
    protected void refreshOffsetY() {
        offsetY = -(float) ((strokePaint.getFontMetrics().top + strokePaint.getFontMetrics().bottom) / 2)
    }

    @Override
    void setAlpha(int alpha) {}

    @Override
    void setColorFilter(ColorFilter cf) {}

    @Override
    int getOpacity() { PixelFormat.TRANSLUCENT }

    @Override
    protected void onBoundsChange(Rect bounds) {
        strokePaint.setStrokeWidth(((float) (getWidth() * WIDTH2TEXT_SIZE*0.01)))
        strokePaint.setTextSize(((float) (getWidth() * WIDTH2TEXT_SIZE)))
        fillPaint.setTextSize(((float) (getWidth() * WIDTH2TEXT_SIZE)))
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
