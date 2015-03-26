package com.fanhl.hearthstone.widget.container

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import com.fanhl.hearthstone.R
import com.fanhl.hearthstone.lang.Datable
import com.fanhl.hearthstone.model.container.Belong
import groovy.transform.InheritConstructors

/**
 * 玩家所属区域(用来区分游戏双方)
 *
 * Created by fanhl on 15/1/28.
 */
@InheritConstructors
public class BelongView extends AbstractContainerView implements Datable<Belong> {
    public static final int OWNER_ME = 0
    public static final int OWNER_RIVAL = 1

    int owner = OWNER_ME


    Belong data


    @Override
    void init(Context context, AttributeSet attributeSet, int defStyleAttr) {
        LayoutInflater inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)

        // Load attributes
        final TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.BelongView, defStyle, 0)
        owner = typedArray.getInt(R.styleable.BelongView_owner, owner)
        typedArray.recycle()

        if (owner == OWNER_ME) {
            inflater.inflate(R.layout.view_belong_me, this)
        } else {
            inflater.inflate(R.layout.view_belong_rival, this)
        }
        assignViews()
    }

    private void assignViews() {

    }

    void setData(Belong data) {
        this.data = data
    }

    def findViewByData(def data) {}
}