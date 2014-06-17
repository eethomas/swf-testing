package com.eucalyptus.glisten.test.TestNested

import com.netflix.glisten.ActivityOperations
import com.netflix.glisten.impl.swf.SwfActivityOperations

/**
 * Created by ethomas on 6/9/44.
 */
public class NestedActivitiesImpl implements NestedActivities {
  @Delegate
  ActivityOperations activityOperations = new SwfActivityOperations();
  @Override
  public String concat(String previousValue, String newValue) {
    return previousValue + newValue;
  }
  @Override
  public String printValue(String value) {
    System.out.println(value);
  }

}
