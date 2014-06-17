package com.eucalyptus.glisten.test.TestAndPromise

import com.netflix.glisten.WorkflowDescriptionTemplate

/**
 * Created by ethomas on 6/9/14.
 */
public class AndPromiseWorkflowDescriptionTemplate extends WorkflowDescriptionTemplate implements AndPromiseWorkflow {

  @Override
  void runWorkflow() {
    description="AndPromiseWorkflow";
  }
}
