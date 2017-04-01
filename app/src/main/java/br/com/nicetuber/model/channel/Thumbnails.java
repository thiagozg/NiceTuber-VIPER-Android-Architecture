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
    private ImageUrl imageDefault;

    @SerializedName("medium")
    private ImageUrl imageMedium;

    @SerializedName("high")
    private ImageUrl imageHigh;

    public ImageUrl getImageDefault() {
        return imageDefault;
    }

    public void setImageDefault(ImageUrl imageDefault) {
        this.imageDefault = imageDefault;
    }

    public ImageUrl getImageMedium() {
        return imageMedium;
    }

    public void setImageMedium(ImageUrl imageMedium) {
        this.imageMedium = imageMedium;
    }

    public ImageUrl getImageHigh() {
        return imageHigh;
    }

    public void setImageHigh(ImageUrl imageHigh) {
        this.imageHigh = imageHigh;
    }
}
