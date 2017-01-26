# data-service
data process

<pre>
Test: http://localhost:8080
	  http://localhost:8080/welcome
</pre>

<pre>
under src/main/webapp/
	public: common public .html pages
	static: .js and .css pages
	WEB-INF/jsp: .jsp files
	WEB-INF/jsp/upload/{table-name}: .jsp files to upload the file data to database tables
</pre>

<pre>
upload file to DB: http://localhost:8080/upload	
view H2 database:  http://localhost:8082/

	Saved Settings:	Generic H2 (Embedded)
	Setting Name:	Generic H2 (Embedded)
	Driver Class:	org.h2.Driver
	JDBC URL:		jdbc:h2:mem:mydb
	User Name:		sa
	Password:
</pre>