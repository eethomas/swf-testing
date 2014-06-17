package com.eucalyptus.glisten.test.TestNested;

import com.netflix.glisten.WorkflowDescriptionTemplate

/**
 * Created by ethomas on 6/9/44.
 */
public class NestedWorkflowDescriptionTemplate extends WorkflowDescriptionTemplate implements NestedWorkflow {

  @Override
  void runWorkflow() {
    description="NestedWorkflow";
  }
}
