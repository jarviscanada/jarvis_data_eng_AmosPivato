package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Arrays;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Entities {

    private Hashtag[] hastags;

    private UserMention[] userMentions;

    public Hashtag[] getHastags() {
        return hastags;
    }

    public void setHastags(Hashtag[] hastags) {
        this.hastags = hastags;
    }

    public UserMention[] getUserMentions() {
        return userMentions;
    }

    public void setUserMentions(UserMention[] userMentions) {
        this.userMentions = userMentions;
    }

    @Override
    public String toString() {
        return "Entities{" +
                "hastags=" + Arrays.toString(hastags) +
                ", userMentions=" + Arrays.toString(userMentions) +
                '}';
    }
}
