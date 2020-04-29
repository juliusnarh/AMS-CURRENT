package com.telpo.usb.finger.transition;

import android.transition.AutoTransition;
import android.transition.Transition;

public class FadeOutTransition extends AutoTransition {

    private static final int FADE_OUT_DURATION = 250;

    private FadeOutTransition() {
        // force callers to call the factory method to instantiate this class
    }

    /**
     * Creates a AutoTransition that calls the {@linkplain TransitionListener#onTransitionEnd(Transition)}
     * of the passing Listener when complete
     */
    public static Transition withAction(TransitionListener finishingAction) {
        AutoTransition transition = new AutoTransition();
        transition.setDuration(FADE_OUT_DURATION);
        transition.addListener(finishingAction);
        return transition;
    }

}
