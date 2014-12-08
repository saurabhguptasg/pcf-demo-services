package io.pivotal.demo.services.common.broker.service;

import java.io.Serializable;

/**
 * Created by sgupta on 12/8/14.
 */
public class ServiceInstance implements Serializable {

  private static final long serialVersionUID = 8863865458221248274L;

  private String instance_id;
  private String service_id;
  private String plan_id;
  private String organization_guid;
  private String space_guid;

  public ServiceInstance(String instance_id, String service_id, String plan_id, String organization_guid, String space_guid) {
    this.instance_id = instance_id;
    this.service_id = service_id;
    this.plan_id = plan_id;
    this.organization_guid = organization_guid;
    this.space_guid = space_guid;
  }

  public ServiceInstance() {
  }

  public String getInstance_id() {
    return instance_id;
  }

  public void setInstance_id(String instance_id) {
    this.instance_id = instance_id;
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

  public String getOrganization_guid() {
    return organization_guid;
  }

  public void setOrganization_guid(String organization_guid) {
    this.organization_guid = organization_guid;
  }

  public String getSpace_guid() {
    return space_guid;
  }

  public void setSpace_guid(String space_guid) {
    this.space_guid = space_guid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ServiceInstance that = (ServiceInstance) o;

    if (!instance_id.equals(that.instance_id)) {
      return false;
    }
    if (!organization_guid.equals(that.organization_guid)) {
      return false;
    }
    if (!plan_id.equals(that.plan_id)) {
      return false;
    }
    if (!service_id.equals(that.service_id)) {
      return false;
    }
    if (!space_guid.equals(that.space_guid)) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = instance_id.hashCode();
    result = 31 * result + service_id.hashCode();
    result = 31 * result + plan_id.hashCode();
    result = 31 * result + organization_guid.hashCode();
    result = 31 * result + space_guid.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "ServiceInstance{" +
        "instance_id='" + instance_id + '\'' +
        ", service_id='" + service_id + '\'' +
        ", plan_id='" + plan_id + '\'' +
        ", organization_guid='" + organization_guid + '\'' +
        ", space_guid='" + space_guid + '\'' +
        '}';
  }
}
