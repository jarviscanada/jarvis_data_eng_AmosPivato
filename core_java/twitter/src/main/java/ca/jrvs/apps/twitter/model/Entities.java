package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Entities {

    private Hashtag[] hashtags;

    private UserMention[] userMentions;

    public Hashtag[] getHashtags() {
        return hashtags;
    }

    public void setHashtags(Hashtag[] hashtags) {
        this.hashtags = hashtags;
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
                "hastags=" + Arrays.toString(hashtags) +
                ", userMentions=" + Arrays.toString(userMentions) +
                '}';
    }
}
