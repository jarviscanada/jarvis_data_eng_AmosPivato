package ca.jrvs.apps.trading;

import ca.jrvs.apps.trading.controller.QuoteController;
import ca.jrvs.apps.trading.dao.MarketDataDao;
//import ca.jrvs.apps.trading.dao.QuoteDao;
import ca.jrvs.apps.trading.model.config.MarketDataConfig;
import ca.jrvs.apps.trading.service.QuoteService;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"ca.jrvs.apps.trading.dao", "ca.jrvs.apps.trading.service"})
public class TestConfig {

    private Logger logger = LoggerFactory.getLogger(AppConfig.class);

    private String jdbcUrl;
    private String user;
    private String password;

    @Bean
    public DataSource dataSource(){
        jdbcUrl = "jdbc:postgresql://" +
                System.getenv("PSQL_HOST") + ":" +
                System.getenv("PSQL_PORT") +
                "/" +
                System.getenv("PSQL_DB");
        user = System.getenv("PSQL_USER");
        password = System.getenv("PSQL_PASSWORD");

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(jdbcUrl);
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(password);

        basicDataSource.setDriverClassName("org.postgresql.Driver");
        return basicDataSource;
    }

    @Bean
    public MarketDataConfig marketDataConfig(){
        String host = "https://cloud.iexapis.com/stable";
        String token = System.getenv("IEX_PUB_TOKEN");
        MarketDataConfig marketDataConfig = new MarketDataConfig();
        marketDataConfig.setHost(host);
        marketDataConfig.setToken(token);
        return marketDataConfig;
    }

    @Bean
    public HttpClientConnectionManager httpClientConnectionManager(){
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(50);
        cm.setDefaultMaxPerRoute(50);
        return cm;
    }

//    @Bean
//    public MarketDataDao marketDataDao(HttpClientConnectionManager httpClientConnectionManager, MarketDataConfig marketDataConfig){
//        return new MarketDataDao(httpClientConnectionManager, marketDataConfig);
//    }
//
//    @Bean
//    public QuoteDao quoteDao(DataSource dataSource){
//        return new QuoteDao(dataSource);
//    }
//
//    @Bean
//    public QuoteService quoteService(QuoteDao quoteDao, MarketDataDao marketDataDao){
//        return new QuoteService(quoteDao, marketDataDao);
//    }
//
//    @Bean
//    public QuoteController quoteController(QuoteService quoteService){
//        return new QuoteController(quoteService);
//    }
}
