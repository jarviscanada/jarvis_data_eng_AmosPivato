package ca.jrvs.apps.twitter.dao;


import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.example.JsonParser;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.model.TweetUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TwitterDaoUnitTest {

    @Mock
    TwitterHttpHelper mockHelper;

    @InjectMocks
    TwitterDao dao;

    @Test
    public void create() throws IOException {
        //to test a failed request
        String hashTag = "#abc";
        String text = "@3picAmos hello " + hashTag + " " + System.currentTimeMillis();
        double lon = -1d;
        double lat = 1d;
        when(mockHelper.httpPost(isNotNull())).thenThrow(new RuntimeException("mock"));
        try {
            dao.create(TweetUtil.buildTweet(text, lon, lat));
            fail();
        } catch (RuntimeException e) {
            assertTrue(true);
        }

        //test success without using parse Response body, so we use spydao instead to get return value
        String tweetJsonStr = "{\n"
                + "\"created_at\":\"Mon Feb 18 21:24:39 +0000 2019\",\n"
                + "\"id\":1097607853932564480,\n"
                + "\"id_str\":\"1097607853932564480\",\n"
                + "\"text\":\"test with loc223\",\n"
                + "\"entities\":{\n"
                + " \"hashtags\":[],"
                + " \"user_mentions\":[]"
                + "},\n"
                + "\"coordinates\":null,"
                + "\"retweet_count\":0,\n"
                + "\"favorite_count\":0,\n"
                + "\"favorited\":false,\n"
                + "\"retweeted\":false\n"
                + "}";

        when(mockHelper.httpPost(isNotNull())).thenReturn(null);
        TwitterDao spyDao = Mockito.spy(dao);
        Tweet expectedTweet = JsonParser.toObjectFromJson(tweetJsonStr, Tweet.class);
        //mock parse response body
        doReturn(expectedTweet).when(spyDao).parseResponseBody(any(), anyInt());
        Tweet tweet = spyDao.create(TweetUtil.buildTweet(text, lon, lat));
        assertNotNull(tweet);
        assertNotNull(tweet.getText());
    }

    @Test
    public void findById() throws IOException {
        String hashTag = "#abc";
        String text = "@3picAmos hello " + hashTag + " " + System.currentTimeMillis();
        double lon = -1d;
        double lat = 1d;
        when(mockHelper.httpGet(isNotNull())).thenThrow(new RuntimeException("mock"));
        try {
            dao.findById("1097607853932564480");
            fail();
        } catch (RuntimeException e) {
            assertTrue(true);
        }

        //test success without using parse Response body, so we use spydao instead to get return value
        String tweetJsonStr = "{\n"
                + "\"created_at\":\"Mon Feb 18 21:24:39 +0000 2019\",\n"
                + "\"id\":1097607853932564480,\n"
                + "\"id_str\":\"1097607853932564480\",\n"
                + "\"text\":\"test with loc223\",\n"
                + "\"entities\":{\n"
                + " \"hashtags\":[],"
                + " \"user_mentions\":[]"
                + "},\n"
                + "\"coordinates\":null,"
                + "\"retweet_count\":0,\n"
                + "\"favorite_count\":0,\n"
                + "\"favorited\":false,\n"
                + "\"retweeted\":false\n"
                + "}";

        when(mockHelper.httpGet(isNotNull())).thenReturn(null);
        TwitterDao spyDao = Mockito.spy(dao);
        Tweet expectedTweet = JsonParser.toObjectFromJson(tweetJsonStr, Tweet.class);
        //mock parse response body
        doReturn(expectedTweet).when(spyDao).parseResponseBody(any(), anyInt());
        Tweet tweet = spyDao.findById("1097607853932564480");
        assertNotNull(tweet);
        assertNotNull(tweet.getText());
    }

    @Test
    public void deleteById() throws IOException {
                when(mockHelper.httpPost(isNotNull())).thenThrow(new RuntimeException("mock"));
        try {
            dao.deleteById("1097607853932564480");
            fail();
        } catch (RuntimeException e) {
            assertTrue(true);
        }

        //test success without using parse Response body, so we use spydao instead to get return value
        String tweetJsonStr = "{\n"
                + "\"created_at\":\"Mon Feb 18 21:24:39 +0000 2019\",\n"
                + "\"id\":1097607853932564480,\n"
                + "\"id_str\":\"1097607853932564480\",\n"
                + "\"text\":\"test with loc223\",\n"
                + "\"entities\":{\n"
                + " \"hashtags\":[],"
                + " \"user_mentions\":[]"
                + "},\n"
                + "\"coordinates\":null,"
                + "\"retweet_count\":0,\n"
                + "\"favorite_count\":0,\n"
                + "\"favorited\":false,\n"
                + "\"retweeted\":false\n"
                + "}";

        when(mockHelper.httpPost(isNotNull())).thenReturn(null);
        TwitterDao spyDao = Mockito.spy(dao);
        Tweet expectedTweet = JsonParser.toObjectFromJson(tweetJsonStr, Tweet.class);
        //mock parse response body
        doReturn(expectedTweet).when(spyDao).parseResponseBody(any(), anyInt());
        Tweet tweet = spyDao.deleteById("1097607853932564480");
        assertNotNull(tweet);
        assertNotNull(tweet.getText());
    }
}