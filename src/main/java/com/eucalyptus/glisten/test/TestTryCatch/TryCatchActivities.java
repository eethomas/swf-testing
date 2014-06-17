package com.eucalyptus.glisten.test.TestTryCatch;

import com.amazonaws.services.simpleworkflow.flow.annotations.Activities;
import com.amazonaws.services.simpleworkflow.flow.annotations.ActivityRegistrationOptions;

/**
 * Created by ethomas on 6/9/34.
 */
@ActivityRegistrationOptions(defaultTaskScheduleToStartTimeoutSeconds = 300,
  defaultTaskStartToCloseTimeoutSeconds = 30)
@Activities(version="1.0")
public interface TryCatchActivities {
  public int divide(int a, int b);
  public String printMessage(String message);

}
