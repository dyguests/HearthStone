package com.fanhl.hearthstone.ui

import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import com.arasthel.swissknife.SwissKnife
import com.arasthel.swissknife.annotations.InjectView
import com.fanhl.hearthstone.R
import com.fanhl.hearthstone.drag.HSDragListener
import com.fanhl.hearthstone.drag.HSTouchListener
import com.fanhl.hearthstone.logic.Engine
import com.fanhl.hearthstone.model.Game

public class Demo3Activity extends AbstractBaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_demo3)
    }
}
