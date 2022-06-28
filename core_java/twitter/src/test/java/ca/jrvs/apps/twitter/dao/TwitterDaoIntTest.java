package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.example.JsonParser;
import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.model.TweetUtil;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;
public class TwitterDaoIntTest {

    private static final Logger logger = LoggerFactory.getLogger(TwitterHttpHelper.class);

    private TwitterDao twitterDao;

    @Before
    public void setUp() throws Exception {
        logger.info("setting up test and Running test method");
        String consumerKey = System.getenv("consumerKey");
        String consumerSecret = System.getenv("consumerSecret");
        String accessToken = System.getenv("accessToken");
        String tokenSecret = System.getenv("tokenSecret");
        logger.info(consumerKey+" | "+ consumerSecret +" | "+ accessToken +" | "+ tokenSecret);
        TwitterHttpHelper twitterHttpHelper = new TwitterHttpHelper(consumerKey, consumerSecret, accessToken, tokenSecret);
        this.twitterDao = new TwitterDao(twitterHttpHelper);
    }

    @Test
    public void create() throws Exception{
        logger.info("start of create method test");
        //String hashTag = "#abc";
        //String text = "@3picAmos hello " + hashTag + " " + System.currentTimeMillis();
        String text = "hello friends"+ System.currentTimeMillis();
        double lon = -1d;
        double lat = 1d;
        Tweet post = TweetUtil.buildTweet(text, lon, lat);
        logger.info(JsonParser.toJson(post, true, true));

        Tweet tweetOut = twitterDao.create(post);

        assertEquals(text, tweetOut.getText());
        Coordinates coordinates = tweetOut.getCoordinates();
        assertNotNull(coordinates);
        assertEquals(2, coordinates.getCoordinates().length);
        assertEquals(lon, coordinates.getCoordinates()[0], 0.000001d);
        assertEquals(lat, coordinates.getCoordinates()[1], 0.000001d);
        //assertTrue(hashTag.contains(tweetOut.getEntities().getHashtags()[0].getText()));
        Tweet response = twitterDao.deleteById(tweetOut.getId_str()); //delete after to avoid incraesing tweets
    }

    @Test
    public void findById() {
        logger.info("start of find byid method test");
        String text = "@3picAmos hello #abc 1655923111688";
        String hashTag = "#abc";
        double lon = -1d;
        double lat = 1d;
        Tweet tweet = twitterDao.findById("1539679251103875075");

        assertEquals(text, tweet.getText());
        Coordinates coordinates = tweet.getCoordinates();
        assertNotNull(coordinates);
        assertEquals(2, coordinates.getCoordinates().length);
        assertEquals(lon, coordinates.getCoordinates()[0], 0.000001d);
        assertEquals(lat, coordinates.getCoordinates()[1], 0.000001d);
        assertTrue(hashTag.contains(tweet.getEntities().getHashtags()[0].getText()));
    }

    @Test
    public void deleteById() {
        logger.info("start of delete by id method test");
        //commented out because not needed and also tested in create test case
        //Tweet response = twitterDao.deleteById("1539672285342318595");
        //Tweet response1 = twitterDao.deleteById("1539675071614255104");
        //Tweet response2 = twitterDao.deleteById("1539678077218848769");
    }
}