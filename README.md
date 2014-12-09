Service Brokers
===============

These are Spring Boot apps that implement the [Service Broker API for CloudFoundry](http://docs.cloudfoundry.org/services/api.html)

These apps can be deployed within CloudFoundry as well.

The manifest.yml files for each app include the following constants:
* `SVC_AUTH_NAME`: this is the authentication name the `CloudController` will use to auth with the broker
* `SVC_AUTH_CODE`: this is the authentication code the `CloudController` will use to auth with the broker

When adding a service broker, you can use the following command:
`cf update-service-broker {service_name} {SVC_AUTH_NAME} {SVC_AUTH_CODE} {service_app_endpoint}`

Currently, these apps don't have a backing store integrated (e.g. Redis) so if you plan to make the brokers scale out,
 then you'll need to introduce something like that so that service instance information can be shared across app instances.