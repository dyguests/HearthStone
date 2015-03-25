package com.fanhl.hearthstone.widget.element

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import com.fanhl.hearthstone.R
import com.fanhl.hearthstone.drag.DragInfo
import com.fanhl.hearthstone.drawable.MIntDrawable
import com.fanhl.hearthstone.exception.CardTypeNotFoundException
import com.fanhl.hearthstone.lang.Datable
import com.fanhl.hearthstone.lang.MInt
import com.fanhl.hearthstone.lang.PCoord
import com.fanhl.hearthstone.lang.Roleable
import com.fanhl.hearthstone.model.card.Card
import com.fanhl.hearthstone.model.card.Minion
import com.fanhl.hearthstone.model.card.Spell
import com.fanhl.hearthstone.model.card.Weapon
import groovy.transform.InheritConstructors

/**
 * Created by fanhl on 15/3/25.
 */
@InheritConstructors
class CardView extends AbstractElementView implements Datable<Card> {
    public static final int DIRECTION_FACE = 0
    public static final int DIRECTION_BACK = 1
    public static final int DIRECTION_UPSIDEDOWN = 2

    /**
     * 控件宽度与显示文字MInt的比率
     */
    public static float WIDTH2MINT_SIZE = 0.26f

    Drawable viewTemplateDrawable
    MIntDrawable costDrawable
    MIntDrawable attackDrawable
    MIntDrawable bloodDrawable

    PCoord costCoord
    PCoord attackCoord
    PCoord bloodCoord

    int direction = DIRECTION_FACE

    Card data

    @Override
    void init(Context context, AttributeSet attrs, int defStyleAttr) {
        super.init(context, attrs, defStyleAttr)
        viewTemplateDrawable = getResources().getDrawable(R.drawable.card_back_template)
        costDrawable = new MIntDrawable()
        attackDrawable = new MIntDrawable()
        bloodDrawable = new MIntDrawable()

        //和MInt元素的相对坐标
        costCoord = new PCoord(0.143f, 0.106f)
        attackCoord = new PCoord(0.143f, 0.891f)
        bloodCoord = new PCoord(0.881f, 0.893f)

        //测试用
        if (isInEditMode()) {
            setData(new Minion(cost: new MInt(2), attack: new MInt(3, 1), blood: new MInt(4, -1)))
        }
    }

    @Override
    protected float getInitWidth(Context context) {
        context.getResources().getDimension(R.dimen.view_card_width)
    }

    @Override
    protected float getInitHeight(Context context) {
        context.getResources().getDimension(R.dimen.view_card_height)
    }

    @Override
    protected void onTouchDown() {

    }


    @Override
    protected void onSelfDragEnded(DragInfo dragInfo) {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas)

        viewTemplateDrawable.with {
            setBounds(0, 0, width, height)
            draw(canvas)
        }

        setPercentBounds(costDrawable, costCoord, WIDTH2MINT_SIZE, width, height)
        costDrawable.draw(canvas)

        if (data instanceof Roleable) {
            setPercentBounds(attackDrawable, attackCoord, WIDTH2MINT_SIZE, width, height)
            attackDrawable.draw(canvas)
            setPercentBounds(bloodDrawable, bloodCoord, WIDTH2MINT_SIZE, width, height)
            bloodDrawable.draw(canvas)
        }
    }

    void setPercentBounds(MIntDrawable mIntDrawable, PCoord coord, float rate, int width, int height) {
        int left, top, right, bottom
        //边长
        int halfPbSize = rate * width / 2//Math.min(width,height)
        left = coord.x * width - halfPbSize
        top = coord.y * height - halfPbSize
        right = coord.x * width + halfPbSize
        bottom = coord.y * height + halfPbSize

        mIntDrawable.setBounds(left, top, right, bottom)
    }

    void setData(Card data) {
        this.data = data

        switch (data) {
            case Minion: viewTemplateDrawable = getResources().getDrawable(R.drawable.card_minion_template); break
            case Spell: viewTemplateDrawable = getResources().getDrawable(R.drawable.card_spell_template); break
            case Weapon: viewTemplateDrawable = getResources().getDrawable(R.drawable.card_weapon_template); break
            default: throw new CardTypeNotFoundException("未找到卡牌类型")
        }

        costDrawable.data = data.cost
        if (data instanceof Roleable) {
            attackDrawable.data = data.attack
            bloodDrawable.data = data.blood
        }
    }
}
