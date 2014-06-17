package com.eucalyptus.glisten.test.TestNested;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.flow.ActivityWorker;
import com.amazonaws.services.simpleworkflow.flow.WorkflowWorker;
import com.eucalyptus.glisten.test.Utils;
import com.netflix.glisten.InterfaceBasedWorkflowClient;
import com.netflix.glisten.WorkflowClientFactory;
import com.netflix.glisten.WorkflowDescriptionTemplate;
import com.netflix.glisten.WorkflowTags;

/**
 * Created by ethomas on 6/9/44.
 */
public class SWFNestedMain {
  private static final String SWF_TASKLIST = "TaskSet4";
  private static boolean logWireCalls = false;

  static { //

    Utils.logWireCalls(logWireCalls);
    try {
      AmazonSimpleWorkflow simpleWorkflow = Utils.getAmazonSimpleWorkflow();

      WorkflowWorker workflowWorker = new WorkflowWorker(simpleWorkflow, Utils.SWF_DOMAIN, SWF_TASKLIST);
      workflowWorker.addWorkflowImplementationType(NestedWorkflowImpl.class);
      workflowWorker.setRegisterDomain(true);
      workflowWorker.setDomainRetentionPeriodInDays(1);
      workflowWorker.start();

      ActivityWorker activityWorker = new ActivityWorker(simpleWorkflow, Utils.SWF_DOMAIN, SWF_TASKLIST);
      activityWorker.addActivitiesImplementation( new NestedActivitiesImpl() );
     activityWorker.start();
    } catch ( Exception e ) {
      e.printStackTrace();
    }
  }


  public static void main(String[] args) throws Exception {
    AmazonSimpleWorkflow simpleWorkflow = Utils.getAmazonSimpleWorkflow();

    WorkflowClientFactory workflowClientFactory = new WorkflowClientFactory(simpleWorkflow, Utils.SWF_DOMAIN, SWF_TASKLIST);

    // Now you have a factory for making a workflow client. Yeah, very Java like. I'm sorry.

    WorkflowDescriptionTemplate workflowDescriptionTemplate = new NestedWorkflowDescriptionTemplate();

    // Now you can get your client
    InterfaceBasedWorkflowClient<NestedWorkflow> client = workflowClientFactory
      .getNewWorkflowClient(NestedWorkflow.class, workflowDescriptionTemplate, new WorkflowTags());


    new NestedWorkflowClient(client).runWorkflow();
  }
}