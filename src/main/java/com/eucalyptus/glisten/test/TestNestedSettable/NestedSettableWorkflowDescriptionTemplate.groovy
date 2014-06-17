package com.eucalyptus.glisten.test.TestNestedSettable;

import com.netflix.glisten.WorkflowDescriptionTemplate

/**
 * Created by ethomas on 6/9/22.
 */
public class NestedSettableWorkflowDescriptionTemplate extends WorkflowDescriptionTemplate implements NestedSettableWorkflow {

  @Override
  void runWorkflow() {
    description="NestedSettableWorkflow";
  }
}
