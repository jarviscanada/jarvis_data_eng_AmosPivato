package ca.jrvs.apps.twitter.dao.helper;

import com.google.gdata.util.common.base.PercentEscaper;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

import static org.junit.Assert.*;

public class TwitterHttpHelperUnitTest {
    private static final Logger logger = LoggerFactory.getLogger(TwitterHttpHelper.class);

    @BeforeClass
    public static void classSetUp() throws Exception {
        logger.info("setup step, Class is instantiated");
    }

    @AfterClass
    public static void ClassTearDown() throws Exception {
        logger.info("Tear down step, Class is no longer being used, unittest complete");
    }

    private TwitterHttpHelper twitterHttpHelper;

    @Before
    public void setUp() throws Exception {
        logger.info("setting up test and Running test method");
        String consumerKey = System.getenv("consumerKey");
        String consumerSecret = System.getenv("consumerSecret");
        String accessToken = System.getenv("accessToken");
        String tokenSecret = System.getenv("tokenSecret");
        logger.info(consumerKey+" | "+ consumerSecret +" | "+ accessToken +" | "+ tokenSecret);
        twitterHttpHelper = new TwitterHttpHelper(consumerKey, consumerSecret, accessToken, tokenSecret);
    }

    @After
    public void tearDown() throws Exception {
        logger.info("test method finished");
    }

    @Test
    public void httpPost() throws Exception {
        logger.info("testing sending a tweet");
        String status = "new tweet who dis?" + System.currentTimeMillis();
        PercentEscaper percentEscaper = new PercentEscaper("", false);
        HttpResponse response = twitterHttpHelper.httpPost(new URI("https://api.twitter.com/1.1/statuses/update.json?status="+percentEscaper.escape(status)));
        logger.info(EntityUtils.toString(response.getEntity()));
        //can test delete in there as well but could cause issues cuz how do i retrieve tweet id yet
    }

    @Test
    public void httpGet() throws Exception{
        logger.info("testing retrieving tweets");
        HttpResponse response = twitterHttpHelper.httpGet(new URI("https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=PivatoAmos"));
        logger.info(EntityUtils.toString(response.getEntity()));
    }
}