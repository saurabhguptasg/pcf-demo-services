package io.pivotal.demo.services.common.broker.service;

/**
 * Created by sgupta on 12/8/14.
 */
public class UpdateRequest {
  private String plan_id;

  public UpdateRequest(String plan_id) {
    this.plan_id = plan_id;
  }

  public UpdateRequest() {
  }

  public String getPlan_id() {
    return plan_id;
  }

  public void setPlan_id(String plan_id) {
    this.plan_id = plan_id;
  }
}
