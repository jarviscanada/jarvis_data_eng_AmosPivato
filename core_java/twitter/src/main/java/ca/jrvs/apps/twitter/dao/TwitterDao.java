package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.example.JsonParser;
import ca.jrvs.apps.twitter.model.Tweet;
import com.google.gdata.util.common.base.PercentEscaper;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Repository
public class TwitterDao implements CrdDao<Tweet, String>{

    private static final Logger logger = LoggerFactory.getLogger(TwitterHttpHelper.class);
    //uri constants
    private static final String API_BASE_URI = "https://api.twitter.com";
    private static final String POST_PATH = "/1.1/statuses/update.json";
    private static final String SHOW_PATH = "/1.1/statuses/show.json";
    private static final String DELETE_PATH = "/1.1/statuses/destroy";

    //URI sysmbols
    private static final String QUERY_SYM = "?";
    private static final String AMPERSAND = "&";
    private static final String EQUAL = "=";

    //response code
    private static final int HTTP_OK = 200;

    private HttpHelper httpHelper;

    @Autowired
    public TwitterDao(HttpHelper httpHelper) {
        this.httpHelper = httpHelper;
    }

    @Override
    public Tweet create(Tweet entity) {
        URI uri;
        try {
            uri = getPostUri(entity);
        } catch(URISyntaxException e){
            throw new IllegalArgumentException("Invalid tweet input", e);
        }
        HttpResponse response = httpHelper.httpPost(uri);
        return parseResponseBody(response, HTTP_OK);
    }

    @Override
    public Tweet findById(String id) {
        URI uri;
        try {
            uri = getShowUri(id);
        } catch(URISyntaxException e){
            throw new IllegalArgumentException("Invalid id input", e);
        }
        HttpResponse response = httpHelper.httpGet(uri);
        return parseResponseBody(response, HTTP_OK);
    }

    @Override
    public Tweet deleteById(String id) {
        URI uri;
        try {
            uri = getDeleteUri(id);
        } catch(URISyntaxException e){
            throw new IllegalArgumentException("Invalid id input", e);
        }
        HttpResponse response = httpHelper.httpPost(uri);
        return parseResponseBody(response, HTTP_OK);
    }

    Tweet parseResponseBody(HttpResponse response, Integer expectedStatusCode) {
        Tweet tweet = null;
        //check response
        int status = response.getStatusLine().getStatusCode();
        if (status != expectedStatusCode){
            try {
                logger.info(EntityUtils.toString(response.getEntity()));
            } catch (IOException e) {
                logger.error("response has no entity" + e);
            }
            throw new RuntimeException("unexpected HTTP status:" + status);
        }
        if (response.getEntity() == null) {
            throw new RuntimeException("empty response body");
        }

        //convert response to str
        String jsonStr;
        try{
            jsonStr = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
           throw new RuntimeException("failed to convert entity to string", e);
        }

        //deserialize json string to tweet object
        try{
            tweet = JsonParser.toObjectFromJson(jsonStr, Tweet.class);
        } catch (IOException e){
            throw new RuntimeException("unable to convert JSON str to objet", e);
        }
        return tweet;
    }

    private URI getPostUri(Tweet tweet) throws URISyntaxException {
        PercentEscaper percentEscaper = new PercentEscaper("", false);
        return new URI(API_BASE_URI+POST_PATH+QUERY_SYM+"status"+EQUAL+percentEscaper.escape(tweet.getText())+AMPERSAND+"lon="+tweet.getCoordinates().getCoordinates()[0]+AMPERSAND+"lat="+tweet.getCoordinates().getCoordinates()[1]);
    }

    private URI getShowUri(String id) throws URISyntaxException {
        return new URI(API_BASE_URI+SHOW_PATH+QUERY_SYM+"id"+EQUAL+id);
    }

    private URI getDeleteUri(String id) throws URISyntaxException {
        return new URI(API_BASE_URI+DELETE_PATH+"/"+id+".json");
    }


}
