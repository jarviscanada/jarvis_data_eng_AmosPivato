package ca.jrvs.apps.twitter.controller;

import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.example.JsonParser;
import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.model.TweetUtil;
import ca.jrvs.apps.twitter.service.TwitterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.*;

public class TwitterControllerIntTest {

    private static final Logger logger = LoggerFactory.getLogger(TwitterHttpHelper.class);

    private TwitterController twitterController;

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
        TwitterService twitterService = new TwitterService(twitterDao);
        twitterController = new TwitterController(twitterService);
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
        String[] args = {"post", text, lat+":"+lon};
        logger.info(JsonParser.toJson(post, true, true));
        Tweet tweetOut = twitterController.postTweet(args);
        logger.info(JsonParser.toJson(tweetOut, true, true));

        logger.info("start of invalid args posttweet test");
        String[] args1 = {"post", text};
        try {
            Tweet tweetOut1 = twitterController.postTweet(args1);
        } catch (IllegalArgumentException e) {
            logger.info("exception 1 was thrown correctly");
        }
        String[] args2 = {"post", text, lat+":"};
        try {
            Tweet tweetOut2 = twitterController.postTweet(args2);
        } catch (IllegalArgumentException e) {
            logger.info("exception 2 was thrown correctly");
        }
        String[] args3 = {"post", text, "fifty:twenty"};
        try {
            Tweet tweetOut3 = twitterController.postTweet(args3);
        } catch (IllegalArgumentException e) {
            logger.info("exception 3 was thrown correctly");
        }

        //delete new tweet after testing
        String[] args4 = {"delete", tweetOut.getId_str()};
        List<Tweet> dels = twitterController.deleteTweet(args4);
    }

    @Test
    public void showTweet() throws JsonProcessingException {
        logger.info("start of showtweet successful method test");
        String text = "@3picAmos hello #abc 1655923111688";
        String hashTag = "#abc";
        double lon = -1d;
        double lat = 1d;
        String fields = "created_at,id,id_str,text,entities,coordinates,retweet_count,favorite_count,favorited,retweeted";
        String[] args = {"show","1539679251103875075", fields};
        Tweet tweet = twitterController.showTweet(args);
        logger.info(JsonParser.toJson(tweet, true, true));

        assertEquals(text, tweet.getText());
        Coordinates coordinates = tweet.getCoordinates();
        assertNotNull(coordinates);
        assertEquals(2, coordinates.getCoordinates().length);
        assertEquals(lon, coordinates.getCoordinates()[0], 0.000001d);
        assertEquals(lat, coordinates.getCoordinates()[1], 0.000001d);
        assertTrue(hashTag.contains(tweet.getEntities().getHashtags()[0].getText()));

        String[] args1 = {"show","1539679251103875075", "id_str,text"};
        tweet = twitterController.showTweet(args1);
        logger.info(JsonParser.toJson(tweet, true, true));

        logger.info("start of showtweet invalid args method test");
        String[] args2 = {"show","1539679251103875075"};
        try {
            tweet = twitterController.showTweet(args2);
        } catch (IllegalArgumentException e) {
            logger.info("exception 1 properly thrown");
        }
        String[] args3 = {"show","1539679251103875075", "created_at,id,id_str,text,entities,coordinates,retweet_count,favorite_count,favorited,retweeted,bruh"};
        try {
            tweet = twitterController.showTweet(args3);
        } catch (IllegalArgumentException e) {
            logger.info("exception 2 properly thrown");
        }
        String[] args4 = {"show","1539679251103875075", "bruh,id,id_str,text,entities,coordinates,retweet_count,favorite_count,favorited,retweeted"};
        try {
            tweet = twitterController.showTweet(args4);
        } catch (IllegalArgumentException e) {
            logger.info("exception 3 properly thrown");
        }
    }

    @Test
    public void deleteTweet() {
        logger.info("start of deletetweets successful method test");
        //String[] args = {"delete" ,"1540426977051541507,1540431897737715714,1540433416692416512"};
        List<Tweet> tweet;

        //tweet = twitterController.deleteTweet(args);
        //logger.info(tweet.toString());

        logger.info("start of deletetweet invalid args method test");
        String[] args1 = {"delete"};
        try {
            tweet = twitterController.deleteTweet(args1);
        } catch (IllegalArgumentException e) {
            logger.info("exception 1 properly thrown");
        }
        String[] args2 = {"delete", ""};
        try {
            tweet = twitterController.deleteTweet(args2);
        } catch (IllegalArgumentException e) {
            logger.info("exception 2 properly thrown");
        }
    }
}