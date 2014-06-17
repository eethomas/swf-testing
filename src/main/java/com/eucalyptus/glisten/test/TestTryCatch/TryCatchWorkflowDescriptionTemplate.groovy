package com.eucalyptus.glisten.test.TestTryCatch

import com.netflix.glisten.WorkflowDescriptionTemplate

/**
 * Created by ethomas on 6/9/34.
 */
public class TryCatchWorkflowDescriptionTemplate extends WorkflowDescriptionTemplate implements TryCatchWorkflow {

  @Override
  void runWorkflow() {
    description="TryCatchWorkflow";
  }
}
