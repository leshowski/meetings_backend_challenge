# Meetings Challenge

## Description
Build a simple application to support meeting room reservation inside a company, knowing that:

* A company can have multiple buildings, these can have multiple floors which in turn can have
  multiple meeting rooms.
* Meeting rooms have maximum allocation.
* Only some rooms have multimedia capabilities.
* Rooms have a clean-up time proportional to their size (5 minutes base + 1 min per room seat)

By supplying the start date and meeting time span, number of attendees and required multimedia
capabilities the user should be able to reserve a meeting room from a list of available rooms.

Result list should be ordered based off efficiency of allocation. Specifying the building is optional.

User should be able to view/list reserved time spans per room for all buildings in any day.

## Solution details

Spring Boot Rest application, using an in memory H2 Database. The import.sql file has the insert statements for the entities (buildings, floors, rooms, capabilities).
When the app is running, is possible to query the database by accessing [http://localhost:8080/h2-console](http://localhost:8080/h2-console). The credentials are stored in application.properties file.

## Requirements

* Maven
* Java 11+

## Run

Get the content and inside the folder run:

```bash
mvn spring-boot:run
```

## Usage

### Endpoints Specs:
[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

### Endpoints (See Swagger UI for request-details):
#### GET - List of Buildings with their floors, rooms and capabilities:
[http://localhost:8080/buildings](http://localhost:8080/buildings)
#### GET - List of Available rooms:
[http://localhost:8080/availableRooms](http://localhost:8080/availableRooms)
#### POST - Book a room:
[http://localhost:8080/bookRoom](http://localhost:8080/bookRoom)
#### GET - Booked rooms:
[http://localhost:8080/bookedRooms?fromDate=yyyyMMdd](http://localhost:8080/bookedRooms)
