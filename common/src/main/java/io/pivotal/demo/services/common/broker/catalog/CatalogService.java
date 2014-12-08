package io.pivotal.demo.services.common.broker.catalog;

/**
 * Created by sgupta on 12/3/14.
 */
public class CatalogService {

  /**
   * An identifier used to correlate this service in future requests to the catalog. This must be unique within Cloud Foundry, using a GUID is recommended
   */
  private String id;

  /**
   * The CLI-friendly name of the service that will appear in the catalog. All lowercase, no spaces
   */
  private String name;

  /**
   * A short description of the service that will appear in the catalog
   */
  private String description;

  /**
   * Whether the service can be bound to applications
   */
  private boolean bindable;

  /**
   * Tags provide a flexible mechanism to expose a classification, attribute, or base technology of a service, enabling equivalent services to be swapped out without changes to dependent logic in applications, buildpacks, or other services.
   * Eg. mysql, relational, redis, key-value, caching, messaging, amqp
   */
  private String[] tags;

  /**
   * metadata for a service offering.
   */
  private CatalogServiceMetadata metadata;

  /**
   * A list of permissions that the user would have to give the service, if they provision it.
   * The only permission currently supported is syslog_drain
   */
  private CatalogServicePermissionsRequired[] requires;

  /**
   * A list of plans for this service
   */
  private CatalogServicePlan[] plans;

  private CatalogServiceDashboardClient dashboard_client;

  public CatalogService(String id,
                        String name,
                        String description,
                        boolean bindable,
                        String[] tags,
                        CatalogServiceMetadata metadata,
                        CatalogServicePermissionsRequired[] requires,
                        CatalogServicePlan[] plans,
                        CatalogServiceDashboardClient dashboard_client) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.bindable = bindable;
    this.tags = tags;
    this.metadata = metadata;
    this.requires = requires;
    this.plans = plans;
    this.dashboard_client = dashboard_client;
  }

  public CatalogService() {
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

  public boolean isBindable() {
    return bindable;
  }

  public void setBindable(boolean bindable) {
    this.bindable = bindable;
  }

  public String[] getTags() {
    return tags;
  }

  public void setTags(String[] tags) {
    this.tags = tags;
  }

  public CatalogServiceMetadata getMetadata() {
    return metadata;
  }

  public void setMetadata(CatalogServiceMetadata metadata) {
    this.metadata = metadata;
  }

  public CatalogServicePermissionsRequired[] getRequires() {
    return requires;
  }

  public void setRequires(CatalogServicePermissionsRequired[] requires) {
    this.requires = requires;
  }

  public CatalogServicePlan[] getPlans() {
    return plans;
  }

  public void setPlans(CatalogServicePlan[] plans) {
    this.plans = plans;
  }

  public CatalogServiceDashboardClient getDashboard_client() {
    return dashboard_client;
  }

  public void setDashboard_client(CatalogServiceDashboardClient dashboard_client) {
    this.dashboard_client = dashboard_client;
  }
}
