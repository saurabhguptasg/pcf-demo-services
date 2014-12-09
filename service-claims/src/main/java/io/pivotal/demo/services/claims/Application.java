package io.pivotal.demo.services.claims;

import io.pivotal.demo.services.common.broker.catalog.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Entry point for the claims application (service broker and app)
 *
 */
@Configuration
@ComponentScan(basePackages = {"io.pivotal.demo.services"})
@EnableAutoConfiguration
public class Application  {
    public static void main( String[] args ) {
        SpringApplication.run(Application.class, args);
    }

  @Bean
  public Map<String,String> getGlobalCache() {
    return new HashMap<>();
  }


    @Bean
    public CatalogResponse getCatalogResponse() {
        CatalogService service = new CatalogService();
        service.setId("69FB2D58-A823-4C2C-9EE2-E60B556B8419");
        service.setName("claims");
        service.setDescription("A service to provide claims functionality, with admin functions for internal use");
        service.setBindable(true);
        service.setTags(new String[]{"claims", "businesslogic", "internal"});
        service.setMetadata(new CatalogServiceMetadata("ClaimsService",
                                                       "Create, Retrieve, Monitor and Administer claims",
                                                       "Claims Service",
                                                       "http://storage.googleapis.com/atomcloud-dough-files/Cabinet.png",
                                                       "A common service to allow apps to create claims in the central claims system, with endpoints to administer and manage the claims internally via admin level apps",
                                                       "Corporate Claims Division",
                                                       "http://www.pivotal.io",
                                                       "http://www.pivotal.io"));
        service.setPlans(new CatalogServicePlan[]{
            new CatalogServicePlan("3520282F-75E3-4BF5-A97A-7DC5FF402782",
                                   "basic",
                                   "basic, default claims service plan functionality",
                                   new CatalogServicePlanMetadata("basicclaims", "Basic Claims Plan", "Routine claims functionality",
                                                                  new String[]{"create claims", "delete claims", "monitor claims"},
                                                                  new CatalogServicePlanCost[]{
                                                                      new CatalogServicePlanCost("usd", 0.00F, "MONTHLY")
                                                                  }), true)
        });
      service.setRequires(new CatalogServicePermissionsRequired[]{CatalogServicePermissionsRequired.syslog_drain});
        CatalogResponse catalogResponse = new CatalogResponse(new CatalogService[]{service});
      System.out.println(">> >> >> created new catalog response!");
        return catalogResponse;
    }

  @Bean
  public PlanSet getPlanSet(CatalogResponse catalogResponse) {
    PlanSet planSet = new PlanSet();
    for (CatalogService catalogService : catalogResponse.getServices()) {
      for (CatalogServicePlan catalogServicePlan : catalogService.getPlans()) {
        planSet.addPlan(catalogServicePlan.getId());
      }
    }
    return planSet;
  }

}
