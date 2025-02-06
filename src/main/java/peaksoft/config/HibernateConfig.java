package peaksoft.config;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import peaksoft.models.Laptop;
import peaksoft.models.Programmer;

@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = "peaksoft")
public class HibernateConfig {
    private static String URL = "jdbc:postgresql://localhost:5454/java16";
    private static String USER = "postgres";
    private static String PASSWORD = "postgres";
    private static String DRIVER = "org.postgresql.Driver";
    private static String DIALECT = "org.hibernate.dialect.PostgreSQLDialect";

    @Bean
    public EntityManagerFactory getEntityManagerFactory() {
        Configuration configuration = new Configuration();
        configuration.setProperty(Environment.JAKARTA_JDBC_URL, URL);
        configuration.setProperty(Environment.JAKARTA_JDBC_USER, USER);
        configuration.setProperty(Environment.JAKARTA_JDBC_PASSWORD, PASSWORD);
        configuration.setProperty(Environment.DIALECT, DIALECT);
        configuration.setProperty(Environment.JAKARTA_JDBC_DRIVER, DRIVER);
        configuration.setProperty(Environment.HBM2DDL_AUTO, "update");
        configuration.setProperty(Environment.SHOW_SQL, true);
        configuration.addAnnotatedClass(Programmer.class);
        configuration.addAnnotatedClass(Laptop.class);
        return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
    }

    @Bean
    public EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }


}
