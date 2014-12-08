package io.pivotal.demo.services.common.broker.catalog;

/**
 * Created by sgupta on 12/3/14.
 */
public class CatalogServiceDashboardClient {
  private String id;
  private String secret;
  private String redirectUri;

  public CatalogServiceDashboardClient(String id, String secret, String redirectUri) {
    this.id = id;
    this.secret = secret;
    this.redirectUri = redirectUri;
  }

  public CatalogServiceDashboardClient() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSecret() {
    return secret;
  }

  public void setSecret(String secret) {
    this.secret = secret;
  }

  public String getRedirectUri() {
    return redirectUri;
  }

  public void setRedirectUri(String redirectUri) {
    this.redirectUri = redirectUri;
  }
}
