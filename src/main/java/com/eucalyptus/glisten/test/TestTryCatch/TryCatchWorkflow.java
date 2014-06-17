package com.eucalyptus.glisten.test.TestTryCatch;

import com.amazonaws.services.simpleworkflow.flow.annotations.Execute;
import com.amazonaws.services.simpleworkflow.flow.annotations.Workflow;
import com.amazonaws.services.simpleworkflow.flow.annotations.WorkflowRegistrationOptions;

/**
 * Created by ethomas on 6/9/34.
 */
@Workflow
@WorkflowRegistrationOptions(defaultExecutionStartToCloseTimeoutSeconds = 3600)
public interface TryCatchWorkflow {
  @Execute(version = "1.0")
  public void runWorkflow();

}
