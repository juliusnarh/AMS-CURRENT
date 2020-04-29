package com.telpo.usb.finger.databinding;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentIpsettingsBindingImpl extends FragmentIpsettingsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.btnsave, 6);
    }
    // views
    @NonNull
    private final android.widget.FrameLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener txtcontextandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of ip.context.get()
            //         is ip.context.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(txtcontext);
            // localize variables for thread safety
            // ip.context != null
            boolean ipContextJavaLangObjectNull = false;
            // ip
            com.telpo.usb.finger.pojo.IPSettingsPojo ip = mIp;
            // ip.context
            androidx.databinding.ObservableField<java.lang.String> ipContext = null;
            // ip.context.get()
            java.lang.String ipContextGet = null;
            // ip != null
            boolean ipJavaLangObjectNull = false;



            ipJavaLangObjectNull = (ip) != (null);
            if (ipJavaLangObjectNull) {


                ipContext = ip.context;

                ipContextJavaLangObjectNull = (ipContext) != (null);
                if (ipContextJavaLangObjectNull) {




                    ipContext.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener txtipandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of ip.ipaddress.get()
            //         is ip.ipaddress.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(txtip);
            // localize variables for thread safety
            // ip.ipaddress
            androidx.databinding.ObservableField<java.lang.String> ipIpaddress = null;
            // ip
            com.telpo.usb.finger.pojo.IPSettingsPojo ip = mIp;
            // ip.ipaddress.get()
            java.lang.String ipIpaddressGet = null;
            // ip.ipaddress != null
            boolean ipIpaddressJavaLangObjectNull = false;
            // ip != null
            boolean ipJavaLangObjectNull = false;



            ipJavaLangObjectNull = (ip) != (null);
            if (ipJavaLangObjectNull) {


                ipIpaddress = ip.ipaddress;

                ipIpaddressJavaLangObjectNull = (ipIpaddress) != (null);
                if (ipIpaddressJavaLangObjectNull) {




                    ipIpaddress.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener txtportandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of ip.port.get()
            //         is ip.port.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(txtport);
            // localize variables for thread safety
            // ip.port.get()
            java.lang.String ipPortGet = null;
            // ip
            com.telpo.usb.finger.pojo.IPSettingsPojo ip = mIp;
            // ip.port != null
            boolean ipPortJavaLangObjectNull = false;
            // ip.port
            androidx.databinding.ObservableField<java.lang.String> ipPort = null;
            // ip != null
            boolean ipJavaLangObjectNull = false;



            ipJavaLangObjectNull = (ip) != (null);
            if (ipJavaLangObjectNull) {


                ipPort = ip.port;

                ipPortJavaLangObjectNull = (ipPort) != (null);
                if (ipPortJavaLangObjectNull) {




                    ipPort.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener txtprotocolandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of ip.protocol.get()
            //         is ip.protocol.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(txtprotocol);
            // localize variables for thread safety
            // ip.protocol != null
            boolean ipProtocolJavaLangObjectNull = false;
            // ip
            com.telpo.usb.finger.pojo.IPSettingsPojo ip = mIp;
            // ip.protocol.get()
            java.lang.String ipProtocolGet = null;
            // ip.protocol
            androidx.databinding.ObservableField<java.lang.String> ipProtocol = null;
            // ip != null
            boolean ipJavaLangObjectNull = false;



            ipJavaLangObjectNull = (ip) != (null);
            if (ipJavaLangObjectNull) {


                ipProtocol = ip.protocol;

                ipProtocolJavaLangObjectNull = (ipProtocol) != (null);
                if (ipProtocolJavaLangObjectNull) {




                    ipProtocol.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public FragmentIpsettingsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private FragmentIpsettingsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4
            , (android.widget.Button) bindings[6]
            , (android.widget.TextView) bindings[4]
            , (android.widget.EditText) bindings[3]
            , (android.widget.EditText) bindings[1]
            , (android.widget.EditText) bindings[2]
            , (android.widget.EditText) bindings[5]
            );
        this.mboundView0 = (android.widget.FrameLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.txtcomplete.setTag(null);
        this.txtcontext.setTag(null);
        this.txtip.setTag(null);
        this.txtport.setTag(null);
        this.txtprotocol.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
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
        if (BR.ip == variableId) {
            setIp((com.telpo.usb.finger.pojo.IPSettingsPojo) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setIp(@Nullable com.telpo.usb.finger.pojo.IPSettingsPojo Ip) {
        this.mIp = Ip;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.ip);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeIpIpaddress((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeIpProtocol((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeIpContext((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeIpPort((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeIpIpaddress(androidx.databinding.ObservableField<java.lang.String> IpIpaddress, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeIpProtocol(androidx.databinding.ObservableField<java.lang.String> IpProtocol, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeIpContext(androidx.databinding.ObservableField<java.lang.String> IpContext, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeIpPort(androidx.databinding.ObservableField<java.lang.String> IpPort, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
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
        java.lang.String ipProtocolGet = null;
        java.lang.String androidUtilsTolowerIpProtocolJavaLangString = null;
        java.lang.String ipPortGet = null;
        java.lang.String androidUtilsTolowerIpContext = null;
        androidx.databinding.ObservableField<java.lang.String> ipIpaddress = null;
        java.lang.String androidUtilsTolowerIpProtocolJavaLangStringAndroidUtilsTolowerIpIpaddressJavaLangStringAndroidUtilsTolowerIpPortJavaLangString = null;
        java.lang.String ipContextGet = null;
        com.telpo.usb.finger.pojo.IPSettingsPojo ip = mIp;
        java.lang.String androidUtilsTolowerIpProtocolJavaLangStringAndroidUtilsTolowerIpIpaddress = null;
        java.lang.String androidUtilsTolowerIpPort = null;
        java.lang.String ipIpaddressGet = null;
        java.lang.String androidUtilsTolowerIpProtocolJavaLangStringAndroidUtilsTolowerIpIpaddressJavaLangStringAndroidUtilsTolowerIpPortJavaLangStringAndroidUtilsTolowerIpContext = null;
        java.lang.String androidUtilsTolowerIpProtocolJavaLangStringAndroidUtilsTolowerIpIpaddressJavaLangStringAndroidUtilsTolowerIpPort = null;
        androidx.databinding.ObservableField<java.lang.String> ipProtocol = null;
        java.lang.String androidUtilsTolowerIpProtocolJavaLangStringAndroidUtilsTolowerIpIpaddressJavaLangString = null;
        java.lang.String androidUtilsTolowerIpIpaddress = null;
        androidx.databinding.ObservableField<java.lang.String> ipContext = null;
        java.lang.String androidUtilsTolowerIpProtocol = null;
        androidx.databinding.ObservableField<java.lang.String> ipPort = null;

        if ((dirtyFlags & 0x3fL) != 0) {



                if (ip != null) {
                    // read ip.ipaddress
                    ipIpaddress = ip.ipaddress;
                    // read ip.protocol
                    ipProtocol = ip.protocol;
                    // read ip.context
                    ipContext = ip.context;
                    // read ip.port
                    ipPort = ip.port;
                }
                updateRegistration(0, ipIpaddress);
                updateRegistration(1, ipProtocol);
                updateRegistration(2, ipContext);
                updateRegistration(3, ipPort);


                if (ipIpaddress != null) {
                    // read ip.ipaddress.get()
                    ipIpaddressGet = ipIpaddress.get();
                }
                if (ipProtocol != null) {
                    // read ip.protocol.get()
                    ipProtocolGet = ipProtocol.get();
                }
                if (ipContext != null) {
                    // read ip.context.get()
                    ipContextGet = ipContext.get();
                }
                if (ipPort != null) {
                    // read ip.port.get()
                    ipPortGet = ipPort.get();
                }


                // read AndroidUtils.tolower(ip.ipaddress.get())
                androidUtilsTolowerIpIpaddress = com.telpo.usb.finger.utils.AndroidUtils.tolower(ipIpaddressGet);
                // read AndroidUtils.tolower(ip.protocol.get())
                androidUtilsTolowerIpProtocol = com.telpo.usb.finger.utils.AndroidUtils.tolower(ipProtocolGet);
                // read AndroidUtils.tolower(ip.context.get())
                androidUtilsTolowerIpContext = com.telpo.usb.finger.utils.AndroidUtils.tolower(ipContextGet);
                // read AndroidUtils.tolower(ip.port.get())
                androidUtilsTolowerIpPort = com.telpo.usb.finger.utils.AndroidUtils.tolower(ipPortGet);


                // read (AndroidUtils.tolower(ip.protocol.get())) + ("://")
                androidUtilsTolowerIpProtocolJavaLangString = (androidUtilsTolowerIpProtocol) + ("://");


                // read ((AndroidUtils.tolower(ip.protocol.get())) + ("://")) + (AndroidUtils.tolower(ip.ipaddress.get()))
                androidUtilsTolowerIpProtocolJavaLangStringAndroidUtilsTolowerIpIpaddress = (androidUtilsTolowerIpProtocolJavaLangString) + (androidUtilsTolowerIpIpaddress);


                // read (((AndroidUtils.tolower(ip.protocol.get())) + ("://")) + (AndroidUtils.tolower(ip.ipaddress.get()))) + (":")
                androidUtilsTolowerIpProtocolJavaLangStringAndroidUtilsTolowerIpIpaddressJavaLangString = (androidUtilsTolowerIpProtocolJavaLangStringAndroidUtilsTolowerIpIpaddress) + (":");


                // read ((((AndroidUtils.tolower(ip.protocol.get())) + ("://")) + (AndroidUtils.tolower(ip.ipaddress.get()))) + (":")) + (AndroidUtils.tolower(ip.port.get()))
                androidUtilsTolowerIpProtocolJavaLangStringAndroidUtilsTolowerIpIpaddressJavaLangStringAndroidUtilsTolowerIpPort = (androidUtilsTolowerIpProtocolJavaLangStringAndroidUtilsTolowerIpIpaddressJavaLangString) + (androidUtilsTolowerIpPort);


                // read (((((AndroidUtils.tolower(ip.protocol.get())) + ("://")) + (AndroidUtils.tolower(ip.ipaddress.get()))) + (":")) + (AndroidUtils.tolower(ip.port.get()))) + ("/")
                androidUtilsTolowerIpProtocolJavaLangStringAndroidUtilsTolowerIpIpaddressJavaLangStringAndroidUtilsTolowerIpPortJavaLangString = (androidUtilsTolowerIpProtocolJavaLangStringAndroidUtilsTolowerIpIpaddressJavaLangStringAndroidUtilsTolowerIpPort) + ("/");


                // read ((((((AndroidUtils.tolower(ip.protocol.get())) + ("://")) + (AndroidUtils.tolower(ip.ipaddress.get()))) + (":")) + (AndroidUtils.tolower(ip.port.get()))) + ("/")) + (AndroidUtils.tolower(ip.context.get()))
                androidUtilsTolowerIpProtocolJavaLangStringAndroidUtilsTolowerIpIpaddressJavaLangStringAndroidUtilsTolowerIpPortJavaLangStringAndroidUtilsTolowerIpContext = (androidUtilsTolowerIpProtocolJavaLangStringAndroidUtilsTolowerIpIpaddressJavaLangStringAndroidUtilsTolowerIpPortJavaLangString) + (androidUtilsTolowerIpContext);
        }
        // batch finished
        if ((dirtyFlags & 0x3fL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtcomplete, androidUtilsTolowerIpProtocolJavaLangStringAndroidUtilsTolowerIpIpaddressJavaLangStringAndroidUtilsTolowerIpPortJavaLangStringAndroidUtilsTolowerIpContext);
        }
        if ((dirtyFlags & 0x34L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtcontext, ipContextGet);
        }
        if ((dirtyFlags & 0x20L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.txtcontext, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, txtcontextandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.txtip, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, txtipandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.txtport, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, txtportandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.txtprotocol, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, txtprotocolandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x31L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtip, ipIpaddressGet);
        }
        if ((dirtyFlags & 0x38L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtport, ipPortGet);
        }
        if ((dirtyFlags & 0x32L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtprotocol, ipProtocolGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): ip.ipaddress
        flag 1 (0x2L): ip.protocol
        flag 2 (0x3L): ip.context
        flag 3 (0x4L): ip.port
        flag 4 (0x5L): ip
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}