package ca.jrvs.apps.twitter.controller;

import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.model.TweetUtil;
import ca.jrvs.apps.twitter.service.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class TwitterController implements Controller{

    private static final String COORD_SEP = ":";
    private static final String COMMA = ",";

    private Service service;

    public TwitterController(Service service) {
        this.service = service;
    }

    @Override
    public Tweet postTweet(String[] args) {
        if (args.length != 3){
            throw new IllegalArgumentException("USAGE: TwitterCLIApp post \"tweet_text\" \"latitude:longitude\"");
        }
        String tweetText = args[1];
        String[] coords = args[2].split(COORD_SEP);
        if (coords.length !=2 || StringUtils.isEmpty(tweetText)) {
            throw new IllegalArgumentException("USAGE: TwitterCLIApp post \"tweet_text\" \"latitude:longitude\"");
        }
        Double lat = null;
        Double lon = null;
        try {
            lat = Double.parseDouble(coords[0]);
            lon = Double.parseDouble(coords[1]);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Invalid location format\n USAGE: TwitterCLIApp post \"tweet_text\" \"latitude:longitude\"", e);
        }

        Tweet tweet = TweetUtil.buildTweet(tweetText, lon, lat);
        Tweet response = service.postTweet(tweet);
        return response;
    }

    @Override
    public Tweet showTweet(String[] args) {
        if (args.length > 3 || args.length < 2){
            throw new IllegalArgumentException("USAGE: TwitterCLIApp show \"tweet_id\" \"[field1,field2...]\"");
        }

        String id = args[1];
        String[] expected = {"created_at", "id", "id_str", "text", "entities", "coordinates", "retweet_count", "favorite_count", "favorited", "retweeted"};
        String[] fields;
        if (args.length == 3) {
            fields = args[2].split(COMMA);
            if (fields.length > 10 || StringUtils.isEmpty(id)) {
                throw new IllegalArgumentException("USAGE: TwitterCLIApp show \"tweet_id\" \"[field1,field2...]\"");
            }
        }
        else {
            fields = expected;
        }
        List<String> expectedList = Arrays.asList(expected);
        if (!Arrays.stream(fields).anyMatch(f -> expectedList.contains(f))){
            throw new IllegalArgumentException("Invalid field included, USAGE: TwitterCLIApp show \"tweet_id\" \"[field1,field2...]\" \nfields: created_at\",\"id\", \"id_str\", \"text\", \"entities\", \"coordinates\", \"retweet_count\", \"favorite_count\", \"favorited\", \"retweeted\"");
        }

        Tweet response = service.showTweet(id, fields);
        return response;
    }

    @Override
    public List<Tweet> deleteTweet(String[] args) {
        if (args.length != 2){
            throw new IllegalArgumentException("USAGE: TwitterCLIApp delete \"[id1,id2...]\"");
        }

        String[] ids = args[1].split(COMMA);
        if (ids.length == 0) {
            throw new IllegalArgumentException("USAGE: TwitterCLIApp delete \"[id1,id2...]\"");
        }

        List<Tweet> response = service.deleteTweets(ids);
        return response;
    }
}
