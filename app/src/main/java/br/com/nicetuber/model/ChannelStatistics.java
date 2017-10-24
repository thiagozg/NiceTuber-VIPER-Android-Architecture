package br.com.nicetuber.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by thiagozg on 23/10/2017.
 */

public class ChannelStatistics {

    @SerializedName("viewCount")
    private String viewCount;

    @SerializedName("commentCount")
    private String commentCount;

    @SerializedName("subscriberCount")
    private String subscriberCount;

    @SerializedName("hiddenSubscriberCount")
    private boolean hiddenSubscriberCount;

    @SerializedName("videoCount")
    private String videoCount;

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public String getSubscriberCount() {
        return subscriberCount;
    }

    public void setSubscriberCount(String subscriberCount) {
        this.subscriberCount = subscriberCount;
    }

    public boolean isHiddenSubscriberCount() {
        return hiddenSubscriberCount;
    }

    public void setHiddenSubscriberCount(boolean hiddenSubscriberCount) {
        this.hiddenSubscriberCount = hiddenSubscriberCount;
    }

    public String getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(String videoCount) {
        this.videoCount = videoCount;
    }
}
