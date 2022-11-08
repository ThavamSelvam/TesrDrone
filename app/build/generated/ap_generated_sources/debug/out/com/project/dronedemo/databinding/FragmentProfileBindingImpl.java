package com.project.dronedemo.databinding;
import com.project.dronedemo.R;
import com.project.dronedemo.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentProfileBindingImpl extends FragmentProfileBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.v, 1);
        sViewsWithIds.put(R.id.cdProfile, 2);
        sViewsWithIds.put(R.id.imgProfile, 3);
        sViewsWithIds.put(R.id.imgProfileEdit, 4);
        sViewsWithIds.put(R.id.guideline3, 5);
        sViewsWithIds.put(R.id.guideStart, 6);
        sViewsWithIds.put(R.id.guideEnd, 7);
        sViewsWithIds.put(R.id.constraintLayout2, 8);
        sViewsWithIds.put(R.id.imgProfileHint, 9);
        sViewsWithIds.put(R.id.outlinedTextField, 10);
        sViewsWithIds.put(R.id.edtName, 11);
        sViewsWithIds.put(R.id.constraintLayout, 12);
        sViewsWithIds.put(R.id.imgMobileHint, 13);
        sViewsWithIds.put(R.id.outlinedTextFieldMob, 14);
        sViewsWithIds.put(R.id.edtNumber, 15);
        sViewsWithIds.put(R.id.constraintLayout3, 16);
        sViewsWithIds.put(R.id.imgTypeHint, 17);
        sViewsWithIds.put(R.id.outlinedTextFieldType, 18);
        sViewsWithIds.put(R.id.edtType, 19);
        sViewsWithIds.put(R.id.constraintLayout4, 20);
        sViewsWithIds.put(R.id.imgLocationHint, 21);
        sViewsWithIds.put(R.id.outlinedTextFieldLoc, 22);
        sViewsWithIds.put(R.id.edtLocation, 23);
        sViewsWithIds.put(R.id.constraintLayout5, 24);
        sViewsWithIds.put(R.id.imgPinHint, 25);
        sViewsWithIds.put(R.id.outlinedTextFieldPin, 26);
        sViewsWithIds.put(R.id.edtPin, 27);
        sViewsWithIds.put(R.id.btnSubmit, 28);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentProfileBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 29, sIncludes, sViewsWithIds));
    }
    private FragmentProfileBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatButton) bindings[28]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[2]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[12]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[8]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[16]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[20]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[24]
            , (com.google.android.material.textfield.TextInputEditText) bindings[23]
            , (com.google.android.material.textfield.TextInputEditText) bindings[11]
            , (com.google.android.material.textfield.TextInputEditText) bindings[15]
            , (com.google.android.material.textfield.TextInputEditText) bindings[27]
            , (com.google.android.material.textfield.TextInputEditText) bindings[19]
            , (androidx.constraintlayout.widget.Guideline) bindings[7]
            , (androidx.constraintlayout.widget.Guideline) bindings[6]
            , (androidx.constraintlayout.widget.Guideline) bindings[5]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[21]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[13]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[25]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageView) bindings[4]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[9]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[17]
            , (com.google.android.material.textfield.TextInputLayout) bindings[10]
            , (com.google.android.material.textfield.TextInputLayout) bindings[22]
            , (com.google.android.material.textfield.TextInputLayout) bindings[14]
            , (com.google.android.material.textfield.TextInputLayout) bindings[26]
            , (com.google.android.material.textfield.TextInputLayout) bindings[18]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[1]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
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