package io.pivotal.demo.services.claims.controllers;

import io.pivotal.demo.services.common.broker.catalog.CatalogResponse;
import io.pivotal.demo.services.common.broker.catalog.PlanSet;
import io.pivotal.demo.services.common.broker.provision.ProvisionRequest;
import io.pivotal.demo.services.common.broker.provision.ProvisionResponse;
import io.pivotal.demo.services.common.broker.service.*;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by sgupta on 12/3/14.
 */
@Controller
@RequestMapping(value = "/v2/**", produces = "application/json")
public class BrokerController {
  public static final Logger LOGGER = Logger.getLogger(BrokerController.class.getName());

  private static final Random RANDOM = new Random();

  @Autowired
  CatalogResponse catalogResponse;

  @Autowired
  PlanSet planSet;

  Map<String,ServiceInstance> serviceInstanceMap = new HashMap<>();

  Map<String,Binding> bindingMap = new HashMap<>();

  @RequestMapping(value = "/catalog", method = RequestMethod.GET)
  @ResponseBody
  public CatalogResponse getCatalog() {
    return catalogResponse;
  }

  @RequestMapping(value = "/service_instances/{instance_id}", method = RequestMethod.PUT)
  @ResponseBody
  public ResponseEntity<ProvisionResponse> provision(@PathVariable("instance_id") String instanceId,
                                                     @RequestBody ProvisionRequest provisionRequest) {
    LOGGER.log(Level.FINE, "provision request is: " + provisionRequest);

    ResponseEntity<ProvisionResponse> responseEntity;
    ServiceInstance currInstance = serviceInstanceMap.get(instanceId);
    ServiceInstance newInstance = new ServiceInstance(instanceId,
                                                      provisionRequest.getService_id(),
                                                      provisionRequest.getPlan_id(),
                                                      provisionRequest.getOrganization_guid(),
                                                      provisionRequest.getSpace_guid());
    if(currInstance == null) {
      currInstance = newInstance;
      serviceInstanceMap.put(instanceId, currInstance);
      responseEntity = new ResponseEntity<>(new ProvisionResponse(), HttpStatus.CREATED);
    }
    else if(currInstance.equals(newInstance)) {
      responseEntity = new ResponseEntity<>(new ProvisionResponse(), HttpStatus.OK);
    }
    else {
      responseEntity = new ResponseEntity<>(new ProvisionResponse(), HttpStatus.CONFLICT);
    }

    return responseEntity;
  }

  @RequestMapping(value = "/service_instances/{instance_id}", method = RequestMethod.PATCH)
  @ResponseBody
  public ResponseEntity<Map<String,String>> update(@PathVariable("instance_id") String instanceId,
                                                   @RequestBody UpdateRequest updateRequest) {
    ServiceInstance serviceInstance = serviceInstanceMap.get(instanceId);
    if(serviceInstance == null) {
      return new ResponseEntity<Map<String, String>>(new HashMap<String,String>(), HttpStatus.NOT_FOUND);
    }
    else if(planSet.hasPlan(updateRequest.getPlan_id())) {
      serviceInstance.setPlan_id(updateRequest.getPlan_id());
      return new ResponseEntity<Map<String, String>>(new HashMap<String,String>(), HttpStatus.OK);
    }
    else {
      return new ResponseEntity<Map<String, String>>(new HashMap<String,String>(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

  @RequestMapping(value = "/service_instances/{instance_id}/service_bindings/{binding_id}", method = RequestMethod.PUT)
  @ResponseBody
  public ResponseEntity<BindResponse> bind(@PathVariable("instance_id") String instance_id,
                                                 @PathVariable("binding_id") String binding_id,
                                                 @RequestBody BindRequest bindRequest) {

    ServiceInstance serviceInstance = serviceInstanceMap.get(instance_id);
    if(serviceInstance == null) {
      return new ResponseEntity<>(new BindResponse(new HashMap<String,String>()),
                                  HttpStatus.NOT_FOUND);
    }

    Binding currentBinding = bindingMap.get(binding_id);
    Binding newBinding = new Binding(binding_id, bindRequest.getPlan_id(), bindRequest.getService_id(), bindRequest.getApp_guid());
    if(currentBinding == null) {
      newBinding.setCredentials(generateNewCredentials());
      bindingMap.put(binding_id, newBinding);
      return new ResponseEntity<>(new BindResponse(newBinding.getCredentials()),
                                  HttpStatus.CREATED);
    }
    else if(currentBinding.equals(newBinding)) {
      return new ResponseEntity<>(new BindResponse(currentBinding.getCredentials()),
                                              HttpStatus.OK);
    }
    else {
      return new ResponseEntity<>(new BindResponse((Map<String,String>)null),
                                  HttpStatus.CONFLICT);
    }
  }

  @RequestMapping(value = "/service_instances/{instance_id}/service_bindings/{binding_id}", method = RequestMethod.DELETE)
  @ResponseBody
  public ResponseEntity<Map<String,String>> unbind(@PathVariable("instance_id") String instance_id,
                                                   @PathVariable("binding_id") String binding_id,
                                                   @RequestParam("plan_id") String plain_id,
                                                   @RequestParam("service_id")String service_id) {

    Binding currentBinding = bindingMap.remove(binding_id);
    if(currentBinding == null) {
      return new ResponseEntity<Map<String, String>>(new HashMap<String,String>(), HttpStatus.GONE);
    }
    return new ResponseEntity<Map<String, String>>(new HashMap<String,String>(), HttpStatus.OK);
  }

  @RequestMapping(value = "/service_instances/{instance_id}", method = RequestMethod.DELETE)
  @ResponseBody
  public ResponseEntity<Map<String,String>> deprovision(@PathVariable("instance_id") String instance_id,
                                                        @RequestParam("plan_id") String plain_id,
                                                        @RequestParam("service_id")String service_id) {
    LOGGER.info(">> deprovisioning instance id: " + instance_id);
    LOGGER.info(">> deprovisioning params: plan_id["+plain_id+"], service_id["+service_id+"]");

    ServiceInstance serviceInstance = serviceInstanceMap.remove(instance_id);
    if(serviceInstance == null) {
      return new ResponseEntity<Map<String, String>>(new HashMap<String,String>(), HttpStatus.GONE);
    }
    return new ResponseEntity<Map<String, String>>(new HashMap<String,String>(), HttpStatus.OK);
  }


  private Map<String,String> generateNewCredentials() {
    Map<String,String> credentials = new HashMap<>();
    byte[] bytes = new byte[32];
    RANDOM.nextBytes(bytes);
    credentials.put("username", Base64.encodeBase64URLSafeString(bytes));
    RANDOM.nextBytes(bytes);
    credentials.put("password", Base64.encodeBase64URLSafeString(bytes));

    return credentials;
  }

}
