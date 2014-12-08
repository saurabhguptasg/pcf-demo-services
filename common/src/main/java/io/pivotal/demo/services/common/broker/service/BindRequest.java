package io.pivotal.demo.services.common.broker.service;

/**
 * Created by sgupta on 12/8/14.
 */
public class BindRequest {
  private String service_id;
  private String plan_id;
  private String app_guid;

  public BindRequest(String service_id, String plan_id, String app_guid) {
    this.service_id = service_id;
    this.plan_id = plan_id;
    this.app_guid = app_guid;
  }

  public BindRequest() {
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

  public String getApp_guid() {
    return app_guid;
  }

  public void setApp_guid(String app_guid) {
    this.app_guid = app_guid;
  }

  @Override
  public String toString() {
    return "BindRequest{" +
        "service_id='" + service_id + '\'' +
        ", plan_id='" + plan_id + '\'' +
        ", app_guid='" + app_guid + '\'' +
        '}';
  }
}
