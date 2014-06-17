package com.eucalyptus.glisten.test.TestNestedSettable

import com.amazonaws.services.simpleworkflow.flow.core.Settable
import com.google.common.collect.Maps
import com.netflix.glisten.WorkflowOperations
import com.netflix.glisten.impl.swf.SwfWorkflowOperations

/**
 * Created by ethomas on 6/9/22.
 */
public class NestedSettableWorkflowImpl implements NestedSettableWorkflow {
  @Delegate
  WorkflowOperations<NestedSettableActivities> workflowOperations = SwfWorkflowOperations.of(NestedSettableActivities);

  @Override
  public void runWorkflow() {
    Map<Character, Settable<String>> promisePlaceholders = Maps.newHashMap();
    for (char c='A'; c<='Z';c++) {
      promisePlaceholders.put(c, new Settable<String>());
    }
    // put a waitFor() on each condition now...
    for (char c='A'; c<'Z';c++) {
      char d = c+1;
      waitFor(promisePlaceholders.get(c)) { String result ->
        promisePlaceholders.get(d).chain(promiseFor(activities.concat(result, String.valueOf(d))));
      }
    }
    char Z = 'Z';
    waitFor(promisePlaceholders.get(Z)) { String result ->
      promiseFor(activities.printValue(result));
    }
    char A = 'A';
    promisePlaceholders.get(A).chain(promiseFor(activities.concat("","A")));
  }
}