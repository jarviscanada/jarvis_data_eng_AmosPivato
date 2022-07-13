package ca.jrvs.apps.trading;

import ca.jrvs.apps.trading.model.config.MarketDataConfig;
import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    private Logger logger = LoggerFactory.getLogger(AppConfig.class);

    private String jdbcUrl;
    private String user;
    private String password;

    @Bean
    public DataSource dataSource(){
        jdbcUrl = "jdbc:postgresql://" +
                System.getenv("PSQL_HOST") + ":" +
                System.getenv("PSQL_PORT") + ":" +
                "/" +
                System.getenv("PSQL_DB");
        user = System.getenv("PSQL_USER");
        password = System.getenv("PSQL_PASSWORD");

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(jdbcUrl);
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(password);
        return basicDataSource;
    }

    @Bean
    public MarketDataConfig marketDataConfig(){

    }
}
