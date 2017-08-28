# RESTful API with MySQL 

## Overview
This Maven Project persists data sent through a RESTful API in a MySQL Database.

## Prerequisites
* Red Hat JBoss Enterprise Application Platform
* Red Hat JBoss Developer Studio
* MySQL Community Server.
* A browser or Postman API

## Installation
### Installation of all
1. At https://access.redhat.com download and unzip them in the desired area: 
* Server file for Red Hat JBoss Enterprise Application Platform.
* Jar installer for JBoss Developer Studio.
2. At https://dev.mysql.com/downloads/mysql/, download the MySQL Community Server.
3. For Postman, go to www.getpostman.com and download it.

## Configuration
### MySQL Community Server
1. Create your user to log into MySQL Community Server.
2. Create a database called 'Pessoa' after logged in. 

#### Red Hat JBoss Developer Studio
1. Open the Servers tab.
2. Click on the `No servers are available. Click this link to create a new server..` link.
3. Expand Red Hat JBoss Middleware and choose JBoss Enterprise Application Platform 7.0. Enter a server name then click Next.
4. Create a server adapter to manage starting and stopping the server. Keep the defaults and click Next.
5. Enter a name, for example JBoss EAP 7.0 Runtime. Click `Browse next to Home Directory` and navigate to your JBoss EAP installation directory, then click Finish.
6. Create a Datasource 
7. Connect the JBoss Enterprise Application Platform Datasource with the database created, changing the `persistence.xml` file of this application.


## Standalone Deployment
1. Import the project downloaded here. 
2. Right-click the project in the `Project Explorer` tab and select `Run As → Run on Server`.
3. Go to the terminal and use the command `mysql -u user -p`.
4. See the databases with `show databases` and use a specific one with `use database_name`.
5. See the Data persisted in the specific table with `select * from table_name`.

## Tests 
* Persisting Data (make sure to set it to POST with Postman):
```
http://localhost:8080/helloworld-0.0.1-SNAPSHOT/api/dao/persist?rg=286263859&nome=Eduardo
```
* Retrieving Data (make sure to set it to GET with Postman):
```
http://localhost:8080/helloworld-0.0.1-SNAPSHOT/api/dao/find?rg=286263859
```

## Useful Links 
* Any trouble with installation and setup can be solved at https://access.redhat.com with the Documentation or Knowledgebase.
