# SpringBoot-JDBCAuthontication-Security-Application-By-Yakub
Spring Security with jdbc authentication
--------------------------------------------------------------
--> if we provide credential with data base for 
global access for Rest Application. such type of 
authentication is called jdbc authentication.

-> Step1: creating a table with name users
user_id   --PK     ---> int()
username            --> varchar(40)
password    --> encrypted  -->varchar(64)
role----> varchar(40)
enabled    ----> 1/0   --->      TINYINT   ---> boolean values
------------------------------------------------------------------------
step2: Create Spring Boot Appn
Step3 : Add Required Starters  
        1. Spring web
         2. spring -securiry
         3. jdbc_starter
         4. Msql -Driver
--------------------------------------------------------------
Step4: in application.properties

port no code
db connection code+JPA properties 
===================================================
Step5: Create Your Controller class With methods and its end points

getHomePage()   --------> homepage.jsp   ---> /home
getWelcomPage() ----> welcomepage.jsp   ---> /welcome
getAdminPage() ----> adminpage.jsp   ---> /admin   --> role:admin
getEmpPage() ----> emppage.jsp   ---> /emp              --> role:employee
getManagerPage() ----> managerpage.jsp   ---> /mgr   --> role: manager
getCommonPage() ----> common.jsp   ---> /common  --> roles:admin&employee&manager
getLogout()   -------> logoutpage.jsp   -->/logout   --> 
-----------------------------------------------------------------------------
Step6: create Java class with   (CustomSecurity.java)
@Configuration+@EnableWebSecurity  --> Java Based Configuration

1. @Override    configire()   --> Default Security 

2. @Override    configire()   --> http.jdbcAuthentication()



CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  `role` varchar(45) NOT NULL,
  `enabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
);



INSERT INTO `users` (`username`,`password`,`role`,`enabled`)
VALUES ('user',
'$2a$10$XptfskLsT1l/bRTLRiiCgejHqOpgXFreUnNUa35gJdCr2v2QbVFzu',
'ROLE_USER', 1);
 
INSERT INTO `users` (`username`,`password`,`role`,`enabled`)
VALUES ('emp',
'$2a$10$zxvEq8XzYEYtNjbkRsJEbukHeRx3XS6MDXHMu8cNuNsRfZJWwswDy',
'ROLE_EMP', 1);

INSERT INTO `users` (`username`,`password`,`role`,`enabled`)
VALUES ('admin',
'$2a$10$zxvEq8XzYEYtNjbkRsJEbukHeRx3XS6MDXHMu8cNuNsRfZJWwswDy',
'ROLE_ADMIN', 1);

INSERT INTO `users` (`username`,`password`,`role`,`enabled`)
VALUES ('mrg',
'$2a$10$zxvEq8XzYEYtNjbkRsJEbukHeRx3XS6MDXHMu8cNuNsRfZJWwswDy',
'ROLE_MGR', 1);

----------------------------------------------------------------
Reuired Files are
-------------------------
1. MyController .java   --> @Controller
2. application.properties
3. CutomizedSecurity.java  --> @Configuration+@EnableWebSecurity
4. App.java     --> @SpringBootApplication
-------------------------------------------------------------------------------
Reuired Jars Are
-----------------------
1. Spring Web
2. Spring Security
3. Spring jdbc
4. Mysql Connector
