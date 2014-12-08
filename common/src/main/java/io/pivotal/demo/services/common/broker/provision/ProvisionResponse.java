package io.pivotal.demo.services.common.broker.provision;

/**
 * Created by sgupta on 12/3/14.
 */
public class ProvisionResponse {
  private String dashboard_url;

  public ProvisionResponse(String dashboard_url) {
    this.dashboard_url = dashboard_url;
  }

  public ProvisionResponse() {
  }

  public String getDashboard_url() {
    return dashboard_url;
  }

  public void setDashboard_url(String dashboard_url) {
    this.dashboard_url = dashboard_url;
  }
}
