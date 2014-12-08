package io.pivotal.demo.services.common.broker.service;

import java.util.Map;

/**
 * Created by sgupta on 12/8/14.
 */
public class Binding {
  private String binding_id;
  private String plan_id;
  private String service_id;
  private String app_guid;

  //not used in equals and hashcode
  private Map<String,String> credentials;

  public Binding(String binding_id, String plan_id, String service_id, String app_guid) {
    this.binding_id = binding_id;
    this.plan_id = plan_id;
    this.service_id = service_id;
    this.app_guid = app_guid;
  }

  public Binding() {
  }

  public String getBinding_id() {
    return binding_id;
  }

  public void setBinding_id(String binding_id) {
    this.binding_id = binding_id;
  }

  public String getPlan_id() {
    return plan_id;
  }

  public void setPlan_id(String plan_id) {
    this.plan_id = plan_id;
  }

  public String getService_id() {
    return service_id;
  }

  public void setService_id(String service_id) {
    this.service_id = service_id;
  }

  public String getApp_guid() {
    return app_guid;
  }

  public void setApp_guid(String app_guid) {
    this.app_guid = app_guid;
  }

  public Map<String, String> getCredentials() {
    return credentials;
  }

  public void setCredentials(Map<String, String> credentials) {
    this.credentials = credentials;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Binding binding = (Binding) o;

    if (!app_guid.equals(binding.app_guid)) {
      return false;
    }
    if (!binding_id.equals(binding.binding_id)) {
      return false;
    }
    if (!plan_id.equals(binding.plan_id)) {
      return false;
    }
    if (!service_id.equals(binding.service_id)) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = binding_id.hashCode();
    result = 31 * result + plan_id.hashCode();
    result = 31 * result + service_id.hashCode();
    result = 31 * result + app_guid.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "Binding{" +
        "binding_id='" + binding_id + '\'' +
        ", plan_id='" + plan_id + '\'' +
        ", service_id='" + service_id + '\'' +
        ", app_guid='" + app_guid + '\'' +
        ", credentials=" + credentials +
        '}';
  }
}
