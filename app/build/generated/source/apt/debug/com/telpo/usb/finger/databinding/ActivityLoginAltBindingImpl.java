package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityLoginAltBindingImpl extends ActivityLoginAltBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.login_progress, 3);
        sViewsWithIds.put(R.id.animation_view, 4);
        sViewsWithIds.put(R.id.login_form, 5);
        sViewsWithIds.put(R.id.email_login_form, 6);
        sViewsWithIds.put(R.id.cov, 7);
        sViewsWithIds.put(R.id.cocoa, 8);
        sViewsWithIds.put(R.id.cover, 9);
        sViewsWithIds.put(R.id.textView2, 10);
        sViewsWithIds.put(R.id.textView3, 11);
        sViewsWithIds.put(R.id.form, 12);
        sViewsWithIds.put(R.id.btnlogin, 13);
        sViewsWithIds.put(R.id.link_signup, 14);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityLoginAltBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }
    private ActivityLoginAltBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.airbnb.lottie.LottieAnimationView) bindings[4]
            , (android.widget.Button) bindings[13]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.FrameLayout) bindings[0]
            , (android.widget.RelativeLayout) bindings[7]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.RelativeLayout) bindings[6]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.TextView) bindings[14]
            , (android.widget.ScrollView) bindings[5]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.EditText) bindings[2]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[11]
            , (android.widget.EditText) bindings[1]
            );
        this.container.setTag(null);
        this.password.setTag(null);
        this.username.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
        if ((dirtyFlags & 0x1L) != 0) {
            // api target 1

            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.password, true, (java.lang.String)null, (boolean)false);
            br.com.ilhasoft.support.validation.binding.LengthBindings.bindingEmpty(this.username, true, (java.lang.String)null, (boolean)false);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}