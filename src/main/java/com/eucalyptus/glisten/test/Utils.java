package com.eucalyptus.glisten.test;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ethomas on 6/12/14.
 */
public class Utils {

  public static AmazonSimpleWorkflow getAmazonSimpleWorkflow( ) {
    ClientConfiguration config = new ClientConfiguration().withSocketTimeout(70*1000);
//    String swfAccessId = "MY_ACCESS_KEY";
//    String swfSecretKey = "MY_SECRET_KEY";
//
//    AWSCredentials awsCredentials = new BasicAWSCredentials(swfAccessId, swfSecretKey);
    AWSCredentials awsCredentials = new EnvironmentVariableCredentialsProvider().getCredentials();

    AmazonSimpleWorkflow client = new AmazonSimpleWorkflowClient(awsCredentials, config);
    client.setRegion( Region.getRegion(Regions.US_EAST_1) );
    return client;
  }

  public static void logWireCalls(boolean doIt) {
    if (doIt) {
      Logger.getLogger("org.apache.http.wire").setLevel(Level.ALL);
      Logger.getLogger("").getHandlers()[0].setLevel(Level.ALL);
    }
  }

  public static final String SWF_DOMAIN = "GlistenTesting10";

}
