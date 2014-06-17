package com.eucalyptus.glisten.test.TestTryCatch

import com.netflix.glisten.WorkflowOperations
import com.netflix.glisten.impl.swf.SwfWorkflowOperations

/**
 * Created by ethomas on 6/9/34.
 */
public class TryCatchWorkflowImpl implements TryCatchWorkflow {
  @Delegate
  WorkflowOperations<TryCatchActivities> workflowOperations = SwfWorkflowOperations.of(TryCatchActivities);

  @Override
  public void runWorkflow() {
    waitFor(
      doTry {
        waitFor(promiseFor(activities.divide(1,1))) { int result ->
          promiseFor(activities.printMessage("Result:" + result));
        }
      }.withCatch { Throwable t ->
        promiseFor(activities.printMessage("Error:" + t.getMessage()));
      }.getResult()) {
      waitFor(
        doTry {
          waitFor(promiseFor(activities.divide(1,0))) { int result ->
            promiseFor(activities.printMessage("Result:" + result));
          }
        }.withCatch { Throwable t ->
          promiseFor(activities.printMessage("Error:" + t.getMessage()));
        }.getResult()) {
        promiseFor(activities.printMessage("Done"));
      }
    }
  }
}

