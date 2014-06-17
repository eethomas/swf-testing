package com.eucalyptus.glisten.test.TestAndPromise

import com.netflix.glisten.ActivityOperations
import com.netflix.glisten.impl.swf.SwfActivityOperations

/**
 * Created by ethomas on 6/9/14.
 */
public class AndPromiseActivitiesImpl implements AndPromiseActivities {
  @Delegate
  ActivityOperations activityOperations = new SwfActivityOperations();

  @Override
  public String sleepAndPrintMessage(int seconds, String message) {
    Thread.sleep(1000L * seconds);
    System.out.println(message);
    return "";
  }
}
