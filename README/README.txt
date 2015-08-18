
How to deploy LockerEJB.jar on JBoss 4.2.2?


- install MySQL:
	- mysql-installer-5.5.19.0.msi
	- Default install

- add 'locker' user:
	- open MySQL Workbench, click on 'Manage Security' link
	- Add Account:
		* un: locker
		* pw: locker
		* limit connectivity to hosts matching: localhost
	- Administrative Roles:
		* DBManager
- create schema:
	- open SQL Editor in MySQL Workbench:
	- execute: create schema locker<Ctrl+Enter>
	- double click on 'locker' schema on the left (to make it the currently selected schema)
	- open and execute script: E:\repository\Budapest\LockerEJB\locker.sql

- edit JBoss CLASSPATH:
	- cp C:\Program Files\MySQL\MySQL Connector J\mysql-connector-java-5.1.15-bin.jar C:\jboss-4.2.2.GA\server\default\lib

- add datasource:
	- cp E:\repository\Budapest\LockerEJB\mysql-ds.xml C:\jboss-4.2.2.GA\server\default\deploy

- junction to the EJB:
	- C:\Utils\junction.exe LockerEJB.jar E:\repository\Budapest\LockerEJB

====

- see also:
	- scripts under:  E:\repository\Budapest\LockerEJB\ejbModule\META-INF
