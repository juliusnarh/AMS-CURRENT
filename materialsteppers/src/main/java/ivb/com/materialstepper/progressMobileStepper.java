package ivb.com.materialstepper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import java.io.Serializable;
import java.util.List;

public abstract class progressMobileStepper extends AppCompatActivity implements View.OnClickListener {

    List<Class> mStepperFragmentList;
    private Button mPrevious;
    private ProgressBar mStepperProgress;
    private baseStepper mBaseStepper;
    private int RECOVERCURRENTSTATE = 0;
    private ScrollView mScroll;

    public static void hideKeyboard(Activity ctx) {
        try {
            InputMethodManager inputManager = (InputMethodManager) ctx.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(ctx.getCurrentFocus().getWindowToken(), 0);
        } catch (Exception ex) {
        }

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_mobile_stepper);

        Button mNext = (Button) findViewById(R.id.next);
        mPrevious = (Button) findViewById(R.id.back);
        mStepperProgress = (ProgressBar) findViewById(R.id.stepperprogressbar);
        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setOffscreenPageLimit(5);
        mScroll = (ScrollView) findViewById(R.id.mobilescroll);

        mNext.setOnClickListener(this);
        mPrevious.setOnClickListener(this);
        if (savedInstanceState != null) {
            if (savedInstanceState.getSerializable("HSTEPPERBASE") != null) {
                try {
                    mStepperFragmentList = (List<Class>) savedInstanceState.getSerializable("HSTEPPERBASE");
                    RECOVERCURRENTSTATE = savedInstanceState.getInt("HCURRENT");
                } catch (Exception e) {
                    e.printStackTrace();
                    //it's  okay we will recover from the init method
                    mStepperFragmentList = init();
                }
            } else {
                mStepperFragmentList = init();
            }
        } else {
            mStepperFragmentList = init();
        }
        mBaseStepper = new baseStepper(mViewPager, mStepperFragmentList, getSupportFragmentManager());
        mBaseStepper.CURRENT_PAGE = RECOVERCURRENTSTATE;
        RECOVERCURRENTSTATE = 0;
        BackButtonConfig();
        updateUI();
        mStepperProgress.setMax(mBaseStepper.TOTAL_PAGE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("HSTEPPERBASE", (Serializable) mStepperFragmentList);
        outState.putInt("HCURRENT", mBaseStepper.CURRENT_PAGE);
        super.onSaveInstanceState(outState);

    }

    protected void BackButtonConfig() {
        if (mBaseStepper.CURRENT_PAGE == 0)
            mPrevious.setVisibility(View.INVISIBLE);
        else
            mPrevious.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        hideKeyboard(this);
//        mScroll.setFillViewport(true);
        if (i == R.id.next) {
            if (checkStepper()) {
                mBaseStepper.onNextButtonClicked();
                BackButtonConfig();
                updateUI();
            }

        } else if (i == R.id.back) {
            mBaseStepper.onBackButtonClicked();
            BackButtonConfig();
            updateUI();
        }
    }

    public int getCurrentFragmentId() {
        return mBaseStepper.CURRENT_PAGE;
    }

    public boolean checkStepper() {
        if (mBaseStepper.resolveNavigation()) {
            return true;
        }
        onStepperCompleted();
        return false;

    }

    protected final void updateUI() {
        mScroll.pageScroll(View.FOCUS_UP);
        mStepperProgress.setProgress(mBaseStepper.CURRENT_PAGE + 1);
    }

    public abstract void onStepperCompleted();

    public abstract List<Class> init();

}


