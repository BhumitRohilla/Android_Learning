// Generated by view binder compiler. Do not edit!
package com.example.guessinggame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.example.guessinggame.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final FragmentContainerView rootView;

  @NonNull
  public final FragmentContainerView FragmentContainerView;

  private ActivityMainBinding(@NonNull FragmentContainerView rootView,
      @NonNull FragmentContainerView FragmentContainerView) {
    this.rootView = rootView;
    this.FragmentContainerView = FragmentContainerView;
  }

  @Override
  @NonNull
  public FragmentContainerView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    FragmentContainerView FragmentContainerView = (FragmentContainerView) rootView;

    return new ActivityMainBinding((FragmentContainerView) rootView, FragmentContainerView);
  }
}