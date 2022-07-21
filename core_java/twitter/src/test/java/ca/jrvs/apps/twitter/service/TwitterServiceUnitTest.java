package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.model.TweetUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TwitterServiceUnitTest {

    @Mock
    TwitterDao dao;

    @InjectMocks
    TwitterService service;

    @Test
    public void postTweet() {
        when(dao.create(any())).thenReturn(new Tweet());
        service.postTweet(TweetUtil.buildTweet("test", 50.0, 0.0));
    }

    @Test
    public void showTweet() {
        when(dao.findById(any())).thenReturn(new Tweet());
        String[] expected = {"created_at","id", "id_str", "text", "entities", "coordinates", "retweet_count", "favorite_count", "favorited", "retweeted"};
        service.showTweet("1539679251103875075", expected);
    }

    @Test
    public void deleteTweets() {
        when(dao.deleteById(any())).thenReturn(new Tweet());
        String[] id = {"1539672285342318595"};
        service.deleteTweets(id);
    }
}