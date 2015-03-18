package com.fanhl.hearthstone.drag

import android.view.DragEvent
import android.view.View
import com.fanhl.util.Lg

/**
 * Created by fanhl on 15/3/14.
 */
class HSDragListener implements View.OnDragListener {
    static def lgd = Lg.d.curry HSDragListener.class.getSimpleName()

    @Override
    boolean onDrag(View v, DragEvent event) {
        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED: return onDragStart(v, event)
            case DragEvent.ACTION_DRAG_ENTERED: return onDragEntered(v, event)
            case DragEvent.ACTION_DRAG_LOCATION: return onDragLocation(v, event)
            case DragEvent.ACTION_DROP: return onDragDrop(v, event)
            case DragEvent.ACTION_DRAG_EXITED: return onDragExited(v, event)
            case DragEvent.ACTION_DRAG_ENDED: return onDragEnded(v, event)
            default: return true
        }
    }

    private boolean onDragStart(View v, DragEvent event) {
//        lgd "ACTION_DRAG_STARTED v:$v event:$event"
        return true
    }

    private boolean onDragEntered(View v, DragEvent event) {
//        lgd "ACTION_DRAG_ENTERED v:$v event:$event"
        return true
    }

    private boolean onDragLocation(View view, DragEvent dragEvent) {
        true
    }

    private boolean onDragDrop(View v, DragEvent event) {
//        lgd "ACTION_DROP v:$v event:$event"
        final DragInfo dragInfo = (DragInfo) event.getLocalState()
        dragInfo.destView = v

        return true
    }

    private boolean onDragExited(View v, DragEvent event) {
//        lgd "ACTION_DRAG_EXITED v:$v event:$event"
        return true
    }

    private boolean onDragEnded(View v, DragEvent event) {
//        lgd "ACTION_DRAG_ENDED v:$v event:$event"

        final DragInfo dragInfo = (DragInfo) event.getLocalState()
        if (dragInfo.srcView == v) {
            lgd "拖拽结束 $dragInfo"
        }

        return true
    }
}
