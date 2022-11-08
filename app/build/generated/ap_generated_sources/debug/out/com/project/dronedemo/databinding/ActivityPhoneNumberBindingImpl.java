package com.project.dronedemo.databinding;
import com.project.dronedemo.R;
import com.project.dronedemo.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityPhoneNumberBindingImpl extends ActivityPhoneNumberBinding implements com.project.dronedemo.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.guidelineLeft, 3);
        sViewsWithIds.put(R.id.guidelineRight, 4);
        sViewsWithIds.put(R.id.ImgBackBtn, 5);
        sViewsWithIds.put(R.id.appCompatTextView, 6);
        sViewsWithIds.put(R.id.txtNote, 7);
        sViewsWithIds.put(R.id.cdlPhoneNumber, 8);
        sViewsWithIds.put(R.id.txtCountryCode, 9);
        sViewsWithIds.put(R.id.imgNext, 10);
        sViewsWithIds.put(R.id.guideLineNumber, 11);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener edtNumberPhomeandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.phoneNumber.get()
            //         is viewModel.phoneNumber.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(edtNumberPhome);
            // localize variables for thread safety
            // viewModel.phoneNumber
            androidx.databinding.ObservableField<java.lang.String> viewModelPhoneNumber = null;
            // viewModel.phoneNumber != null
            boolean viewModelPhoneNumberJavaLangObjectNull = false;
            // viewModel.phoneNumber.get()
            java.lang.String viewModelPhoneNumberGet = null;
            // viewModel
            com.project.dronedemo.view.enternumber.PhoneNumberViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelPhoneNumber = viewModel.getPhoneNumber();

                viewModelPhoneNumberJavaLangObjectNull = (viewModelPhoneNumber) != (null);
                if (viewModelPhoneNumberJavaLangObjectNull) {




                    viewModelPhoneNumber.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityPhoneNumberBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private ActivityPhoneNumberBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.appcompat.widget.AppCompatImageView) bindings[5]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[6]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[2]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[8]
            , (android.widget.EditText) bindings[1]
            , (androidx.constraintlayout.widget.Guideline) bindings[11]
            , (androidx.constraintlayout.widget.Guideline) bindings[3]
            , (androidx.constraintlayout.widget.Guideline) bindings[4]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[10]
            , (android.widget.TextView) bindings[9]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[7]
            );
        this.cdlNext.setTag(null);
        this.edtNumberPhome.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.project.dronedemo.generated.callback.OnClickListener(this, 1);
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
        if (BR.viewModel == variableId) {
            setViewModel((com.project.dronedemo.view.enternumber.PhoneNumberViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.project.dronedemo.view.enternumber.PhoneNumberViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelPhoneNumber((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelPhoneNumber(androidx.databinding.ObservableField<java.lang.String> ViewModelPhoneNumber, int fieldId) {
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
        androidx.databinding.ObservableField<java.lang.String> viewModelPhoneNumber = null;
        java.lang.String viewModelPhoneNumberGet = null;
        com.project.dronedemo.view.enternumber.PhoneNumberViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x7L) != 0) {



                if (viewModel != null) {
                    // read viewModel.phoneNumber
                    viewModelPhoneNumber = viewModel.getPhoneNumber();
                }
                updateRegistration(0, viewModelPhoneNumber);


                if (viewModelPhoneNumber != null) {
                    // read viewModel.phoneNumber.get()
                    viewModelPhoneNumberGet = viewModelPhoneNumber.get();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.cdlNext.setOnClickListener(mCallback1);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.edtNumberPhome, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, edtNumberPhomeandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.edtNumberPhome, viewModelPhoneNumberGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // viewModel
        com.project.dronedemo.view.enternumber.PhoneNumberViewModel viewModel = mViewModel;
        // viewModel != null
        boolean viewModelJavaLangObjectNull = false;



        viewModelJavaLangObjectNull = (viewModel) != (null);
        if (viewModelJavaLangObjectNull) {


            viewModel.onNextClick();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.phoneNumber
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}