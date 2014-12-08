package io.pivotal.demo.services.common.broker.catalog;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sgupta on 12/8/14.
 */
public class PlanSet {

  private Set<String> plans;

  public PlanSet() {
    plans = new HashSet<String>();
  }

  public void addPlan(String plainId) {
    plans.add(plainId);
  }

  public boolean hasPlan(String planId) {
    return plans.contains(planId);
  }
}
