# car_challenge
Simple API for tracking car maintenance, designed to run on Tomcat 7, and jUnit 4.

# Information about what is included.

## Unit tests
- Testing is done for each POJO and DAO.

## Vehicle object, with its children, one for each type:
- Electric Vehicle
- Gasoline Vehicle
- Diesel Vehicle

## Service object
- Each object represents a certain service that can be applied to vehicles.
- It has a boolean property for each Vehicle type, to indicate if it is compatible.
- This can be expanded by adding more properties, such as average cost, or average hours.

## VehicleServiceOccurrence object
- One instance is used to track a particular service, with a particular vehicle, by ID.
- When setting this 'service incident', some simple logic checks if the services are compatible.
- If an incompatibility is found, a custom ServiceNotCompatibleException exception is thrown.

## DAOs
- Simple objects meant to maintain a hashmap of object instances at runtime.
- Uses ID as the key, and the object as the value for efficient searching.

## Resource Objects
- Objects meant to facilitate POST/GET requests and XML responses from and to the user.

## HTML
- create_service.html, create_vehicle.html, service_vehicle.html.
- Very simple forms to send POST/GET requests.
- Would be good to add more complex UI in future.
- After a POST is issued, the user is redirected to the XML output of a GET request, listing the current vehicles, services, or service occurrences.

