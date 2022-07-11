package ca.jrvs.apps.trading.dao;

import ca.jrvs.apps.trading.model.config.MarketDataConfig;
import ca.jrvs.apps.trading.model.domain.IexQuote;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * MarketDataDao is responsible for getting quotes from IEX
 */
@Repository
public class MarketDataDao implements CrudRepository<IexQuote, String> {

    //private static final String IEX__BASE_PATH = "https://cloud.iexapis.com/stable";

    private static final String IEX_FIND_PATH = "/Stock/%s/quote?token=";
    private static final String IEX_BATCH_PATH = "/stock/market/batch?symbols=%s&types=quote&token=";

    private final String IEX_FIND_URL;
    private final String IEX_BATCH_URL;

    private Logger logger = LoggerFactory.getLogger(MarketDataDao.class);
    private HttpClientConnectionManager httpClientConnectionManager;

    public MarketDataDao(HttpClientConnectionManager httpClientConnectionManager, MarketDataConfig marketdataConfig){
        this.httpClientConnectionManager = httpClientConnectionManager;
        IEX_FIND_URL = marketdataConfig.getHost() + IEX_FIND_PATH + marketdataConfig.getToken();
        IEX_BATCH_URL = marketdataConfig.getHost() + IEX_BATCH_PATH + marketdataConfig.getToken();
    }

    /**
     * get an iexquote (helper method which class findallbyid)
     * @param ticker ticker
     * @return iexqupte object
     * @throws IllegalArgumentException if any ticker is invalid or tickers is empty
     * @throws org.springframework.dao.DataRetrievalFailureException is http request failed
     */
    @Override
    public Optional<IexQuote> findById(String ticker) {
        Optional<IexQuote> iexQuote;
        List<IexQuote> quotes = findAllById(Collections.singletonList(ticker));

        if (quotes.size() == 0){
            return Optional.empty();
        }
        else if (quotes.size() == 1){
            iexQuote = Optional.of(quotes.get(0));
        }
        else {
            throw new DataRetrievalFailureException("unexpected number of quotes");
        }
        return iexQuote;
    }

    /**
     * get quptes from IEX
     * @param iterable is a list of tickers
     * @return a list of exQuote object
     * @throws IllegalArgumentException if any ticker is invalid or tickers is empty
     * @throws org.springframework.dao.DataRetrievalFailureException is http request failed
     */
    @Override
    public List<IexQuote> findAllById(Iterable<String> iterable) {
//create uri
        if (iterable.length() == 0){
            throw new IllegalArgumentException("invalid ticker");
        }
        String uri = String.format(this.IEX_FIND_URL, s);

        //confirm ticker string is valid and
        //get http response
        String response;
        try {
            response = executeHttpGet(uri).orElseThrow(() -> new IllegalArgumentException("invalid ticker"));
        }
        catch (IllegalArgumentException e) {
            logger.error("invalid ticker" + e);
            return Optional.empty();
        }

        //deserialyze http response to IexQuote object
        JSONObject IexQuoteJson = new JSONObject(response);
        if (IexQuoteJson.length() == 0){

        }
        return null;
    }

    /**
     * execute a get and return the http entity/body as a string
     *
     * tip: use entityUtils.tostring to process http entity
     *
     * @param url resouce url
     * @return http response body or option.empty for 404 reponse
     * @throws org.springframework.dao.DataRetrievalFailureException if http failed or status code is unexpected
     */
    private Optional<String> executeHttpGet(String url){
        //setting up httpclient and executing the url
        HttpClient httpClient = getHttpClient();
        HttpGet request = new HttpGet(url);
        HttpResponse response;
        try {
            response = httpClient.execute(request);
        } catch (IOException e){
            logger.error("HttpClient failed", e);
            throw new DataRetrievalFailureException("HttpClient failed", e);
        }

        //parsing response body, first go through error checks
        int status = response.getStatusLine().getStatusCode();
        if (status == 404){
            logger.info("response status code 404, not found");
            return Optional.empty();
        }
        else if(status != 200){
            try {
                logger.info(EntityUtils.toString(response.getEntity()));
            } catch (IOException e){
                logger.error("Response has no entity" + e);
            }
            logger.error("Response status code is unexpected: " + status);
            throw new DataRetrievalFailureException("Response status code is unexpected: " + status);
        }
        if (response.getEntity() == null){
            logger.error("Empty response body");
            throw new DataRetrievalFailureException("Empty response body");
        }

        //checks completed, response should have entity body now
        String jsonStr;
        try {
            jsonStr = EntityUtils.toString(response.getEntity());
        } catch (IOException e){
            logger.error("failed to convert entity to string" + e);
            throw new DataRetrievalFailureException("failed to convert entity to string", e);
        }
        return Optional.ofNullable(jsonStr);
    }

    /**
     * borrow a http client from the httpclientconnectionmanager
     * @return a httpclient
     */
    private CloseableHttpClient getHttpClient(){
        return HttpClients.custom().setConnectionManager(httpClientConnectionManager).setConnectionManagerShared(true).build();
    }
}
