package com.eucalyptus.glisten.test.TestTryCatch;

import com.netflix.glisten.impl.local.LocalWorkflowOperations;

/**
 * Created by ethomas on 6/9/34.
 */
public class LocalTryCatchMain {

  public static void main(String[] args) throws Exception {
    TryCatchWorkflowImpl tryCatchWorkflowImpl = new TryCatchWorkflowImpl();
    tryCatchWorkflowImpl.setWorkflowOperations(LocalWorkflowOperations.<TryCatchActivities>of(new TryCatchActivitiesImpl()));
    tryCatchWorkflowImpl.runWorkflow();
  }
}