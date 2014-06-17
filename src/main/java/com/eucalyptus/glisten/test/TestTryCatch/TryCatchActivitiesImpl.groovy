package com.eucalyptus.glisten.test.TestTryCatch

import com.netflix.glisten.ActivityOperations
import com.netflix.glisten.impl.swf.SwfActivityOperations

/**
 * Created by ethomas on 6/9/34.
 */
public class TryCatchActivitiesImpl implements TryCatchActivities {
  @Delegate
  ActivityOperations activityOperations = new SwfActivityOperations();
  @Override
  public int divide(int a, int b) {
    return a/b;
  }
  @Override
  public String printMessage(String message) {
    System.out.println(message);
    return "";
  }
}
