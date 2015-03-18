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

public class DragDemoActivity extends AbstractBaseActivity {
    Engine engine
    Game game

    @InjectView(R.id.item1)
    TextView item1
    @InjectView(R.id.container1)
    RelativeLayout container1
    @InjectView(R.id.container2)
    RelativeLayout container2
    @InjectView(R.id.item2)
    TextView item2


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drag_demo)
        SwissKnife.inject(this)
        init()
    }

    def init() {
        initModel()
        initView()
    }

    def initModel() {
        game = new Game()
    }

    def initView() {
        item1.onTouchListener = new HSTouchListener()

        item1.onDragListener = new HSDragListener()
        container1.onDragListener = new HSDragListener()
        container2.onDragListener = new HSDragListener()
        item2.onDragListener = new HSDragListener()

    }
}
