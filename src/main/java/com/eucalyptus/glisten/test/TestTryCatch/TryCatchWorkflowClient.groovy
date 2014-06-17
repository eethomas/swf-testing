package com.eucalyptus.glisten.test.TestTryCatch

import com.netflix.glisten.InterfaceBasedWorkflowClient

/**
 * Created by ethomas on 6/9/34.
 */
class TryCatchWorkflowClient implements TryCatchWorkflow {
  TryCatchWorkflow workflow

  TryCatchWorkflowClient( InterfaceBasedWorkflowClient<TryCatchWorkflow> client ) {
    workflow = client.asWorkflow( ) as TryCatchWorkflow
  }

  @Override
  void runWorkflow() {
    workflow.runWorkflow();
  }
}
