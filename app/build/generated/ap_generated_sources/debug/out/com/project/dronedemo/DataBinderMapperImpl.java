package com.project.dronedemo;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.project.dronedemo.databinding.ActivityBookingBindingImpl;
import com.project.dronedemo.databinding.ActivityOtpVerificationBindingImpl;
import com.project.dronedemo.databinding.ActivityPhoneNumberBindingImpl;
import com.project.dronedemo.databinding.FragmentProfileBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYBOOKING = 1;

  private static final int LAYOUT_ACTIVITYOTPVERIFICATION = 2;

  private static final int LAYOUT_ACTIVITYPHONENUMBER = 3;

  private static final int LAYOUT_FRAGMENTPROFILE = 4;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(4);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.project.dronedemo.R.layout.activity_booking, LAYOUT_ACTIVITYBOOKING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.project.dronedemo.R.layout.activity_otp_verification, LAYOUT_ACTIVITYOTPVERIFICATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.project.dronedemo.R.layout.activity_phone_number, LAYOUT_ACTIVITYPHONENUMBER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.project.dronedemo.R.layout.fragment_profile, LAYOUT_FRAGMENTPROFILE);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYBOOKING: {
          if ("layout/activity_booking_0".equals(tag)) {
            return new ActivityBookingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_booking is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYOTPVERIFICATION: {
          if ("layout/activity_otp_verification_0".equals(tag)) {
            return new ActivityOtpVerificationBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_otp_verification is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPHONENUMBER: {
          if ("layout/activity_phone_number_0".equals(tag)) {
            return new ActivityPhoneNumberBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_phone_number is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPROFILE: {
          if ("layout/fragment_profile_0".equals(tag)) {
            return new FragmentProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_profile is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(2);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "viewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout/activity_booking_0", com.project.dronedemo.R.layout.activity_booking);
      sKeys.put("layout/activity_otp_verification_0", com.project.dronedemo.R.layout.activity_otp_verification);
      sKeys.put("layout/activity_phone_number_0", com.project.dronedemo.R.layout.activity_phone_number);
      sKeys.put("layout/fragment_profile_0", com.project.dronedemo.R.layout.fragment_profile);
    }
  }
}
