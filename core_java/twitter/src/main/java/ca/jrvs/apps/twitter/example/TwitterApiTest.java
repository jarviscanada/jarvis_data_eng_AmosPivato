package ca.jrvs.apps.twitter.example;

import com.google.gdata.util.common.base.PercentEscaper;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.Arrays;

public class TwitterApiTest {
    private static String CONSUMER_KEY = System.getenv("consumerKey");
    private static String CONSUMER_SECRET = System.getenv("consumerSecret");
    private static String ACCESS_TOKEN = System.getenv("accessToken");
    private static String TOKEN_SECRET = System.getenv("tokenSecret");

    public static void main(String[] args) throws Exception {
        //oauth set up
        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        consumer.setTokenWithSecret(ACCESS_TOKEN, TOKEN_SECRET);

        //create http get request
        String status = "Today is is a good day";
        //PercentEscaper percentEscaper = new PercentEscaper("", false);
        //HttpPost request = new HttpPost("https://api.twitter.com/1.1/statuses/update.json?status="+ percentEscaper.escape(status));
        HttpPost request = new HttpPost("https://api.twitter.com/1.1/statuses/destroy/1538933463809675265.json");

        //sign the request (adding headers encapsulating)
        consumer.sign(request);
        System.out.println("Https Request Headers:");
        Arrays.stream(request.getAllHeaders()).forEach(System.out::println);

        //send the request
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse response = httpClient.execute(request);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }
}
