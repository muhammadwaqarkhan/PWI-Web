# PWI-Web PWI (Product Warehouse & Inventory) System:

Product Configuration
DB: you need to import "PWI" mySQL database, which is pleaced at BaseJar project under database folder.

hibernate.cfg.xml is configuration file where you can put DB username and password like below
 property = hibernate.connection.password=''
 property = hibernate.connection.username=root

Setup Tomcat:
once you take sync from  https://github.com/muhammadwaqarkhan/PWI-Web.git URL you need to setup tomcat7.
 1) goto tomcat class path add bin folder  of DomainModel project
 1) goto tomcat class path add bin folder  of PWIServices project
 2) goto tomcat class path and add AOP,hibernate,JarStore,jaxws,jpa2,rest and both spring Jars
 
start tomcat server and hit http://localhost:8080/PWI/login.jsp 
application login is:
	User 	= Vantiboli
	Password= Vantiboli


This product consists of four projects
1)	Base Jar
2)	Domain Model
3)	PWI-App
4)	PWI-Services

Base-Jar:
This project contains all required jar Spring, hibernate, jaxws, jpa2, aop and jar store. Unfortunately, I build my own project to contain all jar’s. 

Domain Model:
This project contains all Domain (entity) and DAO (data access object) of complete database. Each table has its own entity
Address, Branch, BrandProduct, Brand, Company, StoreProduct, Product, Store, UserAccounts

PWI-App: 
This is Dynamic web project, which initiate our application, this project has two parts, WebContent and Source. Each JSP page bind with PageHandler which is responsible to handle that requests.

To associate each JSP with PageHandler, we need to add entry in PWI-Page-Handler.xml file like below.
 
    
    
Each page has Page-Handler and that page handler must have implemented by IPageHandler.java which contain four methods. 
1)	executeRead: action to read record with the help of service
2)	executeWrite: action to create record with the help of service
3)	executeDelete: action to performed deletion part
4)	executeUpdate: action to update records

UI Validation: I have written generic validation JS with name IValidatio.js which help me find mask and mandatory. As I did same thing on my other project.


Web-Services:
	Rest service: As mention in assignment I need to develop some web services which I have done below are URL’s. all service return XML
Store related Service

Get all stores: 		http://localhost:8080/PWI/rest/Stores/getStore

Add Store:	 	http://localhost:8080/PWI/rest/Stores/addStore

Update Store:	 	http://localhost:8080/PWI/rest/Stores/updateStore

Delete Store:	 	http://localhost:8080/PWI/rest/Stores/deleteStore

Get Store Quantity:	 http://localhost:8080/PWI/rest/Stores/getStoreQuantity

Update Store Quantity:	 http://localhost:8080/PWI/rest/Stores/updateStoreQuantity


Product related Service

Add Product:	 		http://localhost:8080/PWIApp/rest/Products/addProduct

Update Product:	 	http://localhost:8080/PWIApp/rest/Products/updateProduct

Product Size:	 		http://localhost:8080/PWIApp/rest/Products/productSize

I am not good in rest base services might have possibility that there are missing standers in my code. As I have also developed SOAP base web services you can access above functionality through below SOAP method
SOAP Base services
I have also integrated soap handler you can log all request which came on your server through JAXSoapServiceHandler.java document is there for further details
I have published above method on server startup at below link

Product: http://localhost:7779/PWI/Products

Store: http://localhost:7779/PWI/Stores

Branch: http://localhost:7779/PWI/Branch


PWI-Services:
This project contains all services to interact with database using Domain and DAO.
How to create service:
I have created my own annotation with name “ServiceMethod”. This annotation helped me to identified service method.
See below simple ProductService which help us to performed product related work like, fetch product, save product, delete product and update product.
ServiceBase: every service must extend with ServiceBase class. we have inject session object just before calling service.
 ServiceMethod: ” FeatchProduct” is name of service method used to call service in ServiceExecutor 
IResponseHandler: is basically an interface while help us to identified either request completed successfully or not.

