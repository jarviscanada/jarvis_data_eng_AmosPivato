package ca.jrvs.apps.trading.dao;

import ca.jrvs.apps.trading.model.config.MarketDataConfig;
import ca.jrvs.apps.trading.model.domain.IexQuote;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * MarketDataDao is responsible for getting quotes from IEX
 */
@Repository
public class MarketDataDao implements CrudRepository<IexQuote, String> {

    private static final String IEX_BATCH_PATH = "/stock/market/batch?symbols=%s&types=quote&token=";
    private final String IEX_BATCH_URL;

    private Logger logger = LoggerFactory.getLogger(MarketDataDao.class);
    private HttpClientConnectionManager httpClientConnectionManager;

    public MarketDataDao(HttpClientConnectionManager httpClientConnectionManager, MarketDataConfig marketdataConfig){
        this.httpClientConnectionManager = httpClientConnectionManager;
        IEX_BATCH_URL = marketdataConfig.getHost() + IEX_BATCH_PATH + marketdataConfig.getToken();
    }

    /**
     * get an iexquote (helper method which class findallbyid)
     * @param s ticker
     * @return iexqupte object
     * @throws IllegalArgumentException if any ticker is invalid or tickers is empty
     * @throws org.springframework.dao.DataRetrievalFailureException is http request failed
     */
    @Override
    public Optional<IexQuote> findById(String s) {
        return Optional.empty();
    }

    /**
     * get quptes from IEX
     * @param iterable is a list of tickers
     * @return a list of exQuote object
     * @throws IllegalArgumentException if any ticker is invalid or tickers is empty
     * @throws org.springframework.dao.DataRetrievalFailureException is http request failed
     */
    @Override
    public Iterable<IexQuote> findAllById(Iterable<String> iterable) {
        return null;
    }

    /**
     * execute a get and return the http entity/body as a string
     *
     * tip: use entityUtils.stostring to process http entity
     *
     * @param url resouce url
     * @return http response boy or option.empty for 404 reponse
     * @throws org.springframework.dao.DataRetrievalFailureException if http failed or status code is unexpected
     */
    private Optional<String> executeHttpGet(String url){

    }

    /**
     * borrow a http client from the httpclientconnectionmanager
     * @return a httpclient
     */
    private CloseableHttpClient getHttpClient(){
        return HttpClients.custom().setConnectionManager(httpClientConnectionManager).setConnectionManagerShared(true).build();
    }
}
