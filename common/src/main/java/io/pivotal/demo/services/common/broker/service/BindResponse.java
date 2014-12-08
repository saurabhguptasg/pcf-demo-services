package io.pivotal.demo.services.common.broker.service;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sgupta on 12/8/14.
 */
public class BindResponse {
  private Map<String,String> credentials;

  public BindResponse(Map<String, String> credentials) {
    this.credentials = credentials;
  }

  public BindResponse(Map.Entry<String,String> ... entries) {
    this.credentials = new HashMap<String, String>();
    for (Map.Entry<String, String> entry : entries) {
      credentials.put(entry.getKey(), entry.getValue());
    }
  }

  public BindResponse() {
  }

  public Map<String, String> getCredentials() {
    return credentials;
  }

  public void setCredentials(Map<String, String> credentials) {
    this.credentials = credentials;
  }

}
