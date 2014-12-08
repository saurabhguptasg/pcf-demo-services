package io.pivotal.demo.services.common.broker.catalog;

/**
 * Created by sgupta on 12/3/14.
 */
public class CatalogServicePlanMetadata {

  /**
   * A short name for the service plan to be displayed in a catalog
   */
  private String name;

  /**
   * Name of the plan to be display in graphical clients
   */
  private String displayName;

  /**
   * A description of the service plan to be displayed in a catalog
   */
  private String description;

  /**
   * Features of this plan, to be displayed in a bulleted-list
   */
  private String[] bullets;

  /**
   * An array-of-objects that describes the costs of a service, in what currency, and the unit of measure.
   * If there are multiple costs, all of them could be billed to the user (such as a monthly + usage costs at once).
   * Each object must provide the following keys:
   * amount: { usd: float }, unit: string
   * This indicates the cost in USD of the service plan, and how frequently the cost is occurred, such as “MONTHLY” or “per 1000 messages”
   */
  private CatalogServicePlanCost[] costs;

  public CatalogServicePlanMetadata(String name, String displayName, String description, String[] bullets, CatalogServicePlanCost[] costs) {
    this.name = name;
    this.displayName = displayName;
    this.description = description;
    this.bullets = bullets;
    this.costs = costs;
  }

  public CatalogServicePlanMetadata() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String[] getBullets() {
    return bullets;
  }

  public void setBullets(String[] bullets) {
    this.bullets = bullets;
  }

  public CatalogServicePlanCost[] getCosts() {
    return costs;
  }

  public void setCosts(CatalogServicePlanCost[] costs) {
    this.costs = costs;
  }
}
