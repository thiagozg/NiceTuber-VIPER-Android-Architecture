package br.com.nicetuber.model.channel;

import com.google.gson.annotations.SerializedName;

/**
 * Developed by.:   @thiagozg on 01/04/2017.
 * E-mail.:         thiagozg1995@gmail.com
 * GitHub.:         https://github.com/thiagozg/
 * Google Play.:    https://play.google.com/store/apps/developer?id=Thiago+Giacomini
 */
public class Thumbnails {

    @SerializedName("default")
    private ChannelImage imageDefault;

    @SerializedName("medium")
    private ChannelImage imageMedium;

    @SerializedName("high")
    private ChannelImage imageHigh;

    public ChannelImage getImageDefault() {
        return imageDefault;
    }

    public void setImageDefault(ChannelImage imageDefault) {
        this.imageDefault = imageDefault;
    }

    public ChannelImage getImageMedium() {
        return imageMedium;
    }

    public void setImageMedium(ChannelImage imageMedium) {
        this.imageMedium = imageMedium;
    }

    public ChannelImage getImageHigh() {
        return imageHigh;
    }

    public void setImageHigh(ChannelImage imageHigh) {
        this.imageHigh = imageHigh;
    }
}
