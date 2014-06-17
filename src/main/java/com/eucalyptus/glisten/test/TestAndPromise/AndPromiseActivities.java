package com.eucalyptus.glisten.test.TestAndPromise;

import com.amazonaws.services.simpleworkflow.flow.annotations.Activities;
import com.amazonaws.services.simpleworkflow.flow.annotations.ActivityRegistrationOptions;

/**
 * Created by ethomas on 6/9/14.
 */
@ActivityRegistrationOptions(defaultTaskScheduleToStartTimeoutSeconds = 300,
  defaultTaskStartToCloseTimeoutSeconds = 10)
@Activities(version="1.0")
public interface AndPromiseActivities {
  public String sleepAndPrintMessage(int seconds, String message);

}
