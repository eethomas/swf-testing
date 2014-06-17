package com.eucalyptus.glisten.test.TestAndPromise;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.flow.ActivityWorker;
import com.amazonaws.services.simpleworkflow.flow.WorkflowWorker;
import com.eucalyptus.glisten.test.Utils;
import com.netflix.glisten.InterfaceBasedWorkflowClient;
import com.netflix.glisten.WorkflowClientFactory;
import com.netflix.glisten.WorkflowDescriptionTemplate;
import com.netflix.glisten.WorkflowTags;

/**
 * Created by ethomas on 6/9/14.
 */
public class SWFAndPromiseMain {
  private static final String SWF_TASKLIST = "TaskSet1";

  private static boolean logWireCalls = false;

  static { //

    Utils.logWireCalls(logWireCalls);
    try {
      AmazonSimpleWorkflow simpleWorkflow = Utils.getAmazonSimpleWorkflow();

      WorkflowWorker workflowWorker = new WorkflowWorker(simpleWorkflow, Utils.SWF_DOMAIN, SWF_TASKLIST);
      workflowWorker.addWorkflowImplementationType(AndPromiseWorkflowImpl.class);
      workflowWorker.setRegisterDomain(true);
      workflowWorker.setDomainRetentionPeriodInDays(1);
      workflowWorker.start();

      ActivityWorker activityWorker = new ActivityWorker(simpleWorkflow, Utils.SWF_DOMAIN, SWF_TASKLIST);
      activityWorker.addActivitiesImplementation( new AndPromiseActivitiesImpl() );
      activityWorker.start();
    } catch ( Exception e ) {
      e.printStackTrace();
    }
  }


  public static void main(String[] args) throws Exception {
    AmazonSimpleWorkflow simpleWorkflow = Utils.getAmazonSimpleWorkflow();

    WorkflowClientFactory workflowClientFactory = new WorkflowClientFactory(simpleWorkflow, Utils.SWF_DOMAIN, SWF_TASKLIST);

    // Now you have a factory for making a workflow client. Yeah, very Java like. I'm sorry.

    WorkflowDescriptionTemplate workflowDescriptionTemplate = new AndPromiseWorkflowDescriptionTemplate();

    // Now you can get your client
    InterfaceBasedWorkflowClient<AndPromiseWorkflow> client = workflowClientFactory
      .getNewWorkflowClient(AndPromiseWorkflow.class, workflowDescriptionTemplate, new WorkflowTags());


    new AndPromiseWorkflowClient(client).runWorkflow();
  }
}