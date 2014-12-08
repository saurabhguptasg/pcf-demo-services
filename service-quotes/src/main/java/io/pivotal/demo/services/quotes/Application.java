package io.pivotal.demo.services.quotes;

import io.pivotal.demo.services.common.broker.catalog.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 *
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {
    public static void main( String[] args ) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CatalogResponse getCatalogResponse() {
        CatalogService service = new CatalogService();
        service.setId("0021627D-1504-4D11-94B1-D979C32B2E62");
        service.setName("quotes");
        service.setDescription("A service to provide quotes functionality, with admin functions for internal use");
        service.setBindable(true);
        service.setTags(new String[]{"quotes", "sales", "internal"});
        service.setMetadata(new CatalogServiceMetadata("QuotesService",
                                                       "Create, Retrieve, Monitor and Administer quotes for users",
                                                       "Quotes Service",
                                                       "http://storage.googleapis.com/atomcloud-dough-files/Sales.png",
                                                       "A common service to allow apps to create quotes in the central quoting system, with endpoints to administer and manage the quotes internally via admin level apps",
                                                       "Quotes and Sales Division",
                                                       "http://www.pivotal.io",
                                                       "http://www.pivotal.io"));
        service.setPlans(new CatalogServicePlan[]{
            new CatalogServicePlan("5DA588AA-7092-4922-8C9D-9D0FE8168B5E",
                                   "basic",
                                   "basic, default quoting service plan functionality",
                                   new CatalogServicePlanMetadata("basicquotes", "Basic Quotes Plan", "Routine quotes functionality",
                                                                  new String[]{"create quotes", "delete quotes", "monitor and adjust quotes"},
                                                                  new CatalogServicePlanCost[]{
                                                                      new CatalogServicePlanCost("usd", 0.00F, "MONTHLY")
                                                                  }), true)
        });
        service.setRequires(new CatalogServicePermissionsRequired[]{CatalogServicePermissionsRequired.syslog_drain});
        CatalogResponse catalogResponse = new CatalogResponse(new CatalogService[]{service});
        System.out.println(">> >> >> created new catalog response!");
        return catalogResponse;
    }

}
