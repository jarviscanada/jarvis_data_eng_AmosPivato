package ca.jrvs.apps.twitter.dao.helper;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import java.io.IOException;
import java.net.URI;

public class TwitterHttpHelper implements HttpHelper{
    /**
     * dependencies are specified as private member variables
     */
    private OAuthConsumer consumer;
    private HttpClient httpClient;
    private static final Logger logger = LoggerFactory.getLogger(TwitterHttpHelper.class);

    /**
     * constructor
     * setup dependecies using secrets
     * @param consumerKey
     * @param consumerSecret
     * @param accessToken
     * @param tokenSecret
     */
    public TwitterHttpHelper(String consumerKey, String consumerSecret, String accessToken, String tokenSecret){
        consumer = new CommonsHttpOAuthConsumer(consumerKey, consumerSecret);
        consumer.setTokenWithSecret(accessToken, tokenSecret);
        /**
         *default = single connection.
         */
        httpClient = new DefaultHttpClient();
    }

    @Override
    public HttpResponse httpPost(URI uri){
        try {
            return executeHttpRequest(HttpMethod.POST, uri, null); //change later for string entity
        } catch (OAuthException | IOException e) {
            throw new RuntimeException("failed to execute",e);
        }
    }

    @Override
    public HttpResponse httpGet(URI uri) {
        try {
            return executeHttpRequest(HttpMethod.GET, uri, null);
        } catch (OAuthException | IOException e) {
            throw new RuntimeException("failed to execute",e);
        }
    }

    private HttpResponse executeHttpRequest(HttpMethod method, URI uri, StringEntity stringEntity) throws OAuthException, IOException {
        if (method == HttpMethod.GET) {
            HttpGet request = new HttpGet(uri);
            consumer.sign(request);
            return httpClient.execute(request);
        }
        else if (method == HttpMethod.POST) {
            HttpPost request = new HttpPost(uri);
            if (stringEntity != null){
                request.setEntity(stringEntity);
            }
            consumer.sign(request);
            return httpClient.execute(request);
        }
        else {
            throw new IllegalArgumentException("unknown Http method: " + method.name());
        }
    }
//consumerKey=XLY9vAElirQuUYTbG6R0uFkSd;consumerSecret=5cVHnD2CjE1SKijFIfpqK8Q3CJV8yJkpwCl4ggGBq4eoE1h8ad;accessToken=1531317516152315906-J9YVBIZ7cjMzkSTSGv73QKdDdev7mt;tokenSecret=ppRmvj72rYGOesZk7sAfISaOqJRLv4OP3a91kEVeDhQ9g
    public static void main(String[] args) throws Exception{
        String consumerKey = System.getenv("consumerKey");
        String consumerSecret = System.getenv("consumerSecret");
        String accessToken = System.getenv("accessToken");
        String tokenSecret = System.getenv("tokenSecret");
        logger.info(consumerKey+"|"+ consumerSecret +"|"+ accessToken +"|"+ tokenSecret);
        HttpHelper httpHelper = new TwitterHttpHelper(consumerKey, consumerSecret, accessToken, tokenSecret);
        HttpResponse response = httpHelper.httpPost(new URI("https://api.twitter.com//1.1/statuses/update.json?status=first_tweet2"));
        logger.info(EntityUtils.toString(response.getEntity()));
    }
}


