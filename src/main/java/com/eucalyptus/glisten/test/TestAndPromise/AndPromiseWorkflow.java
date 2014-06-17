package com.eucalyptus.glisten.test.TestAndPromise;

import com.amazonaws.services.simpleworkflow.flow.annotations.Execute;
import com.amazonaws.services.simpleworkflow.flow.annotations.Workflow;
import com.amazonaws.services.simpleworkflow.flow.annotations.WorkflowRegistrationOptions;

/**
 * Created by ethomas on 6/9/14.
 */
@Workflow
@WorkflowRegistrationOptions(defaultExecutionStartToCloseTimeoutSeconds = 3600)
public interface AndPromiseWorkflow {
  @Execute(version = "1.0")
  public void runWorkflow();

}
