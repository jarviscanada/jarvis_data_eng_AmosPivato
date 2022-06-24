package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.controller.Controller;
import ca.jrvs.apps.twitter.controller.TwitterController;
import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.example.JsonParser;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.TwitterService;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public class TwitterCLIApp {

    private Controller controller;

    public TwitterCLIApp(Controller controller) {
        this.controller = controller;
    }

    public void run(String[] args){

        switch (args[0]){
            case "post":
                Tweet response = controller.postTweet(args);
                printTweet(response, true);
                break;
            case "show":
                Tweet show = controller.showTweet(args);
                if (args.length == 3){
                    printTweet(show, false);
                }
                else if (args.length == 2){
                    printTweet(show, true);
                }

                break;
            case "delete":
                List<Tweet> responses = controller.deleteTweet(args);
                responses.stream().forEach(x -> printTweet(x, true));
                break;
            default:
                throw  new IllegalArgumentException("USAGE TwitterCLIApp post|show|delete [options]");
        }
    }

    public static void main(String[] args) {
        String CONSUMER_KEY = System.getenv("consumerKey");
        String CONSUMER_SECRET = System.getenv("consumerSecret");
        String ACCESS_TOKEN = System.getenv("accessToken");
        String TOKEN_SECRET = System.getenv("tokenSecret");
        TwitterHttpHelper helper = new TwitterHttpHelper(CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN, TOKEN_SECRET);
        TwitterDao dao = new TwitterDao(helper);
        TwitterService service = new TwitterService(dao);
        TwitterController controller = new TwitterController(service);
        TwitterCLIApp app = new TwitterCLIApp(controller);
        try {
            app.run(args);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }
    public void printTweet(Tweet tweet, boolean incNull){
        try {
            System.out.println(JsonParser.toJson(tweet,true, incNull));
        } catch (JsonProcessingException e){
            throw new RuntimeException("unable to convert tweet to object string", e);
        }
    }
}
//1539679251103875075
