package com.eucalyptus.glisten.test.TestNested;

import com.netflix.glisten.InterfaceBasedWorkflowClient

/**
 * Created by ethomas on 6/9/44.
 */
class NestedWorkflowClient implements NestedWorkflow {
  NestedWorkflow workflow

  NestedWorkflowClient( InterfaceBasedWorkflowClient<NestedWorkflow> client ) {
    workflow = client.asWorkflow( ) as NestedWorkflow
  }

  @Override
  void runWorkflow() {
    workflow.runWorkflow();
  }
}
