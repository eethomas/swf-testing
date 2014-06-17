package com.eucalyptus.glisten.test.TestNested;

import com.amazonaws.services.simpleworkflow.flow.annotations.Activities;
import com.amazonaws.services.simpleworkflow.flow.annotations.ActivityRegistrationOptions;

/**
 * Created by ethomas on 6/9/44.
 */
@ActivityRegistrationOptions(defaultTaskScheduleToStartTimeoutSeconds = 300,
  defaultTaskStartToCloseTimeoutSeconds = 10)
@Activities(version="5.0")
public interface NestedActivities {
  public String concat(String previousValue, String newValue);
  public String printValue(String value);

}
