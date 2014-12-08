package io.pivotal.demo.services.common.broker.catalog;

/**
 * Created by sgupta on 12/3/14.
 */
public class CatalogResponse {

  private CatalogService[] services;

  public CatalogResponse(CatalogService[] services) {
    this.services = services;
  }

  public CatalogResponse() {
  }

  public CatalogService[] getServices() {
    return services;
  }

  public void setServices(CatalogService[] services) {
    this.services = services;
  }
}
