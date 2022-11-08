// Generated by data binding compiler. Do not edit!
package com.project.dronedemo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.project.dronedemo.R;
import com.project.dronedemo.view.enternumber.PhoneNumberViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityPhoneNumberBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatImageView ImgBackBtn;

  @NonNull
  public final AppCompatTextView appCompatTextView;

  @NonNull
  public final ConstraintLayout cdlNext;

  @NonNull
  public final ConstraintLayout cdlPhoneNumber;

  @NonNull
  public final EditText edtNumberPhome;

  @NonNull
  public final Guideline guideLineNumber;

  @NonNull
  public final Guideline guidelineLeft;

  @NonNull
  public final Guideline guidelineRight;

  @NonNull
  public final AppCompatImageView imgNext;

  @NonNull
  public final TextView txtCountryCode;

  @NonNull
  public final AppCompatTextView txtNote;

  @Bindable
  protected PhoneNumberViewModel mViewModel;

  protected ActivityPhoneNumberBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppCompatImageView ImgBackBtn, AppCompatTextView appCompatTextView, ConstraintLayout cdlNext,
      ConstraintLayout cdlPhoneNumber, EditText edtNumberPhome, Guideline guideLineNumber,
      Guideline guidelineLeft, Guideline guidelineRight, AppCompatImageView imgNext,
      TextView txtCountryCode, AppCompatTextView txtNote) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ImgBackBtn = ImgBackBtn;
    this.appCompatTextView = appCompatTextView;
    this.cdlNext = cdlNext;
    this.cdlPhoneNumber = cdlPhoneNumber;
    this.edtNumberPhome = edtNumberPhome;
    this.guideLineNumber = guideLineNumber;
    this.guidelineLeft = guidelineLeft;
    this.guidelineRight = guidelineRight;
    this.imgNext = imgNext;
    this.txtCountryCode = txtCountryCode;
    this.txtNote = txtNote;
  }

  public abstract void setViewModel(@Nullable PhoneNumberViewModel viewModel);

  @Nullable
  public PhoneNumberViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static ActivityPhoneNumberBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_phone_number, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityPhoneNumberBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityPhoneNumberBinding>inflateInternal(inflater, R.layout.activity_phone_number, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityPhoneNumberBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_phone_number, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityPhoneNumberBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityPhoneNumberBinding>inflateInternal(inflater, R.layout.activity_phone_number, null, false, component);
  }

  public static ActivityPhoneNumberBinding bind(@NonNull View view) {
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
  public static ActivityPhoneNumberBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityPhoneNumberBinding)bind(component, view, R.layout.activity_phone_number);
  }
}