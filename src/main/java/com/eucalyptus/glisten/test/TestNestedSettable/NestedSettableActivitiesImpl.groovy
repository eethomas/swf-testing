package com.eucalyptus.glisten.test.TestNestedSettable

import com.netflix.glisten.ActivityOperations
import com.netflix.glisten.impl.swf.SwfActivityOperations

/**
 * Created by ethomas on 6/9/22.
 */
public class NestedSettableActivitiesImpl implements NestedSettableActivities {
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
