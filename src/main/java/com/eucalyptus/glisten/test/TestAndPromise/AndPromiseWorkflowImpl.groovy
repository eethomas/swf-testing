package com.eucalyptus.glisten.test.TestAndPromise

import com.amazonaws.services.simpleworkflow.flow.core.AndPromise
import com.amazonaws.services.simpleworkflow.flow.core.Promise
import com.netflix.glisten.WorkflowOperations
import com.netflix.glisten.impl.swf.SwfWorkflowOperations

/**
 * Created by ethomas on 6/9/14.
 */
public class AndPromiseWorkflowImpl implements AndPromiseWorkflow {
  @Delegate
  WorkflowOperations<AndPromiseActivities> workflowOperations = SwfWorkflowOperations.of(AndPromiseActivities);

  @Override
  public void runWorkflow() {
    Promise<String> promiseA = promiseFor(activities.sleepAndPrintMessage(3, "This is promise A"));
    Promise<String> promiseB = promiseFor(activities.sleepAndPrintMessage(2, "This is promise B"));
    Promise<String> promiseC = promiseFor(activities.sleepAndPrintMessage(6, "This is promise C"));
    AndPromise promiseAAndB = new AndPromise(promiseA, promiseB);
    waitFor(promiseC) {
      promiseFor(activities.sleepAndPrintMessage(1,"This is promise D"));
    }
    waitFor(promiseAAndB) {
      promiseFor(activities.sleepAndPrintMessage(1,"This is AndPromise for A and B"));
    }
  }
}
