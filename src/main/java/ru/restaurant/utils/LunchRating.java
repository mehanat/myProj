package ru.restaurant.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ru.restaurant.model.Lunch;

/**
 * Created by Анатолий on 21.05.2016.
 */
@JsonSerialize()
public class LunchRating {
    Lunch lunch;
    int votesCount;

    public LunchRating(Lunch lunch, int votesCount) {
        this.lunch = lunch;
        this.votesCount = votesCount;
    }

    @JsonProperty
    public Lunch getLunch() {
        return lunch;
    }

    public void setLunch(Lunch lunch) {
        this.lunch = lunch;
    }

    @JsonProperty
    public int getVotesCount() {
        return votesCount;
    }

    public void setVotesCount(int votesCount) {
        this.votesCount = votesCount;
    }
}
