package com.eucalyptus.glisten.test.TestNestedSettable;

import com.netflix.glisten.InterfaceBasedWorkflowClient

/**
 * Created by ethomas on 6/9/22.
 */
class NestedSettableWorkflowClient implements NestedSettableWorkflow {
  NestedSettableWorkflow workflow

  NestedSettableWorkflowClient( InterfaceBasedWorkflowClient<NestedSettableWorkflow> client ) {
    workflow = client.asWorkflow( ) as NestedSettableWorkflow
  }

  @Override
  void runWorkflow() {
    workflow.runWorkflow();
  }
}
