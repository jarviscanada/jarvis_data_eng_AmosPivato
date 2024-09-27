package ca.jrvs.apps.twitter.controller;

import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.TwitterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TwitterControllerUnitTest {

    @Mock
    TwitterService service;

    @InjectMocks
    TwitterController controller;

    @Test
    public void postTweet() {
        when(service.postTweet(any())).thenReturn(new Tweet());
        String[] args = {"post", "text", "1:1"};
        controller.postTweet(args);
    }

    @Test
    public void showTweet() {
        when(service.showTweet(any(), any())).thenReturn(new Tweet());
        String[] args = {"show", "1539679251103875075", "id,text"};
        controller.showTweet(args);
    }

    @Test
    public void deleteTweet() {
        when(service.deleteTweets(any())).thenReturn(new ArrayList<Tweet>());
        String[] args = {"delete", "1539679251103875075"};
        controller.deleteTweet(args);
    }
}