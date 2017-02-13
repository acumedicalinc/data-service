package com.acumedicalinc.web.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
//@EnableTransactionManagement
@ComponentScan
public class DatabaseConfig {

  /**
   * DataSource definition for database connection. Settings are read from
   * the application.properties file (using the env object).
   */
//  @Bean
//  public DataSource dataSource() {
//    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//    dataSource.setDriverClassName("org.h2.Driver");
//    dataSource.setUrl( "jdbc:h2:mem:mydb");
//    dataSource.setUsername("");
//    dataSource.setPassword("");
//    return dataSource;
//  }

//  @Bean
//  public EntityManagerFactory entityManagerFactory() {
//	  if (entityManagerFactory == null)
//		  entityManagerFactory =  new HibernateJpaSessionFactoryBean().getEntityManagerFactory();
//	  
//	  return entityManagerFactory;
//  }
  
//  @Autowired
//  private EntityManagerFactory entityManagerFactory;
  
  @Bean  
  public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){  
      return hemf.getSessionFactory();  
  } 
//  @Bean
//  public SessionFactory getSessionFactory() {
//      if (entityManagerFactory().unwrap(SessionFactory.class) == null) {
//          throw new NullPointerException("factory is not a hibernate factory");
//      }
//      return entityManagerFactory().unwrap(SessionFactory.class);
//  }
  
//  @Bean
//	public DataSource dataSource() {
//
//		// no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
//		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//		EmbeddedDatabase db = builder
//			.setType(EmbeddedDatabaseType.HSQL) //.H2 or .DERBY
//			.addScript("db/sql/create-db.sql")
//			.addScript("db/sql/insert-data.sql")
//			.build();
//		return db;
//	}
//  
//  @Bean
//  @Primary
//  public DataSource dataSource() {
//      return DataSourceBuilder
//          .create()
//          .username("")
//          .password("")
//          .url("jdbc:h2:/temp/h2database")
//          .driverClassName("org.h2.Driver")
//          .build();
//  }
//  
//  @Bean(initMethod="start",destroyMethod="stop")
//  public org.h2.tools.Server h2WebConsonleServer () throws SQLException {
//    return org.h2.tools.Server.createWebServer("-web","-webAllowOthers","-webDaemon","-webPort", "8082");
//  }
  
  /**
   * PersistenceExceptionTranslationPostProcessor is a bean post processor
   * which adds an advisor to any bean annotated with Repository so that any
   * platform-specific exceptions are caught and then rethrown as one
   * Spring's unchecked data access exceptions (i.e. a subclass of 
   * DataAccessException).
   */
//  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
    return new PersistenceExceptionTranslationPostProcessor();
  }
  
  @Bean (name="jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}

  @Autowired
  private DataSource dataSource;

  @Bean(initMethod="start",destroyMethod="stop")
  public org.h2.tools.Server h2WebConsonleServer () throws SQLException {
    return org.h2.tools.Server.createWebServer("-web","-webAllowOthers","-webDaemon","-webPort", "8082");
  }
}
