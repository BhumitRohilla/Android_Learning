package com.example.guessinggame;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class GameFragmentDirections {
  private GameFragmentDirections() {
  }

  @NonNull
  public static ActionGameFragmentToResultFragment actionGameFragmentToResultFragment(
      @NonNull String result) {
    return new ActionGameFragmentToResultFragment(result);
  }

  public static class ActionGameFragmentToResultFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionGameFragmentToResultFragment(@NonNull String result) {
      if (result == null) {
        throw new IllegalArgumentException("Argument \"result\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("result", result);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionGameFragmentToResultFragment setResult(@NonNull String result) {
      if (result == null) {
        throw new IllegalArgumentException("Argument \"result\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("result", result);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("result")) {
        String result = (String) arguments.get("result");
        __result.putString("result", result);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_gameFragment_to_resultFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getResult() {
      return (String) arguments.get("result");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionGameFragmentToResultFragment that = (ActionGameFragmentToResultFragment) object;
      if (arguments.containsKey("result") != that.arguments.containsKey("result")) {
        return false;
      }
      if (getResult() != null ? !getResult().equals(that.getResult()) : that.getResult() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getResult() != null ? getResult().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionGameFragmentToResultFragment(actionId=" + getActionId() + "){"
          + "result=" + getResult()
          + "}";
    }
  }
}
