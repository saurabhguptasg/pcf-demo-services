package io.pivotal.demo.services.common.broker.service;

/**
 * Created by sgupta on 12/8/14.
 */
public class UnbindRequest {

  private String service_id;
  private String plan_id;

  public UnbindRequest(String service_id, String plan_id) {
    this.service_id = service_id;
    this.plan_id = plan_id;
  }

  public UnbindRequest() {
  }

  public String getService_id() {
    return service_id;
  }

  public void setService_id(String service_id) {
    this.service_id = service_id;
  }

  public String getPlan_id() {
    return plan_id;
  }

  public void setPlan_id(String plan_id) {
    this.plan_id = plan_id;
  }

  @Override
  public String toString() {
    return "UnbindRequest{" +
        "service_id='" + service_id + '\'' +
        ", plan_id='" + plan_id + '\'' +
        '}';
  }
}
