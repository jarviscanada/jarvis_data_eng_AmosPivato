package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Arrays;
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserMention {

    private String name;

    private int[] indices;

    private String screen_name;

    private long id;

    private String id_str;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getIndices() {
        return indices;
    }

    public void setIndices(int[] indices) {
        this.indices = indices;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getId_str() {
        return id_str;
    }

    public void setId_str(String id_str) {
        this.id_str = id_str;
    }

    @Override
    public String toString() {
        return "UserMention{" +
                "name='" + name + '\'' +
                ", indices=" + Arrays.toString(indices) +
                ", screen_name='" + screen_name + '\'' +
                ", id=" + id +
                ", id_str='" + id_str + '\'' +
                '}';
    }
}
