package com.eucalyptus.glisten.test.TestAndPromise

import com.netflix.glisten.InterfaceBasedWorkflowClient

/**
 * Created by ethomas on 6/9/14.
 */
class AndPromiseWorkflowClient implements AndPromiseWorkflow {
  AndPromiseWorkflow workflow

  AndPromiseWorkflowClient( InterfaceBasedWorkflowClient<AndPromiseWorkflow> client ) {
    workflow = client.asWorkflow( ) as AndPromiseWorkflow
  }

  @Override
  void runWorkflow() {
    workflow.runWorkflow();
  }
}
