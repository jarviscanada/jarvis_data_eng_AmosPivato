package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.example.JsonParser;
import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.model.TweetUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class TwitterServiceIntTest {

    private static final Logger logger = LoggerFactory.getLogger(TwitterHttpHelper.class);

    private TwitterService twitterService;

    @Before
    public void setUp() throws Exception {
        logger.info("setting up test and Running test method");
        String consumerKey = System.getenv("consumerKey");
        String consumerSecret = System.getenv("consumerSecret");
        String accessToken = System.getenv("accessToken");
        String tokenSecret = System.getenv("tokenSecret");
        logger.info(consumerKey+" | "+ consumerSecret +" | "+ accessToken +" | "+ tokenSecret);
        TwitterHttpHelper twitterHttpHelper = new TwitterHttpHelper(consumerKey, consumerSecret, accessToken, tokenSecret);
        TwitterDao twitterDao = new TwitterDao(twitterHttpHelper);
        twitterService = new TwitterService(twitterDao);
    }

    @After
    public void tearDown() throws Exception {
        logger.info("test completed moving on to next test");
    }

    @Test
    public void postTweet() throws JsonProcessingException {
        logger.info("start of succesful posttweet test");
        String hashTag = "#abc";
        String text = "@3picAmos hello " + hashTag + " " + System.currentTimeMillis();
        double lon = -1d;
        double lat = 1d;
        Tweet post = TweetUtil.buildTweet(text, lon, lat);
        logger.info(JsonParser.toJson(post, true, true));
        Tweet tweetOut = twitterService.postTweet(post);


        logger.info("start of unsccesful posttweet test");
        String text1 = "@3picAmos hello this tweet is too long and shouldnt be able to be posted as the maximum amount of caracters allowed in a tweet is about 140 charstaers and this one is of about 200" + hashTag + " " + System.currentTimeMillis();
        Tweet post1 = TweetUtil.buildTweet(text1, lon, lat);
        logger.info(JsonParser.toJson(post1, true, true));
        try {
            Tweet tweetOut1 = twitterService.postTweet(post1);
        } catch (IllegalArgumentException e) {
            logger.info("exception was thrown correctly");
        }
        double lon1 = -200d;
        double lat1 = 100d;
        Tweet post2 = TweetUtil.buildTweet(text, lon1, lat1);
        logger.info(JsonParser.toJson(post2, true, true));
        try {
            Tweet tweetOut2 = twitterService.postTweet(post2);
        } catch (IllegalArgumentException e){
            logger.info("exception was thrown correctly");
        }


    }

    @Test
    public void showTweet() throws JsonProcessingException {
        logger.info("start of showtweet successful method test");
        String text = "@3picAmos hello #abc 1655923111688";
        String hashTag = "#abc";
        double lon = -1d;
        double lat = 1d;
        String[] fields = {"created_at","id", "id_str", "text", "entities", "coordinates", "retweet_count", "favorite_count", "favorited", "retweeted"};
        Tweet tweet = twitterService.showTweet("1539679251103875075", fields);
        logger.info(JsonParser.toJson(tweet, true, true));

        assertEquals(text, tweet.getText());
        Coordinates coordinates = tweet.getCoordinates();
        assertNotNull(coordinates);
        assertEquals(2, coordinates.getCoordinates().length);
        assertEquals(lon, coordinates.getCoordinates()[0], 0.000001d);
        assertEquals(lat, coordinates.getCoordinates()[1], 0.000001d);
        assertTrue(hashTag.contains(tweet.getEntities().getHashtags()[0].getText()));

        String[] fields1 = {"id_str", "text", };
        tweet = twitterService.showTweet("1539679251103875075", fields1);
        logger.info(JsonParser.toJson(tweet, true, true));

        logger.info("start of showtweet invalid id method test");
        try {
            tweet = twitterService.showTweet("PivatoAmos", fields);
        } catch (IllegalArgumentException e) {
            logger.info("exception properly thrown");
        }
        try {
            tweet = twitterService.showTweet("21123", fields);
        } catch (IllegalArgumentException e) {
            logger.info("exception properly thrown");
        }
        try {
            tweet = twitterService.showTweet("1539672285342318595", fields);
        } catch (IllegalArgumentException e) {
            logger.info("exception properly thrown");
        }
    }

    @Test
    public void deleteTweets() {

    }
}