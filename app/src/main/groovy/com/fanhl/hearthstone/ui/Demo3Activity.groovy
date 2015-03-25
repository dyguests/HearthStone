package com.fanhl.hearthstone.ui

import android.os.Bundle
import com.fanhl.hearthstone.R
import com.fanhl.hearthstone.lang.MInt
import com.fanhl.hearthstone.model.card.Minion
import com.fanhl.hearthstone.model.card.Spell
import com.fanhl.hearthstone.model.card.Weapon
import com.fanhl.hearthstone.widget.element.CardView

public class Demo3Activity extends AbstractBaseActivity {

    CardView cardView1
    CardView cardView2
    CardView cardView3
    CardView cardView4

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_demo3)

        assignViews()

    }

    private void assignViews() {
        cardView1 = (CardView) findViewById(R.id.cardView1)
        cardView2 = (CardView) findViewById(R.id.cardView2)
        cardView3 = (CardView) findViewById(R.id.cardView3)
        cardView4 = (CardView) findViewById(R.id.cardView4)


        cardView2.setData(new Minion(cost: new MInt(2), attack: new MInt(3, 1), blood: new MInt(4, -1)))
        cardView3.setData(new Spell(cost: new MInt(2)))
        cardView4.setData(new Weapon(cost: new MInt(2), attack: new MInt(3, 1), blood: new MInt(4, -1)))
    }
}
