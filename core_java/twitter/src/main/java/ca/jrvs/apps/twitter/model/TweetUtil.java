package ca.jrvs.apps.twitter.model;

public class TweetUtil {

    public static Tweet buildTweet(String text, double lon, double lat) {
        Tweet tweet = new Tweet();
        double[] coordinates = {lon, lat};
        Coordinates coordinates1 = new Coordinates();
        coordinates1.setCoordinates(coordinates);
        tweet.setText(text);
        tweet.setCoordinates(coordinates1);
        return tweet;
    }
}
