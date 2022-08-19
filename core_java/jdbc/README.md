# Introduction

This Maven project CRUD application uses JDBC to connect to a PSQL database instance and implement the nesesacry object methods for DBA's to have easier control and access to the Databases information.

# Implementation
## ER Diagram

![Architecture graph](hplussportER.png)

## Design Patterns
DAO or Data Access Objects design patterns work as follows:
- Consists of abstraction of data persistence and is considered closer to the underlying storage.
- Used to separate low-level data accessing API or operations from high business services.
- Essentially this type of API would hide all complex CRUD operations implemented in the underlying storage mechanism from the application.
- great for when we need to change the underlying persistence mechanism, we only have to change the DAO layer and not all the places in the domain logic where the DAO layer is used from.

Repository design patterns work as follows:
- Is an abstraction of a collection of data objects.
- This is done by mediating between the domain and the data mapping layers using a collection-like interface for accessing the domain objects.
- Allows for easy controller testing as the actual database, queries, and other data access logic will be separate from the rest of the application

# Test
This app was tested using the hplussport database through the following:
- To confirm setup of database, connection to tables was tested through psql cli commands using psql_docker.sh container as the psql instance to connect to
- To confrim database creation and tables set up, psql cli connection was tested succesfully and dbeaver instance connection was succesfully tested, along with table viewing and ER diagram generation
- To confirm query results and Data Access control, JDBCExecute file implements a series a object DAO's and DTO's for the hplussport database to evaluate query results and data manipulation


