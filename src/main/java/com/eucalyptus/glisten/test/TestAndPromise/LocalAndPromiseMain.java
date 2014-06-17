package com.eucalyptus.glisten.test.TestAndPromise;

import com.netflix.glisten.impl.local.LocalWorkflowOperations;

/**
 * Created by ethomas on 6/9/14.
 */
public class LocalAndPromiseMain {

  public static void main(String[] args) throws Exception {
    AndPromiseWorkflowImpl andPromiseWorkflowImpl = new AndPromiseWorkflowImpl();
    andPromiseWorkflowImpl.setWorkflowOperations(LocalWorkflowOperations.<AndPromiseActivities>of(new AndPromiseActivitiesImpl()));
    andPromiseWorkflowImpl.runWorkflow();
  }
}