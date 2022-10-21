package com.example.guessinggame;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ResultFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private ResultFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private ResultFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ResultFragmentArgs fromBundle(@NonNull Bundle bundle) {
    ResultFragmentArgs __result = new ResultFragmentArgs();
    bundle.setClassLoader(ResultFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("result")) {
      String result;
      result = bundle.getString("result");
      if (result == null) {
        throw new IllegalArgumentException("Argument \"result\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("result", result);
    } else {
      throw new IllegalArgumentException("Required argument \"result\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ResultFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    ResultFragmentArgs __result = new ResultFragmentArgs();
    if (savedStateHandle.contains("result")) {
      String result;
      result = savedStateHandle.get("result");
      if (result == null) {
        throw new IllegalArgumentException("Argument \"result\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("result", result);
    } else {
      throw new IllegalArgumentException("Required argument \"result\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getResult() {
    return (String) arguments.get("result");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("result")) {
      String result = (String) arguments.get("result");
      __result.putString("result", result);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("result")) {
      String result = (String) arguments.get("result");
      __result.set("result", result);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    ResultFragmentArgs that = (ResultFragmentArgs) object;
    if (arguments.containsKey("result") != that.arguments.containsKey("result")) {
      return false;
    }
    if (getResult() != null ? !getResult().equals(that.getResult()) : that.getResult() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getResult() != null ? getResult().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ResultFragmentArgs{"
        + "result=" + getResult()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull ResultFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull String result) {
      if (result == null) {
        throw new IllegalArgumentException("Argument \"result\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("result", result);
    }

    @NonNull
    public ResultFragmentArgs build() {
      ResultFragmentArgs result = new ResultFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setResult(@NonNull String result) {
      if (result == null) {
        throw new IllegalArgumentException("Argument \"result\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("result", result);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public String getResult() {
      return (String) arguments.get("result");
    }
  }
}
