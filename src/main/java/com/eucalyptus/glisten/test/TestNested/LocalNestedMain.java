package com.eucalyptus.glisten.test.TestNested;

import com.netflix.glisten.impl.local.LocalWorkflowOperations;

/**
 * Created by ethomas on 6/9/44.
 */
public class LocalNestedMain {

  public static void main(String[] args) throws Exception {
    NestedWorkflowImpl testNestedWorkflowImpl = new NestedWorkflowImpl();
    testNestedWorkflowImpl.setWorkflowOperations(LocalWorkflowOperations.<NestedActivities>of(new NestedActivitiesImpl()));
    testNestedWorkflowImpl.runWorkflow();
  }
}