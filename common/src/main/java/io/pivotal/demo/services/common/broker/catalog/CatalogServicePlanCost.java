package io.pivotal.demo.services.common.broker.catalog;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sgupta on 12/3/14.
 */
public class CatalogServicePlanCost {
  private Map<String,Float> amount;
  private String unit;

  public CatalogServicePlanCost() {
  }

  public CatalogServicePlanCost(String currencyCode, Float amount, String unit) {
    setUnit(unit);
    addCostInCurrencyValue(currencyCode, amount);
  }

  public Map<String, Float> getAmount() {
    return amount;
  }

  public void setAmount(Map<String, Float> amount) {
    this.amount = amount;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public void addCostInCurrencyValue(String currency, Float cost) {
    if(amount == null) {
      amount = new HashMap<String, Float>();
    }
    amount.put(currency, cost);
  }
}
