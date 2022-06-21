package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
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
    public void create() {
        //need to implement tweet object constructor to build a tweet object from a text and the coordinates
        //ask quesitons tomorrow about stuff
    }

    @Test
    public void findById() {
    }

    @Test
    public void deleteById() {
    }
}