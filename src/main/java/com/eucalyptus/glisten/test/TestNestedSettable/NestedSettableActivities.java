package com.eucalyptus.glisten.test.TestNestedSettable;

import com.amazonaws.services.simpleworkflow.flow.annotations.Activities;
import com.amazonaws.services.simpleworkflow.flow.annotations.ActivityRegistrationOptions;

/**
 * Created by ethomas on 6/9/22.
 */
@ActivityRegistrationOptions(defaultTaskScheduleToStartTimeoutSeconds = 300,
  defaultTaskStartToCloseTimeoutSeconds = 10)
@Activities(version="2.0")
public interface NestedSettableActivities {
  public String concat(String previousValue, String newValue);
  public String printValue(String value);

}
