// Generated by data binding compiler. Do not edit!
package com.project.dronedemo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.project.dronedemo.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentProfileBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatButton btnSubmit;

  @NonNull
  public final ConstraintLayout cdProfile;

  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final ConstraintLayout constraintLayout2;

  @NonNull
  public final ConstraintLayout constraintLayout3;

  @NonNull
  public final ConstraintLayout constraintLayout4;

  @NonNull
  public final ConstraintLayout constraintLayout5;

  @NonNull
  public final TextInputEditText edtLocation;

  @NonNull
  public final TextInputEditText edtName;

  @NonNull
  public final TextInputEditText edtNumber;

  @NonNull
  public final TextInputEditText edtPin;

  @NonNull
  public final TextInputEditText edtType;

  @NonNull
  public final Guideline guideEnd;

  @NonNull
  public final Guideline guideStart;

  @NonNull
  public final Guideline guideline3;

  @NonNull
  public final AppCompatImageView imgLocationHint;

  @NonNull
  public final AppCompatImageView imgMobileHint;

  @NonNull
  public final AppCompatImageView imgPinHint;

  @NonNull
  public final ImageView imgProfile;

  @NonNull
  public final ImageView imgProfileEdit;

  @NonNull
  public final AppCompatImageView imgProfileHint;

  @NonNull
  public final AppCompatImageView imgTypeHint;

  @NonNull
  public final TextInputLayout outlinedTextField;

  @NonNull
  public final TextInputLayout outlinedTextFieldLoc;

  @NonNull
  public final TextInputLayout outlinedTextFieldMob;

  @NonNull
  public final TextInputLayout outlinedTextFieldPin;

  @NonNull
  public final TextInputLayout outlinedTextFieldType;

  @NonNull
  public final ConstraintLayout v;

  protected FragmentProfileBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppCompatButton btnSubmit, ConstraintLayout cdProfile, ConstraintLayout constraintLayout,
      ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3,
      ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5,
      TextInputEditText edtLocation, TextInputEditText edtName, TextInputEditText edtNumber,
      TextInputEditText edtPin, TextInputEditText edtType, Guideline guideEnd, Guideline guideStart,
      Guideline guideline3, AppCompatImageView imgLocationHint, AppCompatImageView imgMobileHint,
      AppCompatImageView imgPinHint, ImageView imgProfile, ImageView imgProfileEdit,
      AppCompatImageView imgProfileHint, AppCompatImageView imgTypeHint,
      TextInputLayout outlinedTextField, TextInputLayout outlinedTextFieldLoc,
      TextInputLayout outlinedTextFieldMob, TextInputLayout outlinedTextFieldPin,
      TextInputLayout outlinedTextFieldType, ConstraintLayout v) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnSubmit = btnSubmit;
    this.cdProfile = cdProfile;
    this.constraintLayout = constraintLayout;
    this.constraintLayout2 = constraintLayout2;
    this.constraintLayout3 = constraintLayout3;
    this.constraintLayout4 = constraintLayout4;
    this.constraintLayout5 = constraintLayout5;
    this.edtLocation = edtLocation;
    this.edtName = edtName;
    this.edtNumber = edtNumber;
    this.edtPin = edtPin;
    this.edtType = edtType;
    this.guideEnd = guideEnd;
    this.guideStart = guideStart;
    this.guideline3 = guideline3;
    this.imgLocationHint = imgLocationHint;
    this.imgMobileHint = imgMobileHint;
    this.imgPinHint = imgPinHint;
    this.imgProfile = imgProfile;
    this.imgProfileEdit = imgProfileEdit;
    this.imgProfileHint = imgProfileHint;
    this.imgTypeHint = imgTypeHint;
    this.outlinedTextField = outlinedTextField;
    this.outlinedTextFieldLoc = outlinedTextFieldLoc;
    this.outlinedTextFieldMob = outlinedTextFieldMob;
    this.outlinedTextFieldPin = outlinedTextFieldPin;
    this.outlinedTextFieldType = outlinedTextFieldType;
    this.v = v;
  }

  @NonNull
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_profile, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentProfileBinding>inflateInternal(inflater, R.layout.fragment_profile, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_profile, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentProfileBinding>inflateInternal(inflater, R.layout.fragment_profile, null, false, component);
  }

  public static FragmentProfileBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentProfileBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentProfileBinding)bind(component, view, R.layout.fragment_profile);
  }
}
