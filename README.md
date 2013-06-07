AlfrescoCustomTableSample
=========================

Sample code to insert into / select from custom table of Alfresco via ibatis

Environment
-----------
* Alfresco Community Edition 4.2.c
* MySQL Community Server 5.5.31

How to install
--------------
* Create custom table using Create-CustomTable.sql
* Locate aegif-alfresco-custom.jar under alfresco/WEB-INF/lib
* Locate context files to shared/classes/alfresco/extension

Usage
-----
You can insert into / select from the custom table using JavaScript.
* insert : `customEntity.insert(person.properties["userName"]);`
* select : `customEntity.selectByUser(person.properties["userName"];`
