package io.pivotal.demo.services.common.broker.catalog;

/**
 * Created by sgupta on 12/3/14.
 */
public class CatalogServicePlan {
  /**
   * An identifier used to correlate this plan in future requests to the catalog.
   * This must be unique within Cloud Foundry, using a GUID is recommended
   */
  private String id;

  /**
   * The CLI-friendly name of the plan that will appear in the catalog. All lowercase, no spaces
   */
  private String name;

  /**
   * A short description of the plan that will appear in the catalog
   */
  private String description;

  /**
   * metadata for a service plan
   */
  private CatalogServicePlanMetadata metadata;

  /**
   * This field allows the plan to be limited by the non_basic_services_allowed field in a Cloud Foundry Quota, see Quota Plans. Default: true
   */
  private boolean free;

  public CatalogServicePlan(String id, String name, String description, CatalogServicePlanMetadata metadata, boolean free) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.metadata = metadata;
    this.free = free;
  }

  public CatalogServicePlan() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CatalogServicePlanMetadata getMetadata() {
    return metadata;
  }

  public void setMetadata(CatalogServicePlanMetadata metadata) {
    this.metadata = metadata;
  }

  public boolean isFree() {
    return free;
  }

  public void setFree(boolean free) {
    this.free = free;
  }
}
