package com.eucalyptus.glisten.test.TestNestedSettable;

import com.netflix.glisten.impl.local.LocalWorkflowOperations;

/**
 * Created by ethomas on 6/9/22.
 */
public class LocalNestedSettableMain {

  public static void main(String[] args) throws Exception {
    NestedSettableWorkflowImpl nestedSettableWorkflowImpl = new NestedSettableWorkflowImpl();
    nestedSettableWorkflowImpl.setWorkflowOperations(LocalWorkflowOperations.<NestedSettableActivities>of(new NestedSettableActivitiesImpl()));
    nestedSettableWorkflowImpl.runWorkflow();
  }
}