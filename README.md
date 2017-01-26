# data-service
data process

Test: http://localhost:8080
	  http://localhost:8080/welcome

under src/main/webapp/
	public: common public .html pages
	static: .js and .css pages
	WEB-INF/jsp: .jsp files
	WEB-INF/jsp/upload/{table-name}: .jsp files to upload the file data to database tables
	
login to http://localhost:8082/ to view H2 database
	Saved Settings:	Generic H2 (Embedded)
	Setting Name:	Generic H2 (Embedded)
	Driver Class:	org.h2.Driver
	JDBC URL:		jdbc:h2:mem:mydb
	User Name:		sa
	Password:
