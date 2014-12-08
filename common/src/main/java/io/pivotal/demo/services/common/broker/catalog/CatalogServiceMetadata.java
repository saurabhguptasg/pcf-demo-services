package io.pivotal.demo.services.common.broker.catalog;

/**
 * Created by sgupta on 12/3/14.
 */
public class CatalogServiceMetadata {

  /**
   * A short name for the service to be displayed in a catalog
   */
  private String name;

  /**
   * A short 1-line description for the service, usually a single sentence or phrase
   */
  private String description;

  /**
   * The name of the service to be displayed in graphical clients
   */
  private String displayName;

  /**
   * The URL to an image
   */
  private String imageUrl;

  /**
   * Long description
   */
  private String longDescription;

  /**
   * The name of the upstream entity providing the actual service
   */
  private String providerDisplayName;

  /**
   * Link to documentation page for service
   */
  private String documentationUrl;

  /**
   * Link to support for the service
   */
  private String supportUrl;

  public CatalogServiceMetadata(String name,
                                String description,
                                String displayName,
                                String imageUrl,
                                String longDescription,
                                String providerDisplayName,
                                String documentationUrl,
                                String supportUrl) {
    this.name = name;
    this.description = description;
    this.displayName = displayName;
    this.imageUrl = imageUrl;
    this.longDescription = longDescription;
    this.providerDisplayName = providerDisplayName;
    this.documentationUrl = documentationUrl;
    this.supportUrl = supportUrl;
  }

  public CatalogServiceMetadata() {
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

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getLongDescription() {
    return longDescription;
  }

  public void setLongDescription(String longDescription) {
    this.longDescription = longDescription;
  }

  public String getProviderDisplayName() {
    return providerDisplayName;
  }

  public void setProviderDisplayName(String providerDisplayName) {
    this.providerDisplayName = providerDisplayName;
  }

  public String getDocumentationUrl() {
    return documentationUrl;
  }

  public void setDocumentationUrl(String documentationUrl) {
    this.documentationUrl = documentationUrl;
  }

  public String getSupportUrl() {
    return supportUrl;
  }

  public void setSupportUrl(String supportUrl) {
    this.supportUrl = supportUrl;
  }
}
