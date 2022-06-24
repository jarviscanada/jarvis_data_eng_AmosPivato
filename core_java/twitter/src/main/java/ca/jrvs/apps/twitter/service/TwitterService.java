package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.model.Tweet;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwitterService implements Service{

    private CrdDao dao;

    public TwitterService(CrdDao dao){
        this.dao = dao;
    }

    @Override
    public Tweet postTweet(Tweet tweet) {
        validatePostTweet(tweet);
        return (Tweet) dao.create(tweet);
    }

    @Override
    public Tweet showTweet(String id, String[] fields) {
        Tweet response;
        Tweet tweet;
        if (validateId(id)){
            try {
                tweet = (Tweet) dao.findById(id);
            } catch (RuntimeException e) {
                throw new IllegalArgumentException("id provided does not exist");
            }
            response = validateShowTweet(tweet, fields);
        }
        else{
            throw new IllegalArgumentException("Id was not valid");
        }
        return response;
    }

    @Override
    public List<Tweet> deleteTweets(String[] ids) {
        validateDeleteTweets(ids);
        List<Tweet> tweets = new ArrayList<>();
        for (String id : ids){
            try {
                tweets.add((Tweet) dao.deleteById(id));
            }
            catch (RuntimeException e) {
                throw new IllegalArgumentException("id provided does not exist");
            }
        }
        return tweets;
    }

    private void validatePostTweet(Tweet tweet){
        if (tweet.getText().length() > 140){
            throw new IllegalArgumentException("Too many characters in tweet text, cannot exceed 140");
        }
        if (tweet.getCoordinates().getCoordinates()[0] > 180.0 || tweet.getCoordinates().getCoordinates()[0] < -180.0 ){
            throw new IllegalArgumentException("longitude is out of range, must be within -180 to 180");
        }
        if (tweet.getCoordinates().getCoordinates()[1] > 90.0 || tweet.getCoordinates().getCoordinates()[1] < -90.0 ){
            throw new IllegalArgumentException("latitude is out of range, must be within -90 to 90");
        }
    }

    private Tweet validateShowTweet(Tweet tweet, String[] fields){
        String[] expected = {"created_at","id", "id_str", "text", "entities", "coordinates", "retweet_count", "favorite_count", "favorited", "retweeted"};
        for (String field : expected) {
            if (!Arrays.stream(fields).anyMatch(str -> str.equals(field))) {
                switch (field){
                    case "created_at":
                        tweet.setCreated_at(null);
                        break;
                    case "id":
                        tweet.setId(null);
                        break;
                    case "id_str":
                        tweet.setId_str(null);
                        break;
                    case "text":
                        tweet.setText(null);
                        break;
                    case "entities":
                        tweet.setEntities(null);
                        break;
                    case "coordinates":
                        tweet.setCoordinates(null);
                        break;
                    case "retweet_count":
                        tweet.setRetweet_count(null);
                        break;
                    case "favorite_count":
                        tweet.setFavorite_count(null);
                        break;
                    case "favorited":
                        tweet.setFavorited(null);
                        break;
                    case "retweeted":
                        tweet.setRetweeted(null);
                        break;
                }
            }
        }
        return tweet;
    }

    private void validateDeleteTweets(String[] ids){
        for (String id : ids){
            if (!validateId(id)){
                throw new IllegalArgumentException("an invalid id was provided" + id);
            }
        }
    }

    private boolean validateId(String id){
        long num;
        if (StringUtils.isNumeric(id)) {
            try {
                num = Long.parseLong(id);
            } catch (NumberFormatException e) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
}
