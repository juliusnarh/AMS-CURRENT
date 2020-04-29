package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentFaf3BindingImpl extends FragmentFaf3Binding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.txtpinfo, 2);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener commentsandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of faf3.commentSss.get()
            //         is faf3.commentSss.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(comments);
            // localize variables for thread safety
            // faf3.commentSss != null
            boolean faf3CommentSssJavaLangObjectNull = false;
            // faf3
            com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_3_Pojo faf3 = mFaf3;
            // faf3 != null
            boolean faf3JavaLangObjectNull = false;
            // faf3.commentSss
            androidx.databinding.ObservableField<java.lang.String> faf3CommentSss = null;
            // faf3.commentSss.get()
            java.lang.String faf3CommentSssGet = null;



            faf3JavaLangObjectNull = (faf3) != (null);
            if (faf3JavaLangObjectNull) {


                faf3CommentSss = faf3.commentSss;

                faf3CommentSssJavaLangObjectNull = (faf3CommentSss) != (null);
                if (faf3CommentSssJavaLangObjectNull) {




                    faf3CommentSss.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public FragmentFaf3BindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private FragmentFaf3BindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.EditText) bindings[1]
            , (android.widget.TextView) bindings[2]
            );
        this.comments.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
        if (BR.faf3 == variableId) {
            setFaf3((com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_3_Pojo) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setFaf3(@Nullable com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_3_Pojo Faf3) {
        this.mFaf3 = Faf3;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.faf3);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeFaf3CommentSss((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeFaf3CommentSss(androidx.databinding.ObservableField<java.lang.String> Faf3CommentSss, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
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
        androidx.databinding.ObservableField<java.lang.String> faf3CommentSss = null;
        com.telpo.usb.finger.pojo.inputdistribution.pojo.FAF_3_Pojo faf3 = mFaf3;
        java.lang.String faf3CommentSssGet = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (faf3 != null) {
                    // read faf3.commentSss
                    faf3CommentSss = faf3.commentSss;
                }
                updateRegistration(0, faf3CommentSss);


                if (faf3CommentSss != null) {
                    // read faf3.commentSss.get()
                    faf3CommentSssGet = faf3CommentSss.get();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.comments, faf3CommentSssGet);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.comments, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, commentsandroidTextAttrChanged);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): faf3.commentSss
        flag 1 (0x2L): faf3
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}