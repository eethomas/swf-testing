package com.eucalyptus.glisten.test.TestNested

import com.amazonaws.services.simpleworkflow.flow.core.Promise
import com.netflix.glisten.WorkflowOperations
import com.netflix.glisten.impl.swf.SwfWorkflowOperations

/**
 * Created by ethomas on 6/9/44.
 */
public class NestedWorkflowImpl implements NestedWorkflow {
  @Delegate
  WorkflowOperations<NestedActivities> workflowOperations = SwfWorkflowOperations.of(NestedActivities);

  @Override
  public void runWorkflow() {
    Promise<String> previousPromise = promiseFor("");
    for (char c='A'; c<='Z';c++) {
      char d = c;
      previousPromise = waitFor(previousPromise) { String result ->
        promiseFor(activities.concat(result, String.valueOf(d)));
      }
    }
    waitFor(previousPromise) {String result ->
      promiseFor(activities.printValue(result));
    }
  }
}